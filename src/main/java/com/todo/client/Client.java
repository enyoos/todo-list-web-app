package com.todo.client;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="client")
public class Client{
    @Id
    @SequenceGenerator(
        name="client_id_generator", 
        sequenceName="client_id_generator",
        allocationSize=1
    )
    @GeneratedValue(
        strategy = GenerationType.SEQUENCE,
        generator = "client_id_generator"
    ) 
    private Long id;
    private String name;

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
    public void setTodos(List<String> todos){this.todos=todos;}
    public Long getId(){return this.id;}
    public String getName(){return this.name;}
    public List<String> getTodos(){return this.todos;}
}