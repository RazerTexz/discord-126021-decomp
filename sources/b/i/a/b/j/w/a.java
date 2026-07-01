package b.i.a.b.j.w;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import b.i.a.b.d;
import java.util.EnumMap;

/* JADX INFO: compiled from: PriorityMapping.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public static SparseArray<d> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static EnumMap<d, Integer> f804b;

    static {
        EnumMap<d, Integer> enumMap = new EnumMap<>(d.class);
        f804b = enumMap;
        enumMap.put(d.DEFAULT, 0);
        f804b.put(d.VERY_LOW, 1);
        f804b.put(d.HIGHEST, 2);
        for (K k : f804b.keySet()) {
            a.append(f804b.get(k).intValue(), k);
        }
    }

    public static int a(@NonNull d dVar) {
        Integer num = f804b.get(dVar);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + dVar);
    }

    @NonNull
    public static d b(int i) {
        d dVar = a.get(i);
        if (dVar != null) {
            return dVar;
        }
        throw new IllegalArgumentException(b.d.b.a.a.q("Unknown Priority for value ", i));
    }
}
