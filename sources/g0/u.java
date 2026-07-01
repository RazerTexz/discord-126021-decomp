package g0;

import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import okio.ByteString;

/* JADX INFO: compiled from: SegmentedByteString.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class u extends ByteString {
    public final transient byte[][] n;
    public final transient int[] o;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(byte[][] bArr, int[] iArr) {
        super(ByteString.j.getData());
        d0.z.d.m.checkParameterIsNotNull(bArr, "segments");
        d0.z.d.m.checkParameterIsNotNull(iArr, "directory");
        this.n = bArr;
        this.o = iArr;
    }

    private final Object writeReplace() {
        return u();
    }

    @Override // okio.ByteString
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.j() == j() && n(0, byteString, 0, j())) {
                return true;
            }
        }
        return false;
    }

    @Override // okio.ByteString
    public String f() {
        return u().f();
    }

    @Override // okio.ByteString
    public ByteString g(String str) throws NoSuchAlgorithmException {
        d0.z.d.m.checkParameterIsNotNull(str, "algorithm");
        MessageDigest messageDigest = MessageDigest.getInstance(str);
        int length = this.n.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.o;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            messageDigest.update(this.n[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
        byte[] bArrDigest = messageDigest.digest();
        d0.z.d.m.checkExpressionValueIsNotNull(bArrDigest, "digest.digest()");
        return new ByteString(bArrDigest);
    }

    @Override // okio.ByteString
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int length = this.n.length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int[] iArr = this.o;
            int i5 = iArr[length + i2];
            int i6 = iArr[i2];
            byte[] bArr = this.n[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        this.hashCode = i3;
        return i3;
    }

    @Override // okio.ByteString
    public int j() {
        return this.o[this.n.length - 1];
    }

    @Override // okio.ByteString
    public String k() {
        return u().k();
    }

    @Override // okio.ByteString
    public byte[] l() {
        return t();
    }

    @Override // okio.ByteString
    public byte m(int i) {
        b.i.a.f.e.o.f.B(this.o[this.n.length - 1], i, 1L);
        int iA1 = b.i.a.f.e.o.f.a1(this, i);
        int i2 = iA1 == 0 ? 0 : this.o[iA1 - 1];
        int[] iArr = this.o;
        byte[][] bArr = this.n;
        return bArr[iA1][(i - i2) + iArr[bArr.length + iA1]];
    }

    @Override // okio.ByteString
    public boolean n(int i, ByteString byteString, int i2, int i3) {
        d0.z.d.m.checkParameterIsNotNull(byteString, "other");
        if (i < 0 || i > j() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iA1 = b.i.a.f.e.o.f.a1(this, i);
        while (i < i4) {
            int i5 = iA1 == 0 ? 0 : this.o[iA1 - 1];
            int[] iArr = this.o;
            int i6 = iArr[iA1] - i5;
            int i7 = iArr[this.n.length + iA1];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!byteString.o(i2, this.n[iA1], (i - i5) + i7, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iA1++;
        }
        return true;
    }

    @Override // okio.ByteString
    public boolean o(int i, byte[] bArr, int i2, int i3) {
        d0.z.d.m.checkParameterIsNotNull(bArr, "other");
        if (i < 0 || i > j() - i3 || i2 < 0 || i2 > bArr.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iA1 = b.i.a.f.e.o.f.a1(this, i);
        while (i < i4) {
            int i5 = iA1 == 0 ? 0 : this.o[iA1 - 1];
            int[] iArr = this.o;
            int i6 = iArr[iA1] - i5;
            int i7 = iArr[this.n.length + iA1];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!b.i.a.f.e.o.f.h(this.n[iA1], (i - i5) + i7, bArr, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iA1++;
        }
        return true;
    }

    @Override // okio.ByteString
    public ByteString p() {
        return u().p();
    }

    @Override // okio.ByteString
    public void r(OutputStream outputStream) throws IOException {
        d0.z.d.m.checkParameterIsNotNull(outputStream, "out");
        int length = this.n.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int[] iArr = this.o;
            int i3 = iArr[length + i];
            int i4 = iArr[i];
            outputStream.write(this.n[i], i3, i4 - i2);
            i++;
            i2 = i4;
        }
    }

    @Override // okio.ByteString
    public void s(e eVar, int i, int i2) {
        d0.z.d.m.checkParameterIsNotNull(eVar, "buffer");
        int i3 = i2 + i;
        int iA1 = b.i.a.f.e.o.f.a1(this, i);
        while (i < i3) {
            int i4 = iA1 == 0 ? 0 : this.o[iA1 - 1];
            int[] iArr = this.o;
            int i5 = iArr[iA1] - i4;
            int i6 = iArr[this.n.length + iA1];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = (i - i4) + i6;
            s sVar = new s(this.n[iA1], i7, i7 + iMin, true, false);
            s sVar2 = eVar.j;
            if (sVar2 == null) {
                sVar.g = sVar;
                sVar.f = sVar;
                eVar.j = sVar;
            } else {
                s sVar3 = sVar2.g;
                if (sVar3 == null) {
                    d0.z.d.m.throwNpe();
                }
                sVar3.b(sVar);
            }
            i += iMin;
            iA1++;
        }
        eVar.k += (long) j();
    }

    public byte[] t() {
        byte[] bArr = new byte[j()];
        int length = this.n.length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int[] iArr = this.o;
            int i4 = iArr[length + i];
            int i5 = iArr[i];
            int i6 = i5 - i2;
            d0.t.j.copyInto(this.n[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    @Override // okio.ByteString
    public String toString() {
        return u().toString();
    }

    public final ByteString u() {
        return new ByteString(t());
    }
}
