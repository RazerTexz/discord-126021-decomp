package androidx.viewpager2.widget;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import java.util.Locale;

/* JADX INFO: loaded from: classes.dex */
public final class ScrollEventAdapter extends RecyclerView$OnScrollListener {
    private static final int NO_POSITION = -1;
    private static final int STATE_IDLE = 0;
    private static final int STATE_IN_PROGRESS_FAKE_DRAG = 4;
    private static final int STATE_IN_PROGRESS_IMMEDIATE_SCROLL = 3;
    private static final int STATE_IN_PROGRESS_MANUAL_DRAG = 1;
    private static final int STATE_IN_PROGRESS_SMOOTH_SCROLL = 2;
    private int mAdapterState;
    private ViewPager2$OnPageChangeCallback mCallback;
    private boolean mDataSetChangeHappened;
    private boolean mDispatchSelected;
    private int mDragStartPosition;
    private boolean mFakeDragging;

    @NonNull
    private final LinearLayoutManager mLayoutManager;

    @NonNull
    private final RecyclerView mRecyclerView;
    private boolean mScrollHappened;
    private int mScrollState;
    private ScrollEventAdapter$ScrollEventValues mScrollValues;
    private int mTarget;

    @NonNull
    private final ViewPager2 mViewPager;

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.mViewPager = viewPager2;
        RecyclerView recyclerView = viewPager2.mRecyclerView;
        this.mRecyclerView = recyclerView;
        this.mLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.mScrollValues = new ScrollEventAdapter$ScrollEventValues();
        resetState();
    }

    private void dispatchScrolled(int i, float f, int i2) {
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.mCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            viewPager2$OnPageChangeCallback.onPageScrolled(i, f, i2);
        }
    }

    private void dispatchSelected(int i) {
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.mCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            viewPager2$OnPageChangeCallback.onPageSelected(i);
        }
    }

    private void dispatchStateChanged(int i) {
        if ((this.mAdapterState == 3 && this.mScrollState == 0) || this.mScrollState == i) {
            return;
        }
        this.mScrollState = i;
        ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback = this.mCallback;
        if (viewPager2$OnPageChangeCallback != null) {
            viewPager2$OnPageChangeCallback.onPageScrollStateChanged(i);
        }
    }

    private int getPosition() {
        return this.mLayoutManager.findFirstVisibleItemPosition();
    }

    private boolean isInAnyDraggingState() {
        int i = this.mAdapterState;
        return i == 1 || i == 4;
    }

    private void resetState() {
        this.mAdapterState = 0;
        this.mScrollState = 0;
        this.mScrollValues.reset();
        this.mDragStartPosition = -1;
        this.mTarget = -1;
        this.mDispatchSelected = false;
        this.mScrollHappened = false;
        this.mFakeDragging = false;
        this.mDataSetChangeHappened = false;
    }

    private void startDrag(boolean z2) {
        this.mFakeDragging = z2;
        this.mAdapterState = z2 ? 4 : 1;
        int i = this.mTarget;
        if (i != -1) {
            this.mDragStartPosition = i;
            this.mTarget = -1;
        } else if (this.mDragStartPosition == -1) {
            this.mDragStartPosition = getPosition();
        }
        dispatchStateChanged(1);
    }

    private void updateScrollEventValues() {
        int top;
        ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
        int iFindFirstVisibleItemPosition = this.mLayoutManager.findFirstVisibleItemPosition();
        scrollEventAdapter$ScrollEventValues.mPosition = iFindFirstVisibleItemPosition;
        if (iFindFirstVisibleItemPosition == -1) {
            scrollEventAdapter$ScrollEventValues.reset();
            return;
        }
        View viewFindViewByPosition = this.mLayoutManager.findViewByPosition(iFindFirstVisibleItemPosition);
        if (viewFindViewByPosition == null) {
            scrollEventAdapter$ScrollEventValues.reset();
            return;
        }
        int leftDecorationWidth = this.mLayoutManager.getLeftDecorationWidth(viewFindViewByPosition);
        int rightDecorationWidth = this.mLayoutManager.getRightDecorationWidth(viewFindViewByPosition);
        int topDecorationHeight = this.mLayoutManager.getTopDecorationHeight(viewFindViewByPosition);
        int bottomDecorationHeight = this.mLayoutManager.getBottomDecorationHeight(viewFindViewByPosition);
        ViewGroup$LayoutParams layoutParams = viewFindViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup$MarginLayoutParams) {
            ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
            leftDecorationWidth += viewGroup$MarginLayoutParams.leftMargin;
            rightDecorationWidth += viewGroup$MarginLayoutParams.rightMargin;
            topDecorationHeight += viewGroup$MarginLayoutParams.topMargin;
            bottomDecorationHeight += viewGroup$MarginLayoutParams.bottomMargin;
        }
        int height = viewFindViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = viewFindViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.mLayoutManager.getOrientation() == 0) {
            top = (viewFindViewByPosition.getLeft() - leftDecorationWidth) - this.mRecyclerView.getPaddingLeft();
            if (this.mViewPager.isRtl()) {
                top = -top;
            }
            height = width;
        } else {
            top = (viewFindViewByPosition.getTop() - topDecorationHeight) - this.mRecyclerView.getPaddingTop();
        }
        int i = -top;
        scrollEventAdapter$ScrollEventValues.mOffsetPx = i;
        if (i >= 0) {
            scrollEventAdapter$ScrollEventValues.mOffset = height == 0 ? 0.0f : i / height;
        } else {
            if (!new AnimateLayoutChangeDetector(this.mLayoutManager).mayHaveInterferingAnimations()) {
                throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventAdapter$ScrollEventValues.mOffsetPx)));
            }
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        }
    }

    public double getRelativeScrollPosition() {
        updateScrollEventValues();
        ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
        return ((double) scrollEventAdapter$ScrollEventValues.mPosition) + ((double) scrollEventAdapter$ScrollEventValues.mOffset);
    }

    public int getScrollState() {
        return this.mScrollState;
    }

    public boolean isDragging() {
        return this.mScrollState == 1;
    }

    public boolean isFakeDragging() {
        return this.mFakeDragging;
    }

    public boolean isIdle() {
        return this.mScrollState == 0;
    }

    public void notifyBeginFakeDrag() {
        this.mAdapterState = 4;
        startDrag(true);
    }

    public void notifyDataSetChangeHappened() {
        this.mDataSetChangeHappened = true;
    }

    public void notifyEndFakeDrag() {
        if (!isDragging() || this.mFakeDragging) {
            this.mFakeDragging = false;
            updateScrollEventValues();
            ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
            if (scrollEventAdapter$ScrollEventValues.mOffsetPx != 0) {
                dispatchStateChanged(2);
                return;
            }
            int i = scrollEventAdapter$ScrollEventValues.mPosition;
            if (i != this.mDragStartPosition) {
                dispatchSelected(i);
            }
            dispatchStateChanged(0);
            resetState();
        }
    }

    public void notifyProgrammaticScroll(int i, boolean z2) {
        this.mAdapterState = z2 ? 2 : 3;
        this.mFakeDragging = false;
        boolean z3 = this.mTarget != i;
        this.mTarget = i;
        dispatchStateChanged(2);
        if (z3) {
            dispatchSelected(i);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        boolean z2 = true;
        if (!(this.mAdapterState == 1 && this.mScrollState == 1) && i == 1) {
            startDrag(false);
            return;
        }
        if (isInAnyDraggingState() && i == 2) {
            if (this.mScrollHappened) {
                dispatchStateChanged(2);
                this.mDispatchSelected = true;
                return;
            }
            return;
        }
        if (isInAnyDraggingState() && i == 0) {
            updateScrollEventValues();
            if (this.mScrollHappened) {
                ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
                if (scrollEventAdapter$ScrollEventValues.mOffsetPx == 0) {
                    int i2 = this.mDragStartPosition;
                    int i3 = scrollEventAdapter$ScrollEventValues.mPosition;
                    if (i2 != i3) {
                        dispatchSelected(i3);
                    }
                } else {
                    z2 = false;
                }
            } else {
                int i4 = this.mScrollValues.mPosition;
                if (i4 != -1) {
                    dispatchScrolled(i4, 0.0f, 0);
                }
            }
            if (z2) {
                dispatchStateChanged(0);
                resetState();
            }
        }
        if (this.mAdapterState == 2 && i == 0 && this.mDataSetChangeHappened) {
            updateScrollEventValues();
            ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues2 = this.mScrollValues;
            if (scrollEventAdapter$ScrollEventValues2.mOffsetPx == 0) {
                int i5 = this.mTarget;
                int i6 = scrollEventAdapter$ScrollEventValues2.mPosition;
                if (i5 != i6) {
                    if (i6 == -1) {
                        i6 = 0;
                    }
                    dispatchSelected(i6);
                }
                dispatchStateChanged(0);
                resetState();
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0022  */
    /* JADX WARN: Code duplicated, block: B:19:0x002f  */
    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        boolean z2;
        int i3;
        this.mScrollHappened = true;
        updateScrollEventValues();
        if (this.mDispatchSelected) {
            this.mDispatchSelected = false;
            if (i2 <= 0) {
                if (i2 == 0) {
                    z2 = (i < 0) == this.mViewPager.isRtl();
                }
            }
            if (z2) {
                ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues = this.mScrollValues;
                if (scrollEventAdapter$ScrollEventValues.mOffsetPx != 0) {
                    i3 = scrollEventAdapter$ScrollEventValues.mPosition + 1;
                } else {
                    i3 = this.mScrollValues.mPosition;
                }
            } else {
                i3 = this.mScrollValues.mPosition;
            }
            this.mTarget = i3;
            if (this.mDragStartPosition != i3) {
                dispatchSelected(i3);
            }
        } else if (this.mAdapterState == 0) {
            int i4 = this.mScrollValues.mPosition;
            if (i4 == -1) {
                i4 = 0;
            }
            dispatchSelected(i4);
        }
        ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues2 = this.mScrollValues;
        int i5 = scrollEventAdapter$ScrollEventValues2.mPosition;
        if (i5 == -1) {
            i5 = 0;
        }
        dispatchScrolled(i5, scrollEventAdapter$ScrollEventValues2.mOffset, scrollEventAdapter$ScrollEventValues2.mOffsetPx);
        ScrollEventAdapter$ScrollEventValues scrollEventAdapter$ScrollEventValues3 = this.mScrollValues;
        int i6 = scrollEventAdapter$ScrollEventValues3.mPosition;
        int i7 = this.mTarget;
        if ((i6 == i7 || i7 == -1) && scrollEventAdapter$ScrollEventValues3.mOffsetPx == 0 && this.mScrollState != 1) {
            dispatchStateChanged(0);
            resetState();
        }
    }

    public void setOnPageChangeCallback(ViewPager2$OnPageChangeCallback viewPager2$OnPageChangeCallback) {
        this.mCallback = viewPager2$OnPageChangeCallback;
    }
}
