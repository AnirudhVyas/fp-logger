package free.me.log
import cats.effect.{IO, Sync}
object LoggerTest extends App {
  val ioLogger =
    Logger.safeLogger[IO](this.getClass.getName)
  Sync[IO]
    .delay[String](throw new Exception("yoyo"))
    .attempt
    .flatMap {
      case Left(value) =>
        ioLogger.flatMap(e => e.error(s"failed due to: $value"))
      case Right(v) => Sync[IO].pure[String](v)
    }
    .unsafeRunSync()
}
