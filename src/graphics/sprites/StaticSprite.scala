package graphics.sprites

import core.utils.idGenerator

import java.awt.image.BufferedImage
import java.awt.image.AffineTransformOp
import java.awt.geom.AffineTransform
import java.awt.Graphics2D

class StaticSprite (private val image : BufferedImage) extends Sprite {
  
  private val id = idGenerator id
  
  override def dimension() = (image getWidth, image getHeight)
   
  override def scaled(scale: Double) = {
    
    val tx = new AffineTransform()
    tx.scale(scale, scale)
    val op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR)
    val newSpriteImage = new BufferedImage(
                        (dimension._1 * scale).asInstanceOf[Int],
                        (dimension._2 * scale).asInstanceOf[Int],
                        image.getType()
                        )
    new StaticSprite(op.filter(image, newSpriteImage))
    
  }

  override def renderAt(g: Graphics2D, x: Int, y: Int) = {
    g drawImage(image, x, y, null)
  }
  
  override def equals(o: Any) : Boolean = {
    o match {
      case ss : StaticSprite => id == ss.id
      case _ => false
    }
  }
  
}