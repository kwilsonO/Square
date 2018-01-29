package square.app.restcontroller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import square.api.HeadersDefinition;
import square.api.domain.errors.ErrorCode;
import square.api.domain.errors.ErrorInfo;
import square.app.domain.jpa.SquareNumber;
import square.app.exceptions.ObjectNotFoundException;

public class BaseRestController {

  protected final Logger log = LoggerFactory.getLogger(getClass());

  /**
   * ObjectNotFoundException.
   * @param ex ex
   * @return ErrorInfo
   */
  @ExceptionHandler( {ObjectNotFoundException.class})
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public ErrorInfo handleNotFound(ObjectNotFoundException ex) {
    if (ex.getEntityNotFound().equals(SquareNumber.class)) {
      return ErrorInfo.newErrorInfo()
          .withErrorCode(ErrorCode.NUMBER_NOT_FOUND)
          .withErrorDescription(ex.getMessage())
          .withReferenceId(MDC.get(HeadersDefinition.BREAD_CRUMB_ID))
          .build();
    }

    return ErrorInfo.newErrorInfo()
        .withErrorDescription(ex.getMessage())
        .withReferenceId(MDC.get(HeadersDefinition.BREAD_CRUMB_ID))
        .build();
  }
}
