package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.j0, reason: use source file name */
/* JADX INFO: compiled from: UserDataReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class UserDataReader {
    public final List<Format2> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TrackOutput2[] f1261b;

    public UserDataReader(List<Format2> list) {
        this.a = list;
        this.f1261b = new TrackOutput2[list.size()];
    }

    public void a(long j, ParsableByteArray parsableByteArray) {
        if (parsableByteArray.a() < 9) {
            return;
        }
        int iF = parsableByteArray.f();
        int iF2 = parsableByteArray.f();
        int iT = parsableByteArray.t();
        if (iF == 434 && iF2 == 1195456820 && iT == 3) {
            AnimatableValueParser.K(j, parsableByteArray, this.f1261b);
        }
    }

    public void b(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        for (int i = 0; i < this.f1261b.length; i++) {
            dVar.a();
            TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 3);
            Format2 format2 = this.a.get(i);
            String str = format2.w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            AnimatableValueParser.m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            Format2.b bVar = new Format2.b();
            bVar.a = dVar.b();
            bVar.k = str;
            bVar.d = format2.o;
            bVar.c = format2.n;
            bVar.C = format2.O;
            bVar.m = format2.f1019y;
            trackOutput2P.e(bVar.a());
            this.f1261b[i] = trackOutput2P;
        }
    }
}
