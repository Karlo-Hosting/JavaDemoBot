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

10. In the next menu select on the left side Maven and click on Procect JDK

11. Click Download JDK

12. Select as Vendor Amazon Coretto and as Version the newest version which starts with "11."

13. Click Download

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

27. Now put your cursor in the name of your class and press Alt + Paste and press enter to select the Constructor now should open a window 
where you click "Select None".

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

```

32. Now you have to set a few variables:
 - Set the Activity of your bot with ```builder.setActivity(Activity.playing("on Karlo Hosting."));``` in the brackets after Activity you can press Strg + Space for 
 the options you can set.
 
 - Set the status of your bot with ```builder.setStatus(OnlineStatus.ONLINE);``` in the brackets after OnlineStatus you can press Strg + Space again for the options.
 
 - Your bot has to set the intents he will use. So write ```builder.setEnabledIntents(GatewayIntent.MESSAGE_CONTENT);``` for the usage of this Demo Bot.
 
 - 
