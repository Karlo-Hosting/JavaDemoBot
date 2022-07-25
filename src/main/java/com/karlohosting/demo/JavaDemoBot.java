import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

import javax.security.auth.login.LoginException;

public class JavaDemoBot {
    public static void main(String[] args) throws InterruptedException {
        JDA jda = null;
        JDABuilder builder = JDABuilder.create("token", GatewayIntents);
        builder.setActivity(Activity.playing("Demo Bot"));
        //Adds the classes that will listen for events.
        builder.addEventListeners(new DemoComnmands());
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
