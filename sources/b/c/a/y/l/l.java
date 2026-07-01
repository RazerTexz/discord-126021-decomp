package b.c.a.y.l;

import android.graphics.Path$FillType;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: ShapeFill.java */
/* JADX INFO: loaded from: classes.dex */
public class l implements b {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path$FillType f425b;
    public final String c;

    @Nullable
    public final b.c.a.y.k.a d;

    @Nullable
    public final b.c.a.y.k.d e;
    public final boolean f;

    public l(String str, boolean z2, Path$FillType path$FillType, @Nullable b.c.a.y.k.a aVar, @Nullable b.c.a.y.k.d dVar, boolean z3) {
        this.c = str;
        this.a = z2;
        this.f425b = path$FillType;
        this.d = aVar;
        this.e = dVar;
        this.f = z3;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.g(jVar, bVar, this);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ShapeFill{color=, fillEnabled=");
        sbU.append(this.a);
        sbU.append('}');
        return sbU.toString();
    }
}
