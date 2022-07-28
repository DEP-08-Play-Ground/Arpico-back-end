package ij.ijse.dulanga.arpicobackend.service.impl;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.repository.UserRepository;
import ij.ijse.dulanga.arpicobackend.service.UserService;
import ij.ijse.dulanga.arpicobackend.service.exception.DuplicateEmailException;
import ij.ijse.dulanga.arpicobackend.service.exception.NotFoundException;
import ij.ijse.dulanga.arpicobackend.service.util.EntityDTOTransformer;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    }

    @Override
    public UserDTO getUserInfo(String userId) throws NotFoundException {
        return null;
    }

    @Override
    public void deleteUser(String userId) throws NotFoundException {

    }
}
