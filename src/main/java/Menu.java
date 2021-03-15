import feature.Following;
import feature.Publishing;
import feature.Timeline;

import java.util.Scanner;

public class Menu {

    private Publishing publishing;
    private Timeline timeline;
    private Following following;

    public Menu(Publishing publishing, Timeline timeline, Following following) {
        this.publishing = publishing;
        this.timeline = timeline;
        this.following = following;
    }

    public void displayMainMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Social Networking App");

        while (true) {
            System.out.println("To use Feature 1 (Publishing), Enter 1");
            System.out.println("To use Feature 2 (Timeline), Enter 2");
            System.out.println("To use Feature 3 (Following), Enter 3");
            printEnterExitMessage();

            printEnterYourChoiceMessage();
            int choice = scan.nextInt();
            mainMenu(choice);
        }
    }

    private void mainMenu(int choice) {
        switch (choice) {
            case 1:
                displayPublishingMenu();
                break;
            case 2:
                displayTimelineMenu();
                break;
            case 3:
                displayFollowingMenu();
                break;
            case 0:
                System.out.println("Thank you and Good Bye!");
                System.exit(0);
            default:
                printIncorrectInputMessage();
        }
    }

    private void displayPublishingMenu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Publishing Feature");

        while (true) {
            System.out.println("To Post the Message, Enter 1");
            System.out.println("To View own Timeline, Enter 2");
            printEnterExitMessage();

            printEnterYourChoiceMessage();
            int choice = scan.nextInt();
            publishingMenu(choice);
        }
    }

    private void publishingMenu(int choice) {
        switch (choice) {
            case 1:
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter your Message:");
                publishing.postMessage(scan.nextLine());
                System.out.println("Message has been Posted");
                break;
            case 2:
                publishing.viewTimeline();
                break;
            case 0:
                printBackToMainMenuMessage();
                SocialNetworkingApp.main(new String[]{});
                break;
            default:
                printIncorrectInputMessage();
        }
    }

    private void displayTimelineMenu() {
        timeline.bobPublishingMessages();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Publishing Feature");

        while (true) {
            System.out.println("To View Bob's Timeline, Enter 1");
            printEnterExitMessage();

            printEnterYourChoiceMessage();
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    timeline.viewBobTimeline();
                    break;
                case 0:
                    printBackToMainMenuMessage();
                    SocialNetworkingApp.main(new String[]{});
                    break;
                default:
                    printIncorrectInputMessage();
            }
        }
    }

    private void displayFollowingMenu() {
        following.charliePublishingMessages();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to the Publishing Feature");

        while (true) {
            System.out.println("To Follow Alice, Enter 1");
            System.out.println("To Follow Bob, Enter 2");
            System.out.println("To View Own Wall, Enter 3");
            printEnterExitMessage();

            printEnterYourChoiceMessage();
            int choice = scan.nextInt();

            switch (choice) {
                case 1:
                    String name1 = "Alice";
                    if (following.isFollowing(name1)) {
                        System.out.println("You are already Following Alice");
                    } else {
                        following.follow(name1);
                        System.out.println("Now You are Following Alice");
                    }
                    break;
                case 2:
                    String name2 = "Bob";
                    if (following.isFollowing(name2)) {
                        System.out.println("You are already Following Bob");
                    } else {
                        following.follow(name2);
                        System.out.println("Now You are Following Bob");
                    }
                    break;
                case 3:
                    following.viewAllMessages();
                    break;
                case 0:
                    printBackToMainMenuMessage();
                    SocialNetworkingApp.main(new String[]{});
                    break;
                default:
                    printIncorrectInputMessage();
            }
        }
    }

    private void printEnterYourChoiceMessage() {
        System.out.println("Enter your choice:");
    }

    private void printEnterExitMessage() {
        System.out.println("To Exit, Enter 0");
    }

    private void printBackToMainMenuMessage() {
        System.out.println("Back to Main Menu");
    }

    private void printIncorrectInputMessage() {
        System.out.println("Incorrect input! Please re-enter a valid choice from the menu");
    }

}