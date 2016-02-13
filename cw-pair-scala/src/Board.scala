/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
case class Result(guess: Code, result: String)

case class Board(numberOfGuessesLeft: Int,
                 codeLength: Int,
                 secretCode: Code,
                 results: Vector[Result],
                 showCode: Boolean) {

  override def toString(): String = {
    var out = ""

    out += secretCode.toString + " Secret Code \n"
    results.foreach(r => out += r.guess +" "+ r.result + "\n")
    for (i <- 1 to numberOfGuessesLeft) { /// put this in holes to string??????
      out += rowToString + "\n"
    }
    out += guessesLeftToString + "\n"
    out
  }

  def secretCodeToString = {
    var out = ""
    if(showCode){
      out += secretCode.toString
    } else {
      out += rowToString
    }
    out += " Secret code\n"
  }

  def rowToString = {
    var output = ""
    for (i <- 1 to codeLength) {
      output += "."
    }
    output
  }

  def guessesLeftToString = s"You have $numberOfGuessesLeft guesses left."
}
