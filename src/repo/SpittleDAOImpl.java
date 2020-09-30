package repo;

import domain.Spittle;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class SpittleDAOImpl implements DAO<Spittle>{

    private final String table_name = "spittle";

    @Override
    public void create(Spittle sptl) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO "+table_name+" (idSpittle, message, time, latitude, longitude) " +
                        "VALUES ('"+sptl.getId()+"', '"+sptl.getMessage()+"','"+ sptl.getTime()+"','"+
                         sptl.getLatitude()+ "', '"+sptl.getLontitude()+"')";

        try {
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
    public void read(Spittle sptl) throws SQLException, ClassNotFoundException {

        String query = "SELECT * " +
                       "FROM "+table_name +
                       " WHERE idSpittle = '" +sptl.getId()+"'";

        try {
            Statement stmt = DBConnection.getInstance().getStmt();
            ResultSet results = stmt.executeQuery(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // STEP 5: Extract data from result set
            while (results.next()) {
                //Retrieve by column name
                int id = results.getInt("idSpittle");
                String message = results.getString("message");
                String time = results.getString("time");
                String latitude = results.getString("latitude");
                String longitude = results.getString("longitude");

                //Display values
                System.out.print("idSpittle: " + id);
                System.out.print(", message: " + message);
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
    public void update(Spittle sptl, String updateText) throws SQLException, ClassNotFoundException {

        String query = "UPDATE " + table_name +
                       " SET message = '"+ updateText +
                       "' WHERE idSpittle = '" + sptl.getId() +"'";

        //Update Obj
        sptl.setMessage(updateText);

        try {
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
    public void delete(Spittle sptl) throws SQLException, ClassNotFoundException {

        String query = "DELETE FROM " + table_name +
                       " WHERE idSpittle = '" + sptl.getId() + "'";
        try {
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
