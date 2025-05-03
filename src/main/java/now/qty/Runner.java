package now.qty;

import now.qty.dao.ClientDao;
import now.qty.dao.impl.ClientDaoImpl;
import now.qty.entity.ClientEntity;
import now.qty.entity.PriceLevelEntity;
import now.qty.util.ConnectionManager;

import java.sql.Connection;
import java.util.Optional;


public class Runner {
    public static void main(String[] args) throws Exception {

        ClientDaoImpl clientDao = ClientDaoImpl.getInstance();

        ClientEntity newClient = ClientEntity.builder()
                .name("Test Org")
                .isLegal(true)
                .isVatPayer(true)
                .regNumber("11234567899")
                .vatNumber("LV11234567899")
                .addressId(null)
                .bankAccount(null)
                .priceLevel(PriceLevelEntity.builder().id(1).build())
                .build();

//_______________Add Client Test
//                clientDao.add(newClient);

//_______________Update Client Test
//        Optional<ClientEntity> optionalClient = clientDao.findById(11);
//        if (optionalClient.isPresent()) {
//            ClientEntity client = optionalClient.get();
//            client.setName("Updated Org Name");
//            client.setAddressId(1);
//            clientDao.update(client);
//        }

// _______________Delete Client Test
//                clientDao.delete(11);

// _______________Find All Client Test
//        System.out.println(clientDao.findAll());

// _______________Find All Client Test
//            System.out.println(clientDao.findById(2));

    }
}

