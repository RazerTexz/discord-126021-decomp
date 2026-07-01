package b.c.a.y.l;

import android.graphics.PointF;

/* JADX INFO: compiled from: CircleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class a implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.c.a.y.k.m<PointF, PointF> f415b;
    public final b.c.a.y.k.f c;
    public final boolean d;
    public final boolean e;

    public a(String str, b.c.a.y.k.m<PointF, PointF> mVar, b.c.a.y.k.f fVar, boolean z2, boolean z3) {
        this.a = str;
        this.f415b = mVar;
        this.c = fVar;
        this.d = z2;
        this.e = z3;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.f(jVar, bVar, this);
    }
}
