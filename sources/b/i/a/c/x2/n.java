package b.i.a.c.x2;

import b.i.a.c.f3.e0;

/* JADX INFO: compiled from: FlacSeekTableSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class n implements t {
    public final o a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1291b;

    public n(o oVar, long j) {
        this.a = oVar;
        this.f1291b = j;
    }

    public final u b(long j, long j2) {
        return new u((j * 1000000) / ((long) this.a.e), this.f1291b + j2);
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        b.c.a.a0.d.H(this.a.k);
        o oVar = this.a;
        o$a o_a = oVar.k;
        long[] jArr = o_a.a;
        long[] jArr2 = o_a.f1293b;
        int iE = e0.e(jArr, oVar.g(j), true, false);
        u uVarB = b(iE == -1 ? 0L : jArr[iE], iE != -1 ? jArr2[iE] : 0L);
        if (uVarB.f1298b == j || iE == jArr.length - 1) {
            return new t$a(uVarB);
        }
        int i = iE + 1;
        return new t$a(uVarB, b(jArr[i], jArr2[i]));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.a.d();
    }
}
