package pl.hollow.wallstreet.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class PostTestSuite {

    @Autowired
    private PostRepository postRepository;

    @Test
    public void shouldFetchRate() {
//        Given
        Post rate = new Post();
        postRepository.save(rate);
        String postId = rate.getId();

//        When
        Optional<Post> fetchedRateOpt = postRepository.findById(postId);

//        Then
        assertTrue(fetchedRateOpt.isPresent());
        assertEquals(postId, fetchedRateOpt.get().getId());

//        CleanUp
        postRepository.deleteById(postId);
    }
}