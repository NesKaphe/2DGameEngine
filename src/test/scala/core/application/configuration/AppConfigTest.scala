package core.application.configuration

import org.scalatest.FlatSpec
import org.scalatest.Matchers

class AppConfigTest extends FlatSpec with Matchers {

  it should "get created with goodConf.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
           getClass.getResource("/config/goodConf.conf").getPath
         )
    
    config should not equal(None)
  }
  
  it should "not be created with confWithoutHeight.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confWithoutHeight.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confWithoutWidth.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confWithoutWidth.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confWithoutFps.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confWithoutFps.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confWithoutTitle.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confWithoutTitle.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confBadValueFps.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confBadValueFps.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confBadValueTitle.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confBadValueTitle.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confBadValueHeight.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confBadValueHeight.conf").getPath
        )
    
    config should equal(None)
  }
  
  it should "not be created with confBadValueHWidth.conf" in {
    val config = AppConfigMaker.loadFromFilePath(
          getClass.getResource("/config/confBadValueWidth.conf").getPath
        )
    
    config should equal(None)
  }
}