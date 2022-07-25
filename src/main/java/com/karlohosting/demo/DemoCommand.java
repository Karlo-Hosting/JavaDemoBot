import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DemoCommand extends ListenerAdapter {
    //Text Commands
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getMessage().equals("ping")){
            event.getChannel().sendMessage("pong!").queue();
        }
    }
    
    //Slash Commands
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("png")){
            event.reply("pong!").queue();
        }
    }
}
