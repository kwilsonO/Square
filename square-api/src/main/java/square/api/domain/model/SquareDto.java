package square.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(builder = SquareDto.Builder.class)
public class SquareDto {

  private final Integer number;

  private SquareDto(Builder builder) {
    number = builder.number;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  /**
   * Buildern.
   * @param copy copy
   * @return return
   */
  public static Builder newBuilder(SquareDto copy) {
    Builder builder = new Builder();
    builder.number = copy.getNumber();
    return builder;
  }

  public Integer getNumber() {
    return number;
  }

  public static final class Builder {
    private Integer number;

    private Builder() {
    }

    public Builder withNumber(Integer val) {
      number = val;
      return this;
    }

    public SquareDto build() {
      return new SquareDto(this);
    }
  }
}
