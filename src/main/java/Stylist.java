import org.sql2o.*;
import java.util.*;

public class Stylist {
  private String stylistName;
  private int id;

  public Stylist(String name) {
    this.stylistName = name;
  }

  public String getStylistName() {
    return stylistName;
  }

  public int getStylistId() {
    return id;
  }

  public static List<Stylist> allStylists() {
    String sql = "SELECT id, stylistName FROM stylists";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Stylist.class);
    }
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO stylists(stylistName) VALUES (:stylistName)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("stylistName", this.stylistName)
        .executeUpdate()
        .getKey();
    }
  }
}
