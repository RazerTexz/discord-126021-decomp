package d0.t;

import d0.z.d.Intrinsics3;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: d0.t.q, reason: use source file name */
/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class MutableCollectionsJVM extends Iterators7 {
    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortWith");
        Intrinsics3.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
