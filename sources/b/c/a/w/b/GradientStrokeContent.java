package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.y.l.GradientColor;
import b.c.a.y.l.GradientStroke;
import b.c.a.y.m.BaseLayer2;

/* JADX INFO: renamed from: b.c.a.w.b.i, reason: use source file name */
/* JADX INFO: compiled from: GradientStrokeContent.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientStrokeContent extends BaseStrokeContent {
    public final String o;
    public final boolean p;
    public final LongSparseArray<LinearGradient> q;
    public final LongSparseArray<RadialGradient> r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final RectF f382s;
    public final int t;
    public final int u;
    public final BaseKeyframeAnimation<GradientColor, GradientColor> v;
    public final BaseKeyframeAnimation<PointF, PointF> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final BaseKeyframeAnimation<PointF, PointF> f383x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    @Nullable
    public ValueCallbackKeyframeAnimation f384y;

    public GradientStrokeContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, GradientStroke gradientStroke) {
        super(lottieDrawable, baseLayer2, b.c.a.y.b.k(gradientStroke.h), b.c.a.y.b.l(gradientStroke.i), gradientStroke.j, gradientStroke.d, gradientStroke.g, gradientStroke.k, gradientStroke.l);
        this.q = new LongSparseArray<>();
        this.r = new LongSparseArray<>();
        this.f382s = new RectF();
        this.o = gradientStroke.a;
        this.t = gradientStroke.f418b;
        this.p = gradientStroke.m;
        this.u = (int) (lottieDrawable.k.b() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimationA = gradientStroke.c.a();
        this.v = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA2 = gradientStroke.e.a();
        this.w = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA3 = gradientStroke.f.a();
        this.f383x = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA3);
    }

    public final int[] e(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f384y;
        if (valueCallbackKeyframeAnimation != null) {
            Integer[] numArr = (Integer[]) valueCallbackKeyframeAnimation.e();
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
    @Override // b.c.a.w.b.BaseStrokeContent, b.c.a.w.b.DrawingContent
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
                GradientColor gradientColorE = this.v.e();
                radialGradient = new LinearGradient(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y, e(gradientColorE.f416b), gradientColorE.a, Shader.TileMode.CLAMP);
                this.q.put(jH, radialGradient);
            }
        } else {
            long jH2 = h();
            radialGradient = this.r.get(jH2);
            if (radialGradient == null) {
                PointF pointFE3 = this.w.e();
                PointF pointFE4 = this.f383x.e();
                GradientColor gradientColorE2 = this.v.e();
                int[] iArrE = e(gradientColorE2.f416b);
                float[] fArr = gradientColorE2.a;
                float f = pointFE3.x;
                float f2 = pointFE3.y;
                radialGradient = new RadialGradient(f, f2, (float) Math.hypot(pointFE4.x - f, pointFE4.y - f2), iArrE, fArr, Shader.TileMode.CLAMP);
                this.r.put(jH2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.i.setShader(radialGradient);
        super.f(canvas, matrix, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.w.b.BaseStrokeContent, b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        super.g(t, lottieValueCallback);
        if (t == LottieProperty.D) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.f384y;
            if (valueCallbackKeyframeAnimation != null) {
                this.f.u.remove(valueCallbackKeyframeAnimation);
            }
            if (lottieValueCallback == null) {
                this.f384y = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.f384y = valueCallbackKeyframeAnimation2;
            valueCallbackKeyframeAnimation2.a.add(this);
            this.f.e(this.f384y);
        }
    }

    @Override // b.c.a.w.b.Content2
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
