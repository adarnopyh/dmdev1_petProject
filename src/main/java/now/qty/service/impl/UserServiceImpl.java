package now.qty.service.impl;

import now.qty.dao.UserDao;
import now.qty.dao.impl.UserDaoImpl;
import now.qty.dto.CreateUserDto;
import now.qty.mapper.ClientMapper;
import now.qty.mapper.UserMapper;
import now.qty.mapper.impl.ClientMapperImpl;
import now.qty.mapper.impl.UserMapperImpl;
import now.qty.service.UserService;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;

    private final UserDao userDao = UserDaoImpl.getInstance();
    private final UserMapper userMapper = UserMapperImpl.getInstance();

    public UserServiceImpl() {
    }

    @Override
    public CreateUserDto create(CreateUserDto createUserDto) {
        var userEntity = userMapper.toEntity(createUserDto);
        var savedEntity = userDao.create(userEntity);
        return userMapper.toDto(savedEntity);
    }

    public static synchronized UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }
}
