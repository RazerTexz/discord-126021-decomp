package androidx.recyclerview.widget;

import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public class ScrollbarHelper {
    private ScrollbarHelper() {
    }

    public static int computeScrollExtent(RecyclerView$State recyclerView$State, OrientationHelper orientationHelper, View view, View view2, RecyclerView$LayoutManager recyclerView$LayoutManager, boolean z2) {
        if (recyclerView$LayoutManager.getChildCount() == 0 || recyclerView$State.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return Math.abs(recyclerView$LayoutManager.getPosition(view) - recyclerView$LayoutManager.getPosition(view2)) + 1;
        }
        return Math.min(orientationHelper.getTotalSpace(), orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view));
    }

    public static int computeScrollOffset(RecyclerView$State recyclerView$State, OrientationHelper orientationHelper, View view, View view2, RecyclerView$LayoutManager recyclerView$LayoutManager, boolean z2, boolean z3) {
        if (recyclerView$LayoutManager.getChildCount() == 0 || recyclerView$State.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        int iMax = z3 ? Math.max(0, (recyclerView$State.getItemCount() - Math.max(recyclerView$LayoutManager.getPosition(view), recyclerView$LayoutManager.getPosition(view2))) - 1) : Math.max(0, Math.min(recyclerView$LayoutManager.getPosition(view), recyclerView$LayoutManager.getPosition(view2)));
        if (z2) {
            return Math.round((iMax * (Math.abs(orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(recyclerView$LayoutManager.getPosition(view) - recyclerView$LayoutManager.getPosition(view2)) + 1))) + (orientationHelper.getStartAfterPadding() - orientationHelper.getDecoratedStart(view)));
        }
        return iMax;
    }

    public static int computeScrollRange(RecyclerView$State recyclerView$State, OrientationHelper orientationHelper, View view, View view2, RecyclerView$LayoutManager recyclerView$LayoutManager, boolean z2) {
        if (recyclerView$LayoutManager.getChildCount() == 0 || recyclerView$State.getItemCount() == 0 || view == null || view2 == null) {
            return 0;
        }
        if (!z2) {
            return recyclerView$State.getItemCount();
        }
        return (int) (((orientationHelper.getDecoratedEnd(view2) - orientationHelper.getDecoratedStart(view)) / (Math.abs(recyclerView$LayoutManager.getPosition(view) - recyclerView$LayoutManager.getPosition(view2)) + 1)) * recyclerView$State.getItemCount());
    }
}
