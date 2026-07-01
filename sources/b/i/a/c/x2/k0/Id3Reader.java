package b.i.a.c.x2.k0;

import android.util.Log;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.t, reason: use source file name */
/* JADX INFO: compiled from: Id3Reader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Id3Reader implements ElementaryStreamReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public TrackOutput2 f1277b;
    public boolean c;
    public int e;
    public int f;
    public final ParsableByteArray a = new ParsableByteArray(10);
    public long d = -9223372036854775807L;

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        AnimatableValueParser.H(this.f1277b);
        if (this.c) {
            int iA = parsableByteArray.a();
            int i = this.f;
            if (i < 10) {
                int iMin = Math.min(iA, 10 - i);
                System.arraycopy(parsableByteArray.a, parsableByteArray.f984b, this.a.a, this.f, iMin);
                if (this.f + iMin == 10) {
                    this.a.E(0);
                    if (73 != this.a.t() || 68 != this.a.t() || 51 != this.a.t()) {
                        Log.w("Id3Reader", "Discarding invalid ID3 tag");
                        this.c = false;
                        return;
                    } else {
                        this.a.F(3);
                        this.e = this.a.s() + 10;
                    }
                }
            }
            int iMin2 = Math.min(iA, this.e - this.f);
            this.f1277b.c(parsableByteArray, iMin2);
            this.f += iMin2;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.c = false;
        this.d = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
        int i;
        AnimatableValueParser.H(this.f1277b);
        if (this.c && (i = this.e) != 0 && this.f == i) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                this.f1277b.d(j, 1, i, 0, null);
            }
            this.c = false;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        dVar.a();
        TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 5);
        this.f1277b = trackOutput2P;
        Format2.b bVar = new Format2.b();
        bVar.a = dVar.b();
        bVar.k = "application/id3";
        trackOutput2P.e(bVar.a());
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.d = j;
        }
        this.e = 0;
        this.f = 0;
    }
}
