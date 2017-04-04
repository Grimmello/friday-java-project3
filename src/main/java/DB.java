import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.sql2o.*;

public class DB {
  private String db_host;
  private String db_port;
  private String db_name;

  public void db() {
    Properties prop = new Properties();
    InputStream input = null;


    try {
      input = new FileInputStream("config.properties");
      prop.load(input);
      db_host=prop.getProperty("db_host");
      db_port=prop.getProperty("db_port");
      db_name=prop.getProperty("db_name");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
  String sql2oOutput = String.format("jdbc:postgresql://%s:%s2/%s3",db_host,db_port,db_name);
  public Sql2o sql2o = new Sql2o(sql2oOutput, null, null);
}
