package ij.ijse.dulanga.arpicobackend.repository;

import ij.ijse.dulanga.arpicobackend.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,String> {
    boolean existsUserByUsername(String email);
}
