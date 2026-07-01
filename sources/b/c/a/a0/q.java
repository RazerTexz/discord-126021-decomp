package b.c.a.a0;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import b.c.a.a0.i0.c$a;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: KeyframeParser.java */
/* JADX INFO: loaded from: classes.dex */
public class q {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f341b;
    public static final Interpolator a = new LinearInterpolator();
    public static c$a c = c$a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    public static <T> b.c.a.c0.a<T> a(b.c.a.a0.i0.c cVar, b.c.a.d dVar, float f, h0<T> h0Var, boolean z2) throws IOException {
        Interpolator interpolator;
        T t;
        WeakReference<Interpolator> weakReference;
        Interpolator interpolatorCreate;
        if (!z2) {
            return new b.c.a.c0.a<>(h0Var.a(cVar, f));
        }
        cVar.b();
        int i = 1;
        PointF pointFB = null;
        PointF pointFB2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFB3 = null;
        PointF pointFB4 = null;
        boolean z3 = false;
        float fN = 0.0f;
        while (cVar.e()) {
            switch (cVar.y(c)) {
                case 0:
                    fN = (float) cVar.n();
                    break;
                case 1:
                    tA2 = h0Var.a(cVar, f);
                    continue;
                case 2:
                    tA = h0Var.a(cVar, f);
                    continue;
                case 3:
                    pointFB = p.b(cVar, f);
                    continue;
                case 4:
                    pointFB2 = p.b(cVar, f);
                    continue;
                case 5:
                    if (cVar.q() == i) {
                        z3 = true;
                    } else {
                        z3 = false;
                        continue;
                    }
                    break;
                case 6:
                    pointFB4 = p.b(cVar, f);
                    continue;
                case 7:
                    pointFB3 = p.b(cVar, f);
                    continue;
                default:
                    cVar.C();
                    break;
            }
            i = 1;
        }
        cVar.d();
        if (z3) {
            interpolator = a;
            t = tA2;
        } else {
            if (pointFB == null || pointFB2 == null) {
                interpolator = a;
            } else {
                float f2 = -f;
                pointFB.x = b.c.a.b0.f.b(pointFB.x, f2, f);
                pointFB.y = b.c.a.b0.f.b(pointFB.y, -100.0f, 100.0f);
                pointFB2.x = b.c.a.b0.f.b(pointFB2.x, f2, f);
                float fB = b.c.a.b0.f.b(pointFB2.y, -100.0f, 100.0f);
                pointFB2.y = fB;
                float f3 = pointFB.x;
                float f4 = pointFB.y;
                float f5 = pointFB2.x;
                PathMeasure pathMeasure = b.c.a.b0.g.a;
                int i2 = f3 != 0.0f ? (int) (527 * f3) : 17;
                if (f4 != 0.0f) {
                    i2 = (int) (i2 * 31 * f4);
                }
                if (f5 != 0.0f) {
                    i2 = (int) (i2 * 31 * f5);
                }
                if (fB != 0.0f) {
                    i2 = (int) (i2 * 31 * fB);
                }
                synchronized (q.class) {
                    if (f341b == null) {
                        f341b = new SparseArrayCompat<>();
                    }
                    weakReference = f341b.get(i2);
                }
                interpolator = weakReference != null ? weakReference.get() : null;
                if (weakReference == null || interpolator == null) {
                    pointFB.x /= f;
                    pointFB.y /= f;
                    float f6 = pointFB2.x / f;
                    pointFB2.x = f6;
                    float f7 = pointFB2.y / f;
                    pointFB2.y = f7;
                    try {
                        interpolatorCreate = PathInterpolatorCompat.create(pointFB.x, pointFB.y, f6, f7);
                    } catch (IllegalArgumentException e) {
                        interpolatorCreate = e.getMessage().equals("The Path cannot loop back on itself.") ? PathInterpolatorCompat.create(Math.min(pointFB.x, 1.0f), pointFB.y, Math.max(pointFB2.x, 0.0f), pointFB2.y) : new LinearInterpolator();
                    }
                    interpolator = interpolatorCreate;
                    try {
                        WeakReference<Interpolator> weakReference2 = new WeakReference<>(interpolator);
                        synchronized (q.class) {
                            f341b.put(i2, weakReference2);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            t = tA;
        }
        b.c.a.c0.a<T> aVar = new b.c.a.c0.a<>(dVar, tA2, t, interpolator, fN, null);
        aVar.m = pointFB4;
        aVar.n = pointFB3;
        return aVar;
    }
}
