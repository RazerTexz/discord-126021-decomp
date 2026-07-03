package p007b.p085c.p086a.p095y.p096k;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1556m;

/* JADX INFO: renamed from: b.c.a.y.k.i */
/* JADX INFO: compiled from: AnimatableSplitDimensionPathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class C1580i implements InterfaceC1584m<PointF, PointF> {

    /* JADX INFO: renamed from: a */
    public final C1573b f2723a;

    /* JADX INFO: renamed from: b */
    public final C1573b f2724b;

    public C1580i(C1573b c1573b, C1573b c1573b2) {
        this.f2723a = c1573b;
        this.f2724b = c1573b2;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    /* JADX INFO: renamed from: a */
    public AbstractC1544a<PointF, PointF> mo773a() {
        return new C1556m(this.f2723a.mo773a(), this.f2724b.mo773a());
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    /* JADX INFO: renamed from: b */
    public List<C1501a<PointF>> mo774b() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    public boolean isStatic() {
        return this.f2723a.isStatic() && this.f2724b.isStatic();
    }
}
