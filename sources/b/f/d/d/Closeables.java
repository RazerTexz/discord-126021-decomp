package b.f.d.d;

import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: b.f.d.d.a, reason: use source file name */
/* JADX INFO: compiled from: Closeables.java */
/* JADX INFO: loaded from: classes.dex */
public final class Closeables {

    @VisibleForTesting
    public static final Logger a = Logger.getLogger(Closeables.class.getName());

    public static void a(Closeable closeable, boolean z2) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (!z2) {
                throw e;
            }
            a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
        }
    }

    public static void b(InputStream inputStream) {
        try {
            a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
