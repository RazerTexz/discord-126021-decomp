package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11670c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11673f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12139j;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.a */
/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11636a {

    /* JADX INFO: renamed from: a */
    public final a f23550a;

    /* JADX INFO: renamed from: b */
    public final C11673f f23551b;

    /* JADX INFO: renamed from: c */
    public final String[] f23552c;

    /* JADX INFO: renamed from: d */
    public final String[] f23553d;

    /* JADX INFO: renamed from: e */
    public final String[] f23554e;

    /* JADX INFO: renamed from: f */
    public final String f23555f;

    /* JADX INFO: renamed from: g */
    public final int f23556g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.a$a */
    /* JADX INFO: compiled from: KotlinClassHeader.kt */
    public enum a {
        UNKNOWN(0),
        CLASS(1),
        FILE_FACADE(2),
        SYNTHETIC_CLASS(3),
        MULTIFILE_CLASS(4),
        MULTIFILE_CLASS_PART(5);


        /* JADX INFO: renamed from: j */
        public static final C13314a f23557j = new C13314a(null);

        /* JADX INFO: renamed from: k */
        public static final Map<Integer, a> f23558k;

        /* JADX INFO: renamed from: id */
        private final int f23566id;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.b0.a$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: KotlinClassHeader.kt */
        public static final class C13314a {
            public C13314a(DefaultConstructorMarker defaultConstructorMarker) {
            }

            public final a getById(int i) {
                a aVar = (a) a.f23558k.get(Integer.valueOf(i));
                return aVar == null ? a.UNKNOWN : aVar;
            }
        }

        static {
            a[] aVarArrValuesCustom = valuesCustom();
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(6), 16));
            for (int i = 0; i < 6; i++) {
                a aVar = aVarArrValuesCustom[i];
                linkedHashMap.put(Integer.valueOf(aVar.getId()), aVar);
            }
            f23558k = linkedHashMap;
        }

        a(int i) {
            this.f23566id = i;
        }

        public static final a getById(int i) {
            return f23557j.getById(i);
        }

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }

        public final int getId() {
            return this.f23566id;
        }
    }

    public C11636a(a aVar, C11673f c11673f, C11670c c11670c, String[] strArr, String[] strArr2, String[] strArr3, String str, int i, String str2) {
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(c11673f, "metadataVersion");
        C12238m.checkNotNullParameter(c11670c, "bytecodeVersion");
        this.f23550a = aVar;
        this.f23551b = c11673f;
        this.f23552c = strArr;
        this.f23553d = strArr2;
        this.f23554e = strArr3;
        this.f23555f = str;
        this.f23556g = i;
    }

    /* JADX INFO: renamed from: a */
    public final boolean m9538a(int i, int i2) {
        return (i & i2) != 0;
    }

    public final String[] getData() {
        return this.f23552c;
    }

    public final String[] getIncompatibleData() {
        return this.f23553d;
    }

    public final a getKind() {
        return this.f23550a;
    }

    public final C11673f getMetadataVersion() {
        return this.f23551b;
    }

    public final String getMultifileClassName() {
        String str = this.f23555f;
        if (getKind() == a.MULTIFILE_CLASS_PART) {
            return str;
        }
        return null;
    }

    public final List<String> getMultifilePartNames() {
        String[] strArr = this.f23552c;
        if (!(getKind() == a.MULTIFILE_CLASS)) {
            strArr = null;
        }
        List<String> listAsList = strArr != null ? C12139j.asList(strArr) : null;
        return listAsList != null ? listAsList : C12147n.emptyList();
    }

    public final String[] getStrings() {
        return this.f23554e;
    }

    public final boolean isPreRelease() {
        return m9538a(this.f23556g, 2);
    }

    public final boolean isUnstableFirBinary() {
        return m9538a(this.f23556g, 64) && !m9538a(this.f23556g, 32);
    }

    public final boolean isUnstableJvmIrBinary() {
        return m9538a(this.f23556g, 16) && !m9538a(this.f23556g, 32);
    }

    public String toString() {
        return this.f23550a + " version=" + this.f23551b;
    }
}
