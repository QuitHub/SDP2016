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
      val filteredStr = zippedAndFiltered._1
      var filteredOther = zippedAndFiltered._2
      filteredStr.toStream.foreach(c => filteredOther = filteredOther diff c.toString)
      filteredStr.length - filteredOther.length
    }


    def matchOutputString(other: String, lang: Language = EnglishLanguage()): String = {
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
