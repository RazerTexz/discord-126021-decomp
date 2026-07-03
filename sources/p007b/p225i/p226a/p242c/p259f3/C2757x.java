package p007b.p225i.p226a.p242c.p259f3;

import androidx.annotation.Nullable;
import java.nio.charset.Charset;
import java.util.Arrays;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p355b.p356a.C4483c;

/* JADX INFO: renamed from: b.i.a.c.f3.x */
/* JADX INFO: compiled from: ParsableByteArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2757x {

    /* JADX INFO: renamed from: a */
    public byte[] f6793a;

    /* JADX INFO: renamed from: b */
    public int f6794b;

    /* JADX INFO: renamed from: c */
    public int f6795c;

    public C2757x() {
        this.f6793a = C2738e0.f6713f;
    }

    /* JADX INFO: renamed from: A */
    public void m3075A(int i) {
        byte[] bArr = this.f6793a;
        if (bArr.length < i) {
            bArr = new byte[i];
        }
        m3077C(bArr, i);
    }

    /* JADX INFO: renamed from: B */
    public void m3076B(byte[] bArr) {
        int length = bArr.length;
        this.f6793a = bArr;
        this.f6795c = length;
        this.f6794b = 0;
    }

    /* JADX INFO: renamed from: C */
    public void m3077C(byte[] bArr, int i) {
        this.f6793a = bArr;
        this.f6795c = i;
        this.f6794b = 0;
    }

    /* JADX INFO: renamed from: D */
    public void m3078D(int i) {
        C1460d.m531j(i >= 0 && i <= this.f6793a.length);
        this.f6795c = i;
    }

    /* JADX INFO: renamed from: E */
    public void m3079E(int i) {
        C1460d.m531j(i >= 0 && i <= this.f6795c);
        this.f6794b = i;
    }

    /* JADX INFO: renamed from: F */
    public void m3080F(int i) {
        m3079E(this.f6794b + i);
    }

    /* JADX INFO: renamed from: a */
    public int m3081a() {
        return this.f6795c - this.f6794b;
    }

    /* JADX INFO: renamed from: b */
    public void m3082b(int i) {
        byte[] bArr = this.f6793a;
        if (i > bArr.length) {
            this.f6793a = Arrays.copyOf(bArr, i);
        }
    }

    /* JADX INFO: renamed from: c */
    public int m3083c() {
        return this.f6793a[this.f6794b] & 255;
    }

    /* JADX INFO: renamed from: d */
    public void m3084d(C2756w c2756w, int i) {
        m3085e(c2756w.f6789a, 0, i);
        c2756w.m3071k(0);
    }

    /* JADX INFO: renamed from: e */
    public void m3085e(byte[] bArr, int i, int i2) {
        System.arraycopy(this.f6793a, this.f6794b, bArr, i, i2);
        this.f6794b += i2;
    }

    /* JADX INFO: renamed from: f */
    public int m3086f() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 24;
        int i4 = i2 + 1;
        this.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 16);
        int i6 = i4 + 1;
        this.f6794b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 8);
        this.f6794b = i6 + 1;
        return (bArr[i6] & 255) | i7;
    }

    @Nullable
    /* JADX INFO: renamed from: g */
    public String m3087g() {
        if (m3081a() == 0) {
            return null;
        }
        int i = this.f6794b;
        while (i < this.f6795c) {
            byte b2 = this.f6793a[i];
            int i2 = C2738e0.f6708a;
            if (b2 == 10 || b2 == 13) {
                break;
            }
            i++;
        }
        int i3 = this.f6794b;
        if (i - i3 >= 3) {
            byte[] bArr = this.f6793a;
            if (bArr[i3] == -17 && bArr[i3 + 1] == -69 && bArr[i3 + 2] == -65) {
                this.f6794b = i3 + 3;
            }
        }
        byte[] bArr2 = this.f6793a;
        int i4 = this.f6794b;
        String strM3005m = C2738e0.m3005m(bArr2, i4, i - i4);
        this.f6794b = i;
        int i5 = this.f6795c;
        if (i == i5) {
            return strM3005m;
        }
        byte[] bArr3 = this.f6793a;
        if (bArr3[i] == 13) {
            int i6 = i + 1;
            this.f6794b = i6;
            if (i6 == i5) {
                return strM3005m;
            }
        }
        int i7 = this.f6794b;
        if (bArr3[i7] == 10) {
            this.f6794b = i7 + 1;
        }
        return strM3005m;
    }

    /* JADX INFO: renamed from: h */
    public int m3088h() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = bArr[i] & 255;
        int i4 = i2 + 1;
        this.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        int i6 = i4 + 1;
        this.f6794b = i6;
        int i7 = i5 | ((bArr[i4] & 255) << 16);
        this.f6794b = i6 + 1;
        return ((bArr[i6] & 255) << 24) | i7;
    }

    /* JADX INFO: renamed from: i */
    public short m3089i() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = bArr[i] & 255;
        this.f6794b = i2 + 1;
        return (short) (((bArr[i2] & 255) << 8) | i3);
    }

    /* JADX INFO: renamed from: j */
    public long m3090j() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        long j = ((long) bArr[i]) & 255;
        int i3 = i2 + 1;
        this.f6794b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 8);
        int i4 = i3 + 1;
        this.f6794b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 16);
        this.f6794b = i4 + 1;
        return j3 | ((((long) bArr[i4]) & 255) << 24);
    }

    /* JADX INFO: renamed from: k */
    public int m3091k() {
        int iM3088h = m3088h();
        if (iM3088h >= 0) {
            return iM3088h;
        }
        throw new IllegalStateException(C1643a.m851g(29, "Top bit not zero: ", iM3088h));
    }

    /* JADX INFO: renamed from: l */
    public int m3092l() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = bArr[i] & 255;
        this.f6794b = i2 + 1;
        return ((bArr[i2] & 255) << 8) | i3;
    }

    /* JADX INFO: renamed from: m */
    public long m3093m() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        long j = (((long) bArr[i]) & 255) << 56;
        int i3 = i2 + 1;
        this.f6794b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 48);
        int i4 = i3 + 1;
        this.f6794b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 40);
        int i5 = i4 + 1;
        this.f6794b = i5;
        long j4 = j3 | ((((long) bArr[i4]) & 255) << 32);
        int i6 = i5 + 1;
        this.f6794b = i6;
        long j5 = j4 | ((((long) bArr[i5]) & 255) << 24);
        int i7 = i6 + 1;
        this.f6794b = i7;
        long j6 = j5 | ((((long) bArr[i6]) & 255) << 16);
        int i8 = i7 + 1;
        this.f6794b = i8;
        long j7 = j6 | ((((long) bArr[i7]) & 255) << 8);
        this.f6794b = i8 + 1;
        return j7 | (((long) bArr[i8]) & 255);
    }

    @Nullable
    /* JADX INFO: renamed from: n */
    public String m3094n() {
        if (m3081a() == 0) {
            return null;
        }
        int i = this.f6794b;
        while (i < this.f6795c && this.f6793a[i] != 0) {
            i++;
        }
        byte[] bArr = this.f6793a;
        int i2 = this.f6794b;
        String strM3005m = C2738e0.m3005m(bArr, i2, i - i2);
        this.f6794b = i;
        if (i < this.f6795c) {
            this.f6794b = i + 1;
        }
        return strM3005m;
    }

    /* JADX INFO: renamed from: o */
    public String m3095o(int i) {
        if (i == 0) {
            return "";
        }
        int i2 = this.f6794b;
        int i3 = (i2 + i) - 1;
        String strM3005m = C2738e0.m3005m(this.f6793a, i2, (i3 >= this.f6795c || this.f6793a[i3] != 0) ? i : i - 1);
        this.f6794b += i;
        return strM3005m;
    }

    /* JADX INFO: renamed from: p */
    public short m3096p() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f6794b = i2 + 1;
        return (short) ((bArr[i2] & 255) | i3);
    }

    /* JADX INFO: renamed from: q */
    public String m3097q(int i) {
        return m3098r(i, C4483c.f11945c);
    }

    /* JADX INFO: renamed from: r */
    public String m3098r(int i, Charset charset) {
        String str = new String(this.f6793a, this.f6794b, i, charset);
        this.f6794b += i;
        return str;
    }

    /* JADX INFO: renamed from: s */
    public int m3099s() {
        return (m3100t() << 21) | (m3100t() << 14) | (m3100t() << 7) | m3100t();
    }

    /* JADX INFO: renamed from: t */
    public int m3100t() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        this.f6794b = i + 1;
        return bArr[i] & 255;
    }

    /* JADX INFO: renamed from: u */
    public long m3101u() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        long j = (((long) bArr[i]) & 255) << 24;
        int i3 = i2 + 1;
        this.f6794b = i3;
        long j2 = j | ((((long) bArr[i2]) & 255) << 16);
        int i4 = i3 + 1;
        this.f6794b = i4;
        long j3 = j2 | ((((long) bArr[i3]) & 255) << 8);
        this.f6794b = i4 + 1;
        return j3 | (((long) bArr[i4]) & 255);
    }

    /* JADX INFO: renamed from: v */
    public int m3102v() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 16;
        int i4 = i2 + 1;
        this.f6794b = i4;
        int i5 = i3 | ((bArr[i2] & 255) << 8);
        this.f6794b = i4 + 1;
        return (bArr[i4] & 255) | i5;
    }

    /* JADX INFO: renamed from: w */
    public int m3103w() {
        int iM3086f = m3086f();
        if (iM3086f >= 0) {
            return iM3086f;
        }
        throw new IllegalStateException(C1643a.m851g(29, "Top bit not zero: ", iM3086f));
    }

    /* JADX INFO: renamed from: x */
    public long m3104x() {
        long jM3093m = m3093m();
        if (jM3093m >= 0) {
            return jM3093m;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("Top bit not zero: ");
        sb.append(jM3093m);
        throw new IllegalStateException(sb.toString());
    }

    /* JADX INFO: renamed from: y */
    public int m3105y() {
        byte[] bArr = this.f6793a;
        int i = this.f6794b;
        int i2 = i + 1;
        this.f6794b = i2;
        int i3 = (bArr[i] & 255) << 8;
        this.f6794b = i2 + 1;
        return (bArr[i2] & 255) | i3;
    }

    /* JADX INFO: renamed from: z */
    public long m3106z() {
        int i;
        int i2;
        long j = this.f6793a[this.f6794b];
        int i3 = 7;
        while (true) {
            if (i3 >= 0) {
                int i4 = 1 << i3;
                if ((((long) i4) & j) == 0) {
                    if (i3 < 6) {
                        j &= (long) (i4 - 1);
                        i2 = 7 - i3;
                        break;
                    }
                    if (i3 == 7) {
                        i2 = 1;
                        break;
                    }
                } else {
                    i3--;
                }
            }
            i2 = 0;
            break;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder(55);
            sb.append("Invalid UTF-8 sequence first byte: ");
            sb.append(j);
            throw new NumberFormatException(sb.toString());
        }
        for (i = 1; i < i2; i++) {
            byte b2 = this.f6793a[this.f6794b + i];
            if ((b2 & 192) != 128) {
                StringBuilder sb2 = new StringBuilder(62);
                sb2.append("Invalid UTF-8 sequence continuation byte: ");
                sb2.append(j);
                throw new NumberFormatException(sb2.toString());
            }
            j = (j << 6) | ((long) (b2 & 63));
        }
        this.f6794b += i2;
        return j;
    }

    public C2757x(int i) {
        this.f6793a = new byte[i];
        this.f6795c = i;
    }

    public C2757x(byte[] bArr) {
        this.f6793a = bArr;
        this.f6795c = bArr.length;
    }

    public C2757x(byte[] bArr, int i) {
        this.f6793a = bArr;
        this.f6795c = i;
    }
}
