package generated.grpc.marites;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 * <pre>
 * Service: Marites - AI Public Camera Robot
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: marites.proto")
public final class MaritesGrpc {

  private MaritesGrpc() {}

  public static final String SERVICE_NAME = "marites.Marites";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.marites.PersonImage,
      generated.grpc.marites.IdentityData> getScanFaceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ScanFace",
      requestType = generated.grpc.marites.PersonImage.class,
      responseType = generated.grpc.marites.IdentityData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.marites.PersonImage,
      generated.grpc.marites.IdentityData> getScanFaceMethod() {
    io.grpc.MethodDescriptor<generated.grpc.marites.PersonImage, generated.grpc.marites.IdentityData> getScanFaceMethod;
    if ((getScanFaceMethod = MaritesGrpc.getScanFaceMethod) == null) {
      synchronized (MaritesGrpc.class) {
        if ((getScanFaceMethod = MaritesGrpc.getScanFaceMethod) == null) {
          MaritesGrpc.getScanFaceMethod = getScanFaceMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.marites.PersonImage, generated.grpc.marites.IdentityData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "marites.Marites", "ScanFace"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.marites.PersonImage.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.marites.IdentityData.getDefaultInstance()))
                  .setSchemaDescriptor(new MaritesMethodDescriptorSupplier("ScanFace"))
                  .build();
          }
        }
     }
     return getScanFaceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.marites.Location,
      generated.grpc.marites.CrimeAlert> getLiveSurveillanceMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LiveSurveillance",
      requestType = generated.grpc.marites.Location.class,
      responseType = generated.grpc.marites.CrimeAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.marites.Location,
      generated.grpc.marites.CrimeAlert> getLiveSurveillanceMethod() {
    io.grpc.MethodDescriptor<generated.grpc.marites.Location, generated.grpc.marites.CrimeAlert> getLiveSurveillanceMethod;
    if ((getLiveSurveillanceMethod = MaritesGrpc.getLiveSurveillanceMethod) == null) {
      synchronized (MaritesGrpc.class) {
        if ((getLiveSurveillanceMethod = MaritesGrpc.getLiveSurveillanceMethod) == null) {
          MaritesGrpc.getLiveSurveillanceMethod = getLiveSurveillanceMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.marites.Location, generated.grpc.marites.CrimeAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "marites.Marites", "LiveSurveillance"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.marites.Location.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.marites.CrimeAlert.getDefaultInstance()))
                  .setSchemaDescriptor(new MaritesMethodDescriptorSupplier("LiveSurveillance"))
                  .build();
          }
        }
     }
     return getLiveSurveillanceMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.marites.PersonData,
      generated.grpc.marites.InvestigationReport> getReportSuspiciousActivityMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "ReportSuspiciousActivity",
      requestType = generated.grpc.marites.PersonData.class,
      responseType = generated.grpc.marites.InvestigationReport.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.marites.PersonData,
      generated.grpc.marites.InvestigationReport> getReportSuspiciousActivityMethod() {
    io.grpc.MethodDescriptor<generated.grpc.marites.PersonData, generated.grpc.marites.InvestigationReport> getReportSuspiciousActivityMethod;
    if ((getReportSuspiciousActivityMethod = MaritesGrpc.getReportSuspiciousActivityMethod) == null) {
      synchronized (MaritesGrpc.class) {
        if ((getReportSuspiciousActivityMethod = MaritesGrpc.getReportSuspiciousActivityMethod) == null) {
          MaritesGrpc.getReportSuspiciousActivityMethod = getReportSuspiciousActivityMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.marites.PersonData, generated.grpc.marites.InvestigationReport>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "marites.Marites", "ReportSuspiciousActivity"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.marites.PersonData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.marites.InvestigationReport.getDefaultInstance()))
                  .setSchemaDescriptor(new MaritesMethodDescriptorSupplier("ReportSuspiciousActivity"))
                  .build();
          }
        }
     }
     return getReportSuspiciousActivityMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static MaritesStub newStub(io.grpc.Channel channel) {
    return new MaritesStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static MaritesBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new MaritesBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static MaritesFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new MaritesFutureStub(channel);
  }

  /**
   * <pre>
   * Service: Marites - AI Public Camera Robot
   * </pre>
   */
  public static abstract class MaritesImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Scan a person's face and return identity data
     * </pre>
     */
    public void scanFace(generated.grpc.marites.PersonImage request,
        io.grpc.stub.StreamObserver<generated.grpc.marites.IdentityData> responseObserver) {
      asyncUnimplementedUnaryCall(getScanFaceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stream real-time surveillance alerts from different locations
     * </pre>
     */
    public void liveSurveillance(generated.grpc.marites.Location request,
        io.grpc.stub.StreamObserver<generated.grpc.marites.CrimeAlert> responseObserver) {
      asyncUnimplementedUnaryCall(getLiveSurveillanceMethod(), responseObserver);
    }

    /**
     * <pre>
     * Report multiple suspicious activities detected by the system
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.marites.PersonData> reportSuspiciousActivity(
        io.grpc.stub.StreamObserver<generated.grpc.marites.InvestigationReport> responseObserver) {
      return asyncUnimplementedStreamingCall(getReportSuspiciousActivityMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getScanFaceMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.marites.PersonImage,
                generated.grpc.marites.IdentityData>(
                  this, METHODID_SCAN_FACE)))
          .addMethod(
            getLiveSurveillanceMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.marites.Location,
                generated.grpc.marites.CrimeAlert>(
                  this, METHODID_LIVE_SURVEILLANCE)))
          .addMethod(
            getReportSuspiciousActivityMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.marites.PersonData,
                generated.grpc.marites.InvestigationReport>(
                  this, METHODID_REPORT_SUSPICIOUS_ACTIVITY)))
          .build();
    }
  }

  /**
   * <pre>
   * Service: Marites - AI Public Camera Robot
   * </pre>
   */
  public static final class MaritesStub extends io.grpc.stub.AbstractStub<MaritesStub> {
    private MaritesStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaritesStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaritesStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaritesStub(channel, callOptions);
    }

    /**
     * <pre>
     * Scan a person's face and return identity data
     * </pre>
     */
    public void scanFace(generated.grpc.marites.PersonImage request,
        io.grpc.stub.StreamObserver<generated.grpc.marites.IdentityData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getScanFaceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stream real-time surveillance alerts from different locations
     * </pre>
     */
    public void liveSurveillance(generated.grpc.marites.Location request,
        io.grpc.stub.StreamObserver<generated.grpc.marites.CrimeAlert> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLiveSurveillanceMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Report multiple suspicious activities detected by the system
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.marites.PersonData> reportSuspiciousActivity(
        io.grpc.stub.StreamObserver<generated.grpc.marites.InvestigationReport> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getReportSuspiciousActivityMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service: Marites - AI Public Camera Robot
   * </pre>
   */
  public static final class MaritesBlockingStub extends io.grpc.stub.AbstractStub<MaritesBlockingStub> {
    private MaritesBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaritesBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaritesBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaritesBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Scan a person's face and return identity data
     * </pre>
     */
    public generated.grpc.marites.IdentityData scanFace(generated.grpc.marites.PersonImage request) {
      return blockingUnaryCall(
          getChannel(), getScanFaceMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stream real-time surveillance alerts from different locations
     * </pre>
     */
    public java.util.Iterator<generated.grpc.marites.CrimeAlert> liveSurveillance(
        generated.grpc.marites.Location request) {
      return blockingServerStreamingCall(
          getChannel(), getLiveSurveillanceMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service: Marites - AI Public Camera Robot
   * </pre>
   */
  public static final class MaritesFutureStub extends io.grpc.stub.AbstractStub<MaritesFutureStub> {
    private MaritesFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private MaritesFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected MaritesFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new MaritesFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Scan a person's face and return identity data
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.marites.IdentityData> scanFace(
        generated.grpc.marites.PersonImage request) {
      return futureUnaryCall(
          getChannel().newCall(getScanFaceMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SCAN_FACE = 0;
  private static final int METHODID_LIVE_SURVEILLANCE = 1;
  private static final int METHODID_REPORT_SUSPICIOUS_ACTIVITY = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final MaritesImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(MaritesImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SCAN_FACE:
          serviceImpl.scanFace((generated.grpc.marites.PersonImage) request,
              (io.grpc.stub.StreamObserver<generated.grpc.marites.IdentityData>) responseObserver);
          break;
        case METHODID_LIVE_SURVEILLANCE:
          serviceImpl.liveSurveillance((generated.grpc.marites.Location) request,
              (io.grpc.stub.StreamObserver<generated.grpc.marites.CrimeAlert>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_REPORT_SUSPICIOUS_ACTIVITY:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.reportSuspiciousActivity(
              (io.grpc.stub.StreamObserver<generated.grpc.marites.InvestigationReport>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class MaritesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    MaritesBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.marites.MaritesProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Marites");
    }
  }

  private static final class MaritesFileDescriptorSupplier
      extends MaritesBaseDescriptorSupplier {
    MaritesFileDescriptorSupplier() {}
  }

  private static final class MaritesMethodDescriptorSupplier
      extends MaritesBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    MaritesMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (MaritesGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new MaritesFileDescriptorSupplier())
              .addMethod(getScanFaceMethod())
              .addMethod(getLiveSurveillanceMethod())
              .addMethod(getReportSuspiciousActivityMethod())
              .build();
        }
      }
    }
    return result;
  }
}
