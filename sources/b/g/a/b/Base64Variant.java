package b.g.a.b;

import b.d.b.a.outline;
import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.g.a.b.a, reason: use source file name */
/* JADX INFO: compiled from: Base64Variant.java */
/* JADX INFO: loaded from: classes3.dex */
public final class Base64Variant implements Serializable {
    private static final long serialVersionUID = 1;
    private final int _maxLineLength;
    public final String _name;
    private final char _paddingChar;
    private final a _paddingReadBehaviour;
    private final boolean _writePadding;
    public final transient int[] j;
    public final transient char[] k;
    public final transient byte[] l;

    /* JADX INFO: renamed from: b.g.a.b.a$a */
    /* JADX INFO: compiled from: Base64Variant.java */
    public enum a {
        PADDING_FORBIDDEN,
        PADDING_REQUIRED,
        PADDING_ALLOWED
    }

    public Base64Variant(String str, String str2, boolean z2, char c, int i) {
        int[] iArr = new int[128];
        this.j = iArr;
        char[] cArr = new char[64];
        this.k = cArr;
        this.l = new byte[64];
        this._name = str;
        this._writePadding = z2;
        this._paddingChar = c;
        this._maxLineLength = i;
        int length = str2.length();
        if (length != 64) {
            throw new IllegalArgumentException(outline.r("Base64Alphabet length must be exactly 64 (was ", length, ")"));
        }
        str2.getChars(0, length, cArr, 0);
        Arrays.fill(iArr, -1);
        for (int i2 = 0; i2 < length; i2++) {
            char c2 = this.k[i2];
            this.l[i2] = (byte) c2;
            this.j[c2] = i2;
        }
        if (z2) {
            this.j[c] = -2;
        }
        this._paddingReadBehaviour = z2 ? a.PADDING_REQUIRED : a.PADDING_FORBIDDEN;
    }

    public String a(byte[] bArr) {
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
            sb.append(this.k[(i8 >> 18) & 63]);
            sb.append(this.k[(i8 >> 12) & 63]);
            sb.append(this.k[(i8 >> 6) & 63]);
            sb.append(this.k[i8 & 63]);
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
            sb.append(this.k[(i11 >> 18) & 63]);
            sb.append(this.k[(i11 >> 12) & 63]);
            if (this._writePadding) {
                sb.append(i9 == 2 ? this.k[(i11 >> 6) & 63] : this._paddingChar);
                sb.append(this._paddingChar);
            } else if (i9 == 2) {
                sb.append(this.k[(i11 >> 6) & 63]);
            }
        }
        return sb.toString();
    }

    public int b(int i, char[] cArr, int i2) {
        int i3 = i2 + 1;
        char[] cArr2 = this.k;
        cArr[i2] = cArr2[(i >> 18) & 63];
        int i4 = i3 + 1;
        cArr[i3] = cArr2[(i >> 12) & 63];
        int i5 = i4 + 1;
        cArr[i4] = cArr2[(i >> 6) & 63];
        int i6 = i5 + 1;
        cArr[i5] = cArr2[i & 63];
        return i6;
    }

    public int c(int i, int i2, char[] cArr, int i3) {
        int i4 = i3 + 1;
        char[] cArr2 = this.k;
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

    public int d() {
        return this._maxLineLength;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != Base64Variant.class) {
            return false;
        }
        Base64Variant base64Variant = (Base64Variant) obj;
        return base64Variant._paddingChar == this._paddingChar && base64Variant._maxLineLength == this._maxLineLength && base64Variant._writePadding == this._writePadding && base64Variant._paddingReadBehaviour == this._paddingReadBehaviour && this._name.equals(base64Variant._name);
    }

    public int hashCode() {
        return this._name.hashCode();
    }

    public Object readResolve() {
        String str = this._name;
        Base64Variant base64Variant = Base64Variants.a;
        if (!base64Variant._name.equals(str)) {
            base64Variant = Base64Variants.f656b;
            if (!base64Variant._name.equals(str)) {
                base64Variant = Base64Variants.c;
                if (!base64Variant._name.equals(str)) {
                    base64Variant = Base64Variants.d;
                    if (!base64Variant._name.equals(str)) {
                        throw new IllegalArgumentException(outline.w("No Base64Variant with name ", str == null ? "<null>" : outline.y("'", str, "'")));
                    }
                }
            }
        }
        Base64Variant base64Variant2 = base64Variant;
        boolean z2 = this._writePadding;
        boolean z3 = base64Variant2._writePadding;
        return (z2 == z3 && this._paddingChar == base64Variant2._paddingChar && this._paddingReadBehaviour == base64Variant2._paddingReadBehaviour && this._maxLineLength == base64Variant2._maxLineLength && z2 == z3) ? base64Variant2 : new Base64Variant(base64Variant2, this._name, z2, this._paddingChar, this._paddingReadBehaviour, this._maxLineLength);
    }

    public String toString() {
        return this._name;
    }

    public Base64Variant(Base64Variant base64Variant, String str, int i) {
        this(base64Variant, str, base64Variant._writePadding, base64Variant._paddingChar, base64Variant._paddingReadBehaviour, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z2, char c, int i) {
        this(base64Variant, str, z2, c, base64Variant._paddingReadBehaviour, i);
    }

    public Base64Variant(Base64Variant base64Variant, String str, boolean z2, char c, a aVar, int i) {
        int[] iArr = new int[128];
        this.j = iArr;
        char[] cArr = new char[64];
        this.k = cArr;
        byte[] bArr = new byte[64];
        this.l = bArr;
        this._name = str;
        byte[] bArr2 = base64Variant.l;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        char[] cArr2 = base64Variant.k;
        System.arraycopy(cArr2, 0, cArr, 0, cArr2.length);
        int[] iArr2 = base64Variant.j;
        System.arraycopy(iArr2, 0, iArr, 0, iArr2.length);
        this._writePadding = z2;
        this._paddingChar = c;
        this._maxLineLength = i;
        this._paddingReadBehaviour = aVar;
    }
}
