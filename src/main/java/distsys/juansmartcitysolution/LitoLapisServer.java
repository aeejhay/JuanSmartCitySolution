/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ajand
 */
package distsys.juansmartcitysolution;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import generated.grpc.litolapis.*;

import java.io.IOException;
import java.util.logging.Logger;

public class LitoLapisServer extends LitoLapisGrpc.LitoLapisImplBase {
    private static final Logger logger = Logger.getLogger(LitoLapisServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        LitoLapisServer server = new LitoLapisServer();
        Server grpcServer = ServerBuilder.forPort(50053)
                .addService(server)
                .build()
                .start();

        logger.info("Lito Lapis Server started on port 50053");
        grpcServer.awaitTermination();
    }

    @Override
    public void getCurrentLocation(PenID request, StreamObserver<GPSData> responseObserver) {
        logger.info("Fetching GPS location for Pen ID: " + request.getPenSerial());

        GPSData response = GPSData.newBuilder()
                .setLatitude(14.5995)
                .setLongitude(120.9842)
                .setTimestamp(String.valueOf(System.currentTimeMillis()))
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

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
}
