import scala.annotation.tailrec

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
class MastermindGame() extends GameAbstractImpl() {

  val sir = StandardInputReceiver
  val sor = StandardOutputRenderer
  val siv = StandardInputValidator
  val eLang = EnglishLanguage
  val gs = StandardGameSettings()

  override def runGames: Unit = {
    sor.render(eLang.introString)
    playGame()
  }

  @tailrec
  private def playGame(): Unit = {
    val board = makeBoard
    sor.render(board.toString())
    val boardAfterGameOver = keepGuessing(board)
    gameOverOutput(boardAfterGameOver)
    if (wannaPlayAgain) playGame()
  }

  private def makeBoard: Board = Board(gs.numberOfTurns, gs, RandomCode(gs), Vector[Result]())

  @tailrec
  private def validGuessString: String = {
    sor.render(eLang.nextGuessStr)
    val input = sir.getInput
    if (siv.validateInput(input))
      input
    else
      validGuessString
  }

  @tailrec
  private def keepGuessing(b: Board): Board = {
    val guess = Guess(validGuessString)
    val updatedBoard = b.updateBoard(guess)
    sor.render(updatedBoard.toString)
    if (updatedBoard.thereAreGuessesLeft && !updatedBoard.theCodeIsCracked) {
      sor.render(updatedBoard.guessesLeftToString + "\n")
      keepGuessing(updatedBoard)
    } else {
      updatedBoard
    }
  }

  private def gameOverOutput(b: Board) = {
    if (b.theCodeIsCracked)
      sor.render(eLang.wellDoneStr)
    else
      sor.render(eLang.failStr)
  }

  private def wannaPlayAgain = {
    sor.render(eLang.quitStr)
    siv.playAgain(sir.getInput)
  }
}