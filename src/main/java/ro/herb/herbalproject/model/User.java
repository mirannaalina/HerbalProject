package ro.herb.herbalproject.model;

import java.util.Collection;

public class User {

    boolean enabled;
    boolean accountNonExpired;
    boolean credentialsNonExpired;
    boolean accountNonLocked;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Collection<Role>roles;



    public User(){

    }

    public User(String email, String firstName,String lastName,String password, boolean enabled,boolean accountNonExpired,
                boolean credentialsNonExpired, boolean accountNonLocked, Collection<Role> roles) {
        this.enabled = enabled;
        this.accountNonExpired = accountNonExpired;
        this.credentialsNonExpired = credentialsNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.roles= roles;



    }
}
