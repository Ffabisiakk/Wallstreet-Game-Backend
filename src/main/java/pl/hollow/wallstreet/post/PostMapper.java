package pl.hollow.wallstreet.post;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import pl.hollow.wallstreet.post.dto.PostDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public abstract class PostMapper {

    abstract PostDto postToPostDto(Post post);
    abstract Post postDtoToPost(PostDto postDto);
    abstract List<PostDto> postsToPostDtos(List<Post> posts);
    public Page<PostDto> postPageToPostDtoPage(Page<Post> postPage) {
        return postPage.map(this::postToPostDto);
    }
}
