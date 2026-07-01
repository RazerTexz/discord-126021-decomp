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
import android.graphics.Shader;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.LongSparseArray;
import b.c.a.L;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.LPaint;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.ValueCallbackKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.l.GradientColor;
import b.c.a.y.l.GradientFill;
import b.c.a.y.m.BaseLayer2;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.w.b.h, reason: use source file name */
/* JADX INFO: compiled from: GradientFillContent.java */
/* JADX INFO: loaded from: classes.dex */
public class GradientFillContent implements DrawingContent, BaseKeyframeAnimation.b, KeyPathElementContent {

    @NonNull
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f381b;
    public final BaseLayer2 c;
    public final LongSparseArray<LinearGradient> d = new LongSparseArray<>();
    public final LongSparseArray<RadialGradient> e = new LongSparseArray<>();
    public final Path f;
    public final Paint g;
    public final RectF h;
    public final List<PathContent> i;
    public final int j;
    public final BaseKeyframeAnimation<GradientColor, GradientColor> k;
    public final BaseKeyframeAnimation<Integer, Integer> l;
    public final BaseKeyframeAnimation<PointF, PointF> m;
    public final BaseKeyframeAnimation<PointF, PointF> n;

    @Nullable
    public BaseKeyframeAnimation<ColorFilter, ColorFilter> o;

    @Nullable
    public ValueCallbackKeyframeAnimation p;
    public final LottieDrawable q;
    public final int r;

    public GradientFillContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, GradientFill gradientFill) {
        Path path = new Path();
        this.f = path;
        this.g = new LPaint(1);
        this.h = new RectF();
        this.i = new ArrayList();
        this.c = baseLayer2;
        this.a = gradientFill.g;
        this.f381b = gradientFill.h;
        this.q = lottieDrawable;
        this.j = gradientFill.a;
        path.setFillType(gradientFill.f417b);
        this.r = (int) (lottieDrawable.k.b() / 32.0f);
        BaseKeyframeAnimation<GradientColor, GradientColor> baseKeyframeAnimationA = gradientFill.c.a();
        this.k = baseKeyframeAnimationA;
        baseKeyframeAnimationA.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA);
        BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimationA2 = gradientFill.d.a();
        this.l = baseKeyframeAnimationA2;
        baseKeyframeAnimationA2.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA2);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA3 = gradientFill.e.a();
        this.m = baseKeyframeAnimationA3;
        baseKeyframeAnimationA3.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA3);
        BaseKeyframeAnimation<PointF, PointF> baseKeyframeAnimationA4 = gradientFill.f.a();
        this.n = baseKeyframeAnimationA4;
        baseKeyframeAnimationA4.a.add(this);
        baseLayer2.e(baseKeyframeAnimationA4);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.q.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        for (int i = 0; i < list2.size(); i++) {
            Content2 content2 = list2.get(i);
            if (content2 instanceof PathContent) {
                this.i.add((PathContent) content2);
            }
        }
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i, list, keyPath2, this);
    }

    @Override // b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.f.reset();
        for (int i = 0; i < this.i.size(); i++) {
            this.f.addPath(this.i.get(i).getPath(), matrix);
        }
        this.f.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    public final int[] e(int[] iArr) {
        ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = this.p;
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
    @Override // b.c.a.w.b.DrawingContent
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
                GradientColor gradientColorE = this.k.e();
                LinearGradient linearGradient = new LinearGradient(pointFE.x, pointFE.y, pointFE2.x, pointFE2.y, e(gradientColorE.f416b), gradientColorE.a, Shader.TileMode.CLAMP);
                this.d.put(jH, linearGradient);
                radialGradient = linearGradient;
            }
        } else {
            long jH2 = h();
            radialGradient = this.e.get(jH2);
            if (radialGradient == null) {
                PointF pointFE3 = this.m.e();
                PointF pointFE4 = this.n.e();
                GradientColor gradientColorE2 = this.k.e();
                int[] iArrE = e(gradientColorE2.f416b);
                float[] fArr = gradientColorE2.a;
                float f = pointFE3.x;
                float f2 = pointFE3.y;
                float fHypot = (float) Math.hypot(pointFE4.x - f, pointFE4.y - f2);
                radialGradient = new RadialGradient(f, f2, fHypot <= 0.0f ? 0.001f : fHypot, iArrE, fArr, Shader.TileMode.CLAMP);
                this.e.put(jH2, radialGradient);
            }
        }
        radialGradient.setLocalMatrix(matrix);
        this.g.setShader(radialGradient);
        BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation = this.o;
        if (baseKeyframeAnimation != null) {
            this.g.setColorFilter(baseKeyframeAnimation.e());
        }
        this.g.setAlpha(MiscUtils.c((int) ((((i / 255.0f) * this.l.e().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.f, this.g);
        L.a("GradientFillContent#draw");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (t == LottieProperty.d) {
            BaseKeyframeAnimation<Integer, Integer> baseKeyframeAnimation = this.l;
            LottieValueCallback<Integer> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
            return;
        }
        if (t == LottieProperty.C) {
            BaseKeyframeAnimation<ColorFilter, ColorFilter> baseKeyframeAnimation2 = this.o;
            if (baseKeyframeAnimation2 != null) {
                this.c.u.remove(baseKeyframeAnimation2);
            }
            if (lottieValueCallback == 0) {
                this.o = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.o = valueCallbackKeyframeAnimation;
            valueCallbackKeyframeAnimation.a.add(this);
            this.c.e(this.o);
            return;
        }
        if (t == LottieProperty.D) {
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation2 = this.p;
            if (valueCallbackKeyframeAnimation2 != null) {
                this.c.u.remove(valueCallbackKeyframeAnimation2);
            }
            if (lottieValueCallback == 0) {
                this.p = null;
                return;
            }
            ValueCallbackKeyframeAnimation valueCallbackKeyframeAnimation3 = new ValueCallbackKeyframeAnimation(lottieValueCallback, null);
            this.p = valueCallbackKeyframeAnimation3;
            valueCallbackKeyframeAnimation3.a.add(this);
            this.c.e(this.p);
        }
    }

    @Override // b.c.a.w.b.Content2
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
