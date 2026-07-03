package p007b.p109f.p190m;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileLock;

/* JADX INFO: renamed from: b.f.m.g */
/* JADX INFO: compiled from: FileLocker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2054g implements Closeable {

    /* JADX INFO: renamed from: j */
    public final FileOutputStream f4335j;

    /* JADX INFO: renamed from: k */
    public final FileLock f4336k;

    public C2054g(File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        this.f4335j = fileOutputStream;
        try {
            FileLock fileLockLock = fileOutputStream.getChannel().lock();
            if (fileLockLock == null) {
                fileOutputStream.close();
            }
            this.f4336k = fileLockLock;
        } catch (Throwable th) {
            this.f4335j.close();
            throw th;
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        try {
            FileLock fileLock = this.f4336k;
            if (fileLock != null) {
                fileLock.release();
            }
        } finally {
            this.f4335j.close();
        }
    }
}
