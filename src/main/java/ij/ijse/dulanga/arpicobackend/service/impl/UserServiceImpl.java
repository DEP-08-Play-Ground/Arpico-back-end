package ij.ijse.dulanga.arpicobackend.service.impl;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.entity.User;
import ij.ijse.dulanga.arpicobackend.repository.UserRepository;
import ij.ijse.dulanga.arpicobackend.service.UserService;
import ij.ijse.dulanga.arpicobackend.service.exception.DuplicateEmailException;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;
import ij.ijse.dulanga.arpicobackend.service.util.EntityDTOTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final EntityDTOTransformer transformer;
    private final UserRepository userRepository;

    public UserServiceImpl(EntityDTOTransformer transformer, UserRepository userRepository) {
        this.transformer = transformer;
        this.userRepository = userRepository;
    }

    @Override
    public UserDTO registerUser(UserDTO user) throws DuplicateEmailException {
        if (userRepository.existsUserByUsername(user.getUsername())) {
            throw new DuplicateEmailException("Username Already Exists");
        }
        return transformer.getUserDTO(userRepository.save(transformer.getUserEntity(user)));
    }

    @Override
    public void updateUSer(UserDTO user) throws NotFoundException {
        Optional<User> optUser = userRepository.findUserByUsername(user.getUsername());
        if (!optUser.isPresent()) throw new NotFoundException("Invalid username");
        optUser.get().setFullName(user.getFullName());
        optUser.get().setPassword(user.getPassword());
        optUser.get().setAddress(user.getAddress());
        optUser.get().setAge(user.getAge());
        optUser.get().setEmail(user.getEmail());
    }

    @Override
    public UserDTO getUserInfo(String username) throws NotFoundException {
        return transformer.getUserDTO(userRepository.findUserByUsername(username).get());
    }

    @Override
    public void deleteUser(String username) throws NotFoundException {
        if (!userRepository.existsUserByUsername(username)) throw new NotFoundException("Invalid Username");
        userRepository.deleteUserByUsername(username);
    }
}
