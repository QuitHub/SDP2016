import StringUtils._

import scala.annotation.tailrec

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
case class MastermindGame(sir: InputReceiver = StandardInputReceiver,
                          sor: OutputRenderer = StandardOutputRenderer,
                          iv: InputValidator = StandardInputValidator(),
                          eLang: Language = EnglishLanguage(),
                          gameState: GameState,
                          board: Board
                         ) {

  def runGames(): Unit = {
    sor.render(eLang.introString)
    playGame()
  }

  @tailrec
  private def playGame(): Unit = {

    sor.render(board.toString())
    val gameStateAfterGameOver = loopUntilGameOver(gameState, board)
    gameOverOutput(gameStateAfterGameOver)
    if (wannaPlayAgain) playGame()
  }


  @tailrec
  private def validGuessString: String = {
    sor.render(eLang.nextGuessStr)
    val str = sir.getInputAsUpper
    if (iv.validateGuess(str))
      str
    else
      validGuessString // not valid so recursively seek valid one
  }

  @tailrec
  private def loopUntilGameOver(gameState: GameState, board: Board): GameState = {
    val guess = validGuessString
    val updatedGameState = GameState(board.numberOfGuessesLeft, gameState.isCompleteMatch(board, guess))
    val updatedBoard = updatedGameState.updateBoard(guess, board)
    sor.render(updatedBoard.toString)
    if (updatedGameState.thereAreGuessesLeft && !updatedGameState.isCodeCracked) {
      sor.render(updatedGameState.guessesLeftToString + "\n")
      loopUntilGameOver(updatedGameState, updatedBoard)
    } else {
      updatedGameState
    }
  }

  private def gameOverOutput(gameState: GameState) = {
    if (gameState.isCodeCracked)
      sor.render(eLang.wellDoneStr)
    else
      sor.render(eLang.failStr)
  }

  private def wannaPlayAgain = {
    sor.render(eLang.quitStr)
    sir.getInputAsUpper == eLang.playAgainStr
  }
}

case class GameState(guessesLeft: Int, isCodeCracked: Boolean = false) {

  def guessesLeftToString = s"You have $guessesLeft guesses left."

  def updateBoard(guess: String, board: Board): Board = {
    val result = guess.matchOutputString(board.secretCode)
    Board(
      guessesLeft(isCompleteMatch(board, guess)),
      board.showCode,
      board.codeLength,
      board.palette,
      board.results :+ result
    )
  }

  def isCompleteMatch(board: Board, guess: String) = guess.countPerfectMatches(board.secretCode) == board.codeLength

  private def guessesLeft(isCompleteMatch: Boolean): Int = {
    if (isCompleteMatch) 0
    else guessesLeft - 1
  }

  def thereAreGuessesLeft = guessesLeft > 0
}