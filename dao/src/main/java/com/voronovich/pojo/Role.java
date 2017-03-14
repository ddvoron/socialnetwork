package com.voronovich.pojo;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Pojo - users role entity
 *
 * @author  Dmitry V
 * @version 1.0
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(of = {"idRole","role"})
@ToString(exclude = "users")
@Entity
@Table(name = "role")
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
@NamedQueries({
        @NamedQuery(name = "getAllRoles", query = Role.QUERY_GET_ALL_ROLES),
})
public class Role implements Serializable {

    static final String QUERY_GET_ALL_ROLES = "FROM Role";

    @Id
    @Column(name = "id_role")
    private int idRole;

    @Column(name = "role", insertable = true, updatable = true)
    private String role;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private List<User> users = new ArrayList<>();

    public Role(int idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }
}