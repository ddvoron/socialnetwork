package com.voronovich.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

/**
 * POJO friendship entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Entity
@Table(name = "friendship")
@NamedQueries({
        @NamedQuery(name = "getAllFriendships", query = Friendship.QUERY_GET_ALL_FRIENDSHIPS),
})
public class Friendship implements Serializable{

    static final String QUERY_GET_ALL_FRIENDSHIPS = "FROM Friendship";

    @Id
    @Column(name = "id_friendship")
    private int idFriendship;

    @ManyToOne
    @JoinColumn(name = "friend_one")
    private User friendOne;

    @ManyToOne
    @JoinColumn(name = "friend_two")
    private User friendTwo;

    public Friendship(int idFriendship, User friendOne, User friendTwo) {
        this.idFriendship = idFriendship;
        this.friendOne = friendOne;
        this.friendTwo = friendTwo;
    }
}
