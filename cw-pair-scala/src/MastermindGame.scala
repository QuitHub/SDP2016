

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
class MastermindGame() extends GameAbstractImpl() {

  /**
    * Run a one or more game sof mastermind, until the player
    * quits.
    */
  val sir = StandardInputReceiver
  val sor = StandardOutputRenderer
  val siv = StandardInputValidator
  val eLang = EnglishLanguage
  val gs = Factory.getGameSettings(Factory.bo)

  def gameSettings: GameSettings = gs

  override def runGames: Unit = {
    sor.render(eLang.getIntroString)
    playGame()
  }

  def playGame(): Unit = {
    var board = makeBoard
    sor.render(board.toString())
    while (board.thereAreGuessesLeft && !board.theCodeIsCracked) {
      board = board.updateBoard(Guess(getValidGuess))
      sor.render(board.toString())
      if (!board.theCodeIsCracked) sor.render(board.guessesLeftToString + "\n")
    }
    gameOverOutput(board)
    if (getPlayAgain) playGame()
  }

  def makeBoard: Board = Board(gs.numberOfTurns, gs, RandomCode(gs), Vector[Result]())

  def getValidGuess = {
    var isValidGuess = false
    var input = ""
    while (!isValidGuess) {
      sor.render(eLang.getNextGuessStr)
      input = sir.getInput
      isValidGuess = siv.validateInput(input)
    }
    input
  }

  def gameOverOutput(b: Board) = {
    if (b.theCodeIsCracked) {
      sor.render(eLang.getWellDoneStr)
    } else {
      sor.render(eLang.getFailStr)
    }
  }

  def getPlayAgain = {
    sor.render(eLang.getQuitStr)
    val input = sir.getInput
    siv.playAgain(input)
  }
}

