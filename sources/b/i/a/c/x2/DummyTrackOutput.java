package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.Format2;
import b.i.a.c.e3.DataReader;
import b.i.a.c.f3.ParsableByteArray;
import b.i.a.c.x2.TrackOutput2;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: renamed from: b.i.a.c.x2.g, reason: use source file name */
/* JADX INFO: compiled from: DummyTrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DummyTrackOutput implements TrackOutput2 {
    public final byte[] a = new byte[4096];

    @Override // b.i.a.c.x2.TrackOutput2
    public int a(DataReader dataReader, int i, boolean z2, int i2) throws IOException {
        int i3 = dataReader.read(this.a, 0, Math.min(this.a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public /* synthetic */ int b(DataReader dataReader, int i, boolean z2) {
        return TrackOutput.a(this, dataReader, i, z2);
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public /* synthetic */ void c(ParsableByteArray parsableByteArray, int i) {
        TrackOutput.b(this, parsableByteArray, i);
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public void d(long j, int i, int i2, int i3, @Nullable TrackOutput2.a aVar) {
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public void e(Format2 format2) {
    }

    @Override // b.i.a.c.x2.TrackOutput2
    public void f(ParsableByteArray parsableByteArray, int i, int i2) {
        parsableByteArray.E(parsableByteArray.f984b + i);
    }
}
