package comment.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentVO {
	private int comment_id;
	private String content;
	private String author_id;
	private int post_id;
}
