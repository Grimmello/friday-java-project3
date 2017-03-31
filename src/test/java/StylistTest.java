import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class StylistTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM stylists *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void newStylist_instanceOfStylist_true() {
    Stylist newStylist = new Stylist("Jack");
    assertEquals(true, newStylist instanceof Stylist);
  }

  @Test
  public void newStylist_getStylistName_Jack() {
    Stylist newStylist = new Stylist("Jack");
    assertEquals("Jack", newStylist.getStylistName());
  }

  @Test
  public void newStylist_getStylistName_Jack() {
    Stylist newStylist = new Stylist("Jack");
    newStylist.save();
    assertEquals(true, );
  }
}
