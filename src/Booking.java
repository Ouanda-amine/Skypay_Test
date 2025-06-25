import java.util.Date;

public class Booking {
    User userSnapshot;
    Room roomSnapshot;
    Date checkIn;
    Date checkOut;

    public Booking(User user , Room room ,Date checkIn , Date checkOut){
        this.userSnapshot = new User(user.id, user.balance);
        this.roomSnapshot = new Room(room.nbrRoom , room.type,room.prixParNuit);
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

}
