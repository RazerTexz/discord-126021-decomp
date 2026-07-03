package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import p007b.p225i.p226a.p288f.p299e.p300h.p301j.C3293g;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.w */
/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC3325w implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C3327x f9462j;

    public RunnableC3325w(C3327x c3327x) {
        this.f9462j = c3327x;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3293g.a aVar = this.f9462j.f9463a;
        aVar.f9393b.m4032c(aVar.f9394c.getClass().getName().concat(" disconnecting because it was signed out."));
    }
}
