import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import javax.security.auth.login.LoginException;

public class JavaDemoBot {
    public static void main(String[] args) {
        JDA jda = null;
        //Creates the bot with the bot token and gateway intents.
        JDABuilder builder = JDABuilder.create("token", GatewayIntents);
        
        //Sets the activity of the bot.
        builder.setActivity(Activity.playing("Demo Bot"));
        
        //Adds the classes that will listen for events.
        builder.addEventListeners(new DemoComnmands());
        
        //Tries to register the bot.
        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
        
        //Waits until the bot is done loading then uploads the commands.
        jda.awaitReady();
        jda.upsertCommand(Commands.slash("ping","pong!")).queue();
      
    }
}
