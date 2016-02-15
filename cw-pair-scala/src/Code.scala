import scala.util.Random

abstract class Code {
  var vector: Vector[Char] = Vector()

  def stringToCode(s: String): Unit = s.foreach(c => vector = vector :+ c)

  def calculateResult(other: Code): Result = Result(this, countPerfectMatches(other), countPartialMatches(other), Factory.getGameSettings(Factory.bo))

  def countPerfectMatches(other: Code): Int = (this.vector, other.vector).zipped.filter(_ == _)._1.size

  def countPartialMatches(other: Code): Int = {
    val zippedAndFiltered = (this.vector, other.vector).zipped.filter(_ != _)
    val setA = zippedAndFiltered._1.toSet[Char]
    val setB = zippedAndFiltered._2.toSet[Char]
    setA.intersect(setB).size
  }

  override def toString(): String = {
    vector.mkString
  }
}

case class RandomCode(gs: GameSettings) extends Code {

  {
    stringToCode(generateRandomString(gs.codeLength))
  }

  def generateRandomString(length: Int): String = {
    val r = new Random()
    r.alphanumeric
      .filter(c => c.isLetter && isValidChar(c))
      .slice(0, length)
      .mkString
  }

  def isValidChar(c: Char): Boolean = gs.getColours.keySet.contains(c)

}

case class Guess(input: String) extends Code { stringToCode(input) }

case class Result(guess: Code, fullMatches: Int, partialMatches: Int, gameSettings: GameSettings){

 override def toString: String = guess.toString() + " "+ gameSettings.perfectMatchStr * fullMatches + " "+ gameSettings.partialMatchStr * partialMatches
}