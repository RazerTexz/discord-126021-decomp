package b.g.a.c.g0.t;

import b.g.a.a.i0;

/* JADX INFO: compiled from: ObjectIdWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class j {
    public final b.g.a.c.j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.g.a.b.k f704b;
    public final i0<?> c;
    public final b.g.a.c.n<Object> d;
    public final boolean e;

    public j(b.g.a.c.j jVar, b.g.a.b.k kVar, i0<?> i0Var, b.g.a.c.n<?> nVar, boolean z2) {
        this.a = jVar;
        this.f704b = kVar;
        this.c = i0Var;
        this.d = nVar;
        this.e = z2;
    }

    public static j a(b.g.a.c.j jVar, b.g.a.c.t tVar, i0<?> i0Var, boolean z2) {
        String str = tVar == null ? null : tVar._simpleName;
        return new j(jVar, str != null ? new b.g.a.b.p.j(str) : null, i0Var, null, z2);
    }
}
