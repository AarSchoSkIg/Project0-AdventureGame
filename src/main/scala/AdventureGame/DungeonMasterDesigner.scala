package AdventureGame

import AdventureGame.DBController.{connectionToDB, initiateDML, initiateQuery}

import java.sql.{Connection, DriverManager, PreparedStatement, Statement}

object DungeonMasterDesigner {

  def main(args: Array[String]): Unit = {

        // created a statement for getting all rows from Adventurer Table, and ran the select query

    connectionToDB()
    println("Welcome to the Dungeon Master Dungeon designer WorkSheet. This Worksheet is for creating a dungeon, adding components to that dungeon, and having it stored in one place")
    println("To start: Please enter your Name")
    var dungeonMaster = scala.io.StdIn.readLine()

    //Initial variable setup
    var createDungeon = true
    var choice = ""
    var dungeonID: Int = 0
    var monsters = 0
    var loot = 0
    var rooms = 0

    //When dungeon master wants to add new dungeon entry
    while (createDungeon == true){
      println("Press 1 to create a dungeon, 3 to add a new Monster, 4 to add a new rewardItem, 5 if you wanna delete the dungeon logs, Press 6 if you want to quit")
      choice = scala.io.StdIn.readLine()
      while(choice =="1") {
        if (dungeonID == 0) {
          dungeonID = dungeonID + 1
          println("Enter in the number of monsters to add for this dungeon")
          monsters = scala.io.StdIn.readInt()
          println("Enter in the amount of loot to add for this dungeon")
          loot = scala.io.StdIn.readInt()
          println("Enter in the number of rooms for this dungeon: ie Cave Entrance")
          rooms = scala.io.StdIn.readInt()
          createNewDungeon(dungeonID, monsters, loot, rooms)
        }
        else {

        }
      }
    }

  }
  //end of main method

  def createNewDungeon(dungeonName: String, monsters: Int, loot: Int, rooms: Int): Unit = ???
  }
