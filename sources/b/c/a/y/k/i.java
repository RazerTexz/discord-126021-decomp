package b.c.a.y.k;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: compiled from: AnimatableSplitDimensionPathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class i implements m<PointF, PointF> {
    public final b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f412b;

    public i(b bVar, b bVar2) {
        this.a = bVar;
        this.f412b = bVar2;
    }

    @Override // b.c.a.y.k.m
    public b.c.a.w.c.a<PointF, PointF> a() {
        return new b.c.a.w.c.m(this.a.a(), this.f412b.a());
    }

    @Override // b.c.a.y.k.m
    public List<b.c.a.c0.a<PointF>> b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // b.c.a.y.k.m
    public boolean isStatic() {
        return this.a.isStatic() && this.f412b.isStatic();
    }
}
