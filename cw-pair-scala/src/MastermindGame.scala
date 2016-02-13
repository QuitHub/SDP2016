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
    val myGuess = new Guess("BBCB")
    val randomCode = new RandomCode(4)
    val resultToString = myGuess.calculateResult(randomCode)
    val res = Result(guess = myGuess, result = resultToString)
    val guessesleft = 3
    val codeLength = 4
    val results = Vector(res)
    val show = true
    val b = Board(guessesleft, codeLength, randomCode, results, show)
    b
  }


  override def runGames: Unit = {
    print(makeBoard)
    StandardInputReceiver.getInput()
  }



}
