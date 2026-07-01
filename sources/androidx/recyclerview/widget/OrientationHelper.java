package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;

/* JADX INFO: loaded from: classes.dex */
public abstract class OrientationHelper {
    public static final int HORIZONTAL = 0;
    private static final int INVALID_SIZE = Integer.MIN_VALUE;
    public static final int VERTICAL = 1;
    private int mLastTotalSpace;
    public final RecyclerView$LayoutManager mLayoutManager;
    public final Rect mTmpRect;

    public /* synthetic */ OrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager, OrientationHelper$1 orientationHelper$1) {
        this(recyclerView$LayoutManager);
    }

    public static OrientationHelper createHorizontalHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        return new OrientationHelper$1(recyclerView$LayoutManager);
    }

    public static OrientationHelper createOrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager, int i) {
        if (i == 0) {
            return createHorizontalHelper(recyclerView$LayoutManager);
        }
        if (i == 1) {
            return createVerticalHelper(recyclerView$LayoutManager);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public static OrientationHelper createVerticalHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        return new OrientationHelper$2(recyclerView$LayoutManager);
    }

    public abstract int getDecoratedEnd(View view);

    public abstract int getDecoratedMeasurement(View view);

    public abstract int getDecoratedMeasurementInOther(View view);

    public abstract int getDecoratedStart(View view);

    public abstract int getEnd();

    public abstract int getEndAfterPadding();

    public abstract int getEndPadding();

    public RecyclerView$LayoutManager getLayoutManager() {
        return this.mLayoutManager;
    }

    public abstract int getMode();

    public abstract int getModeInOther();

    public abstract int getStartAfterPadding();

    public abstract int getTotalSpace();

    public int getTotalSpaceChange() {
        if (Integer.MIN_VALUE == this.mLastTotalSpace) {
            return 0;
        }
        return getTotalSpace() - this.mLastTotalSpace;
    }

    public abstract int getTransformedEndWithDecoration(View view);

    public abstract int getTransformedStartWithDecoration(View view);

    public abstract void offsetChild(View view, int i);

    public abstract void offsetChildren(int i);

    public void onLayoutComplete() {
        this.mLastTotalSpace = getTotalSpace();
    }

    private OrientationHelper(RecyclerView$LayoutManager recyclerView$LayoutManager) {
        this.mLastTotalSpace = Integer.MIN_VALUE;
        this.mTmpRect = new Rect();
        this.mLayoutManager = recyclerView$LayoutManager;
    }
}
