package AdventureGame

import java.sql.PreparedStatement


object AdventurerTable {

  def createNewAdventurer(ADVENTURERID: Int, AVENTURERNAME: String, health: Int, DEFENSE: Int= 0, WEAPON: String, LOOT: String, MONSTERSKILLED: Int = 0): Unit = {

    val dbConnect = new dbConnecter
    val connection = dbConnect.connectionToDB()


    //To do: creating a table for Player character and inserting into that table value of what the player chose to have as well as inventory and weapons
    val statement = connection.createStatement()
    val resultSet = s"INSERT INTO adventurerwikidb.ADVENTURER (ADVENTURERID: Int, AVENTURERNAME: String, HEALTH: Int, DEFENSE: Int= 0, WEAPON: String, LOOT: String, MONSTERSKILLED: Int = 0) VALUES (?, ?, ?, ?, ?, ?, ?)"
    val prepstmt : PreparedStatement = connection.prepareStatement(resultSet)
  }

  //Method for User to create a name for their character/adventurer
  def getAdventurerName(id: Int): Unit = {
    //create a new connection to the database
    val dbConnect = new dbConnecter
    val connection = dbConnect.connectionToDB()

    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT * FROM Adventurer WHERE ADVENTURERID = $id")
    var adventurerName = ""
    while(resultSet.next) {
      adventurerName += resultSet.getString("AdventurerName")
    }
  }



}