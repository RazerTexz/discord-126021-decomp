package b.i.a.c.x2.f0;

import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.SeekMap;
import b.i.a.c.x2.SeekPoint;
import b.i.a.c.x2.TrackOutput2;

/* JADX INFO: renamed from: b.i.a.c.x2.f0.d, reason: use source file name */
/* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class StartOffsetExtractorOutput implements ExtractorOutput {
    public final long j;
    public final ExtractorOutput k;

    /* JADX INFO: renamed from: b.i.a.c.x2.f0.d$a */
    /* JADX INFO: compiled from: StartOffsetExtractorOutput.java */
    public class a implements SeekMap {
        public final /* synthetic */ SeekMap a;

        public a(SeekMap seekMap) {
            this.a = seekMap;
        }

        @Override // b.i.a.c.x2.SeekMap
        public boolean c() {
            return this.a.c();
        }

        @Override // b.i.a.c.x2.SeekMap
        public SeekMap.a h(long j) {
            SeekMap.a aVarH = this.a.h(j);
            SeekPoint seekPoint = aVarH.a;
            long j2 = seekPoint.f1298b;
            long j3 = seekPoint.c;
            long j4 = StartOffsetExtractorOutput.this.j;
            SeekPoint seekPoint2 = new SeekPoint(j2, j3 + j4);
            SeekPoint seekPoint3 = aVarH.f1296b;
            return new SeekMap.a(seekPoint2, new SeekPoint(seekPoint3.f1298b, seekPoint3.c + j4));
        }

        @Override // b.i.a.c.x2.SeekMap
        public long i() {
            return this.a.i();
        }
    }

    public StartOffsetExtractorOutput(long j, ExtractorOutput extractorOutput) {
        this.j = j;
        this.k = extractorOutput;
    }

    @Override // b.i.a.c.x2.ExtractorOutput
    public void a(SeekMap seekMap) {
        this.k.a(new a(seekMap));
    }

    @Override // b.i.a.c.x2.ExtractorOutput
    public void j() {
        this.k.j();
    }

    @Override // b.i.a.c.x2.ExtractorOutput
    public TrackOutput2 p(int i, int i2) {
        return this.k.p(i, i2);
    }
}
