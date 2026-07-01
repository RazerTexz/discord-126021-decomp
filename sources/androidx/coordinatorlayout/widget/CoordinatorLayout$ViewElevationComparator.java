package androidx.coordinatorlayout.widget;

import android.view.View;
import androidx.core.view.ViewCompat;
import java.util.Comparator;

/* JADX INFO: loaded from: classes.dex */
public class CoordinatorLayout$ViewElevationComparator implements Comparator<View> {
    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(View view, View view2) {
        return compare2(view, view2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public int compare2(View view, View view2) {
        float z2 = ViewCompat.getZ(view);
        float z3 = ViewCompat.getZ(view2);
        if (z2 > z3) {
            return -1;
        }
        return z2 < z3 ? 1 : 0;
    }
}
