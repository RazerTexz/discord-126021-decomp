package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager$Span {
    public static final int INVALID_LINE = Integer.MIN_VALUE;
    public final int mIndex;
    public final /* synthetic */ StaggeredGridLayoutManager this$0;
    public ArrayList<View> mViews = new ArrayList<>();
    public int mCachedStart = Integer.MIN_VALUE;
    public int mCachedEnd = Integer.MIN_VALUE;
    public int mDeletedSize = 0;

    public StaggeredGridLayoutManager$Span(StaggeredGridLayoutManager staggeredGridLayoutManager, int i) {
        this.this$0 = staggeredGridLayoutManager;
        this.mIndex = i;
    }

    public void appendToSpan(View view) {
        StaggeredGridLayoutManager$LayoutParams layoutParams = getLayoutParams(view);
        layoutParams.mSpan = this;
        this.mViews.add(view);
        this.mCachedEnd = Integer.MIN_VALUE;
        if (this.mViews.size() == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize = this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
        }
    }

    public void cacheReferenceLineAndClear(boolean z2, int i) {
        int endLine = z2 ? getEndLine(Integer.MIN_VALUE) : getStartLine(Integer.MIN_VALUE);
        clear();
        if (endLine == Integer.MIN_VALUE) {
            return;
        }
        if (!z2 || endLine >= this.this$0.mPrimaryOrientation.getEndAfterPadding()) {
            if (z2 || endLine <= this.this$0.mPrimaryOrientation.getStartAfterPadding()) {
                if (i != Integer.MIN_VALUE) {
                    endLine += i;
                }
                this.mCachedEnd = endLine;
                this.mCachedStart = endLine;
            }
        }
    }

    public void calculateCachedEnd() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem fullSpanItem;
        ArrayList<View> arrayList = this.mViews;
        View view = arrayList.get(arrayList.size() - 1);
        StaggeredGridLayoutManager$LayoutParams layoutParams = getLayoutParams(view);
        this.mCachedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view);
        if (layoutParams.mFullSpan && (fullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == 1) {
            this.mCachedEnd = fullSpanItem.getGapForSpan(this.mIndex) + this.mCachedEnd;
        }
    }

    public void calculateCachedStart() {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem fullSpanItem;
        View view = this.mViews.get(0);
        StaggeredGridLayoutManager$LayoutParams layoutParams = getLayoutParams(view);
        this.mCachedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view);
        if (layoutParams.mFullSpan && (fullSpanItem = this.this$0.mLazySpanLookup.getFullSpanItem(layoutParams.getViewLayoutPosition())) != null && fullSpanItem.mGapDir == -1) {
            this.mCachedStart -= fullSpanItem.getGapForSpan(this.mIndex);
        }
    }

    public void clear() {
        this.mViews.clear();
        invalidateCache();
        this.mDeletedSize = 0;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(this.mViews.size() - 1, -1, true) : findOneVisibleChild(0, this.mViews.size(), true);
    }

    public int findFirstPartiallyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true) : findOnePartiallyVisibleChild(0, this.mViews.size(), true);
    }

    public int findFirstVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(this.mViews.size() - 1, -1, false) : findOneVisibleChild(0, this.mViews.size(), false);
    }

    public int findLastCompletelyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(0, this.mViews.size(), true) : findOneVisibleChild(this.mViews.size() - 1, -1, true);
    }

    public int findLastPartiallyVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOnePartiallyVisibleChild(0, this.mViews.size(), true) : findOnePartiallyVisibleChild(this.mViews.size() - 1, -1, true);
    }

    public int findLastVisibleItemPosition() {
        return this.this$0.mReverseLayout ? findOneVisibleChild(0, this.mViews.size(), false) : findOneVisibleChild(this.mViews.size() - 1, -1, false);
    }

    public int findOnePartiallyOrCompletelyVisibleChild(int i, int i2, boolean z2, boolean z3, boolean z4) {
        int startAfterPadding = this.this$0.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.this$0.mPrimaryOrientation.getEndAfterPadding();
        int i3 = i2 > i ? 1 : -1;
        while (i != i2) {
            View view = this.mViews.get(i);
            int decoratedStart = this.this$0.mPrimaryOrientation.getDecoratedStart(view);
            int decoratedEnd = this.this$0.mPrimaryOrientation.getDecoratedEnd(view);
            boolean z5 = false;
            boolean z6 = !z4 ? decoratedStart >= endAfterPadding : decoratedStart > endAfterPadding;
            if (!z4 ? decoratedEnd > startAfterPadding : decoratedEnd >= startAfterPadding) {
                z5 = true;
            }
            if (z6 && z5) {
                if (z2 && z3) {
                    if (decoratedStart >= startAfterPadding && decoratedEnd <= endAfterPadding) {
                        return this.this$0.getPosition(view);
                    }
                } else {
                    if (z3) {
                        return this.this$0.getPosition(view);
                    }
                    if (decoratedStart < startAfterPadding || decoratedEnd > endAfterPadding) {
                        return this.this$0.getPosition(view);
                    }
                }
            }
            i += i3;
        }
        return -1;
    }

    public int findOnePartiallyVisibleChild(int i, int i2, boolean z2) {
        return findOnePartiallyOrCompletelyVisibleChild(i, i2, false, false, z2);
    }

    public int findOneVisibleChild(int i, int i2, boolean z2) {
        return findOnePartiallyOrCompletelyVisibleChild(i, i2, z2, true, false);
    }

    public int getDeletedSize() {
        return this.mDeletedSize;
    }

    public int getEndLine(int i) {
        int i2 = this.mCachedEnd;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.mViews.size() == 0) {
            return i;
        }
        calculateCachedEnd();
        return this.mCachedEnd;
    }

    public View getFocusableViewAfter(int i, int i2) {
        View view = null;
        if (i2 != -1) {
            int size = this.mViews.size() - 1;
            while (size >= 0) {
                View view2 = this.mViews.get(size);
                StaggeredGridLayoutManager staggeredGridLayoutManager = this.this$0;
                if (staggeredGridLayoutManager.mReverseLayout && staggeredGridLayoutManager.getPosition(view2) >= i) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager2 = this.this$0;
                if ((!staggeredGridLayoutManager2.mReverseLayout && staggeredGridLayoutManager2.getPosition(view2) <= i) || !view2.hasFocusable()) {
                    break;
                }
                size--;
                view = view2;
            }
        } else {
            int size2 = this.mViews.size();
            int i3 = 0;
            while (i3 < size2) {
                View view3 = this.mViews.get(i3);
                StaggeredGridLayoutManager staggeredGridLayoutManager3 = this.this$0;
                if (staggeredGridLayoutManager3.mReverseLayout && staggeredGridLayoutManager3.getPosition(view3) <= i) {
                    break;
                }
                StaggeredGridLayoutManager staggeredGridLayoutManager4 = this.this$0;
                if ((!staggeredGridLayoutManager4.mReverseLayout && staggeredGridLayoutManager4.getPosition(view3) >= i) || !view3.hasFocusable()) {
                    break;
                }
                i3++;
                view = view3;
            }
        }
        return view;
    }

    public StaggeredGridLayoutManager$LayoutParams getLayoutParams(View view) {
        return (StaggeredGridLayoutManager$LayoutParams) view.getLayoutParams();
    }

    public int getStartLine(int i) {
        int i2 = this.mCachedStart;
        if (i2 != Integer.MIN_VALUE) {
            return i2;
        }
        if (this.mViews.size() == 0) {
            return i;
        }
        calculateCachedStart();
        return this.mCachedStart;
    }

    public void invalidateCache() {
        this.mCachedStart = Integer.MIN_VALUE;
        this.mCachedEnd = Integer.MIN_VALUE;
    }

    public void onOffset(int i) {
        int i2 = this.mCachedStart;
        if (i2 != Integer.MIN_VALUE) {
            this.mCachedStart = i2 + i;
        }
        int i3 = this.mCachedEnd;
        if (i3 != Integer.MIN_VALUE) {
            this.mCachedEnd = i3 + i;
        }
    }

    public void popEnd() {
        int size = this.mViews.size();
        View viewRemove = this.mViews.remove(size - 1);
        StaggeredGridLayoutManager$LayoutParams layoutParams = getLayoutParams(viewRemove);
        layoutParams.mSpan = null;
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(viewRemove);
        }
        if (size == 1) {
            this.mCachedStart = Integer.MIN_VALUE;
        }
        this.mCachedEnd = Integer.MIN_VALUE;
    }

    public void popStart() {
        View viewRemove = this.mViews.remove(0);
        StaggeredGridLayoutManager$LayoutParams layoutParams = getLayoutParams(viewRemove);
        layoutParams.mSpan = null;
        if (this.mViews.size() == 0) {
            this.mCachedEnd = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize -= this.this$0.mPrimaryOrientation.getDecoratedMeasurement(viewRemove);
        }
        this.mCachedStart = Integer.MIN_VALUE;
    }

    public void prependToSpan(View view) {
        StaggeredGridLayoutManager$LayoutParams layoutParams = getLayoutParams(view);
        layoutParams.mSpan = this;
        this.mViews.add(0, view);
        this.mCachedStart = Integer.MIN_VALUE;
        if (this.mViews.size() == 1) {
            this.mCachedEnd = Integer.MIN_VALUE;
        }
        if (layoutParams.isItemRemoved() || layoutParams.isItemChanged()) {
            this.mDeletedSize = this.this$0.mPrimaryOrientation.getDecoratedMeasurement(view) + this.mDeletedSize;
        }
    }

    public void setLine(int i) {
        this.mCachedStart = i;
        this.mCachedEnd = i;
    }

    public int getEndLine() {
        int i = this.mCachedEnd;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        calculateCachedEnd();
        return this.mCachedEnd;
    }

    public int getStartLine() {
        int i = this.mCachedStart;
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        calculateCachedStart();
        return this.mCachedStart;
    }
}
