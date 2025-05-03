package now.qty.service.impl;

import now.qty.dao.ClientDao;
import now.qty.dao.impl.ClientDaoImpl;
import now.qty.dto.ClientDto;
import now.qty.entity.ClientEntity;
import now.qty.mapper.ClientMapper;
import now.qty.mapper.impl.ClientMapperImpl;
import now.qty.service.ClientService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
    private static ClientServiceImpl instance;

    private final ClientDao clientDao = ClientDaoImpl.getInstance();
    private final ClientMapper clientMapper = ClientMapperImpl.getInstance();

    private ClientServiceImpl() {

    }

    @Override
    public ClientDto findById(Integer id) {
        return clientDao.findById(id)
                .map(clientMapper::toDto)
                .orElseThrow(()-> new RuntimeException("Client not found"));
    }

    @Override
    public List<ClientDto> findAll() {
        return clientDao.findAll().stream()
                .map(clientMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ClientDto create(ClientDto dto) {
        return null;
    }

    @Override
    public ClientDto update(ClientDto updateDto) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    public static synchronized ClientServiceImpl getInstance() {
        if (instance == null) {
            instance = new ClientServiceImpl();
        }
        return instance;
    }
}

