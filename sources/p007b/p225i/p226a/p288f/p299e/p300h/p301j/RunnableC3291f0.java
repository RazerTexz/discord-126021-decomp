package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import com.google.android.gms.common.ConnectionResult;
import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.f0 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3291f0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ BinderC3294g0 f9371j;

    public RunnableC3291f0(BinderC3294g0 binderC3294g0) {
        this.f9371j = binderC3294g0;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((C3293g.b) this.f9371j.f9420h).m4104b(new ConnectionResult(4));
    }
}
