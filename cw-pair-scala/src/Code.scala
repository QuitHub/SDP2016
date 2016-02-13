import scala.util.Random

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */

abstract class Code() {
  var vector: Vector[Char] = Vector()

  def stringToVector(s: String): Unit = {
    s.foreach(c => vector = vector :+ c)
  }

  def calculateResult(other: Code): String = {
    var output = "Result: "
    var zippedAndFiltered = filterOutMatched(this.vector, other.vector)
    var setA = zippedAndFiltered._1.toSet[Char]
    var setB = zippedAndFiltered._2.toSet[Char]
    output = output + getBlacks(this.vector, other.vector) + getWhites(setA, setB)
    if (output.equals("Result: ")) {
      return output + "No Pegs"
    } else {
      return output
    }
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

class RandomCode extends Code {

  def this(length: Int) {
    this()
    stringToVector(generateRandomString(length))
  }

  def generateRandomString(length: Int): String = {
    val r = new Random()
    r.alphanumeric
      .filter(c => c.isLetter && c <= 'F' && c.isUpper)
      .slice(0, length)
      .mkString
  }
}

class Guess extends Code {

  def this(input: String) {
    this()
    stringToVector(input)
  }

}

