package graphics.sprites

/**
 * Represents a sprite for the game
 */

trait Sprite {

  def dimension () : (Int, Int)
    
  def scaled (x:Double) : Sprite
  
  def renderAt (g: java.awt.Graphics2D, x:Int, y:Int) : Unit
}