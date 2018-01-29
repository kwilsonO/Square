package square.api.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateSquareResponse {

  private String numberId;

  public CreateSquareResponse withNumberId(String numberId) {
    this.numberId = numberId;
    return this;
  }

  public String getNumberId() {
    return numberId;
  }

  public void setNumberId(String numberId) {
    this.numberId = numberId;
  }
}
