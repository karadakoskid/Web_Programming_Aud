package mk.ukim.finki.aud.model.exceptions;

public class PasswordDoNotMatchException extends RuntimeException{
    public PasswordDoNotMatchException(){
        super("Password do not match");
    }
}
