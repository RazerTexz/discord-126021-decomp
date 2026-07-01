package d0.e0.p.d.m0.i;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;

/* JADX INFO: compiled from: LiteralByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends c {
    public final byte[] k;
    public int l = 0;

    public m(byte[] bArr) {
        this.k = bArr;
    }

    @Override // d0.e0.p.d.m0.i.c
    public void d(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.k, i, bArr, i2, i3);
    }

    @Override // d0.e0.p.d.m0.i.c
    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof c) || size() != ((c) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof m) {
            return l((m) obj, 0, size());
        }
        if (obj instanceof r) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(b.d.b.a.a.J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    @Override // d0.e0.p.d.m0.i.c
    public boolean g() {
        return true;
    }

    @Override // d0.e0.p.d.m0.i.c
    public int h(int i, int i2, int i3) {
        byte[] bArr = this.k;
        int iM = m() + i2;
        for (int i4 = iM; i4 < iM + i3; i4++) {
            i = (i * 31) + bArr[i4];
        }
        return i;
    }

    public int hashCode() {
        int iH = this.l;
        if (iH == 0) {
            int size = size();
            iH = h(size, 0, size);
            if (iH == 0) {
                iH = 1;
            }
            this.l = iH;
        }
        return iH;
    }

    @Override // d0.e0.p.d.m0.i.c
    public int i(int i, int i2, int i3) {
        int iM = m() + i2;
        return v.partialIsValidUtf8(i, this.k, iM, i3 + iM);
    }

    @Override // d0.e0.p.d.m0.i.c
    public boolean isValidUtf8() {
        int iM = m();
        return v.isValidUtf8(this.k, iM, size() + iM);
    }

    @Override // d0.e0.p.d.m0.i.c, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Iterator<Byte> iterator2() {
        return iterator();
    }

    @Override // d0.e0.p.d.m0.i.c
    public int j() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.i.c
    public void k(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.k, m() + i, i2);
    }

    public boolean l(m mVar, int i, int i2) {
        if (i2 > mVar.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i2 > mVar.size()) {
            int size2 = mVar.size();
            StringBuilder sb2 = new StringBuilder(59);
            sb2.append("Ran off end of other: ");
            sb2.append(i);
            sb2.append(", ");
            sb2.append(i2);
            sb2.append(", ");
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
        byte[] bArr = this.k;
        byte[] bArr2 = mVar.k;
        int iM = m() + i2;
        int iM2 = m();
        int iM3 = mVar.m() + i;
        while (iM2 < iM) {
            if (bArr[iM2] != bArr2[iM3]) {
                return false;
            }
            iM2++;
            iM3++;
        }
        return true;
    }

    public int m() {
        return 0;
    }

    @Override // d0.e0.p.d.m0.i.c
    public int size() {
        return this.k.length;
    }

    @Override // d0.e0.p.d.m0.i.c
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.k, m(), size(), str);
    }

    @Override // d0.e0.p.d.m0.i.c, java.lang.Iterable
    public Iterator<Byte> iterator() {
        return new m$b(this, null);
    }
}
