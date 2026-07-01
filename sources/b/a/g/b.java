package b.a.g;

import d0.z.d.m;
import java.util.Arrays;

/* JADX INFO: compiled from: ColorHistogram.kt */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    public static final b$a a = new b$a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int[] f70b;
    public final int[] c;
    public final int d;

    public b(int[] iArr) {
        int length;
        m.checkNotNullParameter(iArr, "pixels");
        Arrays.sort(iArr);
        int i = 0;
        if (iArr.length < 2) {
            length = iArr.length;
        } else {
            int i2 = iArr[0];
            int length2 = iArr.length;
            int i3 = i2;
            length = 1;
            for (int i4 = 1; i4 < length2; i4++) {
                if (iArr[i4] != i3) {
                    i3 = iArr[i4];
                    length++;
                }
            }
        }
        this.d = length;
        int[] iArr2 = new int[length];
        this.f70b = iArr2;
        int[] iArr3 = new int[length];
        this.c = iArr3;
        if (iArr.length == 0) {
            return;
        }
        int i5 = iArr[0];
        iArr2[0] = i5;
        iArr3[0] = 1;
        if (iArr.length == 1) {
            return;
        }
        int length3 = iArr.length;
        for (int i6 = 1; i6 < length3; i6++) {
            if (iArr[i6] == i5) {
                int[] iArr4 = this.c;
                iArr4[i] = iArr4[i] + 1;
            } else {
                i5 = iArr[i6];
                i++;
                this.f70b[i] = i5;
                this.c[i] = 1;
            }
        }
    }
}
