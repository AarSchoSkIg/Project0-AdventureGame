package AdventureGame


object AdventurerTable {
  //To do: creating a table for Player character and inserting into that table value of what the player chose to have as well as inventory and weapons
  val queryTable= "CREATE TABLE ADVENTURER" +
        "(ADVENTURERID INT NOT NULL AUTO_INCREMENT, " +
        "AdventurerNAME VARCHAR(255), " +
        "HEALTH INT, " +
        "DEFENSE INT, " +
        "Weapon VARCHAR(255), " +
        "loot VarChar(255), " +
        "MONSTERSKILLED VARCHAR(255), )";
}
