import scala.util.Random

/**
  * 11/02/2016.
  *
  * @author lukematthews
  */
class RandomCode extends Code{

  def this(length: Int){
    this()
    stringToVector(generateRandomString(length))
  }

  def generateRandomString(length: Int): String = {
    val r = new Random()
    r.alphanumeric
      .filter(c => c.isLetter && c < 'F' && c.isUpper)
      .slice(0,length)
      .mkString
  }

  override def toString() : String = {
    "d"
  }
}
