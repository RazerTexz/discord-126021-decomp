package p007b.p109f.p115d.p119d;

import androidx.annotation.VisibleForTesting;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: renamed from: b.f.d.d.a */
/* JADX INFO: compiled from: Closeables.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1678a {

    /* JADX INFO: renamed from: a */
    @VisibleForTesting
    public static final Logger f3091a = Logger.getLogger(C1678a.class.getName());

    /* JADX INFO: renamed from: a */
    public static void m965a(Closeable closeable, boolean z2) throws IOException {
        if (closeable == null) {
            return;
        }
        try {
            closeable.close();
        } catch (IOException e) {
            if (!z2) {
                throw e;
            }
            f3091a.log(Level.WARNING, "IOException thrown while closing Closeable.", (Throwable) e);
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m966b(InputStream inputStream) {
        try {
            m965a(inputStream, true);
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }
}
