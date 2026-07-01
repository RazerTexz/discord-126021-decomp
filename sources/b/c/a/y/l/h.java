package b.c.a.y.l;

import android.graphics.PointF;

/* JADX INFO: compiled from: PolystarShape.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final h$a f421b;
    public final b.c.a.y.k.b c;
    public final b.c.a.y.k.m<PointF, PointF> d;
    public final b.c.a.y.k.b e;
    public final b.c.a.y.k.b f;
    public final b.c.a.y.k.b g;
    public final b.c.a.y.k.b h;
    public final b.c.a.y.k.b i;
    public final boolean j;

    public h(String str, h$a h_a, b.c.a.y.k.b bVar, b.c.a.y.k.m<PointF, PointF> mVar, b.c.a.y.k.b bVar2, b.c.a.y.k.b bVar3, b.c.a.y.k.b bVar4, b.c.a.y.k.b bVar5, b.c.a.y.k.b bVar6, boolean z2) {
        this.a = str;
        this.f421b = h_a;
        this.c = bVar;
        this.d = mVar;
        this.e = bVar2;
        this.f = bVar3;
        this.g = bVar4;
        this.h = bVar5;
        this.i = bVar6;
        this.j = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.n(jVar, bVar, this);
    }
}
