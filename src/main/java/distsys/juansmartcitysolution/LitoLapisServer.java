/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ajandongan
 */
package distsys.juansmartcitysolution;

import distsys.security.AuthInterceptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import generated.grpc.litolapis.*;
import io.grpc.ServerInterceptors;

import java.io.IOException;
import java.util.logging.Logger;

public class LitoLapisServer extends LitoLapisGrpc.LitoLapisImplBase {
    private static final Logger logger = Logger.getLogger(LitoLapisServer.class.getName());
    
    public static void main(String[] args) throws IOException, InterruptedException {
        //declare object
        LitoLapisServer server = new LitoLapisServer();
        
        //port and authentictaion
        Server grpcServer = ServerBuilder.forPort(50053)
                .addService(ServerInterceptors.intercept(server, new AuthInterceptor()))
                .build()
                .start();

        logger.info("Lito Lapis Server started on port 50053");
        grpcServer.awaitTermination();
    }
    
    //Get student location method, simulates unary one client request and one server response
    @Override
    public void getCurrentLocation(PenID request, StreamObserver<GPSData> responseObserver) {
        logger.info("[Unary] Fetching GPS location for Pen ID: " + request.getPenSerial());

        GPSData response = GPSData.newBuilder()
                .setLatitude(14.5995)
                .setLongitude(120.9842)
                .setTimestamp(String.valueOf(System.currentTimeMillis()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
    
    //Track student live method, simulates Server streaming, client will request once ans server will response multiple messages
    @Override
    public void trackStudentLive(PenID request, StreamObserver<LocationUpdates> responseObserver) {
        logger.info("Tracking student with Pen ID: " + request.getPenSerial());

        for (int i = 0; i < 5; i++) {
            LocationUpdates update = LocationUpdates.newBuilder()
                    .setStudentName("Carlos Santos")
                    .setGps(GPSData.newBuilder().setLatitude(14.6000 + (Math.random() * 0.01))
                            .setLongitude(120.9800 + (Math.random() * 0.01))
                            .setTimestamp(String.valueOf(System.currentTimeMillis()))
                            .build())
                    .build();

            responseObserver.onNext(update);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }
    
    //Alert student method, it is a bi-directional type. Client will request multiple streams and server will response multiple streams
    @Override
    public StreamObserver<GPSData> alertLostStudent(StreamObserver<SafetyAlert> responseObserver) {
        return new StreamObserver<GPSData>() {

            @Override
            public void onNext(GPSData data) {
                System.out.println("Received GPS: " + data.getLatitude() + ", " + data.getLongitude());

                SafetyAlert alert = SafetyAlert.newBuilder()
                        .setAlertMessage("Alert: Stop detected at " + data.getLatitude() + ", " + data.getLongitude())
                        .build();

                responseObserver.onNext(alert);
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("All GPS data received.");
                responseObserver.onCompleted();
            }
        };
    }

}
