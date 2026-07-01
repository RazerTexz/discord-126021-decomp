package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.f3.TimestampAdjuster;
import b.i.a.c.f3.Util2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.x, reason: use source file name */
/* JADX INFO: compiled from: PassthroughSectionPayloadReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PassthroughSectionPayloadReader implements SectionPayloadReader {
    public Format2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TimestampAdjuster f1282b;
    public TrackOutput2 c;

    public PassthroughSectionPayloadReader(String str) {
        Format2.b bVar = new Format2.b();
        bVar.k = str;
        this.a = bVar.a();
    }

    @Override // b.i.a.c.x2.k0.SectionPayloadReader
    public void a(TimestampAdjuster timestampAdjuster, ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        this.f1282b = timestampAdjuster;
        dVar.a();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 5);
        this.c = trackOutput2P;
        trackOutput2P.e(this.a);
    }

    @Override // b.i.a.c.x2.k0.SectionPayloadReader
    public void b(ParsableByteArray parsableByteArray) {
        long jC;
        AnimatableValueParser.H(this.f1282b);
        int i = Util2.a;
        TimestampAdjuster timestampAdjuster = this.f1282b;
        synchronized (timestampAdjuster) {
            long j = timestampAdjuster.c;
            jC = j != -9223372036854775807L ? j + timestampAdjuster.f966b : timestampAdjuster.c();
        }
        long jD = this.f1282b.d();
        if (jC == -9223372036854775807L || jD == -9223372036854775807L) {
            return;
        }
        Format2 format2 = this.a;
        if (jD != format2.A) {
            Format2.b bVarA = format2.a();
            bVarA.o = jD;
            Format2 format2A = bVarA.a();
            this.a = format2A;
            this.c.e(format2A);
        }
        int iA = parsableByteArray.a();
        this.c.c(parsableByteArray, iA);
        this.c.d(jC, 1, iA, 0, null);
    }
}
