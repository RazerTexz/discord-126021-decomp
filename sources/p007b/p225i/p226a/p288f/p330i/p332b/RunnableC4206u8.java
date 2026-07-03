package p007b.p225i.p226a.p288f.p330i.p332b;

import java.util.ArrayList;

/* JADX INFO: renamed from: b.i.a.f.i.b.u8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4206u8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C4097k9 f11288j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ Runnable f11289k;

    public RunnableC4206u8(C4097k9 c4097k9, Runnable runnable) {
        this.f11288j = c4097k9;
        this.f11289k = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f11288j.m5717R();
        C4097k9 c4097k9 = this.f11288j;
        Runnable runnable = this.f11289k;
        c4097k9.m5720U();
        if (c4097k9.f10910o == null) {
            c4097k9.f10910o = new ArrayList();
        }
        c4097k9.f10910o.add(runnable);
        this.f11288j.m5716Q();
    }
}
