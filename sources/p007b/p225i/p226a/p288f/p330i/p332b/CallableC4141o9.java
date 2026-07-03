package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import java.util.concurrent.Callable;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.o9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class CallableC4141o9 implements Callable<String> {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f11018j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C4097k9 f11019k;

    public CallableC4141o9(C4097k9 c4097k9, zzn zznVar) {
        this.f11019k = c4097k9;
        this.f11018j = zznVar;
    }

    @Override // java.util.concurrent.Callable
    public final String call() throws Exception {
        if (!C3842t8.m5293b() || !this.f11019k.f10906k.f11260h.m5526o(C4142p.f11039J0) || (this.f11019k.m5723a(this.f11018j.f20683j).m5572k() && C4004d.m5563b(this.f11018j.f20682F).m5572k())) {
            return this.f11019k.m5706G(this.f11018j).m5489s();
        }
        this.f11019k.mo5726g().f11149n.m5860a("Analytics storage consent denied. Returning null app instance id");
        return null;
    }
}
