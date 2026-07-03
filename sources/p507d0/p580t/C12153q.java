package p507d0.p580t;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.t.q */
/* JADX INFO: compiled from: MutableCollectionsJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public class C12153q extends C12151p {
    public static final <T extends Comparable<? super T>> void sort(List<T> list) {
        C12238m.checkNotNullParameter(list, "$this$sort");
        if (list.size() > 1) {
            Collections.sort(list);
        }
    }

    public static final <T> void sortWith(List<T> list, Comparator<? super T> comparator) {
        C12238m.checkNotNullParameter(list, "$this$sortWith");
        C12238m.checkNotNullParameter(comparator, "comparator");
        if (list.size() > 1) {
            Collections.sort(list, comparator);
        }
    }
}
