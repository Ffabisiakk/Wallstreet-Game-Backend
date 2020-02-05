package pl.hollow.wallstreet.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import pl.hollow.wallstreet.exception.EntityNotFoundException;

import java.util.List;

@Component
public class PostFacade {

    private PostService postService;

    @Autowired
    public PostFacade(PostService postService) {
        this.postService = postService;
    }

    public List<Post> getPosts() {
        return postService.getPosts();
    }

    public Page<Post> getPostsPage(Pageable pageable) {
        return postService.getPostsPage(pageable);
    }

    public Post getPost(String id) throws EntityNotFoundException {
        return postService.getPost(id);
    }

    public void createPost(Post post) {
        postService.createPost(post);
    }

    public Post updatePost(Post post) {
        return postService.updatePost(post);
    }

    public void deletePost(String id) {
        postService.deletePost(id);
    }
}
