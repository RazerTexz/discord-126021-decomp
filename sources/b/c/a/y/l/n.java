package b.c.a.y.l;

import b.c.a.w.b.q;

/* JADX INFO: compiled from: ShapePath.java */
/* JADX INFO: loaded from: classes.dex */
public class n implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f427b;
    public final b.c.a.y.k.h c;
    public final boolean d;

    public n(String str, int i, b.c.a.y.k.h hVar, boolean z2) {
        this.a = str;
        this.f427b = i;
        this.c = hVar;
        this.d = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new q(jVar, bVar, this);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ShapePath{name=");
        sbU.append(this.a);
        sbU.append(", index=");
        return b.d.b.a.a.A(sbU, this.f427b, '}');
    }
}
