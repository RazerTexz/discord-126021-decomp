package b.g.a.c.b0;

import b.g.a.b.h;
import b.g.a.c.e0.g;
import b.g.a.c.g0.u.p0;
import b.g.a.c.x;
import java.io.IOException;
import java.nio.file.Path;

/* JADX INFO: compiled from: NioPathSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends p0<Path> {
    private static final long serialVersionUID = 1;

    public e() {
        super(Path.class);
    }

    @Override // b.g.a.c.n
    public void f(Object obj, b.g.a.b.d dVar, x xVar) throws IOException {
        dVar.j0(((Path) obj).toUri().toString());
    }

    @Override // b.g.a.c.g0.u.p0, b.g.a.c.n
    public void g(Object obj, b.g.a.b.d dVar, x xVar, g gVar) throws IOException {
        Path path = (Path) obj;
        b.g.a.b.s.b bVarD = gVar.d(path, h.VALUE_STRING);
        bVarD.f675b = Path.class;
        b.g.a.b.s.b bVarE = gVar.e(dVar, bVarD);
        dVar.j0(path.toUri().toString());
        gVar.f(dVar, bVarE);
    }
}
