package p007b.p225i.p226a.p288f.p330i.p332b;

import com.google.android.gms.measurement.internal.zzn;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p288f.p313h.p325l.C3842t8;

/* JADX INFO: renamed from: b.i.a.f.i.b.k5 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4093k5 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ zzn f10876j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ BinderC4257z4 f10877k;

    public RunnableC4093k5(BinderC4257z4 binderC4257z4, zzn zznVar) {
        this.f10877k = binderC4257z4;
        this.f10876j = zznVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        this.f10877k.f11390a.m5717R();
        C4097k9 c4097k9 = this.f10877k.f11390a;
        zzn zznVar = this.f10876j;
        if (C3842t8.m5293b() && c4097k9.f10906k.f11260h.m5526o(C4142p.f11039J0)) {
            c4097k9.mo5725f().mo5848b();
            c4097k9.m5715P();
            C1460d.m583w(zznVar.f20683j);
            C4004d c4004dM5563b = C4004d.m5563b(zznVar.f20682F);
            C4004d c4004dM5723a = c4097k9.m5723a(zznVar.f20683j);
            c4097k9.mo5726g().f11149n.m5862c("Setting consent, package, consent", zznVar.f20683j, c4004dM5563b);
            c4097k9.m5738s(zznVar.f20683j, c4004dM5563b);
            if (c4004dM5563b.m5569f(c4004dM5723a)) {
                c4097k9.m5735p(zznVar);
            }
        }
    }
}
