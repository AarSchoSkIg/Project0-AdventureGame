/*
/*package AdventureGame


import java.sql.PreparedStatement


class Adventurer extends Creature {

//example of how to do a delete statement
  /*def deletePlayer(player_id : Int) : Unit = {
    connectionToDB();
    initiateDML(s"delete from salerates where player_id = $player_id;");
    disconnectFromDB();
  }*/

  //Method for User to create a name for their character/adventurer
  def getAdventurerName(id: Int): Unit = {
    //create a new connection to the database
    val dbConnect = new dbConnecter
    val connection = dbConnect.connectionToDB()

    val statement = connection.createStatement()
    val resultSet = statement.executeQuery(s"SELECT * FROM Adventurer WHERE ADVENTURERID = $id")
    var name = ""
    while(resultSet.next) {
      name += resultSet.getString("AdventurerName")
    }

  def createNewAdventurer(): Unit = {

    val dbConnect = new dbConnecter
    val connection = dbConnect.connectionToDB()


    //To do: creating a table for Player character and inserting into that table value of what the player chose to have as well as inventory and weapons
    val statement = connection.createStatement()
    val resultSet = s"INSERT INTO adventurerwikidb.ADVENTURER (ADVENTURERID: Int, AdventurerName: String, HEALTH: Int, attack: Int, defense: Int, LOOT: String, Location: String) VALUES (?, ?, ?, ?, ?, ?)"
    val prepstmt : PreparedStatement = connection.prepareStatement(resultSet)
    prepstmt.setString(1, name)
    prepstmt.setInt(2, HP)
    prepstmt.setInt(3, attack)
    prepstmt.setInt(4, defense)
    prepstmt.setString(5, loot)
    prepstmt.setString(6, location)
    prepstmt.execute()
  }*/


  }



}*/
