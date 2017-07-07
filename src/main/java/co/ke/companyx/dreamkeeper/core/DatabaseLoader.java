package co.ke.companyx.dreamkeeper.core;

import co.ke.companyx.dreamkeeper.dream.Dream;
import co.ke.companyx.dreamkeeper.dream.DreamRepository;
import co.ke.companyx.dreamkeeper.tag.Tag;
import co.ke.companyx.dreamkeeper.tag.TagRepository;
import co.ke.companyx.dreamkeeper.user.User;
import co.ke.companyx.dreamkeeper.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by onyangor on 7/7/2017.
 */
@Component
public class DatabaseLoader implements ApplicationRunner{

    private final DreamRepository dreams;
    private final UserRepository users;
    private final TagRepository tags;

    @Autowired
    public DatabaseLoader(DreamRepository dreams, UserRepository users, TagRepository tags){
        this.dreams = dreams;
        this.users = users;
        this.tags = tags;
    }

    @Override
    public void run(ApplicationArguments arguments) throws  Exception {
        User ghostDreamer = new User("ghost", "Scary",  "Ghost", "password", new String[] {"ROLE_USER"});
        User sweetDreamer  = new User("dreamer", "Sweet",  "Dreamer", "password", new String[] {"ROLE_USER"});

        users.save(ghostDreamer);
        users.save(sweetDreamer);
        users.save(new User("dr_smith", "Ken",  "Smith", "password", new String[] {"ROLE_USER", "ROLE_PSYCHOLOGIST"}));
        users.save(new User("admin", "Heis", "Admin", "pa55w0rd", new String[]{"ROLE_USER", "ROLE_ADMIN"}));

        Tag flower = new Tag("flower", sweetDreamer);
        Tag flying = new Tag("flying", sweetDreamer);
        Tag blood = new Tag("flower", sweetDreamer);
        tags.save(flower);
        tags.save(flying);
        tags.save(blood);

        List<Dream> dreamz = Arrays.asList(
                new Dream("Walking in a beautiful flower field", sweetDreamer, flower, new Date()),
                new Dream("Flying around like a bird in the sky", sweetDreamer, flying, new Date()),
                new Dream("Wild animals fighting and blood coming out of their eyes", sweetDreamer, blood, new Date())
                );
        dreams.save(dreamz);
    }
}
