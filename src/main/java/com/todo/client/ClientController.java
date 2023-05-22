package com.todo.client;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="api/v1/client")
public class ClientController{
    private final ClientService clientService;   
    
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService=clientService;
    }

    @GetMapping
    public List<Client> getClients(){
        return this.clientService.getClients();  
    } 

    @PostMapping
    public void registerNewClient(@RequestBody Client client){
        this.clientService.addNewClient(client);
    }

    @DeleteMapping(path="{client_id}")
    public void deleteClient(@PathVariable("client_id") Long id){
        this.clientService.removeClient(id);
    }

    @PutMapping(path="{client_id}")
    public void updateClient(@PathVariable("client_id") Long id, 
        @RequestParam(required=false) String name,
        @RequestParam(required=false) String password,
        @RequestParam(required=false) List<String> todos
    )
    {
        this.clientService.updateClient(id, name, password, todos);
    }
}