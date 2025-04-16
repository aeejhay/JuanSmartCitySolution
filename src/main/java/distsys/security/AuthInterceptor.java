/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package distsys.security;

import io.grpc.*;

/**
 * A simple gRPC server-side interceptor to simulate authentication
 * by checking a hardcoded API key sent in the metadata headers.
 * @author ajandongan
 */
public class AuthInterceptor implements ServerInterceptor {

    // Hardcoded valid API key for simulation
    private static final String VALID_API_KEY = "BN7O1MMUMnVkXpSampleKeyOnlyForThiSProjeCTNiGOE9yMXnQRkZqAtm";

    // Define the key name expected in gRPC metadata
    private static final Metadata.Key<String> API_KEY_HEADER =
            Metadata.Key.of("api-key", Metadata.ASCII_STRING_MARSHALLER);

    @Override
    public <ReqT, RespT> ServerCall.Listener<ReqT> interceptCall(
            ServerCall<ReqT, RespT> call,
            Metadata headers,
            ServerCallHandler<ReqT, RespT> next) {

        // Extract the api-key from the incoming headers
        String clientApiKey = headers.get(API_KEY_HEADER);

        // Validate the API key
        if (VALID_API_KEY.equals(clientApiKey)) {
            return next.startCall(call, headers);
        } else {
            // Reject the call with UNAUTHENTICATED status
            call.close(Status.UNAUTHENTICATED.withDescription("Invalid or missing API key."), new Metadata());
            return new ServerCall.Listener() {}; // Return a no-op listener
        }
    }
}
