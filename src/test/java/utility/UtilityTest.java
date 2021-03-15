package utility;

import domain.MessageStructure;
import org.junit.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class UtilityTest {

    @Test
    public void expectedJustNowDateTimeDifference_whenTheMessagePostedTimeAndCurrentTimeIsEquals(){
        String resultString = Utility.messageTimingDifference(LocalDateTime.now(), LocalDateTime.now());
        assertEquals("Just Now", resultString);
    }

    @Test
    public void expectedSecondsDateTimeDifference_whenTheMessageWasPostedAFewSecondsAgo(){
        String resultString = Utility.messageTimingDifference(LocalDateTime.now().minusSeconds(5), LocalDateTime.now());
        assertEquals("5 second(s) ago", resultString);
    }

    @Test
    public void expectedMinutesDateTimeDifference_whenTheMessageWasPostedAFewMinutesAgo(){
        String resultString = Utility.messageTimingDifference(LocalDateTime.now().minusMinutes(10), LocalDateTime.now());
        assertEquals("10 minute(s) ago", resultString);
    }

    @Test
    public void expectedHoursDateTimeDifference_whenTheMessageWasPostedAFewHoursAgo(){
        String resultString = Utility.messageTimingDifference(LocalDateTime.now().minusHours(1), LocalDateTime.now());
        assertEquals("1 hour(s) ago", resultString);
    }

    @Test
    public void expectedDaysDateTimeDifference_whenTheMessageWasPostedAFewDaysAgo(){
        String resultString = Utility.messageTimingDifference(LocalDateTime.now().minusDays(2), LocalDateTime.now());
        assertEquals("2 day(s) ago", resultString);
    }

    @Test
    public void expectASortedListByTime_whenTheListHasMoreThanOneElement() {
        MessageStructure messageStructure1 = new MessageStructure();
        messageStructure1.setAuthor("Alice");
        messageStructure1.setDateTime(LocalDateTime.now().minusMinutes(2));

        MessageStructure messageStructure2 = new MessageStructure();
        messageStructure2.setAuthor("Bob");
        messageStructure2.setDateTime(LocalDateTime.now().minusMinutes(1));

        List<MessageStructure> messageStructureList = new ArrayList<>();
        messageStructureList.add(messageStructure1);
        messageStructureList.add(messageStructure2);

        List<MessageStructure> sortedList = Utility.sortMessages(messageStructureList);
        assertEquals(messageStructure2, sortedList.get(0));
        assertEquals(messageStructure1, sortedList.get(1));
    }

}