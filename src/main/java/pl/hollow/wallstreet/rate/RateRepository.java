package pl.hollow.wallstreet.rate;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
interface RateRepository extends MongoRepository<Rate, String> {

    @Query("FROM Rate r ORDER BY f.date DESC NULLS LAST LIMIT 1")
    Rate findMostRecent();
}
