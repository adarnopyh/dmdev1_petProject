package now.qty.mapper.impl;

import now.qty.dto.ClientDto;
import now.qty.entity.ClientEntity;
import now.qty.mapper.ClientMapper;

public class ClientMapperImpl implements ClientMapper {
    private static ClientMapperImpl instance;

    private ClientMapperImpl() {}

    public static ClientMapperImpl getInstance() {
        if (instance == null) {
            instance = new ClientMapperImpl();
        }
        return instance;
    }
    @Override
    public ClientDto toDto(ClientEntity entity) {
        return ClientDto
                .builder()
                .id(entity.getId())
                .name(entity.getName())
                .isLegal(entity.getIsLegal())
                .isVatPayer(entity.getIsVatPayer())
                .addressId(entity.getAddressId())
                .regNumber(entity.getRegNumber())
                .vatNumber(entity.getVatNumber())
                .bankAccount(entity.getBankAccount())
                .priceLevel(entity.getPriceLevel())
                .build();
    }

    @Override
    public ClientEntity toEntity(ClientDto dto) {
        return ClientEntity
                .builder()
                .id(dto.getId())
                .name(dto.getName())
                .isLegal(dto.getIsLegal())
                .isVatPayer(dto.getIsVatPayer())
                .addressId(dto.getAddressId())
                .regNumber(dto.getRegNumber())
                .vatNumber(dto.getVatNumber())
                .bankAccount(dto.getBankAccount())
                .priceLevel(dto.getPriceLevel())
                .build();
    }
}
