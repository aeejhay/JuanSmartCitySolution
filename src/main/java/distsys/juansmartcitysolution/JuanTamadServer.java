/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.juansmartcitysolution;

/**
 *
 * @author ajand
 */

import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import generated.grpc.juantamad.*;

import java.io.IOException;
import java.util.logging.Logger;

public class JuanTamadServer extends JuanTamadGrpc.JuanTamadImplBase {
    private static final Logger logger = Logger.getLogger(JuanTamadServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        JuanTamadServer server = new JuanTamadServer();
        Server grpcServer = ServerBuilder.forPort(50052)
                .addService(server)
                .build()
                .start();

        logger.info("Juan Tamad Server started on port 50052");
        grpcServer.awaitTermination();
    }

    @Override
    public void checkTrafficStatus(Location request, StreamObserver<TrafficCondition> responseObserver) {
        logger.info("Checking traffic status at " + request.getCity());

        TrafficCondition response = TrafficCondition.newBuilder()
                .setCongestionLevel("High")
                .setSuggestion("Stay Home, heavy traffic ahead!")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void liveTrafficReports(Location request, StreamObserver<TrafficUpdate> responseObserver) {
        logger.info("Sending live traffic updates for " + request.getCity());

        for (int i = 0; i < 5; i++) {
            TrafficUpdate update = TrafficUpdate.newBuilder()
                    .setLocation(request.getCity() + ", " + request.getStreet())
                    .setStatus("Traffic congestion level: Moderate")
                    .setTimestamp(System.currentTimeMillis())
                    .build();

            responseObserver.onNext(update);

            try {
                Thread.sleep(3000); // Simulated update delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<UserInput> crowdsourcedTrafficData(StreamObserver<CityTrafficAnalysis> responseObserver) {
        return new StreamObserver<UserInput>() {
            @Override
            public void onNext(UserInput userInput) {
                logger.info("Received traffic report from user: " + userInput.getUsername());

                CityTrafficAnalysis analysis = CityTrafficAnalysis.newBuilder()
                        .setReportSummary("User-reported traffic levels: " + userInput.getTrafficCondition())
                        .setSuggestedAlternativeRoutes("Take side roads to avoid main congestion")
                        .build();

                responseObserver.onNext(analysis);
            }

            @Override
            public void onError(Throwable t) {
                logger.warning("Error in crowdsourced traffic data: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}

