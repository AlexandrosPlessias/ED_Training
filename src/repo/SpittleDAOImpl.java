package repo;

import domain.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SpittleDAOImpl implements DAO{

    private final String table_name = "spittle";

    @Override
    public void create(Object obj) throws SQLException, ClassNotFoundException {

        Spittle sptl = (Spittle) obj;
        String query = "INSERT INTO "+table_name+" (message, time, latitude, longitude) " +
                        "VALUES ('"+sptl.getMessage()+"','"+ sptl.getTime()+"','"+
                         sptl.getLatitude()+ "', '"+sptl.getLontitude()+"')";

        try {
            DBConnection.getInstance().getConn().setSavepoint("Before user create");
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spittle msg <"+sptl.getMessage()+">, added to DB Successfully");
    }

    @Override
    public void read(Object obj) throws SQLException, ClassNotFoundException {

        Spittle sptl = (Spittle) obj;
        String query = "SELECT * " +
                       "FROM "+table_name +
                       " WHERE message = '" +sptl.getMessage()+"'";

        try {
            DBConnection.getInstance().getConn().setSavepoint("Before user read");
            Statement stmt = DBConnection.getInstance().getStmt();
            ResultSet results = stmt.executeQuery(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // STEP 5: Extract data from result set
            while (results.next()) {
                //Retrieve by column name
                String message = results.getString("message");
                String time = results.getString("time");
                String latitude = results.getString("latitude");
                String longitude = results.getString("longitude");

                //Display values
                System.out.print("message: " + message);
                System.out.print(", time: " + time);
                System.out.print(", latitude: " + latitude);
                System.out.print(", longitude: " + longitude + "\n");
            }
            results.close();
        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spittle msg <"+sptl.getMessage()+">, read was Successfully from DB");
    }

    @Override
    public void update(Object obj, String updateText) throws SQLException, ClassNotFoundException {

        Spittle sptl = (Spittle) obj;
        String query = "UPDATE " + table_name +
                       " SET message = '"+ updateText +
                       "' WHERE message = '" + sptl.getMessage() +"'";

        //Update Obj
        sptl.setMessage(updateText);

        try {
            DBConnection.getInstance().getConn().setSavepoint("Before user update");
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spittle msg <"+sptl.getMessage()+">, Update to DB was Successfully");
    }

    @Override
    public void delete(Object obj) throws SQLException, ClassNotFoundException {

        Spittle sptl = (Spittle) obj;
        String query = "DELETE FROM " + table_name +
                       " WHERE message = '" + sptl.getMessage() + "'";
        try {
            DBConnection.getInstance().getConn().setSavepoint("Before user delete");
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();
        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        System.out.println("Spittle msg <"+sptl.getMessage()+">, Deleted Successfully from DB");
    }
}
