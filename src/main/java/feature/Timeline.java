package feature;

import domain.MessageStructure;
import utility.Utility;

import java.time.LocalDateTime;
import java.util.List;

public class Timeline {

    private static final String NAME = "Bob";

    private List<MessageStructure> messageStructureList;

    public Timeline(List<MessageStructure> messageStructureList) {
        this.messageStructureList = messageStructureList;
    }

    public boolean viewBobTimeline() {
        boolean isMessageFound = false;
        List<MessageStructure> sortedList = Utility.sortMessages(messageStructureList);
        for (MessageStructure messageStructure: sortedList) {
            if (messageStructure.getAuthor().equals(NAME)) {
                Utility.displayMessage(messageStructure);
                isMessageFound = true;
            }
        }
        if(!isMessageFound){
            System.out.println("You have not posted a message yet");
        }
        return isMessageFound;
    }

    public void bobPublishingMessages() {
        // First Message
        MessageStructure messageStructure1 = new MessageStructure();
        messageStructure1.setAuthor(NAME);
        messageStructure1.setMessage("Darn! We lost!");
        messageStructure1.setDateTime(LocalDateTime.now().minusMinutes(2));
        messageStructureList.add(messageStructure1);

        // Second Message
        MessageStructure messageStructure2 = new MessageStructure();
        messageStructure2.setAuthor(NAME);
        messageStructure2.setMessage("Good game though.");
        messageStructure2.setDateTime(LocalDateTime.now().minusMinutes(1));
        messageStructureList.add(messageStructure2);
    }

}