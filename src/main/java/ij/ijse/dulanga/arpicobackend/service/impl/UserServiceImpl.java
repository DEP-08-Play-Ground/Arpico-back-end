package ij.ijse.dulanga.arpicobackend.service.impl;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.service.UserService;
import ij.ijse.dulanga.arpicobackend.service.exception.DuplicateEmailException;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Override
    public UserDTO registerUser(UserDTO user) throws DuplicateEmailException {
        return null;
    }

    @Override
    public void updateUSer(UserDTO user) throws NotFoundException {

    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {

    }
}
