package li.sarossill.twitchplays.bootsrap;

import li.sarossill.twitchplays.model.User;
import li.sarossill.twitchplays.services.ChatService.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements CommandLineRunner {
    public final UserService userService;

    public DataInit(UserService userService) {
        this.userService = userService;
    }

    //May need to throw exception
    @Override
    public void run(String... args) {
        User user1 = new User();
        user1.setUsername("EzBrizy");
        userService.save(user1);

        User user2 = new User();
        user2.setUsername("Sarossilli");
        userService.save(user2);

        User user3 = new User();
        user3.setUsername("Meme Machin");
        userService.save(user3);

        System.out.println("Loaded Bootstrap Data");

    }
}
