package b.g.a.c.i0;

import java.io.IOException;

/* JADX INFO: compiled from: TokenBuffer.java */
/* JADX INFO: loaded from: classes3.dex */
public final class s$a extends b.g.a.b.o.b {
    public int n;
    public t o;
    public boolean p;

    public s$a(b.g.a.b.i iVar, boolean z2, boolean z3, b.g.a.b.g gVar) {
        super(0);
        this.n = -1;
        this.o = new t();
    }

    @Override // b.g.a.b.f
    public b.g.a.b.e a() {
        return b.g.a.b.e.j;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.p) {
            return;
        }
        this.p = true;
    }
}
