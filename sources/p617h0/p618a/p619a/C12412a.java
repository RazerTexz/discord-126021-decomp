package p617h0.p618a.p619a;

import java.util.Objects;

/* JADX INFO: renamed from: h0.a.a.a */
/* JADX INFO: compiled from: AnnotationWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12412a {

    /* JADX INFO: renamed from: a */
    public final C12433v f26141a;

    /* JADX INFO: renamed from: b */
    public final boolean f26142b;

    /* JADX INFO: renamed from: c */
    public final C12414c f26143c;

    /* JADX INFO: renamed from: d */
    public final int f26144d;

    /* JADX INFO: renamed from: e */
    public int f26145e;

    /* JADX INFO: renamed from: f */
    public final C12412a f26146f;

    /* JADX INFO: renamed from: g */
    public C12412a f26147g;

    public C12412a(C12433v c12433v, boolean z2, C12414c c12414c, C12412a c12412a) {
        this.f26141a = c12433v;
        this.f26142b = z2;
        this.f26143c = c12414c;
        int i = c12414c.f26154b;
        this.f26144d = i == 0 ? -1 : i - 2;
        this.f26146f = c12412a;
        if (c12412a != null) {
            c12412a.f26147g = this;
        }
    }

    /* JADX INFO: renamed from: b */
    public static int m10516b(String str, C12412a[] c12412aArr, int i) {
        int iM10518a = (i * 2) + 7;
        for (int i2 = 0; i2 < i; i2++) {
            C12412a c12412a = c12412aArr[i2];
            iM10518a += c12412a == null ? 0 : c12412a.m10518a(str) - 8;
        }
        return iM10518a;
    }

    /* JADX INFO: renamed from: d */
    public static void m10517d(int i, C12412a[] c12412aArr, int i2, C12414c c12414c) {
        int iM10518a = (i2 * 2) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            C12412a c12412a = c12412aArr[i3];
            iM10518a += c12412a == null ? 0 : c12412a.m10518a(null) - 8;
        }
        c12414c.m10538j(i);
        c12414c.m10537i(iM10518a);
        c12414c.m10535g(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            C12412a c12412a2 = null;
            int i5 = 0;
            for (C12412a c12412a3 = c12412aArr[i4]; c12412a3 != null; c12412a3 = c12412a3.f26146f) {
                c12412a3.m10522g();
                i5++;
                c12412a2 = c12412a3;
            }
            c12414c.m10538j(i5);
            while (c12412a2 != null) {
                C12414c c12414c2 = c12412a2.f26143c;
                c12414c.m10536h(c12414c2.f26153a, 0, c12414c2.f26154b);
                c12412a2 = c12412a2.f26147g;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public int m10518a(String str) {
        if (str != null) {
            this.f26141a.m10637l(str);
        }
        int i = 8;
        for (C12412a c12412a = this; c12412a != null; c12412a = c12412a.f26146f) {
            i += c12412a.f26143c.f26154b;
        }
        return i;
    }

    /* JADX INFO: renamed from: c */
    public void m10519c(int i, C12414c c12414c) {
        int i2 = 2;
        int i3 = 0;
        C12412a c12412a = null;
        for (C12412a c12412a2 = this; c12412a2 != null; c12412a2 = c12412a2.f26146f) {
            c12412a2.m10522g();
            i2 += c12412a2.f26143c.f26154b;
            i3++;
            c12412a = c12412a2;
        }
        c12414c.m10538j(i);
        c12414c.m10537i(i2);
        c12414c.m10538j(i3);
        while (c12412a != null) {
            C12414c c12414c2 = c12412a.f26143c;
            c12414c.m10536h(c12414c2.f26153a, 0, c12414c2.f26154b);
            c12412a = c12412a.f26147g;
        }
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /* JADX INFO: renamed from: e */
    public void m10520e(String str, Object obj) {
        this.f26145e++;
        if (this.f26142b) {
            this.f26143c.m10538j(this.f26141a.m10637l(str));
        }
        if (obj instanceof String) {
            this.f26143c.m10533e(115, this.f26141a.m10637l((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.f26143c.m10533e(66, this.f26141a.m10630e(((Byte) obj).byteValue()).f26340a);
            return;
        }
        if (obj instanceof Boolean) {
            this.f26143c.m10533e(90, this.f26141a.m10630e(((Boolean) obj).booleanValue() ? 1 : 0).f26340a);
            return;
        }
        if (obj instanceof Character) {
            this.f26143c.m10533e(67, this.f26141a.m10630e(((Character) obj).charValue()).f26340a);
            return;
        }
        if (obj instanceof Short) {
            this.f26143c.m10533e(83, this.f26141a.m10630e(((Short) obj).shortValue()).f26340a);
            return;
        }
        if (obj instanceof C12434w) {
            this.f26143c.m10533e(99, this.f26141a.m10637l(((C12434w) obj).m10651d()));
            return;
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.f26143c.m10533e(91, bArr.length);
            int length = bArr.length;
            while (i < length) {
                this.f26143c.m10533e(66, this.f26141a.m10630e(bArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.f26143c.m10533e(91, zArr.length);
            int length2 = zArr.length;
            while (i < length2) {
                this.f26143c.m10533e(90, this.f26141a.m10630e(zArr[i] ? 1 : 0).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.f26143c.m10533e(91, sArr.length);
            int length3 = sArr.length;
            while (i < length3) {
                this.f26143c.m10533e(83, this.f26141a.m10630e(sArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.f26143c.m10533e(91, cArr.length);
            int length4 = cArr.length;
            while (i < length4) {
                this.f26143c.m10533e(67, this.f26141a.m10630e(cArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.f26143c.m10533e(91, iArr.length);
            int length5 = iArr.length;
            while (i < length5) {
                this.f26143c.m10533e(73, this.f26141a.m10630e(iArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.f26143c.m10533e(91, jArr.length);
            int length6 = jArr.length;
            while (i < length6) {
                this.f26143c.m10533e(74, this.f26141a.m10632g(5, jArr[i]).f26340a);
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.f26143c.m10533e(91, fArr.length);
            int length7 = fArr.length;
            while (i < length7) {
                float f = fArr[i];
                C12414c c12414c = this.f26143c;
                C12433v c12433v = this.f26141a;
                Objects.requireNonNull(c12433v);
                c12414c.m10533e(70, c12433v.m10631f(4, Float.floatToRawIntBits(f)).f26340a);
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            AbstractC12432u abstractC12432uM10627b = this.f26141a.m10627b(obj);
            this.f26143c.m10533e(".s.IFJDCS".charAt(abstractC12432uM10627b.f26341b), abstractC12432uM10627b.f26340a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.f26143c.m10533e(91, dArr.length);
        int length8 = dArr.length;
        while (i < length8) {
            double d = dArr[i];
            C12414c c12414c2 = this.f26143c;
            C12433v c12433v2 = this.f26141a;
            Objects.requireNonNull(c12433v2);
            c12414c2.m10533e(68, c12433v2.m10632g(6, Double.doubleToRawLongBits(d)).f26340a);
            i++;
        }
    }

    /* JADX INFO: renamed from: f */
    public C12412a m10521f(String str) {
        this.f26145e++;
        if (this.f26142b) {
            this.f26143c.m10538j(this.f26141a.m10637l(str));
        }
        this.f26143c.m10533e(91, 0);
        return new C12412a(this.f26141a, false, this.f26143c, null);
    }

    /* JADX INFO: renamed from: g */
    public void m10522g() {
        int i = this.f26144d;
        if (i != -1) {
            byte[] bArr = this.f26143c.f26153a;
            int i2 = this.f26145e;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }
}
