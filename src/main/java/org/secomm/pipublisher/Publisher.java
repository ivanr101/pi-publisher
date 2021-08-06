package org.secomm.pipublisher;

import org.secomm.pipublisher.webhook.Embed;
import org.secomm.pipublisher.webhook.Field;
import org.secomm.pipublisher.webhook.Image;
import org.secomm.pipublisher.webhook.WebhookContent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@PropertySource("classpath:zotac3060twinedgeoc.properties")
public class Publisher {

    @Value("${webhook.url}")
    private String url;

/*
    @Value("${webhook.content}")
    private String content;
*/

    @Value("${webhook.image_url}")
    private String imageUrl;

    @Value("${webhook.title}")
    private String title;

    @Value("${webhook.buy}")
    private String buy;

    @Value("${webhook.sell7}")
    private String sell7;

    @Value("${webhook.sell14}")
    private String sell14;

    @Value("${webhook.sales7}")
    private String sales7;

    @Value("${webhook.buy.url}")
    private String buyUrl;

    @Value("${webhook.buy.name}")
    private String buyName;


    private final DiscordNotifier discordNotifier;

    public Publisher(final DiscordNotifier discordNotifier) {
        this.discordNotifier = discordNotifier;
    }

    public void publish() {

        discordNotifier.setWebHook(url);
        List<Embed> embeds = new ArrayList<>();
        Embed embed = new Embed();
        embed.setTitle(title);
        embed.setImage(new Image(imageUrl));
        List<Field> fields = new ArrayList<>();
        fields.add(new Field("Buy", buy, false));
        fields.add(new Field("7 Day Average Sell", sell7, false));
        fields.add(new Field("14 Day Average Sell", sell14, false));
        fields.add(new Field("7 Day Sold Quantity", sales7, false));
        fields.add(new Field(buyName, String.format("[BUY](%s)", buyUrl), false));
        embed.setFields(fields);
        embeds.add(embed);
        discordNotifier.sendWebhook(title, "", embeds);
    }
}
