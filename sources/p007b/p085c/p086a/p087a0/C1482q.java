package p007b.p085c.p086a.p087a0;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import java.io.IOException;
import java.lang.ref.WeakReference;
import p007b.p085c.p086a.C1505d;
import p007b.p085c.p086a.p087a0.p088i0.AbstractC1473c;
import p007b.p085c.p086a.p089b0.C1498f;
import p007b.p085c.p086a.p089b0.C1499g;
import p007b.p085c.p086a.p090c0.C1501a;

/* JADX INFO: renamed from: b.c.a.a0.q */
/* JADX INFO: compiled from: KeyframeParser.java */
/* JADX INFO: loaded from: classes.dex */
public class C1482q {

    /* JADX INFO: renamed from: b */
    public static SparseArrayCompat<WeakReference<Interpolator>> f2277b;

    /* JADX INFO: renamed from: a */
    public static final Interpolator f2276a = new LinearInterpolator();

    /* JADX INFO: renamed from: c */
    public static AbstractC1473c.a f2278c = AbstractC1473c.a.m616a("t", "s", "e", "o", "i", "h", "to", "ti");

    /* JADX INFO: renamed from: a */
    public static <T> C1501a<T> m631a(AbstractC1473c abstractC1473c, C1505d c1505d, float f, InterfaceC1469h0<T> interfaceC1469h0, boolean z2) throws IOException {
        Interpolator interpolator;
        T t;
        WeakReference<Interpolator> weakReference;
        Interpolator interpolatorCreate;
        if (!z2) {
            return new C1501a<>(interfaceC1469h0.mo413a(abstractC1473c, f));
        }
        abstractC1473c.mo604b();
        int i = 1;
        PointF pointFM628b = null;
        PointF pointFM628b2 = null;
        T tMo413a = null;
        T tMo413a2 = null;
        PointF pointFM628b3 = null;
        PointF pointFM628b4 = null;
        boolean z3 = false;
        float fMo609n = 0.0f;
        while (abstractC1473c.mo607e()) {
            switch (abstractC1473c.mo615y(f2278c)) {
                case 0:
                    fMo609n = (float) abstractC1473c.mo609n();
                    break;
                case 1:
                    tMo413a2 = interfaceC1469h0.mo413a(abstractC1473c, f);
                    continue;
                case 2:
                    tMo413a = interfaceC1469h0.mo413a(abstractC1473c, f);
                    continue;
                case 3:
                    pointFM628b = C1481p.m628b(abstractC1473c, f);
                    continue;
                case 4:
                    pointFM628b2 = C1481p.m628b(abstractC1473c, f);
                    continue;
                case 5:
                    if (abstractC1473c.mo610q() == i) {
                        z3 = true;
                    } else {
                        z3 = false;
                        continue;
                    }
                    break;
                case 6:
                    pointFM628b4 = C1481p.m628b(abstractC1473c, f);
                    continue;
                case 7:
                    pointFM628b3 = C1481p.m628b(abstractC1473c, f);
                    continue;
                default:
                    abstractC1473c.mo601C();
                    break;
            }
            i = 1;
        }
        abstractC1473c.mo606d();
        if (z3) {
            interpolator = f2276a;
            t = tMo413a2;
        } else {
            if (pointFM628b == null || pointFM628b2 == null) {
                interpolator = f2276a;
            } else {
                float f2 = -f;
                pointFM628b.x = C1498f.m652b(pointFM628b.x, f2, f);
                pointFM628b.y = C1498f.m652b(pointFM628b.y, -100.0f, 100.0f);
                pointFM628b2.x = C1498f.m652b(pointFM628b2.x, f2, f);
                float fM652b = C1498f.m652b(pointFM628b2.y, -100.0f, 100.0f);
                pointFM628b2.y = fM652b;
                float f3 = pointFM628b.x;
                float f4 = pointFM628b.y;
                float f5 = pointFM628b2.x;
                PathMeasure pathMeasure = C1499g.f2309a;
                int i2 = f3 != 0.0f ? (int) (527 * f3) : 17;
                if (f4 != 0.0f) {
                    i2 = (int) (i2 * 31 * f4);
                }
                if (f5 != 0.0f) {
                    i2 = (int) (i2 * 31 * f5);
                }
                if (fM652b != 0.0f) {
                    i2 = (int) (i2 * 31 * fM652b);
                }
                synchronized (C1482q.class) {
                    if (f2277b == null) {
                        f2277b = new SparseArrayCompat<>();
                    }
                    weakReference = f2277b.get(i2);
                }
                interpolator = weakReference != null ? weakReference.get() : null;
                if (weakReference == null || interpolator == null) {
                    pointFM628b.x /= f;
                    pointFM628b.y /= f;
                    float f6 = pointFM628b2.x / f;
                    pointFM628b2.x = f6;
                    float f7 = pointFM628b2.y / f;
                    pointFM628b2.y = f7;
                    try {
                        interpolatorCreate = PathInterpolatorCompat.create(pointFM628b.x, pointFM628b.y, f6, f7);
                    } catch (IllegalArgumentException e) {
                        interpolatorCreate = e.getMessage().equals("The Path cannot loop back on itself.") ? PathInterpolatorCompat.create(Math.min(pointFM628b.x, 1.0f), pointFM628b.y, Math.max(pointFM628b2.x, 0.0f), pointFM628b2.y) : new LinearInterpolator();
                    }
                    interpolator = interpolatorCreate;
                    try {
                        WeakReference<Interpolator> weakReference2 = new WeakReference<>(interpolator);
                        synchronized (C1482q.class) {
                            f2277b.put(i2, weakReference2);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            t = tMo413a;
        }
        C1501a<T> c1501a = new C1501a<>(c1505d, tMo413a2, t, interpolator, fMo609n, null);
        c1501a.f2328m = pointFM628b4;
        c1501a.f2329n = pointFM628b3;
        return c1501a;
    }
}
