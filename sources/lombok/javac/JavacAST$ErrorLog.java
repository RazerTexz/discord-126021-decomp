package lombok.javac;

import com.sun.tools.javac.util.JCDiagnostic$DiagnosticPosition;
import com.sun.tools.javac.util.Log;
import java.lang.reflect.Field;
import javax.annotation.processing.Messager;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST$ErrorLog.SCL.lombok */
abstract class JavacAST$ErrorLog {
    final Log log;
    private final Messager messager;
    private final Field errorCount;
    private final Field warningCount;

    abstract void error1(JCDiagnostic$DiagnosticPosition jCDiagnostic$DiagnosticPosition, String str);

    abstract void warning1(JCDiagnostic$DiagnosticPosition jCDiagnostic$DiagnosticPosition, String str);

    abstract void mandatoryWarning1(JCDiagnostic$DiagnosticPosition jCDiagnostic$DiagnosticPosition, String str);

    abstract void note(JCDiagnostic$DiagnosticPosition jCDiagnostic$DiagnosticPosition, String str);

    private JavacAST$ErrorLog(Log log, Messager messager, Field errorCount, Field warningCount) {
        this.log = log;
        this.messager = messager;
        this.errorCount = errorCount;
        this.warningCount = warningCount;
    }

    /* synthetic */ JavacAST$ErrorLog(Log log, Messager messager, Field field, Field field2, JavacAST$ErrorLog javacAST$ErrorLog) {
        this(log, messager, field, field2);
    }

    final void error(JCDiagnostic$DiagnosticPosition pos, String message) {
        increment(this.errorCount);
        error1(pos, message);
    }

    final void warning(JCDiagnostic$DiagnosticPosition pos, String message) {
        increment(this.warningCount);
        warning1(pos, message);
    }

    final void mandatoryWarning(JCDiagnostic$DiagnosticPosition pos, String message) {
        increment(this.warningCount);
        mandatoryWarning1(pos, message);
    }

    private void increment(Field field) {
        if (field == null) {
            return;
        }
        try {
            int val = ((Number) field.get(this.messager)).intValue();
            field.set(this.messager, Integer.valueOf(val + 1));
        } catch (Throwable unused) {
        }
    }

    static JavacAST$ErrorLog create(Messager messager, Log log) {
        Field errorCount;
        Field warningCount;
        try {
            errorCount = Permit.getField(messager.getClass(), "errorCount");
        } catch (Throwable unused) {
            errorCount = null;
        }
        boolean hasMultipleErrors = false;
        for (Field field : log.getClass().getFields()) {
            if (field.getName().equals("multipleErrors")) {
                hasMultipleErrors = true;
                break;
            }
        }
        if (hasMultipleErrors) {
            return new JavacAST$JdkBefore9(log, messager, errorCount, null);
        }
        try {
            warningCount = Permit.getField(messager.getClass(), "warningCount");
        } catch (Throwable unused2) {
            warningCount = null;
        }
        return new JavacAST$Jdk9Plus(log, messager, errorCount, warningCount, null);
    }
}
