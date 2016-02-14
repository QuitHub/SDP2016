import scala.util.Random

abstract class Code() {
  var vector: Vector[Char] = Vector()

  def stringToVector(s: String): Unit = {
    s.foreach(c => vector = vector :+ c)
  }

  def calculateResult(other: Code): Result = {
    var output = "Result: "
    val zippedAndFiltered = filterOutMatched(this.vector, other.vector)
    val setA = zippedAndFiltered._1.toSet[Char]
    val setB = zippedAndFiltered._2.toSet[Char]
    output = output + getBlacks(this.vector, other.vector) + getWhites(setA, setB)
    if (output.equals("Result: ")) {
      output += output + "No Pegs"
    }
    val isCorrect = (this.vector, other.vector).zipped.filter(_ == _)._1.size == 4
    Result(this, output, isCorrect)
  }

  def getBlacks(guess: Vector[Char], other: Vector[Char]): String = {
    var output = ""
    val numberOfmatches = (guess, other).zipped.filter(_ == _)._1.size
    for (i <- 1 to numberOfmatches) output = output + "black "
    output
  }

  def getWhites(setA: Set[Char], setB: Set[Char]): String = {
    var output = ""
    val numberOfCommonElements = setA.intersect(setB).size
    for (i <- 1 to numberOfCommonElements) output = output + "white "
    output
  }

  def filterOutMatched(guess: Vector[Char], other: Vector[Char]): (Vector[Char], Vector[Char]) = {
    (guess, other).zipped.filter(_ != _)
  }

  override def toString(): String = {
    vector.mkString
  }
}

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
case class Result(guess: Code, resultStr: String, isCorrect: Boolean)

case class RandomCode(length: Int, gameConfigurer: GameConfigurer) extends Code {

  {
    stringToVector(generateRandomString(length))
  }

  def generateRandomString(length: Int): String = {
    val r = new Random()
    r.alphanumeric
      .filter(c => c.isLetter && isValidChar(c))
      .slice(0, length)
      .mkString
  }

  def isValidChar(c: Char): Boolean = {
    gameConfigurer.getColours.keySet.contains(c)
  }
}

case class Guess(input: String) extends Code {
  stringToVector(input)
}

