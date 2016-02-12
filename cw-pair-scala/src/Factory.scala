object Factory {
  def getInstance(c: Class[_], b: Boolean): Game = {
    if(b){
      var showCodeGame = c.newInstance().asInstanceOf[MastermindGame]
      print(showCodeGame.getClass.getDeclaredFields)
      return showCodeGame
    } else {
      return c.newInstance().asInstanceOf[MastermindGame]
    }

//    println("foo "+ cl.getTypeName)
//    println(c.getTypeName)
//    println(c.getTypeParameters)
//    c.asInstanceOf[MastermindGame]

    //return  new MastermindGame(b)
    //return   c.getConstructor(classOf[Boolean]).newInstance(b).asInstanceOf[MastermindGame]
  }
}