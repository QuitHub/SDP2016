import scala.io.StdIn

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

  def makeBoard: Board = {
    val gc = StandardGameConfigurer
    val randomCode = new RandomCode(4, gc)
    val guessesleft = 2
    val codeLength = 4
    val results = Vector[Result]()
    val show = true
    val b = Board(guessesleft, codeLength, randomCode, results, show)
    b
  }


  override def runGames: Unit = {
    var board = makeBoard
    print(board)
    val sir = StandardInputReceiver
    val sor = StandardOutputRender
    val siv = StandardInputValidator
    val lang = EnglishLanguage
    var theyWon = !(board.results.isEmpty || !board.results.last.isCorrect)
    while (!theyWon) {
      var isValidGuess = false
      var input = ""
      while (!isValidGuess) {
        sor.render(lang.getNextGuessString)
        input = sir.getInput
        isValidGuess = siv.validateInput(input)
      }
      val guess = new Guess(input)
      board = board.updateBoard(guess)
      theyWon = board.results.last.isCorrect || board.numberOfGuessesLeft == 0
      println("they won: " +theyWon)
      sor.render(board.toString())

    }
    if(theyWon){
      sor.render(lang.getWellDoneString)
    } else {
      sor.render(lang.getFailString)
    }
    sor.render(lang.getQuitString)
  }
}
