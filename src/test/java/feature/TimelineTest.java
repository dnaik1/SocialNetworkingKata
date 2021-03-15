package feature;

import domain.MessageStructure;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TimelineTest {

    private static final String NAME = "Bob";

    private List<MessageStructure> messageStructureList;
    private Timeline timeline;

    @Before
    public void setUp() {
        messageStructureList = new ArrayList<>();
        timeline = new Timeline(messageStructureList);
    }

    @Test
    public void viewBobTimelineReturnsFalse_whenMessagesAreNotFound() {
        assertFalse(timeline.viewBobTimeline());
    }

    @Test
    public void viewBobTimelineReturnsTrue_whenMessagesAreFound() {
        MessageStructure messageStructure = new MessageStructure();
        messageStructure.setAuthor(NAME);
        messageStructure.setDateTime(LocalDateTime.now());
        messageStructureList.add(messageStructure);

        assertTrue(timeline.viewBobTimeline());
    }

    @Test
    public void whenBobPublishingMessagesIsCalled_messageStructureListHasTwoElements() {
        timeline.bobPublishingMessages();
        assertEquals(2, messageStructureList.size());
    }

}