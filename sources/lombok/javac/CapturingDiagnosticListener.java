package lombok.javac;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.tools.Diagnostic;
import javax.tools.Diagnostic$Kind;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;

/* JADX INFO: loaded from: app.apk:lombok/javac/CapturingDiagnosticListener.SCL.lombok */
public class CapturingDiagnosticListener implements DiagnosticListener<JavaFileObject> {
    private final File file;
    private final Collection<CapturingDiagnosticListener$CompilerMessage> messages;

    public CapturingDiagnosticListener(File file, Collection<CapturingDiagnosticListener$CompilerMessage> messages) {
        this.file = file;
        this.messages = messages;
    }

    public void report(Diagnostic<? extends JavaFileObject> d) {
        String msg = d.getMessage(Locale.ENGLISH);
        Matcher m = Pattern.compile("^" + Pattern.quote(this.file.getAbsolutePath()) + "\\s*:\\s*\\d+\\s*:\\s*(?:warning:\\s*)?(.*)$", 32).matcher(msg);
        if (m.matches()) {
            msg = m.group(1);
        }
        if (msg.equals("deprecated item is not annotated with @Deprecated")) {
            return;
        }
        this.messages.add(new CapturingDiagnosticListener$CompilerMessage(d.getLineNumber(), d.getStartPosition(), d.getKind() == Diagnostic$Kind.ERROR, msg));
    }

    public void suppress(int start, int end) {
        Iterator<CapturingDiagnosticListener$CompilerMessage> it = this.messages.iterator();
        while (it.hasNext()) {
            long pos = it.next().getPosition();
            if (pos >= start && pos < end) {
                it.remove();
            }
        }
    }
}
