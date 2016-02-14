/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

case class Board(numberOfGuessesLeft: Int = 0,
                 codeLength: Int = 4,
                 secretCode: Code,
                 results: Vector[Result],
                 showCode: Boolean) {

  override def toString: String = {
    var out = secretCodeToString
    results.foreach(r => out += r.guess + " " + r.resultStr + "\n")
    for (i <- 1 to numberOfGuessesLeft) {
      /// put this in holes to string??????
      out += rowToString + "\n"
    }
    out += guessesLeftToString + "\n"
    out
  }

  def secretCodeToString = {
    var out = ""
    if (showCode) {
      out += secretCode.toString
    } else {
      out += rowToString
    }
    out + " Secret Code \n"
  }

  def rowToString = {
    var output = ""
    for (i <- 1 to codeLength) {
      output += "."
    }
    output
  }

  def guessesLeftToString = s"You have $numberOfGuessesLeft guesses left."

  def updateBoard(guess: Guess): Board = {
    val randomCode = this.secretCode
    val result = guess.calculateResult(randomCode)
    var guessesLeft = this.numberOfGuessesLeft - 1
    if (result.isCorrect) {
      guessesLeft = 0
    }
    val codeLength = this.codeLength
    val results = this.results :+ result
    val show = this.showCode
    val b = Board(guessesLeft, codeLength, randomCode, results, show)
    b
  }

}
