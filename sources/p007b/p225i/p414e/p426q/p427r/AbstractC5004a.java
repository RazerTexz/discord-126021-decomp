package p007b.p225i.p414e.p426q.p427r;

import com.google.zxing.NotFoundException;
import p007b.p225i.p414e.p426q.AbstractC4997k;

/* JADX INFO: renamed from: b.i.e.q.r.a */
/* JADX INFO: compiled from: AbstractRSSReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC5004a extends AbstractC4997k {

    /* JADX INFO: renamed from: b */
    public final int[] f13400b;

    /* JADX INFO: renamed from: e */
    public final int[] f13403e;

    /* JADX INFO: renamed from: f */
    public final int[] f13404f;

    /* JADX INFO: renamed from: a */
    public final int[] f13399a = new int[4];

    /* JADX INFO: renamed from: c */
    public final float[] f13401c = new float[4];

    /* JADX INFO: renamed from: d */
    public final float[] f13402d = new float[4];

    public AbstractC5004a() {
        int[] iArr = new int[8];
        this.f13400b = iArr;
        this.f13403e = new int[iArr.length / 2];
        this.f13404f = new int[iArr.length / 2];
    }

    /* JADX INFO: renamed from: g */
    public static void m7009g(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] < f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    /* JADX INFO: renamed from: h */
    public static void m7010h(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (fArr[i2] > f) {
                f = fArr[i2];
                i = i2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX INFO: renamed from: i */
    public static boolean m7011i(int[] iArr) {
        int i = iArr[0] + iArr[1];
        float f = i / ((iArr[2] + i) + iArr[3]);
        if (f >= 0.7916667f && f <= 0.89285713f) {
            int i2 = Integer.MAX_VALUE;
            int i3 = Integer.MIN_VALUE;
            for (int i4 : iArr) {
                if (i4 > i3) {
                    i3 = i4;
                }
                if (i4 < i2) {
                    i2 = i4;
                }
            }
            if (i3 < i2 * 10) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: j */
    public static int m7012j(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (AbstractC4997k.m6996d(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.f21665l;
    }
}
