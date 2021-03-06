package sangwoo.naratmal.model.domain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Table(name = "likes")
public class Like {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "like_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;
    private String sessionId;
    private LocalDateTime createdDate;

    public static Like createLike(Long itemId, String sessionId) {
        Like like = new Like();
        like.item = new Item(itemId);
        like.sessionId = sessionId;
        like.createdDate = LocalDateTime.now();
        return like;
    }
}
