package pl.hollow.wallstreet.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.post.dto.PostDto;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/posts")
class PostController {

    private PostFacade postFacade;
    private PostMapper postMapping;

    @Autowired
    public PostController(PostFacade postFacade, PostMapper postMapping) {
        this.postFacade = postFacade;
        this.postMapping = postMapping;
    }

    @GetMapping()
    public Page<PostDto> getPostsPage(@PathVariable(name = "page", required = false) Integer pageOpt) {
        int page = pageOpt == null ? 0 : pageOpt;
        Pageable pageable = PageRequest.of(page, 5, Sort.by(
                Sort.Order.desc("createdAt")
        ));
        return postMapping.postPageToPostDtoPage(postFacade.getPostsPage(pageable));
    }

    @PostMapping()
    public void post() {
        Post post = new Post();
        post.setCreatedAt(LocalDateTime.now());
        post.setModifiedAt(LocalDateTime.now());
        post.setCategory("test category");
        post.setContent("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        postFacade.createPost(post);
    }
}
