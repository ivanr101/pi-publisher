package org.secomm.pipublisher;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.entities.MessageEmbed;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.requests.restaction.MessageAction;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Editor {

    private static final String CHANNEL_ID = "874309789629431858";

    private static final String TEST_CHANNEL_ID = "865011235678584852";

    private static final String MESSAGE_ID = "879756928539045889";

    private static final String TEST_MESSAGE_ID = "879095690955997194";

    public void edit(JDA jda) {

        TextChannel channel = jda.getTextChannelById(CHANNEL_ID);
        if (channel != null){
            Message messageToEdit = channel.retrieveMessageById(MESSAGE_ID).complete();
            List<MessageEmbed> embeds = messageToEdit.getEmbeds();
            MessageEmbed toEdit = embeds.get(0);
            List<MessageEmbed.Field> fields = toEdit.getFields();
            MessageEmbed.Field field = fields.get(0);
            String value = field.getValue();
            String newValue = value + "\n\n:robots: - **Bot Restocks**";
            String name = field.getName();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.addField(name, newValue, false);
            embedBuilder.setDescription(toEdit.getDescription());
            messageToEdit.editMessageEmbeds(embedBuilder.build()).queue(
                    message -> message.editMessageEmbeds(embedBuilder.build()).queue()
            );
        }
    }
}
