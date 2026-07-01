package lombok.javac;

import com.sun.tools.javac.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Field;

/* JADX INFO: loaded from: app.apk:lombok/javac/CompilerMessageSuppressor$Java8WriterField.SCL.lombok */
class CompilerMessageSuppressor$Java8WriterField implements CompilerMessageSuppressor$WriterField {
    private final Field field;
    private PrintWriter writer;

    public CompilerMessageSuppressor$Java8WriterField(Field field) {
        this.field = field;
    }

    @Override // lombok.javac.CompilerMessageSuppressor$WriterField
    public void pauze(Log log) {
        try {
            this.writer = (PrintWriter) this.field.get(log);
            this.field.set(log, NO_WRITER);
        } catch (Exception unused) {
        }
    }

    @Override // lombok.javac.CompilerMessageSuppressor$WriterField
    public void resume(Log log) {
        if (this.writer != null) {
            try {
                this.field.set(log, this.writer);
            } catch (Exception unused) {
            }
        }
        this.writer = null;
    }
}
