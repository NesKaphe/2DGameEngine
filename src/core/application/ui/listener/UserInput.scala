package core.application.ui.listener

import core.application.ui.GameUI
import java.awt.event.KeyEvent
import java.awt.event.KeyAdapter


/* UserInput will notify the application of the key pressed or released
 * by the player.
 */
case class UserInput(private val ui : GameUI) extends KeyAdapter {
  
  override def keyReleased(e : KeyEvent) = {
    ui.app keyReleased(e.getKeyCode)
  }
  
  override def keyPressed(e : KeyEvent) = {
    ui.app keyPressed(e.getKeyCode)
  }
  
}
