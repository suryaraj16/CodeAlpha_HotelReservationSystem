import java.util.ArrayList;
import java.util.Scanner;

public class HotelReservationSystem {

    static ArrayList<Room> rooms = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        // Add Rooms
        rooms.add(new Room(101, "Standard"));
        rooms.add(new Room(102, "Standard"));
        rooms.add(new Room(201, "Deluxe"));
        rooms.add(new Room(202, "Deluxe"));
        rooms.add(new Room(301, "Suite"));

        int choice;

        do {

            System.out.println("\n===== HOTEL RESERVATION SYSTEM =====");
            System.out.println("1. View Rooms");
            System.out.println("2. Book Room");
            System.out.println("3. Cancel Booking");
            System.out.println("4. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    viewRooms();
                    break;

                case 2:
                    bookRoom();
                    break;

                case 3:
                    cancelBooking();
                    break;

                case 4:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 4);
    }

    // View Rooms
    static void viewRooms() {

        System.out.println("\n--- ROOM DETAILS ---");

        for (Room room : rooms) {

            System.out.println(
                    "Room No: " + room.roomNumber +
                    " | Category: " + room.category +
                    " | Status: " + (room.isBooked ? "Booked" : "Available")
            );
        }
    }

    // Book Room
    static void bookRoom() {

        System.out.print("\nEnter Room Number to Book: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (!room.isBooked) {

                    room.isBooked = true;

                    System.out.println("Room Booked Successfully!");
                    System.out.println("Payment Successful!");

                } else {

                    System.out.println("Room Already Booked!");
                }

                return;
            }
        }

        System.out.println("Room Not Found!");
    }

    // Cancel Booking
    static void cancelBooking() {

        System.out.print("\nEnter Room Number to Cancel Booking: ");
        int roomNo = sc.nextInt();

        for (Room room : rooms) {

            if (room.roomNumber == roomNo) {

                if (room.isBooked) {

                    room.isBooked = false;

                    System.out.println("Booking Cancelled Successfully!");

                } else {

                    System.out.println("Room is Not Booked!");
                }

                return;
            }
        }

        System.out.println("Room Not Found!");
    }
}