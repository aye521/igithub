import ch.qos.logback.classic.encoder.PatternLayoutEncoder
import ch.qos.logback.core.ConsoleAppender
 
import static ch.qos.logback.classic.Level.DEBUG
import static ch.qos.logback.classic.Level.INFO
 
appender("STDOUT", ConsoleAppender) {
  encoder(PatternLayoutEncoder) {
    pattern = "%d{HH:mm:ss.SSS} - %msg%n"
  }
}
 
logger("com.javacodegeeks.examples.logbackexample.beans", INFO)
logger("proxy", INFO)
root(DEBUG, ["STDOUT"])