/**
  * 13/02/2016.
  *
  * @author lukematthews
  */

trait Palette {

  var colourSet = scala.collection.immutable.Set[String]()

  def getColourSet: scala.collection.immutable.Set[String] = colourSet

  def colourCharSet: Set[Char] = colourSet.flatMap(_.headOption)

  def addColour(colourStr: String)  = {
    if (!colourCharSet.contains(colourStr.head toUpper)) {
      colourSet = colourSet + colourStr
    }
  }
}

case class StandardPalette(colourNames: Vector[String] =
                           Vector("Blue", "Green", "Orange",
                             "Purple", "Red", "Yellow")) extends Palette {
  colourNames.foreach(name =>
    addColour(name.capitalize))
}


