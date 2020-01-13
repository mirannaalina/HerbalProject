package ro.herb.herbalproject.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.herb.herbalproject.controller.user.UserDto;
import ro.herb.herbalproject.model.Role;
import ro.herb.herbalproject.persistence.user.UserEntity;
import ro.herb.herbalproject.persistence.user.UserRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(UserDto accountDto) {
        UserEntity userEntity = new UserEntity();
        userEntity.setFirstName(accountDto.getFirstName());
        userEntity.setLastName(accountDto.getLastName());
        userEntity.setEmail(accountDto.getEmail());
        userEntity.setPassword(accountDto.getPassword());
        //userEntity.setRoles(Arrays.asList("ROLE_USER"));
        userRepository.save(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //obtinem userul dupa username
        UserEntity userEntity = userRepository.findByName(name);
        if (userEntity == null) {
            throw new UsernameNotFoundException("could not find username");
        }

        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;

        return null;

        //    return new org.springframework.security.core.userdetails.User(
        //           userEntity.getEmail(),
        //            userEntity.getFirstName(),
        //            userEntity.getLastName(),
        //            userEntity.getPassword(),
        //             enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,getAuthorities(userEntity.getRoles()));

        // }

        //  private static List<GrantedAuthority> getAuthorities(Collection<Role> roles){
        //      List<GrantedAuthority> authorities = new ArrayList<>();
        //      for(Role role: roles){
        //          authorities.add(new SimpleGrantedAuthority(role));
        //      }
        //       return authorities;
        //   }


        //check if there are duplicate emails

        //@Transactional


    }

}

