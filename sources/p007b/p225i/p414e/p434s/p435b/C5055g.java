package p007b.p225i.p414e.p434s.p435b;

/* JADX INFO: renamed from: b.i.e.s.b.g */
/* JADX INFO: compiled from: FormatInformation.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5055g {

    /* JADX INFO: renamed from: a */
    public static final int[][] f13533a = {new int[]{21522, 0}, new int[]{20773, 1}, new int[]{24188, 2}, new int[]{23371, 3}, new int[]{17913, 4}, new int[]{16590, 5}, new int[]{20375, 6}, new int[]{19104, 7}, new int[]{30660, 8}, new int[]{29427, 9}, new int[]{32170, 10}, new int[]{30877, 11}, new int[]{26159, 12}, new int[]{25368, 13}, new int[]{27713, 14}, new int[]{26998, 15}, new int[]{5769, 16}, new int[]{5054, 17}, new int[]{7399, 18}, new int[]{6608, 19}, new int[]{1890, 20}, new int[]{597, 21}, new int[]{3340, 22}, new int[]{2107, 23}, new int[]{13663, 24}, new int[]{12392, 25}, new int[]{16177, 26}, new int[]{14854, 27}, new int[]{9396, 28}, new int[]{8579, 29}, new int[]{11994, 30}, new int[]{11245, 31}};

    /* JADX INFO: renamed from: b */
    public final EnumC5054f f13534b;

    /* JADX INFO: renamed from: c */
    public final byte f13535c;

    public C5055g(int i) {
        int i2 = (i >> 3) & 3;
        if (i2 >= 0) {
            EnumC5054f[] enumC5054fArr = EnumC5054f.f13531n;
            if (i2 < enumC5054fArr.length) {
                this.f13534b = enumC5054fArr[i2];
                this.f13535c = (byte) (i & 7);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /* JADX INFO: renamed from: a */
    public static C5055g m7099a(int i, int i2) {
        int iM7100b;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        for (int[] iArr : f13533a) {
            int i5 = iArr[0];
            if (i5 == i || i5 == i2) {
                return new C5055g(iArr[1]);
            }
            int iM7100b2 = m7100b(i, i5);
            if (iM7100b2 < i3) {
                i4 = iArr[1];
                i3 = iM7100b2;
            }
            if (i != i2 && (iM7100b = m7100b(i2, i5)) < i3) {
                i4 = iArr[1];
                i3 = iM7100b;
            }
        }
        if (i3 <= 3) {
            return new C5055g(i4);
        }
        return null;
    }

    /* JADX INFO: renamed from: b */
    public static int m7100b(int i, int i2) {
        return Integer.bitCount(i ^ i2);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C5055g)) {
            return false;
        }
        C5055g c5055g = (C5055g) obj;
        return this.f13534b == c5055g.f13534b && this.f13535c == c5055g.f13535c;
    }

    public int hashCode() {
        return (this.f13534b.ordinal() << 3) | this.f13535c;
    }
}
