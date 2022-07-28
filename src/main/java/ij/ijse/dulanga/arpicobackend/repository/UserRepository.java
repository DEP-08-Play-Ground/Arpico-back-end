package ij.ijse.dulanga.arpicobackend.repository;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.entity.User;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsUserByUsername(String email);
    Optional<User> findUserByUsername(String username) throws NotFoundException;
    void deleteUserByUsername(String username);

}
