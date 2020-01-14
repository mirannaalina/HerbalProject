package ro.herb.herbalproject.service.user;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import ro.herb.herbalproject.controller.user.UserDto;
import ro.herb.herbalproject.persistence.user.UserEntity;

@Service
public interface UserServiceInt extends UserDetailsService {

    UserEntity findByEmail(String email);
    UserEntity save(UserDto registration);
}
