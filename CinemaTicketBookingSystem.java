
package cinematicketbookingsystem;

import cinematicketbookingsystem.Database.EmbededDatabase;
import cinematicketbookingsystem.Forms.SignUp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class CinemaTicketBookingSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException {
        // TODO code application logic here
      //  openConnectionAndCheck();
     // new SignUp().setVisible(true);
        EmbededDatabase embd= new EmbededDatabase();
        embd.embedDatabase();
        new SignUp().setVisible(true);
    }
}
