import scala.util.Random

abstract class Code {
  var str = ""

  def calculateResult(other: Code): Result = Result(this, countPerfectMatches(other), countPartialMatches(other), StandardGameSettings())

  def countPerfectMatches(other: Code): Int = (str, other.str).zipped.filter(_ == _)._1.size

  def countPartialMatches(other: Code): Int = {
    val zippedAndFiltered = (str, other.str).zipped.filter(_ != _)
    val setA = zippedAndFiltered._1.toSet[Char]
    val setB = zippedAndFiltered._2.toSet[Char]
    setA.intersect(setB).size
  }

  override def toString: String = str
}

case class RandomCode(charsInUse: scala.collection.Set[Char],
                      codeLength: Int,
                      showCode: Boolean) extends Code {
  str = generateRandomString(codeLength)

  override def toString: String = {
    if(showCode){
      super.toString + " Secret Code "
    } else {
      "." * codeLength + " Secret Code "
    }
  }


  def generateRandomString(length: Int): String = {
    val isValidChar = (c: Char) => c.isLetter && charsInUse.contains(c)
    val r = new Random()
    r.alphanumeric
      .filter(isValidChar)
      .take(length)
      .mkString
  }
}



case class Guess(input: String) extends Code {
  str = input
}



case class Result(guess: Code, fullMatches: Int, partialMatches: Int, gs: GameSettings) {
  override def toString: String = {
    if(fullMatches + partialMatches == 0){
      guess.toString() + " no pegs"
    } else {
      guess.toString() + " " + s"${gs.perfectMatchStr} " * fullMatches + s"${gs.partialMatchStr} " * partialMatches
    }
  }
}