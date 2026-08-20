package lombok.javac.apt;

import com.sun.tools.javac.file.BaseFileManager;
import com.sun.tools.javac.file.PathFileObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.URI;
import java.nio.file.Path;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/apt/Javac9BaseFileObjectWrapper.SCL.lombok */
class Javac9BaseFileObjectWrapper extends PathFileObject {
    private final LombokFileObject delegate;

    public Javac9BaseFileObjectWrapper(BaseFileManager fileManager, Path path, LombokFileObject delegate) {
        super(fileManager, path);
        this.delegate = delegate;
    }

    public boolean isNameCompatible(String simpleName, JavaFileObject.Kind kind) {
        return this.delegate.isNameCompatible(simpleName, kind);
    }

    public URI toUri() {
        return this.delegate.toUri();
    }

    public String getName() {
        return this.delegate.getName();
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return this.delegate.getCharContent(ignoreEncodingErrors);
    }

    public InputStream openInputStream() throws IOException {
        return this.delegate.openInputStream();
    }

    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
        return this.delegate.openReader(ignoreEncodingErrors);
    }

    public Writer openWriter() throws IOException {
        return this.delegate.openWriter();
    }

    public OutputStream openOutputStream() throws IOException {
        return this.delegate.openOutputStream();
    }

    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    public boolean delete() {
        return this.delegate.delete();
    }

    public JavaFileObject.Kind getKind() {
        return this.delegate.getKind();
    }

    public NestingKind getNestingKind() {
        return this.delegate.getNestingKind();
    }

    public Modifier getAccessLevel() {
        return this.delegate.getAccessLevel();
    }

    public boolean equals(Object obj) {
        if (obj instanceof Javac9BaseFileObjectWrapper) {
            return this.delegate.equals(((Javac9BaseFileObjectWrapper) obj).delegate);
        }
        return false;
    }

    public int hashCode() {
        return this.delegate.hashCode();
    }

    public String toString() {
        return this.delegate.toString();
    }
}
