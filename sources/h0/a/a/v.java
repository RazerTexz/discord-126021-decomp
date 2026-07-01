package h0.a.a;

import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: SymbolTable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class v {
    public final f a;
    public int c;
    public String d;
    public int e;
    public int i;
    public c j;
    public int k;
    public v$a[] l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final d f3725b = null;
    public v$a[] f = new v$a[256];
    public int g = 1;
    public c h = new c();

    public v(f fVar) {
        this.a = fVar;
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

    public u a(n nVar, Object... objArr) {
        boolean z2;
        c cVar = this.j;
        if (cVar == null) {
            cVar = new c();
            this.j = cVar;
        }
        for (Object obj : objArr) {
            b(obj);
        }
        int i = cVar.f3699b;
        cVar.j(i(nVar.a, nVar.f3712b, nVar.c, nVar.d, nVar.e).a);
        cVar.j(objArr.length);
        for (Object obj2 : objArr) {
            cVar.j(b(obj2).a);
        }
        int i2 = cVar.f3699b - i;
        int iHashCode = nVar.hashCode();
        for (Object obj3 : objArr) {
            iHashCode ^= obj3.hashCode();
        }
        int i3 = iHashCode & Integer.MAX_VALUE;
        byte[] bArr = this.j.a;
        v$a[] v_aArr = this.f;
        for (v$a v_a = v_aArr[i3 % v_aArr.length]; v_a != null; v_a = v_a.i) {
            if (v_a.f3724b == 64 && v_a.h == i3) {
                int i4 = (int) v_a.f;
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
                    return v_a;
                }
            }
        }
        int i6 = this.i;
        this.i = i6 + 1;
        v$a v_a2 = new v$a(i6, 64, i, i3);
        v(v_a2);
        return v_a2;
    }

    public u b(Object obj) {
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
        if (obj instanceof w) {
            w wVar = (w) obj;
            int i = wVar.i();
            if (i == 10) {
                return c(wVar.g());
            }
            return i == 11 ? m(16, wVar.d()) : c(wVar.d());
        }
        if (obj instanceof n) {
            n nVar = (n) obj;
            return i(nVar.a, nVar.f3712b, nVar.c, nVar.d, nVar.e);
        }
        if (!(obj instanceof g)) {
            throw new IllegalArgumentException(b.d.b.a.a.v("value ", obj));
        }
        g gVar = (g) obj;
        return d(17, gVar.a, gVar.f3706b, a(gVar.c, gVar.d).a);
    }

    public u c(String str) {
        return m(7, str);
    }

    public final u d(int i, String str, String str2, int i2) {
        int iS = s(i, str, str2, i2);
        for (v$a v_aQ = q(iS); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == i && v_aQ.h == iS && v_aQ.f == i2 && v_aQ.d.equals(str) && v_aQ.e.equals(str2)) {
                return v_aQ;
            }
        }
        this.h.f(i, i2, k(str, str2));
        int i3 = this.g;
        this.g = i3 + 1;
        v$a v_a = new v$a(i3, i, null, str, str2, i2, iS);
        v(v_a);
        return v_a;
    }

    public u e(int i) {
        return f(3, i);
    }

    public final u f(int i, int i2) {
        int iR = r(i, i2);
        for (v$a v_aQ = q(iR); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == i && v_aQ.h == iR && v_aQ.f == i2) {
                return v_aQ;
            }
        }
        c cVar = this.h;
        cVar.g(i);
        cVar.i(i2);
        int i3 = this.g;
        this.g = i3 + 1;
        v$a v_a = new v$a(i3, i, i2, iR);
        v(v_a);
        return v_a;
    }

    public final u g(int i, long j) {
        int i2 = (int) j;
        int i3 = (int) (j >>> 32);
        int i4 = (i + i2 + i3) & Integer.MAX_VALUE;
        for (v$a v_aQ = q(i4); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == i && v_aQ.h == i4 && v_aQ.f == j) {
                return v_aQ;
            }
        }
        int i5 = this.g;
        c cVar = this.h;
        cVar.g(i);
        int i6 = cVar.f3699b;
        if (i6 + 8 > cVar.a.length) {
            cVar.b(8);
        }
        byte[] bArr = cVar.a;
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
        cVar.f3699b = i13 + 1;
        this.g += 2;
        v$a v_a = new v$a(i5, i, j, i4);
        v(v_a);
        return v_a;
    }

    public final v$a h(int i, String str, String str2, String str3) {
        int iT = t(i, str, str2, str3);
        for (v$a v_aQ = q(iT); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == i && v_aQ.h == iT && v_aQ.c.equals(str) && v_aQ.d.equals(str2) && v_aQ.e.equals(str3)) {
                return v_aQ;
            }
        }
        this.h.f(i, m(7, str).a, k(str2, str3));
        int i2 = this.g;
        this.g = i2 + 1;
        v$a v_a = new v$a(i2, i, str, str2, str3, 0L, iT);
        v(v_a);
        return v_a;
    }

    public u i(int i, String str, String str2, String str3, boolean z2) {
        int iU = u(15, str, str2, str3, i);
        for (v$a v_aQ = q(iU); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == 15 && v_aQ.h == iU && v_aQ.f == i && v_aQ.c.equals(str) && v_aQ.d.equals(str2) && v_aQ.e.equals(str3)) {
                return v_aQ;
            }
        }
        if (i <= 4) {
            this.h.d(15, i, h(9, str, str2, str3).a);
        } else {
            this.h.d(15, i, h(z2 ? 11 : 10, str, str2, str3).a);
        }
        int i2 = this.g;
        this.g = i2 + 1;
        v$a v_a = new v$a(i2, 15, str, str2, str3, i, iU);
        v(v_a);
        return v_a;
    }

    public u j(String str) {
        return m(19, str);
    }

    public int k(String str, String str2) {
        int iHashCode = ((str2.hashCode() * str.hashCode()) + 12) & Integer.MAX_VALUE;
        for (v$a v_aQ = q(iHashCode); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == 12 && v_aQ.h == iHashCode && v_aQ.d.equals(str) && v_aQ.e.equals(str2)) {
                return v_aQ.a;
            }
        }
        this.h.f(12, l(str), l(str2));
        int i = this.g;
        this.g = i + 1;
        v(new v$a(i, 12, str, str2, iHashCode));
        return i;
    }

    public int l(String str) {
        int iHashCode = (str.hashCode() + 1) & Integer.MAX_VALUE;
        for (v$a v_aQ = q(iHashCode); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == 1 && v_aQ.h == iHashCode && v_aQ.e.equals(str)) {
                return v_aQ.a;
            }
        }
        c cVar = this.h;
        cVar.g(1);
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i = cVar.f3699b;
        if (i + 2 + length > cVar.a.length) {
            cVar.b(length + 2);
        }
        byte[] bArr = cVar.a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i2 + 1;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 1 || cCharAt > 127) {
                cVar.f3699b = i3;
                cVar.a(str, i4, 65535);
                int i5 = this.g;
                this.g = i5 + 1;
                v(new v$a(i5, 1, str, iHashCode));
                return i5;
            }
            bArr[i3] = (byte) cCharAt;
            i4++;
            i3++;
        }
        cVar.f3699b = i3;
        int i6 = this.g;
        this.g = i6 + 1;
        v(new v$a(i6, 1, str, iHashCode));
        return i6;
    }

    public final u m(int i, String str) {
        int iHashCode = (str.hashCode() + i) & Integer.MAX_VALUE;
        for (v$a v_aQ = q(iHashCode); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == i && v_aQ.h == iHashCode && v_aQ.e.equals(str)) {
                return v_aQ;
            }
        }
        this.h.e(i, l(str));
        int i2 = this.g;
        this.g = i2 + 1;
        v$a v_a = new v$a(i2, i, str, iHashCode);
        v(v_a);
        return v_a;
    }

    public int n(String str) {
        int iHashCode = (str.hashCode() + 128) & Integer.MAX_VALUE;
        for (v$a v_aQ = q(iHashCode); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == 128 && v_aQ.h == iHashCode && v_aQ.e.equals(str)) {
                return v_aQ.a;
            }
        }
        return o(new v$a(this.k, 128, str, iHashCode));
    }

    public final int o(v$a v_a) {
        if (this.l == null) {
            this.l = new v$a[16];
        }
        int i = this.k;
        v$a[] v_aArr = this.l;
        if (i == v_aArr.length) {
            v$a[] v_aArr2 = new v$a[v_aArr.length * 2];
            System.arraycopy(v_aArr, 0, v_aArr2, 0, v_aArr.length);
            this.l = v_aArr2;
        }
        v$a[] v_aArr3 = this.l;
        int i2 = this.k;
        this.k = i2 + 1;
        v_aArr3[i2] = v_a;
        v(v_a);
        return v_a.a;
    }

    public int p(String str, int i) {
        int iHashCode = (str.hashCode() + Opcodes.LOR + i) & Integer.MAX_VALUE;
        for (v$a v_aQ = q(iHashCode); v_aQ != null; v_aQ = v_aQ.i) {
            if (v_aQ.f3724b == 129 && v_aQ.h == iHashCode && v_aQ.f == i && v_aQ.e.equals(str)) {
                return v_aQ.a;
            }
        }
        return o(new v$a(this.k, Opcodes.LOR, str, i, iHashCode));
    }

    public final v$a q(int i) {
        v$a[] v_aArr = this.f;
        return v_aArr[i % v_aArr.length];
    }

    public final v$a v(v$a v_a) {
        int i = this.e;
        v$a[] v_aArr = this.f;
        if (i > (v_aArr.length * 3) / 4) {
            int length = v_aArr.length;
            int i2 = (length * 2) + 1;
            v$a[] v_aArr2 = new v$a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                v$a v_a2 = this.f[i3];
                while (v_a2 != null) {
                    int i4 = v_a2.h % i2;
                    v$a v_a3 = v_a2.i;
                    v_a2.i = v_aArr2[i4];
                    v_aArr2[i4] = v_a2;
                    v_a2 = v_a3;
                }
            }
            this.f = v_aArr2;
        }
        this.e++;
        int i5 = v_a.h;
        v$a[] v_aArr3 = this.f;
        int length2 = i5 % v_aArr3.length;
        v_a.i = v_aArr3[length2];
        v_aArr3[length2] = v_a;
        return v_a;
    }
}
