package now.qty.mapper.impl;

import now.qty.dto.CreateUserDto;
import now.qty.entity.Role;
import now.qty.entity.UserEntity;
import now.qty.mapper.UserMapper;

public class UserMapperImpl implements UserMapper {
    private  static UserMapperImpl instance;

    public UserMapperImpl() {
    }

    public static UserMapper getInstance() {
        if (instance == null) {
            instance = new UserMapperImpl();
        }
        return instance;
    }

    @Override
    public CreateUserDto toDto(UserEntity entity) {
        return CreateUserDto
                .builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(String.valueOf(entity.getRole()))
                .build();
    }

    @Override
    public UserEntity toEntity(CreateUserDto dto) {
        return UserEntity
                .builder()
                .username(dto.getUsername())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .role(Role.valueOf(dto.getRole()))
                .build();
    }
}