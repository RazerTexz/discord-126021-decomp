package b.c.a.b0;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import b.c.a.w.b.KeyPathElementContent;
import b.c.a.y.KeyPath;
import b.d.b.a.outline;
import java.util.List;

/* JADX INFO: renamed from: b.c.a.b0.f, reason: use source file name */
/* JADX INFO: compiled from: MiscUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class MiscUtils {
    public static PointF a = new PointF();

    public static PointF a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    public static float b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    public static int c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    public static int d(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }

    public static float e(float f, float f2, @FloatRange(from = 0.0d, to = 1.0d) float f3) {
        return outline.a(f2, f, f3, f);
    }

    public static void f(KeyPath keyPath, int i, List<KeyPath> list, KeyPath keyPath2, KeyPathElementContent keyPathElementContent) {
        if (keyPath.c(keyPathElementContent.getName(), i)) {
            list.add(keyPath2.a(keyPathElementContent.getName()).g(keyPathElementContent));
        }
    }
}
