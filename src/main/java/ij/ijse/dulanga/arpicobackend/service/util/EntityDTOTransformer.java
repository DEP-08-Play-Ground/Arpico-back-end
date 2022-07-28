package ij.ijse.dulanga.arpicobackend.service.util;

import ij.ijse.dulanga.arpicobackend.dto.UserDTO;
import ij.ijse.dulanga.arpicobackend.entity.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class EntityDTOTransformer {

    private final ModelMapper modelMapper;

    public EntityDTOTransformer(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    public User getUserEntity(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public UserDTO getUserDTO(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
