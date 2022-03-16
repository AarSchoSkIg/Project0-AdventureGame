package AdventureGame

import AdventureGame.DBController.{connection, connectionToDB, disconnectFromDB, resultSet}

import java.sql.Connection
import scala.util.control.Breaks.break


object DungeonMasterDesigner {

  def main(args: Array[String]): Unit = {

    // created a statement for getting all rows from Adventurer Table, and ran the select query

    connectionToDB()
    println("Welcome to the Dungeon Master Dungeon designer WorkSheet. This Worksheet is for creating a dungeon, adding components to that dungeon, and having it stored in one place")
    var dungeonMaster: Unit = println("To start: Please enter your Name")
    dungeonMaster = scala.io.StdIn.readLine()

    //Initial variable setup
    var createDungeons = true
    var choice = ""
    var dungeon = ""
    var dungeonID = 0
    var monster = 0
    var loot = 0
    var rooms = 0
    var rewardID = 0
    var mapAreaID = 0
    //When dungeon master wants to add new dungeon entry
    while (createDungeons == true) {
      println("Press 1 to create a dungeon, Press 2 update existing dungeon record, Press 3 to view Monsters in dungeon, 4 if you wanna delete a the dungeon, Press 5 if you want to quit")
      choice = scala.io.StdIn.readLine()
      while (choice == "1") {
        if (dungeon == "") {
          dungeonID = dungeonID + 1
          println("Enter in the number of monsters to add for this dungeon")
          monster = scala.io.StdIn.readInt()
          println("Enter in the amount of loot to add for this dungeon")
          loot = scala.io.StdIn.readInt()
          println("Enter in the number of rooms for this dungeon: ie Cave Entrance")
          rooms = scala.io.StdIn.readInt()
          rewardID = rewardID + 1
          mapAreaID = mapAreaID + 1
          createNewDungeon (dungeonID: Int, monster: Int, loot: Int, rooms: Int, rewardID: Int, mapAreaID: Int)
          var doneCreating = scala.io.StdIn.readLine()
          if (doneCreating == "y") {
            dungeon = "1"
          }
          else if (doneCreating == "n") {
            choice = "6"
          }
          else {
            print("Invalid input!")
            choice = "6"
          }


        }
      }
      if (choice == "2") {
        updateExistingDungeon()
      }
      else if (choice == "3") {
        viewMonsters()
      }
      else if (choice == "4") {
        deleteDungeon(dungeonID, connection)
      }
      else if (choice == "5") {
        println("Now existing Program")
        println("Your Dungeon is going to be a phenomenal masterpiece, just like you!!! Thank you for using the software.")
        disconnectFromDB()
        break
      }

      /* else if (option == "doneLog")
         println("")*/
      else {
        println("Invalid option!")
        choice = "5"
      }

    }



  }


  //end of main method
  //dungeon create and insert values into table in DB
  def createNewDungeon(dungeonID: Int, monster: Int, loot: Int, rooms: Int, rewardID: Int, mapAreaID: Int): Unit = {
    var pstmt = connection.prepareStatement("Insert Into dungeon (dungeonID, monster, loot, rooms, rewardID, mapAreaID) Values(?, ?, ?, ?, ?, ?)")
    try {
      pstmt.setInt(1, dungeonID)
      pstmt.setInt(2, monster)
      pstmt.setInt(3, loot)
      pstmt.setInt(4, rooms)
      pstmt.setInt(5, rewardID)
      pstmt.setInt(6, mapAreaID)
      pstmt.executeUpdate()
      println("The Dungeon has been created successfully: " + pstmt)
    } /*catch {
      case e: IllegalArgumentException => println("Invalid Input!! Dungeon did not properly create. Would you like to create another dungeon, y or n?")
  }*/
    try {
      var statmnt = connection.createStatement()
      val resultSet = statmnt.executeQuery("Select * From dungeon where dungeonId = 1")
      while (resultSet.next()) {
        val dungeonID = resultSet.getInt("dungeonID")
        val monster = resultSet.getInt("monster")
        val loot = resultSet.getInt("loot")
        val rooms = resultSet.getInt("rooms")
        val rewardID = resultSet.getInt("rewardID")
        val mapAreaID = resultSet.getInt("mapAreaID")
        println(dungeonID, monster, loot, rooms, rewardID, mapAreaID)
      }
    } catch {
      case e: IllegalArgumentException => println("Invalid Input!! Dungeon did not properly create. Would you like to create another dungeon, y or n?")
    }
  }

  //method for viewing Monsters in Dungeon
  def viewMonsters(): Unit = {
    var pstmt2 = connection.prepareStatement("SELECT * FROM Enemy")
    println("ALl monsters in dungeon are: " + pstmt2)

  }
  //method for viewing Rewards in Dungeon
  def viewRewards(): Unit = {
    var pstmt3 = connection.prepareStatement("SELECT * FROM Reward")
    println("ALl rewards in dungeon are: " + pstmt3)
  }

    //Option 5 deletes record of dungeon created

  def deleteDungeon (dungeonID: Int, connection: Connection): Unit = {
    println("There is no going back after you deleted your dungeon, are you sure? y or n")
    var yesOrNo = scala.io.StdIn.readLine()
      if (yesOrNo == "y") {
        var pstmt4 = connection.prepareStatement("DELETE FROM dungeon WHERE dungeonID=?")
        pstmt4.setInt(1, dungeonID)
        pstmt4.execute()
        println("Dungeon has been deleted!")

      }
      else if (yesOrNo == "n") {
        println("Dungeon was not deleted")
      } else {
        println("Invalid input!")
      }
  }
}