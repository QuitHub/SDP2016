object Factory {
  def getInstance(c: Class[_], b: Boolean): Game = {
    if(b){

      var showCodeGame = c.newInstance().asInstanceOf[MastermindGame]
      return showCodeGame
    } else {
      return c.newInstance().asInstanceOf[MastermindGame]
    }

  }
}