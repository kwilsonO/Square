package square.api.domain.errors;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum ErrorCode {

  NUMBER_NOT_FOUND;

  @JsonCreator
  public static ErrorCode forValue(String value) {
    return ErrorCode.valueOf(value);
  }
}
