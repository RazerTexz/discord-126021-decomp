package b.c.a.y.l;

import b.c.a.w.b.s;

/* JADX INFO: compiled from: ShapeTrimPath.java */
/* JADX INFO: loaded from: classes.dex */
public class p implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f429b;
    public final b.c.a.y.k.b c;
    public final b.c.a.y.k.b d;
    public final b.c.a.y.k.b e;
    public final boolean f;

    public p(String str, int i, b.c.a.y.k.b bVar, b.c.a.y.k.b bVar2, b.c.a.y.k.b bVar3, boolean z2) {
        this.a = str;
        this.f429b = i;
        this.c = bVar;
        this.d = bVar2;
        this.e = bVar3;
        this.f = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new s(bVar, this);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("Trim Path: {start: ");
        sbU.append(this.c);
        sbU.append(", end: ");
        sbU.append(this.d);
        sbU.append(", offset: ");
        sbU.append(this.e);
        sbU.append("}");
        return sbU.toString();
    }
}
