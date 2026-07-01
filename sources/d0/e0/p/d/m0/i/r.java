package d0.e0.p.d.m0.i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class r extends c {
    public static final int[] k;
    public final int l;
    public final c m;
    public final c n;
    public final int o;
    public final int p;
    public int q = 0;

    static {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.MAX_VALUE);
        k = new int[arrayList.size()];
        int i4 = 0;
        while (true) {
            int[] iArr = k;
            if (i4 >= iArr.length) {
                return;
            }
            iArr[i4] = ((Integer) arrayList.get(i4)).intValue();
            i4++;
        }
    }

    public r(c cVar, c cVar2) {
        this.m = cVar;
        this.n = cVar2;
        int size = cVar.size();
        this.o = size;
        this.l = cVar2.size() + size;
        this.p = Math.max(cVar.e(), cVar2.e()) + 1;
    }

    public static m l(c cVar, c cVar2) {
        int size = cVar.size();
        int size2 = cVar2.size();
        byte[] bArr = new byte[size + size2];
        cVar.copyTo(bArr, 0, 0, size);
        cVar2.copyTo(bArr, 0, size, size2);
        return new m(bArr);
    }

    @Override // d0.e0.p.d.m0.i.c
    public void d(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            this.m.d(bArr, i, i2, i3);
        } else {
            if (i >= i5) {
                this.n.d(bArr, i - i5, i2, i3);
                return;
            }
            int i6 = i5 - i;
            this.m.d(bArr, i, i2, i6);
            this.n.d(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    @Override // d0.e0.p.d.m0.i.c
    public int e() {
        return this.p;
    }

    public boolean equals(Object obj) {
        int iJ;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (this.l != cVar.size()) {
            return false;
        }
        if (this.l == 0) {
            return true;
        }
        if (this.q != 0 && (iJ = cVar.j()) != 0 && this.q != iJ) {
            return false;
        }
        r$c r_c = new r$c(this, null);
        m next = r_c.next();
        r$c r_c2 = new r$c(cVar, null);
        m next2 = r_c2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = next.size() - i;
            int size2 = next2.size() - i2;
            int iMin = Math.min(size, size2);
            if (!(i == 0 ? next.l(next2, i2, iMin) : next2.l(next, i, iMin))) {
                return false;
            }
            i3 += iMin;
            int i4 = this.l;
            if (i3 >= i4) {
                if (i3 == i4) {
                    return true;
                }
                throw new IllegalStateException();
            }
            if (iMin == size) {
                next = r_c.next();
                i = 0;
            } else {
                i += iMin;
            }
            if (iMin == size2) {
                next2 = r_c2.next();
                i2 = 0;
            } else {
                i2 += iMin;
            }
        }
    }

    @Override // d0.e0.p.d.m0.i.c
    public boolean g() {
        return this.l >= k[this.p];
    }

    @Override // d0.e0.p.d.m0.i.c
    public int h(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            return this.m.h(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.n.h(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.n.h(this.m.h(i, i2, i6), 0, i3 - i6);
    }

    public int hashCode() {
        int iH = this.q;
        if (iH == 0) {
            int i = this.l;
            iH = h(i, 0, i);
            if (iH == 0) {
                iH = 1;
            }
            this.q = iH;
        }
        return iH;
    }

    @Override // d0.e0.p.d.m0.i.c
    public int i(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.o;
        if (i4 <= i5) {
            return this.m.i(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.n.i(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.n.i(this.m.i(i, i2, i6), 0, i3 - i6);
    }

    @Override // d0.e0.p.d.m0.i.c
    public boolean isValidUtf8() {
        int i = this.m.i(0, 0, this.o);
        c cVar = this.n;
        return cVar.i(i, 0, cVar.size()) == 0;
    }

    @Override // d0.e0.p.d.m0.i.c, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // d0.e0.p.d.m0.i.c
    public int j() {
        return this.q;
    }

    @Override // d0.e0.p.d.m0.i.c
    public void k(OutputStream outputStream, int i, int i2) throws IOException {
        int i3 = i + i2;
        int i4 = this.o;
        if (i3 <= i4) {
            this.m.k(outputStream, i, i2);
        } else {
            if (i >= i4) {
                this.n.k(outputStream, i - i4, i2);
                return;
            }
            int i5 = i4 - i;
            this.m.k(outputStream, i, i5);
            this.n.k(outputStream, 0, i2 - i5);
        }
    }

    @Override // d0.e0.p.d.m0.i.c
    public int size() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.i.c
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(toByteArray(), str);
    }

    @Override // d0.e0.p.d.m0.i.c, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new r$d(this, null);
    }
}
