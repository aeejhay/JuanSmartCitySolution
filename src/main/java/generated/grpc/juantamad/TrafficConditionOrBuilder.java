// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: juantamad.proto

package generated.grpc.juantamad;

public interface TrafficConditionOrBuilder extends
    // @@protoc_insertion_point(interface_extends:juantamad.TrafficCondition)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Low, Medium, High, Severe
   * </pre>
   *
   * <code>string congestion_level = 1;</code>
   */
  java.lang.String getCongestionLevel();
  /**
   * <pre>
   * Low, Medium, High, Severe
   * </pre>
   *
   * <code>string congestion_level = 1;</code>
   */
  com.google.protobuf.ByteString
      getCongestionLevelBytes();

  /**
   * <pre>
   * Stay Home, Moderate Traffic, Heavy Congestion
   * </pre>
   *
   * <code>string suggestion = 2;</code>
   */
  java.lang.String getSuggestion();
  /**
   * <pre>
   * Stay Home, Moderate Traffic, Heavy Congestion
   * </pre>
   *
   * <code>string suggestion = 2;</code>
   */
  com.google.protobuf.ByteString
      getSuggestionBytes();
}
