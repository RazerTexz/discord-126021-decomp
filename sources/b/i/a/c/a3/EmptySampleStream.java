package b.i.a.c.a3;

import b.i.a.c.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

/* JADX INFO: renamed from: b.i.a.c.a3.q, reason: use source file name */
/* JADX INFO: compiled from: EmptySampleStream.java */
/* JADX INFO: loaded from: classes3.dex */
public final class EmptySampleStream implements SampleStream {
    @Override // b.i.a.c.a3.SampleStream
    public int a(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, int i) {
        decoderInputBuffer.j = 4;
        return -4;
    }

    @Override // b.i.a.c.a3.SampleStream
    public void b() {
    }

    @Override // b.i.a.c.a3.SampleStream
    public int c(long j) {
        return 0;
    }

    @Override // b.i.a.c.a3.SampleStream
    public boolean d() {
        return true;
    }
}
