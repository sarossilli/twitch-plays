package li.sarossill.twitchplays.services.ChatService;

import com.github.philippheuer.credentialmanager.domain.OAuth2Credential;
import com.github.philippheuer.events4j.simple.SimpleEventHandler;
import com.github.philippheuer.events4j.simple.domain.EventSubscriber;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.chat.events.channel.ChannelMessageEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    // twitch client


    TwitchClient twitchClient;
    OAuth2Credential cred;
    public ChatService(@Value("${spring.config.apikey}") String api){
        cred = new OAuth2Credential("twitch",api);
        twitchClient = TwitchClientBuilder.builder().withEnableChat(true)
                .withChatAccount(cred).build();

        // register your handler class
        twitchClient.getEventManager().getEventHandler(SimpleEventHandler.class).registerListener(new CommandService());
    }

    private class CommandService {
        @EventSubscriber
        public void channelMessage(ChannelMessageEvent event) {
            String msg = event.getMessage();
            String[] args;
            if(msg.charAt(0) == '!'){
                msg = msg.substring(1);
                args = msg.split(" ");
                if (args[0].equalsIgnoreCase("register")){
                    System.out.println("REGISTERING " + event.getUser().getName());
                }
            }

        }
    }
}
