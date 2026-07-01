package b.i.a.c.x2.l0;

import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.ExtractorInput;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.l0.d, reason: use source file name */
/* JADX INFO: compiled from: WavHeaderReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WavHeaderReader {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1289b;

    public WavHeaderReader(int i, long j) {
        this.a = i;
        this.f1289b = j;
    }

    public static WavHeaderReader a(ExtractorInput extractorInput, ParsableByteArray parsableByteArray) throws IOException {
        extractorInput.o(parsableByteArray.a, 0, 8);
        parsableByteArray.E(0);
        return new WavHeaderReader(parsableByteArray.f(), parsableByteArray.j());
    }
}
