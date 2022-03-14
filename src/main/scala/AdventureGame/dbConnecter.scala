package AdventureGame

import java.sql.{Connection, DriverManager}

class dbConnecter {

  def connectionToDB(): Connection = {
    // there's probably a better way to do this
    val connection: Connection = null

    // connect to the database named "mysql" on the localhost
    val driver = "com.mysql.cj.jdbc.Driver"
    val url = "jdbc:mysql://localhost/adventurewikidb"
    val username = "root"
    val password = "L0nkL1nkl3!"
    try{
      Class.forName(driver)
      var connection = DriverManager.getConnection(url, username, password)
    } catch {
      case e: Exception => e.printStackTrace()
    }
    return connection
  }

}
