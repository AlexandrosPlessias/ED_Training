package repo;

import domain.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

public class SpitterDAOImpl implements DAO {

    private final String table_name = "spitter";

    @Override
    public void create(Object obj) throws SQLException, ClassNotFoundException {

        Spitter sp = (Spitter) obj;
        String query = "INSERT INTO "+table_name+" (username, password, email, firstname, lastname, description) " +
                        "VALUES ('" +sp.getUsername()+"', '"+sp.getPassword()+"', '"+sp.getEmail()+"', '" +
                        sp.getFirstName()+"', '" +sp.getLastName()+"', '"+sp.getDescription()+"')";

        try {
            DBConnection.getInstance().getConn().setSavepoint("Before user create");
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        } catch (SQLException e){
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spitter "+sp.getUsername()+", added to DB Successfully");
    }

    @Override
    public void read(Object obj) throws SQLException, ClassNotFoundException {

        Spitter sp = (Spitter) obj;
        String query = "SELECT * " +
                        "FROM "+table_name+" " +
                        "WHERE username = '"+sp.getUsername()+"'";

        try {
            DBConnection.getInstance().getConn().setSavepoint("Before user read");
            Statement stmt = DBConnection.getInstance().getStmt();
            ResultSet results = stmt.executeQuery(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // STEP 5: Extract data from result set
            while(results.next()){
                //Retrieve by column name
                String username  = results.getString("username");
                String password = results.getString("password");
                String email = results.getString("email");
                String fname = results.getString("firstName");
                String lname = results.getString("lastName");
                String desc = results.getString("description");

                //Display values
                System.out.print("user: " + username);
                System.out.print(", password: " + password);
                System.out.print(", email: " + email);
                System.out.print(", fname: " + fname);
                System.out.print(", lname: " + lname);
                System.out.print(", desc: " + desc + "\n");
            }
            results.close();

        }catch (SQLException e){
            DBConnection.getInstance().getConn().rollback();
        }



        System.out.println("Spitter : "+sp.getUsername()+", read was Successfully from DB");
    }

    @Override
    public void update(Object obj, String updateText) throws SQLException, ClassNotFoundException {

        Spitter sp = (Spitter) obj;
        String query = "UPDATE "+table_name+" " +
                        "SET description = '"+updateText+"' " +
                        "WHERE username = '" +sp.getUsername()+"'";

        try{
            DBConnection.getInstance().getConn().setSavepoint("Before user update");
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        }catch (SQLException e){
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spitter: "+sp.getUsername()+", Update desc to DB was Successfully");
    }

    @Override
    public void delete(Object obj) throws SQLException, ClassNotFoundException {

        Spitter sp = (Spitter) obj;
        String query = "DELETE FROM "+table_name+" WHERE username = '" +sp.getUsername()+"'";

        try{
            DBConnection.getInstance().getConn().setSavepoint("Before user delete");
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

        }catch (SQLException e){
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spitter: "+sp.getUsername()+", Deleted Successfully from DB");
    }
}
