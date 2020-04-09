package free.me.log
import cats.effect.{IO, Sync}
object LoggerTest extends App {
  val ioLogger = Logger.safeLogger[IO](this.getClass.getName)
  Sync[IO]
  // delay some operation -- here for testing it happens to be throw new Exception("yoyo")
    .delay[String](throw new Exception("yoyo"))
    .attempt // attempt makes it either.
    .flatMap {
      case Left(value) => ioLogger.flatMap(e => e.error(s"failed due to: $value"))
      case Right(v)    =>
        // if all went well use this.
        Sync[IO].pure[String](v)
    }
    // finally end of the world
    .unsafeRunSync()
}
