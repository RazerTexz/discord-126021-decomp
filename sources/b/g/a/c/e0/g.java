package b.g.a.c.e0;

import b.g.a.a.c0$a;
import b.g.a.b.h;
import b.g.a.b.t.m;
import java.io.IOException;

/* JADX INFO: compiled from: TypeSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class g {
    public abstract g a(b.g.a.c.d dVar);

    public abstract String b();

    public abstract c0$a c();

    public b.g.a.b.s.b d(Object obj, h hVar) {
        b.g.a.b.s.b bVar = new b.g.a.b.s.b(obj, hVar);
        int iOrdinal = c().ordinal();
        if (iOrdinal == 0) {
            bVar.e = 3;
            bVar.d = b();
        } else if (iOrdinal == 1) {
            bVar.e = 2;
        } else if (iOrdinal == 2) {
            bVar.e = 1;
        } else if (iOrdinal == 3) {
            bVar.e = 5;
            bVar.d = b();
        } else {
            if (iOrdinal != 4) {
                int i = m.a;
                throw new RuntimeException("Internal error: this code path should never get executed");
            }
            bVar.e = 4;
            bVar.d = b();
        }
        return bVar;
    }

    public abstract b.g.a.b.s.b e(b.g.a.b.d dVar, b.g.a.b.s.b bVar) throws IOException;

    public abstract b.g.a.b.s.b f(b.g.a.b.d dVar, b.g.a.b.s.b bVar) throws IOException;
}
