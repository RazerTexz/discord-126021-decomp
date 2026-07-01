package b.c.a.a0;

import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import androidx.collection.SparseArrayCompat;
import androidx.core.view.animation.PathInterpolatorCompat;
import b.c.a.LottieComposition;
import b.c.a.a0.i0.JsonReader2;
import b.c.a.b0.MiscUtils;
import b.c.a.b0.Utils;
import b.c.a.c0.Keyframe;
import java.io.IOException;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: b.c.a.a0.q, reason: use source file name */
/* JADX INFO: compiled from: KeyframeParser.java */
/* JADX INFO: loaded from: classes.dex */
public class KeyframeParser {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static SparseArrayCompat<WeakReference<Interpolator>> f341b;
    public static final Interpolator a = new LinearInterpolator();
    public static JsonReader2.a c = JsonReader2.a.a("t", "s", "e", "o", "i", "h", "to", "ti");

    public static <T> Keyframe<T> a(JsonReader2 jsonReader2, LottieComposition lottieComposition, float f, ValueParser<T> valueParser, boolean z2) throws IOException {
        Interpolator interpolator;
        T t;
        WeakReference<Interpolator> weakReference;
        Interpolator interpolatorCreate;
        if (!z2) {
            return new Keyframe<>(valueParser.a(jsonReader2, f));
        }
        jsonReader2.b();
        int i = 1;
        PointF pointFB = null;
        PointF pointFB2 = null;
        T tA = null;
        T tA2 = null;
        PointF pointFB3 = null;
        PointF pointFB4 = null;
        boolean z3 = false;
        float fN = 0.0f;
        while (jsonReader2.e()) {
            switch (jsonReader2.y(c)) {
                case 0:
                    fN = (float) jsonReader2.n();
                    break;
                case 1:
                    tA2 = valueParser.a(jsonReader2, f);
                    continue;
                case 2:
                    tA = valueParser.a(jsonReader2, f);
                    continue;
                case 3:
                    pointFB = JsonUtils.b(jsonReader2, f);
                    continue;
                case 4:
                    pointFB2 = JsonUtils.b(jsonReader2, f);
                    continue;
                case 5:
                    if (jsonReader2.q() == i) {
                        z3 = true;
                    } else {
                        z3 = false;
                        continue;
                    }
                    break;
                case 6:
                    pointFB4 = JsonUtils.b(jsonReader2, f);
                    continue;
                case 7:
                    pointFB3 = JsonUtils.b(jsonReader2, f);
                    continue;
                default:
                    jsonReader2.C();
                    break;
            }
            i = 1;
        }
        jsonReader2.d();
        if (z3) {
            interpolator = a;
            t = tA2;
        } else {
            if (pointFB == null || pointFB2 == null) {
                interpolator = a;
            } else {
                float f2 = -f;
                pointFB.x = MiscUtils.b(pointFB.x, f2, f);
                pointFB.y = MiscUtils.b(pointFB.y, -100.0f, 100.0f);
                pointFB2.x = MiscUtils.b(pointFB2.x, f2, f);
                float fB = MiscUtils.b(pointFB2.y, -100.0f, 100.0f);
                pointFB2.y = fB;
                float f3 = pointFB.x;
                float f4 = pointFB.y;
                float f5 = pointFB2.x;
                PathMeasure pathMeasure = Utils.a;
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
                synchronized (KeyframeParser.class) {
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
                        synchronized (KeyframeParser.class) {
                            f341b.put(i2, weakReference2);
                        }
                    } catch (ArrayIndexOutOfBoundsException unused) {
                    }
                }
            }
            t = tA;
        }
        Keyframe<T> keyframe = new Keyframe<>(lottieComposition, tA2, t, interpolator, fN, null);
        keyframe.m = pointFB4;
        keyframe.n = pointFB3;
        return keyframe;
    }
}
