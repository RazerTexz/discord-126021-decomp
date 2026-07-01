package d0.e0.p.d.m0.e.b.b0;

import d0.d0._Ranges;
import d0.e0.p.d.m0.f.a0.b.JvmBytecodeBinaryVersion;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.t._ArraysJvm;
import d0.z.d.Intrinsics3;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.a, reason: use source file name */
/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class KotlinClassHeader {
    public final a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JvmMetadataVersion f3366b;
    public final String[] c;
    public final String[] d;
    public final String[] e;
    public final String f;
    public final int g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.a$a */
    /* JADX INFO: compiled from: KotlinClassHeader.kt */
    public enum a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);

        public static final C0388a j = new C0388a(null);
        public static final Map<Integer, a> k;

        /* JADX INFO: renamed from: id, reason: collision with root package name */
        private final int f3367id;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KotlinClassHeader.kt */
        public static final class C0388a {
            public C0388a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final a getById(int i) {
                a aVar = (a) a.k.get(Integer.valueOf(i));
                return aVar == null ? a.UNKNOWN : aVar;
            }
        }

        static {
            a[] aVarArrValuesCustom = valuesCustom();
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(6), 16));
            for (int i = 0; i < 6; i++) {
                a aVar = aVarArrValuesCustom[i];
                linkedHashMap.put(Integer.valueOf(aVar.getId()), aVar);
            }
            k = linkedHashMap;
        }

        a(int i) {
            this.f3367id = i;
        }

        public static final a getById(int i) {
            return j.getById(i);
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }

        public final int getId() {
            return this.f3367id;
        }
    }

    public KotlinClassHeader(a aVar, JvmMetadataVersion jvmMetadataVersion, JvmBytecodeBinaryVersion jvmBytecodeBinaryVersion, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        Intrinsics3.checkNotNullParameter(aVar, "kind");
        Intrinsics3.checkNotNullParameter(jvmMetadataVersion, "metadataVersion");
        Intrinsics3.checkNotNullParameter(jvmBytecodeBinaryVersion, "bytecodeVersion");
        this.a = aVar;
        this.f3366b = jvmMetadataVersion;
        this.c = strArr;
        this.d = strArr2;
        this.e = strArr3;
        this.f = str;
        this.g = i;
    }

    public final boolean a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final String[] getData() {
        return this.c;
    }

    public final String[] getIncompatibleData() {
        return this.d;
    }

    public final a getKind() {
        return this.a;
    }

    public final JvmMetadataVersion getMetadataVersion() {
        return this.f3366b;
    }

    public final String getMultifileClassName() {
        String str = this.f;
        if (getKind() == a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.c;
        if (!(getKind() == a.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> listAsList = strArr != null ? _ArraysJvm.asList(strArr) : null;
        return listAsList != null ? listAsList : Collections2.emptyList();
    }

    public final String[] getStrings() {
        return this.e;
    }

    public final boolean isPreRelease() {
        return a(this.g, 2);
    }

    public final boolean isUnstableFirBinary() {
        return a(this.g, 64) && !a(this.g, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return a(this.g, 16) && !a(this.g, 32);
    }

    public String toString() {
        return this.a + " version=" + this.f3366b;
    }
}
