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
import java.util.logging.Level;
import java.util.logging.Logger;

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
        System.out.println("-------------------------------------------------------------");
        System.out.println("Fetching Student Location...");
        PenID penId = PenID.newBuilder().setPenSerial("PEN-001").build();
        GPSData response = blockingStub.getCurrentLocation(penId);
        System.out.println("Location: " + response.getLatitude() + ", " + response.getLongitude());
    }

    public void trackStudentLive() {
        System.out.println("-------------------------------------------------------------");
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
    
    public void alertLostStudent() throws InterruptedException {
        
        CountDownLatch latch = new CountDownLatch(1);
        
        StreamObserver<GPSData> requestObserver = asyncStub.alertLostStudent(new StreamObserver<SafetyAlert>() {
           @Override
           public void onNext(SafetyAlert alert) {
               System.out.println("-------------------------------------------------------------");
               System.out.println("ALERT: " + alert.getAlertMessage() +
                                  " at " + alert.getLastKnownLocation().getLatitude());
           }

           @Override
           public void onError(Throwable t) {
               System.err.println("Error: " + t.getMessage());
               latch.countDown();
           }

           @Override
           public void onCompleted() {
               System.out.println("Stream finished.");
               latch.countDown();
           }
       });
        
        // Send sample GPS data
        for (int i = 0; i < 3; i++) {
            GPSData gps = GPSData.newBuilder()
                    .setLatitude(14.6 + i)
                    .setLongitude(120.9 + i)
                    .setTimestamp(String.valueOf(System.currentTimeMillis()))
                    .build();

            requestObserver.onNext(gps);
            Thread.sleep(1000);
        }

        requestObserver.onCompleted();
        latch.await(5, TimeUnit.SECONDS);
    }


    public static void main(String[] args) {
        LitoLapisClient client = new LitoLapisClient();
        client.getStudentLocation();
        client.trackStudentLive();
        try {
            client.alertLostStudent();
        } catch (InterruptedException ex) {
            Logger.getLogger(LitoLapisClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
}
