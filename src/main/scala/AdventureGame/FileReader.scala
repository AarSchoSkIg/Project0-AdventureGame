package AdventureGame

import java.io.File
import scala.io.Source
import scala.util.matching.Regex

class FileReader {
  /*val property = new Regex("\b[^{}\n,":]+\b|\d+")
  val file = new File(json) // json is just file name
  val in = Source.fromFile(file,"UTF-8")
  //.+,.+,.+\b
  val a = "name,age,weight".split(",") //for reading each column name
  val str = property.findAllIn(in.getLines().mkString("")).toArray
  in.close()*/
  def readDungeonFiles(): Unit = {
    val property = new Regex(".+,.+,.+\b")
    val file = new File("\\Users\\aaron\\Documents\\revature-trainingFeb282022\\ProjectsBigData\\githubrepositoriesforProjects\\Project0-AdventureGame\\src\\main\\scala\\AdventureGame\\dungeon.csv")
    val in = Source.fromFile(file, "UTF-8")
    val readColumnName = "DungeonID, Monster, loot, rooms, rewardID, MapAreaID".split(",")
    val str = property.findAllIn(in.getLines().mkString("")).toArray
    in.close()
  }
  def readEnemyFiles(): Unit = {
    val property1 = new Regex(".+,.+,.+\b")
    val file1 = new File("\\Users\\aaron\\Documents\\revature-trainingFeb282022\\ProjectsBigData\\githubrepositoriesforProjects\\Project0-AdventureGame\\src\\main\\scala\\AdventureGame\\enemy.csv")
    val in1 = Source.fromFile(file1, "UTF-8")
    val str1 = property1.findAllIn(in1.getLines().mkString("")).toArray
    in1.close()
  }
  def readRewardFiles(): Unit = {
    val property2 = new Regex(".+,.+,.+\b")
    val file2 = new File("\\Users\\aaron\\Documents\\revature-trainingFeb282022\\ProjectsBigData\\githubrepositoriesforProjects\\Project0-AdventureGame\\src\\main\\scala\\AdventureGame\\reward.csv")
    val in2 = Source.fromFile(file2, "UTF-8")
    val str2 = property2.findAllIn(in2.getLines().mkString("")).toArray
    in2.close()
  }
}
