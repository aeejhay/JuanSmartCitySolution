/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.juansmartcitysolution;

/**
 *
 * @author ajand
 */

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;
import generated.grpc.juantamad.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class JuanTamadClient {
    private final JuanTamadGrpc.JuanTamadBlockingStub blockingStub;
    private final JuanTamadGrpc.JuanTamadStub asyncStub;

    public JuanTamadClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        blockingStub = JuanTamadGrpc.newBlockingStub(channel);
        asyncStub = JuanTamadGrpc.newStub(channel);
    }

    public void checkTraffic() {
        System.out.println("🚦 Checking Traffic...");
        Location location = Location.newBuilder().setCity("Makati").setStreet("Ayala Ave").build();
        TrafficCondition response = blockingStub.checkTrafficStatus(location);
        System.out.println("🚗 Traffic: " + response.getCongestionLevel() + " | Advice: " + response.getSuggestion());
    }

    public void getLiveTrafficUpdates() {
        System.out.println("📡 Live Traffic Updates Started...");
        Location location = Location.newBuilder().setCity("Quezon City").setStreet("EDSA").build();
        asyncStub.liveTrafficReports(location, new StreamObserver<TrafficUpdate>() {
            @Override
            public void onNext(TrafficUpdate update) {
                System.out.println("🛑 Update: " + update.getStatus() + " at " + update.getLocation());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("✅ Traffic updates completed.");
            }
        });
    }

    public void reportTrafficData() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<UserInput> requestObserver = asyncStub.crowdsourcedTrafficData(new StreamObserver<CityTrafficAnalysis>() {
            @Override
            public void onNext(CityTrafficAnalysis analysis) {
                System.out.println("📊 Traffic Report: " + analysis.getReportSummary());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("✅ Traffic data submitted.");
                latch.countDown();
            }
        });

        requestObserver.onNext(UserInput.newBuilder().setUsername("User123").setTrafficCondition("Heavy").build());
        requestObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
    }

    public static void main(String[] args) throws InterruptedException {
        JuanTamadClient client = new JuanTamadClient();
        client.checkTraffic();
        client.getLiveTrafficUpdates();
        client.reportTrafficData();
    }
}

