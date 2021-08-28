package org.secomm.pipublisher;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.MessageBuilder;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import org.springframework.stereotype.Component;

@Component
public class Publisher {

    private static final String SOURCE_CHANNEL = "";

    private static final String DESTINATION_CHANNEL = "874309789629431858";

    private static final String MESSAGE_TO_COPY = "";

    private static final String FIELD_TITLE = "Roles";

    private static final String FIELD_VALUE = ":football: - **Sportscards**";

    public void publish(JDA jda) {

        TextChannel channel = jda.getTextChannelById(DESTINATION_CHANNEL);
        if (channel != null) {
            MessageBuilder messageBuilder = new MessageBuilder();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setTitle("Select Your Reaction Roles Here");
            embedBuilder.setDescription("You can select your notification role by reacting to this message. "
                        + "Click the reaction that matches the roles you see below and you will receive notifications "
                        + "for that category. To stop receiving notifications, just come back here and click the "
                        + "reaction again.");
            MessageEmbed.Field field = new MessageEmbed.Field(FIELD_TITLE, FIELD_VALUE, false);
            embedBuilder.addField(field);
            messageBuilder.setEmbeds(embedBuilder.build());
            channel.sendMessage(messageBuilder.build()).queue();
        }
    }

}
