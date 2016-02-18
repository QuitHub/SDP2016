object MastermindDriver {
  def main(args: Array[String]) {
    val gs = StandardGameSettings()
    val palette = StandardPalette()
    val randomCode = StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)
    val b = Board(gs.numberOfTurns, true, randomCode)
    val gameState = GameState(gs.numberOfTurns)

    val g = MastermindGame(board = b, gameState = gameState)
    g.runGames

  }
}