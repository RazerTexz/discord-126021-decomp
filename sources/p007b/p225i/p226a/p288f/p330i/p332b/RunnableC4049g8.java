package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import com.google.android.gms.measurement.internal.zzz;

/* JADX INFO: renamed from: b.i.a.f.i.b.g8 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4049g8 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ boolean f10755j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ zzz f10756k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ zzn f10757l;

    /* JADX INFO: renamed from: m */
    public final /* synthetic */ zzz f10758m;

    /* JADX INFO: renamed from: n */
    public final /* synthetic */ C4161q7 f10759n;

    public RunnableC4049g8(C4161q7 c4161q7, boolean z2, zzz zzzVar, zzn zznVar, zzz zzzVar2) {
        this.f10759n = c4161q7;
        this.f10755j = z2;
        this.f10756k = zzzVar;
        this.f10757l = zznVar;
        this.f10758m = zzzVar2;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        C4161q7 c4161q7 = this.f10759n;
        InterfaceC4068i3 interfaceC4068i3 = c4161q7.f11154d;
        if (interfaceC4068i3 == null) {
            c4161q7.mo5726g().f11141f.m5860a("Discarding data. Failed to send conditional user property to service");
        } else {
            c4161q7.m5812w(interfaceC4068i3, this.f10755j ? null : this.f10756k, this.f10757l);
            this.f10759n.m5808F();
        }
    }
}
