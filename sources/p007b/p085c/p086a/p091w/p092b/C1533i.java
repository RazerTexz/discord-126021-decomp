package p007b.p085c.p086a.p091w.p092b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import p007b.p085c.p086a.C1511j;
import p007b.p085c.p086a.InterfaceC1516o;
import p007b.p085c.p086a.p090c0.C1503c;
import p007b.p085c.p086a.p091w.p093c.AbstractC1544a;
import p007b.p085c.p086a.p091w.p093c.C1559p;
import p007b.p085c.p086a.p095y.C1563b;
import p007b.p085c.p086a.p095y.p097l.C1588c;
import p007b.p085c.p086a.p095y.p097l.C1590e;
import p007b.p085c.p086a.p095y.p098m.AbstractC1603b;

/* JADX INFO: renamed from: b.c.a.w.b.i */
/* JADX INFO: compiled from: GradientStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class C1533i extends AbstractC1525a {

    /* JADX INFO: renamed from: o */
    public final String f2529o;

    /* JADX INFO: renamed from: p */
    public final boolean f2530p;

    /* JADX INFO: renamed from: q */
    public final LongSparseArray<LinearGradient> f2531q;

    /* JADX INFO: renamed from: r */
    public final LongSparseArray<RadialGradient> f2532r;

    /* JADX INFO: renamed from: s */
    public final RectF f2533s;

    /* JADX INFO: renamed from: t */
    public final int f2534t;

    /* JADX INFO: renamed from: u */
    public final int f2535u;

    /* JADX INFO: renamed from: v */
    public final AbstractC1544a<C1588c, C1588c> f2536v;

    /* JADX INFO: renamed from: w */
    public final AbstractC1544a<PointF, PointF> f2537w;

    /* JADX INFO: renamed from: x */
    public final AbstractC1544a<PointF, PointF> f2538x;

    /* JADX INFO: renamed from: y */
    @Nullable
    public C1559p f2539y;

    public C1533i(C1511j c1511j, AbstractC1603b abstractC1603b, C1590e c1590e) {
        super(c1511j, abstractC1603b, C1563b.m761k(c1590e.f2761h), C1563b.m762l(c1590e.f2762i), c1590e.f2763j, c1590e.f2757d, c1590e.f2760g, c1590e.f2764k, c1590e.f2765l);
        this.f2531q = new LongSparseArray<>();
        this.f2532r = new LongSparseArray<>();
        this.f2533s = new RectF();
        this.f2529o = c1590e.f2754a;
        this.f2534t = c1590e.f2755b;
        this.f2530p = c1590e.f2766m;
        this.f2535u = (int) (c1511j.f2370k.m670b() / 32.0f);
        AbstractC1544a<C1588c, C1588c> abstractC1544aMo773a = c1590e.f2756c.mo773a();
        this.f2536v = abstractC1544aMo773a;
        abstractC1544aMo773a.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a);
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a2 = c1590e.f2758e.mo773a();
        this.f2537w = abstractC1544aMo773a2;
        abstractC1544aMo773a2.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a2);
        AbstractC1544a<PointF, PointF> abstractC1544aMo773a3 = c1590e.f2759f.mo773a();
        this.f2538x = abstractC1544aMo773a3;
        abstractC1544aMo773a3.f2596a.add(this);
        abstractC1603b.m777e(abstractC1544aMo773a3);
    }

    /* JADX INFO: renamed from: e */
    public final int[] m719e(int[] iArr) {
        C1559p c1559p = this.f2539y;
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
    @Override // p007b.p085c.p086a.p091w.p092b.AbstractC1525a, p007b.p085c.p086a.p091w.p092b.InterfaceC1529e
    /* JADX INFO: renamed from: f */
    public void mo713f(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.f2530p) {
            return;
        }
        mo712d(this.f2533s, matrix, false);
        if (this.f2534t == 1) {
            long jM720h = m720h();
            radialGradient = this.f2531q.get(jM720h);
            if (radialGradient == null) {
                PointF pointFMo727e = this.f2537w.mo727e();
                PointF pointFMo727e2 = this.f2538x.mo727e();
                C1588c c1588cMo727e = this.f2536v.mo727e();
                radialGradient = new LinearGradient(pointFMo727e.x, pointFMo727e.y, pointFMo727e2.x, pointFMo727e2.y, m719e(c1588cMo727e.f2745b), c1588cMo727e.f2744a, Shader.TileMode.CLAMP);
                this.f2531q.put(jM720h, radialGradient);
            }
        } else {
            long jM720h2 = m720h();
            radialGradient = this.f2532r.get(jM720h2);
            if (radialGradient == null) {
                PointF pointFMo727e3 = this.f2537w.mo727e();
                PointF pointFMo727e4 = this.f2538x.mo727e();
                C1588c c1588cMo727e2 = this.f2536v.mo727e();
                int[] iArrM719e = m719e(c1588cMo727e2.f2745b);
                float[] fArr = c1588cMo727e2.f2744a;
                float f = pointFMo727e3.x;
                float f2 = pointFMo727e3.y;
                radialGradient = new RadialGradient(f, f2, (float) Math.hypot(pointFMo727e4.x - f, pointFMo727e4.y - f2), iArrM719e, fArr, Shader.TileMode.CLAMP);
                this.f2532r.put(jM720h2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.f2473i.setShader(radialGradient);
        super.mo713f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p007b.p085c.p086a.p091w.p092b.AbstractC1525a, p007b.p085c.p086a.p095y.InterfaceC1568g
    /* JADX INFO: renamed from: g */
    public <T> void mo714g(T t, @Nullable C1503c<T> c1503c) {
        super.mo714g(t, c1503c);
        if (t == InterfaceC1516o.f2422D) {
            C1559p c1559p = this.f2539y;
            if (c1559p != null) {
                this.f2470f.f2856u.remove(c1559p);
            }
            if (c1503c == null) {
                this.f2539y = null;
                return;
            }
            C1559p c1559p2 = new C1559p(c1503c, null);
            this.f2539y = c1559p2;
            c1559p2.f2596a.add(this);
            this.f2470f.m777e(this.f2539y);
        }
    }

    @Override // p007b.p085c.p086a.p091w.p092b.InterfaceC1527c
    public String getName() {
        return this.f2529o;
    }

    /* JADX INFO: renamed from: h */
    public final int m720h() {
        int iRound = Math.round(this.f2537w.f2599d * this.f2535u);
        int iRound2 = Math.round(this.f2538x.f2599d * this.f2535u);
        int iRound3 = Math.round(this.f2536v.f2599d * this.f2535u);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
