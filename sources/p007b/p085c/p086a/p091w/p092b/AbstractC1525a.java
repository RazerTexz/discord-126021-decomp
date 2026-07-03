package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1546c;
import p007b.p085c.p086a.p091w.p093c.C1548e;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p096k.C1573b;
import p007b.p085c.p086a.p095y.p096k.C1575d;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.a */
/* JADX INFO: compiled from: BaseStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1525a implements AbstractC1544a.b, InterfaceC1535k, InterfaceC1529e {

    /* JADX INFO: renamed from: e */
    public final C1511j f2469e;

    /* JADX INFO: renamed from: f */
    public final AbstractC1603b f2470f;

    /* JADX INFO: renamed from: h */
    public final float[] f2472h;

    /* JADX INFO: renamed from: i */
    public final Paint f2473i;

    /* JADX INFO: renamed from: j */
    public final AbstractC1544a<?, Float> f2474j;

    /* JADX INFO: renamed from: k */
    public final AbstractC1544a<?, Integer> f2475k;

    /* JADX INFO: renamed from: l */
    public final List<AbstractC1544a<?, Float>> f2476l;

    /* JADX INFO: renamed from: m */
    @Nullable
    public final AbstractC1544a<?, Float> f2477m;

    /* JADX INFO: renamed from: n */
    @Nullable
    public AbstractC1544a<ColorFilter, ColorFilter> f2478n;

    /* JADX INFO: renamed from: a */
    public final PathMeasure f2465a = new PathMeasure();

    /* JADX INFO: renamed from: b */
    public final Path f2466b = new Path();

    /* JADX INFO: renamed from: c */
    public final Path f2467c = new Path();

    /* JADX INFO: renamed from: d */
    public final RectF f2468d = new RectF();

    /* JADX INFO: renamed from: g */
    public final List<b> f2471g = new ArrayList();

    /* JADX INFO: renamed from: b.c.a.w.b.a$b */
    /* JADX INFO: compiled from: BaseStrokeContent.java */
    public static final class b {

        /* JADX INFO: renamed from: a */
        public final List<InterfaceC1537m> f2479a = new ArrayList();

        /* JADX INFO: renamed from: b */
        @Nullable
        public final C1543s f2480b;

        public b(C1543s c1543s, a aVar) {
            this.f2480b = c1543s;
        }
    }

    public AbstractC1525a(C1511j c1511j, AbstractC1603b abstractC1603b, Paint.Cap cap, Paint.Join join, float f, C1575d c1575d, C1573b c1573b, List<C1573b> list, C1573b c1573b2) {
        C1524a c1524a = new C1524a(1);
        this.f2473i = c1524a;
        this.f2469e = c1511j;
        this.f2470f = abstractC1603b;
        c1524a.setStyle(Paint.Style.STROKE);
        c1524a.setStrokeCap(cap);
        c1524a.setStrokeJoin(join);
        c1524a.setStrokeMiter(f);
        this.f2475k = c1575d.mo773a();
        this.f2474j = c1573b.mo773a();
        if (c1573b2 == null) {
            this.f2477m = null;
        } else {
            this.f2477m = c1573b2.mo773a();
        }
        this.f2476l = new ArrayList(list.size());
        this.f2472h = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.f2476l.add(list.get(i).mo773a());
        }
        abstractC1603b.m777e(this.f2475k);
        abstractC1603b.m777e(this.f2474j);
        for (int i2 = 0; i2 < this.f2476l.size(); i2++) {
            abstractC1603b.m777e(this.f2476l.get(i2));
        }
        AbstractC1544a<?, Float> abstractC1544a = this.f2477m;
        if (abstractC1544a != null) {
            abstractC1603b.m777e(abstractC1544a);
        }
        this.f2475k.f2596a.add(this);
        this.f2474j.f2596a.add(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.f2476l.get(i3).f2596a.add(this);
        }
        AbstractC1544a<?, Float> abstractC1544a2 = this.f2477m;
        if (abstractC1544a2 != null) {
            abstractC1544a2.f2596a.add(this);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2469e.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0052  */
    /* JADX WARN: Code duplicated, block: B:24:0x0056 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:25:0x0058  */
    /* JADX WARN: Code duplicated, block: B:38:0x0064 A[SYNTHETIC] */
    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        C1543s c1543s = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            InterfaceC1527c interfaceC1527c = list.get(size);
            if (interfaceC1527c instanceof C1543s) {
                C1543s c1543s2 = (C1543s) interfaceC1527c;
                if (c1543s2.f2592c == 2) {
                    c1543s = c1543s2;
                }
            }
        }
        if (c1543s != null) {
            c1543s.f2591b.add(this);
        }
        b bVar = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            InterfaceC1527c interfaceC1527c2 = list2.get(size2);
            if (interfaceC1527c2 instanceof C1543s) {
                C1543s c1543s3 = (C1543s) interfaceC1527c2;
                if (c1543s3.f2592c == 2) {
                    if (bVar != null) {
                        this.f2471g.add(bVar);
                    }
                    bVar = new b(c1543s3, null);
                    c1543s3.f2591b.add(this);
                } else if (!(interfaceC1527c2 instanceof InterfaceC1537m)) {
                    if (bVar == null) {
                        bVar = new b(c1543s, null);
                    }
                    bVar.f2479a.add((InterfaceC1537m) interfaceC1527c2);
                }
            } else if (!(interfaceC1527c2 instanceof InterfaceC1537m)) {
                if (bVar == null) {
                    bVar = new b(c1543s, null);
                }
                bVar.f2479a.add((InterfaceC1537m) interfaceC1527c2);
            }
        }
        if (bVar != null) {
            this.f2471g.add(bVar);
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
        this.f2466b.reset();
        for (int i = 0; i < this.f2471g.size(); i++) {
            b bVar = this.f2471g.get(i);
            for (int i2 = 0; i2 < bVar.f2479a.size(); i2++) {
                this.f2466b.addPath(bVar.f2479a.get(i2).getPath(), matrix);
            }
        }
        this.f2466b.computeBounds(this.f2468d, false);
        float fM739j = ((C1546c) this.f2474j).m739j();
        RectF rectF2 = this.f2468d;
        float f = fM739j / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.f2468d);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        C1500c.m663a("StrokeContent#getBounds");
    }

    /* JADX WARN: Code duplicated, block: B:69:0x01ff  */
    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        float f;
        float[] fArr = C1499g.f2312d;
        boolean z2 = false;
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 37394.73f;
        fArr[3] = 39575.234f;
        matrix.mapPoints(fArr);
        if (fArr[0] == fArr[2] || fArr[1] == fArr[3]) {
            C1500c.m663a("StrokeContent#draw");
            return;
        }
        C1548e c1548e = (C1548e) this.f2475k;
        float fM741j = (i / 255.0f) * c1548e.m741j(c1548e.m723a(), c1548e.m725c());
        float f2 = 100.0f;
        this.f2473i.setAlpha(C1498f.m653c((int) ((fM741j / 100.0f) * 255.0f), 0, 255));
        this.f2473i.setStrokeWidth(C1499g.m660d(matrix) * ((C1546c) this.f2474j).m739j());
        if (this.f2473i.getStrokeWidth() <= 0.0f) {
            C1500c.m663a("StrokeContent#draw");
            return;
        }
        float f3 = 1.0f;
        if (this.f2476l.isEmpty()) {
            C1500c.m663a("StrokeContent#applyDashPattern");
        } else {
            float fM660d = C1499g.m660d(matrix);
            for (int i2 = 0; i2 < this.f2476l.size(); i2++) {
                this.f2472h[i2] = this.f2476l.get(i2).mo727e().floatValue();
                if (i2 % 2 == 0) {
                    float[] fArr2 = this.f2472h;
                    if (fArr2[i2] < 1.0f) {
                        fArr2[i2] = 1.0f;
                    }
                } else {
                    float[] fArr3 = this.f2472h;
                    if (fArr3[i2] < 0.1f) {
                        fArr3[i2] = 0.1f;
                    }
                }
                float[] fArr4 = this.f2472h;
                fArr4[i2] = fArr4[i2] * fM660d;
            }
            AbstractC1544a<?, Float> abstractC1544a = this.f2477m;
            this.f2473i.setPathEffect(new DashPathEffect(this.f2472h, abstractC1544a == null ? 0.0f : abstractC1544a.mo727e().floatValue() * fM660d));
            C1500c.m663a("StrokeContent#applyDashPattern");
        }
        AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a2 = this.f2478n;
        if (abstractC1544a2 != null) {
            this.f2473i.setColorFilter(abstractC1544a2.mo727e());
        }
        int i3 = 0;
        while (i3 < this.f2471g.size()) {
            b bVar = this.f2471g.get(i3);
            C1543s c1543s = bVar.f2480b;
            if (c1543s == null) {
                this.f2466b.reset();
                for (int size = bVar.f2479a.size() - 1; size >= 0; size--) {
                    this.f2466b.addPath(bVar.f2479a.get(size).getPath(), matrix);
                }
                C1500c.m663a("StrokeContent#buildPath");
                canvas.drawPath(this.f2466b, this.f2473i);
                C1500c.m663a("StrokeContent#drawPath");
            } else if (c1543s == null) {
                C1500c.m663a("StrokeContent#applyTrimPath");
            } else {
                this.f2466b.reset();
                int size2 = bVar.f2479a.size();
                while (true) {
                    size2--;
                    if (size2 < 0) {
                        break;
                    } else {
                        this.f2466b.addPath(bVar.f2479a.get(size2).getPath(), matrix);
                    }
                }
                this.f2465a.setPath(this.f2466b, z2);
                float length = this.f2465a.getLength();
                while (this.f2465a.nextContour()) {
                    length += this.f2465a.getLength();
                }
                float fFloatValue = (bVar.f2480b.f2595f.mo727e().floatValue() * length) / 360.0f;
                float fFloatValue2 = ((bVar.f2480b.f2593d.mo727e().floatValue() * length) / f2) + fFloatValue;
                float fFloatValue3 = ((bVar.f2480b.f2594e.mo727e().floatValue() * length) / f2) + fFloatValue;
                int size3 = bVar.f2479a.size() - 1;
                float f4 = 0.0f;
                while (size3 >= 0) {
                    this.f2467c.set(bVar.f2479a.get(size3).getPath());
                    this.f2467c.transform(matrix);
                    this.f2465a.setPath(this.f2467c, z2);
                    float length2 = this.f2465a.getLength();
                    if (fFloatValue3 > length) {
                        float f5 = fFloatValue3 - length;
                        if (f5 >= f4 + length2 || f4 >= f5) {
                            f = f4 + length2;
                            if (f < fFloatValue2 && f4 <= fFloatValue3) {
                                if (f > fFloatValue3 || fFloatValue2 >= f4) {
                                    C1499g.m657a(this.f2467c, fFloatValue2 < f4 ? 0.0f : (fFloatValue2 - f4) / length2, fFloatValue3 > f ? 1.0f : (fFloatValue3 - f4) / length2, 0.0f);
                                    canvas.drawPath(this.f2467c, this.f2473i);
                                } else {
                                    canvas.drawPath(this.f2467c, this.f2473i);
                                }
                            }
                        } else {
                            C1499g.m657a(this.f2467c, fFloatValue2 > length ? (fFloatValue2 - length) / length2 : 0.0f, Math.min(f5 / length2, f3), 0.0f);
                            canvas.drawPath(this.f2467c, this.f2473i);
                        }
                    } else {
                        f = f4 + length2;
                        if (f < fFloatValue2) {
                        }
                    }
                    f4 += length2;
                    size3--;
                    z2 = false;
                    f3 = 1.0f;
                }
                C1500c.m663a("StrokeContent#applyTrimPath");
            }
            i3++;
            z2 = false;
            f2 = 100.0f;
            f3 = 1.0f;
        }
        C1500c.m663a("StrokeContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    @CallSuper
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        if (t == InterfaceC1516o.f2426d) {
            AbstractC1544a<?, Integer> abstractC1544a = this.f2475k;
            C1503c<Integer> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2437o) {
            AbstractC1544a<?, Float> abstractC1544a2 = this.f2474j;
            C1503c<Float> c1503c3 = abstractC1544a2.f2600e;
            abstractC1544a2.f2600e = c1503c;
        } else if (t == InterfaceC1516o.f2421C) {
            AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a3 = this.f2478n;
            if (abstractC1544a3 != null) {
                this.f2470f.f2856u.remove(abstractC1544a3);
            }
            if (c1503c == 0) {
                this.f2478n = null;
                return;
            }
            C1559p c1559p = new C1559p(c1503c, null);
            this.f2478n = c1559p;
            c1559p.f2596a.add(this);
            this.f2470f.m777e(this.f2478n);
        }
    }
}
