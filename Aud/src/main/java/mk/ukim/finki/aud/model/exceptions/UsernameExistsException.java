package mk.ukim.finki.aud.model.exceptions;

public class UsernameExistsException extends RuntimeException{
    public UsernameExistsException(String username){
        super(String.format("Username: %s already exists",username));
    }
}
