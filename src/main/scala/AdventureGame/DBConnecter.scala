package AdventureGame

import java.io.IOException
import java.sql.{Connection, DriverManager, ResultSet, SQLException, SQLIntegrityConstraintViolationException, Statement}

class DBConnecter {

  // connect to the database named "mysql" on the localhost
  val driver = "com.mysql.cj.jdbc.Driver"
  val url = "jdbc:mysql://localhost/dungeondesignerdb"
  val username = "root"
  var connection: Connection = null
  val password = "L0nkL1nkl3!"
  var statmnt: Statement = null
  var resultSet: ResultSet = null

  def connectionToDB(): Unit = {
    // there's probably a better way to do this

    if (connection == null)
      try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, "root", "L0nkL1nkl3!");
      } catch {
        case e: SQLException => e.printStackTrace();
      }
    else if (connection.isClosed)
      try {
        Class.forName(driver);
        connection = DriverManager.getConnection(url, "root", "L0nkL1nkl3!");
      } catch {
        case e: SQLException => e.printStackTrace();
      }
  }

  def disconnectFromDB(): Unit = {
    if (!connection.isClosed)
      connection.close();
    if (resultSet != null)
      if (!resultSet.isClosed)
        resultSet.close();
    if (statmnt != null)
      if (!statmnt.isClosed)
        statmnt.close();
  }

  def initiateDML(query: String): Option[Boolean] = {
    try {
      statmnt = connection.createStatement();
      Some(statmnt.execute(query));
    } catch {
      case e: SQLException => {
        e.printStackTrace();
        None;
      }
      case i: IOException => {
        i.printStackTrace();
        None;
      }
      case n: SQLIntegrityConstraintViolationException => {
        n.printStackTrace();
        None;
      }
    }
  }

  def initiateQuery(query: String): ResultSet = {
    try {
      statmnt = connection.createStatement();
      statmnt.executeQuery(query);
    } catch {
      case e: SQLException => {
        e.printStackTrace();
        null;
      }
      case i: IOException => {
        i.printStackTrace();
        null;
      }
      case n: SQLIntegrityConstraintViolationException => {
        n.printStackTrace();
        null;
      }
    }
  }
}