package repo;

import domain.Spitter;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

// public void insert(Spittle spittle)

public class SpitterDAOImpl implements DAO<Spitter> {

    private final String table_name = "spitter";

    @Override
    public void create(Spitter sp) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO "+table_name+" (idSpitter, username, password, email, firstname, lastname, description) " +
                        "VALUES ( '"+sp.getId()+"', '" +sp.getUsername()+"', '"+sp.getPassword()+"', '"+sp.getEmail()+"', '" +
                        sp.getFirstName()+"', '" +sp.getLastName()+"', '"+sp.getDescription()+"')";

        try{
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spitter "+sp.getUsername()+", added to DB Successfully");
    }

    @Override
    public void read(Spitter sp) throws SQLException, ClassNotFoundException {

        String query = "SELECT * " +
                        "FROM "+table_name+" " +
                        "WHERE idSpitter = '"+sp.getId()+"'";

        try {
            Statement stmt = DBConnection.getInstance().getStmt();
            ResultSet results = stmt.executeQuery(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // STEP 5: Extract data from result set
            while(results.next()){
                //Retrieve by column name
                int id = results.getInt("idSpitter");
                String username  = results.getString("username");
                String password = results.getString("password");
                String email = results.getString("email");
                String fname = results.getString("firstName");
                String lname = results.getString("lastName");
                String desc = results.getString("description");

                //Display values
                System.out.print("id: " + id);
                System.out.print(", user: " + username);
                System.out.print(", password: " + password);
                System.out.print(", email: " + email);
                System.out.print(", fname: " + fname);
                System.out.print(", lname: " + lname);
                System.out.print(", desc: " + desc + "\n");
            }
            results.close();

        }catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }



        System.out.println("Spitter : "+sp.getUsername()+", read was Successfully from DB");
    }

    @Override
    public void update(Spitter sp, String updateText) throws SQLException, ClassNotFoundException {

        String query = "UPDATE "+table_name+" " +
                        "SET description = '"+updateText+"' " +
                        "WHERE idSpitter = '" +sp.getId()+"'";

        try{
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        }catch (SQLException e){
            DBConnection.getInstance().getConn().rollback();
            System.err.print(e);
            e.printStackTrace();
        }

        System.out.println("Spitter: "+sp.getUsername()+", Update desc to DB was Successfully");
    }

    @Override
    public void delete(Spitter sp) throws SQLException, ClassNotFoundException {

        String query = "DELETE FROM "+table_name+" WHERE idSpitter = '" +sp.getId()+"'";

        try{
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

        }catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spitter: "+sp.getUsername()+", Deleted Successfully from DB");
    }
}
