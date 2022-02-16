package li.sarossill.twitchplays.services.ChatService;
import li.sarossill.twitchplays.model.User;

public interface UserService extends CrudService<User,Long>{
    User findByUsername(String username);
}
