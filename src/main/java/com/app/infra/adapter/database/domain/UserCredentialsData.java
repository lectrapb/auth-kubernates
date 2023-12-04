package com.app.infra.adapter.database.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.Instant;


@AllArgsConstructor
@Data
@Table(name = "users")
public class UserCredentialsData {

    @Id
    @Column("user_id")
    private Integer  id;

    @Column("user_name")
    private String name;

    @Column ("user_email")
    private String email;

    @Column ("user_password")
    private String password;

    @Column("create_at")
    private Instant createAt;

    public UserCredentialsData() {
        this.createAt = Instant.now();
    }
}
