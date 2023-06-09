package hr.fer.iot.hos.controller;

import com.google.firebase.messaging.FirebaseMessagingException;
import hr.fer.iot.hos.model.AppNotification;
import hr.fer.iot.hos.service.FirebaseMessagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/firebase")
public class FirebaseController {

    @Autowired
    private FirebaseMessagingService firebaseMessagingService;

    @RequestMapping("/send-notification/token")
    @ResponseBody
    public String sendNotificationToken(@RequestBody AppNotification note,
                                   @RequestParam("token") String token) throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotificationToken(note, token, "LINK_MOCK");
    }

    @RequestMapping("/send-notification/topic")
    @ResponseBody
    public String sendNotificationTopic(@RequestBody AppNotification note,
                                        @RequestParam("topic") String topic) throws FirebaseMessagingException {
        return firebaseMessagingService.sendNotificationTopic(note, topic);
    }
}
