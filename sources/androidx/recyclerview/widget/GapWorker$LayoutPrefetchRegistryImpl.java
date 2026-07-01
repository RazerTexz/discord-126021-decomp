package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"VisibleForTests"})
public class GapWorker$LayoutPrefetchRegistryImpl implements RecyclerView$LayoutManager$LayoutPrefetchRegistry {
    public int mCount;
    public int[] mPrefetchArray;
    public int mPrefetchDx;
    public int mPrefetchDy;

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager$LayoutPrefetchRegistry
    public void addPosition(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException("Layout positions must be non-negative");
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Pixel distance must be non-negative");
        }
        int i3 = this.mCount * 2;
        int[] iArr = this.mPrefetchArray;
        if (iArr == null) {
            int[] iArr2 = new int[4];
            this.mPrefetchArray = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i3 >= iArr.length) {
            int[] iArr3 = new int[i3 * 2];
            this.mPrefetchArray = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        }
        int[] iArr4 = this.mPrefetchArray;
        iArr4[i3] = i;
        iArr4[i3 + 1] = i2;
        this.mCount++;
    }

    public void clearPrefetchPositions() {
        int[] iArr = this.mPrefetchArray;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.mCount = 0;
    }

    public void collectPrefetchPositionsFromView(RecyclerView recyclerView, boolean z2) {
        this.mCount = 0;
        int[] iArr = this.mPrefetchArray;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        RecyclerView$LayoutManager recyclerView$LayoutManager = recyclerView.mLayout;
        if (recyclerView.mAdapter == null || recyclerView$LayoutManager == null || !recyclerView$LayoutManager.isItemPrefetchEnabled()) {
            return;
        }
        if (z2) {
            if (!recyclerView.mAdapterHelper.hasPendingUpdates()) {
                recyclerView$LayoutManager.collectInitialPrefetchPositions(recyclerView.mAdapter.getPageSize(), this);
            }
        } else if (!recyclerView.hasPendingAdapterUpdates()) {
            recyclerView$LayoutManager.collectAdjacentPrefetchPositions(this.mPrefetchDx, this.mPrefetchDy, recyclerView.mState, this);
        }
        int i = this.mCount;
        if (i > recyclerView$LayoutManager.mPrefetchMaxCountObserved) {
            recyclerView$LayoutManager.mPrefetchMaxCountObserved = i;
            recyclerView$LayoutManager.mPrefetchMaxObservedInInitialPrefetch = z2;
            recyclerView.mRecycler.updateViewCacheSize();
        }
    }

    public boolean lastPrefetchIncludedPosition(int i) {
        if (this.mPrefetchArray != null) {
            int i2 = this.mCount * 2;
            for (int i3 = 0; i3 < i2; i3 += 2) {
                if (this.mPrefetchArray[i3] == i) {
                    return true;
                }
            }
        }
        return false;
    }

    public void setPrefetchVector(int i, int i2) {
        this.mPrefetchDx = i;
        this.mPrefetchDy = i2;
    }
}
