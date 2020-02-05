package pl.hollow.wallstreet.post;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import pl.hollow.wallstreet.post.dto.PostDto;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PostMapper {

    PostDto postToPostDto(Post post);
    Post postDtoToPost(PostDto postDto);
    List<PostDto> postsToPostDtos(List<Post> posts);
}
