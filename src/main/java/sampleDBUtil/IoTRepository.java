package sampleDBUtil;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IoTRepository extends MongoRepository<IoTDB, String> {
	
	/**
	   * This method will find an Boooking instance in the database by its departure.
	   * Note that this method is not implemented and its working code will be
	   * automatically generated from its signature by Spring Data JPA.
	   */
	  public List<IoTDB> findByTransportNoAndTravelDate(String transportNo, String travelDate);
}
