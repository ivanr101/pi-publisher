package org.secomm.pipublisher;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.internal.requests.Route;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RolesMessage {

    private static final String CHANNEL_ID = "874309789629431858";

    private static final String ROLES_CHANNEL = "844010605102628906";

    private static final String MESSAGE_ID = "879756928539045889";

    private static final String CAR_BOT_MESSAGE = "878054323773378631";

    public void update(JDA jda, String toAppend) {

        TextChannel channel = jda.getTextChannelById(CHANNEL_ID);
        if (channel != null) {
            Message messageToEdit = channel.retrieveMessageById(MESSAGE_ID).complete();
            List<MessageEmbed> embeds = messageToEdit.getEmbeds();
            MessageEmbed toEdit = embeds.get(0);
            List<MessageEmbed.Field> fields = toEdit.getFields();
            MessageEmbed.Field field = fields.get(0);
            String value = field.getValue();
            String newValue = value + toAppend;
            String name = field.getName();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.addField(name, newValue, false);
            embedBuilder.setDescription(toEdit.getDescription());
            messageToEdit.editMessageEmbeds(embedBuilder.build()).queue(
                    message -> message.editMessageEmbeds(embedBuilder.build()).queue()
            );
        }
    }

    public void edit(JDA jda, String term, String substitution) {

        TextChannel channel = jda.getTextChannelById(CHANNEL_ID);
        if (channel != null) {
            Message messageToEdit = channel.retrieveMessageById(MESSAGE_ID).complete();
            List<MessageEmbed> embeds = messageToEdit.getEmbeds();
            MessageEmbed toEdit = embeds.get(0);
            List<MessageEmbed.Field> fields = toEdit.getFields();
            MessageEmbed.Field field = fields.get(0);
            String value = field.getValue();
            String newValue = value.replaceFirst(term, substitution);
            String name = field.getName();
            EmbedBuilder embedBuilder = new EmbedBuilder();
            embedBuilder.addField(name, newValue, false);
            embedBuilder.setDescription(toEdit.getDescription());
            messageToEdit.editMessageEmbeds(embedBuilder.build()).queue(
                    message -> message.editMessageEmbeds(embedBuilder.build()).queue()
            );
        }
    }

    public void transferRoles(JDA jda) {

        try {
            TextChannel destinationChannel = jda.getTextChannelById(CHANNEL_ID);
            TextChannel sourceChannel = jda.getTextChannelById(ROLES_CHANNEL);
            if (destinationChannel != null && sourceChannel != null) {
                Message sourceMessage = sourceChannel.retrieveMessageById(CAR_BOT_MESSAGE).complete();
                Message destinationMessage = destinationChannel.retrieveMessageById(MESSAGE_ID).complete();
                List<MessageReaction> reactions = sourceMessage.getReactions();
                for (MessageReaction reaction : reactions) {
                    MessageReaction.ReactionEmote reactionEmote = reaction.getReactionEmote();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
