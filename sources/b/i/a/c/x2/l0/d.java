package b.i.a.c.x2.l0;

import b.i.a.c.f3.x;
import b.i.a.c.x2.i;
import java.io.IOException;

/* JADX INFO: compiled from: WavHeaderReader.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1289b;

    public d(int i, long j) {
        this.a = i;
        this.f1289b = j;
    }

    public static d a(i iVar, x xVar) throws IOException {
        iVar.o(xVar.a, 0, 8);
        xVar.E(0);
        return new d(xVar.f(), xVar.j());
    }
}
