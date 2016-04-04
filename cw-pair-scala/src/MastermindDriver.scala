

object MastermindDriver {
  def main(args: Array[String]) {
    val gs = GameSettings()
    val palette = StandardPalette()
    val code = "RBRB"//StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)

    val board =  Board(
      true,
      gs,
      secretCode = code
    )
    val gameState = GameState(gs.numberOfTurns)
    val newCode = StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)
    val newBoard =  Board(
      false,
      gs,
      secretCode = newCode
    )

    val g2 = MastermindGame(gameState = gameState, board = board)
    g2.runGames()
    val g = MastermindGame(gameState = gameState, board = newBoard)
    g.runGames()
  }
}

case class GameSettings(val codeLength: Int = 4, val numberOfTurns: Int = 12)