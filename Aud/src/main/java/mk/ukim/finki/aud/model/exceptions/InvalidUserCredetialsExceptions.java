package mk.ukim.finki.aud.model.exceptions;

import mk.ukim.finki.aud.repository.InMemoryUserRepository;

public class InvalidUserCredetialsExceptions extends RuntimeException{
    public InvalidUserCredetialsExceptions(){
        super("Invalid user credentials exception");
    }
}
