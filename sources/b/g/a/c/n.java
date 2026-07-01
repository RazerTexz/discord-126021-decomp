package b.g.a.c;

import java.io.IOException;

/* JADX INFO: compiled from: JsonSerializer.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class n<T> {
    public Class<T> c() {
        return null;
    }

    public boolean d(x xVar, T t) {
        return t == null;
    }

    public boolean e() {
        return this instanceof b.g.a.c.g0.t.t;
    }

    public abstract void f(T t, b.g.a.b.d dVar, x xVar) throws IOException;

    public void g(T t, b.g.a.b.d dVar, x xVar, b.g.a.c.e0.g gVar) throws IOException {
        Class clsC = c();
        if (clsC == null) {
            clsC = t.getClass();
        }
        xVar.f(xVar.b(clsC), String.format("Type id handling not implemented for type %s (by serializer of type %s)", clsC.getName(), getClass().getName()));
        throw null;
    }

    public n<T> h(b.g.a.c.i0.n nVar) {
        return this;
    }

    public boolean i() {
        return false;
    }
}
