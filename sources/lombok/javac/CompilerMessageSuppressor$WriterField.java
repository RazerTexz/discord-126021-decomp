package lombok.javac;

import com.sun.tools.javac.util.Log;
import java.io.PrintWriter;

/* JADX INFO: loaded from: app.apk:lombok/javac/CompilerMessageSuppressor$WriterField.SCL.lombok */
interface CompilerMessageSuppressor$WriterField {
    public static final PrintWriter NO_WRITER = new PrintWriter(new CompilerMessageSuppressor$WriterField$1());
    public static final CompilerMessageSuppressor$WriterField NONE = new CompilerMessageSuppressor$WriterField$2();

    void pauze(Log log);

    void resume(Log log);
}
