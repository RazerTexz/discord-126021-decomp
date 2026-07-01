package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import b.d.b.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    private static final boolean DEBUG = false;
    public static final int DEFAULT_SPAN_COUNT = -1;
    private static final String TAG = "GridLayoutManager";
    public int[] mCachedBorders;
    public final Rect mDecorInsets;
    public boolean mPendingSpanCountChange;
    public final SparseIntArray mPreLayoutSpanIndexCache;
    public final SparseIntArray mPreLayoutSpanSizeCache;
    public View[] mSet;
    public int mSpanCount;
    public GridLayoutManager$SpanSizeLookup mSpanSizeLookup;
    private boolean mUsingSpansToEstimateScrollBarDimensions;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new GridLayoutManager$DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(RecyclerView$LayoutManager.getProperties(context, attributeSet, i, i2).spanCount);
    }

    private void assignSpans(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int i, boolean z2) {
        int i2;
        int i3;
        int i4 = 0;
        int i5 = -1;
        if (z2) {
            i5 = i;
            i2 = 0;
            i3 = 1;
        } else {
            i2 = i - 1;
            i3 = -1;
        }
        while (i2 != i5) {
            View view = this.mSet[i2];
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams) view.getLayoutParams();
            int spanSize = getSpanSize(recyclerView$Recycler, recyclerView$State, getPosition(view));
            gridLayoutManager$LayoutParams.mSpanSize = spanSize;
            gridLayoutManager$LayoutParams.mSpanIndex = i4;
            i4 += spanSize;
            i2 += i3;
        }
    }

    private void cachePreLayoutSpanMapping() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams) getChildAt(i).getLayoutParams();
            int viewLayoutPosition = gridLayoutManager$LayoutParams.getViewLayoutPosition();
            this.mPreLayoutSpanSizeCache.put(viewLayoutPosition, gridLayoutManager$LayoutParams.getSpanSize());
            this.mPreLayoutSpanIndexCache.put(viewLayoutPosition, gridLayoutManager$LayoutParams.getSpanIndex());
        }
    }

    private void calculateItemBorders(int i) {
        this.mCachedBorders = calculateItemBorders(this.mCachedBorders, this.mSpanCount, i);
    }

    private void clearPreLayoutSpanMappingCache() {
        this.mPreLayoutSpanSizeCache.clear();
        this.mPreLayoutSpanIndexCache.clear();
    }

    private int computeScrollOffsetWithSpanInfo(RecyclerView$State recyclerView$State) {
        if (getChildCount() != 0 && recyclerView$State.getItemCount() != 0) {
            ensureLayoutState();
            boolean zIsSmoothScrollbarEnabled = isSmoothScrollbarEnabled();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!zIsSmoothScrollbarEnabled, true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!zIsSmoothScrollbarEnabled, true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                int cachedSpanGroupIndex = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount);
                int cachedSpanGroupIndex2 = this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount);
                int iMax = this.mShouldReverseLayout ? Math.max(0, ((this.mSpanSizeLookup.getCachedSpanGroupIndex(recyclerView$State.getItemCount() - 1, this.mSpanCount) + 1) - Math.max(cachedSpanGroupIndex, cachedSpanGroupIndex2)) - 1) : Math.max(0, Math.min(cachedSpanGroupIndex, cachedSpanGroupIndex2));
                if (zIsSmoothScrollbarEnabled) {
                    return Math.round((iMax * (Math.abs(this.mOrientationHelper.getDecoratedEnd(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1))) + (this.mOrientationHelper.getStartAfterPadding() - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)));
                }
                return iMax;
            }
        }
        return 0;
    }

    private int computeScrollRangeWithSpanInfo(RecyclerView$State recyclerView$State) {
        if (getChildCount() != 0 && recyclerView$State.getItemCount() != 0) {
            ensureLayoutState();
            View viewFindFirstVisibleChildClosestToStart = findFirstVisibleChildClosestToStart(!isSmoothScrollbarEnabled(), true);
            View viewFindFirstVisibleChildClosestToEnd = findFirstVisibleChildClosestToEnd(!isSmoothScrollbarEnabled(), true);
            if (viewFindFirstVisibleChildClosestToStart != null && viewFindFirstVisibleChildClosestToEnd != null) {
                if (!isSmoothScrollbarEnabled()) {
                    return this.mSpanSizeLookup.getCachedSpanGroupIndex(recyclerView$State.getItemCount() - 1, this.mSpanCount) + 1;
                }
                return (int) (((this.mOrientationHelper.getDecoratedEnd(viewFindFirstVisibleChildClosestToEnd) - this.mOrientationHelper.getDecoratedStart(viewFindFirstVisibleChildClosestToStart)) / ((this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToEnd), this.mSpanCount) - this.mSpanSizeLookup.getCachedSpanGroupIndex(getPosition(viewFindFirstVisibleChildClosestToStart), this.mSpanCount)) + 1)) * (this.mSpanSizeLookup.getCachedSpanGroupIndex(recyclerView$State.getItemCount() - 1, this.mSpanCount) + 1));
            }
        }
        return 0;
    }

    private void ensureAnchorIsInCorrectSpan(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo, int i) {
        boolean z2 = i == 1;
        int spanIndex = getSpanIndex(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo.mPosition);
        if (z2) {
            while (spanIndex > 0) {
                int i2 = linearLayoutManager$AnchorInfo.mPosition;
                if (i2 <= 0) {
                    return;
                }
                int i3 = i2 - 1;
                linearLayoutManager$AnchorInfo.mPosition = i3;
                spanIndex = getSpanIndex(recyclerView$Recycler, recyclerView$State, i3);
            }
            return;
        }
        int itemCount = recyclerView$State.getItemCount() - 1;
        int i4 = linearLayoutManager$AnchorInfo.mPosition;
        while (i4 < itemCount) {
            int i5 = i4 + 1;
            int spanIndex2 = getSpanIndex(recyclerView$Recycler, recyclerView$State, i5);
            if (spanIndex2 <= spanIndex) {
                break;
            }
            i4 = i5;
            spanIndex = spanIndex2;
        }
        linearLayoutManager$AnchorInfo.mPosition = i4;
    }

    private void ensureViewSet() {
        View[] viewArr = this.mSet;
        if (viewArr == null || viewArr.length != this.mSpanCount) {
            this.mSet = new View[this.mSpanCount];
        }
    }

    private int getSpanGroupIndex(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int i) {
        if (!recyclerView$State.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(i, this.mSpanCount);
        }
        int iConvertPreLayoutPositionToPostLayout = recyclerView$Recycler.convertPreLayoutPositionToPostLayout(i);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanGroupIndex(iConvertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    private int getSpanIndex(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int i) {
        if (!recyclerView$State.isPreLayout()) {
            return this.mSpanSizeLookup.getCachedSpanIndex(i, this.mSpanCount);
        }
        int i2 = this.mPreLayoutSpanIndexCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iConvertPreLayoutPositionToPostLayout = recyclerView$Recycler.convertPreLayoutPositionToPostLayout(i);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getCachedSpanIndex(iConvertPreLayoutPositionToPostLayout, this.mSpanCount);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    private int getSpanSize(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int i) {
        if (!recyclerView$State.isPreLayout()) {
            return this.mSpanSizeLookup.getSpanSize(i);
        }
        int i2 = this.mPreLayoutSpanSizeCache.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        int iConvertPreLayoutPositionToPostLayout = recyclerView$Recycler.convertPreLayoutPositionToPostLayout(i);
        if (iConvertPreLayoutPositionToPostLayout != -1) {
            return this.mSpanSizeLookup.getSpanSize(iConvertPreLayoutPositionToPostLayout);
        }
        Log.w(TAG, "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    private void guessMeasurement(float f, int i) {
        calculateItemBorders(Math.max(Math.round(f * this.mSpanCount), i));
    }

    private void measureChild(View view, int i, boolean z2) {
        int childMeasureSpec;
        int childMeasureSpec2;
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams) view.getLayoutParams();
        Rect rect = gridLayoutManager$LayoutParams.mDecorInsets;
        int i2 = rect.top + rect.bottom + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).topMargin + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).bottomMargin;
        int i3 = rect.left + rect.right + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).rightMargin;
        int spaceForSpanRange = getSpaceForSpanRange(gridLayoutManager$LayoutParams.mSpanIndex, gridLayoutManager$LayoutParams.mSpanSize);
        if (this.mOrientation == 1) {
            childMeasureSpec2 = RecyclerView$LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i3, ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).width, false);
            childMeasureSpec = RecyclerView$LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getHeightMode(), i2, ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).height, true);
        } else {
            int childMeasureSpec3 = RecyclerView$LayoutManager.getChildMeasureSpec(spaceForSpanRange, i, i2, ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).height, false);
            int childMeasureSpec4 = RecyclerView$LayoutManager.getChildMeasureSpec(this.mOrientationHelper.getTotalSpace(), getWidthMode(), i3, ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).width, true);
            childMeasureSpec = childMeasureSpec3;
            childMeasureSpec2 = childMeasureSpec4;
        }
        measureChildWithDecorationsAndMargin(view, childMeasureSpec2, childMeasureSpec, z2);
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z2) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        if (z2 ? shouldReMeasureChild(view, i, i2, recyclerView$LayoutParams) : shouldMeasureChild(view, i, i2, recyclerView$LayoutParams)) {
            view.measure(i, i2);
        }
    }

    private void updateMeasurements() {
        int height;
        int paddingTop;
        if (getOrientation() == 1) {
            height = getWidth() - getPaddingRight();
            paddingTop = getPaddingLeft();
        } else {
            height = getHeight() - getPaddingBottom();
            paddingTop = getPaddingTop();
        }
        calculateItemBorders(height - paddingTop);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof GridLayoutManager$LayoutParams;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void collectPrefetchPositionsForLayoutState(RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int spanSize = this.mSpanCount;
        for (int i = 0; i < this.mSpanCount && linearLayoutManager$LayoutState.hasMore(recyclerView$State) && spanSize > 0; i++) {
            int i2 = linearLayoutManager$LayoutState.mCurrentPosition;
            recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(i2, Math.max(0, linearLayoutManager$LayoutState.mScrollingOffset));
            spanSize -= this.mSpanSizeLookup.getSpanSize(i2);
            linearLayoutManager$LayoutState.mCurrentPosition += linearLayoutManager$LayoutState.mItemDirection;
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView$State recyclerView$State) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(recyclerView$State) : super.computeHorizontalScrollOffset(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollRange(RecyclerView$State recyclerView$State) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(recyclerView$State) : super.computeHorizontalScrollRange(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollOffset(RecyclerView$State recyclerView$State) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollOffsetWithSpanInfo(recyclerView$State) : super.computeVerticalScrollOffset(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollRange(RecyclerView$State recyclerView$State) {
        return this.mUsingSpansToEstimateScrollBarDimensions ? computeScrollRangeWithSpanInfo(recyclerView$State) : super.computeVerticalScrollRange(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public View findReferenceChild(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2, boolean z3) {
        int childCount;
        int childCount2 = getChildCount();
        int i = -1;
        int i2 = 1;
        if (z3) {
            childCount = getChildCount() - 1;
            i2 = -1;
        } else {
            i = childCount2;
            childCount = 0;
        }
        int itemCount = recyclerView$State.getItemCount();
        ensureLayoutState();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            if (position >= 0 && position < itemCount && getSpanIndex(recyclerView$Recycler, recyclerView$State, position) == 0) {
                if (((RecyclerView$LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    if (view2 == null) {
                        view2 = childAt;
                    }
                } else {
                    if (this.mOrientationHelper.getDecoratedStart(childAt) < endAfterPadding && this.mOrientationHelper.getDecoratedEnd(childAt) >= startAfterPadding) {
                        return childAt;
                    }
                    if (view == null) {
                        view = childAt;
                    }
                }
            }
            childCount += i2;
        }
        return view != null ? view : view2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new GridLayoutManager$LayoutParams(-2, -1) : new GridLayoutManager$LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new GridLayoutManager$LayoutParams(context, attributeSet);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int getColumnCountForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (this.mOrientation == 1) {
            return this.mSpanCount;
        }
        if (recyclerView$State.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recyclerView$Recycler, recyclerView$State, recyclerView$State.getItemCount() - 1) + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int getRowCountForAccessibility(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (this.mOrientation == 0) {
            return this.mSpanCount;
        }
        if (recyclerView$State.getItemCount() < 1) {
            return 0;
        }
        return getSpanGroupIndex(recyclerView$Recycler, recyclerView$State, recyclerView$State.getItemCount() - 1) + 1;
    }

    public int getSpaceForSpanRange(int i, int i2) {
        if (this.mOrientation != 1 || !isLayoutRTL()) {
            int[] iArr = this.mCachedBorders;
            return iArr[i2 + i] - iArr[i];
        }
        int[] iArr2 = this.mCachedBorders;
        int i3 = this.mSpanCount;
        return iArr2[i3 - i] - iArr2[(i3 - i) - i2];
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    public GridLayoutManager$SpanSizeLookup getSpanSizeLookup() {
        return this.mSpanSizeLookup;
    }

    public boolean isUsingSpansToEstimateScrollbarDimensions() {
        return this.mUsingSpansToEstimateScrollBarDimensions;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v21 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void layoutChunk(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int decoratedMeasurementInOther;
        int i6;
        int i7;
        int paddingLeft;
        int decoratedMeasurementInOther2;
        int childMeasureSpec;
        int childMeasureSpec2;
        View next;
        int modeInOther = this.mOrientationHelper.getModeInOther();
        ?? r5 = 0;
        boolean z2 = modeInOther != 1073741824;
        int i8 = getChildCount() > 0 ? this.mCachedBorders[this.mSpanCount] : 0;
        if (z2) {
            updateMeasurements();
        }
        boolean z3 = linearLayoutManager$LayoutState.mItemDirection == 1;
        int spanIndex = this.mSpanCount;
        if (!z3) {
            spanIndex = getSpanIndex(recyclerView$Recycler, recyclerView$State, linearLayoutManager$LayoutState.mCurrentPosition) + getSpanSize(recyclerView$Recycler, recyclerView$State, linearLayoutManager$LayoutState.mCurrentPosition);
        }
        int i9 = 0;
        while (i9 < this.mSpanCount && linearLayoutManager$LayoutState.hasMore(recyclerView$State) && spanIndex > 0) {
            int i10 = linearLayoutManager$LayoutState.mCurrentPosition;
            int spanSize = getSpanSize(recyclerView$Recycler, recyclerView$State, i10);
            if (spanSize > this.mSpanCount) {
                throw new IllegalArgumentException(a.B(a.W("Item at position ", i10, " requires ", spanSize, " spans but GridLayoutManager has only "), this.mSpanCount, " spans."));
            }
            spanIndex -= spanSize;
            if (spanIndex < 0 || (next = linearLayoutManager$LayoutState.next(recyclerView$Recycler)) == null) {
                break;
            }
            this.mSet[i9] = next;
            i9++;
        }
        if (i9 == 0) {
            linearLayoutManager$LayoutChunkResult.mFinished = true;
            return;
        }
        float f = 0.0f;
        assignSpans(recyclerView$Recycler, recyclerView$State, i9, z3);
        int i11 = 0;
        int i12 = 0;
        while (i11 < i9) {
            View view = this.mSet[i11];
            if (linearLayoutManager$LayoutState.mScrapList == null) {
                if (z3) {
                    addView(view);
                } else {
                    addView(view, r5);
                }
            } else if (z3) {
                addDisappearingView(view);
            } else {
                addDisappearingView(view, r5);
            }
            calculateItemDecorationsForChild(view, this.mDecorInsets);
            measureChild(view, modeInOther, (boolean) r5);
            int decoratedMeasurement = this.mOrientationHelper.getDecoratedMeasurement(view);
            if (decoratedMeasurement > i12) {
                i12 = decoratedMeasurement;
            }
            float decoratedMeasurementInOther3 = (this.mOrientationHelper.getDecoratedMeasurementInOther(view) * 1.0f) / ((GridLayoutManager$LayoutParams) view.getLayoutParams()).mSpanSize;
            if (decoratedMeasurementInOther3 > f) {
                f = decoratedMeasurementInOther3;
            }
            i11++;
            r5 = 0;
        }
        if (z2) {
            guessMeasurement(f, i8);
            i12 = 0;
            for (int i13 = 0; i13 < i9; i13++) {
                View view2 = this.mSet[i13];
                measureChild(view2, BasicMeasure.EXACTLY, true);
                int decoratedMeasurement2 = this.mOrientationHelper.getDecoratedMeasurement(view2);
                if (decoratedMeasurement2 > i12) {
                    i12 = decoratedMeasurement2;
                }
            }
        }
        for (int i14 = 0; i14 < i9; i14++) {
            View view3 = this.mSet[i14];
            if (this.mOrientationHelper.getDecoratedMeasurement(view3) != i12) {
                GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams) view3.getLayoutParams();
                Rect rect = gridLayoutManager$LayoutParams.mDecorInsets;
                int i15 = rect.top + rect.bottom + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).topMargin + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).bottomMargin;
                int i16 = rect.left + rect.right + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).rightMargin;
                int spaceForSpanRange = getSpaceForSpanRange(gridLayoutManager$LayoutParams.mSpanIndex, gridLayoutManager$LayoutParams.mSpanSize);
                if (this.mOrientation == 1) {
                    childMeasureSpec2 = RecyclerView$LayoutManager.getChildMeasureSpec(spaceForSpanRange, BasicMeasure.EXACTLY, i16, ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).width, false);
                    childMeasureSpec = View$MeasureSpec.makeMeasureSpec(i12 - i15, BasicMeasure.EXACTLY);
                } else {
                    int iMakeMeasureSpec = View$MeasureSpec.makeMeasureSpec(i12 - i16, BasicMeasure.EXACTLY);
                    childMeasureSpec = RecyclerView$LayoutManager.getChildMeasureSpec(spaceForSpanRange, BasicMeasure.EXACTLY, i15, ((ViewGroup$MarginLayoutParams) gridLayoutManager$LayoutParams).height, false);
                    childMeasureSpec2 = iMakeMeasureSpec;
                }
                measureChildWithDecorationsAndMargin(view3, childMeasureSpec2, childMeasureSpec, true);
            }
        }
        linearLayoutManager$LayoutChunkResult.mConsumed = i12;
        if (this.mOrientation == 1) {
            if (linearLayoutManager$LayoutState.mLayoutDirection == -1) {
                i3 = linearLayoutManager$LayoutState.mOffset;
                i4 = i3 - i12;
            } else {
                int i17 = linearLayoutManager$LayoutState.mOffset;
                i3 = i12 + i17;
                i4 = i17;
            }
            i2 = 0;
            i = 0;
        } else if (linearLayoutManager$LayoutState.mLayoutDirection == -1) {
            i2 = linearLayoutManager$LayoutState.mOffset;
            i = i2 - i12;
            i4 = 0;
            i3 = 0;
        } else {
            i = linearLayoutManager$LayoutState.mOffset;
            i2 = i12 + i;
            i3 = 0;
            i4 = 0;
        }
        int i18 = 0;
        while (i18 < i9) {
            View view4 = this.mSet[i18];
            GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams2 = (GridLayoutManager$LayoutParams) view4.getLayoutParams();
            if (this.mOrientation == 1) {
                if (isLayoutRTL()) {
                    decoratedMeasurementInOther2 = getPaddingLeft() + this.mCachedBorders[this.mSpanCount - gridLayoutManager$LayoutParams2.mSpanIndex];
                    paddingLeft = decoratedMeasurementInOther2 - this.mOrientationHelper.getDecoratedMeasurementInOther(view4);
                } else {
                    paddingLeft = this.mCachedBorders[gridLayoutManager$LayoutParams2.mSpanIndex] + getPaddingLeft();
                    decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingLeft;
                }
                i6 = decoratedMeasurementInOther2;
                i5 = i4;
                decoratedMeasurementInOther = i3;
                i7 = paddingLeft;
            } else {
                int paddingTop = getPaddingTop() + this.mCachedBorders[gridLayoutManager$LayoutParams2.mSpanIndex];
                i5 = paddingTop;
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(view4) + paddingTop;
                i6 = i2;
                i7 = i;
            }
            layoutDecoratedWithMargins(view4, i7, i5, i6, decoratedMeasurementInOther);
            if (gridLayoutManager$LayoutParams2.isItemRemoved() || gridLayoutManager$LayoutParams2.isItemChanged()) {
                linearLayoutManager$LayoutChunkResult.mIgnoreConsumed = true;
            }
            linearLayoutManager$LayoutChunkResult.mFocusable |= view4.hasFocusable();
            i18++;
            i4 = i5;
            i3 = decoratedMeasurementInOther;
            i2 = i6;
            i = i7;
        }
        Arrays.fill(this.mSet, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void onAnchorReady(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo, int i) {
        super.onAnchorReady(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo, i);
        updateMeasurements();
        if (recyclerView$State.getItemCount() > 0 && !recyclerView$State.isPreLayout()) {
            ensureAnchorIsInCorrectSpan(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo, i);
        }
        ensureViewSet();
    }

    /* JADX WARN: Code duplicated, block: B:79:0x0107  */
    /* JADX WARN: Code duplicated, block: B:81:0x010d  */
    /* JADX WARN: Code duplicated, block: B:82:0x0123  */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d6, code lost:
    
        if (r13 == (r2 > r15)) goto L49;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public View onFocusSearchFailed(View view, int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int childCount;
        int childCount2;
        int i2;
        View view2;
        View view3;
        int i3;
        int i4;
        boolean z2;
        int i5;
        int i6;
        RecyclerView$Recycler recyclerView$Recycler2 = recyclerView$Recycler;
        RecyclerView$State recyclerView$State2 = recyclerView$State;
        View viewFindContainingItemView = findContainingItemView(view);
        View view4 = null;
        if (viewFindContainingItemView == null) {
            return null;
        }
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams) viewFindContainingItemView.getLayoutParams();
        int i7 = gridLayoutManager$LayoutParams.mSpanIndex;
        int i8 = gridLayoutManager$LayoutParams.mSpanSize + i7;
        if (super.onFocusSearchFailed(view, i, recyclerView$Recycler, recyclerView$State) == null) {
            return null;
        }
        if ((convertFocusDirectionToLayoutDirection(i) == 1) != this.mShouldReverseLayout) {
            childCount2 = getChildCount() - 1;
            childCount = -1;
            i2 = -1;
        } else {
            childCount = getChildCount();
            childCount2 = 0;
            i2 = 1;
        }
        boolean z3 = this.mOrientation == 1 && isLayoutRTL();
        int spanGroupIndex = getSpanGroupIndex(recyclerView$Recycler2, recyclerView$State2, childCount2);
        int i9 = childCount2;
        int iMin = 0;
        int i10 = -1;
        int i11 = -1;
        int iMin2 = 0;
        View view5 = null;
        while (i9 != childCount) {
            int spanGroupIndex2 = getSpanGroupIndex(recyclerView$Recycler2, recyclerView$State2, i9);
            View childAt = getChildAt(i9);
            if (childAt == viewFindContainingItemView) {
                break;
            }
            if (!childAt.hasFocusable() || spanGroupIndex2 == spanGroupIndex) {
                GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams2 = (GridLayoutManager$LayoutParams) childAt.getLayoutParams();
                int i12 = gridLayoutManager$LayoutParams2.mSpanIndex;
                view2 = viewFindContainingItemView;
                int i13 = gridLayoutManager$LayoutParams2.mSpanSize + i12;
                if (childAt.hasFocusable() && i12 == i7 && i13 == i8) {
                    return childAt;
                }
                if (!(childAt.hasFocusable() && view4 == null) && (childAt.hasFocusable() || view5 != null)) {
                    view3 = view5;
                    int iMin3 = Math.min(i13, i8) - Math.max(i12, i7);
                    if (!childAt.hasFocusable()) {
                        if (view4 == null) {
                            i3 = iMin;
                            i4 = childCount;
                            z2 = true;
                            if (isViewPartiallyVisible(childAt, false, true)) {
                                i5 = iMin2;
                                if (iMin3 > i5) {
                                    i6 = i11;
                                } else if (iMin3 == i5) {
                                    i6 = i11;
                                    if (z3 == (i12 > i6)) {
                                        z2 = true;
                                    }
                                } else {
                                    i6 = i11;
                                }
                                if (z2) {
                                    if (childAt.hasFocusable()) {
                                        i10 = gridLayoutManager$LayoutParams2.mSpanIndex;
                                        i11 = i6;
                                        iMin2 = i5;
                                        view5 = view3;
                                        view4 = childAt;
                                        iMin = Math.min(i13, i8) - Math.max(i12, i7);
                                    } else {
                                        int i14 = gridLayoutManager$LayoutParams2.mSpanIndex;
                                        iMin2 = Math.min(i13, i8) - Math.max(i12, i7);
                                        i11 = i14;
                                        iMin = i3;
                                        view5 = childAt;
                                    }
                                }
                                i9 += i2;
                                recyclerView$Recycler2 = recyclerView$Recycler;
                                recyclerView$State2 = recyclerView$State;
                                viewFindContainingItemView = view2;
                                childCount = i4;
                            }
                            z2 = false;
                            if (z2) {
                                if (childAt.hasFocusable()) {
                                    i10 = gridLayoutManager$LayoutParams2.mSpanIndex;
                                    i11 = i6;
                                    iMin2 = i5;
                                    view5 = view3;
                                    view4 = childAt;
                                    iMin = Math.min(i13, i8) - Math.max(i12, i7);
                                } else {
                                    int i15 = gridLayoutManager$LayoutParams2.mSpanIndex;
                                    iMin2 = Math.min(i13, i8) - Math.max(i12, i7);
                                    i11 = i15;
                                    iMin = i3;
                                    view5 = childAt;
                                }
                            }
                            i9 += i2;
                            recyclerView$Recycler2 = recyclerView$Recycler;
                            recyclerView$State2 = recyclerView$State;
                            viewFindContainingItemView = view2;
                            childCount = i4;
                        }
                        i6 = i11;
                        i5 = iMin2;
                        z2 = false;
                        if (z2) {
                            if (childAt.hasFocusable()) {
                                i10 = gridLayoutManager$LayoutParams2.mSpanIndex;
                                i11 = i6;
                                iMin2 = i5;
                                view5 = view3;
                                view4 = childAt;
                                iMin = Math.min(i13, i8) - Math.max(i12, i7);
                            } else {
                                int i16 = gridLayoutManager$LayoutParams2.mSpanIndex;
                                iMin2 = Math.min(i13, i8) - Math.max(i12, i7);
                                i11 = i16;
                                iMin = i3;
                                view5 = childAt;
                            }
                        }
                        i9 += i2;
                        recyclerView$Recycler2 = recyclerView$Recycler;
                        recyclerView$State2 = recyclerView$State;
                        viewFindContainingItemView = view2;
                        childCount = i4;
                    } else if (iMin3 <= iMin) {
                        if (iMin3 == iMin) {
                        }
                    }
                    i3 = iMin;
                    i4 = childCount;
                    i6 = i11;
                    i5 = iMin2;
                    z2 = false;
                    if (z2) {
                        if (childAt.hasFocusable()) {
                            i10 = gridLayoutManager$LayoutParams2.mSpanIndex;
                            i11 = i6;
                            iMin2 = i5;
                            view5 = view3;
                            view4 = childAt;
                            iMin = Math.min(i13, i8) - Math.max(i12, i7);
                        } else {
                            int i17 = gridLayoutManager$LayoutParams2.mSpanIndex;
                            iMin2 = Math.min(i13, i8) - Math.max(i12, i7);
                            i11 = i17;
                            iMin = i3;
                            view5 = childAt;
                        }
                    }
                    i9 += i2;
                    recyclerView$Recycler2 = recyclerView$Recycler;
                    recyclerView$State2 = recyclerView$State;
                    viewFindContainingItemView = view2;
                    childCount = i4;
                } else {
                    view3 = view5;
                }
                i3 = iMin;
                i4 = childCount;
                i6 = i11;
                i5 = iMin2;
                z2 = true;
                if (z2) {
                    if (childAt.hasFocusable()) {
                        i10 = gridLayoutManager$LayoutParams2.mSpanIndex;
                        i11 = i6;
                        iMin2 = i5;
                        view5 = view3;
                        view4 = childAt;
                        iMin = Math.min(i13, i8) - Math.max(i12, i7);
                    } else {
                        int i18 = gridLayoutManager$LayoutParams2.mSpanIndex;
                        iMin2 = Math.min(i13, i8) - Math.max(i12, i7);
                        i11 = i18;
                        iMin = i3;
                        view5 = childAt;
                    }
                }
                i9 += i2;
                recyclerView$Recycler2 = recyclerView$Recycler;
                recyclerView$State2 = recyclerView$State;
                viewFindContainingItemView = view2;
                childCount = i4;
            } else {
                if (view4 != null) {
                    break;
                }
                view2 = viewFindContainingItemView;
                view3 = view5;
                i3 = iMin;
                i4 = childCount;
                i6 = i11;
                i5 = iMin2;
            }
            i11 = i6;
            iMin2 = i5;
            iMin = i3;
            view5 = view3;
            i9 += i2;
            recyclerView$Recycler2 = recyclerView$Recycler;
            recyclerView$State2 = recyclerView$State;
            viewFindContainingItemView = view2;
            childCount = i4;
        }
        return view4 != null ? view4 : view5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onInitializeAccessibilityNodeInfoForItem(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof GridLayoutManager$LayoutParams)) {
            super.onInitializeAccessibilityNodeInfoForItem(view, accessibilityNodeInfoCompat);
            return;
        }
        GridLayoutManager$LayoutParams gridLayoutManager$LayoutParams = (GridLayoutManager$LayoutParams) layoutParams;
        int spanGroupIndex = getSpanGroupIndex(recyclerView$Recycler, recyclerView$State, gridLayoutManager$LayoutParams.getViewLayoutPosition());
        if (this.mOrientation == 0) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(gridLayoutManager$LayoutParams.getSpanIndex(), gridLayoutManager$LayoutParams.getSpanSize(), spanGroupIndex, 1, false, false));
        } else {
            accessibilityNodeInfoCompat.setCollectionItemInfo(AccessibilityNodeInfoCompat$CollectionItemInfoCompat.obtain(spanGroupIndex, 1, gridLayoutManager$LayoutParams.getSpanIndex(), gridLayoutManager$LayoutParams.getSpanSize(), false, false));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        this.mSpanSizeLookup.invalidateSpanGroupIndexCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (recyclerView$State.isPreLayout()) {
            cachePreLayoutSpanMapping();
        }
        super.onLayoutChildren(recyclerView$Recycler, recyclerView$State);
        clearPreLayoutSpanMappingCache();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.mPendingSpanCountChange = false;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollHorizontallyBy(i, recyclerView$Recycler, recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        updateMeasurements();
        ensureViewSet();
        return super.scrollVerticallyBy(i, recyclerView$Recycler, recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        if (this.mCachedBorders == null) {
            super.setMeasuredDimension(rect, i, i2);
        }
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView$LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            int[] iArr = this.mCachedBorders;
            iChooseSize = RecyclerView$LayoutManager.chooseSize(i, iArr[iArr.length - 1] + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView$LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            int[] iArr2 = this.mCachedBorders;
            iChooseSize2 = RecyclerView$LayoutManager.chooseSize(i2, iArr2[iArr2.length - 1] + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setSpanCount(int i) {
        if (i == this.mSpanCount) {
            return;
        }
        this.mPendingSpanCountChange = true;
        if (i < 1) {
            throw new IllegalArgumentException(a.q("Span count should be at least 1. Provided ", i));
        }
        this.mSpanCount = i;
        this.mSpanSizeLookup.invalidateSpanIndexCache();
        requestLayout();
    }

    public void setSpanSizeLookup(GridLayoutManager$SpanSizeLookup gridLayoutManager$SpanSizeLookup) {
        this.mSpanSizeLookup = gridLayoutManager$SpanSizeLookup;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setStackFromEnd(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.setStackFromEnd(false);
    }

    public void setUsingSpansToEstimateScrollbarDimensions(boolean z2) {
        this.mUsingSpansToEstimateScrollBarDimensions = z2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && !this.mPendingSpanCountChange;
    }

    public static int[] calculateItemBorders(int[] iArr, int i, int i2) {
        int i3;
        if (iArr == null || iArr.length != i + 1 || iArr[iArr.length - 1] != i2) {
            iArr = new int[i + 1];
        }
        int i4 = 0;
        iArr[0] = 0;
        int i5 = i2 / i;
        int i6 = i2 % i;
        int i7 = 0;
        for (int i8 = 1; i8 <= i; i8++) {
            i4 += i6;
            if (i4 <= 0 || i - i4 >= i6) {
                i3 = i5;
            } else {
                i3 = i5 + 1;
                i4 -= i;
            }
            i7 += i3;
            iArr[i8] = i7;
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams ? new GridLayoutManager$LayoutParams((ViewGroup$MarginLayoutParams) viewGroup$LayoutParams) : new GridLayoutManager$LayoutParams(viewGroup$LayoutParams);
    }

    public GridLayoutManager(Context context, int i) {
        super(context);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new GridLayoutManager$DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }

    public GridLayoutManager(Context context, int i, int i2, boolean z2) {
        super(context, i2, z2);
        this.mPendingSpanCountChange = false;
        this.mSpanCount = -1;
        this.mPreLayoutSpanSizeCache = new SparseIntArray();
        this.mPreLayoutSpanIndexCache = new SparseIntArray();
        this.mSpanSizeLookup = new GridLayoutManager$DefaultSpanSizeLookup();
        this.mDecorInsets = new Rect();
        setSpanCount(i);
    }
}
