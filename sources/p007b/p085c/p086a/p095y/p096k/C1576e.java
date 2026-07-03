package p007b.p085c.p086a.p095y.p096k;

import android.graphics.PointF;
import java.util.List;
import p007b.p085c.p086a.p090c0.C1501a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1552i;
import p007b.p085c.p086a.p091w.p093c.C1553j;

/* JADX INFO: renamed from: b.c.a.y.k.e */
/* JADX INFO: compiled from: AnimatablePathValue.java */
/* JADX INFO: loaded from: classes.dex */
public class C1576e implements InterfaceC1584m<PointF, PointF> {

    /* JADX INFO: renamed from: a */
    public final List<C1501a<PointF>> f2722a;

    public C1576e(List<C1501a<PointF>> list) {
        this.f2722a = list;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    /* JADX INFO: renamed from: a */
    public AbstractC1544a<PointF, PointF> mo773a() {
        return this.f2722a.get(0).m667d() ? new C1553j(this.f2722a) : new C1552i(this.f2722a);
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    /* JADX INFO: renamed from: b */
    public List<C1501a<PointF>> mo774b() {
        return this.f2722a;
    }

    @Override // p007b.p085c.p086a.p095y.p096k.InterfaceC1584m
    public boolean isStatic() {
        return this.f2722a.size() == 1 && this.f2722a.get(0).m667d();
    }
}
