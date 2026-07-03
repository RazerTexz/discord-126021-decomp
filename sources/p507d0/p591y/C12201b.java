package p507d0.p591y;

import java.io.Closeable;
import java.io.IOException;
import p507d0.C11211b;

/* JADX INFO: renamed from: d0.y.b */
/* JADX INFO: compiled from: Closeable.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12201b {
    public static final void closeFinally(Closeable closeable, Throwable th) throws IOException {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            C11211b.addSuppressed(th, th2);
        }
    }
}
