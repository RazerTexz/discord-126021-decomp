package b.c.a.y.k;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: AnimatablePathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class e implements m<PointF, PointF> {
    public final List<b.c.a.c0.a<PointF>> a;

    public e(List<b.c.a.c0.a<PointF>> list) {
        this.a = list;
    }

    @Override // b.c.a.y.k.m
    public b.c.a.w.c.a<PointF, PointF> a() {
        return this.a.get(0).d() ? new b.c.a.w.c.j(this.a) : new b.c.a.w.c.i(this.a);
    }

    @Override // b.c.a.y.k.m
    public List<b.c.a.c0.a<PointF>> b() {
        return this.a;
    }

    @Override // b.c.a.y.k.m
    public boolean isStatic() {
        return this.a.size() == 1 && this.a.get(0).d();
    }
}
