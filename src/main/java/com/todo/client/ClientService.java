package com.todo.client;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.todo.exceptions.*;

@Service
public class ClientService{
    private final ClientRepository clientRepository;
    private final int MIN_LENGTH = 6;

    @Autowired
    public ClientService(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    public List<Client> getClients(){
        this.clientRepository.findAll();
    }

    public void addNewClient(Client client){
        String name = client.getName();
        Optional<Client> optionalClient = this.clientRepository.findClientByName(name); 
        if (optionalClient.isPresent()){
            throw new ClientAlreadyInDatabaseException(name);
        } 
        this.clientRepository.save(client);
    }

    public void removeClient(Long id){
        if (this.clientRepository.existsById(id)){
            this.clientRepository.deleteById(id);
        }
        else throw new ClientNotFoundInDatabase(String.valueOf(id));
    }

    @Transactional
    public void updateClient(Long id, String name, String password, List<String> todos){
		//simple business logic 
		Client client=this.clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundInDatabase(name));
		if (name != null && name.length() > 0 && !Objects.equals(name, client.getName())){
			client.setName(name); //java persistence 
		}
        if (password != null && password.length() > MIN_LENGTH && !Objects.equals(password, client.getPassword())){
            client.setPassword(password);
        }
        if (todos != null && !Objects.equals(todos, client.getTodos())){
            client.setTodos(todos);
        } 
    }
    
}