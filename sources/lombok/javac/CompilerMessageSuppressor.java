package lombok.javac;

import com.sun.tools.javac.util.Context;
import com.sun.tools.javac.util.JCDiagnostic;
import com.sun.tools.javac.util.ListBuffer;
import com.sun.tools.javac.util.Log;
import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import javax.tools.DiagnosticListener;
import javax.tools.JavaFileObject;
import lombok.permit.Permit;

/* JADX INFO: loaded from: app.apk:lombok/javac/CompilerMessageSuppressor.SCL.lombok */
public final class CompilerMessageSuppressor {
    private final Log log;
    private Boolean dumpOnError;
    private Boolean promptOnError;
    private DiagnosticListener<?> contextDiagnosticListener;
    private DiagnosticListener<?> logDiagnosticListener;
    private final Context context;
    private static final ConcurrentMap<Class<?>, Field> handlerDeferredFields = new ConcurrentHashMap();
    private static final ThreadLocal<Queue<?>> queueCache = new ThreadLocal<>();
    private static final CompilerMessageSuppressor$WriterField errWriterField = createWriterField(CompilerMessageSuppressor$Writers.ERROR);
    private static final CompilerMessageSuppressor$WriterField warnWriterField = createWriterField(CompilerMessageSuppressor$Writers.WARNING);
    private static final CompilerMessageSuppressor$WriterField noticeWriterField = createWriterField(CompilerMessageSuppressor$Writers.NOTICE);
    private static final Field dumpOnErrorField = getDeclaredField(Log.class, "dumpOnError");
    private static final Field promptOnErrorField = getDeclaredField(Log.class, "promptOnError");
    private static final Field diagnosticListenerField = getDeclaredField(Log.class, "diagListener");
    private static final Field deferDiagnosticsField = getDeclaredField(Log.class, "deferDiagnostics");
    private static final Field deferredDiagnosticsField = getDeclaredField(Log.class, "deferredDiagnostics");
    private static final Field diagnosticHandlerField = getDeclaredField(Log.class, "diagnosticHandler");
    private static final Field NULL_FIELD = getDeclaredField(JavacResolution.class, "NULL_FIELD");

    static Field getDeclaredField(Class<?> c, String fieldName) {
        try {
            return Permit.getField(c, fieldName);
        } catch (Throwable unused) {
            return null;
        }
    }

    public CompilerMessageSuppressor(Context context) {
        this.log = Log.instance(context);
        this.context = context;
    }

    public void disableLoggers() {
        this.contextDiagnosticListener = (DiagnosticListener) this.context.get(DiagnosticListener.class);
        this.context.put(DiagnosticListener.class, (Object) null);
        errWriterField.pauze(this.log);
        warnWriterField.pauze(this.log);
        noticeWriterField.pauze(this.log);
        if (deferDiagnosticsField != null) {
            try {
                if (Boolean.TRUE.equals(deferDiagnosticsField.get(this.log))) {
                    queueCache.set((Queue) deferredDiagnosticsField.get(this.log));
                    Queue<?> empty = new LinkedList<>();
                    deferredDiagnosticsField.set(this.log, empty);
                }
            } catch (Exception unused) {
            }
        }
        if (diagnosticHandlerField != null) {
            try {
                Object handler = diagnosticHandlerField.get(this.log);
                Field field = getDeferredField(handler);
                if (field != null) {
                    queueCache.set((Queue) field.get(handler));
                    Queue<?> empty2 = new LinkedList<>();
                    field.set(handler, empty2);
                }
            } catch (Exception unused2) {
            }
        }
        if (dumpOnErrorField != null) {
            try {
                this.dumpOnError = (Boolean) dumpOnErrorField.get(this.log);
                dumpOnErrorField.set(this.log, false);
            } catch (Exception unused3) {
            }
        }
        if (promptOnErrorField != null) {
            try {
                this.promptOnError = (Boolean) promptOnErrorField.get(this.log);
                promptOnErrorField.set(this.log, false);
            } catch (Exception unused4) {
            }
        }
        if (diagnosticListenerField != null) {
            try {
                this.logDiagnosticListener = (DiagnosticListener) diagnosticListenerField.get(this.log);
                diagnosticListenerField.set(this.log, null);
            } catch (Exception unused5) {
            }
        }
    }

