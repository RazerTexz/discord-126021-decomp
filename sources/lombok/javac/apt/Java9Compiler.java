package lombok.javac.apt;

import com.sun.tools.javac.file.BaseFileManager;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;

/* JADX INFO: compiled from: Javac9Compiler.java */
/* JADX INFO: loaded from: app.apk:lombok/javac/apt/Java9Compiler.SCL.lombok */
class Java9Compiler implements LombokFileObjects$Compiler {
    private final BaseFileManager fileManager;

    public Java9Compiler(JavaFileManager jfm) {
        this.fileManager = asBaseFileManager(jfm);
    }

    @Override // lombok.javac.apt.LombokFileObjects$Compiler
    public JavaFileObject wrap(LombokFileObject fileObject) {
        Path p;
        try {
            p = toPath(fileObject);
        } catch (Exception unused) {
            p = null;
        }
        return p != null ? new Javac9BaseFileObjectWrapper(this.fileManager, p, fileObject) : new Javac9JavaFileObjectWrapper(fileObject);
    }

    @Override // lombok.javac.apt.LombokFileObjects$Compiler
    public Method getDecoderMethod() {
        return null;
    }

    private static Path toPath(LombokFileObject fileObject) {
        URI uri = fileObject.toUri();
        if (uri.getScheme() == null) {
            uri = URI.create("file:///" + uri);
        }
        try {
            return Paths.get(uri);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Problems in URI '" + uri + "' (" + fileObject.toUri() + ")", e);
        }
    }

    private static BaseFileManager asBaseFileManager(JavaFileManager jfm) {
        if (jfm instanceof BaseFileManager) {
            return (BaseFileManager) jfm;
        }
        return new Java9Compiler$FileManagerWrapper(jfm);
    }
}
