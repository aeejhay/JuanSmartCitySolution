/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.juansmartcitysolution;

/**
 *
 * @author ajandongan
 */

import distsys.security.AuthInterceptor;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;
import generated.grpc.juantamad.*;
import io.grpc.ServerInterceptors;

import java.io.IOException;
import java.util.logging.Logger;

public class JuanTamadServer extends JuanTamadGrpc.JuanTamadImplBase {
    //declare variables and some object getters
    private static final Logger logger = Logger.getLogger(JuanTamadServer.class.getName());     

    public static void main(String[] args) throws IOException, InterruptedException {
                
        //port and authentication
        JuanTamadServer server = new JuanTamadServer();
        Server grpcServer = ServerBuilder.forPort(50052)
                .addService(ServerInterceptors.intercept(server, new AuthInterceptor()))
                .build()
                .start();

        logger.info("Juan Tamad Server started on port 50052");
        grpcServer.awaitTermination();
    }
    
    //Check traffic method (unary type of request) client request once and server response once
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
    
    //Get the live traffic updates method request it once and server will response multiple (server streaming)
    @Override
    public void liveTrafficReports(Location request, StreamObserver<TrafficUpdate> responseObserver) {
        logger.info("Sending live traffic updates for " + request.getCity());
           
        //Simulated traffic congestion level using for loops
        
        for (int i = 0; i < 5; i++) {
            TrafficUpdate update = TrafficUpdate.newBuilder()
                    .setLocation(request.getCity() + ", " + request.getStreet())
                    .setStatus("Traffic congestion level: Moderate")
                    .setTimestamp(System.currentTimeMillis())
                    .build();

            responseObserver.onNext(update);

            try {
                Thread.sleep(2000); // Simulated update delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }

    //Report traffic data method, client will request multiple request and server will response once (Client Streaming)
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

