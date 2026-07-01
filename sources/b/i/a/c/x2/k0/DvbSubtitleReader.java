package b.i.a.c.x2.k0;

import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.n, reason: use source file name */
/* JADX INFO: compiled from: DvbSubtitleReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbSubtitleReader implements ElementaryStreamReader {
    public final List<TsPayloadReader.a> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TrackOutput2[] f1266b;
    public boolean c;
    public int d;
    public int e;
    public long f = -9223372036854775807L;

    public DvbSubtitleReader(List<TsPayloadReader.a> list) {
        this.a = list;
        this.f1266b = new TrackOutput2[list.size()];
    }

    public final boolean a(ParsableByteArray parsableByteArray, int i) {
        if (parsableByteArray.a() == 0) {
            return false;
        }
        if (parsableByteArray.t() != i) {
            this.c = false;
        }
        this.d--;
        return this.c;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void b(ParsableByteArray parsableByteArray) {
        if (this.c) {
            if (this.d != 2 || a(parsableByteArray, 32)) {
                if (this.d != 1 || a(parsableByteArray, 0)) {
                    int i = parsableByteArray.f984b;
                    int iA = parsableByteArray.a();
                    for (TrackOutput2 trackOutput2 : this.f1266b) {
                        parsableByteArray.E(i);
                        trackOutput2.c(parsableByteArray, iA);
                    }
                    this.e += iA;
                }
            }
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void c() {
        this.c = false;
        this.f = -9223372036854775807L;
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void d() {
        if (this.c) {
            if (this.f != -9223372036854775807L) {
                for (TrackOutput2 trackOutput2 : this.f1266b) {
                    trackOutput2.d(this.f, 1, this.e, 0, null);
                }
            }
            this.c = false;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void e(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        for (int i = 0; i < this.f1266b.length; i++) {
            TsPayloadReader.a aVar = this.a.get(i);
            dVar.a();
            TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 3);
            Format2.b bVar = new Format2.b();
            bVar.a = dVar.b();
            bVar.k = "application/dvbsubs";
            bVar.m = Collections.singletonList(aVar.f1257b);
            bVar.c = aVar.a;
            trackOutput2P.e(bVar.a());
            this.f1266b[i] = trackOutput2P;
        }
    }

    @Override // b.i.a.c.x2.k0.ElementaryStreamReader
    public void f(long j, int i) {
        if ((i & 4) == 0) {
            return;
        }
        this.c = true;
        if (j != -9223372036854775807L) {
            this.f = j;
        }
        this.e = 0;
        this.d = 2;
    }
}
