package io.sudhakar.student.entity;

import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Slf4j

@Table(name = "user", schema = "public")
public class UserDetailsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

//    @OneToOne(orphanRemoval = true, mappedBy = "userDetailsEntity", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @LazyCollection(LazyCollectionOption.TRUE)
//    private TaskEntity taskEntity;

}
