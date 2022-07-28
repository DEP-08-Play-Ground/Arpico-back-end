package ij.ijse.dulanga.arpicobackend.repository;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.entity.User;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsUserByUsername(String email);
    User findUserByUsername(String username) throws NotFoundException;

}
