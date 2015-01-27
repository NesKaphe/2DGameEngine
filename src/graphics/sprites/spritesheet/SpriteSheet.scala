package graphics.sprites.spritesheet

import java.awt.image.BufferedImage
import Array._
import graphics.sprites.Sprite
import graphics.sprites.StaticSprite

class SpriteSheet private[spritesheet] (
    private val _spriteSheet : BufferedImage, 
    val spriteWidth : Int, val spriteHeight : Int
    ) {
  
  val spriteSheetWidth  : Int = _spriteSheet.getWidth
  val spriteSheetHeight : Int = _spriteSheet.getHeight
  
  /* Number of columns = how much sprites on a line */
  val spritesPerLine : Int = spriteSheetWidth / spriteWidth 
  /* Number of lines = how much sprites on a column */
  val spritesPerCol  : Int = spriteSheetHeight / spriteHeight
  
  val sprites = ofDim[Sprite](spritesPerCol, spritesPerLine)
  
  for(line <- 0 to spritesPerCol - 1) {
    for(column <- 0 to spritesPerLine - 1) {
      val subImage = _spriteSheet getSubimage(
          column * spriteWidth,
          line * spriteHeight,
          spriteWidth,
          spriteHeight
      )
      
      sprites(line)(column) = new StaticSprite(subImage)
    }
  }
  
  /**
   * return the sprite at the position in the spritesheet specified
   * by the parameters line and column
   * @note the parameters must be counted from 0
   */
  def getSprite(line : Int, column : Int) : Option[Sprite] = {
    if(line < 0 
        || line > spritesPerCol - 1 
        || column < 0 
        || column > spritesPerLine - 1
       ) { 
      None
    }
      
      
    Some(sprites(line)(column))
  }
  
  /**
   * returns the sprite specified by the parameter numSprite
   * @note numSprite must be counted from 0
   */
  def getSprite(numSprite : Int) : Option[Sprite] = {
    
    if(numSprite < 0)
      None
      
    val line = Math.floorDiv(numSprite, spritesPerLine)
    val column = numSprite % spritesPerLine
    
    getSprite(line, column)
  }  
  
  def getScaledSprite(line : Int, column : Int, scale : Double) = {
    getSprite(line, column) match {
      case None => None
      case Some(sprite) => Some(sprite scaled scale)
    }
  }
  
  def getScaledSprite(numSprite: Int, scale : Double) = {
    getSprite(numSprite) match {
      case None => None
      case Some(sprite) => Some(sprite scaled scale)
    }
  }
}
