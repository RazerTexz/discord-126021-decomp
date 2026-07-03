package p007b.p085c.p086a.p095y.p098m;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1495c;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.y.m.c */
/* JADX INFO: compiled from: CompositionLayer.java */
/* JADX INFO: loaded from: classes.dex */
public class C1604c extends AbstractC1603b {

    /* JADX INFO: renamed from: A */
    public final RectF f2859A;

    /* JADX INFO: renamed from: B */
    public Paint f2860B;

    /* JADX INFO: renamed from: x */
    @Nullable
    public AbstractC1544a<Float, Float> f2861x;

    /* JADX INFO: renamed from: y */
    public final List<AbstractC1603b> f2862y;

    /* JADX INFO: renamed from: z */
    public final RectF f2863z;

    public C1604c(C1511j c1511j, C1606e c1606e, List<C1606e> list, C1505d c1505d) {
        int i;
        AbstractC1603b abstractC1603b;
        AbstractC1603b c1604c;
        super(c1511j, c1606e);
        this.f2862y = new ArrayList();
        this.f2863z = new RectF();
        this.f2859A = new RectF();
        this.f2860B = new Paint();
        C1573b c1573b = c1606e.f2886s;
        if (c1573b != null) {
            AbstractC1544a<Float, Float> abstractC1544aMo773a = c1573b.mo773a();
            this.f2861x = abstractC1544aMo773a;
            m777e(abstractC1544aMo773a);
            this.f2861x.f2596a.add(this);
        } else {
            this.f2861x = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(c1505d.f2344i.size());
        int size = list.size() - 1;
        AbstractC1603b abstractC1603b2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            C1606e c1606e2 = list.get(size);
            int iOrdinal = c1606e2.f2872e.ordinal();
            if (iOrdinal == 0) {
                c1604c = new C1604c(c1511j, c1606e2, c1505d.f2338c.get(c1606e2.f2874g), c1505d);
            } else if (iOrdinal == 1) {
                c1604c = new C1609h(c1511j, c1606e2);
            } else if (iOrdinal == 2) {
                c1604c = new C1605d(c1511j, c1606e2);
            } else if (iOrdinal == 3) {
                c1604c = new C1607f(c1511j, c1606e2);
            } else if (iOrdinal == 4) {
                c1604c = new C1608g(c1511j, c1606e2);
            } else if (iOrdinal != 5) {
                StringBuilder sbM833U = C1643a.m833U("Unknown layer type ");
                sbM833U.append(c1606e2.f2872e);
                C1495c.m640b(sbM833U.toString());
                c1604c = null;
            } else {
                c1604c = new C1610i(c1511j, c1606e2);
            }
            if (c1604c != null) {
                longSparseArray.put(c1604c.f2850o.f2871d, c1604c);
                if (abstractC1603b2 != null) {
                    abstractC1603b2.f2853r = c1604c;
                    abstractC1603b2 = null;
                } else {
                    this.f2862y.add(0, c1604c);
                    int iM758h = C1563b.m758h(c1606e2.f2888u);
                    if (iM758h == 1 || iM758h == 2) {
                        abstractC1603b2 = c1604c;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            AbstractC1603b abstractC1603b3 = (AbstractC1603b) longSparseArray.get(longSparseArray.keyAt(i));
            if (abstractC1603b3 != null && (abstractC1603b = (AbstractC1603b) longSparseArray.get(abstractC1603b3.f2850o.f2873f)) != null) {
                abstractC1603b3.f2854s = abstractC1603b;
            }
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: d */
    public void mo712d(RectF rectF, Matrix matrix, boolean z2) {
        super.mo712d(rectF, matrix, z2);
        for (int size = this.f2862y.size() - 1; size >= 0; size--) {
            this.f2863z.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.f2862y.get(size).mo712d(this.f2863z, this.f2848m, true);
            rectF.union(this.f2863z);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b, p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        this.f2857v.m745c(t, c1503c);
        if (t == InterfaceC1516o.f2419A) {
            if (c1503c == null) {
                AbstractC1544a<Float, Float> abstractC1544a = this.f2861x;
                if (abstractC1544a != null) {
                    abstractC1544a.m731i(null);
                    return;
                }
                return;
            }
            C1559p c1559p = new C1559p(c1503c, null);
            this.f2861x = c1559p;
            c1559p.f2596a.add(this);
            m777e(this.f2861x);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: j */
    public void mo780j(Canvas canvas, Matrix matrix, int i) {
        RectF rectF = this.f2859A;
        C1606e c1606e = this.f2850o;
        rectF.set(0.0f, 0.0f, c1606e.f2882o, c1606e.f2883p);
        matrix.mapRect(this.f2859A);
        boolean z2 = this.f2849n.f2366A && this.f2862y.size() > 1 && i != 255;
        if (z2) {
            this.f2860B.setAlpha(i);
            C1499g.m662f(canvas, this.f2859A, this.f2860B, 31);
        } else {
            canvas.save();
        }
        if (z2) {
            i = 255;
        }
        for (int size = this.f2862y.size() - 1; size >= 0; size--) {
            if (!this.f2859A.isEmpty() ? canvas.clipRect(this.f2859A) : true) {
                this.f2862y.get(size).mo713f(canvas, matrix, i);
            }
        }
        canvas.restore();
        C1500c.m663a("CompositionLayer#draw");
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: n */
    public void mo784n(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2) {
        for (int i2 = 0; i2 < this.f2862y.size(); i2++) {
            this.f2862y.get(i2).mo711c(c1567f, i, list, c1567f2);
        }
    }

    @Override // p007b.p085c.p086a.p095y.p098m.AbstractC1603b
    /* JADX INFO: renamed from: o */
    public void mo785o(@FloatRange(from = 0.0d, m75to = 1.0d) float f) {
        super.mo785o(f);
        if (this.f2861x != null) {
            f = ((this.f2861x.mo727e().floatValue() * this.f2850o.f2869b.f2348m) - this.f2850o.f2869b.f2346k) / (this.f2849n.f2370k.m671c() + 0.01f);
        }
        if (this.f2861x == null) {
            C1606e c1606e = this.f2850o;
            f -= c1606e.f2881n / c1606e.f2869b.m671c();
        }
        float f2 = this.f2850o.f2880m;
        if (f2 != 0.0f) {
            f /= f2;
        }
        int size = this.f2862y.size();
        while (true) {
            size--;
            if (size < 0) {
                return;
            } else {
                this.f2862y.get(size).mo785o(f);
            }
        }
    }
}
