import org.sql2o.*;
import java.util.*;

public class Client {
  private String clientName;
  private int id;

  public Client(String name) {
    this.clientName = name;
  }

  public String getClientName() {
    return clientName;
  }

  public int getClientId() {
    return id;
  }

  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO clients (clientName) VALUES (:clientName)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("clientName", this.clientName)
        .executeUpdate()
        .getKey();
    }
  }

  public static List<Client> allClients() {
    String sql = "SELECT id, clientName FROM clients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Client.class);
    }
  }

  public static Client find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM clients WHERE id=:id";
      Client client = con.createQuery(sql)
      .addParameter("id", id)
      .executeAndFetchFirst(Client.class);
      return client;
    }
  }

  public void delete() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "DELETE FROM clients WHERE id=:id";
      con.createQuery(sql)
      .addParameter("id", id)
      .executeUpdate();
    }
  }

  @Override
  public boolean equals(Object otherClient) {
    if (!(otherClient instanceof Client)) {
      return false;
    } else {
      Client newClient = (Client) otherClient;
      return this.getClientName().equals(newClient.getClientName()) &&
      this.getClientId() == newClient.getClientId();
    }
  }
}
