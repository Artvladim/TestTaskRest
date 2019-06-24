package netcracker.homework.testTask.service;

import netcracker.homework.testTask.dao.ClientDao;
import netcracker.homework.testTask.dto.ClientDto;
import netcracker.homework.testTask.mapper.ClientMapper;
import netcracker.homework.testTask.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service //вся бизнес-логика (все алгоритмика)
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ClientMapper clientMapper;

    public List<ClientDto> retrieveAll() {
        List<ClientDao> clientDaoList = clientRepository.findAll();
        return clientMapper.mapCollectionToDto(clientDaoList);
    }

    public List<ClientDto> retrieveByName(String clientName) {
        return clientMapper.mapCollectionToDto(clientRepository.findByName(clientName));
    }

    public List<ClientDto> retrieveByAge(Integer clientAge) {
        return clientMapper.mapCollectionToDto(clientRepository.findByAge(clientAge));
    }

    public List<ClientDto> retrieveAllWithAgeMoreThan(Integer age) {
        List<ClientDao> clientDaoList = clientRepository.findAll();

        List<ClientDao> filteredClients = new ArrayList<>();
        for (ClientDao clientDao : clientDaoList) {
            if (clientDao.getAge() >= age) {
                filteredClients.add(clientDao);
            }
        }

        return clientMapper.mapCollectionToDto(filteredClients); //преобразование данных из таблицы в json (мапинг dao в dto)
    }
}
