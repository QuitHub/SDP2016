/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait GameSettings {

  def codeLength: Int

  def numberOfTurns: Int

  def perfectMatchStr: String

  def partialMatchStr: String

}

case class StandardGameSettings(codeLength: Int = 4,
                                numberOfTurns: Int = 12,
                                perfectMatchStr: String = "black",
                                partialMatchStr: String = "white"

                               ) extends GameSettings

case class StandardPalette(colourNames: Vector[String] =
                           Vector("Blue", "Swedish Blond",
                             "Orange", "Purple", "Red",
                             "Yellow", "Swedish red")) extends Palette {
  super.addColours(colourNames)
}

trait Palette {

  var colMap = scala.collection.mutable.Map[Char, Colour]()

  def addColours(colourNames: Vector[String]) = {
    colourNames.foreach(name =>
      addColour(Colour(name.capitalize)))
  }

  def colourSet: Set[Colour] = colMap.values.toSet

  def colourMap = colMap

  def charsInUse = colMap.keySet

  def addColour(col: Colour): Boolean = {

    if (colMap.keySet.contains(col.firstCharToUpper)) {
      false
    } else {
      colMap += col.firstCharToUpper -> col
      true
    }
  }
}

case class Colour(name: String) { def firstCharToUpper: Char = name.charAt(0).toUpper }

