object MastermindDriver {
  def main(args: Array[String]) {
    val gs = StandardGameSettings(showCode = true)
    val b = Board(gs.numberOfTurns, gs, RandomCode(gs), Vector[Result]())
    val settingsDontShow = StandardGameSettings()
    val dontShowBoard = Board(settingsDontShow.numberOfTurns, settingsDontShow, RandomCode(settingsDontShow), Vector[Result]())

    val g = MastermindGame(board = b)
    g.runGames

    val g2 = MastermindGame(board = dontShowBoard)
    g2.runGames
  }
}