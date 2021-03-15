package feature;

import domain.MessageStructure;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FollowingTest {

    private static final String NAME = "Alice";

    private List<MessageStructure> messageStructureList;
    private Following following;

    @Before
    public void setUp() {
        messageStructureList = new ArrayList<>();
        following = new Following(messageStructureList);
    }

    @Test
    public void isFollowingReturnsFalse_whenNameIsPresentInTheList() {
        assertFalse(following.isFollowing(NAME));
    }

    @Test
    public void isFollowingReturnsTrue_whenNameIsPresentInTheList() {
        following.follow(NAME);
        assertTrue(following.isFollowing(NAME));
    }

    @Test
    public void viewAllMessagesReturnsFalse_whenFollowingListIsEmpty() {
        assertFalse(following.viewAllMessages());
    }

    @Test
    public void viewAllMessagesReturnsTrue_whenFollowingListIsNotEmpty() {
        MessageStructure messageStructure = new MessageStructure();
        messageStructure.setAuthor(NAME);
        messageStructure.setDateTime(LocalDateTime.now());
        messageStructureList.add(messageStructure);

        following.follow(NAME);

        assertTrue(following.viewAllMessages());
    }

    @Test
    public void whenCharliePublishingMessagesIsCalled_messageStructureListIsPopulated() {
        following.charliePublishingMessages();
        assertNotNull(messageStructureList.get(0));
    }

}