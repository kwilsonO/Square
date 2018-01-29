package square.app.restcontroller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.http.HttpStatus.OK;

import square.api.domain.model.CreateSquareRequest;
import square.api.domain.model.CreateSquareResponse;
import square.app.BaseSpringBootTest;
import square.app.domain.jpa.SquareNumber;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;

public class SquareRestControllerTest extends BaseSpringBootTest {

  private static final String NUMBER_URL = "/rest/square/number";

  private SquareNumber squareNumber;

  @Before
  public void setUp() {
  }

  @After
  public void tearDown() {
    numberRepository.deleteAll();
  }

  @Test
  public void saveNumber_ShouldWork_SaveANumber() {
    assertThat(numberRepository.findAll()).hasSize(0);

    Integer number = 5;

    CreateSquareRequest.Builder request = createCorrectNumberRequest(number);

    CreateSquareResponse response = callCreateNumberPostOK(OK, request);

    assertThat(numberRepository.findAll()).hasSize(1);

    assertThat(numberRepository.findOne(Integer.valueOf(response.getNumberId()))).isEqualTo(0);
  }

  private CreateSquareResponse callCreateNumberPostOK(HttpStatus expectedStatus,
      CreateSquareRequest.Builder request) {
    return httpPost(NUMBER_URL + "/v1/setNumber", expectedStatus, request.build(), CreateSquareResponse.class);
  }

  private CreateSquareRequest.Builder createCorrectNumberRequest(int number) {
    return CreateSquareRequest.newBuilder().withNumber(number);
  }

  /*
  @Test
  public void saveNumber_ShouldFail_SaveANumber() {
  }

  @Test
  public void getNumber_ShouldWork_GetANumber() {
  }

  @Test
  public void getNumber_ShouldFail_GetANumber() {
  }
  */
}
