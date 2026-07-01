package h0.a.a;

import java.util.Objects;

/* JADX INFO: compiled from: AnnotationWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final v a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3696b;
    public final c c;
    public final int d;
    public int e;
    public final a f;
    public a g;

    public a(v vVar, boolean z2, c cVar, a aVar) {
        this.a = vVar;
        this.f3696b = z2;
        this.c = cVar;
        int i = cVar.f3699b;
        this.d = i == 0 ? -1 : i - 2;
        this.f = aVar;
        if (aVar != null) {
            aVar.g = this;
        }
    }

    public static int b(String str, a[] aVarArr, int i) {
        int iA = (i * 2) + 7;
        for (int i2 = 0; i2 < i; i2++) {
            a aVar = aVarArr[i2];
            iA += aVar == null ? 0 : aVar.a(str) - 8;
        }
        return iA;
    }

    public static void d(int i, a[] aVarArr, int i2, c cVar) {
        int iA = (i2 * 2) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            a aVar = aVarArr[i3];
            iA += aVar == null ? 0 : aVar.a(null) - 8;
        }
        cVar.j(i);
        cVar.i(iA);
        cVar.g(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            a aVar2 = null;
            int i5 = 0;
            for (a aVar3 = aVarArr[i4]; aVar3 != null; aVar3 = aVar3.f) {
                aVar3.g();
                i5++;
                aVar2 = aVar3;
            }
            cVar.j(i5);
            while (aVar2 != null) {
                c cVar2 = aVar2.c;
                cVar.h(cVar2.a, 0, cVar2.f3699b);
                aVar2 = aVar2.g;
            }
        }
    }

    public int a(String str) {
        if (str != null) {
            this.a.l(str);
        }
        int i = 8;
        for (a aVar = this; aVar != null; aVar = aVar.f) {
            i += aVar.c.f3699b;
        }
        return i;
    }

    public void c(int i, c cVar) {
        int i2 = 2;
        int i3 = 0;
        a aVar = null;
        for (a aVar2 = this; aVar2 != null; aVar2 = aVar2.f) {
            aVar2.g();
            i2 += aVar2.c.f3699b;
            i3++;
            aVar = aVar2;
        }
        cVar.j(i);
        cVar.i(i2);
        cVar.j(i3);
        while (aVar != null) {
            c cVar2 = aVar.c;
            cVar.h(cVar2.a, 0, cVar2.f3699b);
            aVar = aVar.g;
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
    public void e(String str, Object obj) {
        this.e++;
        if (this.f3696b) {
            this.c.j(this.a.l(str));
        }
        if (obj instanceof String) {
            this.c.e(115, this.a.l((String) obj));
            return;
        }
        if (obj instanceof Byte) {
            this.c.e(66, this.a.e(((Byte) obj).byteValue()).a);
            return;
        }
        if (obj instanceof Boolean) {
            this.c.e(90, this.a.e(((Boolean) obj).booleanValue() ? 1 : 0).a);
            return;
        }
        if (obj instanceof Character) {
            this.c.e(67, this.a.e(((Character) obj).charValue()).a);
            return;
        }
        if (obj instanceof Short) {
            this.c.e(83, this.a.e(((Short) obj).shortValue()).a);
            return;
        }
        if (obj instanceof w) {
            this.c.e(99, this.a.l(((w) obj).d()));
            return;
        }
        int i = 0;
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            this.c.e(91, bArr.length);
            int length = bArr.length;
            while (i < length) {
                this.c.e(66, this.a.e(bArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            this.c.e(91, zArr.length);
            int length2 = zArr.length;
            while (i < length2) {
                this.c.e(90, this.a.e(zArr[i] ? 1 : 0).a);
                i++;
            }
            return;
        }
        if (obj instanceof short[]) {
            short[] sArr = (short[]) obj;
            this.c.e(91, sArr.length);
            int length3 = sArr.length;
            while (i < length3) {
                this.c.e(83, this.a.e(sArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof char[]) {
            char[] cArr = (char[]) obj;
            this.c.e(91, cArr.length);
            int length4 = cArr.length;
            while (i < length4) {
                this.c.e(67, this.a.e(cArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof int[]) {
            int[] iArr = (int[]) obj;
            this.c.e(91, iArr.length);
            int length5 = iArr.length;
            while (i < length5) {
                this.c.e(73, this.a.e(iArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            this.c.e(91, jArr.length);
            int length6 = jArr.length;
            while (i < length6) {
                this.c.e(74, this.a.g(5, jArr[i]).a);
                i++;
            }
            return;
        }
        if (obj instanceof float[]) {
            float[] fArr = (float[]) obj;
            this.c.e(91, fArr.length);
            int length7 = fArr.length;
            while (i < length7) {
                float f = fArr[i];
                c cVar = this.c;
                v vVar = this.a;
                Objects.requireNonNull(vVar);
                cVar.e(70, vVar.f(4, Float.floatToRawIntBits(f)).a);
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            u uVarB = this.a.b(obj);
            this.c.e(".s.IFJDCS".charAt(uVarB.f3724b), uVarB.a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.c.e(91, dArr.length);
        int length8 = dArr.length;
        while (i < length8) {
            double d = dArr[i];
            c cVar2 = this.c;
            v vVar2 = this.a;
            Objects.requireNonNull(vVar2);
            cVar2.e(68, vVar2.g(6, Double.doubleToRawLongBits(d)).a);
            i++;
        }
    }

    public a f(String str) {
        this.e++;
        if (this.f3696b) {
            this.c.j(this.a.l(str));
        }
        this.c.e(91, 0);
        return new a(this.a, false, this.c, null);
    }

    public void g() {
        int i = this.d;
        if (i != -1) {
            byte[] bArr = this.c.a;
            int i2 = this.e;
            bArr[i] = (byte) (i2 >>> 8);
            bArr[i + 1] = (byte) i2;
        }
    }
}
