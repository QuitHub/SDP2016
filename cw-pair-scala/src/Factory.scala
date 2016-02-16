object Factory {

  def getInstance(c: Class[_], b: Boolean): Game = {
//    val game = c.getConstructor(classOf[Boolean]).newInstance(b).asInstanceOf[MastermindGame]
//    game.gs = StandardGameSettings(showCode = b)
//    game
    val game = c.newInstance().asInstanceOf[MastermindGame]
    game.gs = StandardGameSettings(showCode = b)
    game
  }

}