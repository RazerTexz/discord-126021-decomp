package b.i.e.s.b;

/* JADX INFO: renamed from: b.i.e.s.b.g, reason: use source file name */
/* JADX INFO: compiled from: FormatInformation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class FormatInformation {
    public static final int[][] a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ErrorCorrectionLevel f1888b;
    public final byte c;

    public FormatInformation(int i) {
        int i2 = (i >> 3) & 3;
        if (i2 >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = ErrorCorrectionLevel.n;
            if (i2 < errorCorrectionLevelArr.length) {
                this.f1888b = errorCorrectionLevelArr[i2];
                this.c = (byte) (i & 7);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public static FormatInformation a(int i, int i2) {
        int iB;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : a) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new FormatInformation(iArr[1]);
            }
            int iB2 = b(i, i5);
            if (iB2 < i3) {
                i4 = iArr[1];
                i3 = iB2;
            }
            if (i != i2 && (iB = b(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iB;
            }
        }
        if (i3 <= 3) {
            return new FormatInformation(i4);
        }
        return null;
    }

    public static int b(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof FormatInformation)) {
            return false;
        }
        FormatInformation formatInformation = (FormatInformation) obj;
        return this.f1888b == formatInformation.f1888b && this.c == formatInformation.c;
    }

    public int hashCode() {
        return (this.f1888b.ordinal() << 3) | this.c;
    }
}
