object MastermindDriver {
  def main(args: Array[String]) {
    val gs = StandardGameSettings()
    val palette = StandardPalette()
    val randomCode = RandomCode(palette.charsInUse, gs.codeLength, showCode = true)
    val b = Board(gs.numberOfTurns, gs.codeLength, randomCode)


    val dontShowBoard = Board(2, 4, randomCode)
    val g = MastermindGame(board = b)
    g.runGames
    val g2 = MastermindGame(board = dontShowBoard)
    g2.runGames
  }
}