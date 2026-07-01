package lombok.javac.apt;

import java.lang.reflect.Method;
import javax.tools.JavaFileObject;

/* JADX INFO: loaded from: app.apk:lombok/javac/apt/LombokFileObjects$Compiler.SCL.lombok */
interface LombokFileObjects$Compiler {
    public static final LombokFileObjects$Compiler JAVAC6 = new LombokFileObjects$Compiler$1();
    public static final LombokFileObjects$Compiler JAVAC7 = new LombokFileObjects$Compiler$2();

    JavaFileObject wrap(LombokFileObject lombokFileObject);

    Method getDecoderMethod();
}
