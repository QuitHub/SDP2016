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
                                colourNames: Vector[String] = Vector("Blue", "Green", "Orange", "Purple", "Red", "Yellow")
                               ) extends GameSettings {
  def getColoursMap = colMap

  var colMap = scala.collection.mutable.Map[Char, Colour]()
  setColours(colourNames)

  override def setColours(colourNames: Vector[String]) = {
    for (name <- colourNames) {
      val nameCapped = name.capitalize
      addColour(Colour(nameCapped))
    }
  }

  override def getColourSet: Set[Colour] = {
    colMap.values.toSet
  }

  def addColour(col: Colour): Boolean = {

    if (colMap.keySet.contains(col.getFirstToUpper)) {
      false
    } else {
      colMap += col.getFirstToUpper -> col
      true
    }
  }
}

case class Colour(name: String) {

  def getFirstToUpper: Char = {
    name.charAt(0).toUpper
  }
}

