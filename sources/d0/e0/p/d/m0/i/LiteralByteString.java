package d0.e0.p.d.m0.i;

import b.d.b.a.outline;
import d0.e0.p.d.m0.i.ByteString3;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: renamed from: d0.e0.p.d.m0.i.m, reason: use source file name */
/* JADX INFO: compiled from: LiteralByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class LiteralByteString extends ByteString3 {
    public final byte[] k;
    public int l = 0;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.i.m$b */
    /* JADX INFO: compiled from: LiteralByteString.java */
    public class b implements ByteString3.a {
        public int j = 0;
        public final int k;

        public b(a aVar) {
            this.k = LiteralByteString.this.size();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.j < this.k;
        }

        @Override // d0.e0.p.d.m0.i.ByteString3.a
        public byte nextByte() {
            try {
                byte[] bArr = LiteralByteString.this.k;
                int i = this.j;
                this.j = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Byte next() {
            return Byte.valueOf(nextByte());
        }
    }

    public LiteralByteString(byte[] bArr) {
        this.k = bArr;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public void d(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.k, i, bArr, i2, i3);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int e() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString3) || size() != ((ByteString3) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (obj instanceof LiteralByteString) {
            return l((LiteralByteString) obj, 0, size());
        }
        if (obj instanceof RopeByteString) {
            return obj.equals(this);
        }
        String strValueOf = String.valueOf(obj.getClass());
        throw new IllegalArgumentException(outline.J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public boolean g() {
        return true;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
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

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int i(int i, int i2, int i3) {
        int iM = m() + i2;
        return Utf8.partialIsValidUtf8(i, this.k, iM, i3 + iM);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public boolean isValidUtf8() {
        int iM = m();
        return Utf8.isValidUtf8(this.k, iM, size() + iM);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int j() {
        return this.l;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public void k(OutputStream outputStream, int i, int i2) throws IOException {
        outputStream.write(this.k, m() + i, i2);
    }

    public boolean l(LiteralByteString literalByteString, int i, int i2) {
        if (i2 > literalByteString.size()) {
            int size = size();
            StringBuilder sb = new StringBuilder(40);
            sb.append("Length too large: ");
            sb.append(i2);
            sb.append(size);
            throw new IllegalArgumentException(sb.toString());
        }
        if (i + i2 > literalByteString.size()) {
            int size2 = literalByteString.size();
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
        byte[] bArr2 = literalByteString.k;
        int iM = m() + i2;
        int iM2 = m();
        int iM3 = literalByteString.m() + i;
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

    @Override // d0.e0.p.d.m0.i.ByteString3
    public int size() {
        return this.k.length;
    }

    @Override // d0.e0.p.d.m0.i.ByteString3
    public String toString(String str) throws UnsupportedEncodingException {
        return new String(this.k, m(), size(), str);
    }

    @Override // d0.e0.p.d.m0.i.ByteString3, java.lang.Iterable
    /* JADX INFO: renamed from: iterator, reason: merged with bridge method [inline-methods] */
    public Iterator<Byte> iterator2() {
        return new b(null);
    }
}
