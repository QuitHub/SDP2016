import com.softwaremill.macwire._

object MastermindDriver {
  def main(args: Array[String]) {

    val code = "RBRB"//StringUtils.randomStringFromCharSet(gs.codeLength, palette.colourCharSet)
    val sc = false
    val gs = wire[GameSettings]
    val pa = wire[StandardPalette]
    val ir = wire[StandardInputReceiver]
    val iv = wire[StandardInputValidator]
    val or = wire[StandardOutputRenderer]
    val la = wire[EnglishLanguage]
    val res = Results()
    val gl = wire[GuessesLeft]
    val gameState = wire[GameState]

    val bo = wire[Board]

//    val board =  Board(
//      true,
//      gs: GameSettings,
//      secretCode = code
//    )

    val newCode = StringUtils.randomStringFromCharSet(gs.codeLength, pa.colourCharSet)
//    val newBoard =  Board(
//      false,
//      gs,
//      secretCode = newCode
//    )



    val g2 = wire[MastermindGame]
    g2.runGames()
//    val g = MastermindGame(gameState = gameState, board = newBoard)
//    g.runGames()
  }
}

case class GameSettings() {
  val codeLength: Int = 4
  val numberOfTurns: Int = 12
}

case class Results(val vec: Vector[String] = Vector[String]())