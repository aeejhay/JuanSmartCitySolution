package generated.grpc.juantamad;

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
 * Service: Juan Tamad - AI Traffic Oracle
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.15.0)",
    comments = "Source: juantamad.proto")
public final class JuanTamadGrpc {

  private JuanTamadGrpc() {}

  public static final String SERVICE_NAME = "juantamad.JuanTamad";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<generated.grpc.juantamad.Location,
      generated.grpc.juantamad.TrafficCondition> getCheckTrafficStatusMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CheckTrafficStatus",
      requestType = generated.grpc.juantamad.Location.class,
      responseType = generated.grpc.juantamad.TrafficCondition.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<generated.grpc.juantamad.Location,
      generated.grpc.juantamad.TrafficCondition> getCheckTrafficStatusMethod() {
    io.grpc.MethodDescriptor<generated.grpc.juantamad.Location, generated.grpc.juantamad.TrafficCondition> getCheckTrafficStatusMethod;
    if ((getCheckTrafficStatusMethod = JuanTamadGrpc.getCheckTrafficStatusMethod) == null) {
      synchronized (JuanTamadGrpc.class) {
        if ((getCheckTrafficStatusMethod = JuanTamadGrpc.getCheckTrafficStatusMethod) == null) {
          JuanTamadGrpc.getCheckTrafficStatusMethod = getCheckTrafficStatusMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.juantamad.Location, generated.grpc.juantamad.TrafficCondition>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "juantamad.JuanTamad", "CheckTrafficStatus"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.juantamad.Location.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.juantamad.TrafficCondition.getDefaultInstance()))
                  .setSchemaDescriptor(new JuanTamadMethodDescriptorSupplier("CheckTrafficStatus"))
                  .build();
          }
        }
     }
     return getCheckTrafficStatusMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.juantamad.Location,
      generated.grpc.juantamad.TrafficUpdate> getLiveTrafficReportsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "LiveTrafficReports",
      requestType = generated.grpc.juantamad.Location.class,
      responseType = generated.grpc.juantamad.TrafficUpdate.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.juantamad.Location,
      generated.grpc.juantamad.TrafficUpdate> getLiveTrafficReportsMethod() {
    io.grpc.MethodDescriptor<generated.grpc.juantamad.Location, generated.grpc.juantamad.TrafficUpdate> getLiveTrafficReportsMethod;
    if ((getLiveTrafficReportsMethod = JuanTamadGrpc.getLiveTrafficReportsMethod) == null) {
      synchronized (JuanTamadGrpc.class) {
        if ((getLiveTrafficReportsMethod = JuanTamadGrpc.getLiveTrafficReportsMethod) == null) {
          JuanTamadGrpc.getLiveTrafficReportsMethod = getLiveTrafficReportsMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.juantamad.Location, generated.grpc.juantamad.TrafficUpdate>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "juantamad.JuanTamad", "LiveTrafficReports"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.juantamad.Location.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.juantamad.TrafficUpdate.getDefaultInstance()))
                  .setSchemaDescriptor(new JuanTamadMethodDescriptorSupplier("LiveTrafficReports"))
                  .build();
          }
        }
     }
     return getLiveTrafficReportsMethod;
  }

  private static volatile io.grpc.MethodDescriptor<generated.grpc.juantamad.UserInput,
      generated.grpc.juantamad.CityTrafficAnalysis> getCrowdsourcedTrafficDataMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "CrowdsourcedTrafficData",
      requestType = generated.grpc.juantamad.UserInput.class,
      responseType = generated.grpc.juantamad.CityTrafficAnalysis.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<generated.grpc.juantamad.UserInput,
      generated.grpc.juantamad.CityTrafficAnalysis> getCrowdsourcedTrafficDataMethod() {
    io.grpc.MethodDescriptor<generated.grpc.juantamad.UserInput, generated.grpc.juantamad.CityTrafficAnalysis> getCrowdsourcedTrafficDataMethod;
    if ((getCrowdsourcedTrafficDataMethod = JuanTamadGrpc.getCrowdsourcedTrafficDataMethod) == null) {
      synchronized (JuanTamadGrpc.class) {
        if ((getCrowdsourcedTrafficDataMethod = JuanTamadGrpc.getCrowdsourcedTrafficDataMethod) == null) {
          JuanTamadGrpc.getCrowdsourcedTrafficDataMethod = getCrowdsourcedTrafficDataMethod = 
              io.grpc.MethodDescriptor.<generated.grpc.juantamad.UserInput, generated.grpc.juantamad.CityTrafficAnalysis>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(
                  "juantamad.JuanTamad", "CrowdsourcedTrafficData"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.juantamad.UserInput.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  generated.grpc.juantamad.CityTrafficAnalysis.getDefaultInstance()))
                  .setSchemaDescriptor(new JuanTamadMethodDescriptorSupplier("CrowdsourcedTrafficData"))
                  .build();
          }
        }
     }
     return getCrowdsourcedTrafficDataMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static JuanTamadStub newStub(io.grpc.Channel channel) {
    return new JuanTamadStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static JuanTamadBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new JuanTamadBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static JuanTamadFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new JuanTamadFutureStub(channel);
  }

  /**
   * <pre>
   * Service: Juan Tamad - AI Traffic Oracle
   * </pre>
   */
  public static abstract class JuanTamadImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Check traffic status for a specific location
     * </pre>
     */
    public void checkTrafficStatus(generated.grpc.juantamad.Location request,
        io.grpc.stub.StreamObserver<generated.grpc.juantamad.TrafficCondition> responseObserver) {
      asyncUnimplementedUnaryCall(getCheckTrafficStatusMethod(), responseObserver);
    }

    /**
     * <pre>
     * Stream live traffic updates for city residents
     * </pre>
     */
    public void liveTrafficReports(generated.grpc.juantamad.Location request,
        io.grpc.stub.StreamObserver<generated.grpc.juantamad.TrafficUpdate> responseObserver) {
      asyncUnimplementedUnaryCall(getLiveTrafficReportsMethod(), responseObserver);
    }

    /**
     * <pre>
     * Receive user-generated traffic reports to enhance congestion analysis
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.juantamad.UserInput> crowdsourcedTrafficData(
        io.grpc.stub.StreamObserver<generated.grpc.juantamad.CityTrafficAnalysis> responseObserver) {
      return asyncUnimplementedStreamingCall(getCrowdsourcedTrafficDataMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCheckTrafficStatusMethod(),
            asyncUnaryCall(
              new MethodHandlers<
                generated.grpc.juantamad.Location,
                generated.grpc.juantamad.TrafficCondition>(
                  this, METHODID_CHECK_TRAFFIC_STATUS)))
          .addMethod(
            getLiveTrafficReportsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                generated.grpc.juantamad.Location,
                generated.grpc.juantamad.TrafficUpdate>(
                  this, METHODID_LIVE_TRAFFIC_REPORTS)))
          .addMethod(
            getCrowdsourcedTrafficDataMethod(),
            asyncClientStreamingCall(
              new MethodHandlers<
                generated.grpc.juantamad.UserInput,
                generated.grpc.juantamad.CityTrafficAnalysis>(
                  this, METHODID_CROWDSOURCED_TRAFFIC_DATA)))
          .build();
    }
  }

  /**
   * <pre>
   * Service: Juan Tamad - AI Traffic Oracle
   * </pre>
   */
  public static final class JuanTamadStub extends io.grpc.stub.AbstractStub<JuanTamadStub> {
    private JuanTamadStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JuanTamadStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JuanTamadStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JuanTamadStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check traffic status for a specific location
     * </pre>
     */
    public void checkTrafficStatus(generated.grpc.juantamad.Location request,
        io.grpc.stub.StreamObserver<generated.grpc.juantamad.TrafficCondition> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCheckTrafficStatusMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Stream live traffic updates for city residents
     * </pre>
     */
    public void liveTrafficReports(generated.grpc.juantamad.Location request,
        io.grpc.stub.StreamObserver<generated.grpc.juantamad.TrafficUpdate> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getLiveTrafficReportsMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     * <pre>
     * Receive user-generated traffic reports to enhance congestion analysis
     * </pre>
     */
    public io.grpc.stub.StreamObserver<generated.grpc.juantamad.UserInput> crowdsourcedTrafficData(
        io.grpc.stub.StreamObserver<generated.grpc.juantamad.CityTrafficAnalysis> responseObserver) {
      return asyncClientStreamingCall(
          getChannel().newCall(getCrowdsourcedTrafficDataMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   * <pre>
   * Service: Juan Tamad - AI Traffic Oracle
   * </pre>
   */
  public static final class JuanTamadBlockingStub extends io.grpc.stub.AbstractStub<JuanTamadBlockingStub> {
    private JuanTamadBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JuanTamadBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JuanTamadBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JuanTamadBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check traffic status for a specific location
     * </pre>
     */
    public generated.grpc.juantamad.TrafficCondition checkTrafficStatus(generated.grpc.juantamad.Location request) {
      return blockingUnaryCall(
          getChannel(), getCheckTrafficStatusMethod(), getCallOptions(), request);
    }

    /**
     * <pre>
     * Stream live traffic updates for city residents
     * </pre>
     */
    public java.util.Iterator<generated.grpc.juantamad.TrafficUpdate> liveTrafficReports(
        generated.grpc.juantamad.Location request) {
      return blockingServerStreamingCall(
          getChannel(), getLiveTrafficReportsMethod(), getCallOptions(), request);
    }
  }

  /**
   * <pre>
   * Service: Juan Tamad - AI Traffic Oracle
   * </pre>
   */
  public static final class JuanTamadFutureStub extends io.grpc.stub.AbstractStub<JuanTamadFutureStub> {
    private JuanTamadFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private JuanTamadFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected JuanTamadFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new JuanTamadFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Check traffic status for a specific location
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<generated.grpc.juantamad.TrafficCondition> checkTrafficStatus(
        generated.grpc.juantamad.Location request) {
      return futureUnaryCall(
          getChannel().newCall(getCheckTrafficStatusMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CHECK_TRAFFIC_STATUS = 0;
  private static final int METHODID_LIVE_TRAFFIC_REPORTS = 1;
  private static final int METHODID_CROWDSOURCED_TRAFFIC_DATA = 2;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final JuanTamadImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(JuanTamadImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CHECK_TRAFFIC_STATUS:
          serviceImpl.checkTrafficStatus((generated.grpc.juantamad.Location) request,
              (io.grpc.stub.StreamObserver<generated.grpc.juantamad.TrafficCondition>) responseObserver);
          break;
        case METHODID_LIVE_TRAFFIC_REPORTS:
          serviceImpl.liveTrafficReports((generated.grpc.juantamad.Location) request,
              (io.grpc.stub.StreamObserver<generated.grpc.juantamad.TrafficUpdate>) responseObserver);
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
        case METHODID_CROWDSOURCED_TRAFFIC_DATA:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.crowdsourcedTrafficData(
              (io.grpc.stub.StreamObserver<generated.grpc.juantamad.CityTrafficAnalysis>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class JuanTamadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    JuanTamadBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return generated.grpc.juantamad.JuanTamadProto.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("JuanTamad");
    }
  }

  private static final class JuanTamadFileDescriptorSupplier
      extends JuanTamadBaseDescriptorSupplier {
    JuanTamadFileDescriptorSupplier() {}
  }

  private static final class JuanTamadMethodDescriptorSupplier
      extends JuanTamadBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    JuanTamadMethodDescriptorSupplier(String methodName) {
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
      synchronized (JuanTamadGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new JuanTamadFileDescriptorSupplier())
              .addMethod(getCheckTrafficStatusMethod())
              .addMethod(getLiveTrafficReportsMethod())
              .addMethod(getCrowdsourcedTrafficDataMethod())
              .build();
        }
      }
    }
    return result;
  }
}
