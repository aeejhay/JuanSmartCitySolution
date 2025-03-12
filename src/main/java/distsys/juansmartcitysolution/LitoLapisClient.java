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
import generated.grpc.litolapis.*;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LitoLapisClient {
    private final LitoLapisGrpc.LitoLapisBlockingStub blockingStub;
    private final LitoLapisGrpc.LitoLapisStub asyncStub;

    public LitoLapisClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50053)
                .usePlaintext()
                .build();
        blockingStub = LitoLapisGrpc.newBlockingStub(channel);
        asyncStub = LitoLapisGrpc.newStub(channel);
    }

    public void getStudentLocation() {
        System.out.println("Fetching Student Location...");
        PenID penId = PenID.newBuilder().setPenSerial("PEN-001").build();
        GPSData response = blockingStub.getCurrentLocation(penId);
        System.out.println("Location: " + response.getLatitude() + ", " + response.getLongitude());
    }

    public void trackStudentLive() {
        System.out.println("Live Tracking Started...");
        PenID penId = PenID.newBuilder().setPenSerial("PEN-001").build();
        asyncStub.trackStudentLive(penId, new StreamObserver<LocationUpdates>() {
            @Override
            public void onNext(LocationUpdates update) {
                System.out.println(update.getStudentName() + " moved to: " + update.getGps().getLatitude() + ", " + update.getGps().getLongitude());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Student tracking completed.");
            }
        });
    }

    public static void main(String[] args) {
        LitoLapisClient client = new LitoLapisClient();
        client.getStudentLocation();
        client.trackStudentLive();
    }
}
