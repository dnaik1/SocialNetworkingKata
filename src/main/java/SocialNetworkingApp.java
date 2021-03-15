import domain.MessageStructure;
import feature.Following;
import feature.Publishing;
import feature.Timeline;

import java.util.ArrayList;
import java.util.List;

public class SocialNetworkingApp {

    private static List<MessageStructure> messageStructureList = new ArrayList<>();

    public static void main(String[] args) {
        Publishing publishing = new Publishing(messageStructureList);
        Timeline timeline = new Timeline(messageStructureList);
        Following following = new Following(messageStructureList);

        Menu menu = new Menu(publishing, timeline, following);
        menu.displayMainMenu();
    }

}