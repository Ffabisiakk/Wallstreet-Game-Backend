package pl.hollow.wallstreet.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
class PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Page<Post> getPostsPage(Pageable pageable) {
        LOGGER.info("Fetching list of all posts.");
        return postRepository.findAll(pageable);
    }
}