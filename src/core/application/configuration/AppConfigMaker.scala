package core.application.configuration

/**
 * AppConfigMaker will help to get a valid configuration for the Application
 * we want to create. Using this object will ensure that the configuration
 * is valid.
 */
object AppConfigMaker extends MakerAttributes 
                      with GenConfig 
                      with FileConfigParse