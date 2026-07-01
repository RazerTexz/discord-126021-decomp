package b.c.a.w.c;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: compiled from: SplitDimensionPathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class m extends a<PointF, PointF> {
    public final PointF i;
    public final a<Float, Float> j;
    public final a<Float, Float> k;

    public m(a<Float, Float> aVar, a<Float, Float> aVar2) {
        super(Collections.emptyList());
        this.i = new PointF();
        this.j = aVar;
        this.k = aVar2;
        h(this.d);
    }

    @Override // b.c.a.w.c.a
    public PointF e() {
        return this.i;
    }

    @Override // b.c.a.w.c.a
    public PointF f(b.c.a.c0.a<PointF> aVar, float f) {
        return this.i;
    }

    @Override // b.c.a.w.c.a
    public void h(float f) {
        this.j.h(f);
        this.k.h(f);
        this.i.set(this.j.e().floatValue(), this.k.e().floatValue());
        for (int i = 0; i < this.a.size(); i++) {
            this.a.get(i).a();
        }
    }
}
