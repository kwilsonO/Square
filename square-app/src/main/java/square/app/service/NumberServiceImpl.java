package square.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import square.app.dao.jpa.NumberRepository;
import square.app.domain.jpa.SquareNumber;

import java.util.UUID;

@Service
public class NumberServiceImpl implements NumberService {

  private static Logger log = LoggerFactory.getLogger(NumberServiceImpl.class);

  private final NumberRepository numberRepository;

  @Autowired
  public NumberServiceImpl(NumberRepository numberRepository) {
    this.numberRepository = numberRepository;
  }

  @Override
  @Transactional(isolation = Isolation.SERIALIZABLE, propagation = Propagation.REQUIRES_NEW)
  public String saveNumber(int number) {
    SquareNumber squareNumber = new SquareNumber();

    squareNumber.setId(UUID.randomUUID().toString());
    squareNumber.setNumber(number);

    log.debug("Number {} being saved.", squareNumber.getNumber());
    return numberRepository.save(squareNumber).getId();
  }

  @Override
  public SquareNumber getNumberById(int id) {
    return numberRepository.findOne(id);
  }
}
