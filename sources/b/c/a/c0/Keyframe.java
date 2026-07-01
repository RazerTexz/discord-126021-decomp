package b.c.a.c0;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
import b.c.a.LottieComposition;
import b.d.b.a.outline;

/* JADX INFO: renamed from: b.c.a.c0.a, reason: use source file name */
/* JADX INFO: compiled from: Keyframe.java */
/* JADX INFO: loaded from: classes.dex */
public class Keyframe<T> {

    @Nullable
    public final LottieComposition a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final T f347b;

    @Nullable
    public T c;

    @Nullable
    public final Interpolator d;
    public final float e;

    @Nullable
    public Float f;
    public float g;
    public float h;
    public int i;
    public int j;
    public float k;
    public float l;
    public PointF m;
    public PointF n;

    public Keyframe(LottieComposition lottieComposition, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.g = -3987645.8f;
        this.h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = lottieComposition;
        this.f347b = t;
        this.c = t2;
        this.d = interpolator;
        this.e = f;
        this.f = f2;
    }

    public boolean a(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= c() && f < b();
    }

    public float b() {
        if (this.a == null) {
            return 1.0f;
        }
        if (this.l == Float.MIN_VALUE) {
            if (this.f == null) {
                this.l = 1.0f;
            } else {
                this.l = ((this.f.floatValue() - this.e) / this.a.c()) + c();
            }
        }
        return this.l;
    }

    public float c() {
        LottieComposition lottieComposition = this.a;
        if (lottieComposition == null) {
            return 0.0f;
        }
        if (this.k == Float.MIN_VALUE) {
            this.k = (this.e - lottieComposition.k) / lottieComposition.c();
        }
        return this.k;
    }

    public boolean d() {
        return this.d == null;
    }

    public String toString() {
        StringBuilder sbU = outline.U("Keyframe{startValue=");
        sbU.append(this.f347b);
        sbU.append(", endValue=");
        sbU.append(this.c);
        sbU.append(", startFrame=");
        sbU.append(this.e);
        sbU.append(", endFrame=");
        sbU.append(this.f);
        sbU.append(", interpolator=");
        sbU.append(this.d);
        sbU.append('}');
        return sbU.toString();
    }

    public Keyframe(T t) {
        this.g = -3987645.8f;
        this.h = -3987645.8f;
        this.i = 784923401;
        this.j = 784923401;
        this.k = Float.MIN_VALUE;
        this.l = Float.MIN_VALUE;
        this.m = null;
        this.n = null;
        this.a = null;
        this.f347b = t;
        this.c = t;
        this.d = null;
        this.e = Float.MIN_VALUE;
        this.f = Float.valueOf(Float.MAX_VALUE);
    }
}
