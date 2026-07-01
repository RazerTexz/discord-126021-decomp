package d0.x.d;

import d0.z.d.m;

/* JADX INFO: compiled from: JDK7PlatformImplementations.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a extends d0.x.a {
    @Override // d0.x.a
    public void addSuppressed(Throwable th, Throwable th2) {
        m.checkNotNullParameter(th, "cause");
        m.checkNotNullParameter(th2, "exception");
        th.addSuppressed(th2);
    }
}
