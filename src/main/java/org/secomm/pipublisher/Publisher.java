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

    private static final String DESTINATION_CHANNEL = "865011235678584852";

    private static final String MESSAGE_TO_COPY = "";

    public void publish(JDA jda) {

        TextChannel channel = jda.getTextChannelById(DESTINATION_CHANNEL);
        if (channel != null) {
            MessageBuilder messageBuilder = new MessageBuilder();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.setDescription("This is a test message with an embed");
            embedBuilder.addField(new MessageEmbed.Field("A field",
                    "A multiline field\n\nTo test appending content", false));
            messageBuilder.setEmbeds(embedBuilder.build());
            channel.sendMessage(messageBuilder.build()).queue();
        }
    }

}
