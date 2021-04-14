package com.app.nokia.entity;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Burak KILINC
 * @since 3/4/2021
 */
@Data
@Entity
@Builder
@Table(name = "user_accounts")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class UserAccount {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    @Length(min = 3, max = 150)
    private String name;

    @Column(name = "phone", nullable = false)
    @Length(min = 9, max = 12)
    private String phone;

    @Column(name = "email", nullable = false)
    @Length(max = 200)
    private String email;

    @Column(name = "address")
    @Length(max = 200)
    private String address;

    @Column(name = "country", nullable = false)
    @Length(max = 56)
    private String country;

    @Column(name = "department", nullable = false)
    @Length(max = 50)
    private String department;
}