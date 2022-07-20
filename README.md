[maven-central]: https://img.shields.io/maven-central/v/net.dv8tion/JDA?color=blue
# JavaDemoBot | How to create an Java Discord Bot with JDA 
# This guide uses Maven and IntelliJ.

<h2>Installing</h2>
1. Download an IDE of your choice, preferably IntelliJ (https://www.jetbrains.com/idea/download)
2. Finish installing the programme to your pc and open it when you are done.

<h2>Configuring</h2>
1. Make sure you have java set up on your device. If you don't, donload it here (https://www.oracle.com/java/technologies/downloads/archive/)
2. Create a new project, select your build system, maven is recommended.
3. Select the correct JDK version for your project.
4. And click create. 

<h2>Coding</h2>
1. Use Maven or gradel to install the libraries.

https://img.shields.io/maven-central/v/net.dv8tion/JDA?color=blue
[https://img.shields.io/maven-central/v/net.dv8tion/JDA?color=blue]
Latest Release: [GitHub Release](https://github.com/DV8FromTheWorld/JDA/releases/latest) <br>

2. Be sure to replace the **VERSION** key below with the one of the versions shown above!

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

2. Go back to the Java Class in my case the "DemoBot" you should see something like this:
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

26. Press enter and write main and press enter to use the suggestion. Now it should look like this:
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
