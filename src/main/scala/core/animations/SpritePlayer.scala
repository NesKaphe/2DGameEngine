package core.animations

import graphics.sprites.Sprite
import graphics.sprites.AnimatedSprite

/**
 * SpritePlayer provides a simple way to start sprite animations.
 * If a sprite doesn't contains an animation, nothing will happen
 */
object SpritePlayer {
  def animate(sprite : Sprite) : Unit = {
    sprite match {
      case as : AnimatedSprite => as play
      case _ => ()
    }
  }
  
  def stop(sprite : Sprite) : Unit = {
    sprite match {
      case as : AnimatedSprite => as stop
      case _ => ()
    }
  }
  
  def pause(sprite : Sprite) : Unit = {
    sprite match {
      case as : AnimatedSprite => as pause
      case _ => ()
    }
  }
}
