package com.arz.movie.services.userService;

import com.arz.movie.dtos.users.UserRequest;
import com.arz.movie.dtos.users.UserResponse;
import com.arz.movie.exceptions.EntityNotFound;
import com.arz.movie.exceptions.EntityPresentException;
import com.arz.movie.models.User;
import com.arz.movie.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class UserServiceImpl implements  UserService{

    @Autowired
    private UserRepository userRepository;

  @Autowired
    private ModelMapper mapper;

    @Override
    public UserResponse createUser(UserRequest user) throws EntityPresentException {

        User userOne =mapper.map(user,User.class);
      if(userRepository.existsByMobileNumberIgnoreCase(user.getMobileNumber()))
      {
        throw  new EntityPresentException("User");
      }


        userRepository.save(userOne);
        UserResponse userResponse = mapper.map(userOne,UserResponse.class);
        return  userResponse;
    }

    @Override
    public UserResponse getUserById(Long userId) throws EntityNotFound {

        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent())
        {
            return  mapper.map(user.get(),UserResponse.class);

        }
        else
        {
            throw  new EntityNotFound(User.class.getName());
        }
    }
}
