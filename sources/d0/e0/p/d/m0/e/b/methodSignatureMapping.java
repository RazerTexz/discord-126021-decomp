package d0.e0.p.d.m0.e.b;

import d0.e0.p.d.m0.k.y.JvmPrimitiveType;
import d0.z.d.Intrinsics3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k, reason: use source file name */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class methodSignatureMapping {
    public static final b a = new b(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d f3379b = new d(JvmPrimitiveType.BOOLEAN);
    public static final d c = new d(JvmPrimitiveType.CHAR);
    public static final d d = new d(JvmPrimitiveType.BYTE);
    public static final d e = new d(JvmPrimitiveType.SHORT);
    public static final d f = new d(JvmPrimitiveType.INT);
    public static final d g = new d(JvmPrimitiveType.FLOAT);
    public static final d h = new d(JvmPrimitiveType.LONG);
    public static final d i = new d(JvmPrimitiveType.DOUBLE);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$a */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class a extends methodSignatureMapping {
        public final methodSignatureMapping j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(methodSignatureMapping methodsignaturemapping) {
            super(null);
            Intrinsics3.checkNotNullParameter(methodsignaturemapping, "elementType");
            this.j = methodsignaturemapping;
        }

        public final methodSignatureMapping getElementType() {
            return this.j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$b */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d getBOOLEAN$descriptors_jvm() {
            return methodSignatureMapping.f3379b;
        }

        public final d getBYTE$descriptors_jvm() {
            return methodSignatureMapping.d;
        }

        public final d getCHAR$descriptors_jvm() {
            return methodSignatureMapping.c;
        }

        public final d getDOUBLE$descriptors_jvm() {
            return methodSignatureMapping.i;
        }

        public final d getFLOAT$descriptors_jvm() {
            return methodSignatureMapping.g;
        }

        public final d getINT$descriptors_jvm() {
            return methodSignatureMapping.f;
        }

        public final d getLONG$descriptors_jvm() {
            return methodSignatureMapping.h;
        }

        public final d getSHORT$descriptors_jvm() {
            return methodSignatureMapping.e;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$c */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class c extends methodSignatureMapping {
        public final String j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            Intrinsics3.checkNotNullParameter(str, "internalName");
            this.j = str;
        }

        public final String getInternalName() {
            return this.j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$d */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class d extends methodSignatureMapping {
        public final JvmPrimitiveType j;

        public d(JvmPrimitiveType jvmPrimitiveType) {
            super(null);
            this.j = jvmPrimitiveType;
        }

        public final JvmPrimitiveType getJvmPrimitiveType() {
            return this.j;
        }
    }

    public methodSignatureMapping() {
    }

    public String toString() {
        return methodSignatureMapping2.a.toString(this);
    }

    public methodSignatureMapping(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
