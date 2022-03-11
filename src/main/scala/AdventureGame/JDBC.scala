package AdventureGame

import java.sql.DriverManager
import java.sql.Connection

object JDBC {
  def main(args: Array[String]) {
    // connect to the database named "mysql" on the localhost
    //val driver = "com.mysql.cj.jdbc.Driver"
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost/adventurewikidb"
    val username = "root"
    val password = "L0nkL1nkl3!"

    // there's probably a better way to do this
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // create the statement, and run the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM monstersandspecs;")
      while ( resultSet.next() ) {
        println(resultSet.getString(1)+", " +resultSet.getString(2) +", " +resultSet.getString(3) +", " +resultSet.getString(4))
      }
    } catch {
      case e: Throwable => e.printStackTrace
    }
    connection.close()
  }
}
