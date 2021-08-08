package org.secomm.pipublisher.rest;

import org.secomm.pipublisher.DiscordNotifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("publisher")
public class PublisherController {

    private final Logger log = LoggerFactory.getLogger(PublisherController.class);

    private final DiscordNotifier discordNotifier;

    public PublisherController(final DiscordNotifier discordNotifier) {
        this.discordNotifier = discordNotifier;
    }

    @PostMapping(value = "/publish", consumes = "application/json", produces = "application/json")
    @CrossOrigin
    public PublishResponse editGlobalUsers(@RequestBody Post post) {

        discordNotifier.sendWebhook(post.getWebhookContent(), post.getWebhook());
        return new PublishResponse("Success");
    }
}
