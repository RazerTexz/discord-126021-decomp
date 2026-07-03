package p007b.p225i.p414e.p430r.p431d.p432k;

/* JADX INFO: renamed from: b.i.e.r.d.k.c */
/* JADX INFO: compiled from: ModulusPoly.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5046c {

    /* JADX INFO: renamed from: a */
    public final C5045b f13502a;

    /* JADX INFO: renamed from: b */
    public final int[] f13503b;

    public C5046c(C5045b c5045b, int[] iArr) {
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        this.f13502a = c5045b;
        int length = iArr.length;
        if (length <= 1 || iArr[0] != 0) {
            this.f13503b = iArr;
            return;
        }
        int i = 1;
        while (i < length && iArr[i] == 0) {
            i++;
        }
        if (i == length) {
            this.f13503b = new int[]{0};
            return;
        }
        int[] iArr2 = new int[length - i];
        this.f13503b = iArr2;
        System.arraycopy(iArr, i, iArr2, 0, iArr2.length);
    }

    /* JADX INFO: renamed from: a */
    public C5046c m7071a(C5046c c5046c) {
        if (!this.f13502a.equals(c5046c.f13502a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (m7075e()) {
            return c5046c;
        }
        if (c5046c.m7075e()) {
            return this;
        }
        int[] iArr = this.f13503b;
        int[] iArr2 = c5046c.f13503b;
        if (iArr.length <= iArr2.length) {
            iArr = iArr2;
            iArr2 = iArr;
        }
        int[] iArr3 = new int[iArr.length];
        int length = iArr.length - iArr2.length;
        System.arraycopy(iArr, 0, iArr3, 0, length);
        for (int i = length; i < iArr.length; i++) {
            iArr3[i] = this.f13502a.m7066a(iArr2[i - length], iArr[i]);
        }
        return new C5046c(this.f13502a, iArr3);
    }

    /* JADX INFO: renamed from: b */
    public int m7072b(int i) {
        if (i == 0) {
            return m7073c(0);
        }
        if (i == 1) {
            int iM7066a = 0;
            for (int i2 : this.f13503b) {
                iM7066a = this.f13502a.m7066a(iM7066a, i2);
            }
            return iM7066a;
        }
        int[] iArr = this.f13503b;
        int iM7066a2 = iArr[0];
        int length = iArr.length;
        for (int i3 = 1; i3 < length; i3++) {
            C5045b c5045b = this.f13502a;
            iM7066a2 = c5045b.m7066a(c5045b.m7069d(i, iM7066a2), this.f13503b[i3]);
        }
        return iM7066a2;
    }

    /* JADX INFO: renamed from: c */
    public int m7073c(int i) {
        int[] iArr = this.f13503b;
        return iArr[(iArr.length - 1) - i];
    }

    /* JADX INFO: renamed from: d */
    public int m7074d() {
        return this.f13503b.length - 1;
    }

    /* JADX INFO: renamed from: e */
    public boolean m7075e() {
        return this.f13503b[0] == 0;
    }

    /* JADX INFO: renamed from: f */
    public C5046c m7076f(int i) {
        if (i == 0) {
            return this.f13502a.f13500d;
        }
        if (i == 1) {
            return this;
        }
        int length = this.f13503b.length;
        int[] iArr = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = this.f13502a.m7069d(this.f13503b[i2], i);
        }
        return new C5046c(this.f13502a, iArr);
    }

    /* JADX INFO: renamed from: g */
    public C5046c m7077g(C5046c c5046c) {
        if (!this.f13502a.equals(c5046c.f13502a)) {
            throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
        }
        if (m7075e() || c5046c.m7075e()) {
            return this.f13502a.f13500d;
        }
        int[] iArr = this.f13503b;
        int length = iArr.length;
        int[] iArr2 = c5046c.f13503b;
        int length2 = iArr2.length;
        int[] iArr3 = new int[(length + length2) - 1];
        for (int i = 0; i < length; i++) {
            int i2 = iArr[i];
            for (int i3 = 0; i3 < length2; i3++) {
                int i4 = i + i3;
                C5045b c5045b = this.f13502a;
                iArr3[i4] = c5045b.m7066a(iArr3[i4], c5045b.m7069d(i2, iArr2[i3]));
            }
        }
        return new C5046c(this.f13502a, iArr3);
    }

    /* JADX INFO: renamed from: h */
    public C5046c m7078h() {
        int length = this.f13503b.length;
        int[] iArr = new int[length];
        for (int i = 0; i < length; i++) {
            iArr[i] = this.f13502a.m7070e(0, this.f13503b[i]);
        }
        return new C5046c(this.f13502a, iArr);
    }

    /* JADX INFO: renamed from: i */
    public C5046c m7079i(C5046c c5046c) {
        if (this.f13502a.equals(c5046c.f13502a)) {
            return c5046c.m7075e() ? this : m7071a(c5046c.m7078h());
        }
        throw new IllegalArgumentException("ModulusPolys do not have same ModulusGF field");
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(m7074d() * 8);
        for (int iM7074d = m7074d(); iM7074d >= 0; iM7074d--) {
            int iM7073c = m7073c(iM7074d);
            if (iM7073c != 0) {
                if (iM7073c < 0) {
                    sb.append(" - ");
                    iM7073c = -iM7073c;
                } else if (sb.length() > 0) {
                    sb.append(" + ");
                }
                if (iM7074d == 0 || iM7073c != 1) {
                    sb.append(iM7073c);
                }
                if (iM7074d != 0) {
                    if (iM7074d == 1) {
                        sb.append('x');
                    } else {
                        sb.append("x^");
                        sb.append(iM7074d);
                    }
                }
            }
        }
        return sb.toString();
    }
}
