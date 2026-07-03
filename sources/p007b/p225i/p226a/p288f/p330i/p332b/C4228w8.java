package p007b.p225i.p226a.p288f.p330i.p332b;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.WorkerThread;
import p007b.p225i.p226a.p288f.p313h.p325l.HandlerC3604bc;

/* JADX INFO: renamed from: b.i.a.f.i.b.w8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4228w8 extends AbstractC3974a5 {

    /* JADX INFO: renamed from: c */
    public Handler f11328c;

    /* JADX INFO: renamed from: d */
    public final C4038f9 f11329d;

    /* JADX INFO: renamed from: e */
    public final C4014d9 f11330e;

    /* JADX INFO: renamed from: f */
    public final C4239x8 f11331f;

    public C4228w8(C4202u4 c4202u4) {
        super(c4202u4);
        this.f11329d = new C4038f9(this);
        this.f11330e = new C4014d9(this);
        this.f11331f = new C4239x8(this);
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC3974a5
    /* JADX INFO: renamed from: v */
    public final boolean mo5499v() {
        return false;
    }

    /* JADX INFO: renamed from: w */
    public final boolean m5959w(boolean z2, boolean z3, long j) {
        return this.f11330e.m5584a(z2, z3, j);
    }

    @WorkerThread
    /* JADX INFO: renamed from: x */
    public final void m5960x() {
        mo5848b();
        if (this.f11328c == null) {
            this.f11328c = new HandlerC3604bc(Looper.getMainLooper());
        }
    }
}
