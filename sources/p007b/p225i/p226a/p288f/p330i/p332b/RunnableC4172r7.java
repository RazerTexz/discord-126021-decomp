package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzku;
import com.google.android.gms.measurement.internal.zzn;

/* JADX INFO: renamed from: b.i.a.f.i.b.r7 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4172r7 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f11182j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzku f11183k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ zzn f11184l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ C4161q7 f11185m;

    public RunnableC4172r7(C4161q7 c4161q7, boolean z2, zzku zzkuVar, zzn zznVar) {
        this.f11185m = c4161q7;
        this.f11182j = z2;
        this.f11183k = zzkuVar;
        this.f11184l = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        C4161q7 c4161q7 = this.f11185m;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Discarding data. Failed to set user property");
        } else {
            c4161q7.m5812w(interfaceC4068i3, this.f11182j ? null : this.f11183k, this.f11184l);
            this.f11185m.m5808F();
        }
    }
}
