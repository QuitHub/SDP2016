object MastermindDriver {
  def main(args: Array[String]) {
    val gs = StandardGameSettings()
    val palette = StandardPalette()
    val code = "RBRB"//StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)
    val board =  Board(
      gs.numberOfTurns,
      true,
      gs.codeLength,
      secretCode = code
    )
    val gameState = GameState(gs.numberOfTurns)
    val newCode = StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)
    val newBoard =  Board(
      gs.numberOfTurns,
      false,
      gs.codeLength,
      secretCode = newCode
    )

    val g2 = MastermindGame(gameState = gameState, board = board)
    g2.runGames()
    val g = MastermindGame(gameState = gameState, board = newBoard)
    g.runGames
  }
}

trait GameSettings {

  def codeLength: Int = 4

  def numberOfTurns: Int = 12

}

case class StandardGameSettings() extends GameSettings