package b.i.a.c.x2.k0;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.Format2;
import b.i.a.c.x2.ExtractorOutput;
import b.i.a.c.x2.TrackOutput2;
import b.i.a.c.x2.k0.TsPayloadReader;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.x2.k0.e0, reason: use source file name */
/* JADX INFO: compiled from: SeiReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SeiReader {
    public final List<Format2> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final TrackOutput2[] f1246b;

    public SeiReader(List<Format2> list) {
        this.a = list;
        this.f1246b = new TrackOutput2[list.size()];
    }

    public void a(ExtractorOutput extractorOutput, TsPayloadReader.d dVar) {
        for (int i = 0; i < this.f1246b.length; i++) {
            dVar.a();
            TrackOutput2 trackOutput2P = extractorOutput.p(dVar.c(), 3);
            Format2 format2 = this.a.get(i);
            String str = format2.w;
            boolean z2 = "application/cea-608".equals(str) || "application/cea-708".equals(str);
            String strValueOf = String.valueOf(str);
            AnimatableValueParser.m(z2, strValueOf.length() != 0 ? "Invalid closed caption mime type provided: ".concat(strValueOf) : new String("Invalid closed caption mime type provided: "));
            String strB = format2.l;
            if (strB == null) {
                strB = dVar.b();
            }
            Format2.b bVar = new Format2.b();
            bVar.a = strB;
            bVar.k = str;
            bVar.d = format2.o;
            bVar.c = format2.n;
            bVar.C = format2.O;
            bVar.m = format2.f1019y;
            trackOutput2P.e(bVar.a());
            this.f1246b[i] = trackOutput2P;
        }
    }
}
