import domain.Spitter;
import services.Service;
import services.SpitterServiceImpl;

import java.sql.SQLException;


public class main {


    public static void main(String[] args)  {


        Spitter tempUser = new Spitter("Nikos_mvp","a&12345678", "mail@gmail.com", "Vasilis","NIkodimos","Hello f Splitter.");

        try {
            Service srv = new SpitterServiceImpl();
            srv.create(tempUser);
            srv.read(tempUser);

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }



    }

}