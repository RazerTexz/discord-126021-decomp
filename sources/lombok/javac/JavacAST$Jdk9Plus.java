package lombok.javac;

import com.sun.tools.javac.util.JCDiagnostic$DiagnosticPosition;
import com.sun.tools.javac.util.JCDiagnostic$Factory;
import com.sun.tools.javac.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import javax.annotation.processing.Messager;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST$Jdk9Plus.SCL.lombok */
class JavacAST$Jdk9Plus extends JavacAST$ErrorLog {
    private static final String PROC_MESSAGER = "proc.messager";
    private Object multiple;
    private Method errorMethod;
    private Method warningMethod;
    private Method mandatoryWarningMethod;
    private Method noteMethod;
    private Method errorKey;
    private Method warningKey;
    private Method noteKey;
    private JCDiagnostic$Factory diags;

    /* synthetic */ JavacAST$Jdk9Plus(Log log, Messager messager, Field field, Field field2, JavacAST$Jdk9Plus javacAST$Jdk9Plus) {
        this(log, messager, field, field2);
    }

    private JavacAST$Jdk9Plus(Log log, Messager messager, Field errorCount, Field warningCount) {
        super(log, messager, errorCount, warningCount, null);
        try {
            Class<?> df = Class.forName("com.sun.tools.javac.util.JCDiagnostic$DiagnosticFlag");
            for (Object constant : df.getEnumConstants()) {
                if (constant.toString().equals("MULTIPLE")) {
                    this.multiple = constant;
                }
            }
            Class<?> errorCls = Class.forName("com.sun.tools.javac.util.JCDiagnostic$Error");
            Class<?> warningCls = Class.forName("com.sun.tools.javac.util.JCDiagnostic$Warning");
            Class<?> noteCls = Class.forName("com.sun.tools.javac.util.JCDiagnostic$Note");
            Class<?> lc = log.getClass();
            this.errorMethod = Permit.getMethod(lc, "error", df, JCDiagnostic$DiagnosticPosition.class, errorCls);
            this.warningMethod = Permit.getMethod(lc, "warning", JCDiagnostic$DiagnosticPosition.class, warningCls);
            this.mandatoryWarningMethod = Permit.getMethod(lc, "mandatoryWarning", JCDiagnostic$DiagnosticPosition.class, warningCls);
            this.noteMethod = Permit.getMethod(lc, "note", JCDiagnostic$DiagnosticPosition.class, noteCls);
            Field diagsField = Permit.getField(lc.getSuperclass(), "diags");
            this.diags = (JCDiagnostic$Factory) diagsField.get(log);
            Class<?> dc = this.diags.getClass();
            this.errorKey = Permit.getMethod(dc, "errorKey", String.class, Object[].class);
            this.warningKey = Permit.getMethod(dc, "warningKey", String.class, Object[].class);
            this.noteKey = Permit.getMethod(dc, "noteKey", String.class, Object[].class);
        } catch (Throwable unused) {
        }
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void error1(JCDiagnostic$DiagnosticPosition pos, String message) {
        try {
            Object error = this.errorKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
            this.errorMethod.invoke(this.log, this.multiple, pos, error);
        } catch (Throwable unused) {
        }
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void warning1(JCDiagnostic$DiagnosticPosition pos, String message) {
        try {
            Object warning = this.warningKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
            this.warningMethod.invoke(this.log, pos, warning);
        } catch (Throwable unused) {
        }
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void mandatoryWarning1(JCDiagnostic$DiagnosticPosition pos, String message) {
        try {
            Object warning = this.warningKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
            this.mandatoryWarningMethod.invoke(this.log, pos, warning);
        } catch (Throwable unused) {
        }
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void note(JCDiagnostic$DiagnosticPosition pos, String message) {
        try {
            Object note = this.noteKey.invoke(this.diags, PROC_MESSAGER, new Object[]{message});
            this.noteMethod.invoke(this.log, pos, note);
        } catch (Throwable unused) {
        }
    }
}
