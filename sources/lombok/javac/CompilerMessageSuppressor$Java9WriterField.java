package lombok.javac;

import com.sun.tools.javac.util.Log;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.Map;

/* JADX INFO: loaded from: app.apk:lombok/javac/CompilerMessageSuppressor$Java9WriterField.SCL.lombok */
class CompilerMessageSuppressor$Java9WriterField implements CompilerMessageSuppressor$WriterField {
    private final Field field;
    private final Object key;
    private PrintWriter writer;

    public CompilerMessageSuppressor$Java9WriterField(Field field, Object key) {
        this.field = field;
        this.key = key;
    }

    @Override // lombok.javac.CompilerMessageSuppressor$WriterField
    public void pauze(Log log) {
        try {
            Map<Object, PrintWriter> map = (Map) this.field.get(log);
            this.writer = map.get(this.key);
            map.put(this.key, NO_WRITER);
        } catch (Exception unused) {
        }
    }

    @Override // lombok.javac.CompilerMessageSuppressor$WriterField
    public void resume(Log log) {
        if (this.writer != null) {
            try {
                Map<Object, PrintWriter> map = (Map) this.field.get(log);
                map.put(this.key, this.writer);
            } catch (Exception unused) {
            }
        }
        this.writer = null;
    }
}
