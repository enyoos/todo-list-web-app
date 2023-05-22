public class ClientAlreadyInDatabaseException extends Exception{
    public ClientAlreadyInDatabaseException(String content){
        super("client with name : " + content + " deosn't exist");
    }
}