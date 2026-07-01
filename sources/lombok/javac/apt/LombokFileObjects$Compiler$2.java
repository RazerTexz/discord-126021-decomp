package lombok.javac.apt;

import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.tools.JavaFileObject;

/* JADX INFO: loaded from: app.apk:lombok/javac/apt/LombokFileObjects$Compiler$2.SCL.lombok */
class LombokFileObjects$Compiler$2 implements LombokFileObjects$Compiler {
    private Method decoderMethod = null;
    private final AtomicBoolean decoderIsSet = new AtomicBoolean();

    LombokFileObjects$Compiler$2() {
    }

    @Override // lombok.javac.apt.LombokFileObjects$Compiler
    public JavaFileObject wrap(LombokFileObject fileObject) {
        return new Javac7BaseFileObjectWrapper(fileObject);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Throwable, java.util.concurrent.atomic.AtomicBoolean] */
    @Override // lombok.javac.apt.LombokFileObjects$Compiler
    public Method getDecoderMethod() {
        ?? r0 = this.decoderIsSet;
        synchronized (r0) {
            try {
                if (this.decoderIsSet.get()) {
                    return this.decoderMethod;
                }
                this.decoderMethod = LombokFileObjects.getDecoderMethod("com.sun.tools.javac.file.BaseFileObject");
                this.decoderIsSet.set(true);
                return this.decoderMethod;
            } catch (Throwable th) {
                throw r0;
            }
        }
    }
}
