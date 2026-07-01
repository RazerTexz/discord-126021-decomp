package b.i.a.c.x2.h0;

import b.i.a.c.f3.e0;
import b.i.a.c.f3.r;
import b.i.a.c.x2.t$a;
import b.i.a.c.x2.u;

/* JADX INFO: compiled from: IndexSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d implements g {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r f1203b;
    public final r c;
    public long d;

    public d(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        r rVar = new r();
        this.f1203b = rVar;
        r rVar2 = new r();
        this.c = rVar2;
        rVar.a(0L);
        rVar2.a(j2);
    }

    @Override // b.i.a.c.x2.h0.g
    public long a() {
        return this.a;
    }

    public boolean b(long j) {
        r rVar = this.f1203b;
        return j - rVar.b(rVar.a - 1) < 100000;
    }

    @Override // b.i.a.c.x2.t
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.h0.g
    public long d(long j) {
        return this.f1203b.b(e0.c(this.c, j, true, true));
    }

    @Override // b.i.a.c.x2.t
    public t$a h(long j) {
        int iC = e0.c(this.f1203b, j, true, true);
        long jB = this.f1203b.b(iC);
        u uVar = new u(jB, this.c.b(iC));
        if (jB != j) {
            r rVar = this.f1203b;
            if (iC != rVar.a - 1) {
                int i = iC + 1;
                return new t$a(uVar, new u(rVar.b(i), this.c.b(i)));
            }
        }
        return new t$a(uVar);
    }

    @Override // b.i.a.c.x2.t
    public long i() {
        return this.d;
    }
}
