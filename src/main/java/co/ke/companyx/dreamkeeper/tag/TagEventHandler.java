package co.ke.companyx.dreamkeeper.tag;

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
@RepositoryEventHandler(Tag.class)
public class TagEventHandler {
    private final UserRepository users;

    @Autowired
    public TagEventHandler(UserRepository users) {
        this.users = users;
    }

    @HandleBeforeCreate
    public void addTaggerBasedOnLoggedInUser(Tag tag) {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = users.findByUsername(username);
        tag.setOwner(user);
    }
}
