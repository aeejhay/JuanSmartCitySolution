// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: marites.proto

package generated.grpc.marites;

public interface CrimeAlertOrBuilder extends
    // @@protoc_insertion_point(interface_extends:marites.CrimeAlert)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>string description = 1;</code>
   */
  java.lang.String getDescription();
  /**
   * <code>string description = 1;</code>
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <code>string suspect_name = 2;</code>
   */
  java.lang.String getSuspectName();
  /**
   * <code>string suspect_name = 2;</code>
   */
  com.google.protobuf.ByteString
      getSuspectNameBytes();

  /**
   * <code>string location = 3;</code>
   */
  java.lang.String getLocation();
  /**
   * <code>string location = 3;</code>
   */
  com.google.protobuf.ByteString
      getLocationBytes();

  /**
   * <code>int64 timestamp = 4;</code>
   */
  long getTimestamp();
}
