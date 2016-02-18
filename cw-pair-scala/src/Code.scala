import scala.util.Random

object StringUtils {

  def randomStringFromCharSet(length: Int, charsInUse: scala.collection.Set[Char]): String = {
    val isValidChar = (c: Char) => c.isLetter && charsInUse.contains(c)
    val r = new Random()
    r.alphanumeric
      .filter(isValidChar)
      .take(length)
      .mkString
  }

  implicit class StringImprovements(val str: String) {

    def countPerfectMatches(other: String): Int = (str, other).zipped.filter(_ == _)._1.size

    def countPartialMatches(other: String): Int = {
      val zippedAndFiltered = (str, other).zipped.filter(_ != _)
      val setA = zippedAndFiltered._1.toSet[Char]
      val setB = zippedAndFiltered._2.toSet[Char]
      setA.intersect(setB).size
    }
    def calculateResult(other: String): Result = Result(str, countPerfectMatches(other), countPartialMatches(other))

    def visibleString(visible : Boolean): String ={
        if(visible){
          str
        } else {
          "." * str.length
        }
    }
  }
}


case class Result(guess: String, fullMatches: Int, partialMatches: Int, lang: Language = EnglishLanguage()) {
  override def toString: String = {
    if(fullMatches + partialMatches == 0){
      guess + " " + lang.noMatchString
    } else {
      guess + " " + s"${lang.perfectMatchStr} " * fullMatches + s"${lang.partialMatchStr} " * partialMatches
    }
  }
}