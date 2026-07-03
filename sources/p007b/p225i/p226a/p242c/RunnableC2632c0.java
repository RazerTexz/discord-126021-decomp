package p007b.p225i.p226a.p242c;

import java.util.Arrays;
import java.util.List;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.C2803h1;

/* JADX INFO: renamed from: b.i.a.c.c0 */
/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class RunnableC2632c0 implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C2727f1 f6165j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ C2803h1.d f6166k;

    public /* synthetic */ RunnableC2632c0(C2727f1 c2727f1, C2803h1.d dVar) {
        this.f6165j = c2727f1;
        this.f6166k = dVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws CloneNotSupportedException {
        long j;
        boolean z2;
        long jM2913m0;
        C2727f1 c2727f1 = this.f6165j;
        C2803h1.d dVar = this.f6166k;
        int i = c2727f1.f6681x - dVar.f7103c;
        c2727f1.f6681x = i;
        boolean z3 = true;
        if (dVar.f7104d) {
            c2727f1.f6682y = dVar.f7105e;
            c2727f1.f6683z = true;
        }
        if (dVar.f7106f) {
            c2727f1.f6652A = dVar.f7107g;
        }
        if (i == 0) {
            AbstractC2832o2 abstractC2832o2 = dVar.f7102b.f7947b;
            if (!c2727f1.f6657F.f7947b.m3331q() && abstractC2832o2.m3331q()) {
                c2727f1.f6658G = -1;
                c2727f1.f6659H = 0L;
            }
            if (!abstractC2832o2.m3331q()) {
                List listAsList = Arrays.asList(((C2634c2) abstractC2832o2).f6174r);
                C1460d.m426D(listAsList.size() == c2727f1.f6670m.size());
                for (int i2 = 0; i2 < listAsList.size(); i2++) {
                    c2727f1.f6670m.get(i2).f6685b = (AbstractC2832o2) listAsList.get(i2);
                }
            }
            long j2 = -9223372036854775807L;
            if (c2727f1.f6683z) {
                if (dVar.f7102b.f7948c.equals(c2727f1.f6657F.f7948c) && dVar.f7102b.f7950e == c2727f1.f6657F.f7965t) {
                    z3 = false;
                }
                if (z3) {
                    if (abstractC2832o2.m3331q() || dVar.f7102b.f7948c.m2593a()) {
                        jM2913m0 = dVar.f7102b.f7950e;
                    } else {
                        C2964w1 c2964w1 = dVar.f7102b;
                        jM2913m0 = c2727f1.m2913m0(abstractC2832o2, c2964w1.f7948c, c2964w1.f7950e);
                    }
                    j2 = jM2913m0;
                }
                j = j2;
                z2 = z3;
            } else {
                j = -9223372036854775807L;
                z2 = false;
            }
            c2727f1.f6683z = false;
            c2727f1.m2924s0(dVar.f7102b, 1, c2727f1.f6652A, false, z2, c2727f1.f6682y, j, -1);
        }
    }
}
