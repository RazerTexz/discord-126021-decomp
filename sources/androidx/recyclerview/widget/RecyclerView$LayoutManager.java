package androidx.recyclerview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.constraintlayout.solver.widgets.analyzer.BasicMeasure;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.recyclerview.R$styleable;
import b.d.b.a.a;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public abstract class RecyclerView$LayoutManager {
    public boolean mAutoMeasure;
    public ChildHelper mChildHelper;
    private int mHeight;
    private int mHeightMode;
    public ViewBoundsCheck mHorizontalBoundCheck;
    private final ViewBoundsCheck$Callback mHorizontalBoundCheckCallback;
    public boolean mIsAttachedToWindow;
    private boolean mItemPrefetchEnabled;
    private boolean mMeasurementCacheEnabled;
    public int mPrefetchMaxCountObserved;
    public boolean mPrefetchMaxObservedInInitialPrefetch;
    public RecyclerView mRecyclerView;
    public boolean mRequestedSimpleAnimations;

    @Nullable
    public RecyclerView$SmoothScroller mSmoothScroller;
    public ViewBoundsCheck mVerticalBoundCheck;
    private final ViewBoundsCheck$Callback mVerticalBoundCheckCallback;
    private int mWidth;
    private int mWidthMode;

    public RecyclerView$LayoutManager() {
        RecyclerView$LayoutManager$1 recyclerView$LayoutManager$1 = new RecyclerView$LayoutManager$1(this);
        this.mHorizontalBoundCheckCallback = recyclerView$LayoutManager$1;
        RecyclerView$LayoutManager$2 recyclerView$LayoutManager$2 = new RecyclerView$LayoutManager$2(this);
        this.mVerticalBoundCheckCallback = recyclerView$LayoutManager$2;
        this.mHorizontalBoundCheck = new ViewBoundsCheck(recyclerView$LayoutManager$1);
        this.mVerticalBoundCheck = new ViewBoundsCheck(recyclerView$LayoutManager$2);
        this.mRequestedSimpleAnimations = false;
        this.mIsAttachedToWindow = false;
        this.mAutoMeasure = false;
        this.mMeasurementCacheEnabled = true;
        this.mItemPrefetchEnabled = true;
    }

    private void addViewInt(View view, int i, boolean z2) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (z2 || childViewHolderInt.isRemoved()) {
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
        } else {
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
        }
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        if (childViewHolderInt.wasReturnedFromScrap() || childViewHolderInt.isScrap()) {
            if (childViewHolderInt.isScrap()) {
                childViewHolderInt.unScrap();
            } else {
                childViewHolderInt.clearReturnedFromScrapFlag();
            }
            this.mChildHelper.attachViewToParent(view, i, view.getLayoutParams(), false);
        } else if (view.getParent() == this.mRecyclerView) {
            int iIndexOfChild = this.mChildHelper.indexOfChild(view);
            if (i == -1) {
                i = this.mChildHelper.getChildCount();
            }
            if (iIndexOfChild == -1) {
                StringBuilder sbU = a.U("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                sbU.append(this.mRecyclerView.indexOfChild(view));
                throw new IllegalStateException(a.n(this.mRecyclerView, sbU));
            }
            if (iIndexOfChild != i) {
                this.mRecyclerView.mLayout.moveView(iIndexOfChild, i);
            }
        } else {
            this.mChildHelper.addView(view, i, false);
            recyclerView$LayoutParams.mInsetsDirty = true;
            RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.mSmoothScroller;
            if (recyclerView$SmoothScroller != null && recyclerView$SmoothScroller.isRunning()) {
                this.mSmoothScroller.onChildAttachedToWindow(view);
            }
        }
        if (recyclerView$LayoutParams.mPendingInvalidate) {
            childViewHolderInt.itemView.invalidate();
            recyclerView$LayoutParams.mPendingInvalidate = false;
        }
    }

    public static int chooseSize(int i, int i2, int i3) {
        int mode = View$MeasureSpec.getMode(i);
        int size = View$MeasureSpec.getSize(i);
        if (mode != Integer.MIN_VALUE) {
            return mode != 1073741824 ? Math.max(i2, i3) : size;
        }
        return Math.min(size, Math.max(i2, i3));
    }

    private void detachViewInternal(int i, @NonNull View view) {
        this.mChildHelper.detachViewFromParent(i);
    }

    /* JADX WARN: Code duplicated, block: B:6:0x000d  */
    /* JADX WARN: Code duplicated, block: B:8:0x0011  */
    @Deprecated
    public static int getChildMeasureSpec(int i, int i2, int i3, boolean z2) {
        int i4 = i - i2;
        int i5 = 0;
        int iMax = Math.max(0, i4);
        if (z2) {
            if (i3 >= 0) {
                i5 = BasicMeasure.EXACTLY;
            } else {
                i3 = 0;
            }
        } else if (i3 >= 0) {
            i5 = BasicMeasure.EXACTLY;
        } else {
            if (i3 == -1) {
                i5 = BasicMeasure.EXACTLY;
            } else if (i3 == -2) {
                i5 = Integer.MIN_VALUE;
            } else {
                i3 = 0;
            }
            i3 = iMax;
        }
        return View$MeasureSpec.makeMeasureSpec(i3, i5);
    }

    private int[] getChildRectangleOnScreenScrollAmount(View view, Rect rect) {
        int[] iArr = new int[2];
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        int left = (view.getLeft() + rect.left) - view.getScrollX();
        int top = (view.getTop() + rect.top) - view.getScrollY();
        int iWidth = rect.width() + left;
        int iHeight = rect.height() + top;
        int i = left - paddingLeft;
        int iMin = Math.min(0, i);
        int i2 = top - paddingTop;
        int iMin2 = Math.min(0, i2);
        int i3 = iWidth - width;
        int iMax = Math.max(0, i3);
        int iMax2 = Math.max(0, iHeight - height);
        if (getLayoutDirection() != 1) {
            if (iMin == 0) {
                iMin = Math.min(i, iMax);
            }
            iMax = iMin;
        } else if (iMax == 0) {
            iMax = Math.max(iMin, i3);
        }
        if (iMin2 == 0) {
            iMin2 = Math.min(i2, iMax2);
        }
        iArr[0] = iMax;
        iArr[1] = iMin2;
        return iArr;
    }

    public static RecyclerView$LayoutManager$Properties getProperties(@NonNull Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        RecyclerView$LayoutManager$Properties recyclerView$LayoutManager$Properties = new RecyclerView$LayoutManager$Properties();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.RecyclerView, i, i2);
        recyclerView$LayoutManager$Properties.orientation = typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_android_orientation, 1);
        recyclerView$LayoutManager$Properties.spanCount = typedArrayObtainStyledAttributes.getInt(R$styleable.RecyclerView_spanCount, 1);
        recyclerView$LayoutManager$Properties.reverseLayout = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_reverseLayout, false);
        recyclerView$LayoutManager$Properties.stackFromEnd = typedArrayObtainStyledAttributes.getBoolean(R$styleable.RecyclerView_stackFromEnd, false);
        typedArrayObtainStyledAttributes.recycle();
        return recyclerView$LayoutManager$Properties;
    }

    private boolean isFocusedChildVisibleAfterScrolling(RecyclerView recyclerView, int i, int i2) {
        View focusedChild = recyclerView.getFocusedChild();
        if (focusedChild == null) {
            return false;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int width = getWidth() - getPaddingRight();
        int height = getHeight() - getPaddingBottom();
        Rect rect = this.mRecyclerView.mTempRect;
        getDecoratedBoundsWithMargins(focusedChild, rect);
        return rect.left - i < width && rect.right - i > paddingLeft && rect.top - i2 < height && rect.bottom - i2 > paddingTop;
    }

    private static boolean isMeasurementUpToDate(int i, int i2, int i3) {
        int mode = View$MeasureSpec.getMode(i2);
        int size = View$MeasureSpec.getSize(i2);
        if (i3 > 0 && i != i3) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    private void scrapOrRecycleView(RecyclerView$Recycler recyclerView$Recycler, int i, View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.shouldIgnore()) {
            return;
        }
        if (childViewHolderInt.isInvalid() && !childViewHolderInt.isRemoved() && !this.mRecyclerView.mAdapter.hasStableIds()) {
            removeViewAt(i);
            recyclerView$Recycler.recycleViewHolderInternal(childViewHolderInt);
        } else {
            detachViewAt(i);
            recyclerView$Recycler.scrapView(view);
            this.mRecyclerView.mViewInfoStore.onViewDetached(childViewHolderInt);
        }
    }

    public void addDisappearingView(View view) {
        addDisappearingView(view, -1);
    }

    public void addView(View view) {
        addView(view, -1);
    }

    public void assertInLayoutOrScroll(String str) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertInLayoutOrScroll(str);
        }
    }

    public void assertNotInLayoutOrScroll(String str) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.assertNotInLayoutOrScroll(str);
        }
    }

    public void attachView(@NonNull View view, int i, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt.isRemoved()) {
            this.mRecyclerView.mViewInfoStore.addToDisappearedInLayout(childViewHolderInt);
        } else {
            this.mRecyclerView.mViewInfoStore.removeFromDisappearedInLayout(childViewHolderInt);
        }
        this.mChildHelper.attachViewToParent(view, i, recyclerView$LayoutParams, childViewHolderInt.isRemoved());
    }

    public void calculateItemDecorationsForChild(@NonNull View view, @NonNull Rect rect) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.getItemDecorInsetsForChild(view));
        }
    }

    public boolean canScrollHorizontally() {
        return false;
    }

    public boolean canScrollVertically() {
        return false;
    }

    public boolean checkLayoutParams(RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return recyclerView$LayoutParams != null;
    }

    public void collectAdjacentPrefetchPositions(int i, int i2, RecyclerView$State recyclerView$State, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
    }

    public void collectInitialPrefetchPositions(int i, RecyclerView$LayoutManager$LayoutPrefetchRegistry recyclerView$LayoutManager$LayoutPrefetchRegistry) {
    }

    public int computeHorizontalScrollExtent(@NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeHorizontalScrollOffset(@NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeHorizontalScrollRange(@NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeVerticalScrollExtent(@NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeVerticalScrollOffset(@NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int computeVerticalScrollRange(@NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public void detachAndScrapAttachedViews(@NonNull RecyclerView$Recycler recyclerView$Recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            scrapOrRecycleView(recyclerView$Recycler, childCount, getChildAt(childCount));
        }
    }

    public void detachAndScrapView(@NonNull View view, @NonNull RecyclerView$Recycler recyclerView$Recycler) {
        scrapOrRecycleView(recyclerView$Recycler, this.mChildHelper.indexOfChild(view), view);
    }

    public void detachAndScrapViewAt(int i, @NonNull RecyclerView$Recycler recyclerView$Recycler) {
        scrapOrRecycleView(recyclerView$Recycler, i, getChildAt(i));
    }

    public void detachView(@NonNull View view) {
        int iIndexOfChild = this.mChildHelper.indexOfChild(view);
        if (iIndexOfChild >= 0) {
            detachViewInternal(iIndexOfChild, view);
        }
    }

    public void detachViewAt(int i) {
        detachViewInternal(i, getChildAt(i));
    }

    public void dispatchAttachedToWindow(RecyclerView recyclerView) {
        this.mIsAttachedToWindow = true;
        onAttachedToWindow(recyclerView);
    }

    public void dispatchDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        this.mIsAttachedToWindow = false;
        onDetachedFromWindow(recyclerView, recyclerView$Recycler);
    }

    public void endAnimation(View view) {
        RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mRecyclerView.mItemAnimator;
        if (recyclerView$ItemAnimator != null) {
            recyclerView$ItemAnimator.endAnimation(RecyclerView.getChildViewHolderInt(view));
        }
    }

    @Nullable
    public View findContainingItemView(@NonNull View view) {
        View viewFindContainingItemView;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (viewFindContainingItemView = recyclerView.findContainingItemView(view)) == null || this.mChildHelper.isHidden(viewFindContainingItemView)) {
            return null;
        }
        return viewFindContainingItemView;
    }

    @Nullable
    public View findViewByPosition(int i) {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(childAt);
            if (childViewHolderInt != null && childViewHolderInt.getLayoutPosition() == i && !childViewHolderInt.shouldIgnore() && (this.mRecyclerView.mState.isPreLayout() || !childViewHolderInt.isRemoved())) {
                return childAt;
            }
        }
        return null;
    }

    public abstract RecyclerView$LayoutParams generateDefaultLayoutParams();

    public RecyclerView$LayoutParams generateLayoutParams(ViewGroup$LayoutParams viewGroup$LayoutParams) {
        if (viewGroup$LayoutParams instanceof RecyclerView$LayoutParams) {
            return new RecyclerView$LayoutParams((RecyclerView$LayoutParams) viewGroup$LayoutParams);
        }
        return viewGroup$LayoutParams instanceof ViewGroup$MarginLayoutParams ? new RecyclerView$LayoutParams((ViewGroup$MarginLayoutParams) viewGroup$LayoutParams) : new RecyclerView$LayoutParams(viewGroup$LayoutParams);
    }

    public int getBaseline() {
        return -1;
    }

    public int getBottomDecorationHeight(@NonNull View view) {
        return ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets.bottom;
    }

    @Nullable
    public View getChildAt(int i) {
        ChildHelper childHelper = this.mChildHelper;
        if (childHelper != null) {
            return childHelper.getChildAt(i);
        }
        return null;
    }

    public int getChildCount() {
        ChildHelper childHelper = this.mChildHelper;
        if (childHelper != null) {
            return childHelper.getChildCount();
        }
        return 0;
    }

    public boolean getClipToPadding() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.mClipToPadding;
    }

    public int getColumnCountForAccessibility(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State) {
        return -1;
    }

    public int getDecoratedBottom(@NonNull View view) {
        return getBottomDecorationHeight(view) + view.getBottom();
    }

    public void getDecoratedBoundsWithMargins(@NonNull View view, @NonNull Rect rect) {
        RecyclerView.getDecoratedBoundsWithMarginsInt(view, rect);
    }

    public int getDecoratedLeft(@NonNull View view) {
        return view.getLeft() - getLeftDecorationWidth(view);
    }

    public int getDecoratedMeasuredHeight(@NonNull View view) {
        Rect rect = ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public int getDecoratedMeasuredWidth(@NonNull View view) {
        Rect rect = ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public int getDecoratedRight(@NonNull View view) {
        return getRightDecorationWidth(view) + view.getRight();
    }

    public int getDecoratedTop(@NonNull View view) {
        return view.getTop() - getTopDecorationHeight(view);
    }

    @Nullable
    public View getFocusedChild() {
        View focusedChild;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.mChildHelper.isHidden(focusedChild)) {
            return null;
        }
        return focusedChild;
    }

    @Px
    public int getHeight() {
        return this.mHeight;
    }

    public int getHeightMode() {
        return this.mHeightMode;
    }

    public int getItemCount() {
        RecyclerView recyclerView = this.mRecyclerView;
        RecyclerView$Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.getItemCount();
        }
        return 0;
    }

    public int getItemViewType(@NonNull View view) {
        return RecyclerView.getChildViewHolderInt(view).getItemViewType();
    }

    public int getLayoutDirection() {
        return ViewCompat.getLayoutDirection(this.mRecyclerView);
    }

    public int getLeftDecorationWidth(@NonNull View view) {
        return ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets.left;
    }

    @Px
    public int getMinimumHeight() {
        return ViewCompat.getMinimumHeight(this.mRecyclerView);
    }

    @Px
    public int getMinimumWidth() {
        return ViewCompat.getMinimumWidth(this.mRecyclerView);
    }

    @Px
    public int getPaddingBottom() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    @Px
    public int getPaddingEnd() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return ViewCompat.getPaddingEnd(recyclerView);
        }
        return 0;
    }

    @Px
    public int getPaddingLeft() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    @Px
    public int getPaddingRight() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    @Px
    public int getPaddingStart() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return ViewCompat.getPaddingStart(recyclerView);
        }
        return 0;
    }

    @Px
    public int getPaddingTop() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int getPosition(@NonNull View view) {
        return ((RecyclerView$LayoutParams) view.getLayoutParams()).getViewLayoutPosition();
    }

    public int getRightDecorationWidth(@NonNull View view) {
        return ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets.right;
    }

    public int getRowCountForAccessibility(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State) {
        return -1;
    }

    public int getSelectionModeForAccessibility(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State) {
        return 0;
    }

    public int getTopDecorationHeight(@NonNull View view) {
        return ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets.top;
    }

    public void getTransformedBoundingBox(@NonNull View view, boolean z2, @NonNull Rect rect) {
        Matrix matrix;
        if (z2) {
            Rect rect2 = ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets;
            rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        } else {
            rect.set(0, 0, view.getWidth(), view.getHeight());
        }
        if (this.mRecyclerView != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.mRecyclerView.mTempRectF;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    @Px
    public int getWidth() {
        return this.mWidth;
    }

    public int getWidthMode() {
        return this.mWidthMode;
    }

    public boolean hasFlexibleChildInBothOrientations() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ViewGroup$LayoutParams layoutParams = getChildAt(i).getLayoutParams();
            if (layoutParams.width < 0 && layoutParams.height < 0) {
                return true;
            }
        }
        return false;
    }

    public boolean hasFocus() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.hasFocus();
    }

    public void ignoreView(@NonNull View view) {
        ViewParent parent = view.getParent();
        RecyclerView recyclerView = this.mRecyclerView;
        if (parent != recyclerView || recyclerView.indexOfChild(view) == -1) {
            throw new IllegalArgumentException(a.n(this.mRecyclerView, a.U("View should be fully attached to be ignored")));
        }
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.addFlags(128);
        this.mRecyclerView.mViewInfoStore.removeViewHolder(childViewHolderInt);
    }

    public boolean isAttachedToWindow() {
        return this.mIsAttachedToWindow;
    }

    public boolean isAutoMeasureEnabled() {
        return this.mAutoMeasure;
    }

    public boolean isFocused() {
        RecyclerView recyclerView = this.mRecyclerView;
        return recyclerView != null && recyclerView.isFocused();
    }

    public final boolean isItemPrefetchEnabled() {
        return this.mItemPrefetchEnabled;
    }

    public boolean isLayoutHierarchical(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State) {
        return false;
    }

    public boolean isMeasurementCacheEnabled() {
        return this.mMeasurementCacheEnabled;
    }

    public boolean isSmoothScrolling() {
        RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.mSmoothScroller;
        return recyclerView$SmoothScroller != null && recyclerView$SmoothScroller.isRunning();
    }

    public boolean isViewPartiallyVisible(@NonNull View view, boolean z2, boolean z3) {
        boolean z4 = this.mHorizontalBoundCheck.isViewWithinBoundFlags(view, 24579) && this.mVerticalBoundCheck.isViewWithinBoundFlags(view, 24579);
        return z2 ? z4 : !z4;
    }

    public void layoutDecorated(@NonNull View view, int i, int i2, int i3, int i4) {
        Rect rect = ((RecyclerView$LayoutParams) view.getLayoutParams()).mDecorInsets;
        view.layout(i + rect.left, i2 + rect.top, i3 - rect.right, i4 - rect.bottom);
    }

    public void layoutDecoratedWithMargins(@NonNull View view, int i, int i2, int i3, int i4) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        Rect rect = recyclerView$LayoutParams.mDecorInsets;
        view.layout(i + rect.left + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).leftMargin, i2 + rect.top + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).topMargin, (i3 - rect.right) - ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).rightMargin, (i4 - rect.bottom) - ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).bottomMargin);
    }

    public void measureChild(@NonNull View view, int i, int i2) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
        int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + i3, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).width, canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + i4, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).height, canScrollVertically());
        if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, recyclerView$LayoutParams)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void measureChildWithMargins(@NonNull View view, int i, int i2) {
        RecyclerView$LayoutParams recyclerView$LayoutParams = (RecyclerView$LayoutParams) view.getLayoutParams();
        Rect itemDecorInsetsForChild = this.mRecyclerView.getItemDecorInsetsForChild(view);
        int i3 = itemDecorInsetsForChild.left + itemDecorInsetsForChild.right + i;
        int i4 = itemDecorInsetsForChild.top + itemDecorInsetsForChild.bottom + i2;
        int childMeasureSpec = getChildMeasureSpec(getWidth(), getWidthMode(), getPaddingRight() + getPaddingLeft() + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).leftMargin + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).rightMargin + i3, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).width, canScrollHorizontally());
        int childMeasureSpec2 = getChildMeasureSpec(getHeight(), getHeightMode(), getPaddingBottom() + getPaddingTop() + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).topMargin + ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).bottomMargin + i4, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).height, canScrollVertically());
        if (shouldMeasureChild(view, childMeasureSpec, childMeasureSpec2, recyclerView$LayoutParams)) {
            view.measure(childMeasureSpec, childMeasureSpec2);
        }
    }

    public void moveView(int i, int i2) {
        View childAt = getChildAt(i);
        if (childAt != null) {
            detachViewAt(i);
            attachView(childAt, i2);
        } else {
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i + this.mRecyclerView.toString());
        }
    }

    public void offsetChildrenHorizontal(@Px int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenHorizontal(i);
        }
    }

    public void offsetChildrenVertical(@Px int i) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.offsetChildrenVertical(i);
        }
    }

    public void onAdapterChanged(@Nullable RecyclerView$Adapter recyclerView$Adapter, @Nullable RecyclerView$Adapter recyclerView$Adapter2) {
    }

    public boolean onAddFocusables(@NonNull RecyclerView recyclerView, @NonNull ArrayList<View> arrayList, int i, int i2) {
        return false;
    }

    @CallSuper
    public void onAttachedToWindow(RecyclerView recyclerView) {
    }

    @Deprecated
    public void onDetachedFromWindow(RecyclerView recyclerView) {
    }

    @CallSuper
    public void onDetachedFromWindow(RecyclerView recyclerView, RecyclerView$Recycler recyclerView$Recycler) {
        onDetachedFromWindow(recyclerView);
    }

    @Nullable
    public View onFocusSearchFailed(@NonNull View view, int i, @NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State) {
        return null;
    }

    public void onInitializeAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityEvent(recyclerView.mRecycler, recyclerView.mState, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityNodeInfo(recyclerView.mRecycler, recyclerView.mState, accessibilityNodeInfoCompat);
    }

    public void onInitializeAccessibilityNodeInfoForItem(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        if (childViewHolderInt == null || childViewHolderInt.isRemoved() || this.mChildHelper.isHidden(childViewHolderInt.itemView)) {
            return;
        }
        RecyclerView recyclerView = this.mRecyclerView;
        onInitializeAccessibilityNodeInfoForItem(recyclerView.mRecycler, recyclerView.mState, view, accessibilityNodeInfoCompat);
    }

    public void onInitializeAccessibilityNodeInfoForItem(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, @NonNull View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
    }

    @Nullable
    public View onInterceptFocusSearch(@NonNull View view, int i) {
        return null;
    }

    public void onItemsAdded(@NonNull RecyclerView recyclerView, int i, int i2) {
    }

    public void onItemsChanged(@NonNull RecyclerView recyclerView) {
    }

    public void onItemsMoved(@NonNull RecyclerView recyclerView, int i, int i2, int i3) {
    }

    public void onItemsRemoved(@NonNull RecyclerView recyclerView, int i, int i2) {
    }

    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2) {
    }

    public void onItemsUpdated(@NonNull RecyclerView recyclerView, int i, int i2, @Nullable Object obj) {
        onItemsUpdated(recyclerView, i, i2);
    }

    public void onLayoutChildren(RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        Log.e(RecyclerView.TAG, "You must override onLayoutChildren(Recycler recycler, State state) ");
    }

    public void onLayoutCompleted(RecyclerView$State recyclerView$State) {
    }

    public void onMeasure(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, int i, int i2) {
        this.mRecyclerView.defaultOnMeasure(i, i2);
    }

    @Deprecated
    public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull View view, @Nullable View view2) {
        return isSmoothScrolling() || recyclerView.isComputingLayout();
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
    }

    @Nullable
    public Parcelable onSaveInstanceState() {
        return null;
    }

    public void onScrollStateChanged(int i) {
    }

    public void onSmoothScrollerStopped(RecyclerView$SmoothScroller recyclerView$SmoothScroller) {
        if (this.mSmoothScroller == recyclerView$SmoothScroller) {
            this.mSmoothScroller = null;
        }
    }

    public boolean performAccessibilityAction(int i, @Nullable Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        return performAccessibilityAction(recyclerView.mRecycler, recyclerView.mState, i, bundle);
    }

    public boolean performAccessibilityActionForItem(@NonNull View view, int i, @Nullable Bundle bundle) {
        RecyclerView recyclerView = this.mRecyclerView;
        return performAccessibilityActionForItem(recyclerView.mRecycler, recyclerView.mState, view, i, bundle);
    }

    public boolean performAccessibilityActionForItem(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, @NonNull View view, int i, @Nullable Bundle bundle) {
        return false;
    }

    public void postOnAnimation(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            ViewCompat.postOnAnimation(recyclerView, runnable);
        }
    }

    public void removeAllViews() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            this.mChildHelper.removeViewAt(childCount);
        }
    }

    public void removeAndRecycleAllViews(@NonNull RecyclerView$Recycler recyclerView$Recycler) {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (!RecyclerView.getChildViewHolderInt(getChildAt(childCount)).shouldIgnore()) {
                removeAndRecycleViewAt(childCount, recyclerView$Recycler);
            }
        }
    }

    public void removeAndRecycleScrapInt(RecyclerView$Recycler recyclerView$Recycler) {
        int scrapCount = recyclerView$Recycler.getScrapCount();
        for (int i = scrapCount - 1; i >= 0; i--) {
            View scrapViewAt = recyclerView$Recycler.getScrapViewAt(i);
            RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(scrapViewAt);
            if (!childViewHolderInt.shouldIgnore()) {
                childViewHolderInt.setIsRecyclable(false);
                if (childViewHolderInt.isTmpDetached()) {
                    this.mRecyclerView.removeDetachedView(scrapViewAt, false);
                }
                RecyclerView$ItemAnimator recyclerView$ItemAnimator = this.mRecyclerView.mItemAnimator;
                if (recyclerView$ItemAnimator != null) {
                    recyclerView$ItemAnimator.endAnimation(childViewHolderInt);
                }
                childViewHolderInt.setIsRecyclable(true);
                recyclerView$Recycler.quickRecycleScrapView(scrapViewAt);
            }
        }
        recyclerView$Recycler.clearScrap();
        if (scrapCount > 0) {
            this.mRecyclerView.invalidate();
        }
    }

    public void removeAndRecycleView(@NonNull View view, @NonNull RecyclerView$Recycler recyclerView$Recycler) {
        removeView(view);
        recyclerView$Recycler.recycleView(view);
    }

    public void removeAndRecycleViewAt(int i, @NonNull RecyclerView$Recycler recyclerView$Recycler) {
        View childAt = getChildAt(i);
        removeViewAt(i);
        recyclerView$Recycler.recycleView(childAt);
    }

    public boolean removeCallbacks(Runnable runnable) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            return recyclerView.removeCallbacks(runnable);
        }
        return false;
    }

    public void removeDetachedView(@NonNull View view) {
        this.mRecyclerView.removeDetachedView(view, false);
    }

    public void removeView(View view) {
        this.mChildHelper.removeView(view);
    }

    public void removeViewAt(int i) {
        if (getChildAt(i) != null) {
            this.mChildHelper.removeViewAt(i);
        }
    }

    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2) {
        return requestChildRectangleOnScreen(recyclerView, view, rect, z2, false);
    }

    public void requestLayout() {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public void requestSimpleAnimationsInNextLayout() {
        this.mRequestedSimpleAnimations = true;
    }

    public int scrollHorizontallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return 0;
    }

    public void scrollToPosition(int i) {
    }

    public int scrollVerticallyBy(int i, RecyclerView$Recycler recyclerView$Recycler, RecyclerView$State recyclerView$State) {
        return 0;
    }

    @Deprecated
    public void setAutoMeasureEnabled(boolean z2) {
        this.mAutoMeasure = z2;
    }

    public void setExactMeasureSpecsFrom(RecyclerView recyclerView) {
        setMeasureSpecs(View$MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), BasicMeasure.EXACTLY), View$MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), BasicMeasure.EXACTLY));
    }

    public final void setItemPrefetchEnabled(boolean z2) {
        if (z2 != this.mItemPrefetchEnabled) {
            this.mItemPrefetchEnabled = z2;
            this.mPrefetchMaxCountObserved = 0;
            RecyclerView recyclerView = this.mRecyclerView;
            if (recyclerView != null) {
                recyclerView.mRecycler.updateViewCacheSize();
            }
        }
    }

    public void setMeasureSpecs(int i, int i2) {
        this.mWidth = View$MeasureSpec.getSize(i);
        int mode = View$MeasureSpec.getMode(i);
        this.mWidthMode = mode;
        if (mode == 0 && !RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            this.mWidth = 0;
        }
        this.mHeight = View$MeasureSpec.getSize(i2);
        int mode2 = View$MeasureSpec.getMode(i2);
        this.mHeightMode = mode2;
        if (mode2 != 0 || RecyclerView.ALLOW_SIZE_IN_UNSPECIFIED_SPEC) {
            return;
        }
        this.mHeight = 0;
    }

    public void setMeasuredDimension(Rect rect, int i, int i2) {
        setMeasuredDimension(chooseSize(i, getPaddingRight() + getPaddingLeft() + rect.width(), getMinimumWidth()), chooseSize(i2, getPaddingBottom() + getPaddingTop() + rect.height(), getMinimumHeight()));
    }

    public void setMeasuredDimensionFromChildren(int i, int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            this.mRecyclerView.defaultOnMeasure(i, i2);
            return;
        }
        int i3 = Integer.MIN_VALUE;
        int i4 = Integer.MIN_VALUE;
        int i5 = Integer.MAX_VALUE;
        int i6 = Integer.MAX_VALUE;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            Rect rect = this.mRecyclerView.mTempRect;
            getDecoratedBoundsWithMargins(childAt, rect);
            int i8 = rect.left;
            if (i8 < i5) {
                i5 = i8;
            }
            int i9 = rect.right;
            if (i9 > i3) {
                i3 = i9;
            }
            int i10 = rect.top;
            if (i10 < i6) {
                i6 = i10;
            }
            int i11 = rect.bottom;
            if (i11 > i4) {
                i4 = i11;
            }
        }
        this.mRecyclerView.mTempRect.set(i5, i6, i3, i4);
        setMeasuredDimension(this.mRecyclerView.mTempRect, i, i2);
    }

    public void setMeasurementCacheEnabled(boolean z2) {
        this.mMeasurementCacheEnabled = z2;
    }

    public void setRecyclerView(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.mRecyclerView = null;
            this.mChildHelper = null;
            this.mWidth = 0;
            this.mHeight = 0;
        } else {
            this.mRecyclerView = recyclerView;
            this.mChildHelper = recyclerView.mChildHelper;
            this.mWidth = recyclerView.getWidth();
            this.mHeight = recyclerView.getHeight();
        }
        this.mWidthMode = BasicMeasure.EXACTLY;
        this.mHeightMode = BasicMeasure.EXACTLY;
    }

    public boolean shouldMeasureChild(View view, int i, int i2, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return (!view.isLayoutRequested() && this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getWidth(), i, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).width) && isMeasurementUpToDate(view.getHeight(), i2, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).height)) ? false : true;
    }

    public boolean shouldMeasureTwice() {
        return false;
    }

    public boolean shouldReMeasureChild(View view, int i, int i2, RecyclerView$LayoutParams recyclerView$LayoutParams) {
        return (this.mMeasurementCacheEnabled && isMeasurementUpToDate(view.getMeasuredWidth(), i, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).width) && isMeasurementUpToDate(view.getMeasuredHeight(), i2, ((ViewGroup$MarginLayoutParams) recyclerView$LayoutParams).height)) ? false : true;
    }

    public void smoothScrollToPosition(RecyclerView recyclerView, RecyclerView$State recyclerView$State, int i) {
        Log.e(RecyclerView.TAG, "You must override smoothScrollToPosition to support smooth scrolling");
    }

    public void startSmoothScroll(RecyclerView$SmoothScroller recyclerView$SmoothScroller) {
        RecyclerView$SmoothScroller recyclerView$SmoothScroller2 = this.mSmoothScroller;
        if (recyclerView$SmoothScroller2 != null && recyclerView$SmoothScroller != recyclerView$SmoothScroller2 && recyclerView$SmoothScroller2.isRunning()) {
            this.mSmoothScroller.stop();
        }
        this.mSmoothScroller = recyclerView$SmoothScroller;
        recyclerView$SmoothScroller.start(this.mRecyclerView, this);
    }

    public void stopIgnoringView(@NonNull View view) {
        RecyclerView$ViewHolder childViewHolderInt = RecyclerView.getChildViewHolderInt(view);
        childViewHolderInt.stopIgnoring();
        childViewHolderInt.resetInternal();
        childViewHolderInt.addFlags(4);
    }

    public void stopSmoothScroller() {
        RecyclerView$SmoothScroller recyclerView$SmoothScroller = this.mSmoothScroller;
        if (recyclerView$SmoothScroller != null) {
            recyclerView$SmoothScroller.stop();
        }
    }

    public boolean supportsPredictiveItemAnimations() {
        return false;
    }

    public void addDisappearingView(View view, int i) {
        addViewInt(view, i, true);
    }

    public void addView(View view, int i) {
        addViewInt(view, i, false);
    }

    public void onInitializeAccessibilityEvent(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, @NonNull AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null || accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (!recyclerView.canScrollVertically(1) && !this.mRecyclerView.canScrollVertically(-1) && !this.mRecyclerView.canScrollHorizontally(-1) && !this.mRecyclerView.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        RecyclerView$Adapter recyclerView$Adapter = this.mRecyclerView.mAdapter;
        if (recyclerView$Adapter != null) {
            accessibilityEvent.setItemCount(recyclerView$Adapter.getItemCount());
        }
    }

    public void onInitializeAccessibilityNodeInfo(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (this.mRecyclerView.canScrollVertically(-1) || this.mRecyclerView.canScrollHorizontally(-1)) {
            accessibilityNodeInfoCompat.addAction(8192);
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        if (this.mRecyclerView.canScrollVertically(1) || this.mRecyclerView.canScrollHorizontally(1)) {
            accessibilityNodeInfoCompat.addAction(4096);
            accessibilityNodeInfoCompat.setScrollable(true);
        }
        accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat$CollectionInfoCompat.obtain(getRowCountForAccessibility(recyclerView$Recycler, recyclerView$State), getColumnCountForAccessibility(recyclerView$Recycler, recyclerView$State), isLayoutHierarchical(recyclerView$Recycler, recyclerView$State), getSelectionModeForAccessibility(recyclerView$Recycler, recyclerView$State)));
    }

    public boolean onRequestChildFocus(@NonNull RecyclerView recyclerView, @NonNull RecyclerView$State recyclerView$State, @NonNull View view, @Nullable View view2) {
        return onRequestChildFocus(recyclerView, view, view2);
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0071 A[PHI: r8
      0x0071: PHI (r8v8 int) = (r8v4 int), (r8v12 int) binds: [B:22:0x005e, B:15:0x0030] A[DONT_GENERATE, DONT_INLINE]] */
    public boolean performAccessibilityAction(@NonNull RecyclerView$Recycler recyclerView$Recycler, @NonNull RecyclerView$State recyclerView$State, int i, @Nullable Bundle bundle) {
        int height;
        int width;
        int i2;
        int i3;
        RecyclerView recyclerView = this.mRecyclerView;
        if (recyclerView == null) {
            return false;
        }
        if (i == 4096) {
            height = recyclerView.canScrollVertically(1) ? (getHeight() - getPaddingTop()) - getPaddingBottom() : 0;
            if (this.mRecyclerView.canScrollHorizontally(1)) {
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = height;
                i3 = width;
            } else {
                i2 = height;
                i3 = 0;
            }
        } else if (i != 8192) {
            i3 = 0;
            i2 = 0;
        } else {
            height = recyclerView.canScrollVertically(-1) ? -((getHeight() - getPaddingTop()) - getPaddingBottom()) : 0;
            if (this.mRecyclerView.canScrollHorizontally(-1)) {
                width = -((getWidth() - getPaddingLeft()) - getPaddingRight());
                i2 = height;
                i3 = width;
            } else {
                i2 = height;
                i3 = 0;
            }
        }
        if (i2 == 0 && i3 == 0) {
            return false;
        }
        this.mRecyclerView.smoothScrollBy(i3, i2, null, Integer.MIN_VALUE, true);
        return true;
    }

    public boolean requestChildRectangleOnScreen(@NonNull RecyclerView recyclerView, @NonNull View view, @NonNull Rect rect, boolean z2, boolean z3) {
        int[] childRectangleOnScreenScrollAmount = getChildRectangleOnScreenScrollAmount(view, rect);
        int i = childRectangleOnScreenScrollAmount[0];
        int i2 = childRectangleOnScreenScrollAmount[1];
        if ((z3 && !isFocusedChildVisibleAfterScrolling(recyclerView, i, i2)) || (i == 0 && i2 == 0)) {
            return false;
        }
        if (z2) {
            recyclerView.scrollBy(i, i2);
        } else {
            recyclerView.smoothScrollBy(i, i2);
        }
        return true;
    }

    /* JADX WARN: Code duplicated, block: B:12:0x001c  */
    /* JADX WARN: Code duplicated, block: B:21:0x002f  */
    public static int getChildMeasureSpec(int i, int i2, int i3, int i4, boolean z2) {
        int iMax = Math.max(0, i - i3);
        if (z2) {
            if (i4 >= 0) {
                i2 = BasicMeasure.EXACTLY;
            } else if (i4 != -1 || (i2 != Integer.MIN_VALUE && (i2 == 0 || i2 != 1073741824))) {
                i2 = 0;
                i4 = 0;
            } else {
                i4 = iMax;
            }
        } else if (i4 >= 0) {
            i2 = BasicMeasure.EXACTLY;
        } else {
            if (i4 != -1) {
                if (i4 == -2) {
                    i2 = (i2 == Integer.MIN_VALUE || i2 == 1073741824) ? Integer.MIN_VALUE : 0;
                } else {
                    i2 = 0;
                    i4 = 0;
                }
            }
            i4 = iMax;
        }
        return View$MeasureSpec.makeMeasureSpec(i4, i2);
    }

    public void attachView(@NonNull View view, int i) {
        attachView(view, i, (RecyclerView$LayoutParams) view.getLayoutParams());
    }

    public RecyclerView$LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        return new RecyclerView$LayoutParams(context, attributeSet);
    }

    public void setMeasuredDimension(int i, int i2) {
        RecyclerView.access$300(this.mRecyclerView, i, i2);
    }

    public void attachView(@NonNull View view) {
        attachView(view, -1);
    }
}
