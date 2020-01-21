package pl.hollow.wallstreet.rate;

import org.mapstruct.Mapping;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pl.hollow.wallstreet.rate.dto.RateDto;

@Repository
interface RateRepository extends MongoRepository<Rate, String> {
}
