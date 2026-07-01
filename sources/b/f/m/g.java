package b.f.m;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: compiled from: FileLocker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements Closeable {
    public final FileOutputStream j;
    public final FileLock k;

    public g(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.j = fileOutputStream;
        try {
            FileLock fileLockLock = fileOutputStream.getChannel().lock();
            if (fileLockLock == null) {
                fileOutputStream.close();
            }
            this.k = fileLockLock;
        } catch (Throwable th) {
            this.j.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.k;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.j.close();
        }
    }
}
