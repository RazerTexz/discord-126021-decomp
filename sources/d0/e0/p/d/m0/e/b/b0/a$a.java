package d0.e0.p.d.m0.e.b.b0;

import d0.t.g0;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: compiled from: KotlinClassHeader.kt */
/* JADX INFO: loaded from: classes3.dex */
public enum a$a {
    UNKNOWN(0),
    CLASS(1),
    FILE_FACADE(2),
    SYNTHETIC_CLASS(3),
    MULTIFILE_CLASS(4),
    MULTIFILE_CLASS_PART(5);

    public static final a$a$a j = new a$a$a(null);
    public static final Map<Integer, a$a> k;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final int f3367id;

    static {
        a$a[] a_aArrValuesCustom = valuesCustom();
        LinkedHashMap linkedHashMap = new LinkedHashMap(d0.d0.f.coerceAtLeast(g0.mapCapacity(6), 16));
        for (int i = 0; i < 6; i++) {
            a$a a_a = a_aArrValuesCustom[i];
            linkedHashMap.put(Integer.valueOf(a_a.getId()), a_a);
        }
        k = linkedHashMap;
    }

    a$a(int i) {
        this.f3367id = i;
    }

    public static final /* synthetic */ Map access$getEntryById$cp() {
        return k;
    }

    public static final a$a getById(int i) {
        return j.getById(i);
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static a$a[] valuesCustom() {
        a$a[] a_aArrValuesCustom = values();
        a$a[] a_aArr = new a$a[a_aArrValuesCustom.length];
        System.arraycopy(a_aArrValuesCustom, 0, a_aArr, 0, a_aArrValuesCustom.length);
        return a_aArr;
    }

    public final int getId() {
        return this.f3367id;
    }
}
