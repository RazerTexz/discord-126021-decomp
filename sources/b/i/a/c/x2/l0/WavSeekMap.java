package b.i.a.c.x2.l0;

import b.i.a.c.f3.Util2;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;

/* JADX INFO: renamed from: b.i.a.c.x2.l0.e, reason: use source file name */
/* JADX INFO: compiled from: WavSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WavSeekMap implements SeekMap {
    public final WavFormat a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f1290b;
    public final long c;
    public final long d;
    public final long e;

    public WavSeekMap(WavFormat wavFormat, int i, long j, long j2) {
        this.a = wavFormat;
        this.f1290b = i;
        this.c = j;
        long j3 = (j2 - j) / ((long) wavFormat.d);
        this.d = j3;
        this.e = b(j3);
    }

    public final long b(long j) {
        return Util2.F(j * ((long) this.f1290b), 1000000L, this.a.c);
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        long jI = Util2.i((((long) this.a.c) * j) / (((long) this.f1290b) * 1000000), 0L, this.d - 1);
        long j2 = (((long) this.a.d) * jI) + this.c;
        long jB = b(jI);
        SeekPoint seekPoint = new SeekPoint(jB, j2);
        if (jB >= j || jI == this.d - 1) {
            return new SeekMap.a(seekPoint);
        }
        long j3 = jI + 1;
        return new SeekMap.a(seekPoint, new SeekPoint(b(j3), (((long) this.a.d) * j3) + this.c));
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.e;
    }
}
