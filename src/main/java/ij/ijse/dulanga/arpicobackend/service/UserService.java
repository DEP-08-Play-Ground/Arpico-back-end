package ij.ijse.dulanga.arpicobackend.service;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.service.exception.DuplicateEmailException;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;

public interface UserService {
    UserDTO registerUser(UserDTO user) throws DuplicateEmailException;

    void updateUSer(UserDTO user) throws NotFoundException;

    UserDTO getUserInfo(String userId) throws NotFoundException;
    void deleteUser(String userId) throws NotFoundException;

}
