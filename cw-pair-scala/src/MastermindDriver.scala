object MastermindDriver {
  def main(args: Array[String]) {
    val gs = StandardGameSettings()
    val palette = StandardPalette()
    val b = Board(
      gs.numberOfTurns,
      true,
      gs.codeLength,
      StandardPalette()
    )
    val gameState = GameState(gs.numberOfTurns)

    val g = MastermindGame(board = b, gameState = gameState)
    g.runGames

  }
}

trait GameSettings {

  def codeLength: Int = 4

  def numberOfTurns: Int = 12

}

case class StandardGameSettings() extends GameSettings