package feature;

import domain.MessageStructure;

import java.time.LocalDateTime;
import java.util.List;

public class Publishing {

    private static final String NAME = "Alice";

    private List<MessageStructure> messageStructureList;

    public Publishing(List<MessageStructure> messageStructureList) {
        this.messageStructureList = messageStructureList;
    }

    public void postMessage(String message) {
        MessageStructure messageStructure = new MessageStructure();
        messageStructure.setAuthor(NAME);
        messageStructure.setMessage(message);
        messageStructure.setDateTime(LocalDateTime.now().minusMinutes(5));
        messageStructureList.add(messageStructure);
    }

    public boolean viewTimeline() {
        boolean isMessageFound = false;
        if (messageStructureList.size() > 0) {
            for (MessageStructure messageStructure : messageStructureList) {
                if (messageStructure.getAuthor().equals(NAME)) {
                    System.out.println(messageStructure.getAuthor() + ": " + messageStructure.getMessage());
                    isMessageFound = true;
                }
            }
        }
        if (!isMessageFound) {
            System.out.println("You have not posted a message yet");
        }
        return isMessageFound;
    }

}