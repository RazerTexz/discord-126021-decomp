package b.i.a.c.x2;

import androidx.annotation.Nullable;
import b.i.a.c.j1;
import java.io.EOFException;
import java.io.IOException;

/* JADX INFO: compiled from: DummyTrackOutput.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g implements w {
    public final byte[] a = new byte[4096];

    @Override // b.i.a.c.x2.w
    public int a(b.i.a.c.e3.h hVar, int i, boolean z2, int i2) throws IOException {
        int i3 = hVar.read(this.a, 0, Math.min(this.a.length, i));
        if (i3 != -1) {
            return i3;
        }
        if (z2) {
            return -1;
        }
        throw new EOFException();
    }

    @Override // b.i.a.c.x2.w
    public /* synthetic */ int b(b.i.a.c.e3.h hVar, int i, boolean z2) {
        return v.a(this, hVar, i, z2);
    }

    @Override // b.i.a.c.x2.w
    public /* synthetic */ void c(b.i.a.c.f3.x xVar, int i) {
        v.b(this, xVar, i);
    }

    @Override // b.i.a.c.x2.w
    public void d(long j, int i, int i2, int i3, @Nullable w$a w_a) {
    }

    @Override // b.i.a.c.x2.w
    public void e(j1 j1Var) {
    }

    @Override // b.i.a.c.x2.w
    public void f(b.i.a.c.f3.x xVar, int i, int i2) {
        xVar.E(xVar.f984b + i);
    }
}
