package models.posts;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.util.Objects;
@Data
@NoArgsConstructor
@Getter
@Setter
@JsonInclude (JsonInclude.Include.NON_NULL)
public class Posts {

    Integer userId;
    Integer id;
    String title;
    String body;



}