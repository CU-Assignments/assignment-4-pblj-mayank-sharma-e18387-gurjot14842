import java.util.*;

class TicketBookingSystem {
    private static final int TOTAL_SEATS = 10;
    private final boolean[] seats = new boolean[TOTAL_SEATS];

    // Synchronized method to book a seat
    public synchronized boolean bookSeat(int seatNumber) {
        if (seatNumber < 0 || seatNumber >= TOTAL_SEATS || seats[seatNumber]) {
            return false; // Seat already booked or invalid
        }
        seats[seatNumber] = true;
        return true;
    }

    public void displaySeats() {
        System.out.print("Seats: ");
        for (int i = 0; i < TOTAL_SEATS; i++) {
            System.out.print((seats[i] ? "[Booked]" : "[Available]") + " ");
        }
        System.out.println();
    }
}

class BookingThread extends Thread {
    private final TicketBookingSystem system;
    private final int seatNumber;

    public BookingThread(TicketBookingSystem system, int seatNumber, String name) {
        super(name);
        this.system = system;
        this.seatNumber = seatNumber;
    }

    @Override
    public void run() {
        if (system.bookSeat(seatNumber)) {
            System.out.println(getName() + " successfully booked seat " + seatNumber);
        } else {
            System.out.println(getName() + " failed to book seat " + seatNumber + ". Already booked or invalid seat.");
        }
    }
}

public class TicketBookingMain {
    public static void main(String[] args) {
        TicketBookingSystem bookingSystem = new TicketBookingSystem();

        // Display initial seat status
        bookingSystem.displaySeats();

        // Simulate booking threads
        Thread vip1 = new BookingThread(bookingSystem, 2, "VIP 1");
        Thread vip2 = new BookingThread(bookingSystem, 5, "VIP 2");
        Thread regular1 = new BookingThread(bookingSystem, 2, "Regular 1");
        Thread regular2 = new BookingThread(bookingSystem, 7, "Regular 2");

        // Set thread priorities (higher priority for VIPs)
        vip1.setPriority(Thread.MAX_PRIORITY);
        vip2.setPriority(Thread.MAX_PRIORITY);
        regular1.setPriority(Thread.NORM_PRIORITY);
        regular2.setPriority(Thread.NORM_PRIORITY);

        // Start threads
        vip1.start();
        vip2.start();
        regular1.start();
        regular2.start();

        // Wait for all threads to finish
        try {
            vip1.join();
            vip2.join();
            regular1.join();
            regular2.join();
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        // Display final seat status
        bookingSystem.displaySeats();
    }
}
