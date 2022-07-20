package com.karlohosting.demo;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;

import javax.security.auth.login.LoginException;

public class JavaDemoBot {
    JDA jda;
    public static void main(String[] args) throws LoginException {
        new JavaDemoBot();
    }
    public JavaDemoBot() throws LoginException {
        JDABuilder builder = JDABuilder.createLight("OTk4ODk2OTk3MjkxNTMyMzE4.GiWrUM.VSuo1UBIV_dJ5xTz73GyVAYOIETCHbC3D-CAtw");
        //This token is an example Token
        builder.setActivity(Activity.playing("on Karlo Hosting."));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.addEventListeners(new DemoCommand());
        builder.setEnabledIntents(GatewayIntent.MESSAGE_CONTENT);
        jda = builder.build();
        jda.upsertCommand("ping", "Calculate ping of the bot.").queue();
    }

}
