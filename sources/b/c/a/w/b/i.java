package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;

/* JADX INFO: compiled from: GradientStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class i extends a {
    public final String o;
    public final boolean p;
    public final LongSparseArray<LinearGradient> q;
    public final LongSparseArray<RadialGradient> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RectF f382s;
    public final int t;
    public final int u;
    public final b.c.a.w.c.a<b.c.a.y.l.c, b.c.a.y.l.c> v;
    public final b.c.a.w.c.a<PointF, PointF> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b.c.a.w.c.a<PointF, PointF> f383x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public b.c.a.w.c.p f384y;

    public i(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.e eVar) {
        super(jVar, bVar, b.c.a.y.b.k(eVar.h), b.c.a.y.b.l(eVar.i), eVar.j, eVar.d, eVar.g, eVar.k, eVar.l);
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.f382s = new RectF();
        this.o = eVar.a;
        this.t = eVar.f418b;
        this.p = eVar.m;
        this.u = (int) (jVar.k.b() / 32.0f);
        b.c.a.w.c.a<b.c.a.y.l.c, b.c.a.y.l.c> aVarA = eVar.c.a();
        this.v = aVarA;
        aVarA.a.add(this);
        bVar.e(aVarA);
        b.c.a.w.c.a<PointF, PointF> aVarA2 = eVar.e.a();
        this.w = aVarA2;
        aVarA2.a.add(this);
        bVar.e(aVarA2);
        b.c.a.w.c.a<PointF, PointF> aVarA3 = eVar.f.a();
        this.f383x = aVarA3;
        aVarA3.a.add(this);
        bVar.e(aVarA3);
    }

    public final int[] e(int[] iArr) {
        b.c.a.w.c.p pVar = this.f384y;
        if (pVar != null) {
            Integer[] numArr = (Integer[]) pVar.e();
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
    @Override // b.c.a.w.b.a, b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.p) {
            return;
        }
        d(this.f382s, matrix, false);
        if (this.t == 1) {
            long jH = h();
            radialGradient = this.q.get(jH);
            if (radialGradient == null) {
                PointF pointFE = this.w.e();
                PointF pointFE2 = this.f383x.e();
                b.c.a.y.l.c cVarE = this.v.e();
                radialGradient = new LinearGradient(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y, e(cVarE.f416b), cVarE.a, Shader$TileMode.CLAMP);
                this.q.put(jH, radialGradient);
            }
        } else {
            long jH2 = h();
            radialGradient = this.r.get(jH2);
            if (radialGradient == null) {
                PointF pointFE3 = this.w.e();
                PointF pointFE4 = this.f383x.e();
                b.c.a.y.l.c cVarE2 = this.v.e();
                int[] iArrE = e(cVarE2.f416b);
                float[] fArr = cVarE2.a;
                float f = pointFE3.x;
                float f2 = pointFE3.y;
                radialGradient = new RadialGradient(f, f2, (float) Math.hypot(pointFE4.x - f, pointFE4.y - f2), iArrE, fArr, Shader$TileMode.CLAMP);
                this.r.put(jH2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.i.setShader(radialGradient);
        super.f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.b.a, b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        super.g(t, cVar);
        if (t == b.c.a.o.D) {
            b.c.a.w.c.p pVar = this.f384y;
            if (pVar != null) {
                this.f.u.remove(pVar);
            }
            if (cVar == null) {
                this.f384y = null;
                return;
            }
            b.c.a.w.c.p pVar2 = new b.c.a.w.c.p(cVar, null);
            this.f384y = pVar2;
            pVar2.a.add(this);
            this.f.e(this.f384y);
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.o;
    }

    public final int h() {
        int iRound = Math.round(this.w.d * this.u);
        int iRound2 = Math.round(this.f383x.d * this.u);
        int iRound3 = Math.round(this.v.d * this.u);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
