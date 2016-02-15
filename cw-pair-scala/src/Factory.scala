object Factory {

  var bo = false

  def getInstance(c: Class[_], b: Boolean): Game = {
    val game = c.newInstance().asInstanceOf[MastermindGame]
    bo = b
    game
  }



  def getGameSettings(b: Boolean): GameSettings = {
    StandardGameSettings(
      codeLength = 4,
      numberOfTurns = 12,
      showCode = b,
      colourNames = Vector("Blue", "Green", "Orange","Purple", "Red", "Yellow"))
  }

}