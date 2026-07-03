package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1545b;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p097l.C1597l;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.g */
/* JADX INFO: compiled from: FillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1531g implements InterfaceC1529e, AbstractC1544a.b, InterfaceC1535k {

    /* JADX INFO: renamed from: a */
    public final Path f2501a;

    /* JADX INFO: renamed from: b */
    public final Paint f2502b;

    /* JADX INFO: renamed from: c */
    public final AbstractC1603b f2503c;

    /* JADX INFO: renamed from: d */
    public final String f2504d;

    /* JADX INFO: renamed from: e */
    public final boolean f2505e;

    /* JADX INFO: renamed from: f */
    public final List<InterfaceC1537m> f2506f;

    /* JADX INFO: renamed from: g */
    public final AbstractC1544a<Integer, Integer> f2507g;

    /* JADX INFO: renamed from: h */
    public final AbstractC1544a<Integer, Integer> f2508h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public AbstractC1544a<ColorFilter, ColorFilter> f2509i;

    /* JADX INFO: renamed from: j */
    public final C1511j f2510j;

    public C1531g(C1511j c1511j, AbstractC1603b abstractC1603b, C1597l c1597l) {
        Path path = new Path();
        this.f2501a = path;
        this.f2502b = new C1524a(1);
        this.f2506f = new ArrayList();
        this.f2503c = abstractC1603b;
        this.f2504d = c1597l.f2808c;
        this.f2505e = c1597l.f2811f;
        this.f2510j = c1511j;
        if (c1597l.f2809d == null || c1597l.f2810e == null) {
            this.f2507g = null;
            this.f2508h = null;
            return;
        }
        path.setFillType(c1597l.f2807b);
        AbstractC1544a<Integer, Integer> abstractC1544aMo773a = c1597l.f2809d.mo773a();
        this.f2507g = abstractC1544aMo773a;
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a);
        AbstractC1544a<Integer, Integer> abstractC1544aMo773a2 = c1597l.f2810e.mo773a();
        this.f2508h = abstractC1544aMo773a2;
        abstractC1544aMo773a2.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a2);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2510j.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            InterfaceC1527c interfaceC1527c = list2.get(i);
            if (interfaceC1527c instanceof InterfaceC1537m) {
                this.f2506f.add((InterfaceC1537m) interfaceC1527c);
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: c */
    public void mo711c(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        C1498f.m656f(c1567f, i, list, c1567f2, this);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2501a.reset();
        for (int i = 0; i < this.f2506f.size(); i++) {
            this.f2501a.addPath(this.f2506f.get(i).getPath(), matrix);
        }
        this.f2501a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        if (this.f2505e) {
            return;
        }
        Paint paint = this.f2502b;
        C1545b c1545b = (C1545b) this.f2507g;
        paint.setColor(c1545b.m738j(c1545b.m723a(), c1545b.m725c()));
        this.f2502b.setAlpha(C1498f.m653c((int) ((((i / 255.0f) * this.f2508h.mo727e().intValue()) / 100.0f) * 255.0f), 0, 255));
        AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a = this.f2509i;
        if (abstractC1544a != null) {
            this.f2502b.setColorFilter(abstractC1544a.mo727e());
        }
        this.f2501a.reset();
        for (int i2 = 0; i2 < this.f2506f.size(); i2++) {
            this.f2501a.addPath(this.f2506f.get(i2).getPath(), matrix);
        }
        canvas.drawPath(this.f2501a, this.f2502b);
        C1500c.m663a("FillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        if (t == InterfaceC1516o.f2423a) {
            AbstractC1544a<Integer, Integer> abstractC1544a = this.f2507g;
            C1503c<Integer> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2426d) {
            AbstractC1544a<Integer, Integer> abstractC1544a2 = this.f2508h;
            C1503c<Integer> c1503c3 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2421C) {
            AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a3 = this.f2509i;
            if (abstractC1544a3 != null) {
                this.f2503c.f2856u.remove(abstractC1544a3);
            }
            if (c1503c == 0) {
                this.f2509i = null;
                return;
            }
            C1559p c1559p = new C1559p(c1503c, null);
            this.f2509i = c1559p;
            c1559p.f2596a.add(this);
            this.f2503c.m777e(this.f2509i);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2504d;
    }
}
