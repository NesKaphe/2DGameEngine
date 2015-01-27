package graphics.sprites.spritesheet

import java.awt.image.BufferedImage
import java.net.URL
import java.io.File;
import javax.imageio.ImageIO;

object SpriteSheetLoader {

  private def checkDimensions(spriteWidth : Int, spriteHeight : Int) : Unit = {
    if(spriteWidth < 0 || spriteHeight < 0)
      throw new IllegalArgumentException("Illegal sprite dimension")
  }
  
  def loadFromFile(filePath : String, 
      spriteWidth : Int, spriteHeight : Int) : SpriteSheet = {
    
    loadFromFile(new File(filePath), spriteWidth, spriteHeight)
  }
  
  def loadFromFile(file : File,
      spriteWidth : Int, spriteHeight : Int) : SpriteSheet = {
    
    checkDimensions(spriteWidth, spriteHeight)
    
    val img = ImageIO read(file)
    
    new SpriteSheet(img, spriteWidth, spriteHeight)
  }
  
  def loadFromUrl(url : String,
      spriteWidth : Int, spriteHeight : Int) : SpriteSheet = {
    
    loadFromUrl(new URL(url), spriteWidth, spriteHeight)
  }
  
  def loadFromUrl(url : URL,
      spriteWidth : Int, spriteHeight : Int) : SpriteSheet = {
    checkDimensions(spriteWidth, spriteHeight)
    
    val img = ImageIO read(url)
    
    new SpriteSheet(img, spriteWidth, spriteHeight)
  }
}
