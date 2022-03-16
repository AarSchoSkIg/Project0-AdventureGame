package AdventureGame

import AdventureGame.DBController.{connection, connectionToDB, disconnectFromDB}

import java.sql.Connection
import scala.util.control.Breaks.break


object DungeonMasterDesigner {

  def main(args: Array[String]): Unit = {

    // created a statement for getting all rows from Adventurer Table, and ran the select query

    connectionToDB()
    println("Welcome to the Dungeon Master Dungeon designer WorkSheet. This Worksheet is for creating a dungeon, adding components to that dungeon, and having it stored in one place")
    var dungeonMaster = println("To start: Please enter your Name")
    dungeonMaster = scala.io.StdIn.readLine()

    //Initial variable setup
    var createDungeons = true
    var choice = ""
    var dungeon = ""
    var dungeonID = 0
    var monsters = 0
    var loot = 0
    var rooms = 0

    //When dungeon master wants to add new dungeon entry
    while (createDungeons == true) {
      println("Press 1 to create a dungeon, 2 to view Monsters in dungeon, 3 to view rewardItems in dungeon, 5 if you wanna delete a the dungeon, Press 6 if you want to quit")
      choice = scala.io.StdIn.readLine()
      while (choice == "1") {
        if (dungeon == "") {
          dungeonID = dungeonID + 1
          println("Enter in the number of monsters to add for this dungeon")
          monsters = scala.io.StdIn.readInt()
          println("Enter in the amount of loot to add for this dungeon")
          loot = scala.io.StdIn.readInt()
          println("Enter in the number of rooms for this dungeon: ie Cave Entrance")
          rooms = scala.io.StdIn.readInt()
          createNewDungeon(dungeonID: Int, monsters: Int, loot: Int, rooms: Int)
          var doneCreating = println("Would you like to create another dungeon, y or n")
          doneCreating = scala.io.StdIn.readLine()
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
        viewMonsters()
      }
      else if (choice == "3") {
        viewRewards()
        break
      }
      else if (choice == "4") {

      }
      else if (choice == "5") {
        deleteDungeon(dungeonID, connection)
        break()
      } else if (choice == "6") {
        println("Now existing Program")
        break()
      }

      /* else if (option == "doneLog")
         println("")*/
      else {
        println("Invalid option!")
        break
      }

    }

    println("Your Dungeon is going to be a phenomenal masterpiece, just like you!!! Thank you for using the software.")
    disconnectFromDB()
  }


  //end of main method
  //dungeon create and insert values into table in DB
  def createNewDungeon(dungeonID: Int, monsters: Int, loot: Int, rooms: Int) = {
    var pstmt = connection.prepareStatement("Inset Into dungeons(dungeonID, monsters, loot, rooms) Values(????)")
    try{
      pstmt.setInt(1, dungeonID)
      pstmt.setInt(2, monsters)
      pstmt.setInt(3, loot)
      pstmt.setInt(4, rooms)
      pstmt.executeUpdate()
      var pstmt1 = connection.prepareStatement("Select * From dungeons")
      println("The Dungeon has been created successfully: " + pstmt1)
    }
  }

  //method for viewing Monsters in Dungeon
  def viewMonsters(): Unit = {
    var pstmt2 = connection.prepareStatement("SELECT * FROM monster")
    println("ALl monsters in dungeon are: " + pstmt2)

  }
  //method for viewing Rewards in Dungeon
  def viewRewards(): Unit = {
    var pstmt3 = connection.prepareStatement("SELECT * FROM Reward")
    println("ALl rewards in dungeon are: " + pstmt3)
  }

    //OPTION 1 step 3: METHOD THAT INSERTS A RECORD INTO THE WORKOUTS TABLE

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