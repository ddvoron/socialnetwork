package com.voronovich.pojo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * POJO user entity
 *
 * @author Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"firstChats", "secondChats", "firstMessages", "secondMessages", "senders", "receivers", "firstFriends", "secondFriends"})
@ToString(exclude = {"firstChats", "secondChats", "firstMessages", "secondMessages", "senders", "receivers", "firstFriends", "secondFriends"})
@Entity
@Table(name = "user")
@NamedQueries({
        @NamedQuery(name = "getAllUsers", query = User.QUERY_GET_ALL_USERS),
        @NamedQuery(name = "getUserByPhone", query = User.QUERY_USER_BY_PHONE),
        @NamedQuery(name = "getUserByEmail", query = User.QUERY_USER_BY_EMAIL),
        @NamedQuery(name = "getUserByPhoneAndPassword", query = User.QUERY_USER_BY_PHONE_AND_PASSWORD),
        @NamedQuery(name = "getUserByEmailAndPassword", query = User.QUERY_USER_BY_EMAIL_AND_PASSWORD),
})
public class User implements Serializable {

    static final String QUERY_GET_ALL_USERS = "FROM User";
    static final String QUERY_USER_BY_PHONE = "FROM User u WHERE u.phone = :phone";
    static final String QUERY_USER_BY_EMAIL = "FROM User u WHERE u.email = :email";
    static final String QUERY_USER_BY_PHONE_AND_PASSWORD = "FROM User u WHERE u.phone = :phone and u.password = :password";
    static final String QUERY_USER_BY_EMAIL_AND_PASSWORD = "FROM User u WHERE u.email = :email and u.password = :password";


    @Id
    @Column(name = "id_user")
    private int idUser;

    @Column(name = "name", insertable = true, updatable = true)
    @Size(min = 3, max = 15, message = "Your name must be between 3 and 15 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+")
    private String name;

    @Column(name = "surname", insertable = true, updatable = true)
    @Size(min = 3, max = 15, message = "Your surname must be between 3 and 15 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z]+")
    private String surname;

    @Column(name = "email", insertable = true, updatable = true)
    @Email
    private String email;

    @Column(name = "phone", insertable = true, updatable = true)
    @Size(min = 3, max = 15, message = "Your login must be between 3 and 15 characters long.")
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z0-9-_.]+")
    private String phone;

    @Column(name = "password", insertable = true, updatable = true)
    @Pattern(regexp = "[а-яА-ЯёЁa-zA-Z0-9-_.]+")
    @Size(min = 3, max = 65, message = "Your password must be between 3 and 65 characters long.")
    private String password;

    @Column(name = "salt", insertable = true, updatable = true)
    private String salt;
    @Column(name = "blackList", insertable = true, updatable = true)
    private String blackList;

    @ManyToOne
    @JoinColumn(name = "role")
    private Role role;

    @OneToMany(mappedBy = "userOne", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Chat> firstChats = new ArrayList<>();

    @OneToMany(mappedBy = "userTwo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Chat> secondChats = new ArrayList<>();

    @OneToMany(mappedBy = "userOne", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Message> firstMessages = new ArrayList<>();

    @OneToMany(mappedBy = "userTwo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Message> secondMessages = new ArrayList<>();

    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Request> senders = new ArrayList<>();

    @OneToMany(mappedBy = "receiver", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Request> receivers = new ArrayList<>();

    @OneToMany(mappedBy = "friendOne", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Friendship> firstFriends = new ArrayList<>();

    @OneToMany(mappedBy = "friendTwo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    List<Friendship> secondFriends = new ArrayList<>();

    public User(int idUser, String name, String surname, String email, String phone,
                String password, String salt, String blackList, Role role) {
        this.idUser = idUser;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.salt = salt;
        this.blackList = blackList;
        this.role = role;
    }
}