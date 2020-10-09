package spittr.persistence;

import spittr.domain.Spitter;
import org.springframework.stereotype.Component;

import java.sql.*;

@Component
public class SpitterDAOImpl implements DAO<Spitter> {

    private final String table_name = "spitter";

    public Spitter create(Spitter sp) throws SQLException, ClassNotFoundException {

        String insertQuery = "INSERT INTO "+table_name+" ( username, password, email, firstname, lastname, description) " +
                        "VALUES ( '" +sp.getUsername()+"', '"+sp.getPassword()+"', '"+sp.getEmail()+"', '" +
                        sp.getFirstName()+"', '" +sp.getLastName()+"', '"+sp.getDescription()+"')";

        String keyQuery = "SELECT LAST_INSERT_ID()";

        try{
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(insertQuery);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // Get last ID (the one just inserted).
            Long id = null;
            ResultSet results = stmt.executeQuery(keyQuery);

            if (results.next()) {
                id = Long.valueOf(results.getInt(1));
            }

            results.close();

            // Update obj and return it.
            sp.setId(id);
            System.out.println("Spitter with id:"+sp.getId()+", added to DB Successfully");
            return sp;

        } catch (SQLIntegrityConstraintViolationException e){
            System.err.println("Spitter already exists");
            return null;
        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        return null;

    }

    public Spitter read(Long id) throws SQLException, ClassNotFoundException {

        String query = "SELECT * " +
                        "FROM "+table_name+" " +
                        "WHERE idSpitter = '"+ id +"'";

        Spitter spitter = null;

        try {
            Statement stmt = DBConnection.getInstance().getStmt();
            ResultSet results = stmt.executeQuery(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // STEP 5: Extract data from result set
            while(results.next()){

                //Retrieve by column name
                Long idSpitter = results.getLong("idSpitter");
                String username  = results.getString("username");
                String password = results.getString("password");
                String email = results.getString("email");
                String fname = results.getString("firstName");
                String lname = results.getString("lastName");
                String desc = results.getString("description");

                spitter = new Spitter(idSpitter, username,password,email,fname,lname, desc);
            }
            results.close();

        }catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        if (spitter == null){
            System.err.println("Spitter with id:"+id+", don't exist in our DB.");
        }else{
            System.out.println("Spitter with id: "+id+", read was Successfully from DB");
        }

        return spitter;

    }

    public Spitter update(Long id, String updateText) throws SQLException, ClassNotFoundException {

        // Check if exists first.
        if (read(id)==null){
            return null;
        }

        String updateQuery = "UPDATE "+table_name+" " +
                        "SET description = '"+updateText+"' " +
                        "WHERE idSpitter = '" + id +"'";

        try{
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(updateQuery);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

        }catch (SQLException e){
            DBConnection.getInstance().getConn().rollback();
            System.err.print(e);
            e.printStackTrace();
        }

        System.out.println("Spitter with id:"+ id +", Desc updated to our DB was Successfully");
        return read(id);
    }

    public boolean delete(Long id) throws SQLException, ClassNotFoundException {

        // Check if exists first.
        if (read(id)==null){
            return false;
        }


        String query = "DELETE FROM "+table_name+" WHERE idSpitter = '" + id +"'";
        boolean delete = false;

        try{
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // flag updated.
            delete = true;

        }catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        if (delete){
            System.out.println("Spitter with id:"+ id +", Deleted Successfully from our DB");
        } else {
            System.err.println("Spitter with id:"+ id +", don't exist in our DB");
        }
        return delete;
    }

    public boolean delete(Spitter sp) throws SQLException, ClassNotFoundException {

        return delete(sp.getId());

    }
}
