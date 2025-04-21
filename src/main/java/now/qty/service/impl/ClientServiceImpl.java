//package now.qty.service.impl;
//
//import now.qty.dao.ClientDao;
//import now.qty.entity.ClientEntity;
//import now.qty.service.ClientService;
//
//import java.util.Optional;
//
//public class ClientServiceImpl implements ClientService {
//    private static ClientServiceImpl instance;
//
//    private final ClientDao clientDao = (ClientDao) ClientServiceImpl.getInstance();
//
//    private ClientServiceImpl() {
//
//    }
//
//    @Override
//    public ClientDto findById(Integer id) {
//        return null;
//    }
//
//    @Override
//    public List<ClientDto> findAll() {
//        return null;
//    }
//
//    @Override
//    public ClientDto add(ClientDtop dto) {
//        return null;
//    }
//
//    @Override
//    public ClientDto update(ClientDtop updatedto) {
//        return null;
//    }
//
//    @Override
//    public void delete(Integer id) {
//
//    }
//
//    public static synchronized ClientServiceImpl getInstance() {
//        if (instance == null) {
//            instance = new ClientServiceImpl();
//        }
//        return instance;
//    }
//}
//
