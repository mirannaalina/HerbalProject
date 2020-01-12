package ro.herb.herbalproject.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.herb.herbalproject.persistence.user.UserEntity;
import ro.herb.herbalproject.persistence.user.UserRepository;

@Service
public class UserService implements UserDetailsService{

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void save(String name, String password){
        UserEntity userEntity = new UserEntity();
    //    userEntity.setName(name);
        userEntity.setPassword(password);
    //   userEntity.setRole("ADMIN");
        userRepository.save(userEntity);
    }

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        //obtinem userul dupa username
        UserEntity userEntity = userRepository.findByName(name);
        if(userEntity==null){
            throw new UsernameNotFoundException("could not find username");
        }
   //     if(userEntity.getRole()==null || userEntity.getRole().isEmpty()){
            throw new UsernameNotFoundException("no role found for user");
        }
   //     return new MyUser(userEntity.getName(),userEntity.getPassword(),userEntity.getRole());
   // }
}
