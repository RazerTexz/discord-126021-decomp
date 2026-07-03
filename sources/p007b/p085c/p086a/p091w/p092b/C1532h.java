package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;
import p007b.p085c.p086a.C1500c;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.C1524a;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p085c.p086a.p095y.p097l.C1588c;
import p007b.p085c.p086a.p095y.p097l.C1589d;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.h */
/* JADX INFO: compiled from: GradientFillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1532h implements InterfaceC1529e, AbstractC1544a.b, InterfaceC1535k {

    /* JADX INFO: renamed from: a */
    @NonNull
    public final String f2511a;

    /* JADX INFO: renamed from: b */
    public final boolean f2512b;

    /* JADX INFO: renamed from: c */
    public final AbstractC1603b f2513c;

    /* JADX INFO: renamed from: d */
    public final LongSparseArray<LinearGradient> f2514d = new LongSparseArray<>();

    /* JADX INFO: renamed from: e */
    public final LongSparseArray<RadialGradient> f2515e = new LongSparseArray<>();

    /* JADX INFO: renamed from: f */
    public final Path f2516f;

    /* JADX INFO: renamed from: g */
    public final Paint f2517g;

    /* JADX INFO: renamed from: h */
    public final RectF f2518h;

    /* JADX INFO: renamed from: i */
    public final List<InterfaceC1537m> f2519i;

    /* JADX INFO: renamed from: j */
    public final int f2520j;

    /* JADX INFO: renamed from: k */
    public final AbstractC1544a<C1588c, C1588c> f2521k;

    /* JADX INFO: renamed from: l */
    public final AbstractC1544a<Integer, Integer> f2522l;

    /* JADX INFO: renamed from: m */
    public final AbstractC1544a<PointF, PointF> f2523m;

    /* JADX INFO: renamed from: n */
    public final AbstractC1544a<PointF, PointF> f2524n;

    /* JADX INFO: renamed from: o */
    @Nullable
    public AbstractC1544a<ColorFilter, ColorFilter> f2525o;

    /* JADX INFO: renamed from: p */
    @Nullable
    public C1559p f2526p;

    /* JADX INFO: renamed from: q */
    public final C1511j f2527q;

    /* JADX INFO: renamed from: r */
    public final int f2528r;

    public C1532h(C1511j c1511j, AbstractC1603b abstractC1603b, C1589d c1589d) {
        Path path = new Path();
        this.f2516f = path;
        this.f2517g = new C1524a(1);
        this.f2518h = new RectF();
        this.f2519i = new ArrayList();
        this.f2513c = abstractC1603b;
        this.f2511a = c1589d.f2752g;
        this.f2512b = c1589d.f2753h;
        this.f2527q = c1511j;
        this.f2520j = c1589d.f2746a;
        path.setFillType(c1589d.f2747b);
        this.f2528r = (int) (c1511j.f2370k.m670b() / 32.0f);
        AbstractC1544a<C1588c, C1588c> abstractC1544aMo773a = c1589d.f2748c.mo773a();
        this.f2521k = abstractC1544aMo773a;
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a);
        AbstractC1544a<Integer, Integer> abstractC1544aMo773a2 = c1589d.f2749d.mo773a();
        this.f2522l = abstractC1544aMo773a2;
        abstractC1544aMo773a2.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a2);
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a3 = c1589d.f2750e.mo773a();
        this.f2523m = abstractC1544aMo773a3;
        abstractC1544aMo773a3.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a3);
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a4 = c1589d.f2751f.mo773a();
        this.f2524n = abstractC1544aMo773a4;
        abstractC1544aMo773a4.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a4);
    }

    @Override // p007b.p085c.p086a.p091w.p093c.AbstractC1544a.b
    /* JADX INFO: renamed from: a */
    public void mo709a() {
        this.f2527q.invalidateSelf();
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    /* JADX INFO: renamed from: b */
    public void mo710b(List<InterfaceC1527c> list, List<InterfaceC1527c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            InterfaceC1527c interfaceC1527c = list2.get(i);
            if (interfaceC1527c instanceof InterfaceC1537m) {
                this.f2519i.add((InterfaceC1537m) interfaceC1527c);
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
        this.f2516f.reset();
        for (int i = 0; i < this.f2519i.size(); i++) {
            this.f2516f.addPath(this.f2519i.get(i).getPath(), matrix);
        }
        this.f2516f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    /* JADX INFO: renamed from: e */
    public final int[] m717e(int[] iArr) {
        C1559p c1559p = this.f2526p;
        if (c1559p != null) {
            Integer[] numArr = (Integer[]) c1559p.mo727e();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.f2512b) {
            return;
        }
        this.f2516f.reset();
        for (int i2 = 0; i2 < this.f2519i.size(); i2++) {
            this.f2516f.addPath(this.f2519i.get(i2).getPath(), matrix);
        }
        this.f2516f.computeBounds(this.f2518h, false);
        if (this.f2520j == 1) {
            long jM718h = m718h();
            radialGradient = this.f2514d.get(jM718h);
            if (radialGradient == null) {
                PointF pointFMo727e = this.f2523m.mo727e();
                PointF pointFMo727e2 = this.f2524n.mo727e();
                C1588c c1588cMo727e = this.f2521k.mo727e();
                LinearGradient linearGradient = new LinearGradient(pointFMo727e.x, pointFMo727e.y, pointFMo727e2.x, pointFMo727e2.y, m717e(c1588cMo727e.f2745b), c1588cMo727e.f2744a, Shader.TileMode.CLAMP);
                this.f2514d.put(jM718h, linearGradient);
                radialGradient = linearGradient;
            }
        } else {
            long jM718h2 = m718h();
            radialGradient = this.f2515e.get(jM718h2);
            if (radialGradient == null) {
                PointF pointFMo727e3 = this.f2523m.mo727e();
                PointF pointFMo727e4 = this.f2524n.mo727e();
                C1588c c1588cMo727e2 = this.f2521k.mo727e();
                int[] iArrM717e = m717e(c1588cMo727e2.f2745b);
                float[] fArr = c1588cMo727e2.f2744a;
                float f = pointFMo727e3.x;
                float f2 = pointFMo727e3.y;
                float fHypot = (float) Math.hypot(pointFMo727e4.x - f, pointFMo727e4.y - f2);
                radialGradient = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrM717e, fArr, Shader.TileMode.CLAMP);
                this.f2515e.put(jM718h2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.f2517g.setShader(radialGradient);
        AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a = this.f2525o;
        if (abstractC1544a != null) {
            this.f2517g.setColorFilter(abstractC1544a.mo727e());
        }
        this.f2517g.setAlpha(C1498f.m653c((int) ((((i / 255.0f) * this.f2522l.mo727e().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f2516f, this.f2517g);
        C1500c.m663a("GradientFillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        if (t == InterfaceC1516o.f2426d) {
            AbstractC1544a<Integer, Integer> abstractC1544a = this.f2522l;
            C1503c<Integer> c1503c2 = abstractC1544a.f2600e;
            abstractC1544a.f2600e = c1503c;
            return;
        }
        if (t == InterfaceC1516o.f2421C) {
            AbstractC1544a<ColorFilter, ColorFilter> abstractC1544a2 = this.f2525o;
            if (abstractC1544a2 != null) {
                this.f2513c.f2856u.remove(abstractC1544a2);
            }
            if (c1503c == 0) {
                this.f2525o = null;
                return;
            }
            C1559p c1559p = new C1559p(c1503c, null);
            this.f2525o = c1559p;
            c1559p.f2596a.add(this);
            this.f2513c.m777e(this.f2525o);
            return;
        }
        if (t == InterfaceC1516o.f2422D) {
            C1559p c1559p2 = this.f2526p;
            if (c1559p2 != null) {
                this.f2513c.f2856u.remove(c1559p2);
            }
            if (c1503c == 0) {
                this.f2526p = null;
                return;
            }
            C1559p c1559p3 = new C1559p(c1503c, null);
            this.f2526p = c1559p3;
            c1559p3.f2596a.add(this);
            this.f2513c.m777e(this.f2526p);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2511a;
    }

    /* JADX INFO: renamed from: h */
    public final int m718h() {
        int iRound = Math.round(this.f2523m.f2599d * this.f2528r);
        int iRound2 = Math.round(this.f2524n.f2599d * this.f2528r);
        int iRound3 = Math.round(this.f2521k.f2599d * this.f2528r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
