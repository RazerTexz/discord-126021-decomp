package lombok.javac.apt;

import com.sun.tools.javac.file.BaseFileManager;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.Set;
import javax.tools.FileObject;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import lombok.javac.apt.LombokFileObjects;

/* JADX INFO: renamed from: lombok.javac.apt.Java9Compiler, reason: use source file name */
/* JADX INFO: compiled from: Javac9Compiler.java */
/* JADX INFO: loaded from: app.apk:lombok/javac/apt/Java9Compiler.SCL.lombok */
class Javac9Compiler implements LombokFileObjects.Compiler {
    private final BaseFileManager fileManager;

    public Javac9Compiler(JavaFileManager jfm) {
        this.fileManager = asBaseFileManager(jfm);
    }

    @Override // lombok.javac.apt.LombokFileObjects.Compiler
    public JavaFileObject wrap(LombokFileObject fileObject) {
        Path p;
        try {
            p = toPath(fileObject);
        } catch (Exception unused) {
            p = null;
        }
        return p != null ? new Javac9BaseFileObjectWrapper(this.fileManager, p, fileObject) : new Javac9JavaFileObjectWrapper(fileObject);
    }

    @Override // lombok.javac.apt.LombokFileObjects.Compiler
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
        return new FileManagerWrapper(jfm);
    }

    /* JADX INFO: renamed from: lombok.javac.apt.Java9Compiler$FileManagerWrapper */
    /* JADX INFO: compiled from: Javac9Compiler.java */
    /* JADX INFO: loaded from: app.apk:lombok/javac/apt/Java9Compiler$FileManagerWrapper.SCL.lombok */
    static class FileManagerWrapper extends BaseFileManager {
        JavaFileManager manager;

        public FileManagerWrapper(JavaFileManager manager) {
            super((Charset) null);
            this.manager = manager;
        }

        public int isSupportedOption(String option) {
            return this.manager.isSupportedOption(option);
        }

        public ClassLoader getClassLoader(JavaFileManager.Location location) {
            return this.manager.getClassLoader(location);
        }

        public Iterable<JavaFileObject> list(JavaFileManager.Location location, String packageName, Set<JavaFileObject.Kind> kinds, boolean recurse) throws IOException {
            return this.manager.list(location, packageName, kinds, recurse);
        }

        public String inferBinaryName(JavaFileManager.Location location, JavaFileObject file) {
            return this.manager.inferBinaryName(location, file);
        }

        public boolean isSameFile(FileObject a, FileObject b2) {
            return this.manager.isSameFile(a, b2);
        }

        public boolean handleOption(String current, Iterator<String> remaining) {
            return this.manager.handleOption(current, remaining);
        }

        public boolean hasLocation(JavaFileManager.Location location) {
            return this.manager.hasLocation(location);
        }

        public JavaFileObject getJavaFileForInput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind) throws IOException {
            return this.manager.getJavaFileForInput(location, className, kind);
        }

        public JavaFileObject getJavaFileForOutput(JavaFileManager.Location location, String className, JavaFileObject.Kind kind, FileObject sibling) throws IOException {
            return this.manager.getJavaFileForOutput(location, className, kind, sibling);
        }

        public FileObject getFileForInput(JavaFileManager.Location location, String packageName, String relativeName) throws IOException {
            return this.manager.getFileForInput(location, packageName, relativeName);
        }

        public FileObject getFileForOutput(JavaFileManager.Location location, String packageName, String relativeName, FileObject sibling) throws IOException {
            return this.manager.getFileForOutput(location, packageName, relativeName, sibling);
        }

        public void flush() throws IOException {
            this.manager.flush();
        }

        public void close() throws IOException {
            this.manager.close();
        }
    }
}
