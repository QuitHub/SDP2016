object MastermindDriver {
  def main(args: Array[String]) {
    val gs = StandardGameSettings()
    val palette = StandardPalette()
    val randomCode = StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)
    val b = Board(gs.numberOfTurns, gs.codeLength, true, randomCode)


    val dontShowBoard = Board(2, 4, false, randomCode)
    val g = MastermindGame(board = b)
    g.runGames
    val g2 = MastermindGame(board = dontShowBoard)
    g2.runGames
  }
}