package p007b.p085c.p086a.p091w.p093c;

import android.graphics.PointF;
import java.util.Collections;
import p007b.p085c.p086a.p090c0.C1501a;

/* JADX INFO: renamed from: b.c.a.w.c.m */
/* JADX INFO: compiled from: SplitDimensionPathKeyframeAnimation.java */
/* JADX INFO: loaded from: classes.dex */
public class C1556m extends AbstractC1544a<PointF, PointF> {

    /* JADX INFO: renamed from: i */
    public final PointF f2624i;

    /* JADX INFO: renamed from: j */
    public final AbstractC1544a<Float, Float> f2625j;

    /* JADX INFO: renamed from: k */
    public final AbstractC1544a<Float, Float> f2626k;

    public C1556m(AbstractC1544a<Float, Float> abstractC1544a, AbstractC1544a<Float, Float> abstractC1544a2) {
        super(Collections.emptyList());
        this.f2624i = new PointF();
        this.f2625j = abstractC1544a;
        this.f2626k = abstractC1544a2;
        mo730h(this.f2599d);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: e */
    public PointF mo727e() {
        return this.f2624i;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: f */
    public PointF mo728f(C1501a<PointF> c1501a, float f) {
        return this.f2624i;
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a
    /* JADX INFO: renamed from: h */
    public void mo730h(float f) {
        this.f2625j.mo730h(f);
        this.f2626k.mo730h(f);
        this.f2624i.set(this.f2625j.mo727e().floatValue(), this.f2626k.mo727e().floatValue());
        for (int i = 0; i < this.f2596a.size(); i++) {
            this.f2596a.get(i).mo709a();
        }
    }
}
