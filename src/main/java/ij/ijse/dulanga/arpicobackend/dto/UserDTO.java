package ij.ijse.dulanga.arpicobackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UserDTO {

    @NotNull(message = "Username shouldn't be empty")
    private String username;

    @NotNull(message = "password can not be empty")
    @Length(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @NotNull(message = "Full name can not be empty")
    @Pattern(regexp = "[A-Za-z ]+")
    private String fullName;

    @NotNull(message = "Address can not be empty")
    @Pattern(regexp = "[A-Za-z\\d]{5,}", message = "Invalid address Input")
    private String address;

    @NotNull(message = "Age can not be empty")
    @Digits(message = "Invalid age input", integer = 2, fraction = 0)
    private Integer age;

    @Email(message = "Invalid Email")
    @NotNull(message = "Email can not be empty")
    private String email;

}

