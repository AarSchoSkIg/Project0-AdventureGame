package AdventureGame

object MainGame {
  //Set up of taking user input and initial variables
  scala.io.StdIn.readLine("")

  protected var AdventurerHP: Int = 0
  protected var Adventurerdefense: Int = 0
  var Adventurerloot: String = _
  var Adventurerweapon: String = _
  var attack: Int = 0
  var location: String = _
  var monsterHP: Int = 0


  //main game inital start simple version
  def main(args: Array[String]): Unit = {

    def gameStart() : Unit = {
      println("Welcome to Grimm Tales! Press enter to start")
      println("Grimm Tales is an exciting adventure game filled with monsters, exploration, combat, and treasure!" +
        "press enter to continue.")
      

    }


  }
}
