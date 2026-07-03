package p617h0.p618a.p619a;

import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: h0.a.a.v */
/* JADX INFO: compiled from: SymbolTable.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12433v {

    /* JADX INFO: renamed from: a */
    public final C12417f f26347a;

    /* JADX INFO: renamed from: c */
    public int f26349c;

    /* JADX INFO: renamed from: d */
    public String f26350d;

    /* JADX INFO: renamed from: e */
    public int f26351e;

    /* JADX INFO: renamed from: i */
    public int f26355i;

    /* JADX INFO: renamed from: j */
    public C12414c f26356j;

    /* JADX INFO: renamed from: k */
    public int f26357k;

    /* JADX INFO: renamed from: l */
    public a[] f26358l;

    /* JADX INFO: renamed from: b */
    public final C12415d f26348b = null;

    /* JADX INFO: renamed from: f */
    public a[] f26352f = new a[256];

    /* JADX INFO: renamed from: g */
    public int f26353g = 1;

    /* JADX INFO: renamed from: h */
    public C12414c f26354h = new C12414c();

    public C12433v(C12417f c12417f) {
        this.f26347a = c12417f;
    }

    /* JADX INFO: renamed from: r */
    public static int m10622r(int i, int i2) {
        return (i + i2) & Integer.MAX_VALUE;
    }

    /* JADX INFO: renamed from: s */
    public static int m10623s(int i, String str, String str2, int i2) {
        return Integer.MAX_VALUE & (((i2 + 1) * str2.hashCode() * str.hashCode()) + i);
    }

    /* JADX INFO: renamed from: t */
    public static int m10624t(int i, String str, String str2, String str3) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode()) + i);
    }

    /* JADX INFO: renamed from: u */
    public static int m10625u(int i, String str, String str2, String str3, int i2) {
        return Integer.MAX_VALUE & ((str3.hashCode() * str2.hashCode() * str.hashCode() * i2) + i);
    }

    /* JADX INFO: renamed from: a */
    public AbstractC12432u m10626a(C12425n c12425n, Object... objArr) {
        boolean z2;
        C12414c c12414c = this.f26356j;
        if (c12414c == null) {
            c12414c = new C12414c();
            this.f26356j = c12414c;
        }
        for (Object obj : objArr) {
            m10627b(obj);
        }
        int i = c12414c.f26154b;
        c12414c.m10538j(m10634i(c12425n.f26237a, c12425n.f26238b, c12425n.f26239c, c12425n.f26240d, c12425n.f26241e).f26340a);
        c12414c.m10538j(objArr.length);
        for (Object obj2 : objArr) {
            c12414c.m10538j(m10627b(obj2).f26340a);
        }
        int i2 = c12414c.f26154b - i;
        int iHashCode = c12425n.hashCode();
        for (Object obj3 : objArr) {
            iHashCode ^= obj3.hashCode();
        }
        int i3 = iHashCode & Integer.MAX_VALUE;
        byte[] bArr = this.f26356j.f26153a;
        a[] aVarArr = this.f26352f;
        for (a aVar = aVarArr[i3 % aVarArr.length]; aVar != null; aVar = aVar.f26360i) {
            if (aVar.f26341b == 64 && aVar.f26359h == i3) {
                int i4 = (int) aVar.f26345f;
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
                    this.f26356j.f26154b = i;
                    return aVar;
                }
            }
        }
        int i6 = this.f26355i;
        this.f26355i = i6 + 1;
        a aVar2 = new a(i6, 64, i, i3);
        m10643v(aVar2);
        return aVar2;
    }

    /* JADX INFO: renamed from: b */
    public AbstractC12432u m10627b(Object obj) {
        if (obj instanceof Integer) {
            return m10630e(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return m10630e(((Byte) obj).intValue());
        }
        if (obj instanceof Character) {
            return m10630e(((Character) obj).charValue());
        }
        if (obj instanceof Short) {
            return m10630e(((Short) obj).intValue());
        }
        if (obj instanceof Boolean) {
            return m10630e(((Boolean) obj).booleanValue() ? 1 : 0);
        }
        if (obj instanceof Float) {
            return m10631f(4, Float.floatToRawIntBits(((Float) obj).floatValue()));
        }
        if (obj instanceof Long) {
            return m10632g(5, ((Long) obj).longValue());
        }
        if (obj instanceof Double) {
            return m10632g(6, Double.doubleToRawLongBits(((Double) obj).doubleValue()));
        }
        if (obj instanceof String) {
            return m10638m(8, (String) obj);
        }
        if (obj instanceof C12434w) {
            C12434w c12434w = (C12434w) obj;
            int iM10654i = c12434w.m10654i();
            if (iM10654i == 10) {
                return m10628c(c12434w.m10653g());
            }
            return iM10654i == 11 ? m10638m(16, c12434w.m10651d()) : m10628c(c12434w.m10651d());
        }
        if (obj instanceof C12425n) {
            C12425n c12425n = (C12425n) obj;
            return m10634i(c12425n.f26237a, c12425n.f26238b, c12425n.f26239c, c12425n.f26240d, c12425n.f26241e);
        }
        if (!(obj instanceof C12418g)) {
            throw new IllegalArgumentException(C1643a.m881v("value ", obj));
        }
        C12418g c12418g = (C12418g) obj;
        return m10629d(17, c12418g.f26190a, c12418g.f26191b, m10626a(c12418g.f26192c, c12418g.f26193d).f26340a);
    }

    /* JADX INFO: renamed from: c */
    public AbstractC12432u m10628c(String str) {
        return m10638m(7, str);
    }

    /* JADX INFO: renamed from: d */
    public final AbstractC12432u m10629d(int i, String str, String str2, int i2) {
        int iM10623s = m10623s(i, str, str2, i2);
        for (a aVarM10642q = m10642q(iM10623s); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iM10623s && aVarM10642q.f26345f == i2 && aVarM10642q.f26343d.equals(str) && aVarM10642q.f26344e.equals(str2)) {
                return aVarM10642q;
            }
        }
        this.f26354h.m10534f(i, i2, m10636k(str, str2));
        int i3 = this.f26353g;
        this.f26353g = i3 + 1;
        a aVar = new a(i3, i, null, str, str2, i2, iM10623s);
        m10643v(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: e */
    public AbstractC12432u m10630e(int i) {
        return m10631f(3, i);
    }

    /* JADX INFO: renamed from: f */
    public final AbstractC12432u m10631f(int i, int i2) {
        int iM10622r = m10622r(i, i2);
        for (a aVarM10642q = m10642q(iM10622r); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iM10622r && aVarM10642q.f26345f == i2) {
                return aVarM10642q;
            }
        }
        C12414c c12414c = this.f26354h;
        c12414c.m10535g(i);
        c12414c.m10537i(i2);
        int i3 = this.f26353g;
        this.f26353g = i3 + 1;
        a aVar = new a(i3, i, i2, iM10622r);
        m10643v(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: g */
    public final AbstractC12432u m10632g(int i, long j) {
        int i2 = (int) j;
        int i3 = (int) (j >>> 32);
        int i4 = (i + i2 + i3) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(i4); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == i4 && aVarM10642q.f26345f == j) {
                return aVarM10642q;
            }
        }
        int i5 = this.f26353g;
        C12414c c12414c = this.f26354h;
        c12414c.m10535g(i);
        int i6 = c12414c.f26154b;
        if (i6 + 8 > c12414c.f26153a.length) {
            c12414c.m10530b(8);
        }
        byte[] bArr = c12414c.f26153a;
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
        c12414c.f26154b = i13 + 1;
        this.f26353g += 2;
        a aVar = new a(i5, i, j, i4);
        m10643v(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: h */
    public final a m10633h(int i, String str, String str2, String str3) {
        int iM10624t = m10624t(i, str, str2, str3);
        for (a aVarM10642q = m10642q(iM10624t); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iM10624t && aVarM10642q.f26342c.equals(str) && aVarM10642q.f26343d.equals(str2) && aVarM10642q.f26344e.equals(str3)) {
                return aVarM10642q;
            }
        }
        this.f26354h.m10534f(i, m10638m(7, str).f26340a, m10636k(str2, str3));
        int i2 = this.f26353g;
        this.f26353g = i2 + 1;
        a aVar = new a(i2, i, str, str2, str3, 0L, iM10624t);
        m10643v(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: i */
    public AbstractC12432u m10634i(int i, String str, String str2, String str3, boolean z2) {
        int iM10625u = m10625u(15, str, str2, str3, i);
        for (a aVarM10642q = m10642q(iM10625u); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 15 && aVarM10642q.f26359h == iM10625u && aVarM10642q.f26345f == i && aVarM10642q.f26342c.equals(str) && aVarM10642q.f26343d.equals(str2) && aVarM10642q.f26344e.equals(str3)) {
                return aVarM10642q;
            }
        }
        if (i <= 4) {
            this.f26354h.m10532d(15, i, m10633h(9, str, str2, str3).f26340a);
        } else {
            this.f26354h.m10532d(15, i, m10633h(z2 ? 11 : 10, str, str2, str3).f26340a);
        }
        int i2 = this.f26353g;
        this.f26353g = i2 + 1;
        a aVar = new a(i2, 15, str, str2, str3, i, iM10625u);
        m10643v(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: j */
    public AbstractC12432u m10635j(String str) {
        return m10638m(19, str);
    }

    /* JADX INFO: renamed from: k */
    public int m10636k(String str, String str2) {
        int iHashCode = ((str2.hashCode() * str.hashCode()) + 12) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 12 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26343d.equals(str) && aVarM10642q.f26344e.equals(str2)) {
                return aVarM10642q.f26340a;
            }
        }
        this.f26354h.m10534f(12, m10637l(str), m10637l(str2));
        int i = this.f26353g;
        this.f26353g = i + 1;
        m10643v(new a(i, 12, str, str2, iHashCode));
        return i;
    }

    /* JADX INFO: renamed from: l */
    public int m10637l(String str) {
        int iHashCode = (str.hashCode() + 1) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 1 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q.f26340a;
            }
        }
        C12414c c12414c = this.f26354h;
        c12414c.m10535g(1);
        int length = str.length();
        if (length > 65535) {
            throw new IllegalArgumentException("UTF8 string too large");
        }
        int i = c12414c.f26154b;
        if (i + 2 + length > c12414c.f26153a.length) {
            c12414c.m10530b(length + 2);
        }
        byte[] bArr = c12414c.f26153a;
        int i2 = i + 1;
        bArr[i] = (byte) (length >>> 8);
        int i3 = i2 + 1;
        bArr[i2] = (byte) length;
        int i4 = 0;
        while (i4 < length) {
            char cCharAt = str.charAt(i4);
            if (cCharAt < 1 || cCharAt > 127) {
                c12414c.f26154b = i3;
                c12414c.m10529a(str, i4, 65535);
                int i5 = this.f26353g;
                this.f26353g = i5 + 1;
                m10643v(new a(i5, 1, str, iHashCode));
                return i5;
            }
            bArr[i3] = (byte) cCharAt;
            i4++;
            i3++;
        }
        c12414c.f26154b = i3;
        int i6 = this.f26353g;
        this.f26353g = i6 + 1;
        m10643v(new a(i6, 1, str, iHashCode));
        return i6;
    }

    /* JADX INFO: renamed from: m */
    public final AbstractC12432u m10638m(int i, String str) {
        int iHashCode = (str.hashCode() + i) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == i && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q;
            }
        }
        this.f26354h.m10533e(i, m10637l(str));
        int i2 = this.f26353g;
        this.f26353g = i2 + 1;
        a aVar = new a(i2, i, str, iHashCode);
        m10643v(aVar);
        return aVar;
    }

    /* JADX INFO: renamed from: n */
    public int m10639n(String str) {
        int iHashCode = (str.hashCode() + 128) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 128 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q.f26340a;
            }
        }
        return m10640o(new a(this.f26357k, 128, str, iHashCode));
    }

    /* JADX INFO: renamed from: o */
    public final int m10640o(a aVar) {
        if (this.f26358l == null) {
            this.f26358l = new a[16];
        }
        int i = this.f26357k;
        a[] aVarArr = this.f26358l;
        if (i == aVarArr.length) {
            a[] aVarArr2 = new a[aVarArr.length * 2];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, aVarArr.length);
            this.f26358l = aVarArr2;
        }
        a[] aVarArr3 = this.f26358l;
        int i2 = this.f26357k;
        this.f26357k = i2 + 1;
        aVarArr3[i2] = aVar;
        m10643v(aVar);
        return aVar.f26340a;
    }

    /* JADX INFO: renamed from: p */
    public int m10641p(String str, int i) {
        int iHashCode = (str.hashCode() + Opcodes.LOR + i) & Integer.MAX_VALUE;
        for (a aVarM10642q = m10642q(iHashCode); aVarM10642q != null; aVarM10642q = aVarM10642q.f26360i) {
            if (aVarM10642q.f26341b == 129 && aVarM10642q.f26359h == iHashCode && aVarM10642q.f26345f == i && aVarM10642q.f26344e.equals(str)) {
                return aVarM10642q.f26340a;
            }
        }
        return m10640o(new a(this.f26357k, Opcodes.LOR, str, i, iHashCode));
    }

    /* JADX INFO: renamed from: q */
    public final a m10642q(int i) {
        a[] aVarArr = this.f26352f;
        return aVarArr[i % aVarArr.length];
    }

    /* JADX INFO: renamed from: v */
    public final a m10643v(a aVar) {
        int i = this.f26351e;
        a[] aVarArr = this.f26352f;
        if (i > (aVarArr.length * 3) / 4) {
            int length = aVarArr.length;
            int i2 = (length * 2) + 1;
            a[] aVarArr2 = new a[i2];
            for (int i3 = length - 1; i3 >= 0; i3--) {
                a aVar2 = this.f26352f[i3];
                while (aVar2 != null) {
                    int i4 = aVar2.f26359h % i2;
                    a aVar3 = aVar2.f26360i;
                    aVar2.f26360i = aVarArr2[i4];
                    aVarArr2[i4] = aVar2;
                    aVar2 = aVar3;
                }
            }
            this.f26352f = aVarArr2;
        }
        this.f26351e++;
        int i5 = aVar.f26359h;
        a[] aVarArr3 = this.f26352f;
        int length2 = i5 % aVarArr3.length;
        aVar.f26360i = aVarArr3[length2];
        aVarArr3[length2] = aVar;
        return aVar;
    }

    /* JADX INFO: renamed from: h0.a.a.v$a */
    /* JADX INFO: compiled from: SymbolTable.java */
    public static class a extends AbstractC12432u {

        /* JADX INFO: renamed from: h */
        public final int f26359h;

        /* JADX INFO: renamed from: i */
        public a f26360i;

        public a(int i, int i2, String str, String str2, String str3, long j, int i3) {
            super(i, i2, str, str2, str3, j);
            this.f26359h = i3;
        }

        public a(int i, int i2, String str, int i3) {
            super(i, i2, null, null, str, 0L);
            this.f26359h = i3;
        }

        public a(int i, int i2, String str, long j, int i3) {
            super(i, i2, null, null, str, j);
            this.f26359h = i3;
        }

        public a(int i, int i2, String str, String str2, int i3) {
            super(i, i2, null, str, str2, 0L);
            this.f26359h = i3;
        }

        public a(int i, int i2, long j, int i3) {
            super(i, i2, null, null, null, j);
            this.f26359h = i3;
        }
    }
}
