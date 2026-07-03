package p007b.p225i.p226a.p288f.p330i.p332b;

import p007b.p085c.p086a.p087a0.C1460d;

/* JADX INFO: renamed from: b.i.a.f.i.b.x */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC4230x implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ String f11334j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ long f11335k;

    /* JADX INFO: renamed from: l */
    public final /* synthetic */ C3968a f11336l;

    public RunnableC4230x(C3968a c3968a, String str, long j) {
        this.f11336l = c3968a;
        this.f11334j = str;
        this.f11335k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C3968a c3968a = this.f11336l;
        String str = this.f11334j;
        long j = this.f11335k;
        c3968a.mo5848b();
        C1460d.m583w(str);
        Integer num = c3968a.f10502c.get(str);
        if (num == null) {
            c3968a.mo5726g().f11141f.m5861b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        C4072i7 c4072i7M5656w = c3968a.m5972q().m5656w(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            c3968a.f10502c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        c3968a.f10502c.remove(str);
        Long l = c3968a.f10501b.get(str);
        if (l == null) {
            c3968a.mo5726g().f11141f.m5860a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j - l.longValue();
            c3968a.f10501b.remove(str);
            c3968a.m5443w(str, jLongValue, c4072i7M5656w);
        }
        if (c3968a.f10502c.isEmpty()) {
            long j2 = c3968a.f10503d;
            if (j2 == 0) {
                c3968a.mo5726g().f11141f.m5860a("First ad exposure time was never set");
            } else {
                c3968a.m5441u(j - j2, c4072i7M5656w);
                c3968a.f10503d = 0L;
            }
        }
    }
}
