import grails.util.BuildSettings
import grails.util.Environment
import org.springframework.boot.logging.logback.ColorConverter
import org.springframework.boot.logging.logback.WhitespaceThrowableProxyConverter

import java.nio.charset.Charset

conversionRule 'clr', ColorConverter
conversionRule 'wex', WhitespaceThrowableProxyConverter

def targetDir = BuildSettings.TARGET_DIR

// See http://logback.qos.ch/manual/groovy.html for details on configuration
appender('STDOUT', ConsoleAppender) {
    encoder(PatternLayoutEncoder) {
        charset = Charset.forName('UTF-8')

        pattern =
                '%clr(%d{yyyy-MM-dd HH:mm:ss.SSS}){faint} ' + // Date
                        '%clr(%5p) ' + // Log level
                        '%clr(---){faint} %clr([%15.15t]){faint} ' + // Thread
                        '%clr(%-40.40logger{39}){cyan} %clr(:){faint} ' + // Logger
                        '%m%n%wex' // Message
    }
}
appender("FILE",FileAppender){
    file="${targetDir}/testFile.log"
    append=true
    encoder(PatternLayoutEncoder){
        pattern="%level%logger-%msg%n"
    }
}

appender("ROLLING_FILE",RollingFileAppender){
    append=true
    encoder(PatternLayoutEncoder){
        pattern="%level%logger-%msg%n"
    }
    rollingPolicy(TimeBasedRollingPolicy){
        fileNamePattern="${targetDir}/myApp-%d{yyyy-MM-dd_HH-mm}.log"
        maxHistory=30
        totalSizeCap="2GB"
    }
}

if (Environment.isDevelopmentMode() && targetDir != null) {
    appender("FULL_STACKTRACE", FileAppender) {
        file = "${targetDir}/stacktrace.log"
        append = true
        encoder(PatternLayoutEncoder) {
            pattern = "%level %logger - %msg%n"
        }
    }
    logger("StackTrace", ERROR, ['FULL_STACKTRACE'], false)
}
logger 'ch.fhnw.youbarter', INFO, ['STDOUT'], false
root(ERROR, ['STDOUT'])
