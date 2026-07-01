package b.g.a.c.g0.u;

import b.g.a.a.c0$a;
import java.io.IOException;

/* JADX INFO: compiled from: JsonValueSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public class s$a extends b.g.a.c.e0.g {
    public final b.g.a.c.e0.g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f714b;

    public s$a(b.g.a.c.e0.g gVar, Object obj) {
        this.a = gVar;
        this.f714b = obj;
    }

    @Override // b.g.a.c.e0.g
    public b.g.a.c.e0.g a(b.g.a.c.d dVar) {
        throw new UnsupportedOperationException();
    }

    @Override // b.g.a.c.e0.g
    public String b() {
        return this.a.b();
    }

    @Override // b.g.a.c.e0.g
    public c0$a c() {
        return this.a.c();
    }

    @Override // b.g.a.c.e0.g
    public b.g.a.b.s.b e(b.g.a.b.d dVar, b.g.a.b.s.b bVar) throws IOException {
        bVar.a = this.f714b;
        return this.a.e(dVar, bVar);
    }

    @Override // b.g.a.c.e0.g
    public b.g.a.b.s.b f(b.g.a.b.d dVar, b.g.a.b.s.b bVar) throws IOException {
        return this.a.f(dVar, bVar);
    }
}
