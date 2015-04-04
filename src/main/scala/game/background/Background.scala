package game.background

import java.awt.Graphics2D
import game.camera.Camera

trait Background {

  def renderAt(g : Graphics2D, camera : Camera)
  
}