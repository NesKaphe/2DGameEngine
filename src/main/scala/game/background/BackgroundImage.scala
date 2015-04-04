package game.background

import game.camera.Camera
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import javax.imageio.ImageIO
import java.io.File

object BackGroundImage {
  
  def apply(imgPath : String, moveScale : Double) = {
    val img = ImageIO read(new File(imgPath))
    new BackgroundImage(img, moveScale)
  }
  
}

final class BackgroundImage private[background] 
    (private val img: BufferedImage,
     private val moveScale: Double) extends Background {

  
  override def renderAt(g: Graphics2D, camera: Camera) = {
    val x = (camera.offsetX * moveScale)
      .asInstanceOf[Int] % camera.visibleWidth
      
    val y = (camera.offsetY * moveScale)
      .asInstanceOf[Int] % camera.visibleHeight
      
    val lenXToDraw = camera.visibleWidth - x
    val lenYToDraw = camera.visibleHeight - y
    
    if(lenXToDraw != camera.visibleWidth || lenYToDraw != camera.visibleHeight){
      val subImage1 = 
        img.getSubimage(x, y, lenXToDraw, lenYToDraw)
        
      val subImage2 = 
        img.getSubimage(0, y, camera.visibleWidth - lenXToDraw, lenYToDraw)
        
      val subImage3 = 
        img.getSubimage(x, 0, lenXToDraw, camera.visibleHeight - lenYToDraw)
        
      val subImage4 = 
        img.getSubimage(0, 0, 
            camera.visibleWidth - lenXToDraw, 
            camera.visibleHeight - lenYToDraw
        )
        
      g.drawImage(subImage1, 0, 0, null)
      
      g.drawImage(subImage2, lenXToDraw, 0, null)
      
      g.drawImage(subImage3, 0, lenYToDraw, null)
      
      g.drawImage(subImage4, lenXToDraw, lenYToDraw, null)
    }
    else {
      g.drawImage(img, 0, 0, null)
    }
  }
  
}