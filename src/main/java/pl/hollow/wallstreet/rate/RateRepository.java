package pl.hollow.wallstreet.rate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface RateRepository extends MongoRepository<Rate, String> {

}
