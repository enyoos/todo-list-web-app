package com.todo.exceptions;
public class ClientNotFoundInDatabase extends Exception{
    public ClientNotFoundInDatabase(String content){
        super("client with name : " + content + " doesn't exist in the database");
    }
}