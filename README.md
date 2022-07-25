[maven-central]: https://img.shields.io/maven-central/v/net.dv8tion/JDA?color=blue
# JavaDemoBot | How to create an Java Discord Bot with JDA 
# This guide uses Maven and IntelliJ.
<h2>Summary</h2>

1. [Installation](#installation)

2. [Configuration](#configuration)

3. [Library set up](#library-set-up)

4. [Example Bot](#example-bot)

5. [Building the .jar with Maven only!](#building-the-jar)

6. [Useful links](#useful-links)


# Installation

» Download an IDE of your choice, preferably IntelliJ you can download it [here](https://www.jetbrains.com/idea/download).

» Finish installing the programme to your pc and open it when you are done.

# Configuration

» Make sure you have java set up on your device. If you don't, download it [here](https://www.oracle.com/java/technologies/downloads/archive/).

» Create a new project, select your build tool, maven is recommended for this guide.

» Select the correct JDK version for your project.

» When you are done click create. 

# Library set up

» Use Maven or Gradle to install the libraries.

[ ![maven-central][] ](https://mvnrepository.com/artifact/net.dv8tion/JDA/latest)

» Be sure to replace the **VERSION** key below with the version shown above!

**Maven**
```xml
<dependency>
    <groupId>net.dv8tion</groupId>
    <artifactId>JDA</artifactId>
    <version>VERSION</version>
</dependency>
```

**Maven without Audio**
```xml
<dependency>
    <groupId>net.dv8tion</groupId>
    <artifactId>JDA</artifactId>
    <version>VERSION</version>
    <exclusions>
        <exclusion>
            <groupId>club.minnced</groupId>
            <artifactId>opus-java</artifactId>
        </exclusion>
    </exclusions>
</dependency>
```

**Gradle**
```gradle
repositories {
    mavenCentral()
}

dependencies {
    //Change 'implementation' to 'compile' in old Gradle versions
    implementation("net.dv8tion:JDA:VERSION")
}
```

**Gradle without Audio**
```gradle
dependencies {
    //Change 'implementation' to 'compile' in old Gradle versions
    implementation("net.dv8tion:JDA:VERSION") {
        exclude module: 'opus-java'
    }
}
```

# Example Bot

» Find the folder in your project src/java/main.

» Create a new class and name it what ever you want. This will be used to register the bot.

  This it what it should first look like

```java
public class DemoBot {
    
}
```
» Now add this code to the class.
```java
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
        //Registers the bot. 
        try {
            jda = builder.build();
        } catch (LoginException e) {
            e.printStackTrace();
        }
    }
}
```
» Now make a new class in the same folder. This will be used to listen for events.
```java
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;

public class DemoCommand extends ListenerAdapter {
    //Text Command
    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {
        if(event.getMessage().equals("ping")){
            event.getChannel().sendMessage("pong!").queue();
        }
    }
    
    //Slash Command
    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event) {
        if(event.getName().equals("png")){
            event.reply("pong!").queue();
        }
    }
}
```
» To register the events go back to your main class and replace the code with this.
```java
        //Adds the classes that will listen for events.
        //Add this before you try build the builder.
        builder.addEventListeners(new DemoComnmands());
        
        //Put the new code above or below this.
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
```
# Building the jar

» Add this to your pom.xml
```xml
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>3.2.4</version>
                <executions>
                    <execution>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <shadedArtifactAttached>true</shadedArtifactAttached>
                            <transformers>
                                <transformer implementation=
                                                     "org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>Put your main class here e.g JavaDemoBot</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

» Next go to the right side of your screen and click "Maven".

» Expand Lifecycle and doubleclick package.

» The file will be compiled to /target in your project folder.

» Now you can upload the file that contains "shaded" the Karlo Hosting Panel.

# Useful links
» [JDA Github](https://github.com/DV8FromTheWorld/JDA)

» [JDA Github Wiki](https://github.com/DV8FromTheWorld/JDA/wiki)
 
» [JDA Wiki](https://jda.wiki/introduction/jda/)
 
» [JDA Java Docs](https://ci.dv8tion.net/job/JDA5/javadoc/)
