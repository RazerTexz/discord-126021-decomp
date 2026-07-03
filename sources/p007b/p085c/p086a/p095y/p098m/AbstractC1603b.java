package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build;
import androidx.annotation.CallSuper;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.C1520s;
import p007b.p085c.p086a.p089b0.C1497e;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p090c0.C1504d;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1527c;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1529e;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1546c;
import p007b.p085c.p086a.p091w.p093c.C1550g;
import p007b.p085c.p086a.p091w.p093c.C1558o;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.InterfaceC1568g;
import p007b.p085c.p086a.p095y.p096k.C1583l;
import p007b.p085c.p086a.p095y.p097l.C1591f;
import p007b.p085c.p086a.p095y.p097l.C1596k;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.m.b */
/* JADX INFO: compiled from: BaseLayer.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1603b implements InterfaceC1529e, AbstractC1544a.b, InterfaceC1568g {

    /* JADX INFO: renamed from: a */
    public final Path f2836a = new Path();

    /* JADX INFO: renamed from: b */
    public final Matrix f2837b = new Matrix();

    /* JADX INFO: renamed from: c */
    public final Paint f2838c = new C1524a(1);

    /* JADX INFO: renamed from: d */
    public final Paint f2839d = new C1524a(1, PorterDuff.Mode.DST_IN);

    /* JADX INFO: renamed from: e */
    public final Paint f2840e = new C1524a(1, PorterDuff.Mode.DST_OUT);

    /* JADX INFO: renamed from: f */
    public final Paint f2841f;

    /* JADX INFO: renamed from: g */
    public final Paint f2842g;

    /* JADX INFO: renamed from: h */
    public final RectF f2843h;

    /* JADX INFO: renamed from: i */
    public final RectF f2844i;

    /* JADX INFO: renamed from: j */
    public final RectF f2845j;

    /* JADX INFO: renamed from: k */
    public final RectF f2846k;

    /* JADX INFO: renamed from: l */
    public final String f2847l;

    /* JADX INFO: renamed from: m */
    public final Matrix f2848m;

    /* JADX INFO: renamed from: n */
    public final C1511j f2849n;

    /* JADX INFO: renamed from: o */
    public final C1606e f2850o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public C1550g f2851p;

    /* JADX INFO: renamed from: q */
    @Nullable
    public C1546c f2852q;

    /* JADX INFO: renamed from: r */
    @Nullable
    public AbstractC1603b f2853r;

    /* JADX INFO: renamed from: s */
    @Nullable
    public AbstractC1603b f2854s;

    /* JADX INFO: renamed from: t */
    public List<AbstractC1603b> f2855t;

    /* JADX INFO: renamed from: u */
    public final List<AbstractC1544a<?, ?>> f2856u;

    /* JADX INFO: renamed from: v */
    public final C1558o f2857v;

    /* JADX INFO: renamed from: w */
    public boolean f2858w;

    public AbstractC1603b(C1511j c1511j, C1606e c1606e) {
        C1524a c1524a = new C1524a(1);
        this.f2841f = c1524a;
        this.f2842g = new C1524a(PorterDuff.Mode.CLEAR);
        this.f2843h = new RectF();
        this.f2844i = new RectF();
        this.f2845j = new RectF();
        this.f2846k = new RectF();
        this.f2848m = new Matrix();
        this.f2856u = new ArrayList();
        this.f2858w = true;
        this.f2849n = c1511j;
        this.f2850o = c1606e;
        this.f2847l = C1643a.m822J(new StringBuilder(), c1606e.f2870c, "#draw");
        if (c1606e.f2888u == 3) {
            c1524a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        } else {
            c1524a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        }
        C1583l c1583l = c1606e.f2876i;
        Objects.requireNonNull(c1583l);
        C1558o c1558o = new C1558o(c1583l);
        this.f2857v = c1558o;
        c1558o.m744b(this);
        List<C1591f> list = c1606e.f2875h;
        if (list != null && !list.isEmpty()) {
            C1550g c1550g = new C1550g(c1606e.f2875h);
            this.f2851p = c1550g;
            Iterator<AbstractC1544a<C1596k, Path>> it = c1550g.f2611a.iterator();
            while (it.hasNext()) {
                it.next().f2596a.add(this);
            }
            for (AbstractC1544a<Integer, Integer> abstractC1544a : this.f2851p.f2612b) {
                m777e(abstractC1544a);
                abstractC1544a.f2596a.add(this);
            }
        }
        if (this.f2850o.f2887t.isEmpty()) {
            m786p(true);
            return;
        }
        C1546c c1546c = new C1546c(this.f2850o.f2887t);
        this.f2852q = c1546c;
        c1546c.f2597b = true;
        c1546c.f2596a.add(new C1602a(this));
        m786p(this.f2852q.mo727e().floatValue() == 1.0f);
        m777e(this.f2852q);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2849n.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: c */
    public void mo711c(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        if (c1567f.m770e(this.f2850o.f2870c, i)) {
            if (!"__container".equals(this.f2850o.f2870c)) {
                c1567f2 = c1567f2.m766a(this.f2850o.f2870c);
                if (c1567f.m768c(this.f2850o.f2870c, i)) {
                    list.add(c1567f2.m772g(this));
                }
            }
            if (c1567f.m771f(this.f2850o.f2870c, i)) {
                mo784n(c1567f, c1567f.m769d(this.f2850o.f2870c, i) + i, list, c1567f2);
            }
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    @CallSuper
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        this.f2843h.set(0.0f, 0.0f, 0.0f, 0.0f);
        m778h();
        this.f2848m.set(matrix);
        if (z2) {
            List<AbstractC1603b> list = this.f2855t;
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    this.f2848m.preConcat(this.f2855t.get(size).f2857v.m747e());
                }
            } else {
                AbstractC1603b abstractC1603b = this.f2854s;
                if (abstractC1603b != null) {
                    this.f2848m.preConcat(abstractC1603b.f2857v.m747e());
                }
            }
        }
        this.f2848m.preConcat(this.f2857v.m747e());
    }

    /* JADX INFO: renamed from: e */
    public void m777e(@Nullable AbstractC1544a<?, ?> abstractC1544a) {
        if (abstractC1544a == null) {
            return;
        }
        this.f2856u.add(abstractC1544a);
    }

    /* JADX WARN: Code duplicated, block: B:115:0x017c A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:40:0x011e  */
    /* JADX WARN: Code duplicated, block: B:45:0x012c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0134  */
    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        boolean z2;
        String str = this.f2847l;
        if (!this.f2858w || this.f2850o.f2889v) {
            C1500c.m663a(str);
            return;
        }
        m778h();
        this.f2837b.reset();
        this.f2837b.set(matrix);
        int i2 = 1;
        for (int size = this.f2855t.size() - 1; size >= 0; size--) {
            this.f2837b.preConcat(this.f2855t.get(size).f2857v.m747e());
        }
        C1500c.m663a("Layer#parentMatrix");
        AbstractC1544a<Integer, Integer> abstractC1544a = this.f2857v.f2636j;
        int iIntValue = (int) ((((i / 255.0f) * (abstractC1544a == null ? 100 : abstractC1544a.mo727e().intValue())) / 100.0f) * 255.0f);
        float f = 0.0f;
        if (!m782l() && !m781k()) {
            this.f2837b.preConcat(this.f2857v.m747e());
            mo780j(canvas, this.f2837b, iIntValue);
            C1500c.m663a("Layer#drawLayer");
            C1500c.m663a(this.f2847l);
            m783m(0.0f);
            return;
        }
        boolean z3 = false;
        mo712d(this.f2843h, this.f2837b, false);
        RectF rectF = this.f2843h;
        int i3 = 3;
        if (m782l() && this.f2850o.f2888u != 3) {
            this.f2845j.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f2853r.mo712d(this.f2845j, matrix, true);
            if (!rectF.intersect(this.f2845j)) {
                rectF.set(0.0f, 0.0f, 0.0f, 0.0f);
            }
        }
        this.f2837b.preConcat(this.f2857v.m747e());
        RectF rectF2 = this.f2843h;
        Matrix matrix2 = this.f2837b;
        this.f2844i.set(0.0f, 0.0f, 0.0f, 0.0f);
        int i4 = 2;
        if (m781k()) {
            int size2 = this.f2851p.f2613c.size();
            int i5 = 0;
            while (true) {
                if (i5 < size2) {
                    C1591f c1591f = this.f2851p.f2613c.get(i5);
                    this.f2836a.set(this.f2851p.f2611a.get(i5).mo727e());
                    this.f2836a.transform(matrix2);
                    int iM758h = C1563b.m758h(c1591f.f2767a);
                    if (iM758h == 0) {
                        if (c1591f.f2770d) {
                        }
                        this.f2836a.computeBounds(this.f2846k, z3);
                        if (i5 == 0) {
                            this.f2844i.set(this.f2846k);
                        } else {
                            RectF rectF3 = this.f2844i;
                            rectF3.set(Math.min(rectF3.left, this.f2846k.left), Math.min(this.f2844i.top, this.f2846k.top), Math.max(this.f2844i.right, this.f2846k.right), Math.max(this.f2844i.bottom, this.f2846k.bottom));
                        }
                        i5++;
                        z3 = false;
                        i3 = 3;
                        i4 = 2;
                    } else if (iM758h != 1) {
                        if (iM758h != i4) {
                            if (iM758h == i3) {
                            }
                            this.f2836a.computeBounds(this.f2846k, z3);
                            if (i5 == 0) {
                                this.f2844i.set(this.f2846k);
                            } else {
                                RectF rectF4 = this.f2844i;
                                rectF4.set(Math.min(rectF4.left, this.f2846k.left), Math.min(this.f2844i.top, this.f2846k.top), Math.max(this.f2844i.right, this.f2846k.right), Math.max(this.f2844i.bottom, this.f2846k.bottom));
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        } else {
                            if (c1591f.f2770d) {
                            }
                            this.f2836a.computeBounds(this.f2846k, z3);
                            if (i5 == 0) {
                                this.f2844i.set(this.f2846k);
                            } else {
                                RectF rectF5 = this.f2844i;
                                rectF5.set(Math.min(rectF5.left, this.f2846k.left), Math.min(this.f2844i.top, this.f2846k.top), Math.max(this.f2844i.right, this.f2846k.right), Math.max(this.f2844i.bottom, this.f2846k.bottom));
                            }
                            i5++;
                            z3 = false;
                            i3 = 3;
                            i4 = 2;
                        }
                    }
                } else if (!rectF2.intersect(this.f2844i)) {
                    f = 0.0f;
                    rectF2.set(0.0f, 0.0f, 0.0f, 0.0f);
                    break;
                }
                f = 0.0f;
                break;
            }
        }
        if (!this.f2843h.intersect(f, f, canvas.getWidth(), canvas.getHeight())) {
            this.f2843h.set(f, f, f, f);
        }
        C1500c.m663a("Layer#computeBounds");
        if (!this.f2843h.isEmpty()) {
            this.f2838c.setAlpha(255);
            C1499g.m662f(canvas, this.f2843h, this.f2838c, 31);
            C1500c.m663a("Layer#saveLayer");
            m779i(canvas);
            mo780j(canvas, this.f2837b, iIntValue);
            C1500c.m663a("Layer#drawLayer");
            if (m781k()) {
                Matrix matrix3 = this.f2837b;
                C1499g.m662f(canvas, this.f2843h, this.f2839d, 19);
                if (Build.VERSION.SDK_INT < 28) {
                    m779i(canvas);
                }
                C1500c.m663a("Layer#saveLayer");
                int i6 = 0;
                while (i6 < this.f2851p.f2613c.size()) {
                    C1591f c1591f2 = this.f2851p.f2613c.get(i6);
                    AbstractC1544a<C1596k, Path> abstractC1544a2 = this.f2851p.f2611a.get(i6);
                    AbstractC1544a<Integer, Integer> abstractC1544a3 = this.f2851p.f2612b.get(i6);
                    int iM758h2 = C1563b.m758h(c1591f2.f2767a);
                    if (iM758h2 != 0) {
                        if (iM758h2 == i2) {
                            if (i6 == 0) {
                                this.f2838c.setColor(ViewCompat.MEASURED_STATE_MASK);
                                this.f2838c.setAlpha(255);
                                canvas.drawRect(this.f2843h, this.f2838c);
                            }
                            if (c1591f2.f2770d) {
                                C1499g.m662f(canvas, this.f2843h, this.f2840e, 31);
                                canvas.drawRect(this.f2843h, this.f2838c);
                                this.f2840e.setAlpha((int) (abstractC1544a3.mo727e().intValue() * 2.55f));
                                this.f2836a.set(abstractC1544a2.mo727e());
                                this.f2836a.transform(matrix3);
                                canvas.drawPath(this.f2836a, this.f2840e);
                                canvas.restore();
                            } else {
                                this.f2836a.set(abstractC1544a2.mo727e());
                                this.f2836a.transform(matrix3);
                                canvas.drawPath(this.f2836a, this.f2840e);
                            }
                        } else if (iM758h2 != 2) {
                            if (iM758h2 == 3) {
                                if (this.f2851p.f2611a.isEmpty()) {
                                    z2 = false;
                                    break;
                                }
                                int i7 = 0;
                                while (true) {
                                    if (i7 >= this.f2851p.f2613c.size()) {
                                        z2 = true;
                                        break;
                                    } else {
                                        if (this.f2851p.f2613c.get(i7).f2767a != 4) {
                                            z2 = false;
                                            break;
                                        }
                                        i7++;
                                    }
                                }
                                if (z2) {
                                    this.f2838c.setAlpha(255);
                                    canvas.drawRect(this.f2843h, this.f2838c);
                                }
                            }
                        } else if (c1591f2.f2770d) {
                            C1499g.m662f(canvas, this.f2843h, this.f2839d, 31);
                            canvas.drawRect(this.f2843h, this.f2838c);
                            this.f2840e.setAlpha((int) (abstractC1544a3.mo727e().intValue() * 2.55f));
                            this.f2836a.set(abstractC1544a2.mo727e());
                            this.f2836a.transform(matrix3);
                            canvas.drawPath(this.f2836a, this.f2840e);
                            canvas.restore();
                        } else {
                            C1499g.m662f(canvas, this.f2843h, this.f2839d, 31);
                            this.f2836a.set(abstractC1544a2.mo727e());
                            this.f2836a.transform(matrix3);
                            this.f2838c.setAlpha((int) (abstractC1544a3.mo727e().intValue() * 2.55f));
                            canvas.drawPath(this.f2836a, this.f2838c);
                            canvas.restore();
                        }
                    } else if (c1591f2.f2770d) {
                        C1499g.m662f(canvas, this.f2843h, this.f2838c, 31);
                        canvas.drawRect(this.f2843h, this.f2838c);
                        this.f2836a.set(abstractC1544a2.mo727e());
                        this.f2836a.transform(matrix3);
                        this.f2838c.setAlpha((int) (abstractC1544a3.mo727e().intValue() * 2.55f));
                        canvas.drawPath(this.f2836a, this.f2840e);
                        canvas.restore();
                    } else {
                        this.f2836a.set(abstractC1544a2.mo727e());
                        this.f2836a.transform(matrix3);
                        this.f2838c.setAlpha((int) (abstractC1544a3.mo727e().intValue() * 2.55f));
                        canvas.drawPath(this.f2836a, this.f2838c);
                    }
                    i6++;
                    i2 = 1;
                }
                canvas.restore();
                C1500c.m663a("Layer#restoreLayer");
            }
            if (m782l()) {
                C1499g.m662f(canvas, this.f2843h, this.f2841f, 19);
                C1500c.m663a("Layer#saveLayer");
                m779i(canvas);
                this.f2853r.mo713f(canvas, matrix, iIntValue);
                canvas.restore();
                C1500c.m663a("Layer#restoreLayer");
                C1500c.m663a("Layer#drawMatte");
            }
            canvas.restore();
            C1500c.m663a("Layer#restoreLayer");
        }
        C1500c.m663a(this.f2847l);
        m783m(0.0f);
    }

    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    @CallSuper
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        this.f2857v.m745c(t, c1503c);
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2850o.f2870c;
    }

    /* JADX INFO: renamed from: h */
    public final void m778h() {
        if (this.f2855t != null) {
            return;
        }
        if (this.f2854s == null) {
            this.f2855t = Collections.emptyList();
            return;
        }
        this.f2855t = new ArrayList();
        for (AbstractC1603b abstractC1603b = this.f2854s; abstractC1603b != null; abstractC1603b = abstractC1603b.f2854s) {
            this.f2855t.add(abstractC1603b);
        }
    }

    /* JADX INFO: renamed from: i */
    public final void m779i(Canvas canvas) {
        RectF rectF = this.f2843h;
        canvas.drawRect(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f, this.f2842g);
        C1500c.m663a("Layer#clearLayer");
    }

    /* JADX INFO: renamed from: j */
    public abstract void mo780j(Canvas canvas, Matrix matrix, int i);

    /* JADX INFO: renamed from: k */
    public boolean m781k() {
        C1550g c1550g = this.f2851p;
        return (c1550g == null || c1550g.f2611a.isEmpty()) ? false : true;
    }

    /* JADX INFO: renamed from: l */
    public boolean m782l() {
        return this.f2853r != null;
    }

    /* JADX INFO: renamed from: m */
    public final void m783m(float f) {
        C1520s c1520s = this.f2849n.f2370k.f2336a;
        String str = this.f2850o.f2870c;
        if (c1520s.f2458a) {
            C1497e c1497e = c1520s.f2460c.get(str);
            if (c1497e == null) {
                c1497e = new C1497e();
                c1520s.f2460c.put(str, c1497e);
            }
            float f2 = c1497e.f2306a + f;
            c1497e.f2306a = f2;
            int i = c1497e.f2307b + 1;
            c1497e.f2307b = i;
            if (i == Integer.MAX_VALUE) {
                c1497e.f2306a = f2 / 2.0f;
                c1497e.f2307b = i / 2;
            }
            if (str.equals("__container")) {
                Iterator<C1520s.a> it = c1520s.f2459b.iterator();
                while (it.hasNext()) {
                    it.next().m708a(f);
                }
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public void mo784n(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
    }

    /* JADX INFO: renamed from: o */
    public void mo785o(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        C1558o c1558o = this.f2857v;
        AbstractC1544a<Integer, Integer> abstractC1544a = c1558o.f2636j;
        if (abstractC1544a != null) {
            abstractC1544a.mo730h(f);
        }
        AbstractC1544a<?, Float> abstractC1544a2 = c1558o.f2639m;
        if (abstractC1544a2 != null) {
            abstractC1544a2.mo730h(f);
        }
        AbstractC1544a<?, Float> abstractC1544a3 = c1558o.f2640n;
        if (abstractC1544a3 != null) {
            abstractC1544a3.mo730h(f);
        }
        AbstractC1544a<PointF, PointF> abstractC1544a4 = c1558o.f2632f;
        if (abstractC1544a4 != null) {
            abstractC1544a4.mo730h(f);
        }
        AbstractC1544a<?, PointF> abstractC1544a5 = c1558o.f2633g;
        if (abstractC1544a5 != null) {
            abstractC1544a5.mo730h(f);
        }
        AbstractC1544a<C1504d, C1504d> abstractC1544a6 = c1558o.f2634h;
        if (abstractC1544a6 != null) {
            abstractC1544a6.mo730h(f);
        }
        AbstractC1544a<Float, Float> abstractC1544a7 = c1558o.f2635i;
        if (abstractC1544a7 != null) {
            abstractC1544a7.mo730h(f);
        }
        C1546c c1546c = c1558o.f2637k;
        if (c1546c != null) {
            c1546c.mo730h(f);
        }
        C1546c c1546c2 = c1558o.f2638l;
        if (c1546c2 != null) {
            c1546c2.mo730h(f);
        }
        if (this.f2851p != null) {
            for (int i = 0; i < this.f2851p.f2611a.size(); i++) {
                this.f2851p.f2611a.get(i).mo730h(f);
            }
        }
        float f2 = this.f2850o.f2880m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        C1546c c1546c3 = this.f2852q;
        if (c1546c3 != null) {
            c1546c3.mo730h(f / f2);
        }
        AbstractC1603b abstractC1603b = this.f2853r;
        if (abstractC1603b != null) {
            abstractC1603b.mo785o(abstractC1603b.f2850o.f2880m * f);
        }
        for (int i2 = 0; i2 < this.f2856u.size(); i2++) {
            this.f2856u.get(i2).mo730h(f);
        }
    }

    /* JADX INFO: renamed from: p */
    public final void m786p(boolean z2) {
        if (z2 != this.f2858w) {
            this.f2858w = z2;
            this.f2849n.invalidateSelf();
        }
    }
}
