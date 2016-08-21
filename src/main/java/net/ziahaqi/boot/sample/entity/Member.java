package net.ziahaqi.boot.sample.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by ziahaqi on 7/29/16.
 */
@Entity
public class Member {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id;

    @Column(nullable = false)
    @NotEmpty
    @Size(max = 200)
    private String name;

    @Column(nullable = false, unique = true)
    @Email
    @NotEmpty
    private String email;

    @Column(name = "birth_day", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    @Past
    private Date birthDay;

    public Member() {
    }

    public Member(String name, String email, Date birthDay) {
        this.name = name;
        this.email = email;
        this.birthDay = birthDay;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }
}
