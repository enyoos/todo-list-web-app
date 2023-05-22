package com.todo.client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{
    @Query(
        value = "SELECT * FROM CLIENTS client WHERE clien.name SIMILAR TO ?1",
        nativeQuery=true
    )
    Optional<Client> findClientByName(String name);     

    @Query(
        value = "DELETE * FROM CLIENTS client WHERE client.name SIMILAR TO ?1",
        nativeQuery=true
    )
    void removeClient(String name); 
} 