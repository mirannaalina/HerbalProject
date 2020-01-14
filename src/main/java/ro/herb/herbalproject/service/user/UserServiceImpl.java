package ro.herb.herbalproject.service.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ro.herb.herbalproject.controller.user.UserDto;
import ro.herb.herbalproject.persistence.user.UserEntity;

public class UserServiceImpl implements UserServiceInt{

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }

    @Override
    public UserEntity findByEmail(String email) {
        return null;
    }

    @Override
    public UserEntity save(UserDto registration) {
        return null;
    }
}
