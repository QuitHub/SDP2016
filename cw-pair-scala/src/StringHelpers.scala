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

    val lang = EnglishLanguage()

    def countPerfectMatches(other: String): Int = (str, other).zipped.filter(_ == _)._1.length

    def countPartialMatches(other: String): Int = {
      val zippedPerfectMatchesRemoved = (str, other).zipped.filter(_ != _)
      val filteredStr = zippedPerfectMatchesRemoved._1
      val filteredOther = zippedPerfectMatchesRemoved._2
      filteredStr.intersect(filteredOther).length
    }

    def matchOutputString(other: String): String = {
      val fullMatches = countPerfectMatches(other)
      val partialMatches = countPartialMatches(other)
      if(fullMatches + partialMatches == 0){
        str + " " + lang.noMatchStr
      } else {
        str + " " + s"${lang.perfectMatchStr} " * fullMatches + s"${lang.partialMatchStr} " * partialMatches
      }
    }
  }
}
