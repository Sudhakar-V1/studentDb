package io.sudhakar.student.dto;

import org.springframework.security.core.GrantedAuthority;
import java.util.Collection;

public class User extends org.springframework.security.core.userdetails.User {

    private final long userId;

    public User(String username, String password, long userId,Collection<? extends GrantedAuthority> authorities
                ) {
        super(username, password, authorities);
        this.userId = userId;

    }

    public long getUserId() {
        return userId;
    }
}
