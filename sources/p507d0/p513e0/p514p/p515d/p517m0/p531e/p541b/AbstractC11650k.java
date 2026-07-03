package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p560y.EnumC11840d;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k */
/* JADX INFO: compiled from: methodSignatureMapping.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC11650k {

    /* JADX INFO: renamed from: a */
    public static final b f23617a = new b(null);

    /* JADX INFO: renamed from: b */
    public static final d f23618b = new d(EnumC11840d.BOOLEAN);

    /* JADX INFO: renamed from: c */
    public static final d f23619c = new d(EnumC11840d.CHAR);

    /* JADX INFO: renamed from: d */
    public static final d f23620d = new d(EnumC11840d.BYTE);

    /* JADX INFO: renamed from: e */
    public static final d f23621e = new d(EnumC11840d.SHORT);

    /* JADX INFO: renamed from: f */
    public static final d f23622f = new d(EnumC11840d.INT);

    /* JADX INFO: renamed from: g */
    public static final d f23623g = new d(EnumC11840d.FLOAT);

    /* JADX INFO: renamed from: h */
    public static final d f23624h = new d(EnumC11840d.LONG);

    /* JADX INFO: renamed from: i */
    public static final d f23625i = new d(EnumC11840d.DOUBLE);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$a */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class a extends AbstractC11650k {

        /* JADX INFO: renamed from: j */
        public final AbstractC11650k f23626j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AbstractC11650k abstractC11650k) {
            super(null);
            C12238m.checkNotNullParameter(abstractC11650k, "elementType");
            this.f23626j = abstractC11650k;
        }

        public final AbstractC11650k getElementType() {
            return this.f23626j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$b */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class b {
        public b(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final d getBOOLEAN$descriptors_jvm() {
            return AbstractC11650k.f23618b;
        }

        public final d getBYTE$descriptors_jvm() {
            return AbstractC11650k.f23620d;
        }

        public final d getCHAR$descriptors_jvm() {
            return AbstractC11650k.f23619c;
        }

        public final d getDOUBLE$descriptors_jvm() {
            return AbstractC11650k.f23625i;
        }

        public final d getFLOAT$descriptors_jvm() {
            return AbstractC11650k.f23623g;
        }

        public final d getINT$descriptors_jvm() {
            return AbstractC11650k.f23622f;
        }

        public final d getLONG$descriptors_jvm() {
            return AbstractC11650k.f23624h;
        }

        public final d getSHORT$descriptors_jvm() {
            return AbstractC11650k.f23621e;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$c */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class c extends AbstractC11650k {

        /* JADX INFO: renamed from: j */
        public final String f23627j;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(String str) {
            super(null);
            C12238m.checkNotNullParameter(str, "internalName");
            this.f23627j = str;
        }

        public final String getInternalName() {
            return this.f23627j;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.k$d */
    /* JADX INFO: compiled from: methodSignatureMapping.kt */
    public static final class d extends AbstractC11650k {

        /* JADX INFO: renamed from: j */
        public final EnumC11840d f23628j;

        public d(EnumC11840d enumC11840d) {
            super(null);
            this.f23628j = enumC11840d;
        }

        public final EnumC11840d getJvmPrimitiveType() {
            return this.f23628j;
        }
    }

    public AbstractC11650k() {
    }

    public String toString() {
        return C11652m.f23629a.toString(this);
    }

    public AbstractC11650k(DefaultConstructorMarker defaultConstructorMarker) {
    }
}
