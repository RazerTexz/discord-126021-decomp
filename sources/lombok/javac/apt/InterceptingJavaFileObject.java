package lombok.javac.apt;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URI;
import java.nio.charset.CharsetDecoder;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.NestingKind;
import javax.tools.JavaFileObject;
import lombok.Lombok;
import lombok.core.DiagnosticsReceiver;
import lombok.core.PostCompiler;

/* JADX INFO: loaded from: discord-126021.apk:lombok/javac/apt/InterceptingJavaFileObject.SCL.lombok */
final class InterceptingJavaFileObject implements LombokFileObject {
    private final JavaFileObject delegate;
    private final String fileName;
    private final DiagnosticsReceiver diagnostics;
    private final Method decoderMethod;

    public InterceptingJavaFileObject(JavaFileObject original, String fileName, DiagnosticsReceiver diagnostics, Method decoderMethod) {
        this.delegate = original;
        this.fileName = fileName;
        this.diagnostics = diagnostics;
        this.decoderMethod = decoderMethod;
    }

    public OutputStream openOutputStream() throws IOException {
        return PostCompiler.wrapOutputStream(this.delegate.openOutputStream(), this.fileName, this.diagnostics);
    }

    public Writer openWriter() throws IOException {
        throw new UnsupportedOperationException("Can't use a write for class files");
    }

    @Override // lombok.javac.apt.LombokFileObject
    public CharsetDecoder getDecoder(boolean ignoreEncodingErrors) {
        if (this.decoderMethod == null) {
            throw new UnsupportedOperationException();
        }
        try {
            return (CharsetDecoder) this.decoderMethod.invoke(this.delegate, Boolean.valueOf(ignoreEncodingErrors));
        } catch (IllegalAccessException e) {
            throw Lombok.sneakyThrow(e);
        } catch (InvocationTargetException e2) {
            throw Lombok.sneakyThrow(e2);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof InterceptingJavaFileObject)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        InterceptingJavaFileObject other = (InterceptingJavaFileObject) obj;
        return this.fileName.equals(other.fileName) && this.delegate.equals(other.delegate);
    }

    public int hashCode() {
        return this.fileName.hashCode() ^ this.delegate.hashCode();
    }

    public boolean delete() {
        return this.delegate.delete();
    }

    public Modifier getAccessLevel() {
        return this.delegate.getAccessLevel();
    }

    public CharSequence getCharContent(boolean ignoreEncodingErrors) throws IOException {
        return this.delegate.getCharContent(ignoreEncodingErrors);
    }

    public JavaFileObject.Kind getKind() {
        return this.delegate.getKind();
    }

    public long getLastModified() {
        return this.delegate.getLastModified();
    }

    public String getName() {
        return this.delegate.getName();
    }

    public NestingKind getNestingKind() {
        return this.delegate.getNestingKind();
    }

    public boolean isNameCompatible(String simpleName, JavaFileObject.Kind kind) {
        return this.delegate.isNameCompatible(simpleName, kind);
    }

    public InputStream openInputStream() throws IOException {
        return this.delegate.openInputStream();
    }

    public Reader openReader(boolean ignoreEncodingErrors) throws IOException {
        return this.delegate.openReader(ignoreEncodingErrors);
    }

    public URI toUri() {
        return this.delegate.toUri();
    }

    public String toString() {
        return this.delegate.toString();
    }
}
