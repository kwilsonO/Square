package square.app.converters;

import square.api.domain.model.SquareDto;
import square.app.domain.jpa.SquareNumber;

public final class SquareConverter {

  private SquareConverter() {
  }

  /**
   * Convert from database object to Dto and squares itself.
   * @param numberObj numberObj
   * @return KvadreringsNumberDto
   */
  public static SquareDto toSquareNumberDto(SquareNumber numberObj) {
    return SquareDto.newBuilder()
        .withNumber(numberObj.getNumber() * numberObj.getNumber())
        .build();
  }
}
