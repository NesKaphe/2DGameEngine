package graphics.sprites

import scala.language.postfixOps

import core.utils.idGenerator
import core.utils.TimedChain

/**
 * SpriteAnimation is a concrete implementation of an animation of sprites
 * using a TimedChain and a sequence of sprites
 * @author Alain Dias
 */
class SpriteAnimation(private var _animationSpeed: Double, 
    val repeatable : Boolean) extends TimedChain[Sprite] {
  
  private var _sprites = Seq[Sprite]()
  private val id = idGenerator id
  
  def toSeq() = _sprites
  
  def add(sprite: Sprite): Unit = {
    _sprites = _sprites :+ sprite
  }
  
  def addSet(spriteSet: Seq[Sprite]): Unit = {
    _sprites = _sprites ++ spriteSet
  }
  
  def copy(): SpriteAnimation = {
    val anim = new SpriteAnimation(_animationSpeed, repeatable)
    anim ++ _sprites
    anim
  }
  
  def current() = {
    _sprites length match {
      case 0 => None
      case _ => Some(_sprites(currentIndex))
    }
    
  }
  
  def len() = _sprites length
  
  override def equals(o: Any) : Boolean = {
    o match {
      case sa : SpriteAnimation => id == sa.id
      case _ => false
    }
  }
  
  /* Syntaxic sugar */
  def fps_=(newFPS: Int) = clockRate_=(newFPS)
}
