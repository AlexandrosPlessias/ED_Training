package repo;

import domain.Spitter;
import domain.Spittle;

import java.sql.*;


public class SpittleDAOImpl implements DAO<Spittle>{

    private final String table_name = "spittle";

    @Override
    public Spittle create(Spittle sptl) throws SQLException, ClassNotFoundException {

        String query = "INSERT INTO "+table_name+" ( message, time, latitude, longitude, idSpitter) " +
                        "VALUES ( '"+sptl.getMessage()+"','"+ sptl.getTime()+"','"+
                         sptl.getLatitude()+ "', '"+sptl.getLontitude()+"', '"+sptl.getOwnerId()+"')";

        String keyQuery = "SELECT LAST_INSERT_ID()";


        try {
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

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
            sptl.setId(id);
            System.out.println("Spittle with id:"+sptl.getId()+", added to DB Successfully");
            return sptl;

        } catch ( SQLIntegrityConstraintViolationException e){
            System.err.println("Spittle already exists");
            return null ;

        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }
        return null;
    }

    @Override
    public Spittle read(Long id) throws SQLException, ClassNotFoundException {

        String query = "SELECT * " +
                       "FROM "+table_name +
                       " WHERE idSpittle = '" + id +"'";

        Spittle spittle = null;

        try {
            Statement stmt = DBConnection.getInstance().getStmt();
            ResultSet results = stmt.executeQuery(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // STEP 5: Extract data from result set
            while (results.next()) {

                //Retrieve by column name
                Long idSpittle = results.getLong("idSpittle");
                String message = results.getString("message");
                Date time = results.getDate("time");
                Double latitude = results.getDouble("latitude");
                Double longitude = results.getDouble("longitude");
                Long ownerId = results.getLong("idSpitter");

                spittle = new Spittle(idSpittle,message,time,latitude,longitude, idSpittle);
            }

            results.close();

        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
            return null;
        }

        if (spittle == null){
            System.err.println("Spittle  with id:"+ id +", don't exist in our DB.");
        } else {
            System.out.println("Spittle with id:"+ id +", read was Successfully from DB");
        }
        return spittle;
    }

    @Override
    public Spittle update(Long id, String updateText) throws SQLException, ClassNotFoundException {

        // Check if exists first.
        if (read(id)==null){
            return null;
        }

        String query = "UPDATE " + table_name +
                       " SET message = '"+ updateText +
                       "' WHERE idSpittle = '" + id +"'";

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

        System.out.println("Spittle with id:"+id+", Update to DB was Successfully");
        return read(id);
    }

    @Override
    public boolean delete(Long id) throws SQLException, ClassNotFoundException {

        // Check if exists first.
        if (read(id)==null){
            return false;
        }


        String query = "DELETE FROM " + table_name +
                " WHERE idSpittle = '" + id + "'";

        boolean delete = false;

        try {
            Statement stmt = DBConnection.getInstance().getStmt();
            stmt.executeUpdate(query);

            //Committing the transaction
            DBConnection.getInstance().getConn().commit();

            // flag updated.
            delete = true;

        } catch (SQLException e){
            System.err.print(e);
            e.printStackTrace();
            DBConnection.getInstance().getConn().rollback();
        }

        if (delete) {
            System.out.println("Spittle with id:"+id+", Deleted Successfully from DB");
        } else {
            System.err.println("Spittle with id:" + id + ", don't exist in our DB");

        }

        return delete;
    }

    @Override
    public boolean delete(Spittle sptl) throws SQLException, ClassNotFoundException {

        return delete(sptl.getId());

    }
}
