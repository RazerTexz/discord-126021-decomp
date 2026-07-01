package b.i.e.q.r;

import b.i.e.q.OneDReader;
import com.google.zxing.NotFoundException;

/* JADX INFO: renamed from: b.i.e.q.r.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractRSSReader.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f1862b;
    public final int[] e;
    public final int[] f;
    public final int[] a = new int[4];
    public final float[] c = new float[4];
    public final float[] d = new float[4];

    public AbstractRSSReader() {
        int[] iArr = new int[8];
        this.f1862b = iArr;
        this.e = new int[iArr.length / 2];
        this.f = new int[iArr.length / 2];
    }

    public static void g(int[] iArr, float[] fArr) {
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

    public static void h(int[] iArr, float[] fArr) {
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

    public static boolean i(int[] iArr) {
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

    public static int j(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (OneDReader.d(iArr, iArr2[i], 0.45f) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.l;
    }
}
