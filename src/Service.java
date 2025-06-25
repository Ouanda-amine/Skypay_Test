import java.util.ArrayList;
import java.util.Date;

public class Service {

    ArrayList<User> users  = new ArrayList<>();
    ArrayList<Room> rooms = new ArrayList<>();
    ArrayList<Booking> bookings = new ArrayList<>();

    public void SetRoom(int roomnbr , RoomType roomtype , int pricePernight){
        for (Room room : rooms){
            if(roomnbr==room.nbrRoom){
                System.out.println("room already exist");
                return;
            }

        }
        rooms.add(0 , new Room(roomnbr , roomtype , pricePernight));
    }

    public void SetUser(int UserId , int balance ){
        for (User user : users){
            if(user.id == UserId){
                System.out.println("User already exist");
                return;
            }

        }
        users.add(0,new User(UserId , balance));
    }

    public void Reserver(int idUser , int roomnbr , Date checkin , Date checkout ){
        if(!checkin.before(checkout)){
            System.out.println("date invalide");
            return;
        }

        Room room = rooms.stream().filter(r->r.nbrRoom==roomnbr).findFirst().orElse(null);
        if (room == null){
            System.out.println("room not found");
            return;
        }

        User user = users.stream().filter(u->u.id==idUser).findFirst().orElse(null);

        if (user == null){
            System.out.println("user not found");
            return;
        }

        for(Booking b : bookings){
            if (b.roomSnapshot.nbrRoom == roomnbr) {
                if (!(checkout.before(b.checkIn) || checkin.after(b.checkOut))) {
                    System.out.println("room not available");
                    return;
                }
            }

        }

        long nights = (checkout.getTime() - checkin.getTime()) / (1000 * 60 * 60 * 24) ;
        int total = (int) nights * room.prixParNuit;

        if (user.balance < total){
            System.out.println("sold insuffisant");
            return;
        }

        user.balance -= total;
        bookings.add(0 , new Booking(user , room , checkin , checkout));

    }
    public  void printAll(){
        for (Room r : rooms){
            System.out.println("Room_Number : " +r.nbrRoom + "Room_Type : " +r.type + "Room_PricePerNight : " +r.prixParNuit  );
        }
        for(Booking b : bookings){
            long nights = (b.checkOut.getTime() - b.checkIn.getTime()) / (1000 * 60 * 60 * 24);
            int total = (int) nights * b.roomSnapshot.prixParNuit;
            System.out.println("Booking_user : " + b.userSnapshot.id +
                    ", Room_number : " + b.roomSnapshot.nbrRoom +
                    ", Check_in : " + b.checkIn +
                    ", Check_Out : " + b.checkOut +
                    ", Total : " + total + " DH");



        }
    }
    public void printAllUsers() {
        for (User u : users)
            System.out.println("User: " + u.id + " Balance: " + u.balance);
    }

}
