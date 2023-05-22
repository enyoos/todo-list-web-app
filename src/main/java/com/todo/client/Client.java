package com.todo.client;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.util.List;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client{
    @Id
    @SequenceGenerator(
        name="client_sequence",
        sequenceName="client_sequence",
        allocationSize=1
    )
    @GeneratedValue(
        strategy=GenerationType.SEQUENCE,
        generator="client_sequence"
    )
    private Long id;
    private String name;
    private String password;
    @Type(ListArrayType.class)
    @Column(
        name="list_todo",
        columnDefinition = "text[]"
    )
    private List<String> todos; 

    public Client(){}
    public Client(Long id, String name, List<String> todos){
        this.id=id;
        this.name=name;
        this.todos=todos;
    }

    //getter's and setter's
    public void setId(Long id){this.id=id;}
    public void setName(String name){this.name=name;}
    public void setPassword(String password){this.password=password;}
    public void setTodos(List<String> todos){this.todos=todos;}
    public Long getId(){return this.id;}
    public String getName(){return this.name;}
    public String getPassword(){return this.password;}
    public List<String> getTodos(){return this.todos;}
}