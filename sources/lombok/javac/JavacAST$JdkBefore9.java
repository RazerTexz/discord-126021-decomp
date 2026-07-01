package lombok.javac;

import com.sun.tools.javac.util.JCDiagnostic$DiagnosticPosition;
import com.sun.tools.javac.util.Log;
import java.lang.reflect.Field;
import javax.annotation.processing.Messager;

/* JADX INFO: loaded from: app.apk:lombok/javac/JavacAST$JdkBefore9.SCL.lombok */
class JavacAST$JdkBefore9 extends JavacAST$ErrorLog {
    /* synthetic */ JavacAST$JdkBefore9(Log log, Messager messager, Field field, JavacAST$JdkBefore9 javacAST$JdkBefore9) {
        this(log, messager, field);
    }

    private JavacAST$JdkBefore9(Log log, Messager messager, Field errorCount) {
        super(log, messager, errorCount, null, null);
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void error1(JCDiagnostic$DiagnosticPosition pos, String message) {
        boolean prev = this.log.multipleErrors;
        this.log.multipleErrors = true;
        try {
            this.log.error(pos, "proc.messager", new Object[]{message});
        } finally {
            this.log.multipleErrors = prev;
        }
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void warning1(JCDiagnostic$DiagnosticPosition pos, String message) {
        this.log.warning(pos, "proc.messager", new Object[]{message});
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void mandatoryWarning1(JCDiagnostic$DiagnosticPosition pos, String message) {
        this.log.mandatoryWarning(pos, "proc.messager", new Object[]{message});
    }

    @Override // lombok.javac.JavacAST$ErrorLog
    void note(JCDiagnostic$DiagnosticPosition pos, String message) {
        this.log.note(pos, "proc.messager", new Object[]{message});
    }
}
