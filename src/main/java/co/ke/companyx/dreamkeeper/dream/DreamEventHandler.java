package co.ke.companyx.dreamkeeper.dream;

import co.ke.companyx.dreamkeeper.user.User;
import co.ke.companyx.dreamkeeper.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * Created by onyangor on 7/7/2017.
 */
@Component
@RepositoryEventHandler(Dream.class)
public class DreamEventHandler {
    private final UserRepository users;

    @Autowired
    public DreamEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addDreamerBasedOnLoggedInUser(Dream dream) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        dream.setDreamer(user);
    }
}
