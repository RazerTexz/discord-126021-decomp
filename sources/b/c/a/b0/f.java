package b.c.a.b0;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import b.c.a.w.b.k;
import java.util.List;

/* JADX INFO: compiled from: MiscUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class f {
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
        return b.d.b.a.a.a(f2, f, f3, f);
    }

    public static void f(b.c.a.y.f fVar, int i, List<b.c.a.y.f> list, b.c.a.y.f fVar2, k kVar) {
        if (fVar.c(kVar.getName(), i)) {
            list.add(fVar2.a(kVar.getName()).g(kVar));
        }
    }
}
