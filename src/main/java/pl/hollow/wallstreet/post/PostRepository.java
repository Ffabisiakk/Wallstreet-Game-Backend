package pl.hollow.wallstreet.post;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
interface PostRepository extends MongoRepository<Post, String> {

    Page<Post> findAll(Pageable pageable);
}
