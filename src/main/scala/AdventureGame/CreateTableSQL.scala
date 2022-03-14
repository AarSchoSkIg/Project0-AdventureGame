package AdventureGame

object CreateTableSQL {
  //To do: (delete up to comment to remain after code is made) Comment to remain creating a table for Player character and inserting into that table value of what the player chose to have as well as inventory and weapons
  val Create_Table_SQL = """CREATE TABLE adventurewikidb.PlayerOne ("
        "PlayerOneID INT NOT NULL,"
        "PlayerOneNAME VARCHAR(45),"
        "GENDER VARCHAR (12),"
        "DEFENSE INT,"
        "loot VARCHAR (255),"
        "MONSTERS KILLED,"
        "PRIMARY KEY (PlayerOneID))"""
}
