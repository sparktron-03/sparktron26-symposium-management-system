import java.util.ArrayList;
import java.util.Scanner;

class Event {

    String eventName;
    String eventDate;
    String eventType;

    Event(String eventName, String eventDate, String eventType) {

        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventType = eventType;
    }

    void displayEvent() {

        System.out.println("\nEvent Type : " + eventType);
        System.out.println("Event Name : " + eventName);
        System.out.println("Event Date : " + eventDate);
        System.out.println("----------------------------------");
    }
}

public class CollegeEventManagement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Event> events = new ArrayList<>();

        int choice;

        do {

            System.out.println("\n========================================");
            System.out.println(" Thamirabarani Engineering College ");
            System.out.println(" SPARKTRON'26 Symposium Management ");
            System.out.println("========================================");

            System.out.println("1. Add Event");
            System.out.println("2. View Events");
            System.out.println("3. Delete Event");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                case 1:

                    System.out.println("\nSelect Event Type");
                    System.out.println("1. Technical Event");
                    System.out.println("2. Non-Technical Event");

                    System.out.print("Enter choice: ");
                    int typeChoice = sc.nextInt();
                    sc.nextLine();

                    String eventType;

                    if(typeChoice == 1) {
                        eventType = "Technical";
                    } else {
                        eventType = "Non-Technical";
                    }

                    System.out.print("Enter Event Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Event Date: ");
                    String date = sc.nextLine();

                    events.add(new Event(name, date, eventType));

                    System.out.println("\nEvent Added Successfully!");
                    break;

                case 2:

                    if(events.isEmpty()) {

                        System.out.println("\nNo Events Available.");

                    } else {

                        System.out.println("\n===== Event Details =====");

                        for(Event e : events) {

                            e.displayEvent();
                        }
                    }

                    break;

                case 3:

                    if(events.isEmpty()) {

                        System.out.println("\nNo Events Available to Delete.");

                    } else {

                        System.out.println("\n===== Event List =====");

                        for(int i = 0; i < events.size(); i++) {

                            System.out.println((i + 1) + ". " + events.get(i).eventName);
                        }

                        System.out.print("Enter Event Number to Delete: ");
                        int deleteIndex = sc.nextInt();

                        if(deleteIndex > 0 && deleteIndex <= events.size()) {

                            events.remove(deleteIndex - 1);

                            System.out.println("Event Deleted Successfully!");

                        } else {

                            System.out.println("Invalid Event Number!");
                        }
                    }

                    break;

                case 4:

                    System.out.println("\nExiting Program...");
                    System.out.println("Thank You!");
                    break;

                default:

                    System.out.println("\nInvalid Choice!");
            }

        } while(choice != 4);

        sc.close();
    }
}
