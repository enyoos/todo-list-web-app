public class ClientAlreadyInDatabaseException extends Exception{
    public ClientAlreadyInDatabaseException(String content){
        super(content);
    }
}