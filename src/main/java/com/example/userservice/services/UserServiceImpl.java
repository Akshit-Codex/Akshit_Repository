package com.example.userservice.services;

import com.example.userservice.models.Token;
import com.example.userservice.models.User;
import com.example.userservice.repositories.TokenRepository;
import com.example.userservice.repositories.UserRepository;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService
{
    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, TokenRepository tokenRepository,
                           BCryptPasswordEncoder bCryptPasswordEncoder)
    {
        this.userRepository = userRepository;
        this.tokenRepository = tokenRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @Override
    public User signup(String name, String email, String password)
    {
        if(userRepository.findByEmail(email).isPresent())
        {
            //throw an exception
            return null;
        }
        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));
        return userRepository.save(user);
    }

    @Override
    public Token login(String email, String password)
    {
        Optional<User> userOptional=userRepository.findByEmail(email);
        if(userOptional.isEmpty())
        {
            //throw an exception
            return null;
        }
        User user = userOptional.get();
        if(!bCryptPasswordEncoder.matches(password, user.getPassword()))//if the pwd is not correct
        {
            //throw an exception
            return null;
        }

        Token token = new Token();
        token.setUser(user);
        //token.setTokenValue(UUID.randomUUID().toString());// We can use this as well
        token.setTokenValue(RandomStringUtils.randomAlphanumeric(128));
        // You can also use UUID but with randomAlphanumeric we can set or increase the String size more than 128
        // characters, in UUID we generally have 128 character size.

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,30);
        Date date = calendar.getTime();

        token.setExpiryAt(date);
        return tokenRepository.save(token);

    }

    @Override
    public void logout(Token token) // THIS IS NOT COMPLETED
    {
        //BELOW CODE IS NOT VALIDATED.
        //tokenRepository.deleteByTokenValue(token.getTokenValue());
    }

    @Override
    public User validateToken(String tokenValue)
    {
        /*
        * Conditions for validating tokens
        * 1. Exists in DB
        * 2. Not deleted
        * 3. Not Expired
        * */

        Optional<Token> tokenOptional = tokenRepository.findByTokenValueAndDeletedAndExpiryAtGreaterThan(
                tokenValue, false,new Date());

        if(tokenOptional.isPresent())
        {
            return tokenOptional.get().getUser();
        }
        return null;
    }
}
