package generated.grpc.litolapis;

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
 * Service: Lito Lapis - Smart GPS Pen for Students
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: litolapis.proto")
public final class LitoLapisGrpc {

  private LitoLapisGrpc() {}

  public static final String SERVICE_NAME = "litolapis.LitoLapis";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.litolapis.PenID,
      generated.grpc.litolapis.GPSData> getGetCurrentLocationMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetCurrentLocation",
      requestType = generated.grpc.litolapis.PenID.class,
      responseType = generated.grpc.litolapis.GPSData.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.litolapis.PenID,
      generated.grpc.litolapis.GPSData> getGetCurrentLocationMethod() {
    io.grpc.MethodDescriptor<generated.grpc.litolapis.PenID, generated.grpc.litolapis.GPSData> getGetCurrentLocationMethod;
    if ((getGetCurrentLocationMethod = LitoLapisGrpc.getGetCurrentLocationMethod) == null) {
      synchronized (LitoLapisGrpc.class) {
        if ((getGetCurrentLocationMethod = LitoLapisGrpc.getGetCurrentLocationMethod) == null) {
          LitoLapisGrpc.getGetCurrentLocationMethod = getGetCurrentLocationMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.litolapis.PenID, generated.grpc.litolapis.GPSData>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "litolapis.LitoLapis", "GetCurrentLocation"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.litolapis.PenID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.litolapis.GPSData.getDefaultInstance()))
                  .setSchemaDescriptor(new LitoLapisMethodDescriptorSupplier("GetCurrentLocation"))
                  .build();
          }
        }
     }
     return getGetCurrentLocationMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.litolapis.PenID,
      generated.grpc.litolapis.LocationUpdates> getTrackStudentLiveMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "TrackStudentLive",
      requestType = generated.grpc.litolapis.PenID.class,
      responseType = generated.grpc.litolapis.LocationUpdates.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.litolapis.PenID,
      generated.grpc.litolapis.LocationUpdates> getTrackStudentLiveMethod() {
    io.grpc.MethodDescriptor<generated.grpc.litolapis.PenID, generated.grpc.litolapis.LocationUpdates> getTrackStudentLiveMethod;
    if ((getTrackStudentLiveMethod = LitoLapisGrpc.getTrackStudentLiveMethod) == null) {
      synchronized (LitoLapisGrpc.class) {
        if ((getTrackStudentLiveMethod = LitoLapisGrpc.getTrackStudentLiveMethod) == null) {
          LitoLapisGrpc.getTrackStudentLiveMethod = getTrackStudentLiveMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.litolapis.PenID, generated.grpc.litolapis.LocationUpdates>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "litolapis.LitoLapis", "TrackStudentLive"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.litolapis.PenID.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.litolapis.LocationUpdates.getDefaultInstance()))
                  .setSchemaDescriptor(new LitoLapisMethodDescriptorSupplier("TrackStudentLive"))
                  .build();
          }
        }
     }
     return getTrackStudentLiveMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.litolapis.GPSData,
      generated.grpc.litolapis.SafetyAlert> getAlertLostStudentMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AlertLostStudent",
      requestType = generated.grpc.litolapis.GPSData.class,
      responseType = generated.grpc.litolapis.SafetyAlert.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.litolapis.GPSData,
      generated.grpc.litolapis.SafetyAlert> getAlertLostStudentMethod() {
    io.grpc.MethodDescriptor<generated.grpc.litolapis.GPSData, generated.grpc.litolapis.SafetyAlert> getAlertLostStudentMethod;
    if ((getAlertLostStudentMethod = LitoLapisGrpc.getAlertLostStudentMethod) == null) {
      synchronized (LitoLapisGrpc.class) {
        if ((getAlertLostStudentMethod = LitoLapisGrpc.getAlertLostStudentMethod) == null) {
          LitoLapisGrpc.getAlertLostStudentMethod = getAlertLostStudentMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.litolapis.GPSData, generated.grpc.litolapis.SafetyAlert>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "litolapis.LitoLapis", "AlertLostStudent"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.litolapis.GPSData.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.litolapis.SafetyAlert.getDefaultInstance()))
                  .setSchemaDescriptor(new LitoLapisMethodDescriptorSupplier("AlertLostStudent"))
                  .build();
          }
        }
     }
     return getAlertLostStudentMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static LitoLapisStub newStub(io.grpc.Channel channel) {
    return new LitoLapisStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static LitoLapisBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new LitoLapisBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static LitoLapisFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new LitoLapisFutureStub(channel);
  }

  /**
   * <pre>
   * Service: Lito Lapis - Smart GPS Pen for Students
   * </pre>
   */
  public static abstract class LitoLapisImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Get the current location of a student's smart pen
     * </pre>
     */
    public void getCurrentLocation(generated.grpc.litolapis.PenID request,
        io.grpc.stub.StreamObserver<generated.grpc.litolapis.GPSData> responseObserver) {
      asyncUnimplementedUnaryCall(getGetCurrentLocationMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stream real-time location updates of the student’s pen
     * </pre>
     */
    public void trackStudentLive(generated.grpc.litolapis.PenID request,
        io.grpc.stub.StreamObserver<generated.grpc.litolapis.LocationUpdates> responseObserver) {
      asyncUnimplementedUnaryCall(getTrackStudentLiveMethod(), responseObserver);
    }

    /**
     * <pre>
     * Bi-directional communication for lost student alerts
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.litolapis.GPSData> alertLostStudent(
        io.grpc.stub.StreamObserver<generated.grpc.litolapis.SafetyAlert> responseObserver) {
      return asyncUnimplementedStreamingCall(getAlertLostStudentMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetCurrentLocationMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.litolapis.PenID,
                generated.grpc.litolapis.GPSData>(
                  this, METHODID_GET_CURRENT_LOCATION)))
          .addMethod(
            getTrackStudentLiveMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.litolapis.PenID,
                generated.grpc.litolapis.LocationUpdates>(
                  this, METHODID_TRACK_STUDENT_LIVE)))
          .addMethod(
            getAlertLostStudentMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.litolapis.GPSData,
                generated.grpc.litolapis.SafetyAlert>(
                  this, METHODID_ALERT_LOST_STUDENT)))
          .build();
    }
  }

  /**
   * <pre>
   * Service: Lito Lapis - Smart GPS Pen for Students
   * </pre>
   */
  public static final class LitoLapisStub extends io.grpc.stub.AbstractStub<LitoLapisStub> {
    private LitoLapisStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LitoLapisStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LitoLapisStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LitoLapisStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the current location of a student's smart pen
     * </pre>
     */
    public void getCurrentLocation(generated.grpc.litolapis.PenID request,
        io.grpc.stub.StreamObserver<generated.grpc.litolapis.GPSData> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getGetCurrentLocationMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stream real-time location updates of the student’s pen
     * </pre>
     */
    public void trackStudentLive(generated.grpc.litolapis.PenID request,
        io.grpc.stub.StreamObserver<generated.grpc.litolapis.LocationUpdates> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getTrackStudentLiveMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Bi-directional communication for lost student alerts
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.litolapis.GPSData> alertLostStudent(
        io.grpc.stub.StreamObserver<generated.grpc.litolapis.SafetyAlert> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getAlertLostStudentMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service: Lito Lapis - Smart GPS Pen for Students
   * </pre>
   */
  public static final class LitoLapisBlockingStub extends io.grpc.stub.AbstractStub<LitoLapisBlockingStub> {
    private LitoLapisBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LitoLapisBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LitoLapisBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LitoLapisBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the current location of a student's smart pen
     * </pre>
     */
    public generated.grpc.litolapis.GPSData getCurrentLocation(generated.grpc.litolapis.PenID request) {
      return blockingUnaryCall(
          getChannel(), getGetCurrentLocationMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stream real-time location updates of the student’s pen
     * </pre>
     */
    public java.util.Iterator<generated.grpc.litolapis.LocationUpdates> trackStudentLive(
        generated.grpc.litolapis.PenID request) {
      return blockingServerStreamingCall(
          getChannel(), getTrackStudentLiveMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service: Lito Lapis - Smart GPS Pen for Students
   * </pre>
   */
  public static final class LitoLapisFutureStub extends io.grpc.stub.AbstractStub<LitoLapisFutureStub> {
    private LitoLapisFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private LitoLapisFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected LitoLapisFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new LitoLapisFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Get the current location of a student's smart pen
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.litolapis.GPSData> getCurrentLocation(
        generated.grpc.litolapis.PenID request) {
      return futureUnaryCall(
          getChannel().newCall(getGetCurrentLocationMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_CURRENT_LOCATION = 0;
  private static final int METHODID_TRACK_STUDENT_LIVE = 1;
  private static final int METHODID_ALERT_LOST_STUDENT = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final LitoLapisImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(LitoLapisImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_CURRENT_LOCATION:
          serviceImpl.getCurrentLocation((generated.grpc.litolapis.PenID) request,
              (io.grpc.stub.StreamObserver<generated.grpc.litolapis.GPSData>) responseObserver);
          break;
        case METHODID_TRACK_STUDENT_LIVE:
          serviceImpl.trackStudentLive((generated.grpc.litolapis.PenID) request,
              (io.grpc.stub.StreamObserver<generated.grpc.litolapis.LocationUpdates>) responseObserver);
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
        case METHODID_ALERT_LOST_STUDENT:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.alertLostStudent(
              (io.grpc.stub.StreamObserver<generated.grpc.litolapis.SafetyAlert>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class LitoLapisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    LitoLapisBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.litolapis.LitoLapisProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("LitoLapis");
    }
  }

  private static final class LitoLapisFileDescriptorSupplier
      extends LitoLapisBaseDescriptorSupplier {
    LitoLapisFileDescriptorSupplier() {}
  }

  private static final class LitoLapisMethodDescriptorSupplier
      extends LitoLapisBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    LitoLapisMethodDescriptorSupplier(String methodName) {
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
      synchronized (LitoLapisGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new LitoLapisFileDescriptorSupplier())
              .addMethod(getGetCurrentLocationMethod())
              .addMethod(getTrackStudentLiveMethod())
              .addMethod(getAlertLostStudentMethod())
              .build();
        }
      }
    }
    return result;
  }
}
