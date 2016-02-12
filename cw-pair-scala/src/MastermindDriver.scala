object MastermindDriver {
  def main(args: Array[String]) {
    var g: Game = Factory.getInstance(classOf[MastermindGame], true)
    g.runGames
    g = Factory.getInstance(classOf[MastermindGame], false)
    g.runGames
  }
}