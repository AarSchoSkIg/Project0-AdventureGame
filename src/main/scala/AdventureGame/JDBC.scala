package AdventureGame

import AdventureGame.AdventurerTable.queryTable

import java.sql.{Connection, DriverManager, PreparedStatement, Statement}

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
      //Issue to fix later: This try catch block is creating two rows of Character data in the table when I only want one
      val statement = connection.createStatement()
      println("Inserting Adventurer details into table: ")
      var insertSQL = "INSERT INTO ADVENTURER VALUES (0, 'Hero', 15, 0, 'ShortSword', Null, Null)"

      connection.close()
    }
      catch {
        case e: Throwable => e.printStackTrace()
      }

      try {
        Class.forName(driver)
        connection = DriverManager.getConnection(url, username, password)
      // created a statement for getting all rows from Adventurer Table, and ran the select query
      val statement1 = connection.createStatement()
      val resultSet1 = statement1.executeQuery("SELECT * FROM Adventurer;")
      while (resultSet1.next()) {
        println(resultSet1.getString(1) + ", " + resultSet1.getString(2) + ", " + resultSet1.getString(3) + ", " + resultSet1.getString(4) + "," + resultSet1.getString(5) + "," + resultSet1.getString(6) + "," + resultSet1.getString(7))
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
      println("Viewing MonsterINDEPTHSTATS table")
      val statement2 = connection.createStatement()
      val resultSet2 = statement2.executeQuery("SELECT * FROM MONSTERINDEPTHSTATS;")
      while (resultSet2.next()) {
        println(resultSet2.getString(1) + ", " + resultSet2.getString(2) + ", " + resultSet2.getString(3) + ", " + resultSet2.getString(4))
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
      val statement3 = connection.createStatement()
      val resultSet3 = statement3.executeQuery("SELECT * FROM MONSTERINDEPTHSTATS;")
      while (resultSet3.next()) {
        println(resultSet3.getString(1) + ", " + resultSet3.getString(2) + ", " + resultSet3.getString(3) + ", " + resultSet3.getString(4))
      }
    }
      catch
      {
        case e: Throwable => e.printStackTrace()
      }
    //To do: (delete up to comment to remain after code is made) Comment to remain deleting Player table after game is won or after player quits
    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)

      val statement4 = connection.createStatement()
      def deleteTable(): Unit = {
        val gameWonScreen = println("You have won the game your character will now be deleted, Thank you for playing. Please enter 1 to exit game")
        val gameExitCharacterDeletion = scala.io.StdIn.readInt()
        

        }
      }
    }
    }
}