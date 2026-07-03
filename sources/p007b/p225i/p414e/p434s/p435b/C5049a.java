package p007b.p225i.p414e.p434s.p435b;

import com.google.zxing.FormatException;
import p007b.p225i.p414e.p418n.C4963b;

/* JADX INFO: renamed from: b.i.e.s.b.a */
/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C5049a {

    /* JADX INFO: renamed from: a */
    public final C4963b f13510a;

    /* JADX INFO: renamed from: b */
    public C5058j f13511b;

    /* JADX INFO: renamed from: c */
    public C5055g f13512c;

    /* JADX INFO: renamed from: d */
    public boolean f13513d;

    public C5049a(C4963b c4963b) throws FormatException {
        int i = c4963b.f13230k;
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.m9260a();
        }
        this.f13510a = c4963b;
    }

    /* JADX INFO: renamed from: a */
    public final int m7084a(int i, int i2, int i3) {
        return this.f13513d ? this.f13510a.m6942f(i2, i) : this.f13510a.m6942f(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    /* JADX INFO: renamed from: b */
    public void m7085b() {
        int i = 0;
        while (i < this.f13510a.f13229j) {
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                C4963b c4963b = this.f13510a;
                if (i3 < c4963b.f13230k) {
                    if (c4963b.m6942f(i, i3) != this.f13510a.m6942f(i3, i)) {
                        this.f13510a.m6941b(i3, i);
                        this.f13510a.m6941b(i, i3);
                    }
                    i3++;
                }
            }
            i = i2;
        }
    }

    /* JADX INFO: renamed from: c */
    public C5055g m7086c() throws FormatException {
        C5055g c5055g = this.f13512c;
        if (c5055g != null) {
            return c5055g;
        }
        int iM7084a = 0;
        int iM7084a2 = 0;
        for (int i = 0; i < 6; i++) {
            iM7084a2 = m7084a(i, 8, iM7084a2);
        }
        int iM7084a3 = m7084a(8, 7, m7084a(8, 8, m7084a(7, 8, iM7084a2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iM7084a3 = m7084a(8, i2, iM7084a3);
        }
        int i3 = this.f13510a.f13230k;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iM7084a = m7084a(8, i5, iM7084a);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iM7084a = m7084a(i6, 8, iM7084a);
        }
        C5055g c5055gM7099a = C5055g.m7099a(iM7084a3, iM7084a);
        if (c5055gM7099a == null) {
            c5055gM7099a = C5055g.m7099a(iM7084a3 ^ 21522, iM7084a ^ 21522);
        }
        this.f13512c = c5055gM7099a;
        if (c5055gM7099a != null) {
            return c5055gM7099a;
        }
        throw FormatException.m9260a();
    }

    /* JADX INFO: renamed from: d */
    public C5058j m7087d() throws FormatException {
        C5058j c5058j = this.f13511b;
        if (c5058j != null) {
            return c5058j;
        }
        int i = this.f13510a.f13230k;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return C5058j.m7104d(i2);
        }
        int i3 = i - 11;
        int iM7084a = 0;
        int iM7084a2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iM7084a2 = m7084a(i5, i4, iM7084a2);
            }
        }
        C5058j c5058jM7103b = C5058j.m7103b(iM7084a2);
        if (c5058jM7103b != null && c5058jM7103b.m7105c() == i) {
            this.f13511b = c5058jM7103b;
            return c5058jM7103b;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iM7084a = m7084a(i6, i7, iM7084a);
            }
        }
        C5058j c5058jM7103b2 = C5058j.m7103b(iM7084a);
        if (c5058jM7103b2 == null || c5058jM7103b2.m7105c() != i) {
            throw FormatException.m9260a();
        }
        this.f13511b = c5058jM7103b2;
        return c5058jM7103b2;
    }

    /* JADX INFO: renamed from: e */
    public void m7088e() {
        if (this.f13512c == null) {
            return;
        }
        EnumC5051c enumC5051c = EnumC5051c.values()[this.f13512c.f13535c];
        C4963b c4963b = this.f13510a;
        enumC5051c.m7090g(c4963b, c4963b.f13230k);
    }
}
