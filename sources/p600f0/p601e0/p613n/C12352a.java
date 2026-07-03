package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.util.zip.Deflater;
import p615g0.C12388e;
import p615g0.C12391h;

/* JADX INFO: renamed from: f0.e0.n.a */
/* JADX INFO: compiled from: MessageDeflater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12352a implements Closeable {

    /* JADX INFO: renamed from: j */
    public final C12388e f25812j;

    /* JADX INFO: renamed from: k */
    public final Deflater f25813k;

    /* JADX INFO: renamed from: l */
    public final C12391h f25814l;

    /* JADX INFO: renamed from: m */
    public final boolean f25815m;

    public C12352a(boolean z2) {
        this.f25815m = z2;
        C12388e c12388e = new C12388e();
        this.f25812j = c12388e;
        Deflater deflater = new Deflater(-1, true);
        this.f25813k = deflater;
        this.f25814l = new C12391h(c12388e, deflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws Throwable {
        this.f25814l.close();
    }
}
