package pl.hollow.wallstreet.post;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "posts")
class Post {

    @Id
    private String id;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private String category;
    private String content;

    public Post() {
    }

    public Post(LocalDateTime createdAt, LocalDateTime modifiedAt, String category, String content) {
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.category = category;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
