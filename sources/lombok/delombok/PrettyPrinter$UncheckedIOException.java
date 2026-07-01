package lombok.delombok;

import java.io.IOException;

/* JADX INFO: loaded from: app.apk:lombok/delombok/PrettyPrinter$UncheckedIOException.SCL.lombok */
public final class PrettyPrinter$UncheckedIOException extends RuntimeException {
    PrettyPrinter$UncheckedIOException(IOException source) {
        super(toMsg(source));
        setStackTrace(source.getStackTrace());
    }

    private static String toMsg(Throwable t) {
        String msg = t.getMessage();
        String n = t.getClass().getSimpleName();
        return (msg == null || msg.isEmpty()) ? n : String.valueOf(n) + ": " + msg;
    }
}
