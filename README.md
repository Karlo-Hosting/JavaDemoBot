# JavaDemoBot | How to create an Java Discord Bot with JDA
<h2>Installing</h2>

1. Install IntelliJ IDEA Community (https://www.jetbrains.com/de-de/idea/download/)

2. Run the dowloaded .exe file

3. Accept the windows defender popup

4. Click Next (and select your Install Folder) or let it like the default

5. Enable the Options you like (in my case Desktop Shortcut)

6. Click Install 

7. After the installing check the Start check box and click Finish.

8. Click confirm and continue

<h2>Configuring</h2>

9. A window should now open. Where you click "Create New Project"

10. In the next menu select on the left side Maven and click on Project JDK

11. Click Download JDK

12. Select as Vendor "BellSoft Liberica" and as Version the newest version which starts with "11."

13. Click Download
<em>This will set up the development enviorment, we are working with.</em>

14. When its completly downloaded click "Next" and Select a Name and a Folder where it will be saved.

15. Click Finish

<h2>Setting up the pom.xml</h2>

16. Now the projects pom.xml should be shown.

17. Paste this into your pom.xml under the version:
```xml
<dependencies>
    <dependency>
        <groupId>net.dv8tion</groupId>
        <artifactId>JDA</artifactId>
        <version>VERSION</version>
    </dependency>
</dependencies>
```

18. Next go to https://github.com/DV8FromTheWorld/JDA/blob/master/README.md and write the Number next to "maven-central" without the "v" into the version field 
in your pom.xml so in my case:
```xml
<dependencies>
    <dependency>
        <groupId>net.dv8tion</groupId>
        <artifactId>JDA</artifactId>
        <version>5.0.0-alpha.16</version>
    </dependency>
</dependencies>
```
<em>This will set up the Discord Dependencies for the Bot.</em>

![Screenshot 2022-07-19 152707](https://user-images.githubusercontent.com/54218430/179762035-412d16c2-2118-4e2b-8e98-933d8a7cde10.png)
Now you have the newest version of JDA (<b>J</b>ava <b>D</b>iscord <b>A</b>PI)

19. Double click on src -> main and right click on java click "New" and select "Package" now you can write a path. For example: "com.karlohosting.demobot" press Enter

20. Right click on the package and click "New" and select "Java Class" and give it a name. For example: "DemoBot" press Enter

21. Before we start coding go back to the pom.xml in the headbar and paste the following under </dependencies>:
```xml
    <properties>
        <maven.compiler.source>11</maven.compiler.source>
        <maven.compiler.target>11</maven.compiler.target>
    </properties>
    <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>2.3.2</version>
                <configuration>
                    <source>11</source>
                    <target>11</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-shade-plugin</artifactId>
                <version>2.3</version>
                <executions>
                    <execution>
                        <phase>package</phase>
                        <goals>
                            <goal>shade</goal>
                        </goals>
                        <configuration>
                            <transformers>
                                <transformer implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
                                    <mainClass>MAINCLASS</mainClass>
                                </transformer>
                            </transformers>
                        </configuration>
                    </execution>
                </executions>
            </plugin>
        </plugins>
    </build>
```

22. Replace MAINCLASS with the path to your mainclass: PackageName.JavaClass so in my case: com.karlohosting.demobot.DemoBot

23. Click on the reload symbol in the top right corner of your code
<em>This will make the code executable at the end.</em>

<h2>Coding</h2>

24. Go back to the Java Class in my case the "DemoBot" you should see something like this:
```java
package com.karlohosting.demobot;

public class DemoBot {
    
}
```

25. Write in the first line in the class ```JDA jda; ``` and hover on the red marked "JDA" click "Import class"
```java
package com.karlohosting.demobot;

public class DemoBot {
    JDA jda; 
}
```
<em>Here you are creating an variable for the Connection to the Discord API</em>

26. Press emter and write main and press enter to use the suggestion. Now it should look like this:
```java
  package com.karlohosting.demobot;

import net.dv8tion.jda.api.JDA;

public class DemoBot {
    JDA jda;

    public static void main(String[] args) {

    }
}
```
<em>The main section will make the class executeable</em>

27. Now put your cursor in the name of your class and press Alt + Paste and press enter to select the Constructor now should open a window 
where you click "Select None".
<em>You will often have to import dependencies in your code, which you are doing like above.</em>
28. Now put your cursor back into the body of main and type: 
```java
new DemoBot();
```
so it should look like this
```java
package com.karlohosting.demobot;

import net.dv8tion.jda.api.JDA;

public class DemoBot {
    JDA jda;

    public DemoBot() {
    }

    public static void main(String[] args) {
        new DemoBot();
    }
}
```
<em>Here you are creating a module named constructor. It is executed in the main section. You will probably ask: Why can't I put the code directly in the main section?  It is because the main section is static and in static methods you can't access outer variables and other stuff, but it is to complicated to explain it here.</em>


29. Now go behind the opening bracket of ```public DemoBot() {``` and press enter and write ```JDABuilder builder = JDABuilder.createLight("");```

30. Import the class again with hovering to red marked JDABuilder and click "Import class"

31. Put into the quotes your bot token. Now your code should look like this:
```java
package com.karlohosting.demobot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DemoBot {
    JDA jda;

    public DemoBot() {
        JDABuilder builder = JDABuilder.createLight("TOKEN");
    }

    public static void main(String[] args) {
        new DemoBot();
    }
}
<em>With the JDABuilder you can make the jda variable functionable, in other words the variable is clear now but we will have to fill it with information.</em>
```

32. Now you have to set a few variables:
 - Set the Activity of your bot with ```builder.setActivity(Activity.playing("on Karlo Hosting."));``` in the brackets after Activity you can press Strg + Space for 
 the options you can set.
 <em>This will set the activity your bot is doing like in discord "Is watching YouTube"</em>
 
 - Set the status of your bot with ```builder.setStatus(OnlineStatus.ONLINE);``` in the brackets after OnlineStatus you can press Strg + Space again for the options.
 <em>Set the online status of your bot like discord: Online, Do not Disturb...</em>
 
 - *Your bot has to set the intents he will use. So write ```builder.setEnabledIntents(GatewayIntent.MESSAGE_CONTENT);``` for the usage of this Demo Bot.
<em>This is neccessary for the Discord API, that they are knowing what your bot could do.</em>
Those with * are neccessary. In every case you have to import the GatewayIntent, OnlineStatus or the Activity class like descrbed above.

33. Next we will have to build the JDA with ```jda = builder.build();``` so it will look like this

```java
package com.karlohosting.demobot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DemoBot {
    JDA jda;

    public DemoBot() {
        JDABuilder builder = JDABuilder.createLight("TOKEN");
        builder.setActivity(Activity.playing("on Karlo Hosting."));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setEnabledIntents(GatewayIntent.MESSAGE_CONTENT);
        jda = builder.build();
    }

    public static void main(String[] args) {
        new DemoBot();
    }
}
<em>Now you are finally making the jda variable filled with the Bot</em>
```
34. Next we will have to tell JDA our slash command with the following line ```jda.upsertCommand("ping", "Calculate ping of the bot.").queue();``` So your code will look like this
```java
package com.karlohosting.demobot;


import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

public class DemoBot {
    JDA jda;

    public DemoBot() {
        JDABuilder builder = JDABuilder.createLight("TOKEN");
        builder.setActivity(Activity.playing("on Karlo Hosting."));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setEnabledIntents(GatewayIntent.MESSAGE_CONTENT);
        jda = builder.build();
        jda.upsertCommand("ping", "Calculate ping of the bot.").queue();
    }

    public static void main(String[] args) {
        new DemoBot();
    }
}
```
35. Create the slash commands class. For the next step create a class like the main but with a name like "PingCommand".

36. In the class write right next to PingCommand ```extends ListenerAdapter``` ,you will have to import the ListenerAdapter like described before. So your code will look like this
```java
package com.karlohosting.demo;

import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
}
```
<em>The ListenerAdapter is created for specific events to recognise.</em>

37. Next we will have to put in the slash command. So put the following in the body of the PingCommand.
```java
@Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    }
```
<em>Now you have to tell him what he should listen for. In this case the SlashCommandInterActionEvent</em>
You will have to import the SlashcommandInteractionEvent like described before. So your code will look like this.
```java
package com.karlohosting.demo;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
    }
}

```

38. Now we have to put a if clause into the Event body to check if the command is something else than /ping. So put the following in the Events body:
```if (!event.getName().equals("ping")) return;```
<em>This if clause is checking if not the name of the event equals "ping" so the code will not be runned.</em>
So your code will look like this:
```java
package com.karlohosting.demo;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ping")) return;
    }
}
```
39. Next you have to put in the answer, "Pong!" like this:
```event.reply("Pong!").queue();```
<em>Now you are telling the event it should reply on the command with "Pong!"</em>
So your code will look like this.
```java
package com.karlohosting.demo;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {
    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (!event.getName().equals("ping")) return;
        event.reply("Pong!").queue();
    }
}
```
40. Now your command is ready and you only have to register the command in the main. So switch back to your mainclass and put the following under the line where you enable the Intends:
```builder.addEventListeners(new COMMANDCLASSNAME());```
<em>You have to register your command in the jda so it will be executed when ther is an event every time by the JDA.</em>
You will have to import your command class. So your code will look like this. 

```java
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
        builder.setActivity(Activity.playing("on Karlo Hosting."));
        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);
        builder.setEnabledIntents(GatewayIntent.MESSAGE_CONTENT);
        builder.addEventListeners(new PingCommand());
        jda = builder.build();
        jda.upsertCommand("ping", "Calculate ping of the bot.").queue();
    }

}
```

<h2>Building the .jar File</h2>

41. Next go to the right side of your screen and click "Maven".

42. Expand Lifecycle and doubleclick package.

43. Now you can upload the not original File in the target folder on the right to the Karlo Hosting Panel.
