package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import androidx.annotation.Nullable;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1545b;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p097l.C1600o;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.r */
/* JADX INFO: compiled from: StrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1542r extends AbstractC1525a {

    /* JADX INFO: renamed from: o */
    public final AbstractC1603b f2585o;

    /* JADX INFO: renamed from: p */
    public final String f2586p;

    /* JADX INFO: renamed from: q */
    public final boolean f2587q;

    /* JADX INFO: renamed from: r */
    public final AbstractC1544a<Integer, Integer> f2588r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public AbstractC1544a<ColorFilter, ColorFilter> f2589s;

    public C1542r(C1511j c1511j, AbstractC1603b abstractC1603b, C1600o c1600o) {
        super(c1511j, abstractC1603b, C1563b.m761k(c1600o.f2825g), C1563b.m762l(c1600o.f2826h), c1600o.f2827i, c1600o.f2823e, c1600o.f2824f, c1600o.f2821c, c1600o.f2820b);
        this.f2585o = abstractC1603b;
        this.f2586p = c1600o.f2819a;
        this.f2587q = c1600o.f2828j;
        AbstractC1544a<Integer, Integer> abstractC1544aMo773a = c1600o.f2822d.mo773a();
        this.f2588r = abstractC1544aMo773a;
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.AbstractC1525a, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        if (this.f2587q) {
            return;
        }
        Paint paint = this.f2473i;
        C1545b c1545b = (C1545b) this.f2588r;
        paint.setColor(c1545b.m738j(c1545b.m723a(), c1545b.m725c()));
        AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a = this.f2589s;
        if (abstractC1544a != null) {
            this.f2473i.setColorFilter(abstractC1544a.mo727e());
        }
        super.mo713f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p092b.AbstractC1525a, p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        super.mo714g(t, c1503c);
        if (t == InterfaceC1516o.f2424b) {
            AbstractC1544a<Integer, Integer> abstractC1544a = this.f2588r;
            C1503c<Integer> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2421C) {
            AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a2 = this.f2589s;
            if (abstractC1544a2 != null) {
                this.f2585o.f2856u.remove(abstractC1544a2);
            }
            if (c1503c == 0) {
                this.f2589s = null;
                return;
            }
            C1559p c1559p = new C1559p(c1503c, null);
            this.f2589s = c1559p;
            c1559p.f2596a.add(this);
            this.f2585o.m777e(this.f2588r);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2586p;
    }
}
