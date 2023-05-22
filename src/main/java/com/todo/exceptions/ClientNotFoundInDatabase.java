public class ClientNotFoundInDatabase extends Exception{
    public ClientNotFoundInDatabase(){
        super("client not found in the database");
    }
}