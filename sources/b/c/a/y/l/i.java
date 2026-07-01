package b.c.a.y.l;

import android.graphics.PointF;

/* JADX INFO: compiled from: RectangleShape.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.c.a.y.k.m<PointF, PointF> f422b;
    public final b.c.a.y.k.f c;
    public final b.c.a.y.k.b d;
    public final boolean e;

    public i(String str, b.c.a.y.k.m<PointF, PointF> mVar, b.c.a.y.k.f fVar, b.c.a.y.k.b bVar, boolean z2) {
        this.a = str;
        this.f422b = mVar;
        this.c = fVar;
        this.d = bVar;
        this.e = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.o(jVar, bVar, this);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("RectangleShape{position=");
        sbU.append(this.f422b);
        sbU.append(", size=");
        sbU.append(this.c);
        sbU.append('}');
        return sbU.toString();
    }
}
