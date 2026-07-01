package b.i.e.o.b;

import com.google.zxing.FormatException;

/* JADX INFO: compiled from: BitMatrixParser.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final b.i.e.n.b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b.i.e.n.b f1844b;
    public final e c;

    public a(b.i.e.n.b bVar) throws FormatException {
        int i;
        int i2 = bVar.k;
        if (i2 < 8 || i2 > 144 || (i2 & 1) != 0) {
            throw FormatException.a();
        }
        int i3 = bVar.j;
        e[] eVarArr = e.a;
        if ((i2 & 1) != 0 || (i3 & 1) != 0) {
            throw FormatException.a();
        }
        for (e eVar : e.a) {
            int i4 = eVar.c;
            if (i4 == i2 && (i = eVar.d) == i3) {
                this.c = eVar;
                if (bVar.k != i4) {
                    throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
                }
                int i5 = eVar.e;
                int i6 = eVar.f;
                int i7 = i4 / i5;
                int i8 = i / i6;
                b.i.e.n.b bVar2 = new b.i.e.n.b(i8 * i6, i7 * i5);
                for (int i9 = 0; i9 < i7; i9++) {
                    int i10 = i9 * i5;
                    for (int i11 = 0; i11 < i8; i11++) {
                        int i12 = i11 * i6;
                        for (int i13 = 0; i13 < i5; i13++) {
                            int i14 = ((i5 + 2) * i9) + 1 + i13;
                            int i15 = i10 + i13;
                            for (int i16 = 0; i16 < i6; i16++) {
                                if (bVar.f(((i6 + 2) * i11) + 1 + i16, i14)) {
                                    bVar2.j(i12 + i16, i15);
                                }
                            }
                        }
                    }
                }
                this.a = bVar2;
                this.f1844b = new b.i.e.n.b(bVar2.j, bVar2.k);
                return;
            }
        }
        throw FormatException.a();
    }

    public final boolean a(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        this.f1844b.j(i2, i);
        return this.a.f(i2, i);
    }

    public final int b(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (a(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (a(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (a(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (a(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (a(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (a(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (a(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return a(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}
