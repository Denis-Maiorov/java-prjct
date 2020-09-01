import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TestHSQLDB {

    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        try {
            //java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/demodb --dbname.0 testdb
            //Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
            //connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/new_pmc", "root", "159753");
            if (connection!= null){
                System.out.println("Connection created successfully");

            }else{
                System.out.println("Problem with creating connection");
            }

        }  catch (Exception e) {
            e.printStackTrace(System.out);
        }
        //new CreatePatient().create("patients", "s", "f", "f", "111");
        //new CreatePatient().delete("patients", "5");
        //new CreatePatient().change("patients", "qq", "qqq", "f", "111", "1");
        //new CreatePatient().select("patients");

        //new CreateDoctor().create("doctors", "s", "f", "f", "111");
        //new CreateDoctor().delete("doctors", "0");
        //new CreateDoctor().change("doctors", "qq", "qqq", "f", "111", "1");
        //new CreateDoctor().select("doctors");

        //new CreateRecipe().create("recipe", "s", "f", "f", "111", "111", "111");
        //new CreateRecipe().delete("recipe", "0");
        //new CreateRecipe().change("recipe", "qwe", "qwe", "qwe", "qwe", "qwe", "qwe", "1");
        //new CreateRecipe().select("recipe");



    }
}