    private static Field getDeferredField(Object handler) {
        Class<?> cls = handler.getClass();
        Field field = handlerDeferredFields.get(cls);
        if (field != null) {
            if (field == NULL_FIELD) {
                return null;
            }
            return field;
        }
        Field value = getDeclaredField(cls, "deferred");
        handlerDeferredFields.put(cls, value == null ? NULL_FIELD : value);
        return getDeferredField(handler);
    }

    public void enableLoggers() {
        if (this.contextDiagnosticListener != null) {
            this.context.put(DiagnosticListener.class, this.contextDiagnosticListener);
            this.contextDiagnosticListener = null;
        }
        errWriterField.resume(this.log);
        warnWriterField.resume(this.log);
        noticeWriterField.resume(this.log);
        if (this.dumpOnError != null) {
            try {
                dumpOnErrorField.set(this.log, this.dumpOnError);
                this.dumpOnError = null;
            } catch (Exception unused) {
            }
        }
        if (this.promptOnError != null) {
            try {
                promptOnErrorField.set(this.log, this.promptOnError);
                this.promptOnError = null;
            } catch (Exception unused2) {
            }
        }
        if (this.logDiagnosticListener != null) {
            try {
                diagnosticListenerField.set(this.log, this.logDiagnosticListener);
                this.logDiagnosticListener = null;
            } catch (Exception unused3) {
            }
        }
        if (diagnosticHandlerField != null && queueCache.get() != null) {
            try {
                Object handler = diagnosticHandlerField.get(this.log);
                Field field = getDeferredField(handler);
                if (field != null) {
                    field.set(handler, queueCache.get());
                    queueCache.set(null);
                }
            } catch (Exception unused4) {
            }
        }
        if (deferDiagnosticsField != null && queueCache.get() != null) {
            try {
                deferredDiagnosticsField.set(this.log, queueCache.get());
                queueCache.set(null);
            } catch (Exception unused5) {
            }
        }
    }

    public void removeAllBetween(JavaFileObject sourcefile, int startPos, int endPos) {
        DiagnosticListener<?> listener = (DiagnosticListener) this.context.get(DiagnosticListener.class);
        if (listener instanceof CapturingDiagnosticListener) {
            ((CapturingDiagnosticListener) listener).suppress(startPos, endPos);
        }
        Field field = null;
        Object receiver = null;
        if (deferDiagnosticsField != null) {
            try {
                if (Boolean.TRUE.equals(deferDiagnosticsField.get(this.log))) {
                    field = deferredDiagnosticsField;
                    receiver = this.log;
                }
            } catch (Exception unused) {
            }
        }
        if (diagnosticHandlerField != null) {
            try {
                Object handler = diagnosticHandlerField.get(this.log);
                field = getDeferredField(handler);
                receiver = handler;
            } catch (Exception unused2) {
            }
        }
        if (field == null || receiver == null) {
            return;
        }
        try {
            ListBuffer<?> deferredDiagnostics = (ListBuffer) field.get(receiver);
            ListBuffer<Object> newDeferredDiagnostics = new ListBuffer<>();
            for (Object diag_ : deferredDiagnostics) {
                if (!(diag_ instanceof JCDiagnostic)) {
                    newDeferredDiagnostics.add(diag_);
                } else {
                    JCDiagnostic diag = (JCDiagnostic) diag_;
                    long here = diag.getStartPosition();
                    if (here < startPos || here >= endPos || diag.getSource() != sourcefile) {
                        newDeferredDiagnostics.add(diag);
                    }
                }
            }
            field.set(receiver, newDeferredDiagnostics);
        } catch (Exception unused3) {
        }
    }

    private static CompilerMessageSuppressor$WriterField createWriterField(CompilerMessageSuppressor$Writers w) {
        try {
            Field writers = getDeclaredField(Log.class, "writer");
            if (writers != null) {
                Class<?> kindsClass = Class.forName("com.sun.tools.javac.util.Log$WriterKind");
                for (Object enumConstant : kindsClass.getEnumConstants()) {
                    if (enumConstant.toString().equals(w.keyName)) {
                        return new CompilerMessageSuppressor$Java9WriterField(writers, enumConstant);
                    }
                }
                return CompilerMessageSuppressor$WriterField.NONE;
            }
        } catch (Exception unused) {
        }
        Field writerField = getDeclaredField(Log.class, w.fieldName);
        return writerField != null ? new CompilerMessageSuppressor$Java8WriterField(writerField) : CompilerMessageSuppressor$WriterField.NONE;
    }
}
