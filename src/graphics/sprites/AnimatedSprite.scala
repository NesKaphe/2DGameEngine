package graphics.sprites

import java.awt.Graphics2D
import core.animations.Animator
import core.animations.SpritePlayer

class AnimatedSprite (private val _animation: SpriteAnimation) extends Sprite {

  require (_animation.len() > 0)
  
  def dimension () : (Int, Int) = (_animation current).get dimension
    
  def scaled (x:Double) : Sprite = {
    var sprites = _animation toSeq
    
    sprites = sprites.map(_.scaled(x))
    val anim = new SpriteAnimation(_animation animationSpeed,
        _animation repeatable)
    anim ++ sprites
    Animator.register(anim)
    
    new AnimatedSprite(anim)
  }
  
  def renderAt (g: Graphics2D, x: Int, y: Int) : Unit = {
    val spriteToDraw = _animation current
    
    spriteToDraw match {
      case Some(sprite) => sprite renderAt(g, x, y)
      case None => () /* Nothing but maybe something in future */
    }
  }
  
  def play () : Unit = _animation start
  
  def stop () : Unit  = _animation stop
  
  def pause () : Unit = _animation pause
  
}
