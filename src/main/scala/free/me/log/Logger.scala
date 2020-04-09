package free.me.log
import cats.effect.Sync
import io.chrisdavenport.log4cats.SelfAwareStructuredLogger
import io.chrisdavenport.log4cats.slf4j.Slf4jLogger

import scala.language.higherKinds

/**
  * Basic vanilla SLF4J logger.
  */
object Logger {

  /**
    * Create a safe logger
    * @tparam F effect type e.g. [[cats.effect.IO]] to wrap logger in.
    * @return [[SelfAwareStructuredLogger]] fit in an effect type.
    */
  def safeLogger[F[_]: Sync](name: String): F[SelfAwareStructuredLogger[F]] =
    Slf4jLogger.fromName(name.replace('$', ' '))
}
