import scala.annotation.tailrec

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
case class MastermindGame(sir: InputReceiver = StandardInputReceiver,
                          sor: OutputRenderer = StandardOutputRenderer,
                          eLang: Language = EnglishLanguage,
                          gs: GameSettings = StandardGameSettings()
                         ) extends GameAbstractImpl() {



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
    val str = sir.getInputAsUpper
    if (validateGuess(str))
      str
    else
      validGuessString // if not valid recursively seek valid one
  }

  private def validateGuess(input: String): Boolean = {
    if (input.length != gs.codeLength) {
      return false
    }
    val inputSet = input.toStream.toSet[Char]
    val colourCharSet = gs.getColoursMap.keySet
    inputSet.intersect(colourCharSet).equals(inputSet)
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
    sir.getInputAsUpper == "Y"
  }
}