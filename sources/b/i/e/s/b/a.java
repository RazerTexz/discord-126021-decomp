package b.i.e.s.b;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final b.i.e.n.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f1886b;
    public g c;
    public boolean d;

    public a(b.i.e.n.b bVar) throws FormatException {
        int i = bVar.k;
        if (i < 21 || (i & 3) != 1) {
            throw FormatException.a();
        }
        this.a = bVar;
    }

    public final int a(int i, int i2, int i3) {
        return this.d ? this.a.f(i2, i) : this.a.f(i, i2) ? (i3 << 1) | 1 : i3 << 1;
    }

    public void b() {
        int i = 0;
        while (i < this.a.j) {
            int i2 = i + 1;
            int i3 = i2;
            while (true) {
                b.i.e.n.b bVar = this.a;
                if (i3 < bVar.k) {
                    if (bVar.f(i, i3) != this.a.f(i3, i)) {
                        this.a.b(i3, i);
                        this.a.b(i, i3);
                    }
                    i3++;
                }
            }
            i = i2;
        }
    }

    public g c() throws FormatException {
        g gVar = this.c;
        if (gVar != null) {
            return gVar;
        }
        int iA = 0;
        int iA2 = 0;
        for (int i = 0; i < 6; i++) {
            iA2 = a(i, 8, iA2);
        }
        int iA3 = a(8, 7, a(8, 8, a(7, 8, iA2)));
        for (int i2 = 5; i2 >= 0; i2--) {
            iA3 = a(8, i2, iA3);
        }
        int i3 = this.a.k;
        int i4 = i3 - 7;
        for (int i5 = i3 - 1; i5 >= i4; i5--) {
            iA = a(8, i5, iA);
        }
        for (int i6 = i3 - 8; i6 < i3; i6++) {
            iA = a(i6, 8, iA);
        }
        g gVarA = g.a(iA3, iA);
        if (gVarA == null) {
            gVarA = g.a(iA3 ^ 21522, iA ^ 21522);
        }
        this.c = gVarA;
        if (gVarA != null) {
            return gVarA;
        }
        throw FormatException.a();
    }

    public j d() throws FormatException {
        j jVar = this.f1886b;
        if (jVar != null) {
            return jVar;
        }
        int i = this.a.k;
        int i2 = (i - 17) / 4;
        if (i2 <= 6) {
            return j.d(i2);
        }
        int i3 = i - 11;
        int iA = 0;
        int iA2 = 0;
        for (int i4 = 5; i4 >= 0; i4--) {
            for (int i5 = i - 9; i5 >= i3; i5--) {
                iA2 = a(i5, i4, iA2);
            }
        }
        j jVarB = j.b(iA2);
        if (jVarB != null && jVarB.c() == i) {
            this.f1886b = jVarB;
            return jVarB;
        }
        for (int i6 = 5; i6 >= 0; i6--) {
            for (int i7 = i - 9; i7 >= i3; i7--) {
                iA = a(i6, i7, iA);
            }
        }
        j jVarB2 = j.b(iA);
        if (jVarB2 == null || jVarB2.c() != i) {
            throw FormatException.a();
        }
        this.f1886b = jVarB2;
        return jVarB2;
    }

    public void e() {
        if (this.c == null) {
            return;
        }
        c cVar = c.values()[this.c.c];
        b.i.e.n.b bVar = this.a;
        cVar.g(bVar, bVar.k);
    }
}
