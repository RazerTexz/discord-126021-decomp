package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader$TileMode;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: GradientFillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class h implements e, b.c.a.w.c.a$b, k {

    @NonNull
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f381b;
    public final b.c.a.y.m.b c;
    public final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    public final Path f;
    public final Paint g;
    public final RectF h;
    public final List<m> i;
    public final int j;
    public final b.c.a.w.c.a<b.c.a.y.l.c, b.c.a.y.l.c> k;
    public final b.c.a.w.c.a<Integer, Integer> l;
    public final b.c.a.w.c.a<PointF, PointF> m;
    public final b.c.a.w.c.a<PointF, PointF> n;

    @Nullable
    public b.c.a.w.c.a<ColorFilter, ColorFilter> o;

    @Nullable
    public b.c.a.w.c.p p;
    public final b.c.a.j q;
    public final int r;

    public h(b.c.a.j jVar, b.c.a.y.m.b bVar, b.c.a.y.l.d dVar) {
        Path path = new Path();
        this.f = path;
        this.g = new b.c.a.w.a(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.c = bVar;
        this.a = dVar.g;
        this.f381b = dVar.h;
        this.q = jVar;
        this.j = dVar.a;
        path.setFillType(dVar.f417b);
        this.r = (int) (jVar.k.b() / 32.0f);
        b.c.a.w.c.a<b.c.a.y.l.c, b.c.a.y.l.c> aVarA = dVar.c.a();
        this.k = aVarA;
        aVarA.a.add(this);
        bVar.e(aVarA);
        b.c.a.w.c.a<Integer, Integer> aVarA2 = dVar.d.a();
        this.l = aVarA2;
        aVarA2.a.add(this);
        bVar.e(aVarA2);
        b.c.a.w.c.a<PointF, PointF> aVarA3 = dVar.e.a();
        this.m = aVarA3;
        aVarA3.a.add(this);
        bVar.e(aVarA3);
        b.c.a.w.c.a<PointF, PointF> aVarA4 = dVar.f.a();
        this.n = aVarA4;
        aVarA4.a.add(this);
        bVar.e(aVarA4);
    }

    @Override // b.c.a.w.c.a$b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // b.c.a.w.b.c
    public void b(List<c> list, List<c> list2) {
        for (int i = 0; i < list2.size(); i++) {
            c cVar = list2.get(i);
            if (cVar instanceof m) {
                this.i.add((m) cVar);
            }
        }
    }

    @Override // b.c.a.y.g
    public void c(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2) {
        b.c.a.b0.f.f(fVar, i, list, fVar2, this);
    }

    @Override // b.c.a.w.b.e
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] e(int[] iArr) {
        b.c.a.w.c.p pVar = this.p;
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
    @Override // b.c.a.w.b.e
    public void f(Canvas canvas, Matrix matrix, int i) {
        RadialGradient radialGradient;
        if (this.f381b) {
            return;
        }
        this.f.reset();
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            this.f.addPath(this.i.get(i2).getPath(), matrix);
        }
        this.f.computeBounds(this.h, false);
        if (this.j == 1) {
            long jH = h();
            radialGradient = this.d.get(jH);
            if (radialGradient == null) {
                PointF pointFE = this.m.e();
                PointF pointFE2 = this.n.e();
                b.c.a.y.l.c cVarE = this.k.e();
                LinearGradient linearGradient = new LinearGradient(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y, e(cVarE.f416b), cVarE.a, Shader$TileMode.CLAMP);
                this.d.put(jH, linearGradient);
                radialGradient = linearGradient;
            }
        } else {
            long jH2 = h();
            radialGradient = this.e.get(jH2);
            if (radialGradient == null) {
                PointF pointFE3 = this.m.e();
                PointF pointFE4 = this.n.e();
                b.c.a.y.l.c cVarE2 = this.k.e();
                int[] iArrE = e(cVarE2.f416b);
                float[] fArr = cVarE2.a;
                float f = pointFE3.x;
                float f2 = pointFE3.y;
                float fHypot = (float) Math.hypot(pointFE4.x - f, pointFE4.y - f2);
                radialGradient = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrE, fArr, Shader$TileMode.CLAMP);
                this.e.put(jH2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.g.setShader(radialGradient);
        b.c.a.w.c.a<ColorFilter, ColorFilter> aVar = this.o;
        if (aVar != null) {
            this.g.setColorFilter(aVar.e());
        }
        this.g.setAlpha(b.c.a.b0.f.c((int) ((((i / 255.0f) * this.l.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        b.c.a.c.a("GradientFillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.g
    public <T> void g(T t, @Nullable b.c.a.c0.c<T> cVar) {
        if (t == b.c.a.o.d) {
            b.c.a.w.c.a<Integer, Integer> aVar = this.l;
            b.c.a.c0.c<Integer> cVar2 = aVar.e;
            aVar.e = cVar;
            return;
        }
        if (t == b.c.a.o.C) {
            b.c.a.w.c.a<ColorFilter, ColorFilter> aVar2 = this.o;
            if (aVar2 != null) {
                this.c.u.remove(aVar2);
            }
            if (cVar == 0) {
                this.o = null;
                return;
            }
            b.c.a.w.c.p pVar = new b.c.a.w.c.p(cVar, null);
            this.o = pVar;
            pVar.a.add(this);
            this.c.e(this.o);
            return;
        }
        if (t == b.c.a.o.D) {
            b.c.a.w.c.p pVar2 = this.p;
            if (pVar2 != null) {
                this.c.u.remove(pVar2);
            }
            if (cVar == 0) {
                this.p = null;
                return;
            }
            b.c.a.w.c.p pVar3 = new b.c.a.w.c.p(cVar, null);
            this.p = pVar3;
            pVar3.a.add(this);
            this.c.e(this.p);
        }
    }

    @Override // b.c.a.w.b.c
    public String getName() {
        return this.a;
    }

    public final int h() {
        int iRound = Math.round(this.m.d * this.r);
        int iRound2 = Math.round(this.n.d * this.r);
        int iRound3 = Math.round(this.k.d * this.r);
        int i = iRound != 0 ? 527 * iRound : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }
}
