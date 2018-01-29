package square.app.service;

import square.app.domain.jpa.SquareNumber;

public interface NumberService {

  String saveNumber(int number);

  SquareNumber getNumberById(int id);

}
