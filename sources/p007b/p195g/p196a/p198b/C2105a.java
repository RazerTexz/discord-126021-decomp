package p007b.p195g.p196a.p198b;

import java.io.Serializable;
import java.util.Arrays;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.g.a.b.a */
/* JADX INFO: compiled from: Base64Variant.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2105a implements Serializable {
    private static final long serialVersionUID = 1;
    private final int _maxLineLength;
    public final String _name;
    private final char _paddingChar;
    private final a _paddingReadBehaviour;
    private final boolean _writePadding;

    /* JADX INFO: renamed from: j */
    public final transient int[] f4444j;

    /* JADX INFO: renamed from: k */
    public final transient char[] f4445k;

    /* JADX INFO: renamed from: l */
    public final transient byte[] f4446l;

    /* JADX INFO: renamed from: b.g.a.b.a$a */
    /* JADX INFO: compiled from: Base64Variant.java */
    public enum a {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public C2105a(String str, String str2, boolean z2, char c, int i) {
        int[] iArr = new int[128];
        this.f4444j = iArr;
        char[] cArr = new char[64];
        this.f4445k = cArr;
        this.f4446l = new byte[64];
        this._name = str;
        this._writePadding = z2;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException(C1643a.m873r("Base64Alphabet length must be exactly 64 (was ", length, ")"));
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = this.f4445k[i2];
            this.f4446l[i2] = (byte) c2;
            this.f4444j[c2] = i2;
        }
        if (z2) {
            this.f4444j[c] = -2;
        }
        this._paddingReadBehaviour = z2 ? a.PADDING_REQUIRED : a.PADDING_FORBIDDEN;
    }

    /* JADX INFO: renamed from: a */
    public String m1622a(byte[] bArr) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        int i = this._maxLineLength >> 2;
        int i2 = 0;
        int i3 = length - 3;
        while (i2 <= i3) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = ((bArr[i2] << 8) | (bArr[i4] & 255)) << 8;
            int i7 = i5 + 1;
            int i8 = i6 | (bArr[i5] & 255);
            sb.append(this.f4445k[(i8 >> 18) & 63]);
            sb.append(this.f4445k[(i8 >> 12) & 63]);
            sb.append(this.f4445k[(i8 >> 6) & 63]);
            sb.append(this.f4445k[i8 & 63]);
            i--;
            if (i <= 0) {
                sb.append('\\');
                sb.append('n');
                i = this._maxLineLength >> 2;
            }
            i2 = i7;
        }
        int i9 = length - i2;
        if (i9 > 0) {
            int i10 = i2 + 1;
            int i11 = bArr[i2] << 16;
            if (i9 == 2) {
                i11 |= (bArr[i10] & 255) << 8;
            }
            sb.append(this.f4445k[(i11 >> 18) & 63]);
            sb.append(this.f4445k[(i11 >> 12) & 63]);
            if (this._writePadding) {
                sb.append(i9 == 2 ? this.f4445k[(i11 >> 6) & 63] : this._paddingChar);
                sb.append(this._paddingChar);
            } else if (i9 == 2) {
                sb.append(this.f4445k[(i11 >> 6) & 63]);
            }
        }
        return sb.toString();
    }

    /* JADX INFO: renamed from: b */
    public int m1623b(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        char[] cArr2 = this.f4445k;
        cArr[i2] = cArr2[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = cArr2[(i >> 12) & 63];
        int i5 = i4 + 1;
        cArr[i4] = cArr2[(i >> 6) & 63];
        int i6 = i5 + 1;
        cArr[i5] = cArr2[i & 63];
        return i6;
    }

    /* JADX INFO: renamed from: c */
    public int m1624c(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        char[] cArr2 = this.f4445k;
        cArr[i3] = cArr2[(i >> 18) & 63];
        int i5 = i4 + 1;
        cArr[i4] = cArr2[(i >> 12) & 63];
        if (this._writePadding) {
            int i6 = i5 + 1;
            cArr[i5] = i2 == 2 ? cArr2[(i >> 6) & 63] : this._paddingChar;
            int i7 = i6 + 1;
            cArr[i6] = this._paddingChar;
            return i7;
        }
        if (i2 != 2) {
            return i5;
        }
        int i8 = i5 + 1;
        cArr[i5] = cArr2[(i >> 6) & 63];
        return i8;
    }

    /* JADX INFO: renamed from: d */
    public int m1625d() {
        return this._maxLineLength;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != C2105a.class) {
            return false;
        }
        C2105a c2105a = (C2105a) obj;
        return c2105a._paddingChar == this._paddingChar && c2105a._maxLineLength == this._maxLineLength && c2105a._writePadding == this._writePadding && c2105a._paddingReadBehaviour == this._paddingReadBehaviour && this._name.equals(c2105a._name);
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public Object readResolve() {
        String str = this._name;
        C2105a c2105a = C2106b.f4451a;
        if (!c2105a._name.equals(str)) {
            c2105a = C2106b.f4452b;
            if (!c2105a._name.equals(str)) {
                c2105a = C2106b.f4453c;
                if (!c2105a._name.equals(str)) {
                    c2105a = C2106b.f4454d;
                    if (!c2105a._name.equals(str)) {
                        throw new IllegalArgumentException(C1643a.m883w("No Base64Variant with name ", str == null ? "<null>" : C1643a.m886y("'", str, "'")));
                    }
                }
            }
        }
        C2105a c2105a2 = c2105a;
        boolean z2 = this._writePadding;
        boolean z3 = c2105a2._writePadding;
        return (z2 == z3 && this._paddingChar == c2105a2._paddingChar && this._paddingReadBehaviour == c2105a2._paddingReadBehaviour && this._maxLineLength == c2105a2._maxLineLength && z2 == z3) ? c2105a2 : new C2105a(c2105a2, this._name, z2, this._paddingChar, this._paddingReadBehaviour, this._maxLineLength);
    }

    public String toString() {
        return this._name;
    }

    public C2105a(C2105a c2105a, String str, int i) {
        this(c2105a, str, c2105a._writePadding, c2105a._paddingChar, c2105a._paddingReadBehaviour, i);
    }

    public C2105a(C2105a c2105a, String str, boolean z2, char c, int i) {
        this(c2105a, str, z2, c, c2105a._paddingReadBehaviour, i);
    }

    public C2105a(C2105a c2105a, String str, boolean z2, char c, a aVar, int i) {
        int[] iArr = new int[128];
        this.f4444j = iArr;
        char[] cArr = new char[64];
        this.f4445k = cArr;
        byte[] bArr = new byte[64];
        this.f4446l = bArr;
        this._name = str;
        byte[] bArr2 = c2105a.f4446l;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = c2105a.f4445k;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = c2105a.f4444j;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._writePadding = z2;
        this._paddingChar = c;
        this._maxLineLength = i;
        this._paddingReadBehaviour = aVar;
    }
}
