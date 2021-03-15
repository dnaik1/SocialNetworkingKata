package feature;

import domain.MessageStructure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PublishingTest {

    private static final String NAME = "Alice";

    private List<MessageStructure> messageStructureList;
    private Publishing publishing;

    @Before
    public void setUp() {
        messageStructureList = new ArrayList<>();
        publishing = new Publishing(messageStructureList);
    }

    @Test
    public void whenPostMessageIsCalled_messageStructureListIsPopulated() {
        publishing.postMessage(NAME);

        MessageStructure messageStructure = messageStructureList.get(0);
        assertEquals(1, messageStructureList.size());
        assertNotNull(messageStructure);
        Assert.assertEquals(NAME, messageStructure.getAuthor());
    }

    @Test
    public void viewTimelineReturnsFalse_whenMessagesAreNotFound() {
        assertFalse(publishing.viewTimeline());
    }

    @Test
    public void viewTimelineReturnsTrue_whenMessagesAreFound() {
        MessageStructure messageStructure = new MessageStructure();
        messageStructure.setAuthor(NAME);
        messageStructure.setDateTime(LocalDateTime.now());
        messageStructureList.add(messageStructure);

        assertTrue(publishing.viewTimeline());
    }

}