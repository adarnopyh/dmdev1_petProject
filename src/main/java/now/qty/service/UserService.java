package now.qty.service;


import now.qty.dto.CreateUserDto;


public interface UserService {
CreateUserDto create(CreateUserDto createUserDto);
}


//
//package now.qty.service;
//
//import now.qty.dto.ClientDto;
//
//import java.util.List;
//
//public interface ClientService {
//    ClientDto findById(Integer id);
//    List<ClientDto> findAll();
//    ClientDto create(ClientDto dto);
//    ClientDto update(ClientDto updateDto);
//    void delete(Integer id);
//
//}