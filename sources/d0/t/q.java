package d0.t;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class q extends p {
    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        d0.z.d.m.checkNotNullParameter(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        d0.z.d.m.checkNotNullParameter(list, "$this$sortWith");
        d0.z.d.m.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
