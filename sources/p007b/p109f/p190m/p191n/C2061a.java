package p007b.p109f.p190m.p191n;

/* JADX INFO: renamed from: b.f.m.n.a */
/* JADX INFO: compiled from: NativeLoader.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2061a {

    /* JADX INFO: renamed from: a */
    public static InterfaceC2062b f4358a;

    /* JADX INFO: renamed from: a */
    public static synchronized void m1587a(InterfaceC2062b interfaceC2062b) {
        if (!m1588b()) {
            synchronized (C2061a.class) {
                if (f4358a != null) {
                    throw new IllegalStateException("Cannot re-initialize NativeLoader.");
                }
                f4358a = interfaceC2062b;
            }
        }
    }

    /* JADX INFO: renamed from: b */
    public static synchronized boolean m1588b() {
        return f4358a != null;
    }

    /* JADX INFO: renamed from: c */
    public static boolean m1589c(String str) {
        return m1590d(str, 0);
    }

    /* JADX INFO: renamed from: d */
    public static boolean m1590d(String str, int i) {
        InterfaceC2062b interfaceC2062b;
        synchronized (C2061a.class) {
            interfaceC2062b = f4358a;
            if (interfaceC2062b == null) {
                throw new IllegalStateException("NativeLoader has not been initialized.  To use standard native library loading, call NativeLoader.init(new SystemDelegate()).");
            }
        }
        return interfaceC2062b.mo1578a(str, i);
    }
}
