package b.i.a.b.j.w;

import android.util.SparseArray;
import androidx.annotation.NonNull;
import b.d.b.a.outline;
import b.i.a.b.Priority3;
import java.util.EnumMap;

/* JADX INFO: renamed from: b.i.a.b.j.w.a, reason: use source file name */
/* JADX INFO: compiled from: PriorityMapping.java */
/* JADX INFO: loaded from: classes3.dex */
public final class PriorityMapping {
    public static SparseArray<Priority3> a = new SparseArray<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static EnumMap<Priority3, Integer> f804b;

    static {
        EnumMap<Priority3, Integer> enumMap = new EnumMap<>(Priority3.class);
        f804b = enumMap;
        enumMap.put(Priority3.DEFAULT, 0);
        f804b.put(Priority3.VERY_LOW, 1);
        f804b.put(Priority3.HIGHEST, 2);
        for (K k : f804b.keySet()) {
            a.append(f804b.get(k).intValue(), k);
        }
    }

    public static int a(@NonNull Priority3 priority3) {
        Integer num = f804b.get(priority3);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + priority3);
    }

    @NonNull
    public static Priority3 b(int i) {
        Priority3 priority3 = a.get(i);
        if (priority3 != null) {
            return priority3;
        }
        throw new IllegalArgumentException(outline.q("Unknown Priority for value ", i));
    }
}
