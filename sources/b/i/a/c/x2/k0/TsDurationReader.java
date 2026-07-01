package b.i.a.c.x2.k0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorInput;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.g0, reason: use source file name */
/* JADX INFO: compiled from: TsDurationReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TsDurationReader {
    public final int a;
    public boolean d;
    public boolean e;
    public boolean f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TimestampAdjuster f1250b = new TimestampAdjuster(0);
    public long g = -9223372036854775807L;
    public long h = -9223372036854775807L;
    public long i = -9223372036854775807L;
    public final ParsableByteArray c = new ParsableByteArray();

    public TsDurationReader(int i) {
        this.a = i;
    }

    public final int a(ExtractorInput extractorInput) {
        this.c.B(Util2.f);
        this.d = true;
        extractorInput.k();
        return 0;
    }
}
