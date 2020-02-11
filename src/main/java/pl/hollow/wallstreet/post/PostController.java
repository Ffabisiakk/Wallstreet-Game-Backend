package pl.hollow.wallstreet.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import pl.hollow.wallstreet.post.dto.PostDto;

@RestController
@CrossOrigin("*")
@RequestMapping("/posts")
class PostController {

    private PostService postService;
    private PostMapper postMapping;

    @Autowired
    public PostController(PostService postService, PostMapper postMapping) {
        this.postService = postService;
        this.postMapping = postMapping;
    }

    @GetMapping()
    public Page<PostDto> getPostsPage(@RequestParam(name = "page", required = false) Integer pageOpt) {
        int page = pageOpt == null ? 0 : pageOpt - 1;
        Pageable pageable = PageRequest.of(page, 5, Sort.by(
                Sort.Order.desc("createdAt")
        ));
        return postMapping.postPageToPostDtoPage(postService.getPostsPage(pageable));
    }

}
