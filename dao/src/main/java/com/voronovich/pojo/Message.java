package com.voronovich.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "message")
@NamedQueries({
        @NamedQuery(name = "getAllMessages", query = Message.QUERY_GET_ALL_MESSAGES),
})
public class Message {

    static final String QUERY_GET_ALL_MESSAGES = "FROM Message";

    @Id
    @Column(name = "id_message")
    private int idMessage;

    @ManyToOne
    @JoinColumn(name = "user_one")
    private User userOne;

    @ManyToOne
    @JoinColumn(name = "user_two")
    private User userTwo;

    @Column(name = "text")
    private String text;

    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "id_chat")
    private Chat chat;

    public Message(int idMessage, User userOne, User userTwo, String text, Date date, Chat chat) {
        this.idMessage = idMessage;
        this.userOne = userOne;
        this.userTwo = userTwo;
        this.text = text;
        this.date = date;
        this.chat = chat;
    }
}
