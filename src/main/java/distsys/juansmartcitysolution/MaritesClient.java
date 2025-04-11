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
import generated.grpc.marites.*;
import com.google.protobuf.ByteString;
import generated.grpc.juantamad.JuanTamadGrpc;
import io.grpc.Metadata;
import io.grpc.stub.MetadataUtils;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MaritesClient {
    private final MaritesGrpc.MaritesBlockingStub blockingStub;
    private final MaritesGrpc.MaritesStub asyncStub;
    
    //Just for simulation I used fakeData
    byte[] fakeData = new byte[10]; // simulate image
    ByteString byteString = ByteString.copyFrom(fakeData);

    public MaritesClient() {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        
        
        // Create metadata with the API key
        Metadata metadata = new Metadata();
        Metadata.Key<String> apiKeyHeader = Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);
        metadata.put(apiKeyHeader, "BN7O1MMUMnVkXpSampleKeyOnlyForThiSProjeCTNiGOE9yMXnQRkZqAtm");

        // Attach metadata to the stub
        blockingStub = MetadataUtils.attachHeaders(MaritesGrpc.newBlockingStub(channel), metadata);       
        asyncStub = MetadataUtils.attachHeaders(MaritesGrpc.newStub(channel), metadata);
        
    }

    public void scanFace() {
        System.out.println("Scanning Face...");
        PersonImage image = PersonImage.newBuilder().setImageData(byteString).build();
        IdentityData response = blockingStub.scanFace(image);
        System.out.println("Identity: " + response.getName() + " | Suspect: " + response.getIsSuspect());
        System.out.println("-------------------------------------------------");
    }

    public void startLiveSurveillance() {
        System.out.println("Live Surveillance Started...");
        Location location = Location.newBuilder().setCity("Manila").setStreet("Roxas Blvd").build();
        asyncStub.liveSurveillance(location, new StreamObserver<CrimeAlert>() {
            @Override
            public void onNext(CrimeAlert alert) {
                System.out.println("ALERT: " + alert.getDescription() + " at " + alert.getLocation());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Surveillance stream completed.");
            }
        });
        System.out.println("-------------------------------------------------");
    }

    public void reportSuspiciousActivity() throws InterruptedException {
        System.out.println("Report Suspicious Activity...");
        CountDownLatch latch = new CountDownLatch(1);
        StreamObserver<PersonData> requestObserver = asyncStub.reportSuspiciousActivity(new StreamObserver<InvestigationReport>() {
            @Override
            public void onNext(InvestigationReport report) {
                System.out.println("Case Opened: " + report.getCaseId() + " | Officer: " + report.getAssignedOfficer());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println("Error: " + t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("Report submitted successfully.");
                latch.countDown();
            }
        });

        requestObserver.onNext(PersonData.newBuilder().setPersonName("Unknown Individual").setDescription("Suspicious behavior").build());
        requestObserver.onCompleted();
        latch.await(3, TimeUnit.SECONDS);
        System.out.println("-------------------------------------------------");
    }

    public static void main(String[] args) throws InterruptedException {
        MaritesClient client = new MaritesClient();
        client.scanFace();
        client.startLiveSurveillance();
        client.reportSuspiciousActivity();
    }
}

