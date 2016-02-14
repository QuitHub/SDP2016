

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
  val sgc = StandardGameConfigurer

  override def runGames: Unit = {
    //do intro in here
    // renderIntro
    playGame()
  }

  def playGame(): Unit = {
    var board = makeBoard
    sor.render(board.toString())
    while (thereAreGuessesLeft(board) && !theCodeIsCracked(board)) {
      board = board.updateBoard(Guess(getValidGuess))
      sor.render(board.toString())
    }
    gameOverOutput(board)
    if(getPlayAgain) playGame() // breaks if you dont enter a string and just press return
  }

  def makeBoard: Board = {
    val randomCode = RandomCode(4, sgc)
    val guessesLeft = sgc.getNumberOfTurns
    val codeLength = sgc.getCodeLength
    val results = Vector[Result]()
    val show = true
    val b = Board(guessesLeft, codeLength, randomCode, results, show)
    b
  }

  def thereAreGuessesLeft(b: Board): Boolean = b.numberOfGuessesLeft > 0

  def theCodeIsCracked(b: Board): Boolean = b.results.nonEmpty && b.results.last.isCorrect

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
    if (theCodeIsCracked(b)) {
      sor.render(eLang.getWellDoneStr)
    } else {
      sor.render(eLang.getFailStr)
    }
  }

  def getPlayAgain = {
    sor.render(eLang.getQuitStr)
    val input = sir.getChar()
    siv.playAgain(input)
  }
}