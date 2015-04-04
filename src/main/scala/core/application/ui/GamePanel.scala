package core.application.ui

import scala.language.postfixOps
import game.states.GameState
import javax.swing.JPanel
import java.awt.Dimension
import java.awt.Image
import java.awt.Graphics
import java.awt.Graphics2D
import graphics.sprites.spritesheet.SpriteSheetLoader

final class GameSurface private[ui] (width: Int, height: Int) {

   //We can't create the back buffer image directly
   private var backBuffer : Image = null
  
   val panel : JPanel = new JPanel() {
     override def paintComponent(g: Graphics) = {
       super.paintComponent(g)
       
       //We'll draw the back buffer image if it exists
       if(backBuffer != null) {
         g drawImage(backBuffer, 0, 0, null)
       }
     }
   }
   
   panel setPreferredSize(new Dimension(width, height))
     
   
   private[ui] def draw(state : GameState) : Unit = {
     
     val panelWidth = panel getWidth
     val panelHeight = panel getHeight
     
     /* First we'll check if the back buffer is created or if panel dimension
      * have changed */
     if(backBuffer == null || panelWidth != width || panelHeight != height) {
       backBuffer = panel createImage(panelWidth, panelHeight)
     }
     
     val gBuf = backBuffer.getGraphics().asInstanceOf[Graphics2D]
     state render(gBuf)     
     gBuf dispose
     
     panel repaint()
   }
}