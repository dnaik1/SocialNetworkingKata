package utility;

import domain.MessageStructure;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Utility {

    public static String messageTimingDifference(LocalDateTime messageTime, LocalDateTime currentTime) {
        String timingDifference = "Just Now";
        long days = Duration.between(messageTime, currentTime).toDays();
        long hours = Duration.between(messageTime, currentTime).toHours();
        long minutes = Duration.between(messageTime, currentTime).toMinutes();
        long seconds = Duration.between(messageTime, currentTime).toSeconds();

        if (days > 0) {
            timingDifference = days + " day(s) ago";
        } else if (hours > 0) {
            timingDifference = hours + " hour(s) ago";
        } else if (minutes > 0) {
            timingDifference = minutes + " minute(s) ago";
        } else if (seconds > 0) {
            timingDifference = seconds + " second(s) ago";
        }
        return timingDifference;
    }

    public static List<MessageStructure> sortMessages(List<MessageStructure> message) {
        return message
                .stream()
                .sorted(Comparator.comparing(MessageStructure::getDateTime).reversed())
                .collect(Collectors.toList());
    }

    public static void displayMessage(MessageStructure messageStructure) {
        LocalDateTime messageTime = messageStructure.getDateTime();
        LocalDateTime currentTime = LocalDateTime.now();
        String timingDifference = Utility.messageTimingDifference(messageTime, currentTime);
        System.out.println(messageStructure.getAuthor() + ": " + messageStructure.getMessage() + " (" + timingDifference + ")");
    }

}