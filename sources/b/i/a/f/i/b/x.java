package b.i.a.f.i.b;

import b.c.a.a0.AnimatableValueParser;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class x implements Runnable {
    public final /* synthetic */ String j;
    public final /* synthetic */ long k;
    public final /* synthetic */ a l;

    public x(a aVar, String str, long j) {
        this.l = aVar;
        this.j = str;
        this.k = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar = this.l;
        String str = this.j;
        long j = this.k;
        aVar.b();
        AnimatableValueParser.w(str);
        Integer num = aVar.c.get(str);
        if (num == null) {
            aVar.g().f.b("Call to endAdUnitExposure for unknown ad unit id", str);
            return;
        }
        i7 i7VarW = aVar.q().w(false);
        int iIntValue = num.intValue() - 1;
        if (iIntValue != 0) {
            aVar.c.put(str, Integer.valueOf(iIntValue));
            return;
        }
        aVar.c.remove(str);
        Long l = aVar.f1512b.get(str);
        if (l == null) {
            aVar.g().f.a("First ad unit exposure time was never set");
        } else {
            long jLongValue = j - l.longValue();
            aVar.f1512b.remove(str);
            aVar.w(str, jLongValue, i7VarW);
        }
        if (aVar.c.isEmpty()) {
            long j2 = aVar.d;
            if (j2 == 0) {
                aVar.g().f.a("First ad exposure time was never set");
            } else {
                aVar.u(j - j2, i7VarW);
                aVar.d = 0L;
            }
        }
    }
}
