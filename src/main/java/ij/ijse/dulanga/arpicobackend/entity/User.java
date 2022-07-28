package ij.ijse.dulanga.arpicobackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements SuperEntity {

    @Id
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,name = "full_name")
    private String fullName;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Integer age;

    @Column(nullable = false, unique = true)
    private String email;
}
