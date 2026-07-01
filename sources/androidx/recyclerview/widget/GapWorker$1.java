package androidx.recyclerview.widget;

import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class GapWorker$1 implements Comparator<GapWorker$Task> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(GapWorker$Task gapWorker$Task, GapWorker$Task gapWorker$Task2) {
        return compare2(gapWorker$Task, gapWorker$Task2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(GapWorker$Task gapWorker$Task, GapWorker$Task gapWorker$Task2) {
        RecyclerView recyclerView = gapWorker$Task.view;
        if ((recyclerView == null) != (gapWorker$Task2.view == null)) {
            return recyclerView == null ? 1 : -1;
        }
        boolean z2 = gapWorker$Task.immediate;
        if (z2 != gapWorker$Task2.immediate) {
            return z2 ? -1 : 1;
        }
        int i = gapWorker$Task2.viewVelocity - gapWorker$Task.viewVelocity;
        if (i != 0) {
            return i;
        }
        int i2 = gapWorker$Task.distanceToItem - gapWorker$Task2.distanceToItem;
        if (i2 != 0) {
            return i2;
        }
        return 0;
    }
}
