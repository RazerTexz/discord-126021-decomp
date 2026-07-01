package h0.a.a;

import b.d.b.a.outline;
import org.objectweb.asm.Opcodes;

/* JADX INFO: renamed from: h0.a.a.v, reason: use source file name */
/* JADX INFO: compiled from: SymbolTable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SymbolTable2 {
    public final ClassWriter2 a;
    public int c;
    public String d;
    public int e;
    public int i;
    public ByteVector2 j;
    public int k;
    public a[] l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassReader2 f3725b = null;
    public a[] f = new a[256];
    public int g = 1;
    public ByteVector2 h = new ByteVector2();

    public SymbolTable2(ClassWriter2 classWriter2) {
        this.a = classWriter2;
    }

    public static int r(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    public static int s(int i, String str, String str2, int i2) {
        return Integer.MAX_VALUE & (((i2 + 1) * str2.hashCode() * str.hashCode()) + i);
    }

    public static int t(int i, String str, String str2, String str3) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i);
    }

    public static int u(int i, String str, String str2, String str3, int i2) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode() * i2) + i);
    }

    public Symbol2 a(Handle2 handle2, Object... objArr) {
        boolean z2;
        ByteVector2 byteVector2 = this.j;
        if (byteVector2 == null) {
            byteVector2 = new ByteVector2();
            this.j = byteVector2;
        }
        for (Object obj : objArr) {
            b(obj);
        }
        int i = byteVector2.f3699b;
        byteVector2.j(i(handle2.a, handle2.f3712b, handle2.c, handle2.d, handle2.e).a);
        byteVector2.j(objArr.length);
        for (Object obj2 : objArr) {
            byteVector2.j(b(obj2).a);
        }
        int i2 = byteVector2.f3699b - i;
        int iHashCode = handle2.hashCode();
        for (Object obj3 : objArr) {
            iHashCode ^= obj3.hashCode();
        }
        int i3 = iHashCode & Integer.MAX_VALUE;
        byte[] bArr = this.j.a;
        a[] aVarArr = this.f;
        for (a aVar = aVarArr[i3 % aVarArr.length]; aVar != null; aVar = aVar.i) {
            if (aVar.f3724b == 64 && aVar.h == i3) {
                int i4 = (int) aVar.f;
                int i5 = 0;
                while (true) {
                    if (i5 >= i2) {
                        z2 = true;
                        break;
                    }
                    if (bArr[i + i5] != bArr[i4 + i5]) {
                        z2 = false;
                        break;
                    }
                    i5++;
                }
                if (z2) {
                    this.j.f3699b = i;
                    return aVar;
                }
            }
        }
        int i6 = this.i;
        this.i = i6 + 1;
        a aVar2 = new a(i6, 64, i, i3);
        v(aVar2);
        return aVar2;
    }

    public Symbol2 b(Object obj) {
        if (obj instanceof Integer) {
            return e(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return e(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return e(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return e(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return e(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return f(4, Float.floatToRawIntBits(((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return g(5, ((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return g(6, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
        }
        if (obj instanceof String) {
            return m(8, (String) obj);
        }
        if (obj instanceof Type2) {
            Type2 type2 = (Type2) obj;
            int i = type2.i();
            if (i == 10) {
                return c(type2.g());
            }
            return i == 11 ? m(16, type2.d()) : c(type2.d());
        }
        if (obj instanceof Handle2) {
            Handle2 handle2 = (Handle2) obj;
            return i(handle2.a, handle2.f3712b, handle2.c, handle2.d, handle2.e);
        }
        if (!(obj instanceof ConstantDynamic2)) {
            throw new IllegalArgumentException(outline.v("value ", obj));
        }
        ConstantDynamic2 constantDynamic2 = (ConstantDynamic2) obj;
        return d(17, constantDynamic2.a, constantDynamic2.f3706b, a(constantDynamic2.c, constantDynamic2.d).a);
    }

    public Symbol2 c(String str) {
        return m(7, str);
    }

    public final Symbol2 d(int i, String str, String str2, int i2) {
        int iS = s(i, str, str2, i2);
        for (a aVarQ = q(iS); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == i && aVarQ.h == iS && aVarQ.f == i2 && aVarQ.d.equals(str) && aVarQ.e.equals(str2)) {
                return aVarQ;
            }
        }
        this.h.f(i, i2, k(str, str2));
        int i3 = this.g;
        this.g = i3 + 1;
        a aVar = new a(i3, i, null, str, str2, i2, iS);
        v(aVar);
        return aVar;
    }

    public Symbol2 e(int i) {
        return f(3, i);
    }

    public final Symbol2 f(int i, int i2) {
        int iR = r(i, i2);
        for (a aVarQ = q(iR); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == i && aVarQ.h == iR && aVarQ.f == i2) {
                return aVarQ;
            }
        }
        ByteVector2 byteVector2 = this.h;
        byteVector2.g(i);
        byteVector2.i(i2);
        int i3 = this.g;
        this.g = i3 + 1;
        a aVar = new a(i3, i, i2, iR);
        v(aVar);
        return aVar;
    }

    public final Symbol2 g(int i, long j) {
        int i2 = (int) j;
        int i3 = (int) (j >>> 32);
        int i4 = (i + i2 + i3) & Integer.MAX_VALUE;
        for (a aVarQ = q(i4); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == i && aVarQ.h == i4 && aVarQ.f == j) {
                return aVarQ;
            }
        }
        int i5 = this.g;
        ByteVector2 byteVector2 = this.h;
        byteVector2.g(i);
        int i6 = byteVector2.f3699b;
        if (i6 + 8 > byteVector2.a.length) {
            byteVector2.b(8);
        }
        byte[] bArr = byteVector2.a;
        int i7 = i6 + 1;
        bArr[i6] = (byte) (i3 >>> 24);
        int i8 = i7 + 1;
        bArr[i7] = (byte) (i3 >>> 16);
        int i9 = i8 + 1;
        bArr[i8] = (byte) (i3 >>> 8);
        int i10 = i9 + 1;
        bArr[i9] = (byte) i3;
        int i11 = i10 + 1;
        bArr[i10] = (byte) (i2 >>> 24);
        int i12 = i11 + 1;
        bArr[i11] = (byte) (i2 >>> 16);
        int i13 = i12 + 1;
        bArr[i12] = (byte) (i2 >>> 8);
        bArr[i13] = (byte) i2;
        byteVector2.f3699b = i13 + 1;
        this.g += 2;
        a aVar = new a(i5, i, j, i4);
        v(aVar);
        return aVar;
    }

    public final a h(int i, String str, String str2, String str3) {
        int iT = t(i, str, str2, str3);
        for (a aVarQ = q(iT); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == i && aVarQ.h == iT && aVarQ.c.equals(str) && aVarQ.d.equals(str2) && aVarQ.e.equals(str3)) {
                return aVarQ;
            }
        }
        this.h.f(i, m(7, str).a, k(str2, str3));
        int i2 = this.g;
        this.g = i2 + 1;
        a aVar = new a(i2, i, str, str2, str3, 0L, iT);
        v(aVar);
        return aVar;
    }

    public Symbol2 i(int i, String str, String str2, String str3, boolean z2) {
        int iU = u(15, str, str2, str3, i);
        for (a aVarQ = q(iU); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == 15 && aVarQ.h == iU && aVarQ.f == i && aVarQ.c.equals(str) && aVarQ.d.equals(str2) && aVarQ.e.equals(str3)) {
                return aVarQ;
            }
        }
        if (i <= 4) {
            this.h.d(15, i, h(9, str, str2, str3).a);
        } else {
            this.h.d(15, i, h(z2 ? 11 : 10, str, str2, str3).a);
        }
        int i2 = this.g;
        this.g = i2 + 1;
        a aVar = new a(i2, 15, str, str2, str3, i, iU);
        v(aVar);
        return aVar;
    }

    public Symbol2 j(String str) {
        return m(19, str);
    }

    public int k(String str, String str2) {
        int iHashCode = ((str2.hashCode() * str.hashCode()) + 12) & Integer.MAX_VALUE;
        for (a aVarQ = q(iHashCode); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == 12 && aVarQ.h == iHashCode && aVarQ.d.equals(str) && aVarQ.e.equals(str2)) {
                return aVarQ.a;
            }
        }
        this.h.f(12, l(str), l(str2));
        int i = this.g;
        this.g = i + 1;
        v(new a(i, 12, str, str2, iHashCode));
        return i;
    }

    public int l(String str) {
        int iHashCode = (str.hashCode() + 1) & Integer.MAX_VALUE;
        for (a aVarQ = q(iHashCode); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == 1 && aVarQ.h == iHashCode && aVarQ.e.equals(str)) {
                return aVarQ.a;
            }
        }
        ByteVector2 byteVector2 = this.h;
        byteVector2.g(1);
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i = byteVector2.f3699b;
        if (i + 2 + length > byteVector2.a.length) {
            byteVector2.b(length + 2);
        }
        byte[] bArr = byteVector2.a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i2 + 1;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 1 || cCharAt > 127) {
                byteVector2.f3699b = i3;
                byteVector2.a(str, i4, 65535);
                int i5 = this.g;
                this.g = i5 + 1;
                v(new a(i5, 1, str, iHashCode));
                return i5;
            }
            bArr[i3] = (byte) cCharAt;
            i4++;
            i3++;
        }
        byteVector2.f3699b = i3;
        int i6 = this.g;
        this.g = i6 + 1;
        v(new a(i6, 1, str, iHashCode));
        return i6;
    }

    public final Symbol2 m(int i, String str) {
        int iHashCode = (str.hashCode() + i) & Integer.MAX_VALUE;
        for (a aVarQ = q(iHashCode); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == i && aVarQ.h == iHashCode && aVarQ.e.equals(str)) {
                return aVarQ;
            }
        }
        this.h.e(i, l(str));
        int i2 = this.g;
        this.g = i2 + 1;
        a aVar = new a(i2, i, str, iHashCode);
        v(aVar);
        return aVar;
    }

    public int n(String str) {
        int iHashCode = (str.hashCode() + 128) & Integer.MAX_VALUE;
        for (a aVarQ = q(iHashCode); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == 128 && aVarQ.h == iHashCode && aVarQ.e.equals(str)) {
                return aVarQ.a;
            }
        }
        return o(new a(this.k, 128, str, iHashCode));
    }

    public final int o(a aVar) {
        if (this.l == null) {
            this.l = new a[16];
        }
        int i = this.k;
        a[] aVarArr = this.l;
        if (i == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.l = aVarArr2;
        }
        a[] aVarArr3 = this.l;
        int i2 = this.k;
        this.k = i2 + 1;
        aVarArr3[i2] = aVar;
        v(aVar);
        return aVar.a;
    }

    public int p(String str, int i) {
        int iHashCode = (str.hashCode() + Opcodes.LOR + i) & Integer.MAX_VALUE;
        for (a aVarQ = q(iHashCode); aVarQ != null; aVarQ = aVarQ.i) {
            if (aVarQ.f3724b == 129 && aVarQ.h == iHashCode && aVarQ.f == i && aVarQ.e.equals(str)) {
                return aVarQ.a;
            }
        }
        return o(new a(this.k, Opcodes.LOR, str, i, iHashCode));
    }

    public final a q(int i) {
        a[] aVarArr = this.f;
        return aVarArr[i % aVarArr.length];
    }

    public final a v(a aVar) {
        int i = this.e;
        a[] aVarArr = this.f;
        if (i > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i2 = (length * 2) + 1;
            a[] aVarArr2 = new a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                a aVar2 = this.f[i3];
                while (aVar2 != null) {
                    int i4 = aVar2.h % i2;
                    a aVar3 = aVar2.i;
                    aVar2.i = aVarArr2[i4];
                    aVarArr2[i4] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f = aVarArr2;
        }
        this.e++;
        int i5 = aVar.h;
        a[] aVarArr3 = this.f;
        int length2 = i5 % aVarArr3.length;
        aVar.i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    /* JADX INFO: renamed from: h0.a.a.v$a */
    /* JADX INFO: compiled from: SymbolTable.java */
    public static class a extends Symbol2 {
        public final int h;
        public a i;

        public a(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.h = i3;
        }

        public a(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.h = i3;
        }

        public a(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.h = i3;
        }

        public a(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.h = i3;
        }

        public a(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.h = i3;
        }
    }
}
