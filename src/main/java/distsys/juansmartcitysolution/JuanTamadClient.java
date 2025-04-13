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

import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;


public class JuanTamadClient {
    private final JuanTamadGrpc.JuanTamadBlockingStub blockingStub;
    private final JuanTamadGrpc.JuanTamadStub asyncStub;

    public JuanTamadClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        
        // Create metadata with the API key / authentication
        Metadata metadata = new Metadata();
        Metadata.Key<String> apiKeyHeader = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(apiKeyHeader, "BN7O1MMUMnVkXpSampleKeyOnlyForThiSProjeCTNiGOE9yMXnQRkZqAtm");

        // Attach metadata to the stub
        blockingStub = MetadataUtils.attachHeaders(JuanTamadGrpc.newBlockingStub(channel), metadata);       
        asyncStub = MetadataUtils.attachHeaders(JuanTamadGrpc.newStub(channel), metadata);
    }
    
    //Check traffic method (unary type of request) client request once and server response once
    public void checkTraffic() {
        System.out.println("Checking Traffic...");
        Location location = Location.newBuilder().setCity("Makati").setStreet("Ayala Ave").build();
        TrafficCondition response = blockingStub.checkTrafficStatus(location);
        System.out.println("Traffic: " + response.getCongestionLevel() + " | Advice: " + response.getSuggestion());
        System.out.println("-------------------------------------------------");
    }
    
    //Get the live traffic updates method request it once and server will response multiple (server streaming)
    public void getLiveTrafficUpdates() throws InterruptedException {
        System.out.println("Live Traffic Updates Started...");
        
        //need to wait to keep client alive and until the server sends all the message and complete
        CountDownLatch latch = new CountDownLatch(1);

        Location location = Location.newBuilder()
                .setCity("Quezon City")
                .setStreet("EDSA")
                .build();
        asyncStub.liveTrafficReports(location, new StreamObserver<TrafficUpdate>() {
            @Override
            public void onNext(TrafficUpdate update) {
                System.out.println("Update: " + update.getStatus() + " at " + update.getLocation());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
                latch.countDown();
            }

            @Override
            public void onCompleted() {
                System.out.println("Traffic updates completed.");
                latch.countDown();
            }
        });
        
        latch.await(20, TimeUnit.SECONDS);  // Wait for server to finish
        System.out.println("-------------------------------------------------");
    }
    
    //Report traffic data method, client will request multiple request and server will response once (Client Streaming)
    public void reportTrafficData() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<UserInput> requestObserver = asyncStub.crowdsourcedTrafficData(new StreamObserver<CityTrafficAnalysis>() {
            @Override
            public void onNext(CityTrafficAnalysis analysis) {
                System.out.println("Traffic Report: " + analysis.getReportSummary());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Traffic data submitted.");
                latch.countDown();
            }
        });

        requestObserver.onNext(UserInput.newBuilder().setUsername("JuanDelaCruz").setTrafficCondition("Heavy").build());
        requestObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
        System.out.println("-------------------------------------------------");
    }
    
    //main method here includes declaration or instantiate new object
    public static void main(String[] args) throws InterruptedException {
        JuanTamadClient client = new JuanTamadClient();
        client.checkTraffic();
        client.getLiveTrafficUpdates();
        client.reportTrafficData();
    }
}

