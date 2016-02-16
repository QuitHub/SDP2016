object MastermindDriver {
  def main(args: Array[String]) {
    val settingsShowCode = StandardGameSettings(showCode = true)
    val g = MastermindGame(gs = settingsShowCode)
    g.runGames
    val settingsDontShow = StandardGameSettings()
    val g2 = MastermindGame(gs = settingsDontShow)
    g2.runGames
  }
}