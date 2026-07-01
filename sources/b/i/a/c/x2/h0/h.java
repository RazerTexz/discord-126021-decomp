package b.i.a.c.x2.h0;

import b.i.a.c.f3.e0;
import b.i.a.c.x2.t$a;
import b.i.a.c.x2.u;

/* JADX INFO: compiled from: VbriSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h implements g {
    public final long[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f1207b;
    public final long c;
    public final long d;

    public h(long[] jArr, long[] jArr2, long j, long j2) {
        this.a = jArr;
        this.f1207b = jArr2;
        this.c = j;
        this.d = j2;
    }

    @Override // b.i.a.c.x2.h0.g
    public long a() {
        return this.d;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.h0.g
    public long d(long j) {
        return this.a[e0.e(this.f1207b, j, true, true)];
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        int iE = e0.e(this.a, j, true, true);
        long[] jArr = this.a;
        long j2 = jArr[iE];
        long[] jArr2 = this.f1207b;
        u uVar = new u(j2, jArr2[iE]);
        if (j2 >= j || iE == jArr.length - 1) {
            return new t$a(uVar);
        }
        int i = iE + 1;
        return new t$a(uVar, new u(jArr[i], jArr2[i]));
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.c;
    }
}
