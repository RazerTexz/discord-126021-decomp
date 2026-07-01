package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import b.d.b.a.a;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends RecyclerView$LayoutManager implements ItemTouchHelper$ViewDropHandler, RecyclerView$SmoothScroller$ScrollVectorProvider {
    public static final boolean DEBUG = false;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "LinearLayoutManager";
    public static final int VERTICAL = 1;
    public final LinearLayoutManager$AnchorInfo mAnchorInfo;
    private int mInitialPrefetchItemCount;
    private boolean mLastStackFromEnd;
    private final LinearLayoutManager$LayoutChunkResult mLayoutChunkResult;
    private LinearLayoutManager$LayoutState mLayoutState;
    public int mOrientation;
    public OrientationHelper mOrientationHelper;
    public LinearLayoutManager$SavedState mPendingSavedState;
    public int mPendingScrollPosition;
    public int mPendingScrollPositionOffset;
    private boolean mRecycleChildrenOnDetach;
    private int[] mReusableIntPair;
    private boolean mReverseLayout;
    public boolean mShouldReverseLayout;
    private boolean mSmoothScrollbarEnabled;
    private boolean mStackFromEnd;

    public LinearLayoutManager(Context context) {
        this(context, 1, false);
    }

    private int computeScrollExtent(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollExtent(recyclerView$State, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollOffset(recyclerView$State, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        ensureLayoutState();
        return ScrollbarHelper.computeScrollRange(recyclerView$State, this.mOrientationHelper, findFirstVisibleChildClosestToStart(!this.mSmoothScrollbarEnabled, true), findFirstVisibleChildClosestToEnd(!this.mSmoothScrollbarEnabled, true), this, this.mSmoothScrollbarEnabled);
    }

    private View findFirstPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(0, getChildCount());
    }

    private View findLastPartiallyOrCompletelyInvisibleChild() {
        return findOnePartiallyOrCompletelyInvisibleChild(getChildCount() - 1, -1);
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToEnd() {
        return this.mShouldReverseLayout ? findFirstPartiallyOrCompletelyInvisibleChild() : findLastPartiallyOrCompletelyInvisibleChild();
    }

    private View findPartiallyOrCompletelyInvisibleChildClosestToStart() {
        return this.mShouldReverseLayout ? findLastPartiallyOrCompletelyInvisibleChild() : findFirstPartiallyOrCompletelyInvisibleChild();
    }

    private int fixLayoutEndGap(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        int endAfterPadding;
        int endAfterPadding2 = this.mOrientationHelper.getEndAfterPadding() - i;
        if (endAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(-endAfterPadding2, recyclerView$Recycler, recyclerView$State);
        int i3 = i + i2;
        if (!z2 || (endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - i3) <= 0) {
            return i2;
        }
        this.mOrientationHelper.offsetChildren(endAfterPadding);
        return endAfterPadding + i2;
    }

    private int fixLayoutStartGap(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        int startAfterPadding;
        int startAfterPadding2 = i - this.mOrientationHelper.getStartAfterPadding();
        if (startAfterPadding2 <= 0) {
            return 0;
        }
        int i2 = -scrollBy(startAfterPadding2, recyclerView$Recycler, recyclerView$State);
        int i3 = i + i2;
        if (!z2 || (startAfterPadding = i3 - this.mOrientationHelper.getStartAfterPadding()) <= 0) {
            return i2;
        }
        this.mOrientationHelper.offsetChildren(-startAfterPadding);
        return i2 - startAfterPadding;
    }

    private View getChildClosestToEnd() {
        return getChildAt(this.mShouldReverseLayout ? 0 : getChildCount() - 1);
    }

    private View getChildClosestToStart() {
        return getChildAt(this.mShouldReverseLayout ? getChildCount() - 1 : 0);
    }

    private void layoutForPredictiveAnimations(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, int i, int i2) {
        if (!recyclerView$State.willRunPredictiveAnimations() || getChildCount() == 0 || recyclerView$State.isPreLayout() || !supportsPredictiveItemAnimations()) {
            return;
        }
        List<RecyclerView$ViewHolder> scrapList = recyclerView$Recycler.getScrapList();
        int size = scrapList.size();
        int position = getPosition(getChildAt(0));
        int decoratedMeasurement = 0;
        int decoratedMeasurement2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            RecyclerView$ViewHolder recyclerView$ViewHolder = scrapList.get(i3);
            if (!recyclerView$ViewHolder.isRemoved()) {
                if (((recyclerView$ViewHolder.getLayoutPosition() < position) != this.mShouldReverseLayout ? (byte) -1 : (byte) 1) == -1) {
                    decoratedMeasurement += this.mOrientationHelper.getDecoratedMeasurement(recyclerView$ViewHolder.itemView);
                } else {
                    decoratedMeasurement2 += this.mOrientationHelper.getDecoratedMeasurement(recyclerView$ViewHolder.itemView);
                }
            }
        }
        this.mLayoutState.mScrapList = scrapList;
        if (decoratedMeasurement > 0) {
            updateLayoutStateToFillStart(getPosition(getChildClosestToStart()), i);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
            linearLayoutManager$LayoutState.mExtraFillSpace = decoratedMeasurement;
            linearLayoutManager$LayoutState.mAvailable = 0;
            linearLayoutManager$LayoutState.assignPositionFromScrapList();
            fill(recyclerView$Recycler, this.mLayoutState, recyclerView$State, false);
        }
        if (decoratedMeasurement2 > 0) {
            updateLayoutStateToFillEnd(getPosition(getChildClosestToEnd()), i2);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState2 = this.mLayoutState;
            linearLayoutManager$LayoutState2.mExtraFillSpace = decoratedMeasurement2;
            linearLayoutManager$LayoutState2.mAvailable = 0;
            linearLayoutManager$LayoutState2.assignPositionFromScrapList();
            fill(recyclerView$Recycler, this.mLayoutState, recyclerView$State, false);
        }
        this.mLayoutState.mScrapList = null;
    }

    private void logChildren() {
        Log.d(TAG, "internal representation of views on the screen");
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            StringBuilder sbU = a.U("item ");
            sbU.append(getPosition(childAt));
            sbU.append(", coord:");
            sbU.append(this.mOrientationHelper.getDecoratedStart(childAt));
            Log.d(TAG, sbU.toString());
        }
        Log.d(TAG, "==============");
    }

    private void recycleByLayoutState(RecyclerView$Recycler recyclerView$Recycler, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState) {
        if (!linearLayoutManager$LayoutState.mRecycle || linearLayoutManager$LayoutState.mInfinite) {
            return;
        }
        int i = linearLayoutManager$LayoutState.mScrollingOffset;
        int i2 = linearLayoutManager$LayoutState.mNoRecycleSpace;
        if (linearLayoutManager$LayoutState.mLayoutDirection == -1) {
            recycleViewsFromEnd(recyclerView$Recycler, i, i2);
        } else {
            recycleViewsFromStart(recyclerView$Recycler, i, i2);
        }
    }

    private void recycleChildren(RecyclerView$Recycler recyclerView$Recycler, int i, int i2) {
        if (i == i2) {
            return;
        }
        if (i2 <= i) {
            while (i > i2) {
                removeAndRecycleViewAt(i, recyclerView$Recycler);
                i--;
            }
        } else {
            for (int i3 = i2 - 1; i3 >= i; i3--) {
                removeAndRecycleViewAt(i3, recyclerView$Recycler);
            }
        }
    }

    private void recycleViewsFromEnd(RecyclerView$Recycler recyclerView$Recycler, int i, int i2) {
        int childCount = getChildCount();
        if (i < 0) {
            return;
        }
        int end = (this.mOrientationHelper.getEnd() - i) + i2;
        if (this.mShouldReverseLayout) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (this.mOrientationHelper.getDecoratedStart(childAt) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt) < end) {
                    recycleChildren(recyclerView$Recycler, 0, i3);
                    return;
                }
            }
            return;
        }
        int i4 = childCount - 1;
        for (int i5 = i4; i5 >= 0; i5--) {
            View childAt2 = getChildAt(i5);
            if (this.mOrientationHelper.getDecoratedStart(childAt2) < end || this.mOrientationHelper.getTransformedStartWithDecoration(childAt2) < end) {
                recycleChildren(recyclerView$Recycler, i4, i5);
                return;
            }
        }
    }

    private void recycleViewsFromStart(RecyclerView$Recycler recyclerView$Recycler, int i, int i2) {
        if (i < 0) {
            return;
        }
        int i3 = i - i2;
        int childCount = getChildCount();
        if (!this.mShouldReverseLayout) {
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                if (this.mOrientationHelper.getDecoratedEnd(childAt) > i3 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt) > i3) {
                    recycleChildren(recyclerView$Recycler, 0, i4);
                    return;
                }
            }
            return;
        }
        int i5 = childCount - 1;
        for (int i6 = i5; i6 >= 0; i6--) {
            View childAt2 = getChildAt(i6);
            if (this.mOrientationHelper.getDecoratedEnd(childAt2) > i3 || this.mOrientationHelper.getTransformedEndWithDecoration(childAt2) > i3) {
                recycleChildren(recyclerView$Recycler, i5, i6);
                return;
            }
        }
    }

    private void resolveShouldLayoutReverse() {
        if (this.mOrientation == 1 || !isLayoutRTL()) {
            this.mShouldReverseLayout = this.mReverseLayout;
        } else {
            this.mShouldReverseLayout = !this.mReverseLayout;
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        View viewFindReferenceChild;
        boolean z2 = false;
        if (getChildCount() == 0) {
            return false;
        }
        View focusedChild = getFocusedChild();
        if (focusedChild != null && linearLayoutManager$AnchorInfo.isViewValidAsAnchor(focusedChild, recyclerView$State)) {
            linearLayoutManager$AnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
            return true;
        }
        boolean z3 = this.mLastStackFromEnd;
        boolean z4 = this.mStackFromEnd;
        if (z3 != z4 || (viewFindReferenceChild = findReferenceChild(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo.mLayoutFromEnd, z4)) == null) {
            return false;
        }
        linearLayoutManager$AnchorInfo.assignFromView(viewFindReferenceChild, getPosition(viewFindReferenceChild));
        if (!recyclerView$State.isPreLayout() && supportsPredictiveItemAnimations()) {
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(viewFindReferenceChild);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(viewFindReferenceChild);
            int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
            int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
            boolean z5 = decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding;
            if (decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding) {
                z2 = true;
            }
            if (z5 || z2) {
                if (linearLayoutManager$AnchorInfo.mLayoutFromEnd) {
                    startAfterPadding = endAfterPadding;
                }
                linearLayoutManager$AnchorInfo.mCoordinate = startAfterPadding;
            }
        }
        return true;
    }

    private boolean updateAnchorFromPendingData(RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        int i;
        if (!recyclerView$State.isPreLayout() && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0 && i < recyclerView$State.getItemCount()) {
                linearLayoutManager$AnchorInfo.mPosition = this.mPendingScrollPosition;
                LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
                if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.hasValidAnchor()) {
                    boolean z2 = this.mPendingSavedState.mAnchorLayoutFromEnd;
                    linearLayoutManager$AnchorInfo.mLayoutFromEnd = z2;
                    if (z2) {
                        linearLayoutManager$AnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingSavedState.mAnchorOffset;
                    } else {
                        linearLayoutManager$AnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingSavedState.mAnchorOffset;
                    }
                    return true;
                }
                if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                    boolean z3 = this.mShouldReverseLayout;
                    linearLayoutManager$AnchorInfo.mLayoutFromEnd = z3;
                    if (z3) {
                        linearLayoutManager$AnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding() - this.mPendingScrollPositionOffset;
                    } else {
                        linearLayoutManager$AnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding() + this.mPendingScrollPositionOffset;
                    }
                    return true;
                }
                View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                if (viewFindViewByPosition == null) {
                    if (getChildCount() > 0) {
                        linearLayoutManager$AnchorInfo.mLayoutFromEnd = (this.mPendingScrollPosition < getPosition(getChildAt(0))) == this.mShouldReverseLayout;
                    }
                    linearLayoutManager$AnchorInfo.assignCoordinateFromPadding();
                } else {
                    if (this.mOrientationHelper.getDecoratedMeasurement(viewFindViewByPosition) > this.mOrientationHelper.getTotalSpace()) {
                        linearLayoutManager$AnchorInfo.assignCoordinateFromPadding();
                        return true;
                    }
                    if (this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition) - this.mOrientationHelper.getStartAfterPadding() < 0) {
                        linearLayoutManager$AnchorInfo.mCoordinate = this.mOrientationHelper.getStartAfterPadding();
                        linearLayoutManager$AnchorInfo.mLayoutFromEnd = false;
                        return true;
                    }
                    if (this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition) < 0) {
                        linearLayoutManager$AnchorInfo.mCoordinate = this.mOrientationHelper.getEndAfterPadding();
                        linearLayoutManager$AnchorInfo.mLayoutFromEnd = true;
                        return true;
                    }
                    linearLayoutManager$AnchorInfo.mCoordinate = linearLayoutManager$AnchorInfo.mLayoutFromEnd ? this.mOrientationHelper.getTotalSpaceChange() + this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition) : this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition);
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    private void updateAnchorInfoForLayout(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        if (updateAnchorFromPendingData(recyclerView$State, linearLayoutManager$AnchorInfo) || updateAnchorFromChildren(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo)) {
            return;
        }
        linearLayoutManager$AnchorInfo.assignCoordinateFromPadding();
        linearLayoutManager$AnchorInfo.mPosition = this.mStackFromEnd ? recyclerView$State.getItemCount() - 1 : 0;
    }

    private void updateLayoutState(int i, int i2, boolean z2, RecyclerView$State recyclerView$State) {
        int startAfterPadding;
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mLayoutDirection = i;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(recyclerView$State, iArr);
        int iMax = Math.max(0, this.mReusableIntPair[0]);
        int iMax2 = Math.max(0, this.mReusableIntPair[1]);
        boolean z3 = i == 1;
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        int i3 = z3 ? iMax2 : iMax;
        linearLayoutManager$LayoutState.mExtraFillSpace = i3;
        if (!z3) {
            iMax = iMax2;
        }
        linearLayoutManager$LayoutState.mNoRecycleSpace = iMax;
        if (z3) {
            linearLayoutManager$LayoutState.mExtraFillSpace = this.mOrientationHelper.getEndPadding() + i3;
            View childClosestToEnd = getChildClosestToEnd();
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState2 = this.mLayoutState;
            linearLayoutManager$LayoutState2.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
            int position = getPosition(childClosestToEnd);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState3 = this.mLayoutState;
            linearLayoutManager$LayoutState2.mCurrentPosition = position + linearLayoutManager$LayoutState3.mItemDirection;
            linearLayoutManager$LayoutState3.mOffset = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
            startAfterPadding = this.mOrientationHelper.getDecoratedEnd(childClosestToEnd) - this.mOrientationHelper.getEndAfterPadding();
        } else {
            View childClosestToStart = getChildClosestToStart();
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState4 = this.mLayoutState;
            linearLayoutManager$LayoutState4.mExtraFillSpace = this.mOrientationHelper.getStartAfterPadding() + linearLayoutManager$LayoutState4.mExtraFillSpace;
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState5 = this.mLayoutState;
            linearLayoutManager$LayoutState5.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
            int position2 = getPosition(childClosestToStart);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState6 = this.mLayoutState;
            linearLayoutManager$LayoutState5.mCurrentPosition = position2 + linearLayoutManager$LayoutState6.mItemDirection;
            linearLayoutManager$LayoutState6.mOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart);
            startAfterPadding = (-this.mOrientationHelper.getDecoratedStart(childClosestToStart)) + this.mOrientationHelper.getStartAfterPadding();
        }
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState7 = this.mLayoutState;
        linearLayoutManager$LayoutState7.mAvailable = i2;
        if (z2) {
            linearLayoutManager$LayoutState7.mAvailable = i2 - startAfterPadding;
        }
        linearLayoutManager$LayoutState7.mScrollingOffset = startAfterPadding;
    }

    private void updateLayoutStateToFillEnd(LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        updateLayoutStateToFillEnd(linearLayoutManager$AnchorInfo.mPosition, linearLayoutManager$AnchorInfo.mCoordinate);
    }

    private void updateLayoutStateToFillStart(LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo) {
        updateLayoutStateToFillStart(linearLayoutManager$AnchorInfo.mPosition, linearLayoutManager$AnchorInfo.mCoordinate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    public void calculateExtraLayoutSpace(@NonNull RecyclerView$State recyclerView$State, @NonNull int[] iArr) {
        int i;
        int extraLayoutSpace = getExtraLayoutSpace(recyclerView$State);
        if (this.mLayoutState.mLayoutDirection == -1) {
            i = 0;
        } else {
            i = extraLayoutSpace;
            extraLayoutSpace = 0;
        }
        iArr[0] = extraLayoutSpace;
        iArr[1] = i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView$State recyclerView$State, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        ensureLayoutState();
        updateLayoutState(i > 0 ? 1 : -1, Math.abs(i), true, recyclerView$State);
        collectPrefetchPositionsForLayoutState(recyclerView$State, this.mLayoutState, recyclerView$LayoutManager$LayoutPrefetchRegistry);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void collectInitialPrefetchPositions(int i, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        boolean z2;
        int i2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState == null || !linearLayoutManager$SavedState.hasValidAnchor()) {
            resolveShouldLayoutReverse();
            z2 = this.mShouldReverseLayout;
            i2 = this.mPendingScrollPosition;
            if (i2 == -1) {
                i2 = z2 ? i - 1 : 0;
            }
        } else {
            LinearLayoutManager$SavedState linearLayoutManager$SavedState2 = this.mPendingSavedState;
            z2 = linearLayoutManager$SavedState2.mAnchorLayoutFromEnd;
            i2 = linearLayoutManager$SavedState2.mAnchorPosition;
        }
        int i3 = z2 ? -1 : 1;
        for (int i4 = 0; i4 < this.mInitialPrefetchItemCount && i2 >= 0 && i2 < i; i4++) {
            recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(i2, 0);
            i2 += i3;
        }
    }

    public void collectPrefetchPositionsForLayoutState(RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int i = linearLayoutManager$LayoutState.mCurrentPosition;
        if (i < 0 || i >= recyclerView$State.getItemCount()) {
            return;
        }
        recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(i, Math.max(0, linearLayoutManager$LayoutState.mScrollingOffset));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollExtent(RecyclerView$State recyclerView$State) {
        return computeScrollExtent(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollOffset(RecyclerView$State recyclerView$State) {
        return computeScrollOffset(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeHorizontalScrollRange(RecyclerView$State recyclerView$State) {
        return computeScrollRange(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$SmoothScroller$ScrollVectorProvider
    public PointF computeScrollVectorForPosition(int i) {
        if (getChildCount() == 0) {
            return null;
        }
        int i2 = (i < getPosition(getChildAt(0))) != this.mShouldReverseLayout ? -1 : 1;
        return this.mOrientation == 0 ? new PointF(i2, 0.0f) : new PointF(0.0f, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollExtent(RecyclerView$State recyclerView$State) {
        return computeScrollExtent(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollOffset(RecyclerView$State recyclerView$State) {
        return computeScrollOffset(recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int computeVerticalScrollRange(RecyclerView$State recyclerView$State) {
        return computeScrollRange(recyclerView$State);
    }

    public int convertFocusDirectionToLayoutDirection(int i) {
        if (i == 1) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? 1 : -1;
        }
        if (i == 2) {
            return (this.mOrientation != 1 && isLayoutRTL()) ? -1 : 1;
        }
        if (i == 17) {
            return this.mOrientation == 0 ? -1 : Integer.MIN_VALUE;
        }
        if (i == 33) {
            return this.mOrientation == 1 ? -1 : Integer.MIN_VALUE;
        }
        if (i != 66) {
            return (i == 130 && this.mOrientation == 1) ? 1 : Integer.MIN_VALUE;
        }
        return this.mOrientation == 0 ? 1 : Integer.MIN_VALUE;
    }

    public LinearLayoutManager$LayoutState createLayoutState() {
        return new LinearLayoutManager$LayoutState();
    }

    public void ensureLayoutState() {
        if (this.mLayoutState == null) {
            this.mLayoutState = createLayoutState();
        }
    }

    public int fill(RecyclerView$Recycler recyclerView$Recycler, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, RecyclerView$State recyclerView$State, boolean z2) {
        int i = linearLayoutManager$LayoutState.mAvailable;
        int i2 = linearLayoutManager$LayoutState.mScrollingOffset;
        if (i2 != Integer.MIN_VALUE) {
            if (i < 0) {
                linearLayoutManager$LayoutState.mScrollingOffset = i2 + i;
            }
            recycleByLayoutState(recyclerView$Recycler, linearLayoutManager$LayoutState);
        }
        int i3 = linearLayoutManager$LayoutState.mAvailable + linearLayoutManager$LayoutState.mExtraFillSpace;
        LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult = this.mLayoutChunkResult;
        while (true) {
            if ((!linearLayoutManager$LayoutState.mInfinite && i3 <= 0) || !linearLayoutManager$LayoutState.hasMore(recyclerView$State)) {
                break;
            }
            linearLayoutManager$LayoutChunkResult.resetInternal();
            layoutChunk(recyclerView$Recycler, recyclerView$State, linearLayoutManager$LayoutState, linearLayoutManager$LayoutChunkResult);
            if (!linearLayoutManager$LayoutChunkResult.mFinished) {
                linearLayoutManager$LayoutState.mOffset = (linearLayoutManager$LayoutChunkResult.mConsumed * linearLayoutManager$LayoutState.mLayoutDirection) + linearLayoutManager$LayoutState.mOffset;
                if (!linearLayoutManager$LayoutChunkResult.mIgnoreConsumed || linearLayoutManager$LayoutState.mScrapList != null || !recyclerView$State.isPreLayout()) {
                    int i4 = linearLayoutManager$LayoutState.mAvailable;
                    int i5 = linearLayoutManager$LayoutChunkResult.mConsumed;
                    linearLayoutManager$LayoutState.mAvailable = i4 - i5;
                    i3 -= i5;
                }
                int i6 = linearLayoutManager$LayoutState.mScrollingOffset;
                if (i6 != Integer.MIN_VALUE) {
                    int i7 = i6 + linearLayoutManager$LayoutChunkResult.mConsumed;
                    linearLayoutManager$LayoutState.mScrollingOffset = i7;
                    int i8 = linearLayoutManager$LayoutState.mAvailable;
                    if (i8 < 0) {
                        linearLayoutManager$LayoutState.mScrollingOffset = i7 + i8;
                    }
                    recycleByLayoutState(recyclerView$Recycler, linearLayoutManager$LayoutState);
                }
                if (z2 && linearLayoutManager$LayoutChunkResult.mFocusable) {
                    break;
                }
            } else {
                break;
            }
        }
        return i - linearLayoutManager$LayoutState.mAvailable;
    }

    public int findFirstCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findFirstVisibleChildClosestToEnd(boolean z2, boolean z3) {
        return this.mShouldReverseLayout ? findOneVisibleChild(0, getChildCount(), z2, z3) : findOneVisibleChild(getChildCount() - 1, -1, z2, z3);
    }

    public View findFirstVisibleChildClosestToStart(boolean z2, boolean z3) {
        return this.mShouldReverseLayout ? findOneVisibleChild(getChildCount() - 1, -1, z2, z3) : findOneVisibleChild(0, getChildCount(), z2, z3);
    }

    public int findFirstVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(0, getChildCount(), false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastCompletelyVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, true, false);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public int findLastVisibleItemPosition() {
        View viewFindOneVisibleChild = findOneVisibleChild(getChildCount() - 1, -1, false, true);
        if (viewFindOneVisibleChild == null) {
            return -1;
        }
        return getPosition(viewFindOneVisibleChild);
    }

    public View findOnePartiallyOrCompletelyInvisibleChild(int i, int i2) {
        byte b2;
        int i3;
        int i4;
        ensureLayoutState();
        if (i2 > i) {
            b2 = 1;
        } else {
            b2 = i2 < i ? (byte) -1 : (byte) 0;
        }
        if (b2 == 0) {
            return getChildAt(i);
        }
        if (this.mOrientationHelper.getDecoratedStart(getChildAt(i)) < this.mOrientationHelper.getStartAfterPadding()) {
            i3 = 16644;
            i4 = 16388;
        } else {
            i3 = 4161;
            i4 = FragmentTransaction.TRANSIT_FRAGMENT_OPEN;
        }
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4) : this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
    }

    public View findOneVisibleChild(int i, int i2, boolean z2, boolean z3) {
        ensureLayoutState();
        int i3 = z2 ? 24579 : 320;
        int i4 = z3 ? 320 : 0;
        return this.mOrientation == 0 ? this.mHorizontalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4) : this.mVerticalBoundCheck.findOneViewWithinBoundFlags(i, i2, i3, i4);
    }

    /* JADX WARN: Code duplicated, block: B:33:0x0073  */
    /* JADX WARN: Code duplicated, block: B:35:0x0077  */
    public View findReferenceChild(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2, boolean z3) {
        int childCount;
        int i;
        ensureLayoutState();
        int childCount2 = getChildCount();
        int i2 = -1;
        if (z3) {
            childCount = getChildCount() - 1;
            i = -1;
        } else {
            i2 = childCount2;
            childCount = 0;
            i = 1;
        }
        int itemCount = recyclerView$State.getItemCount();
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding();
        int endAfterPadding = this.mOrientationHelper.getEndAfterPadding();
        View view = null;
        View view2 = null;
        View view3 = null;
        while (childCount != i2) {
            View childAt = getChildAt(childCount);
            int position = getPosition(childAt);
            int decoratedStart = this.mOrientationHelper.getDecoratedStart(childAt);
            int decoratedEnd = this.mOrientationHelper.getDecoratedEnd(childAt);
            if (position >= 0 && position < itemCount) {
                if (!((RecyclerView$LayoutParams) childAt.getLayoutParams()).isItemRemoved()) {
                    boolean z4 = decoratedEnd <= startAfterPadding && decoratedStart < startAfterPadding;
                    boolean z5 = decoratedStart >= endAfterPadding && decoratedEnd > endAfterPadding;
                    if (!z4 && !z5) {
                        return childAt;
                    }
                    if (z2) {
                        if (z5) {
                            view2 = childAt;
                        } else if (view == null) {
                            view = childAt;
                        }
                    } else if (z4) {
                        view2 = childAt;
                    } else if (view == null) {
                        view = childAt;
                    }
                } else if (view3 == null) {
                    view3 = childAt;
                }
            }
            childCount += i;
        }
        if (view != null) {
            return view;
        }
        return view2 != null ? view2 : view3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return null;
        }
        int position = i - getPosition(getChildAt(0));
        if (position >= 0 && position < childCount) {
            View childAt = getChildAt(position);
            if (getPosition(childAt) == i) {
                return childAt;
            }
        }
        return super.findViewByPosition(i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView$LayoutParams(-2, -2);
    }

    @Deprecated
    public int getExtraLayoutSpace(RecyclerView$State recyclerView$State) {
        if (recyclerView$State.hasTargetScrollPosition()) {
            return this.mOrientationHelper.getTotalSpace();
        }
        return 0;
    }

    public int getInitialPrefetchItemCount() {
        return this.mInitialPrefetchItemCount;
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getRecycleChildrenOnDetach() {
        return this.mRecycleChildrenOnDetach;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public boolean getStackFromEnd() {
        return this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean isAutoMeasureEnabled() {
        return true;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    public boolean isSmoothScrollbarEnabled() {
        return this.mSmoothScrollbarEnabled;
    }

    public void layoutChunk(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$LayoutState linearLayoutManager$LayoutState, LinearLayoutManager$LayoutChunkResult linearLayoutManager$LayoutChunkResult) {
        int i;
        int i2;
        int i3;
        int paddingLeft;
        int decoratedMeasurementInOther;
        View next = linearLayoutManager$LayoutState.next(recyclerView$Recycler);
        if (next == null) {
            linearLayoutManager$LayoutChunkResult.mFinished = true;
            return;
        }
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) next.getLayoutParams();
        if (linearLayoutManager$LayoutState.mScrapList == null) {
            if (this.mShouldReverseLayout == (linearLayoutManager$LayoutState.mLayoutDirection == -1)) {
                addView(next);
            } else {
                addView(next, 0);
            }
        } else {
            if (this.mShouldReverseLayout == (linearLayoutManager$LayoutState.mLayoutDirection == -1)) {
                addDisappearingView(next);
            } else {
                addDisappearingView(next, 0);
            }
        }
        measureChildWithMargins(next, 0, 0);
        linearLayoutManager$LayoutChunkResult.mConsumed = this.mOrientationHelper.getDecoratedMeasurement(next);
        if (this.mOrientation == 1) {
            if (isLayoutRTL()) {
                decoratedMeasurementInOther = getWidth() - getPaddingRight();
                paddingLeft = decoratedMeasurementInOther - this.mOrientationHelper.getDecoratedMeasurementInOther(next);
            } else {
                paddingLeft = getPaddingLeft();
                decoratedMeasurementInOther = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingLeft;
            }
            if (linearLayoutManager$LayoutState.mLayoutDirection == -1) {
                int i4 = linearLayoutManager$LayoutState.mOffset;
                i3 = i4;
                i2 = decoratedMeasurementInOther;
                i = i4 - linearLayoutManager$LayoutChunkResult.mConsumed;
            } else {
                int i5 = linearLayoutManager$LayoutState.mOffset;
                i = i5;
                i2 = decoratedMeasurementInOther;
                i3 = linearLayoutManager$LayoutChunkResult.mConsumed + i5;
            }
        } else {
            int paddingTop = getPaddingTop();
            int decoratedMeasurementInOther2 = this.mOrientationHelper.getDecoratedMeasurementInOther(next) + paddingTop;
            if (linearLayoutManager$LayoutState.mLayoutDirection == -1) {
                int i6 = linearLayoutManager$LayoutState.mOffset;
                i2 = i6;
                i = paddingTop;
                i3 = decoratedMeasurementInOther2;
                paddingLeft = i6 - linearLayoutManager$LayoutChunkResult.mConsumed;
            } else {
                int i7 = linearLayoutManager$LayoutState.mOffset;
                i = paddingTop;
                i2 = linearLayoutManager$LayoutChunkResult.mConsumed + i7;
                i3 = decoratedMeasurementInOther2;
                paddingLeft = i7;
            }
        }
        layoutDecoratedWithMargins(next, paddingLeft, i, i2, i3);
        if (recyclerView$LayoutParams.isItemRemoved() || recyclerView$LayoutParams.isItemChanged()) {
            linearLayoutManager$LayoutChunkResult.mIgnoreConsumed = true;
        }
        linearLayoutManager$LayoutChunkResult.mFocusable = next.hasFocusable();
    }

    public void onAnchorReady(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo, int i) {
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        super.onDetachedFromWindow(recyclerView, recyclerView$Recycler);
        if (this.mRecycleChildrenOnDetach) {
            removeAndRecycleAllViews(recyclerView$Recycler);
            recyclerView$Recycler.clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public View onFocusSearchFailed(View view, int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int iConvertFocusDirectionToLayoutDirection;
        resolveShouldLayoutReverse();
        if (getChildCount() == 0 || (iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i)) == Integer.MIN_VALUE) {
            return null;
        }
        ensureLayoutState();
        updateLayoutState(iConvertFocusDirectionToLayoutDirection, (int) (this.mOrientationHelper.getTotalSpace() * MAX_SCROLL_FACTOR), false, recyclerView$State);
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        linearLayoutManager$LayoutState.mScrollingOffset = Integer.MIN_VALUE;
        linearLayoutManager$LayoutState.mRecycle = false;
        fill(recyclerView$Recycler, linearLayoutManager$LayoutState, recyclerView$State, true);
        View viewFindPartiallyOrCompletelyInvisibleChildClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? findPartiallyOrCompletelyInvisibleChildClosestToStart() : findPartiallyOrCompletelyInvisibleChildClosestToEnd();
        View childClosestToStart = iConvertFocusDirectionToLayoutDirection == -1 ? getChildClosestToStart() : getChildClosestToEnd();
        if (!childClosestToStart.hasFocusable()) {
            return viewFindPartiallyOrCompletelyInvisibleChildClosestToStart;
        }
        if (viewFindPartiallyOrCompletelyInvisibleChildClosestToStart == null) {
            return null;
        }
        return childClosestToStart;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            accessibilityEvent.setFromIndex(findFirstVisibleItemPosition());
            accessibilityEvent.setToIndex(findLastVisibleItemPosition());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        int i;
        int i2;
        int i3;
        int i4;
        int iFixLayoutEndGap;
        int i5;
        View viewFindViewByPosition;
        int decoratedStart;
        int endAfterPadding;
        int i6 = -1;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && recyclerView$State.getItemCount() == 0) {
            removeAndRecycleAllViews(recyclerView$Recycler);
            return;
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState != null && linearLayoutManager$SavedState.hasValidAnchor()) {
            this.mPendingScrollPosition = this.mPendingSavedState.mAnchorPosition;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = false;
        resolveShouldLayoutReverse();
        View focusedChild = getFocusedChild();
        LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo = this.mAnchorInfo;
        if (!linearLayoutManager$AnchorInfo.mValid || this.mPendingScrollPosition != -1 || this.mPendingSavedState != null) {
            linearLayoutManager$AnchorInfo.reset();
            LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo2 = this.mAnchorInfo;
            linearLayoutManager$AnchorInfo2.mLayoutFromEnd = this.mShouldReverseLayout ^ this.mStackFromEnd;
            updateAnchorInfoForLayout(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo2);
            this.mAnchorInfo.mValid = true;
        } else if (focusedChild != null && (this.mOrientationHelper.getDecoratedStart(focusedChild) >= this.mOrientationHelper.getEndAfterPadding() || this.mOrientationHelper.getDecoratedEnd(focusedChild) <= this.mOrientationHelper.getStartAfterPadding())) {
            this.mAnchorInfo.assignFromViewAndKeepVisibleRect(focusedChild, getPosition(focusedChild));
        }
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        linearLayoutManager$LayoutState.mLayoutDirection = linearLayoutManager$LayoutState.mLastScrollDelta >= 0 ? 1 : -1;
        int[] iArr = this.mReusableIntPair;
        iArr[0] = 0;
        iArr[1] = 0;
        calculateExtraLayoutSpace(recyclerView$State, iArr);
        int startAfterPadding = this.mOrientationHelper.getStartAfterPadding() + Math.max(0, this.mReusableIntPair[0]);
        int endPadding = this.mOrientationHelper.getEndPadding() + Math.max(0, this.mReusableIntPair[1]);
        if (recyclerView$State.isPreLayout() && (i5 = this.mPendingScrollPosition) != -1 && this.mPendingScrollPositionOffset != Integer.MIN_VALUE && (viewFindViewByPosition = findViewByPosition(i5)) != null) {
            if (this.mShouldReverseLayout) {
                endAfterPadding = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(viewFindViewByPosition);
                decoratedStart = this.mPendingScrollPositionOffset;
            } else {
                decoratedStart = this.mOrientationHelper.getDecoratedStart(viewFindViewByPosition) - this.mOrientationHelper.getStartAfterPadding();
                endAfterPadding = this.mPendingScrollPositionOffset;
            }
            int i7 = endAfterPadding - decoratedStart;
            if (i7 > 0) {
                startAfterPadding += i7;
            } else {
                endPadding -= i7;
            }
        }
        LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo3 = this.mAnchorInfo;
        if (!linearLayoutManager$AnchorInfo3.mLayoutFromEnd ? !this.mShouldReverseLayout : this.mShouldReverseLayout) {
            i6 = 1;
        }
        onAnchorReady(recyclerView$Recycler, recyclerView$State, linearLayoutManager$AnchorInfo3, i6);
        detachAndScrapAttachedViews(recyclerView$Recycler);
        this.mLayoutState.mInfinite = resolveIsInfinite();
        this.mLayoutState.mIsPreLayout = recyclerView$State.isPreLayout();
        this.mLayoutState.mNoRecycleSpace = 0;
        LinearLayoutManager$AnchorInfo linearLayoutManager$AnchorInfo4 = this.mAnchorInfo;
        if (linearLayoutManager$AnchorInfo4.mLayoutFromEnd) {
            updateLayoutStateToFillStart(linearLayoutManager$AnchorInfo4);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState2 = this.mLayoutState;
            linearLayoutManager$LayoutState2.mExtraFillSpace = startAfterPadding;
            fill(recyclerView$Recycler, linearLayoutManager$LayoutState2, recyclerView$State, false);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState3 = this.mLayoutState;
            i2 = linearLayoutManager$LayoutState3.mOffset;
            int i8 = linearLayoutManager$LayoutState3.mCurrentPosition;
            int i9 = linearLayoutManager$LayoutState3.mAvailable;
            if (i9 > 0) {
                endPadding += i9;
            }
            updateLayoutStateToFillEnd(this.mAnchorInfo);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState4 = this.mLayoutState;
            linearLayoutManager$LayoutState4.mExtraFillSpace = endPadding;
            linearLayoutManager$LayoutState4.mCurrentPosition += linearLayoutManager$LayoutState4.mItemDirection;
            fill(recyclerView$Recycler, linearLayoutManager$LayoutState4, recyclerView$State, false);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState5 = this.mLayoutState;
            i = linearLayoutManager$LayoutState5.mOffset;
            int i10 = linearLayoutManager$LayoutState5.mAvailable;
            if (i10 > 0) {
                updateLayoutStateToFillStart(i8, i2);
                LinearLayoutManager$LayoutState linearLayoutManager$LayoutState6 = this.mLayoutState;
                linearLayoutManager$LayoutState6.mExtraFillSpace = i10;
                fill(recyclerView$Recycler, linearLayoutManager$LayoutState6, recyclerView$State, false);
                i2 = this.mLayoutState.mOffset;
            }
        } else {
            updateLayoutStateToFillEnd(linearLayoutManager$AnchorInfo4);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState7 = this.mLayoutState;
            linearLayoutManager$LayoutState7.mExtraFillSpace = endPadding;
            fill(recyclerView$Recycler, linearLayoutManager$LayoutState7, recyclerView$State, false);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState8 = this.mLayoutState;
            i = linearLayoutManager$LayoutState8.mOffset;
            int i11 = linearLayoutManager$LayoutState8.mCurrentPosition;
            int i12 = linearLayoutManager$LayoutState8.mAvailable;
            if (i12 > 0) {
                startAfterPadding += i12;
            }
            updateLayoutStateToFillStart(this.mAnchorInfo);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState9 = this.mLayoutState;
            linearLayoutManager$LayoutState9.mExtraFillSpace = startAfterPadding;
            linearLayoutManager$LayoutState9.mCurrentPosition += linearLayoutManager$LayoutState9.mItemDirection;
            fill(recyclerView$Recycler, linearLayoutManager$LayoutState9, recyclerView$State, false);
            LinearLayoutManager$LayoutState linearLayoutManager$LayoutState10 = this.mLayoutState;
            int i13 = linearLayoutManager$LayoutState10.mOffset;
            int i14 = linearLayoutManager$LayoutState10.mAvailable;
            if (i14 > 0) {
                updateLayoutStateToFillEnd(i11, i);
                LinearLayoutManager$LayoutState linearLayoutManager$LayoutState11 = this.mLayoutState;
                linearLayoutManager$LayoutState11.mExtraFillSpace = i14;
                fill(recyclerView$Recycler, linearLayoutManager$LayoutState11, recyclerView$State, false);
                i = this.mLayoutState.mOffset;
            }
            i2 = i13;
        }
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout ^ this.mStackFromEnd) {
                int iFixLayoutEndGap2 = fixLayoutEndGap(i, recyclerView$Recycler, recyclerView$State, true);
                i3 = i2 + iFixLayoutEndGap2;
                i4 = i + iFixLayoutEndGap2;
                iFixLayoutEndGap = fixLayoutStartGap(i3, recyclerView$Recycler, recyclerView$State, false);
            } else {
                int iFixLayoutStartGap = fixLayoutStartGap(i2, recyclerView$Recycler, recyclerView$State, true);
                i3 = i2 + iFixLayoutStartGap;
                i4 = i + iFixLayoutStartGap;
                iFixLayoutEndGap = fixLayoutEndGap(i4, recyclerView$Recycler, recyclerView$State, false);
            }
            i2 = i3 + iFixLayoutEndGap;
            i = i4 + iFixLayoutEndGap;
        }
        layoutForPredictiveAnimations(recyclerView$Recycler, recyclerView$State, i2, i);
        if (recyclerView$State.isPreLayout()) {
            this.mAnchorInfo.reset();
        } else {
            this.mOrientationHelper.onLayoutComplete();
        }
        this.mLastStackFromEnd = this.mStackFromEnd;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.mPendingSavedState = null;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof LinearLayoutManager$SavedState) {
            LinearLayoutManager$SavedState linearLayoutManager$SavedState = (LinearLayoutManager$SavedState) parcelable;
            this.mPendingSavedState = linearLayoutManager$SavedState;
            if (this.mPendingScrollPosition != -1) {
                linearLayoutManager$SavedState.invalidateAnchor();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public Parcelable onSaveInstanceState() {
        if (this.mPendingSavedState != null) {
            return new LinearLayoutManager$SavedState(this.mPendingSavedState);
        }
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = new LinearLayoutManager$SavedState();
        if (getChildCount() > 0) {
            ensureLayoutState();
            boolean z2 = this.mLastStackFromEnd ^ this.mShouldReverseLayout;
            linearLayoutManager$SavedState.mAnchorLayoutFromEnd = z2;
            if (z2) {
                View childClosestToEnd = getChildClosestToEnd();
                linearLayoutManager$SavedState.mAnchorOffset = this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(childClosestToEnd);
                linearLayoutManager$SavedState.mAnchorPosition = getPosition(childClosestToEnd);
            } else {
                View childClosestToStart = getChildClosestToStart();
                linearLayoutManager$SavedState.mAnchorPosition = getPosition(childClosestToStart);
                linearLayoutManager$SavedState.mAnchorOffset = this.mOrientationHelper.getDecoratedStart(childClosestToStart) - this.mOrientationHelper.getStartAfterPadding();
            }
        } else {
            linearLayoutManager$SavedState.invalidateAnchor();
        }
        return linearLayoutManager$SavedState;
    }

    @Override // androidx.recyclerview.widget.ItemTouchHelper$ViewDropHandler
    public void prepareForDrop(@NonNull View view, @NonNull View view2, int i, int i2) {
        assertNotInLayoutOrScroll("Cannot drop a view during a scroll or layout calculation");
        ensureLayoutState();
        resolveShouldLayoutReverse();
        int position = getPosition(view);
        int position2 = getPosition(view2);
        byte b2 = position < position2 ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            if (b2 == 1) {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - (this.mOrientationHelper.getDecoratedMeasurement(view) + this.mOrientationHelper.getDecoratedStart(view2)));
                return;
            } else {
                scrollToPositionWithOffset(position2, this.mOrientationHelper.getEndAfterPadding() - this.mOrientationHelper.getDecoratedEnd(view2));
                return;
            }
        }
        if (b2 == -1) {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedStart(view2));
        } else {
            scrollToPositionWithOffset(position2, this.mOrientationHelper.getDecoratedEnd(view2) - this.mOrientationHelper.getDecoratedMeasurement(view));
        }
    }

    public boolean resolveIsInfinite() {
        return this.mOrientationHelper.getMode() == 0 && this.mOrientationHelper.getEnd() == 0;
    }

    public int scrollBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        ensureLayoutState();
        this.mLayoutState.mRecycle = true;
        int i2 = i > 0 ? 1 : -1;
        int iAbs = Math.abs(i);
        updateLayoutState(i2, iAbs, true, recyclerView$State);
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        int iFill = fill(recyclerView$Recycler, linearLayoutManager$LayoutState, recyclerView$State, false) + linearLayoutManager$LayoutState.mScrollingOffset;
        if (iFill < 0) {
            return 0;
        }
        if (iAbs > iFill) {
            i = i2 * iFill;
        }
        this.mOrientationHelper.offsetChildren(-i);
        this.mLayoutState.mLastScrollDelta = i;
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (this.mOrientation == 1) {
            return 0;
        }
        return scrollBy(i, recyclerView$Recycler, recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void scrollToPosition(int i) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.invalidateAnchor();
        }
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        LinearLayoutManager$SavedState linearLayoutManager$SavedState = this.mPendingSavedState;
        if (linearLayoutManager$SavedState != null) {
            linearLayoutManager$SavedState.invalidateAnchor();
        }
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (this.mOrientation == 0) {
            return 0;
        }
        return scrollBy(i, recyclerView$Recycler, recyclerView$State);
    }

    public void setInitialPrefetchItemCount(int i) {
        this.mInitialPrefetchItemCount = i;
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(a.q("invalid orientation:", i));
        }
        assertNotInLayoutOrScroll(null);
        if (i != this.mOrientation || this.mOrientationHelper == null) {
            OrientationHelper orientationHelperCreateOrientationHelper = OrientationHelper.createOrientationHelper(this, i);
            this.mOrientationHelper = orientationHelperCreateOrientationHelper;
            this.mAnchorInfo.mOrientationHelper = orientationHelperCreateOrientationHelper;
            this.mOrientation = i;
            requestLayout();
        }
    }

    public void setRecycleChildrenOnDetach(boolean z2) {
        this.mRecycleChildrenOnDetach = z2;
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll(null);
        if (z2 == this.mReverseLayout) {
            return;
        }
        this.mReverseLayout = z2;
        requestLayout();
    }

    public void setSmoothScrollbarEnabled(boolean z2) {
        this.mSmoothScrollbarEnabled = z2;
    }

    public void setStackFromEnd(boolean z2) {
        assertNotInLayoutOrScroll(null);
        if (this.mStackFromEnd == z2) {
            return;
        }
        this.mStackFromEnd = z2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean shouldMeasureTwice() {
        return (getHeightMode() == 1073741824 || getWidthMode() == 1073741824 || !hasFlexibleChildInBothOrientations()) ? false : true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State recyclerView$State, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null && this.mLastStackFromEnd == this.mStackFromEnd;
    }

    public void validateChildOrder() {
        StringBuilder sbU = a.U("validating child count ");
        sbU.append(getChildCount());
        Log.d(TAG, sbU.toString());
        if (getChildCount() < 1) {
            return;
        }
        int position = getPosition(getChildAt(0));
        int decoratedStart = this.mOrientationHelper.getDecoratedStart(getChildAt(0));
        if (this.mShouldReverseLayout) {
            for (int i = 1; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                int position2 = getPosition(childAt);
                int decoratedStart2 = this.mOrientationHelper.getDecoratedStart(childAt);
                if (position2 < position) {
                    logChildren();
                    StringBuilder sbU2 = a.U("detected invalid position. loc invalid? ");
                    sbU2.append(decoratedStart2 < decoratedStart);
                    throw new RuntimeException(sbU2.toString());
                }
                if (decoratedStart2 > decoratedStart) {
                    logChildren();
                    throw new RuntimeException("detected invalid location");
                }
            }
            return;
        }
        for (int i2 = 1; i2 < getChildCount(); i2++) {
            View childAt2 = getChildAt(i2);
            int position3 = getPosition(childAt2);
            int decoratedStart3 = this.mOrientationHelper.getDecoratedStart(childAt2);
            if (position3 < position) {
                logChildren();
                StringBuilder sbU3 = a.U("detected invalid position. loc invalid? ");
                sbU3.append(decoratedStart3 < decoratedStart);
                throw new RuntimeException(sbU3.toString());
            }
            if (decoratedStart3 < decoratedStart) {
                logChildren();
                throw new RuntimeException("detected invalid location");
            }
        }
    }

    public LinearLayoutManager(Context context, int i, boolean z2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new LinearLayoutManager$AnchorInfo();
        this.mLayoutChunkResult = new LinearLayoutManager$LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        setOrientation(i);
        setReverseLayout(z2);
    }

    private void updateLayoutStateToFillEnd(int i, int i2) {
        this.mLayoutState.mAvailable = this.mOrientationHelper.getEndAfterPadding() - i2;
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        linearLayoutManager$LayoutState.mItemDirection = this.mShouldReverseLayout ? -1 : 1;
        linearLayoutManager$LayoutState.mCurrentPosition = i;
        linearLayoutManager$LayoutState.mLayoutDirection = 1;
        linearLayoutManager$LayoutState.mOffset = i2;
        linearLayoutManager$LayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    private void updateLayoutStateToFillStart(int i, int i2) {
        this.mLayoutState.mAvailable = i2 - this.mOrientationHelper.getStartAfterPadding();
        LinearLayoutManager$LayoutState linearLayoutManager$LayoutState = this.mLayoutState;
        linearLayoutManager$LayoutState.mCurrentPosition = i;
        linearLayoutManager$LayoutState.mItemDirection = this.mShouldReverseLayout ? 1 : -1;
        linearLayoutManager$LayoutState.mLayoutDirection = -1;
        linearLayoutManager$LayoutState.mOffset = i2;
        linearLayoutManager$LayoutState.mScrollingOffset = Integer.MIN_VALUE;
    }

    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        this.mOrientation = 1;
        this.mReverseLayout = false;
        this.mShouldReverseLayout = false;
        this.mStackFromEnd = false;
        this.mSmoothScrollbarEnabled = true;
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo = new LinearLayoutManager$AnchorInfo();
        this.mLayoutChunkResult = new LinearLayoutManager$LayoutChunkResult();
        this.mInitialPrefetchItemCount = 2;
        this.mReusableIntPair = new int[2];
        RecyclerView$LayoutManager$Properties properties = RecyclerView$LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setReverseLayout(properties.reverseLayout);
        setStackFromEnd(properties.stackFromEnd);
    }
}
