package b.c.a.w.b;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import androidx.annotation.Nullable;
import b.c.a.LottieDrawable;
import b.c.a.LottieProperty;
import b.c.a.b0.MiscUtils;
import b.c.a.c0.LottieValueCallback;
import b.c.a.w.c.BaseKeyframeAnimation;
import b.c.a.w.c.TransformKeyframeAnimation;
import b.c.a.y.KeyPath;
import b.c.a.y.k.AnimatableTransform;
import b.c.a.y.l.Repeater;
import b.c.a.y.m.BaseLayer2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;

/* JADX INFO: renamed from: b.c.a.w.b.p, reason: use source file name */
/* JADX INFO: compiled from: RepeaterContent.java */
/* JADX INFO: loaded from: classes.dex */
public class RepeaterContent implements DrawingContent, PathContent, GreedyContent, BaseKeyframeAnimation.b, KeyPathElementContent {
    public final Matrix a = new Matrix();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Path f388b = new Path();
    public final LottieDrawable c;
    public final BaseLayer2 d;
    public final String e;
    public final boolean f;
    public final BaseKeyframeAnimation<Float, Float> g;
    public final BaseKeyframeAnimation<Float, Float> h;
    public final TransformKeyframeAnimation i;
    public ContentGroup j;

    public RepeaterContent(LottieDrawable lottieDrawable, BaseLayer2 baseLayer2, Repeater repeater) {
        this.c = lottieDrawable;
        this.d = baseLayer2;
        this.e = repeater.a;
        this.f = repeater.e;
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA = repeater.f423b.a();
        this.g = baseKeyframeAnimationA;
        baseLayer2.e(baseKeyframeAnimationA);
        baseKeyframeAnimationA.a.add(this);
        BaseKeyframeAnimation<Float, Float> baseKeyframeAnimationA2 = repeater.c.a();
        this.h = baseKeyframeAnimationA2;
        baseLayer2.e(baseKeyframeAnimationA2);
        baseKeyframeAnimationA2.a.add(this);
        AnimatableTransform animatableTransform = repeater.d;
        Objects.requireNonNull(animatableTransform);
        TransformKeyframeAnimation transformKeyframeAnimation = new TransformKeyframeAnimation(animatableTransform);
        this.i = transformKeyframeAnimation;
        transformKeyframeAnimation.a(baseLayer2);
        transformKeyframeAnimation.b(this);
    }

    @Override // b.c.a.w.c.BaseKeyframeAnimation.b
    public void a() {
        this.c.invalidateSelf();
    }

    @Override // b.c.a.w.b.Content2
    public void b(List<Content2> list, List<Content2> list2) {
        this.j.b(list, list2);
    }

    @Override // b.c.a.y.KeyPathElement
    public void c(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2) {
        MiscUtils.f(keyPath, i, list, keyPath2, this);
    }

    @Override // b.c.a.w.b.DrawingContent
    public void d(RectF rectF, Matrix matrix, boolean z2) {
        this.j.d(rectF, matrix, z2);
    }

    @Override // b.c.a.w.b.GreedyContent
    public void e(ListIterator<Content2> listIterator) {
        if (this.j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.j = new ContentGroup(this.c, this.d, "Repeater", this.f, arrayList, null);
    }

    @Override // b.c.a.w.b.DrawingContent
    public void f(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.g.e().floatValue();
        float fFloatValue2 = this.h.e().floatValue();
        float fFloatValue3 = this.i.m.e().floatValue() / 100.0f;
        float fFloatValue4 = this.i.n.e().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.a.set(matrix);
            float f = i2;
            this.a.preConcat(this.i.f(f + fFloatValue2));
            this.j.f(canvas, this.a, (int) (MiscUtils.e(fFloatValue3, fFloatValue4, f / fFloatValue) * i));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // b.c.a.y.KeyPathElement
    public <T> void g(T t, @Nullable LottieValueCallback<T> lottieValueCallback) {
        if (this.i.c(t, lottieValueCallback)) {
            return;
        }
        if (t == LottieProperty.q) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation = this.g;
            LottieValueCallback<Float> lottieValueCallback2 = baseKeyframeAnimation.e;
            baseKeyframeAnimation.e = lottieValueCallback;
        } else if (t == LottieProperty.r) {
            BaseKeyframeAnimation<Float, Float> baseKeyframeAnimation2 = this.h;
            LottieValueCallback<Float> lottieValueCallback3 = baseKeyframeAnimation2.e;
            baseKeyframeAnimation2.e = lottieValueCallback;
        }
    }

    @Override // b.c.a.w.b.Content2
    public String getName() {
        return this.e;
    }

    @Override // b.c.a.w.b.PathContent
    public Path getPath() {
        Path path = this.j.getPath();
        this.f388b.reset();
        float fFloatValue = this.g.e().floatValue();
        float fFloatValue2 = this.h.e().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.a.set(this.i.f(i + fFloatValue2));
            this.f388b.addPath(path, this.a);
        }
        return this.f388b;
    }
}
