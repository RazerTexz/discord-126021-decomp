package p600f0.p601e0.p613n;

import java.io.Closeable;
import java.io.IOException;
import java.util.zip.Inflater;
import p615g0.C12388e;
import p615g0.C12396m;
import p615g0.InterfaceC12407x;

/* JADX INFO: renamed from: f0.e0.n.c */
/* JADX INFO: compiled from: MessageInflater.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12354c implements Closeable {

    /* JADX INFO: renamed from: j */
    public final C12388e f25817j;

    /* JADX INFO: renamed from: k */
    public final Inflater f25818k;

    /* JADX INFO: renamed from: l */
    public final C12396m f25819l;

    /* JADX INFO: renamed from: m */
    public final boolean f25820m;

    public C12354c(boolean z2) {
        this.f25820m = z2;
        C12388e c12388e = new C12388e();
        this.f25817j = c12388e;
        Inflater inflater = new Inflater(true);
        this.f25818k = inflater;
        this.f25819l = new C12396m((InterfaceC12407x) c12388e, inflater);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f25819l.close();
    }
}
