package pl.hollow.wallstreet.post;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.hollow.wallstreet.exception.EntityNotFoundException;

import java.util.List;

@Service
class PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PostService.class);

    private PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> getPosts() {
        LOGGER.info("Fetching list of all posts.");
        return postRepository.findAll();
    }

    public Page<Post> getPostsPage(Pageable pageable) {
        LOGGER.info("Fetching list of all posts.");
        return postRepository.findAll(pageable);
    }

    public Post getPost(String id) throws EntityNotFoundException {
        LOGGER.info("Fetching post {}", id);
        return postRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Post: " + id));
    }

    public void createPost(Post post) {
        LOGGER.info("Creating post {}", post.getId());
        postRepository.save(post);
    }

    public Post updatePost(Post post) {
        LOGGER.info("Updating post {}", post.getId());
        return postRepository.save(post);
    }

    public void deletePost(String id) {
        LOGGER.info("Deleting post {}", id);
        postRepository.deleteById(id);
    }
}