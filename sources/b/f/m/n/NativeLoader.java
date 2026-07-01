package b.f.m.n;

/* JADX INFO: renamed from: b.f.m.n.a, reason: use source file name */
/* JADX INFO: compiled from: NativeLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public class NativeLoader {
    public static NativeLoaderDelegate a;

    public static synchronized void a(NativeLoaderDelegate nativeLoaderDelegate) {
        if (!b()) {
            synchronized (NativeLoader.class) {
                if (a != null) {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
                a = nativeLoaderDelegate;
            }
        }
    }

    public static synchronized boolean b() {
        return a != null;
    }

    public static boolean c(String str) {
        return d(str, 0);
    }

    public static boolean d(String str, int i) {
        NativeLoaderDelegate nativeLoaderDelegate;
        synchronized (NativeLoader.class) {
            nativeLoaderDelegate = a;
            if (nativeLoaderDelegate == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return nativeLoaderDelegate.a(str, i);
    }
}
