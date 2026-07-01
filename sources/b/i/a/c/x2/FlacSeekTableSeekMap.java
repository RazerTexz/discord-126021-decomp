package b.i.a.c.x2;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.FlacStreamMetadata;
import b.i.a.c.x2.SeekMap;

/* JADX INFO: renamed from: b.i.a.c.x2.n, reason: use source file name */
/* JADX INFO: compiled from: FlacSeekTableSeekMap.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FlacSeekTableSeekMap implements SeekMap {
    public final FlacStreamMetadata a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1291b;

    public FlacSeekTableSeekMap(FlacStreamMetadata flacStreamMetadata, long j) {
        this.a = flacStreamMetadata;
        this.f1291b = j;
    }

    public final SeekPoint b(long j, long j2) {
        return new SeekPoint((j * 1000000) / ((long) this.a.e), this.f1291b + j2);
    }

    @Override // b.i.a.c.x2.SeekMap
    public boolean c() {
        return true;
    }

    @Override // b.i.a.c.x2.SeekMap
    public SeekMap.a h(long j) {
        AnimatableValueParser.H(this.a.k);
        FlacStreamMetadata flacStreamMetadata = this.a;
        FlacStreamMetadata.a aVar = flacStreamMetadata.k;
        long[] jArr = aVar.a;
        long[] jArr2 = aVar.f1293b;
        int iE = Util2.e(jArr, flacStreamMetadata.g(j), true, false);
        SeekPoint seekPointB = b(iE == -1 ? 0L : jArr[iE], iE != -1 ? jArr2[iE] : 0L);
        if (seekPointB.f1298b == j || iE == jArr.length - 1) {
            return new SeekMap.a(seekPointB);
        }
        int i = iE + 1;
        return new SeekMap.a(seekPointB, b(jArr[i], jArr2[i]));
    }

    @Override // b.i.a.c.x2.SeekMap
    public long i() {
        return this.a.d();
    }
}
