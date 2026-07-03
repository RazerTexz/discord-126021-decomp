package p007b.p085c.p086a.p089b0;

import android.graphics.PointF;
import androidx.annotation.FloatRange;
import java.util.List;
import p007b.p085c.p086a.p091w.p092b.InterfaceC1535k;
import p007b.p085c.p086a.p095y.C1567f;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.c.a.b0.f */
/* JADX INFO: compiled from: MiscUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class C1498f {

    /* JADX INFO: renamed from: a */
    public static PointF f2308a = new PointF();

    /* JADX INFO: renamed from: a */
    public static PointF m651a(PointF pointF, PointF pointF2) {
        return new PointF(pointF.x + pointF2.x, pointF.y + pointF2.y);
    }

    /* JADX INFO: renamed from: b */
    public static float m652b(float f, float f2, float f3) {
        return Math.max(f2, Math.min(f3, f));
    }

    /* JADX INFO: renamed from: c */
    public static int m653c(int i, int i2, int i3) {
        return Math.max(i2, Math.min(i3, i));
    }

    /* JADX INFO: renamed from: d */
    public static int m654d(float f, float f2) {
        int i = (int) f;
        int i2 = (int) f2;
        int i3 = i / i2;
        int i4 = i % i2;
        if (!((i ^ i2) >= 0) && i4 != 0) {
            i3--;
        }
        return i - (i2 * i3);
    }

    /* JADX INFO: renamed from: e */
    public static float m655e(float f, float f2, @FloatRange(from = 0.0d, m75to = 1.0d) float f3) {
        return C1643a.m839a(f2, f, f3, f);
    }

    /* JADX INFO: renamed from: f */
    public static void m656f(C1567f c1567f, int i, List<C1567f> list, C1567f c1567f2, InterfaceC1535k interfaceC1535k) {
        if (c1567f.m768c(interfaceC1535k.getName(), i)) {
            list.add(c1567f2.m766a(interfaceC1535k.getName()).m772g(interfaceC1535k));
        }
    }
}
