package AdventureGame

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
    var connection:Connection = null

    try {
      // make the connection
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      // created a statement for getting all rows from MonstersandSpecs Table, and ran the select query
      val statement = connection.createStatement()
      val resultSet = statement.executeQuery("SELECT * FROM monstersandspecs;")
      while ( resultSet.next() ) {
        println(resultSet.getString(1)+", " +resultSet.getString(2) +", " +resultSet.getString(3) +", " +resultSet.getString(4))
      }
    } catch {
      case e: Throwable => e.printStackTrace()
    }
    //create an update statement to update fields in MonstersandSPecs for adding super secret boss
    try {
      val sqlUpdate = "UPDATE MONSTERINDEPTHSTATS " + "SET defense = ? " + "WHERE detailsid = ?"
      val  pstmt: PreparedStatement = connection.prepareStatement(sqlUpdate)

      var defense= 2
      val detailsId: Int = 1

      pstmt.setInt(1, defense)
      pstmt.setInt(2, detailsId)
      var rowAffected = pstmt.executeUpdate()
      println(StringFormat("Row affected %d", rowAffected))
      pstmt.close()
    }catch {
      case e: Throwable => e.printStackTrace()
    }

  }
}
