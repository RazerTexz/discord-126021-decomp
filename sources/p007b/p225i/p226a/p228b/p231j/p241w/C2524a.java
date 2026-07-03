package p007b.p225i.p226a.p228b.p231j.p241w;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import java.util.EnumMap;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p228b.EnumC2409d;

/* JADX INFO: renamed from: b.i.a.b.j.w.a */
/* JADX INFO: compiled from: PriorityMapping.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2524a {

    /* JADX INFO: renamed from: a */
    public static SparseArray<EnumC2409d> f5461a = new SparseArray<>();

    /* JADX INFO: renamed from: b */
    public static EnumMap<EnumC2409d, Integer> f5462b;

    static {
        EnumMap<EnumC2409d, Integer> enumMap = new EnumMap<>(EnumC2409d.class);
        f5462b = enumMap;
        enumMap.put(EnumC2409d.DEFAULT, 0);
        f5462b.put(EnumC2409d.VERY_LOW, 1);
        f5462b.put(EnumC2409d.HIGHEST, 2);
        for (K k : f5462b.keySet()) {
            f5461a.append(f5462b.get(k).intValue(), k);
        }
    }

    /* JADX INFO: renamed from: a */
    public static int m2414a(@NonNull EnumC2409d enumC2409d) {
        Integer num = f5462b.get(enumC2409d);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC2409d);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public static EnumC2409d m2415b(int i) {
        EnumC2409d enumC2409d = f5461a.get(i);
        if (enumC2409d != null) {
            return enumC2409d;
        }
        throw new IllegalArgumentException(C1643a.m871q("Unknown Priority for value ", i));
    }
}
