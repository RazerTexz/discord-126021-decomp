package androidx.constraintlayout.motion.widget;

/* JADX INFO: loaded from: classes.dex */
public class SplineSet$Sort {
    private SplineSet$Sort() {
    }

    public static void doubleQuickSort(int[] iArr, float[] fArr, int i, int i2) {
        int[] iArr2 = new int[iArr.length + 10];
        iArr2[0] = i2;
        iArr2[1] = i;
        int i3 = 2;
        while (i3 > 0) {
            int i4 = i3 - 1;
            int i5 = iArr2[i4];
            i3 = i4 - 1;
            int i6 = iArr2[i3];
            if (i5 < i6) {
                int iPartition = partition(iArr, fArr, i5, i6);
                int i7 = i3 + 1;
                iArr2[i3] = iPartition - 1;
                int i8 = i7 + 1;
                iArr2[i7] = i5;
                int i9 = i8 + 1;
                iArr2[i8] = i6;
                i3 = i9 + 1;
                iArr2[i9] = iPartition + 1;
            }
        }
    }

    private static int partition(int[] iArr, float[] fArr, int i, int i2) {
        int i3 = iArr[i2];
        int i4 = i;
        while (i < i2) {
            if (iArr[i] <= i3) {
                swap(iArr, fArr, i4, i);
                i4++;
            }
            i++;
        }
        swap(iArr, fArr, i4, i2);
        return i4;
    }

    private static void swap(int[] iArr, float[] fArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
        float f = fArr[i];
        fArr[i] = fArr[i2];
        fArr[i2] = f;
    }
}
