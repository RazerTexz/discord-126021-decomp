package h0.a.a;

import java.util.Objects;

/* JADX INFO: renamed from: h0.a.a.a, reason: use source file name */
/* JADX INFO: compiled from: AnnotationWriter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class AnnotationWriter2 {
    public final SymbolTable2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3696b;
    public final ByteVector2 c;
    public final int d;
    public int e;
    public final AnnotationWriter2 f;
    public AnnotationWriter2 g;

    public AnnotationWriter2(SymbolTable2 symbolTable2, boolean z2, ByteVector2 byteVector2, AnnotationWriter2 annotationWriter2) {
        this.a = symbolTable2;
        this.f3696b = z2;
        this.c = byteVector2;
        int i = byteVector2.f3699b;
        this.d = i == 0 ? -1 : i - 2;
        this.f = annotationWriter2;
        if (annotationWriter2 != null) {
            annotationWriter2.g = this;
        }
    }

    public static int b(String str, AnnotationWriter2[] annotationWriter2Arr, int i) {
        int iA = (i * 2) + 7;
        for (int i2 = 0; i2 < i; i2++) {
            AnnotationWriter2 annotationWriter2 = annotationWriter2Arr[i2];
            iA += annotationWriter2 == null ? 0 : annotationWriter2.a(str) - 8;
        }
        return iA;
    }

    public static void d(int i, AnnotationWriter2[] annotationWriter2Arr, int i2, ByteVector2 byteVector2) {
        int iA = (i2 * 2) + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            AnnotationWriter2 annotationWriter2 = annotationWriter2Arr[i3];
            iA += annotationWriter2 == null ? 0 : annotationWriter2.a(null) - 8;
        }
        byteVector2.j(i);
        byteVector2.i(iA);
        byteVector2.g(i2);
        for (int i4 = 0; i4 < i2; i4++) {
            AnnotationWriter2 annotationWriter3 = null;
            int i5 = 0;
            for (AnnotationWriter2 annotationWriter4 = annotationWriter2Arr[i4]; annotationWriter4 != null; annotationWriter4 = annotationWriter4.f) {
                annotationWriter4.g();
                i5++;
                annotationWriter3 = annotationWriter4;
            }
            byteVector2.j(i5);
            while (annotationWriter3 != null) {
                ByteVector2 byteVector3 = annotationWriter3.c;
                byteVector2.h(byteVector3.a, 0, byteVector3.f3699b);
                annotationWriter3 = annotationWriter3.g;
            }
        }
    }

    public int a(String str) {
        if (str != null) {
            this.a.l(str);
        }
        int i = 8;
        for (AnnotationWriter2 annotationWriter2 = this; annotationWriter2 != null; annotationWriter2 = annotationWriter2.f) {
            i += annotationWriter2.c.f3699b;
        }
        return i;
    }

    public void c(int i, ByteVector2 byteVector2) {
        int i2 = 2;
        int i3 = 0;
        AnnotationWriter2 annotationWriter2 = null;
        for (AnnotationWriter2 annotationWriter3 = this; annotationWriter3 != null; annotationWriter3 = annotationWriter3.f) {
            annotationWriter3.g();
            i2 += annotationWriter3.c.f3699b;
            i3++;
            annotationWriter2 = annotationWriter3;
        }
        byteVector2.j(i);
        byteVector2.i(i2);
        byteVector2.j(i3);
        while (annotationWriter2 != null) {
            ByteVector2 byteVector3 = annotationWriter2.c;
            byteVector2.h(byteVector3.a, 0, byteVector3.f3699b);
            annotationWriter2 = annotationWriter2.g;
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
        if (obj instanceof Type2) {
            this.c.e(99, this.a.l(((Type2) obj).d()));
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
                ByteVector2 byteVector2 = this.c;
                SymbolTable2 symbolTable2 = this.a;
                Objects.requireNonNull(symbolTable2);
                byteVector2.e(70, symbolTable2.f(4, Float.floatToRawIntBits(f)).a);
                i++;
            }
            return;
        }
        if (!(obj instanceof double[])) {
            Symbol2 symbol2B = this.a.b(obj);
            this.c.e(".s.IFJDCS".charAt(symbol2B.f3724b), symbol2B.a);
            return;
        }
        double[] dArr = (double[]) obj;
        this.c.e(91, dArr.length);
        int length8 = dArr.length;
        while (i < length8) {
            double d = dArr[i];
            ByteVector2 byteVector3 = this.c;
            SymbolTable2 symbolTable3 = this.a;
            Objects.requireNonNull(symbolTable3);
            byteVector3.e(68, symbolTable3.g(6, Double.doubleToRawLongBits(d)).a);
            i++;
        }
    }

    public AnnotationWriter2 f(String str) {
        this.e++;
        if (this.f3696b) {
            this.c.j(this.a.l(str));
        }
        this.c.e(91, 0);
        return new AnnotationWriter2(this.a, false, this.c, null);
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
