/**
  * 13/02/2016.
  *
  * @author lukematthews
  */
trait GameSettings {

  def codeLength: Int

  def numberOfTurns: Int

  def getColourSet: Set[Colour]

  def setColours(colours: Vector[String])

  def perfectMatchStr: String

  def partialMatchStr: String

  def showCode: Boolean

  def getColoursMap: scala.collection.mutable.Map[Char, Colour]
}

case class StandardGameSettings(codeLength: Int = 4,
                                numberOfTurns: Int = 12,
                                var showCode: Boolean = false,
                                perfectMatchStr: String = "black",
                                partialMatchStr: String = "white",
                                colourNames: Vector[String] = Vector("Turquoise", "Green", "Orange", "Purple", "Maroon", "Yellow")
                               ) extends GameSettings {


  var colMap = scala.collection.mutable.Map[Char, Colour]()
  setColours(colourNames)

  def getColoursMap = colMap

  override def setColours(colourNames: Vector[String]) = {
    colourNames.foreach(name =>
      addColour(Colour(name.capitalize)))
  }

  override def getColourSet: Set[Colour] = colMap.values.toSet

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

