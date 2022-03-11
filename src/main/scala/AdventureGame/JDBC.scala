package AdventureGame

import org.apache.arrow.util.AutoCloseables.close

import java.sql.{Connection, DriverManager, PreparedStatement, SQLException, Statement}

object JDBC {
  def main(args: Array[String]): Unit = {
    // connect to the database named "mysql" on the localhost
    //val driver = "com.mysql.cj.jdbc.Driver"
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost/adventurewikidb"
    val username = "root"
    val password = "L0nkL1nkl3!"

    // there's probably a better way to do this
    var connection: Connection = null

    

    //making a connection to MySQL adventurewikidb
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // created a statement for getting all rows from MonstersandSpecs Table, and ran the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM monstersandspecs;")
      while (resultSet.next()) {
        println(resultSet.getString(1) + ", " + resultSet.getString(2) + ", " + resultSet.getString(3) + ", " + resultSet.getString(4))
      }
      connection.close()
    } catch {
      case e: Throwable => e.printStackTrace()
    }
    //create a statement to view the Monsterindepthstats table before defense field is updated
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // created a statement for getting all rows from MONSTERINDEPTHSTATS Table, and ran the select query
      val statement1 = connection.createStatement()
      val resultSet1 = statement1.executeQuery("SELECT * FROM MONSTERINDEPTHSTATS;")
      while (resultSet1.next()) {
        println(resultSet1.getString(1) + ", " + resultSet1.getString(2) + ", " + resultSet1.getString(3) + ", " + resultSet1.getString(4))
      }
      connection.close()

      //create an update statement to update defense field of goblin to 1 in MONSTERINDEPTHSTATS table
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      val sqlUpdate = "UPDATE MONSTERINDEPTHSTATS " + "SET defense = ? " + "WHERE detailsid = ?"
      val pstmt: PreparedStatement = connection.prepareStatement(sqlUpdate)

      var defense = 1
      val detailsId: Int = 1

      pstmt.setInt(1, defense)
      pstmt.setInt(2, detailsId)
      var rowAffected = pstmt.executeUpdate()
      println(StringFormat("Row affected %d", rowAffected))

      pstmt.close()
      //view Monsterindepthstats table after update of defense to 1
      val statement2 = connection.createStatement()
      val resultSet2 = statement2.executeQuery("SELECT * FROM MONSTERINDEPTHSTATS;")
      while (resultSet2.next()) {
        println(resultSet2.getString(1) + ", " + resultSet2.getString(2) + ", " + resultSet2.getString(3) + ", " + resultSet2.getString(4))
      }
    }
      catch
      {
        case e: Throwable => e.printStackTrace()
      }
    }
}