package lombok.core;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: loaded from: app.apk:lombok/core/PostCompiler$1.SCL.lombok */
class PostCompiler$1 extends ByteArrayOutputStream {
    private final /* synthetic */ String val$fileName;
    private final /* synthetic */ DiagnosticsReceiver val$diagnostics;
    private final /* synthetic */ OutputStream val$originalStream;

    PostCompiler$1(String str, DiagnosticsReceiver diagnosticsReceiver, OutputStream outputStream) {
        this.val$fileName = str;
        this.val$diagnostics = diagnosticsReceiver;
        this.val$originalStream = outputStream;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        byte[] original = toByteArray();
        byte[] copy = null;
        if (original.length > 0) {
            try {
                copy = PostCompiler.applyTransformations(original, this.val$fileName, this.val$diagnostics);
            } catch (Exception unused) {
                this.val$diagnostics.addWarning(String.format("Error during the transformation of '%s'; no post-compilation has been applied", this.val$fileName));
            }
        }
        if (copy == null) {
            copy = original;
        }
        this.val$originalStream.write(copy);
        this.val$originalStream.close();
    }
}
