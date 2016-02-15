/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
case class Colour(name: String) {

  def getFirstToUpper: Char = {
    name.charAt(0).toUpper
  }
}

object Palette {

  var colMap = scala.collection.mutable.Map[Char, Colour]()
  //How should we handle when someone adds a colour with the same letter
  // as a colour already in there????????????
  def addColour(col: Colour): Boolean = {

    if (colMap.keySet.contains(col.getFirstToUpper)) {
      false
    } else {
      colMap += col.getFirstToUpper -> col
      true
    }
  }

}