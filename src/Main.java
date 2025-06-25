import java.text.ParseException;
import java.text.SimpleDateFormat;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        Service service = new Service();
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        service.SetUser(1,5000);
        service.SetUser(2,10000);

        service.SetRoom(1,RoomType.STANDARD , 1000);
        service.SetRoom(2,RoomType.JUNIOR , 2000);
        service.SetRoom(3,RoomType.MASTER , 3000);

        service.Reserver(1,2,date.parse("30/06/2026") ,date.parse("07/07/2026"));
        service.Reserver(1 , 2 ,date.parse("07/07/2026") , date.parse("30/06/2026")   );
        service.Reserver(1 , 1 ,date.parse("07/07/2026") , date.parse("08/07/2026") );


        service.Reserver(2,1,date.parse("07/07/2026"), date.parse("09/07/2026"));
        service.Reserver(2,3,date.parse("07/07/2026"), date.parse("08/07/2026"));

        service.SetRoom(1,RoomType.MASTER,10000);

        service.printAll();
        service.printAllUsers();





    }
}