package lombok.javac.apt;

import java.io.IOException;
import javax.tools.FileObject;
import javax.tools.ForwardingJavaFileManager;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileManager$Location;
import javax.tools.JavaFileObject;
import javax.tools.JavaFileObject$Kind;
import lombok.core.DiagnosticsReceiver;

/* JADX INFO: loaded from: app.apk:lombok/javac/apt/InterceptingJavaFileManager.SCL.lombok */
final class InterceptingJavaFileManager extends ForwardingJavaFileManager<JavaFileManager> {
    private final DiagnosticsReceiver diagnostics;
    private final LombokFileObjects$Compiler compiler;

    InterceptingJavaFileManager(JavaFileManager original, DiagnosticsReceiver diagnostics) {
        super(original);
        this.compiler = LombokFileObjects.getCompiler(original);
        this.diagnostics = diagnostics;
    }

    public JavaFileObject getJavaFileForOutput(JavaFileManager$Location location, String className, JavaFileObject$Kind kind, FileObject sibling) throws IOException {
        JavaFileObject fileObject = this.fileManager.getJavaFileForOutput(location, className, kind, sibling);
        return kind != JavaFileObject$Kind.CLASS ? fileObject : LombokFileObjects.createIntercepting(this.compiler, fileObject, className, this.diagnostics);
    }
}
