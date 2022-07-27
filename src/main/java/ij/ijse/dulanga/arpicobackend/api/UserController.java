package ij.ijse.dulanga.arpicobackend.api;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@CrossOrigin
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO registerUser(@RequestBody @Validated UserDTO user) {
        return null;
    }

    @GetMapping(path = "/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public UserDTO getUserInfo(@PathVariable String userId) {
        return null;
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping(path = "/{userId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable String userId, @RequestBody @Valid UserDTO user) {

    }

}