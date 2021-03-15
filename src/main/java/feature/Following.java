package feature;

import domain.MessageStructure;
import utility.Utility;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Following {

    private static final String NAME = "Charlie";

    private List<MessageStructure> messageStructureList;
    private List<String> followingList = new ArrayList<>();

    public Following(List<MessageStructure> messageStructureList) {
        this.messageStructureList = messageStructureList;
    }

    public boolean isFollowing(String name) {
        return followingList.contains(name);
    }

    public void follow(String name) {
        followingList.add(name);
    }

    public boolean viewAllMessages() {
        boolean areOtherMessagesFound = false;
        List<MessageStructure> sortedList = Utility.sortMessages(messageStructureList);
        for (MessageStructure messageStructure : sortedList) {
            if (followingList.contains(messageStructure.getAuthor())) {
                Utility.displayMessage(messageStructure);
                areOtherMessagesFound = true;
            }
            if (messageStructure.getAuthor().equals(NAME)) {
                Utility.displayMessage(messageStructure);
            }
        }
        return areOtherMessagesFound;
    }

    public void charliePublishingMessages() {
        MessageStructure messageStructure = new MessageStructure();
        messageStructure.setAuthor(NAME);
        messageStructure.setMessage("I'm in New York today! Anyone wants to have a coffee?");
        messageStructure.setDateTime(LocalDateTime.now().minusSeconds(10));
        messageStructureList.add(messageStructure);
    }

}