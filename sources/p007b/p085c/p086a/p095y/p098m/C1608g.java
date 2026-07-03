package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.List;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.p091w.p092b.C1528d;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p097l.C1598m;

/* JADX INFO: renamed from: b.c.a.y.m.g */
/* JADX INFO: compiled from: ShapeLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1608g extends AbstractC1603b {

    /* JADX INFO: renamed from: x */
    public final C1528d f2898x;

    public C1608g(C1511j c1511j, C1606e c1606e) {
        super(c1511j, c1606e);
        C1528d c1528d = new C1528d(c1511j, this, new C1598m("__container", c1606e.f2868a, false));
        this.f2898x = c1528d;
        c1528d.mo710b(Collections.emptyList(), Collections.emptyList());
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        this.f2898x.mo712d(rectF, this.f2848m, z2);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: j */
    public void mo780j(@NonNull Canvas canvas, Matrix matrix, int i) {
        this.f2898x.mo713f(canvas, matrix, i);
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: n */
    public void mo784n(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        this.f2898x.mo711c(c1567f, i, list, c1567f2);
    }
}
