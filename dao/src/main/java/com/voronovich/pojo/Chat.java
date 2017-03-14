package com.voronovich.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO chat entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = "messages")
@ToString(exclude = "messages")
@Entity
@Table(name = "chat")
@NamedQueries({
        @NamedQuery(name = "getAllChats", query = Chat.QUERY_GET_ALL_CHATS),
})
public class Chat implements Serializable {

    static final String QUERY_GET_ALL_CHATS = "FROM Chat";

    @Id
    @Column(name = "id_chat")
    private int idChat;

    @ManyToOne
    @JoinColumn(name = "user_one")
    private User userOne;

    @ManyToOne
    @JoinColumn(name = "user_two")
    private User userTwo;

    @OneToMany(mappedBy = "chat", cascade = CascadeType.ALL)
    List<Message> messages = new ArrayList<>();

    public Chat(int idChat, User userOne, User userTwo) {
        this.idChat = idChat;
        this.userOne = userOne;
        this.userTwo = userTwo;
    }
}
