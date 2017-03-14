package com.voronovich.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * POJO request entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "request")
@NamedQueries({
        @NamedQuery(name = "getAllRequests", query = Request.QUERY_GET_ALL_REQUESTS),
})
public class Request implements Serializable{

    static final String QUERY_GET_ALL_REQUESTS = "FROM Request";

    @Id
    @Column(name = "id_request")
    private int idChat;

    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver")
    private User receiver;

    @Column(name = "accepted")
    private String accepted;

    public Request(int idChat, User sender, User receiver, String accepted) {
        this.idChat = idChat;
        this.sender = sender;
        this.receiver = receiver;
        this.accepted = accepted;
    }
}
