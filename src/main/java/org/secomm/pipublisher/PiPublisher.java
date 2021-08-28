package org.secomm.pipublisher;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.requests.GatewayIntent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:bots.properties")
public class PiPublisher implements CommandLineRunner {

    @Value("${token}")
    private String token;

    @Autowired
    private Publisher publisher;

    @Autowired
    private RolesMessage rolesMessage;

    @Autowired
    private Editor editor;

    public static void main(String... args) {
        SpringApplication.run(PiPublisher.class);
    }

    @Override
    public void run(String... args) throws Exception {

        JDA jda = JDABuilder.createLight(token, GatewayIntent.GUILD_MESSAGES)
                .build();
        jda.awaitReady();

//        publisher.publish(jda);
//        editor.edit(jda);
//        rolesMessage.update(jda, "\n\n:desktop: - **Gpus**");
//        rolesMessage.edit(jda, "\\*\\*:robot: - \\*\\*Bot - \\*\\*Bot Restocks\\*\\*", ":robot: - **Bot Restocks**");
//        rolesMessage.transferRoles(jda);

//        User user = jda.getUserById(405950664850800640L);
//        String username = user.getName();
    }
}
