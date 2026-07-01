package b.c.a.y.l;

import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: ShapeGroup.java */
/* JADX INFO: loaded from: classes.dex */
public class m implements b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<b> f426b;
    public final boolean c;

    public m(String str, List<b> list, boolean z2) {
        this.a = str;
        this.f426b = list;
        this.c = z2;
    }

    @Override // b.c.a.y.l.b
    public b.c.a.w.b.c a(b.c.a.j jVar, b.c.a.y.m.b bVar) {
        return new b.c.a.w.b.d(jVar, bVar, this);
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("ShapeGroup{name='");
        sbU.append(this.a);
        sbU.append("' Shapes: ");
        sbU.append(Arrays.toString(this.f426b.toArray()));
        sbU.append('}');
        return sbU.toString();
    }
}
