package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import b.d.b.a.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;

/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends RecyclerView$LayoutManager implements RecyclerView$SmoothScroller$ScrollVectorProvider {
    public static final boolean DEBUG = false;

    @Deprecated
    public static final int GAP_HANDLING_LAZY = 1;
    public static final int GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS = 2;
    public static final int GAP_HANDLING_NONE = 0;
    public static final int HORIZONTAL = 0;
    public static final int INVALID_OFFSET = Integer.MIN_VALUE;
    private static final float MAX_SCROLL_FACTOR = 0.33333334f;
    private static final String TAG = "StaggeredGridLManager";
    public static final int VERTICAL = 1;
    private int mFullSizeSpec;
    private boolean mLastLayoutFromEnd;
    private boolean mLastLayoutRTL;

    @NonNull
    private final LayoutState mLayoutState;
    private int mOrientation;
    private StaggeredGridLayoutManager$SavedState mPendingSavedState;
    private int[] mPrefetchDistances;

    @NonNull
    public OrientationHelper mPrimaryOrientation;
    private BitSet mRemainingSpans;

    @NonNull
    public OrientationHelper mSecondaryOrientation;
    private int mSizePerSpan;
    public StaggeredGridLayoutManager$Span[] mSpans;
    private int mSpanCount = -1;
    public boolean mReverseLayout = false;
    public boolean mShouldReverseLayout = false;
    public int mPendingScrollPosition = -1;
    public int mPendingScrollPositionOffset = Integer.MIN_VALUE;
    public StaggeredGridLayoutManager$LazySpanLookup mLazySpanLookup = new StaggeredGridLayoutManager$LazySpanLookup();
    private int mGapStrategy = 2;
    private final Rect mTmpRect = new Rect();
    private final StaggeredGridLayoutManager$AnchorInfo mAnchorInfo = new StaggeredGridLayoutManager$AnchorInfo(this);
    private boolean mLaidOutInvalidFullSpan = false;
    private boolean mSmoothScrollbarEnabled = true;
    private final Runnable mCheckForGapsRunnable = new StaggeredGridLayoutManager$1(this);

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i2) {
        RecyclerView$LayoutManager$Properties properties = RecyclerView$LayoutManager.getProperties(context, attributeSet, i, i2);
        setOrientation(properties.orientation);
        setSpanCount(properties.spanCount);
        setReverseLayout(properties.reverseLayout);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void appendViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].appendToSpan(view);
        }
    }

    private void applyPendingSavedState(StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        int i = staggeredGridLayoutManager$SavedState.mSpanOffsetsSize;
        if (i > 0) {
            if (i == this.mSpanCount) {
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    this.mSpans[i2].clear();
                    StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState2 = this.mPendingSavedState;
                    int endAfterPadding = staggeredGridLayoutManager$SavedState2.mSpanOffsets[i2];
                    if (endAfterPadding != Integer.MIN_VALUE) {
                        endAfterPadding += staggeredGridLayoutManager$SavedState2.mAnchorLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                    }
                    this.mSpans[i2].setLine(endAfterPadding);
                }
            } else {
                staggeredGridLayoutManager$SavedState.invalidateSpanInfo();
                StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState3 = this.mPendingSavedState;
                staggeredGridLayoutManager$SavedState3.mAnchorPosition = staggeredGridLayoutManager$SavedState3.mVisibleAnchorPosition;
            }
        }
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState4 = this.mPendingSavedState;
        this.mLastLayoutRTL = staggeredGridLayoutManager$SavedState4.mLastLayoutRTL;
        setReverseLayout(staggeredGridLayoutManager$SavedState4.mReverseLayout);
        resolveShouldLayoutReverse();
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState5 = this.mPendingSavedState;
        int i3 = staggeredGridLayoutManager$SavedState5.mAnchorPosition;
        if (i3 != -1) {
            this.mPendingScrollPosition = i3;
            staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd = staggeredGridLayoutManager$SavedState5.mAnchorLayoutFromEnd;
        } else {
            staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
        }
        if (staggeredGridLayoutManager$SavedState5.mSpanLookupSize > 1) {
            StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup = this.mLazySpanLookup;
            staggeredGridLayoutManager$LazySpanLookup.mData = staggeredGridLayoutManager$SavedState5.mSpanLookup;
            staggeredGridLayoutManager$LazySpanLookup.mFullSpanItems = staggeredGridLayoutManager$SavedState5.mFullSpanItems;
        }
    }

    private void attachViewToSpans(View view, StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams, LayoutState layoutState) {
        if (layoutState.mLayoutDirection == 1) {
            if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                appendViewToAllSpans(view);
                return;
            } else {
                staggeredGridLayoutManager$LayoutParams.mSpan.appendToSpan(view);
                return;
            }
        }
        if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
            prependViewToAllSpans(view);
        } else {
            staggeredGridLayoutManager$LayoutParams.mSpan.prependToSpan(view);
        }
    }

    private int calculateScrollDirectionForPosition(int i) {
        if (getChildCount() == 0) {
            return this.mShouldReverseLayout ? 1 : -1;
        }
        return (i < getFirstChildPosition()) != this.mShouldReverseLayout ? -1 : 1;
    }

    private boolean checkSpanForGap(StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span) {
        if (this.mShouldReverseLayout) {
            if (staggeredGridLayoutManager$Span.getEndLine() < this.mPrimaryOrientation.getEndAfterPadding()) {
                ArrayList<View> arrayList = staggeredGridLayoutManager$Span.mViews;
                return !staggeredGridLayoutManager$Span.getLayoutParams(arrayList.get(arrayList.size() - 1)).mFullSpan;
            }
        } else if (staggeredGridLayoutManager$Span.getStartLine() > this.mPrimaryOrientation.getStartAfterPadding()) {
            return !staggeredGridLayoutManager$Span.getLayoutParams(staggeredGridLayoutManager$Span.mViews.get(0)).mFullSpan;
        }
        return false;
    }

    private int computeScrollExtent(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollExtent(recyclerView$State, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int computeScrollOffset(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollOffset(recyclerView$State, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled, this.mShouldReverseLayout);
    }

    private int computeScrollRange(RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0) {
            return 0;
        }
        return ScrollbarHelper.computeScrollRange(recyclerView$State, this.mPrimaryOrientation, findFirstVisibleItemClosestToStart(!this.mSmoothScrollbarEnabled), findFirstVisibleItemClosestToEnd(!this.mSmoothScrollbarEnabled), this, this.mSmoothScrollbarEnabled);
    }

    private int convertFocusDirectionToLayoutDirection(int i) {
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

    private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFullSpanItemFromEnd(int i) {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan[i2] = i - this.mSpans[i2].getEndLine(i);
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    private StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem createFullSpanItemFromStart(int i) {
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
        staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan = new int[this.mSpanCount];
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.mGapPerSpan[i2] = this.mSpans[i2].getStartLine(i) - i;
        }
        return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
    }

    private void createOrientationHelpers() {
        this.mPrimaryOrientation = OrientationHelper.createOrientationHelper(this, this.mOrientation);
        this.mSecondaryOrientation = OrientationHelper.createOrientationHelper(this, 1 - this.mOrientation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v7 */
    private int fill(RecyclerView$Recycler recyclerView$Recycler, LayoutState layoutState, RecyclerView$State recyclerView$State) {
        int i;
        int maxEnd;
        StaggeredGridLayoutManager$Span nextSpan;
        int decoratedMeasurement;
        int i2;
        int decoratedMeasurement2;
        int decoratedMeasurement3;
        ?? r9 = 0;
        this.mRemainingSpans.set(0, this.mSpanCount, true);
        if (this.mLayoutState.mInfinite) {
            i = layoutState.mLayoutDirection == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        } else {
            i = layoutState.mLayoutDirection == 1 ? layoutState.mEndLine + layoutState.mAvailable : layoutState.mStartLine - layoutState.mAvailable;
        }
        updateAllRemainingSpans(layoutState.mLayoutDirection, i);
        int endAfterPadding = this.mShouldReverseLayout ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
        boolean z2 = false;
        while (layoutState.hasMore(recyclerView$State) && (this.mLayoutState.mInfinite || !this.mRemainingSpans.isEmpty())) {
            View next = layoutState.next(recyclerView$Recycler);
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) next.getLayoutParams();
            int viewLayoutPosition = staggeredGridLayoutManager$LayoutParams.getViewLayoutPosition();
            int span = this.mLazySpanLookup.getSpan(viewLayoutPosition);
            boolean z3 = span == -1;
            if (z3) {
                nextSpan = staggeredGridLayoutManager$LayoutParams.mFullSpan ? this.mSpans[r9] : getNextSpan(layoutState);
                this.mLazySpanLookup.setSpan(viewLayoutPosition, nextSpan);
            } else {
                nextSpan = this.mSpans[span];
            }
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = nextSpan;
            staggeredGridLayoutManager$LayoutParams.mSpan = staggeredGridLayoutManager$Span;
            if (layoutState.mLayoutDirection == 1) {
                addView(next);
            } else {
                addView(next, r9);
            }
            measureChildWithDecorationsAndMargin(next, staggeredGridLayoutManager$LayoutParams, r9);
            if (layoutState.mLayoutDirection == 1) {
                int maxEnd2 = staggeredGridLayoutManager$LayoutParams.mFullSpan ? getMaxEnd(endAfterPadding) : staggeredGridLayoutManager$Span.getEndLine(endAfterPadding);
                int decoratedMeasurement4 = this.mPrimaryOrientation.getDecoratedMeasurement(next) + maxEnd2;
                if (z3 && staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromEnd = createFullSpanItemFromEnd(maxEnd2);
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromEnd.mGapDir = -1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromEnd.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromEnd);
                }
                i2 = decoratedMeasurement4;
                decoratedMeasurement = maxEnd2;
            } else {
                int minStart = staggeredGridLayoutManager$LayoutParams.mFullSpan ? getMinStart(endAfterPadding) : staggeredGridLayoutManager$Span.getStartLine(endAfterPadding);
                decoratedMeasurement = minStart - this.mPrimaryOrientation.getDecoratedMeasurement(next);
                if (z3 && staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                    StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromStart = createFullSpanItemFromStart(minStart);
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromStart.mGapDir = 1;
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromStart.mPosition = viewLayoutPosition;
                    this.mLazySpanLookup.addFullSpanItem(staggeredGridLayoutManager$LazySpanLookup$FullSpanItemCreateFullSpanItemFromStart);
                }
                i2 = minStart;
            }
            if (staggeredGridLayoutManager$LayoutParams.mFullSpan && layoutState.mItemDirection == -1) {
                if (z3) {
                    this.mLaidOutInvalidFullSpan = true;
                } else {
                    if (!(layoutState.mLayoutDirection == 1 ? areAllEndsEqual() : areAllStartsEqual())) {
                        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem fullSpanItem = this.mLazySpanLookup.getFullSpanItem(viewLayoutPosition);
                        if (fullSpanItem != null) {
                            fullSpanItem.mHasUnwantedGapAfter = true;
                        }
                        this.mLaidOutInvalidFullSpan = true;
                    }
                }
            }
            attachViewToSpans(next, staggeredGridLayoutManager$LayoutParams, layoutState);
            if (isLayoutRTL() && this.mOrientation == 1) {
                int endAfterPadding2 = staggeredGridLayoutManager$LayoutParams.mFullSpan ? this.mSecondaryOrientation.getEndAfterPadding() : this.mSecondaryOrientation.getEndAfterPadding() - (((this.mSpanCount - 1) - staggeredGridLayoutManager$Span.mIndex) * this.mSizePerSpan);
                decoratedMeasurement3 = endAfterPadding2;
                decoratedMeasurement2 = endAfterPadding2 - this.mSecondaryOrientation.getDecoratedMeasurement(next);
            } else {
                int startAfterPadding = staggeredGridLayoutManager$LayoutParams.mFullSpan ? this.mSecondaryOrientation.getStartAfterPadding() : (staggeredGridLayoutManager$Span.mIndex * this.mSizePerSpan) + this.mSecondaryOrientation.getStartAfterPadding();
                decoratedMeasurement2 = startAfterPadding;
                decoratedMeasurement3 = this.mSecondaryOrientation.getDecoratedMeasurement(next) + startAfterPadding;
            }
            if (this.mOrientation == 1) {
                layoutDecoratedWithMargins(next, decoratedMeasurement2, decoratedMeasurement, decoratedMeasurement3, i2);
            } else {
                layoutDecoratedWithMargins(next, decoratedMeasurement, decoratedMeasurement2, i2, decoratedMeasurement3);
            }
            if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                updateAllRemainingSpans(this.mLayoutState.mLayoutDirection, i);
            } else {
                updateRemainingSpans(staggeredGridLayoutManager$Span, this.mLayoutState.mLayoutDirection, i);
            }
            recycle(recyclerView$Recycler, this.mLayoutState);
            if (this.mLayoutState.mStopInFocusable && next.hasFocusable()) {
                if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                    this.mRemainingSpans.clear();
                } else {
                    this.mRemainingSpans.set(staggeredGridLayoutManager$Span.mIndex, false);
                }
            }
            z2 = true;
            r9 = 0;
        }
        if (!z2) {
            recycle(recyclerView$Recycler, this.mLayoutState);
        }
        if (this.mLayoutState.mLayoutDirection == -1) {
            maxEnd = this.mPrimaryOrientation.getStartAfterPadding() - getMinStart(this.mPrimaryOrientation.getStartAfterPadding());
        } else {
            maxEnd = getMaxEnd(this.mPrimaryOrientation.getEndAfterPadding()) - this.mPrimaryOrientation.getEndAfterPadding();
        }
        if (maxEnd > 0) {
            return Math.min(layoutState.mAvailable, maxEnd);
        }
        return 0;
    }

    private int findFirstReferenceChildPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            int position = getPosition(getChildAt(i2));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private int findLastReferenceChildPosition(int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            int position = getPosition(getChildAt(childCount));
            if (position >= 0 && position < i) {
                return position;
            }
        }
        return 0;
    }

    private void fixEndGap(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        int endAfterPadding;
        int maxEnd = getMaxEnd(Integer.MIN_VALUE);
        if (maxEnd != Integer.MIN_VALUE && (endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - maxEnd) > 0) {
            int i = endAfterPadding - (-scrollBy(-endAfterPadding, recyclerView$Recycler, recyclerView$State));
            if (!z2 || i <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(i);
        }
    }

    private void fixStartGap(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        int startAfterPadding;
        int minStart = getMinStart(Integer.MAX_VALUE);
        if (minStart != Integer.MAX_VALUE && (startAfterPadding = minStart - this.mPrimaryOrientation.getStartAfterPadding()) > 0) {
            int iScrollBy = startAfterPadding - scrollBy(startAfterPadding, recyclerView$Recycler, recyclerView$State);
            if (!z2 || iScrollBy <= 0) {
                return;
            }
            this.mPrimaryOrientation.offsetChildren(-iScrollBy);
        }
    }

    private int getMaxEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 > endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMaxStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 > startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private int getMinEnd(int i) {
        int endLine = this.mSpans[0].getEndLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int endLine2 = this.mSpans[i2].getEndLine(i);
            if (endLine2 < endLine) {
                endLine = endLine2;
            }
        }
        return endLine;
    }

    private int getMinStart(int i) {
        int startLine = this.mSpans[0].getStartLine(i);
        for (int i2 = 1; i2 < this.mSpanCount; i2++) {
            int startLine2 = this.mSpans[i2].getStartLine(i);
            if (startLine2 < startLine) {
                startLine = startLine2;
            }
        }
        return startLine;
    }

    private StaggeredGridLayoutManager$Span getNextSpan(LayoutState layoutState) {
        int i;
        int i2;
        int i3 = -1;
        if (preferLastSpan(layoutState.mLayoutDirection)) {
            i = this.mSpanCount - 1;
            i2 = -1;
        } else {
            i = 0;
            i3 = this.mSpanCount;
            i2 = 1;
        }
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = null;
        if (layoutState.mLayoutDirection == 1) {
            int i4 = Integer.MAX_VALUE;
            int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
            while (i != i3) {
                StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span2 = this.mSpans[i];
                int endLine = staggeredGridLayoutManager$Span2.getEndLine(startAfterPadding);
                if (endLine < i4) {
                    staggeredGridLayoutManager$Span = staggeredGridLayoutManager$Span2;
                    i4 = endLine;
                }
                i += i2;
            }
            return staggeredGridLayoutManager$Span;
        }
        int i5 = Integer.MIN_VALUE;
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        while (i != i3) {
            StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span3 = this.mSpans[i];
            int startLine = staggeredGridLayoutManager$Span3.getStartLine(endAfterPadding);
            if (startLine > i5) {
                staggeredGridLayoutManager$Span = staggeredGridLayoutManager$Span3;
                i5 = startLine;
            }
            i += i2;
        }
        return staggeredGridLayoutManager$Span;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0025  */
    /* JADX WARN: Code duplicated, block: B:17:0x0028 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:19:0x002b  */
    /* JADX WARN: Code duplicated, block: B:20:0x0036  */
    /* JADX WARN: Code duplicated, block: B:21:0x003c  */
    /* JADX WARN: Code duplicated, block: B:23:0x0043 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:24:0x0044  */
    /* JADX WARN: Code duplicated, block: B:26:0x0048  */
    /* JADX WARN: Code duplicated, block: B:27:0x004d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:? A[RETURN, SYNTHETIC] */
    private void handleUpdate(int i, int i2, int i3) {
        int i4;
        int i5;
        int lastChildPosition;
        int lastChildPosition2 = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
        if (i3 == 8) {
            if (i < i2) {
                i4 = i2 + 1;
            } else {
                i4 = i + 1;
                i5 = i2;
            }
            this.mLazySpanLookup.invalidateAfter(i5);
            if (i3 != 1) {
                this.mLazySpanLookup.offsetForAddition(i, i2);
            } else if (i3 != 2) {
                this.mLazySpanLookup.offsetForRemoval(i, i2);
            } else if (i3 == 8) {
                this.mLazySpanLookup.offsetForRemoval(i, 1);
                this.mLazySpanLookup.offsetForAddition(i2, 1);
            }
            if (i4 <= lastChildPosition2) {
                return;
            }
            if (this.mShouldReverseLayout) {
                lastChildPosition = getFirstChildPosition();
            } else {
                lastChildPosition = getLastChildPosition();
            }
            if (i5 <= lastChildPosition) {
                requestLayout();
            }
        }
        i4 = i + i2;
        i5 = i;
        this.mLazySpanLookup.invalidateAfter(i5);
        if (i3 != 1) {
            this.mLazySpanLookup.offsetForAddition(i, i2);
        } else if (i3 != 2) {
            this.mLazySpanLookup.offsetForRemoval(i, i2);
        } else if (i3 == 8) {
            this.mLazySpanLookup.offsetForRemoval(i, 1);
            this.mLazySpanLookup.offsetForAddition(i2, 1);
        }
        if (i4 <= lastChildPosition2) {
            return;
        }
        if (this.mShouldReverseLayout) {
            lastChildPosition = getFirstChildPosition();
        } else {
            lastChildPosition = getLastChildPosition();
        }
        if (i5 <= lastChildPosition) {
            requestLayout();
        }
    }

    private void measureChildWithDecorationsAndMargin(View view, StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams, boolean z2) {
        if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
            if (this.mOrientation != 1) {
                measureChildWithDecorationsAndMargin(view, RecyclerView$LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).width, true), this.mFullSizeSpec, z2);
                return;
            }
            measureChildWithDecorationsAndMargin(view, this.mFullSizeSpec, RecyclerView$LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).height, true), z2);
            return;
        }
        if (this.mOrientation != 1) {
            measureChildWithDecorationsAndMargin(view, RecyclerView$LayoutManager.getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft(), ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).width, true), RecyclerView$LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getHeightMode(), 0, ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).height, false), z2);
            return;
        }
        measureChildWithDecorationsAndMargin(view, RecyclerView$LayoutManager.getChildMeasureSpec(this.mSizePerSpan, getWidthMode(), 0, ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).width, false), RecyclerView$LayoutManager.getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop(), ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).height, true), z2);
    }

    private boolean preferLastSpan(int i) {
        if (this.mOrientation == 0) {
            return (i == -1) != this.mShouldReverseLayout;
        }
        return ((i == -1) == this.mShouldReverseLayout) == isLayoutRTL();
    }

    private void prependViewToAllSpans(View view) {
        for (int i = this.mSpanCount - 1; i >= 0; i--) {
            this.mSpans[i].prependToSpan(view);
        }
    }

    private void recycle(RecyclerView$Recycler recyclerView$Recycler, LayoutState layoutState) {
        int iMin;
        if (!layoutState.mRecycle || layoutState.mInfinite) {
            return;
        }
        if (layoutState.mAvailable == 0) {
            if (layoutState.mLayoutDirection == -1) {
                recycleFromEnd(recyclerView$Recycler, layoutState.mEndLine);
                return;
            } else {
                recycleFromStart(recyclerView$Recycler, layoutState.mStartLine);
                return;
            }
        }
        if (layoutState.mLayoutDirection == -1) {
            int i = layoutState.mStartLine;
            int maxStart = i - getMaxStart(i);
            recycleFromEnd(recyclerView$Recycler, maxStart < 0 ? layoutState.mEndLine : layoutState.mEndLine - Math.min(maxStart, layoutState.mAvailable));
        } else {
            int minEnd = getMinEnd(layoutState.mEndLine) - layoutState.mEndLine;
            if (minEnd < 0) {
                iMin = layoutState.mStartLine;
            } else {
                iMin = Math.min(minEnd, layoutState.mAvailable) + layoutState.mStartLine;
            }
            recycleFromStart(recyclerView$Recycler, iMin);
        }
    }

    private void recycleFromEnd(RecyclerView$Recycler recyclerView$Recycler, int i) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (this.mPrimaryOrientation.getDecoratedStart(childAt) < i || this.mPrimaryOrientation.getTransformedStartWithDecoration(childAt) < i) {
                return;
            }
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) childAt.getLayoutParams();
            if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    if (this.mSpans[i2].mViews.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.mSpans[i3].popEnd();
                }
            } else if (staggeredGridLayoutManager$LayoutParams.mSpan.mViews.size() == 1) {
                return;
            } else {
                staggeredGridLayoutManager$LayoutParams.mSpan.popEnd();
            }
            removeAndRecycleView(childAt, recyclerView$Recycler);
        }
    }

    private void recycleFromStart(RecyclerView$Recycler recyclerView$Recycler, int i) {
        while (getChildCount() > 0) {
            View childAt = getChildAt(0);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > i || this.mPrimaryOrientation.getTransformedEndWithDecoration(childAt) > i) {
                return;
            }
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) childAt.getLayoutParams();
            if (staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                    if (this.mSpans[i2].mViews.size() == 1) {
                        return;
                    }
                }
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.mSpans[i3].popStart();
                }
            } else if (staggeredGridLayoutManager$LayoutParams.mSpan.mViews.size() == 1) {
                return;
            } else {
                staggeredGridLayoutManager$LayoutParams.mSpan.popStart();
            }
            removeAndRecycleView(childAt, recyclerView$Recycler);
        }
    }

    private void repositionToWrapContentIfNecessary() {
        if (this.mSecondaryOrientation.getMode() == 1073741824) {
            return;
        }
        float fMax = 0.0f;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            float decoratedMeasurement = this.mSecondaryOrientation.getDecoratedMeasurement(childAt);
            if (decoratedMeasurement >= fMax) {
                if (((StaggeredGridLayoutManager$LayoutParams) childAt.getLayoutParams()).isFullSpan()) {
                    decoratedMeasurement = (decoratedMeasurement * 1.0f) / this.mSpanCount;
                }
                fMax = Math.max(fMax, decoratedMeasurement);
            }
        }
        int i2 = this.mSizePerSpan;
        int iRound = Math.round(fMax * this.mSpanCount);
        if (this.mSecondaryOrientation.getMode() == Integer.MIN_VALUE) {
            iRound = Math.min(iRound, this.mSecondaryOrientation.getTotalSpace());
        }
        updateMeasureSpecs(iRound);
        if (this.mSizePerSpan == i2) {
            return;
        }
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt2 = getChildAt(i3);
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) childAt2.getLayoutParams();
            if (!staggeredGridLayoutManager$LayoutParams.mFullSpan) {
                if (isLayoutRTL() && this.mOrientation == 1) {
                    int i4 = this.mSpanCount;
                    int i5 = staggeredGridLayoutManager$LayoutParams.mSpan.mIndex;
                    childAt2.offsetLeftAndRight(((-((i4 - 1) - i5)) * this.mSizePerSpan) - ((-((i4 - 1) - i5)) * i2));
                } else {
                    int i6 = staggeredGridLayoutManager$LayoutParams.mSpan.mIndex;
                    int i7 = this.mSizePerSpan * i6;
                    int i8 = i6 * i2;
                    if (this.mOrientation == 1) {
                        childAt2.offsetLeftAndRight(i7 - i8);
                    } else {
                        childAt2.offsetTopAndBottom(i7 - i8);
                    }
                }
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

    private void setLayoutStateDirection(int i) {
        LayoutState layoutState = this.mLayoutState;
        layoutState.mLayoutDirection = i;
        layoutState.mItemDirection = this.mShouldReverseLayout != (i == -1) ? -1 : 1;
    }

    private void updateAllRemainingSpans(int i, int i2) {
        for (int i3 = 0; i3 < this.mSpanCount; i3++) {
            if (!this.mSpans[i3].mViews.isEmpty()) {
                updateRemainingSpans(this.mSpans[i3], i, i2);
            }
        }
    }

    private boolean updateAnchorFromChildren(RecyclerView$State recyclerView$State, StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        staggeredGridLayoutManager$AnchorInfo.mPosition = this.mLastLayoutFromEnd ? findLastReferenceChildPosition(recyclerView$State.getItemCount()) : findFirstReferenceChildPosition(recyclerView$State.getItemCount());
        staggeredGridLayoutManager$AnchorInfo.mOffset = Integer.MIN_VALUE;
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:17:0x0036  */
    /* JADX WARN: Code duplicated, block: B:18:0x004d  */
    private void updateLayoutState(int i, RecyclerView$State recyclerView$State) {
        int totalSpace;
        int totalSpace2;
        int targetScrollPosition;
        LayoutState layoutState = this.mLayoutState;
        boolean z2 = false;
        layoutState.mAvailable = 0;
        layoutState.mCurrentPosition = i;
        if (isSmoothScrolling() && (targetScrollPosition = recyclerView$State.getTargetScrollPosition()) != -1) {
            if (this.mShouldReverseLayout == (targetScrollPosition < i)) {
                totalSpace = this.mPrimaryOrientation.getTotalSpace();
            } else {
                totalSpace2 = this.mPrimaryOrientation.getTotalSpace();
                totalSpace = 0;
            }
            if (getClipToPadding()) {
                this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
                this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + totalSpace;
            } else {
                this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + totalSpace;
                this.mLayoutState.mStartLine = -totalSpace2;
            }
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mStopInFocusable = false;
            layoutState2.mRecycle = true;
            if (this.mPrimaryOrientation.getMode() == 0 && this.mPrimaryOrientation.getEnd() == 0) {
                z2 = true;
            }
            layoutState2.mInfinite = z2;
        }
        totalSpace = 0;
        totalSpace2 = 0;
        if (getClipToPadding()) {
            this.mLayoutState.mStartLine = this.mPrimaryOrientation.getStartAfterPadding() - totalSpace2;
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEndAfterPadding() + totalSpace;
        } else {
            this.mLayoutState.mEndLine = this.mPrimaryOrientation.getEnd() + totalSpace;
            this.mLayoutState.mStartLine = -totalSpace2;
        }
        LayoutState layoutState3 = this.mLayoutState;
        layoutState3.mStopInFocusable = false;
        layoutState3.mRecycle = true;
        if (this.mPrimaryOrientation.getMode() == 0) {
            z2 = true;
        }
        layoutState3.mInfinite = z2;
    }

    private void updateRemainingSpans(StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span, int i, int i2) {
        int deletedSize = staggeredGridLayoutManager$Span.getDeletedSize();
        if (i == -1) {
            if (staggeredGridLayoutManager$Span.getStartLine() + deletedSize <= i2) {
                this.mRemainingSpans.set(staggeredGridLayoutManager$Span.mIndex, false);
            }
        } else if (staggeredGridLayoutManager$Span.getEndLine() - deletedSize >= i2) {
            this.mRemainingSpans.set(staggeredGridLayoutManager$Span.mIndex, false);
        }
    }

    private int updateSpecWithExtra(int i, int i2, int i3) {
        if (i2 == 0 && i3 == 0) {
            return i;
        }
        int mode = View$MeasureSpec.getMode(i);
        return (mode == Integer.MIN_VALUE || mode == 1073741824) ? View$MeasureSpec.makeMeasureSpec(Math.max(0, (View$MeasureSpec.getSize(i) - i2) - i3), mode) : i;
    }

    public boolean areAllEndsEqual() {
        int endLine = this.mSpans[0].getEndLine(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.mSpans[i].getEndLine(Integer.MIN_VALUE) != endLine) {
                return false;
            }
        }
        return true;
    }

    public boolean areAllStartsEqual() {
        int startLine = this.mSpans[0].getStartLine(Integer.MIN_VALUE);
        for (int i = 1; i < this.mSpanCount; i++) {
            if (this.mSpans[i].getStartLine(Integer.MIN_VALUE) != startLine) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void assertNotInLayoutOrScroll(String str) {
        if (this.mPendingSavedState == null) {
            super.assertNotInLayoutOrScroll(str);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollHorizontally() {
        return this.mOrientation == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean canScrollVertically() {
        return this.mOrientation == 1;
    }

    public boolean checkForGaps() {
        int firstChildPosition;
        int lastChildPosition;
        if (getChildCount() == 0 || this.mGapStrategy == 0 || !isAttachedToWindow()) {
            return false;
        }
        if (this.mShouldReverseLayout) {
            firstChildPosition = getLastChildPosition();
            lastChildPosition = getFirstChildPosition();
        } else {
            firstChildPosition = getFirstChildPosition();
            lastChildPosition = getLastChildPosition();
        }
        if (firstChildPosition == 0 && hasGapsToFix() != null) {
            this.mLazySpanLookup.clear();
            requestSimpleAnimationsInNextLayout();
            requestLayout();
            return true;
        }
        if (!this.mLaidOutInvalidFullSpan) {
            return false;
        }
        int i = this.mShouldReverseLayout ? -1 : 1;
        int i2 = lastChildPosition + 1;
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem firstFullSpanItemInRange = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, i2, i, true);
        if (firstFullSpanItemInRange == null) {
            this.mLaidOutInvalidFullSpan = false;
            this.mLazySpanLookup.forceInvalidateAfter(i2);
            return false;
        }
        StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem firstFullSpanItemInRange2 = this.mLazySpanLookup.getFirstFullSpanItemInRange(firstChildPosition, firstFullSpanItemInRange.mPosition, i * (-1), true);
        if (firstFullSpanItemInRange2 == null) {
            this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange.mPosition);
        } else {
            this.mLazySpanLookup.forceInvalidateAfter(firstFullSpanItemInRange2.mPosition + 1);
        }
        requestSimpleAnimationsInNextLayout();
        requestLayout();
        return true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams instanceof StaggeredGridLayoutManager$LayoutParams;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    @RestrictTo({RestrictTo$Scope.LIBRARY})
    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView$State recyclerView$State, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
        int endLine;
        int startLine;
        if (this.mOrientation != 0) {
            i = i2;
        }
        if (getChildCount() == 0 || i == 0) {
            return;
        }
        prepareLayoutStateForDelta(i, recyclerView$State);
        int[] iArr = this.mPrefetchDistances;
        if (iArr == null || iArr.length < this.mSpanCount) {
            this.mPrefetchDistances = new int[this.mSpanCount];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.mSpanCount; i4++) {
            LayoutState layoutState = this.mLayoutState;
            if (layoutState.mItemDirection == -1) {
                endLine = layoutState.mStartLine;
                startLine = this.mSpans[i4].getStartLine(endLine);
            } else {
                endLine = this.mSpans[i4].getEndLine(layoutState.mEndLine);
                startLine = this.mLayoutState.mEndLine;
            }
            int i5 = endLine - startLine;
            if (i5 >= 0) {
                this.mPrefetchDistances[i3] = i5;
                i3++;
            }
        }
        Arrays.sort(this.mPrefetchDistances, 0, i3);
        for (int i6 = 0; i6 < i3 && this.mLayoutState.hasMore(recyclerView$State); i6++) {
            recyclerView$LayoutManager$LayoutPrefetchRegistry.addPosition(this.mLayoutState.mCurrentPosition, this.mPrefetchDistances[i6]);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition += layoutState2.mItemDirection;
        }
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
        int iCalculateScrollDirectionForPosition = calculateScrollDirectionForPosition(i);
        PointF pointF = new PointF();
        if (iCalculateScrollDirectionForPosition == 0) {
            return null;
        }
        if (this.mOrientation == 0) {
            pointF.x = iCalculateScrollDirectionForPosition;
            pointF.y = 0.0f;
        } else {
            pointF.x = 0.0f;
            pointF.y = iCalculateScrollDirectionForPosition;
        }
        return pointF;
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

    public int[] findFirstCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder sbU = a.U("Provided int[]'s size must be more than or equal to span count. Expected:");
            sbU.append(this.mSpanCount);
            sbU.append(", array size:");
            sbU.append(iArr.length);
            throw new IllegalArgumentException(sbU.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findFirstCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public View findFirstVisibleItemClosestToEnd(boolean z2) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        View view = null;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
            if (decoratedEnd > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedEnd <= endAfterPadding || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public View findFirstVisibleItemClosestToStart(boolean z2) {
        int startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
        int childCount = getChildCount();
        View view = null;
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
            if (this.mPrimaryOrientation.getDecoratedEnd(childAt) > startAfterPadding && decoratedStart < endAfterPadding) {
                if (decoratedStart >= startAfterPadding || !z2) {
                    return childAt;
                }
                if (view == null) {
                    view = childAt;
                }
            }
        }
        return view;
    }

    public int findFirstVisibleItemPositionInt() {
        View viewFindFirstVisibleItemClosestToEnd = this.mShouldReverseLayout ? findFirstVisibleItemClosestToEnd(true) : findFirstVisibleItemClosestToStart(true);
        if (viewFindFirstVisibleItemClosestToEnd == null) {
            return -1;
        }
        return getPosition(viewFindFirstVisibleItemClosestToEnd);
    }

    public int[] findFirstVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder sbU = a.U("Provided int[]'s size must be more than or equal to span count. Expected:");
            sbU.append(this.mSpanCount);
            sbU.append(", array size:");
            sbU.append(iArr.length);
            throw new IllegalArgumentException(sbU.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findFirstVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastCompletelyVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder sbU = a.U("Provided int[]'s size must be more than or equal to span count. Expected:");
            sbU.append(this.mSpanCount);
            sbU.append(", array size:");
            sbU.append(iArr.length);
            throw new IllegalArgumentException(sbU.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findLastCompletelyVisibleItemPosition();
        }
        return iArr;
    }

    public int[] findLastVisibleItemPositions(int[] iArr) {
        if (iArr == null) {
            iArr = new int[this.mSpanCount];
        } else if (iArr.length < this.mSpanCount) {
            StringBuilder sbU = a.U("Provided int[]'s size must be more than or equal to span count. Expected:");
            sbU.append(this.mSpanCount);
            sbU.append(", array size:");
            sbU.append(iArr.length);
            throw new IllegalArgumentException(sbU.toString());
        }
        for (int i = 0; i < this.mSpanCount; i++) {
            iArr[i] = this.mSpans[i].findLastVisibleItemPosition();
        }
        return iArr;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateDefaultLayoutParams() {
        return this.mOrientation == 0 ? new StaggeredGridLayoutManager$LayoutParams(-2, -1) : new StaggeredGridLayoutManager$LayoutParams(-1, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new StaggeredGridLayoutManager$LayoutParams(context, attributeSet);
    }

    public int getFirstChildPosition() {
        if (getChildCount() == 0) {
            return 0;
        }
        return getPosition(getChildAt(0));
    }

    public int getGapStrategy() {
        return this.mGapStrategy;
    }

    public int getLastChildPosition() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return 0;
        }
        return getPosition(getChildAt(childCount - 1));
    }

    public int getOrientation() {
        return this.mOrientation;
    }

    public boolean getReverseLayout() {
        return this.mReverseLayout;
    }

    public int getSpanCount() {
        return this.mSpanCount;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0088  */
    /* JADX WARN: Code duplicated, block: B:38:0x008a  */
    public View hasGapsToFix() {
        int i;
        int i2;
        boolean z2;
        int childCount = getChildCount() - 1;
        BitSet bitSet = new BitSet(this.mSpanCount);
        bitSet.set(0, this.mSpanCount, true);
        byte b2 = (this.mOrientation == 1 && isLayoutRTL()) ? (byte) 1 : (byte) -1;
        if (this.mShouldReverseLayout) {
            i = -1;
        } else {
            i = childCount + 1;
            childCount = 0;
        }
        int i3 = childCount < i ? 1 : -1;
        while (childCount != i) {
            View childAt = getChildAt(childCount);
            StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) childAt.getLayoutParams();
            if (bitSet.get(staggeredGridLayoutManager$LayoutParams.mSpan.mIndex)) {
                if (checkSpanForGap(staggeredGridLayoutManager$LayoutParams.mSpan)) {
                    return childAt;
                }
                bitSet.clear(staggeredGridLayoutManager$LayoutParams.mSpan.mIndex);
            }
            if (!staggeredGridLayoutManager$LayoutParams.mFullSpan && (i2 = childCount + i3) != i) {
                View childAt2 = getChildAt(i2);
                if (this.mShouldReverseLayout) {
                    int decoratedEnd = this.mPrimaryOrientation.getDecoratedEnd(childAt);
                    int decoratedEnd2 = this.mPrimaryOrientation.getDecoratedEnd(childAt2);
                    if (decoratedEnd < decoratedEnd2) {
                        return childAt;
                    }
                    if (decoratedEnd == decoratedEnd2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(childAt);
                    int decoratedStart2 = this.mPrimaryOrientation.getDecoratedStart(childAt2);
                    if (decoratedStart > decoratedStart2) {
                        return childAt;
                    }
                    if (decoratedStart == decoratedStart2) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                }
                if (z2) {
                    if ((staggeredGridLayoutManager$LayoutParams.mSpan.mIndex - ((StaggeredGridLayoutManager$LayoutParams) childAt2.getLayoutParams()).mSpan.mIndex < 0) != (b2 < 0)) {
                        return childAt;
                    }
                } else {
                    continue;
                }
            }
            childCount += i3;
        }
        return null;
    }

    public void invalidateSpanAssignments() {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean isAutoMeasureEnabled() {
        return this.mGapStrategy != 0;
    }

    public boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void offsetChildrenHorizontal(int i) {
        super.offsetChildrenHorizontal(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void offsetChildrenVertical(int i) {
        super.offsetChildrenVertical(i);
        for (int i2 = 0; i2 < this.mSpanCount; i2++) {
            this.mSpans[i2].onOffset(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onAdapterChanged(@Nullable RecyclerView$Adapter recyclerView$Adapter, @Nullable RecyclerView$Adapter recyclerView$Adapter2) {
        this.mLazySpanLookup.clear();
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        super.onDetachedFromWindow(recyclerView, recyclerView$Recycler);
        removeCallbacks(this.mCheckForGapsRunnable);
        for (int i = 0; i < this.mSpanCount; i++) {
            this.mSpans[i].clear();
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    @Nullable
    public View onFocusSearchFailed(View view, int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        View viewFindContainingItemView;
        View focusableViewAfter;
        if (getChildCount() == 0 || (viewFindContainingItemView = findContainingItemView(view)) == null) {
            return null;
        }
        resolveShouldLayoutReverse();
        int iConvertFocusDirectionToLayoutDirection = convertFocusDirectionToLayoutDirection(i);
        if (iConvertFocusDirectionToLayoutDirection == Integer.MIN_VALUE) {
            return null;
        }
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) viewFindContainingItemView.getLayoutParams();
        boolean z2 = staggeredGridLayoutManager$LayoutParams.mFullSpan;
        StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = staggeredGridLayoutManager$LayoutParams.mSpan;
        int lastChildPosition = iConvertFocusDirectionToLayoutDirection == 1 ? getLastChildPosition() : getFirstChildPosition();
        updateLayoutState(lastChildPosition, recyclerView$State);
        setLayoutStateDirection(iConvertFocusDirectionToLayoutDirection);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = layoutState.mItemDirection + lastChildPosition;
        layoutState.mAvailable = (int) (this.mPrimaryOrientation.getTotalSpace() * MAX_SCROLL_FACTOR);
        LayoutState layoutState2 = this.mLayoutState;
        layoutState2.mStopInFocusable = true;
        layoutState2.mRecycle = false;
        fill(recyclerView$Recycler, layoutState2, recyclerView$State);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        if (!z2 && (focusableViewAfter = staggeredGridLayoutManager$Span.getFocusableViewAfter(lastChildPosition, iConvertFocusDirectionToLayoutDirection)) != null && focusableViewAfter != viewFindContainingItemView) {
            return focusableViewAfter;
        }
        if (preferLastSpan(iConvertFocusDirectionToLayoutDirection)) {
            for (int i2 = this.mSpanCount - 1; i2 >= 0; i2--) {
                View focusableViewAfter2 = this.mSpans[i2].getFocusableViewAfter(lastChildPosition, iConvertFocusDirectionToLayoutDirection);
                if (focusableViewAfter2 != null && focusableViewAfter2 != viewFindContainingItemView) {
                    return focusableViewAfter2;
                }
            }
        } else {
            for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                View focusableViewAfter3 = this.mSpans[i3].getFocusableViewAfter(lastChildPosition, iConvertFocusDirectionToLayoutDirection);
                if (focusableViewAfter3 != null && focusableViewAfter3 != viewFindContainingItemView) {
                    return focusableViewAfter3;
                }
            }
        }
        boolean z3 = (this.mReverseLayout ^ true) == (iConvertFocusDirectionToLayoutDirection == -1);
        if (!z2) {
            View viewFindViewByPosition = findViewByPosition(z3 ? staggeredGridLayoutManager$Span.findFirstPartiallyVisibleItemPosition() : staggeredGridLayoutManager$Span.findLastPartiallyVisibleItemPosition());
            if (viewFindViewByPosition != null && viewFindViewByPosition != viewFindContainingItemView) {
                return viewFindViewByPosition;
            }
        }
        if (preferLastSpan(iConvertFocusDirectionToLayoutDirection)) {
            for (int i4 = this.mSpanCount - 1; i4 >= 0; i4--) {
                if (i4 != staggeredGridLayoutManager$Span.mIndex) {
                    View viewFindViewByPosition2 = findViewByPosition(z3 ? this.mSpans[i4].findFirstPartiallyVisibleItemPosition() : this.mSpans[i4].findLastPartiallyVisibleItemPosition());
                    if (viewFindViewByPosition2 != null && viewFindViewByPosition2 != viewFindContainingItemView) {
                        return viewFindViewByPosition2;
                    }
                }
            }
        } else {
            for (int i5 = 0; i5 < this.mSpanCount; i5++) {
                View viewFindViewByPosition3 = findViewByPosition(z3 ? this.mSpans[i5].findFirstPartiallyVisibleItemPosition() : this.mSpans[i5].findLastPartiallyVisibleItemPosition());
                if (viewFindViewByPosition3 != null && viewFindViewByPosition3 != viewFindContainingItemView) {
                    return viewFindViewByPosition3;
                }
            }
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        if (getChildCount() > 0) {
            View viewFindFirstVisibleItemClosestToStart = findFirstVisibleItemClosestToStart(false);
            View viewFindFirstVisibleItemClosestToEnd = findFirstVisibleItemClosestToEnd(false);
            if (viewFindFirstVisibleItemClosestToStart == null || viewFindFirstVisibleItemClosestToEnd == null) {
                return;
            }
            int position = getPosition(viewFindFirstVisibleItemClosestToStart);
            int position2 = getPosition(viewFindFirstVisibleItemClosestToEnd);
            if (position < position2) {
                accessibilityEvent.setFromIndex(position);
                accessibilityEvent.setToIndex(position2);
            } else {
                accessibilityEvent.setFromIndex(position2);
                accessibilityEvent.setToIndex(position);
            }
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsAdded(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 1);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsChanged(RecyclerView recyclerView) {
        this.mLazySpanLookup.clear();
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsMoved(RecyclerView recyclerView, int i, int i2, int i3) {
        handleUpdate(i, i2, 8);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsRemoved(RecyclerView recyclerView, int i, int i2) {
        handleUpdate(i, i2, 2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onItemsUpdated(RecyclerView recyclerView, int i, int i2, Object obj) {
        handleUpdate(i, i2, 4);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        onLayoutChildren(recyclerView$Recycler, recyclerView$State, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
        super.onLayoutCompleted(recyclerView$State);
        this.mPendingScrollPosition = -1;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        this.mPendingSavedState = null;
        this.mAnchorInfo.reset();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof StaggeredGridLayoutManager$SavedState) {
            StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = (StaggeredGridLayoutManager$SavedState) parcelable;
            this.mPendingSavedState = staggeredGridLayoutManager$SavedState;
            if (this.mPendingScrollPosition != -1) {
                staggeredGridLayoutManager$SavedState.invalidateAnchorPositionInfo();
                this.mPendingSavedState.invalidateSpanInfo();
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public Parcelable onSaveInstanceState() {
        int startLine;
        int startAfterPadding;
        int[] iArr;
        if (this.mPendingSavedState != null) {
            return new StaggeredGridLayoutManager$SavedState(this.mPendingSavedState);
        }
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = new StaggeredGridLayoutManager$SavedState();
        staggeredGridLayoutManager$SavedState.mReverseLayout = this.mReverseLayout;
        staggeredGridLayoutManager$SavedState.mAnchorLayoutFromEnd = this.mLastLayoutFromEnd;
        staggeredGridLayoutManager$SavedState.mLastLayoutRTL = this.mLastLayoutRTL;
        StaggeredGridLayoutManager$LazySpanLookup staggeredGridLayoutManager$LazySpanLookup = this.mLazySpanLookup;
        if (staggeredGridLayoutManager$LazySpanLookup == null || (iArr = staggeredGridLayoutManager$LazySpanLookup.mData) == null) {
            staggeredGridLayoutManager$SavedState.mSpanLookupSize = 0;
        } else {
            staggeredGridLayoutManager$SavedState.mSpanLookup = iArr;
            staggeredGridLayoutManager$SavedState.mSpanLookupSize = iArr.length;
            staggeredGridLayoutManager$SavedState.mFullSpanItems = staggeredGridLayoutManager$LazySpanLookup.mFullSpanItems;
        }
        if (getChildCount() > 0) {
            staggeredGridLayoutManager$SavedState.mAnchorPosition = this.mLastLayoutFromEnd ? getLastChildPosition() : getFirstChildPosition();
            staggeredGridLayoutManager$SavedState.mVisibleAnchorPosition = findFirstVisibleItemPositionInt();
            int i = this.mSpanCount;
            staggeredGridLayoutManager$SavedState.mSpanOffsetsSize = i;
            staggeredGridLayoutManager$SavedState.mSpanOffsets = new int[i];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                if (this.mLastLayoutFromEnd) {
                    startLine = this.mSpans[i2].getEndLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getEndAfterPadding();
                        startLine -= startAfterPadding;
                    }
                } else {
                    startLine = this.mSpans[i2].getStartLine(Integer.MIN_VALUE);
                    if (startLine != Integer.MIN_VALUE) {
                        startAfterPadding = this.mPrimaryOrientation.getStartAfterPadding();
                        startLine -= startAfterPadding;
                    }
                }
                staggeredGridLayoutManager$SavedState.mSpanOffsets[i2] = startLine;
            }
        } else {
            staggeredGridLayoutManager$SavedState.mAnchorPosition = -1;
            staggeredGridLayoutManager$SavedState.mVisibleAnchorPosition = -1;
            staggeredGridLayoutManager$SavedState.mSpanOffsetsSize = 0;
        }
        return staggeredGridLayoutManager$SavedState;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onScrollStateChanged(int i) {
        if (i == 0) {
            checkForGaps();
        }
    }

    public void prepareLayoutStateForDelta(int i, RecyclerView$State recyclerView$State) {
        int firstChildPosition;
        int i2;
        if (i > 0) {
            firstChildPosition = getLastChildPosition();
            i2 = 1;
        } else {
            firstChildPosition = getFirstChildPosition();
            i2 = -1;
        }
        this.mLayoutState.mRecycle = true;
        updateLayoutState(firstChildPosition, recyclerView$State);
        setLayoutStateDirection(i2);
        LayoutState layoutState = this.mLayoutState;
        layoutState.mCurrentPosition = firstChildPosition + layoutState.mItemDirection;
        layoutState.mAvailable = Math.abs(i);
    }

    public int scrollBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        if (getChildCount() == 0 || i == 0) {
            return 0;
        }
        prepareLayoutStateForDelta(i, recyclerView$State);
        int iFill = fill(recyclerView$Recycler, this.mLayoutState, recyclerView$State);
        if (this.mLayoutState.mAvailable >= iFill) {
            i = i < 0 ? -iFill : iFill;
        }
        this.mPrimaryOrientation.offsetChildren(-i);
        this.mLastLayoutFromEnd = this.mShouldReverseLayout;
        LayoutState layoutState = this.mLayoutState;
        layoutState.mAvailable = 0;
        recycle(recyclerView$Recycler, layoutState);
        return i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollHorizontallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return scrollBy(i, recyclerView$Recycler, recyclerView$State);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void scrollToPosition(int i) {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState != null && staggeredGridLayoutManager$SavedState.mAnchorPosition != i) {
            staggeredGridLayoutManager$SavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        requestLayout();
    }

    public void scrollToPositionWithOffset(int i, int i2) {
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState != null) {
            staggeredGridLayoutManager$SavedState.invalidateAnchorPositionInfo();
        }
        this.mPendingScrollPosition = i;
        this.mPendingScrollPositionOffset = i2;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public int scrollVerticallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return scrollBy(i, recyclerView$Recycler, recyclerView$State);
    }

    public void setGapStrategy(int i) {
        assertNotInLayoutOrScroll(null);
        if (i == this.mGapStrategy) {
            return;
        }
        if (i != 0 && i != 2) {
            throw new IllegalArgumentException("invalid gap strategy. Must be GAP_HANDLING_NONE or GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS");
        }
        this.mGapStrategy = i;
        requestLayout();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void setMeasuredDimension(Rect rect, int i, int i2) {
        int iChooseSize;
        int iChooseSize2;
        int paddingRight = getPaddingRight() + getPaddingLeft();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.mOrientation == 1) {
            iChooseSize2 = RecyclerView$LayoutManager.chooseSize(i2, rect.height() + paddingBottom, getMinimumHeight());
            iChooseSize = RecyclerView$LayoutManager.chooseSize(i, (this.mSizePerSpan * this.mSpanCount) + paddingRight, getMinimumWidth());
        } else {
            iChooseSize = RecyclerView$LayoutManager.chooseSize(i, rect.width() + paddingRight, getMinimumWidth());
            iChooseSize2 = RecyclerView$LayoutManager.chooseSize(i2, (this.mSizePerSpan * this.mSpanCount) + paddingBottom, getMinimumHeight());
        }
        setMeasuredDimension(iChooseSize, iChooseSize2);
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        assertNotInLayoutOrScroll(null);
        if (i == this.mOrientation) {
            return;
        }
        this.mOrientation = i;
        OrientationHelper orientationHelper = this.mPrimaryOrientation;
        this.mPrimaryOrientation = this.mSecondaryOrientation;
        this.mSecondaryOrientation = orientationHelper;
        requestLayout();
    }

    public void setReverseLayout(boolean z2) {
        assertNotInLayoutOrScroll(null);
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
        if (staggeredGridLayoutManager$SavedState != null && staggeredGridLayoutManager$SavedState.mReverseLayout != z2) {
            staggeredGridLayoutManager$SavedState.mReverseLayout = z2;
        }
        this.mReverseLayout = z2;
        requestLayout();
    }

    public void setSpanCount(int i) {
        assertNotInLayoutOrScroll(null);
        if (i != this.mSpanCount) {
            invalidateSpanAssignments();
            this.mSpanCount = i;
            this.mRemainingSpans = new BitSet(this.mSpanCount);
            this.mSpans = new StaggeredGridLayoutManager$Span[this.mSpanCount];
            for (int i2 = 0; i2 < this.mSpanCount; i2++) {
                this.mSpans[i2] = new StaggeredGridLayoutManager$Span(this, i2);
            }
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State recyclerView$State, int i) {
        LinearSmoothScroller linearSmoothScroller = new LinearSmoothScroller(recyclerView.getContext());
        linearSmoothScroller.setTargetPosition(i);
        startSmoothScroll(linearSmoothScroller);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return this.mPendingSavedState == null;
    }

    public boolean updateAnchorFromPendingData(RecyclerView$State recyclerView$State, StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        int i;
        if (!recyclerView$State.isPreLayout() && (i = this.mPendingScrollPosition) != -1) {
            if (i >= 0 && i < recyclerView$State.getItemCount()) {
                StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState = this.mPendingSavedState;
                if (staggeredGridLayoutManager$SavedState == null || staggeredGridLayoutManager$SavedState.mAnchorPosition == -1 || staggeredGridLayoutManager$SavedState.mSpanOffsetsSize < 1) {
                    View viewFindViewByPosition = findViewByPosition(this.mPendingScrollPosition);
                    if (viewFindViewByPosition != null) {
                        staggeredGridLayoutManager$AnchorInfo.mPosition = this.mShouldReverseLayout ? getLastChildPosition() : getFirstChildPosition();
                        if (this.mPendingScrollPositionOffset != Integer.MIN_VALUE) {
                            if (staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd) {
                                staggeredGridLayoutManager$AnchorInfo.mOffset = (this.mPrimaryOrientation.getEndAfterPadding() - this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                            } else {
                                staggeredGridLayoutManager$AnchorInfo.mOffset = (this.mPrimaryOrientation.getStartAfterPadding() + this.mPendingScrollPositionOffset) - this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition);
                            }
                            return true;
                        }
                        if (this.mPrimaryOrientation.getDecoratedMeasurement(viewFindViewByPosition) > this.mPrimaryOrientation.getTotalSpace()) {
                            staggeredGridLayoutManager$AnchorInfo.mOffset = staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd ? this.mPrimaryOrientation.getEndAfterPadding() : this.mPrimaryOrientation.getStartAfterPadding();
                            return true;
                        }
                        int decoratedStart = this.mPrimaryOrientation.getDecoratedStart(viewFindViewByPosition) - this.mPrimaryOrientation.getStartAfterPadding();
                        if (decoratedStart < 0) {
                            staggeredGridLayoutManager$AnchorInfo.mOffset = -decoratedStart;
                            return true;
                        }
                        int endAfterPadding = this.mPrimaryOrientation.getEndAfterPadding() - this.mPrimaryOrientation.getDecoratedEnd(viewFindViewByPosition);
                        if (endAfterPadding < 0) {
                            staggeredGridLayoutManager$AnchorInfo.mOffset = endAfterPadding;
                            return true;
                        }
                        staggeredGridLayoutManager$AnchorInfo.mOffset = Integer.MIN_VALUE;
                    } else {
                        int i2 = this.mPendingScrollPosition;
                        staggeredGridLayoutManager$AnchorInfo.mPosition = i2;
                        int i3 = this.mPendingScrollPositionOffset;
                        if (i3 == Integer.MIN_VALUE) {
                            staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd = calculateScrollDirectionForPosition(i2) == 1;
                            staggeredGridLayoutManager$AnchorInfo.assignCoordinateFromPadding();
                        } else {
                            staggeredGridLayoutManager$AnchorInfo.assignCoordinateFromPadding(i3);
                        }
                        staggeredGridLayoutManager$AnchorInfo.mInvalidateOffsets = true;
                    }
                } else {
                    staggeredGridLayoutManager$AnchorInfo.mOffset = Integer.MIN_VALUE;
                    staggeredGridLayoutManager$AnchorInfo.mPosition = this.mPendingScrollPosition;
                }
                return true;
            }
            this.mPendingScrollPosition = -1;
            this.mPendingScrollPositionOffset = Integer.MIN_VALUE;
        }
        return false;
    }

    public void updateAnchorInfoForLayout(RecyclerView$State recyclerView$State, StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo) {
        if (updateAnchorFromPendingData(recyclerView$State, staggeredGridLayoutManager$AnchorInfo) || updateAnchorFromChildren(recyclerView$State, staggeredGridLayoutManager$AnchorInfo)) {
            return;
        }
        staggeredGridLayoutManager$AnchorInfo.assignCoordinateFromPadding();
        staggeredGridLayoutManager$AnchorInfo.mPosition = 0;
    }

    public void updateMeasureSpecs(int i) {
        this.mSizePerSpan = i / this.mSpanCount;
        this.mFullSizeSpec = View$MeasureSpec.makeMeasureSpec(i, this.mSecondaryOrientation.getMode());
    }

    /* JADX WARN: Code duplicated, block: B:89:0x015a  */
    private void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State, boolean z2) {
        boolean z3;
        StaggeredGridLayoutManager$SavedState staggeredGridLayoutManager$SavedState;
        StaggeredGridLayoutManager$AnchorInfo staggeredGridLayoutManager$AnchorInfo = this.mAnchorInfo;
        if (!(this.mPendingSavedState == null && this.mPendingScrollPosition == -1) && recyclerView$State.getItemCount() == 0) {
            removeAndRecycleAllViews(recyclerView$Recycler);
            staggeredGridLayoutManager$AnchorInfo.reset();
            return;
        }
        boolean z4 = (staggeredGridLayoutManager$AnchorInfo.mValid && this.mPendingScrollPosition == -1 && this.mPendingSavedState == null) ? false : true;
        if (z4) {
            staggeredGridLayoutManager$AnchorInfo.reset();
            if (this.mPendingSavedState != null) {
                applyPendingSavedState(staggeredGridLayoutManager$AnchorInfo);
            } else {
                resolveShouldLayoutReverse();
                staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd = this.mShouldReverseLayout;
            }
            updateAnchorInfoForLayout(recyclerView$State, staggeredGridLayoutManager$AnchorInfo);
            staggeredGridLayoutManager$AnchorInfo.mValid = true;
        }
        if (this.mPendingSavedState == null && this.mPendingScrollPosition == -1 && (staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd != this.mLastLayoutFromEnd || isLayoutRTL() != this.mLastLayoutRTL)) {
            this.mLazySpanLookup.clear();
            staggeredGridLayoutManager$AnchorInfo.mInvalidateOffsets = true;
        }
        if (getChildCount() > 0 && ((staggeredGridLayoutManager$SavedState = this.mPendingSavedState) == null || staggeredGridLayoutManager$SavedState.mSpanOffsetsSize < 1)) {
            if (staggeredGridLayoutManager$AnchorInfo.mInvalidateOffsets) {
                for (int i = 0; i < this.mSpanCount; i++) {
                    this.mSpans[i].clear();
                    int i2 = staggeredGridLayoutManager$AnchorInfo.mOffset;
                    if (i2 != Integer.MIN_VALUE) {
                        this.mSpans[i].setLine(i2);
                    }
                }
            } else if (z4 || this.mAnchorInfo.mSpanReferenceLines == null) {
                for (int i3 = 0; i3 < this.mSpanCount; i3++) {
                    this.mSpans[i3].cacheReferenceLineAndClear(this.mShouldReverseLayout, staggeredGridLayoutManager$AnchorInfo.mOffset);
                }
                this.mAnchorInfo.saveSpanReferenceLines(this.mSpans);
            } else {
                for (int i4 = 0; i4 < this.mSpanCount; i4++) {
                    StaggeredGridLayoutManager$Span staggeredGridLayoutManager$Span = this.mSpans[i4];
                    staggeredGridLayoutManager$Span.clear();
                    staggeredGridLayoutManager$Span.setLine(this.mAnchorInfo.mSpanReferenceLines[i4]);
                }
            }
        }
        detachAndScrapAttachedViews(recyclerView$Recycler);
        this.mLayoutState.mRecycle = false;
        this.mLaidOutInvalidFullSpan = false;
        updateMeasureSpecs(this.mSecondaryOrientation.getTotalSpace());
        updateLayoutState(staggeredGridLayoutManager$AnchorInfo.mPosition, recyclerView$State);
        if (staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd) {
            setLayoutStateDirection(-1);
            fill(recyclerView$Recycler, this.mLayoutState, recyclerView$State);
            setLayoutStateDirection(1);
            LayoutState layoutState = this.mLayoutState;
            layoutState.mCurrentPosition = staggeredGridLayoutManager$AnchorInfo.mPosition + layoutState.mItemDirection;
            fill(recyclerView$Recycler, layoutState, recyclerView$State);
        } else {
            setLayoutStateDirection(1);
            fill(recyclerView$Recycler, this.mLayoutState, recyclerView$State);
            setLayoutStateDirection(-1);
            LayoutState layoutState2 = this.mLayoutState;
            layoutState2.mCurrentPosition = staggeredGridLayoutManager$AnchorInfo.mPosition + layoutState2.mItemDirection;
            fill(recyclerView$Recycler, layoutState2, recyclerView$State);
        }
        repositionToWrapContentIfNecessary();
        if (getChildCount() > 0) {
            if (this.mShouldReverseLayout) {
                fixEndGap(recyclerView$Recycler, recyclerView$State, true);
                fixStartGap(recyclerView$Recycler, recyclerView$State, false);
            } else {
                fixStartGap(recyclerView$Recycler, recyclerView$State, true);
                fixEndGap(recyclerView$Recycler, recyclerView$State, false);
            }
        }
        if (z2 && !recyclerView$State.isPreLayout()) {
            if (this.mGapStrategy != 0 && getChildCount() > 0 && (this.mLaidOutInvalidFullSpan || hasGapsToFix() != null)) {
                removeCallbacks(this.mCheckForGapsRunnable);
                z3 = checkForGaps();
            }
        }
        if (recyclerView$State.isPreLayout()) {
            this.mAnchorInfo.reset();
        }
        this.mLastLayoutFromEnd = staggeredGridLayoutManager$AnchorInfo.mLayoutFromEnd;
        this.mLastLayoutRTL = isLayoutRTL();
        if (z3) {
            this.mAnchorInfo.reset();
            onLayoutChildren(recyclerView$Recycler, recyclerView$State, false);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$LayoutManager
    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        return viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams ? new StaggeredGridLayoutManager$LayoutParams((ViewGroup$MarginLayoutParams) viewGroup$LayoutParams) : new StaggeredGridLayoutManager$LayoutParams(viewGroup$LayoutParams);
    }

    public StaggeredGridLayoutManager(int i, int i2) {
        this.mOrientation = i2;
        setSpanCount(i);
        this.mLayoutState = new LayoutState();
        createOrientationHelpers();
    }

    private void measureChildWithDecorationsAndMargin(View view, int i, int i2, boolean z2) {
        boolean zShouldMeasureChild;
        calculateItemDecorationsForChild(view, this.mTmpRect);
        StaggeredGridLayoutManager$LayoutParams staggeredGridLayoutManager$LayoutParams = (StaggeredGridLayoutManager$LayoutParams) view.getLayoutParams();
        int i3 = ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).leftMargin;
        Rect rect = this.mTmpRect;
        int iUpdateSpecWithExtra = updateSpecWithExtra(i, i3 + rect.left, ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).rightMargin + rect.right);
        int i4 = ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).topMargin;
        Rect rect2 = this.mTmpRect;
        int iUpdateSpecWithExtra2 = updateSpecWithExtra(i2, i4 + rect2.top, ((ViewGroup$MarginLayoutParams) staggeredGridLayoutManager$LayoutParams).bottomMargin + rect2.bottom);
        if (z2) {
            zShouldMeasureChild = shouldReMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, staggeredGridLayoutManager$LayoutParams);
        } else {
            zShouldMeasureChild = shouldMeasureChild(view, iUpdateSpecWithExtra, iUpdateSpecWithExtra2, staggeredGridLayoutManager$LayoutParams);
        }
        if (zShouldMeasureChild) {
            view.measure(iUpdateSpecWithExtra, iUpdateSpecWithExtra2);
        }
    }
}
