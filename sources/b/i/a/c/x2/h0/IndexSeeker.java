package b.i.a.c.x2.h0;

import b.i.a.c.f3.LongArray;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;

/* JADX INFO: renamed from: b.i.a.c.x2.h0.d, reason: use source file name */
/* JADX INFO: compiled from: IndexSeeker.java */
/* JADX INFO: loaded from: classes3.dex */
public final class IndexSeeker implements Seeker {
    public final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LongArray f1203b;
    public final LongArray c;
    public long d;

    public IndexSeeker(long j, long j2, long j3) {
        this.d = j;
        this.a = j3;
        LongArray longArray = new LongArray();
        this.f1203b = longArray;
        LongArray longArray2 = new LongArray();
        this.c = longArray2;
        longArray.a(0L);
        longArray2.a(j2);
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long a() {
        return this.a;
    }

    public boolean b(long j) {
        LongArray longArray = this.f1203b;
        return j - longArray.b(longArray.a - 1) < 100000;
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.h0.Seeker
    public long d(long j) {
        return this.f1203b.b(Util2.c(this.c, j, true, true));
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        int iC = Util2.c(this.f1203b, j, true, true);
        long jB = this.f1203b.b(iC);
        SeekPoint seekPoint = new SeekPoint(jB, this.c.b(iC));
        if (jB != j) {
            LongArray longArray = this.f1203b;
            if (iC != longArray.a - 1) {
                int i = iC + 1;
                return new SeekMap.a(seekPoint, new SeekPoint(longArray.b(i), this.c.b(i)));
            }
        }
        return new SeekMap.a(seekPoint);
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.d;
    }
}
