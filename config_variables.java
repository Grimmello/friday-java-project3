
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import org.sql2o.*;

public class DB {
  public static String db_host;
  public static String db_port;
  public static String db_name;
  public static String db_test_name;
  public static String prodDatabase;
  public static String testDatabase;

  public static void main(String[] args) {
    db();
  }


  public static void db() {
    Properties prop = new Properties();
    InputStream input;


    try {
      String filename = "config.properties";
      input = new FileInputStream(filename);
      if (input == null) {
        System.out.println("Sorry, unable to find " + filename);
      }
      prop.load(input);
      String db_host = prop.getProperty("dbhost","localhost");
      String db_port = prop.getProperty("dbport","5432");
      String db_name = prop.getProperty("dbname","hair_salon");
      String db_test_name = prop.getProperty("dbtestname","hair_salon_test");

      String prodDatabase = String.format("jdbc:postgresql://%1$s:%2$s/%3$s",db_host,db_port,db_name);
      String testDatabase = String.format("jdbc:postgresql://%1$s:%2$s/%3$s",db_host,db_port,db_test_name);

    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static Sql2o sql2o = new Sql2o(prodDatabase, null, null);
}
