package co.ke.companyx.dreamkeeper.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * Created by onyangor on 7/7/2017.
 */
@Component
public class DetailsService implements UserDetailsService {
    @Autowired
    UserRepository users;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);

        if(user == null) {
            throw new UsernameNotFoundException(username + " not found.");
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                AuthorityUtils.createAuthorityList(user.getRoles())
        );
    }
}
