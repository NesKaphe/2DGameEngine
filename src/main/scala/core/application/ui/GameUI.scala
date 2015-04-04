package core.application.ui

import core.application.Application
import core.application.ui.listener.UserInput
import game.states.GameState
import javax.swing.JFrame
import java.awt.BorderLayout

class GameUI(val app: Application) {

  private val gameWindow : JFrame = new JFrame(app.config.gameTitle)
  private val gamePanel : GameSurface = new GameSurface(app.config.widthRes,
                                                        app.config.heightRes)
  
  
  //Game window configuration for the game
  gameWindow add(gamePanel.panel, BorderLayout.CENTER)
  gameWindow setResizable(false)
  gameWindow pack()
  gameWindow setLocationRelativeTo(null)
  gameWindow addKeyListener(new UserInput(this))
  gameWindow setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE)
  
  def openGraphics() : Unit = {
    gameWindow setVisible(true)
    gameWindow requestFocus()
  }
  
  def render(state : GameState) : Unit = {
    gamePanel draw(state)
  }
  
}