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
import generated.grpc.marites.*;

import java.io.IOException;
import java.util.logging.Logger;

public class MaritesServer extends MaritesGrpc.MaritesImplBase {
    private static final Logger logger = Logger.getLogger(MaritesServer.class.getName());

    public static void main(String[] args) throws IOException, InterruptedException {
        MaritesServer server = new MaritesServer();
        Server grpcServer = ServerBuilder.forPort(50051)
                .addService(server)
                .build()
                .start();
        
        logger.info("Marites Server started on port 50051");
        grpcServer.awaitTermination();
    }

    @Override
    public void scanFace(PersonImage request, StreamObserver<IdentityData> responseObserver) {
        logger.info("Processing face scan...");
        
        // Simulated identity check
        IdentityData response = IdentityData.newBuilder()
                .setName("Juan Dela Cruz")
                .setNationalId("PH123456")
                .setIsSuspect(false)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void liveSurveillance(Location request, StreamObserver<CrimeAlert> responseObserver) {
        logger.info("Starting live surveillance at " + request.getCity());

        for (int i = 0; i < 5; i++) {
            CrimeAlert alert = CrimeAlert.newBuilder()
                    .setDescription("Suspicious activity detected!")
                    .setSuspectName("Unknown Person")
                    .setLocation(request.getCity() + ", " + request.getStreet())
                    .setTimestamp(System.currentTimeMillis())
                    .build();
            
            responseObserver.onNext(alert);

            try {
                Thread.sleep(3000); // Simulated delay
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        responseObserver.onCompleted();
    }

    @Override
    public StreamObserver<PersonData> reportSuspiciousActivity(StreamObserver<InvestigationReport> responseObserver) {
        return new StreamObserver<PersonData>() {
            @Override
            public void onNext(PersonData personData) {
                logger.info("Suspicious activity reported: " + personData.getPersonName());

                InvestigationReport report = InvestigationReport.newBuilder()
                        .setCaseOpened(true)
                        .setAssignedOfficer("Officer Reyes")
                        .setCaseId("CASE-" + System.currentTimeMillis())
                        .build();

                responseObserver.onNext(report);
            }

            @Override
            public void onError(Throwable t) {
                logger.warning("Error in reporting suspicious activity: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
