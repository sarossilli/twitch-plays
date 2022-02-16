package li.sarossill.twitchplays.services.ChatService.mapImpl;

import li.sarossill.twitchplays.model.User;
import li.sarossill.twitchplays.services.ChatService.UserService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserServiceImpl extends AbstractMap<User,Long> implements UserService {
    @Override
    public Set<User> findAll() {
        return super.findAll();
    }

    @Override
    public User findByID(Long aLong) {
        return super.findById(aLong);
    }

    @Override
    public User save(User item) {
        return super.save(item);
    }

    @Override
    public void delete(User item) {
        super.delete(item);
    }

    @Override
    public void deleteById(Long aLong) {
        super.deleteByID(aLong);
    }

    @Override
    public User findByUsername(String username) {
        Set<User> setOfUsers = super.findAll();
        for(User u : setOfUsers){
            if(u.getUsername() == username){
                return u;
            }
        }
        return null;
    }
}
