import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ClientTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/hair_salon_test", null, null);
  }

  @After
  public void tearDown() {
    try (Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients *;";
      con.createQuery(sql).executeUpdate();
    }
  }

  @Test
  public void newClient_instanceOfClient_true() {
    Client newClient = new Client("Richard");
    assertEquals(true, newClient instanceof Client);
  }

  @Test
  public void getClientName_returnsClientName_Richard() {
    Client newClient = new Client("Richard");
    assertEquals("Richard", newClient.getClientName());
  }

  @Test
  public void getClientId_returnsClientId() {
    Client newClient = new Client("Richard");
    newClient.save();
    assertEquals(true,newClient.getClientId() > 0);
  }

  @Test
  public void allClients_returnsAllClients() {
    Client newClient = new Client("Richard");
    newClient.save();
    assertEquals(true, Client.allClients().contains(newClient));
  }

  @Test
  public void find_returnsNewClient1() {
    Client newClient1 = new Client("Richard");
    Client newClient2 = new Client("John");
    newClient1.save();
    newClient2.save();
    assertEquals(newClient1, Client.find(newClient1.getClientId()));
  }

  @Test
  public void delete_deletesNewClient() {
    Client newClient = new Client("Richard");
    newClient.save();
    newClient.delete();
    assertEquals(null, Client.find(newClient.getClientId()));
  }
}
