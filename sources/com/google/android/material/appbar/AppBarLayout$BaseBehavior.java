package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View$MeasureSpec;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.animation.Interpolator;
import android.widget.LinearLayout$LayoutParams;
import android.widget.ListView;
import android.widget.ScrollView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.math.MathUtils;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import b.i.a.g.a.a;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AppBarLayout$BaseBehavior<T extends AppBarLayout> extends a<T> {
    private static final int INVALID_POSITION = -1;
    private static final int MAX_OFFSET_ANIMATION_DURATION = 600;

    @Nullable
    private WeakReference<View> lastNestedScrollingChildRef;
    private int lastStartedType;
    private ValueAnimator offsetAnimator;
    private int offsetDelta;
    private int offsetToChildIndexOnLayout;
    private boolean offsetToChildIndexOnLayoutIsMinHeight;
    private float offsetToChildIndexOnLayoutPerc;
    private AppBarLayout$BaseBehavior$BaseDragCallback onDragCallback;

    public AppBarLayout$BaseBehavior() {
        this.offsetToChildIndexOnLayout = -1;
    }

    public static /* synthetic */ int access$000(AppBarLayout$BaseBehavior appBarLayout$BaseBehavior) {
        return appBarLayout$BaseBehavior.offsetDelta;
    }

    private void addAccessibilityScrollActions(CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
        if (getTopBottomOffsetForScrollingSibling() != (-t.getTotalScrollRange()) && view.canScrollVertically(1)) {
            addActionToExpand(coordinatorLayout, t, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_FORWARD, false);
        }
        if (getTopBottomOffsetForScrollingSibling() != 0) {
            if (!view.canScrollVertically(-1)) {
                addActionToExpand(coordinatorLayout, t, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, true);
                return;
            }
            int i = -t.getDownNestedPreScrollRange();
            if (i != 0) {
                ViewCompat.replaceAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD, null, new AppBarLayout$BaseBehavior$b(this, coordinatorLayout, t, view, i));
            }
        }
    }

    private void addActionToExpand(CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull AccessibilityNodeInfoCompat$AccessibilityActionCompat accessibilityNodeInfoCompat$AccessibilityActionCompat, boolean z2) {
        ViewCompat.replaceAccessibilityAction(coordinatorLayout, accessibilityNodeInfoCompat$AccessibilityActionCompat, null, new AppBarLayout$BaseBehavior$c(this, t, z2));
    }

    private void animateOffsetTo(CoordinatorLayout coordinatorLayout, @NonNull T t, int i, float f) {
        int iAbs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
        float fAbs = Math.abs(f);
        animateOffsetWithDuration(coordinatorLayout, t, i, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / t.getHeight()) + 1.0f) * 150.0f));
    }

    private void animateOffsetWithDuration(CoordinatorLayout coordinatorLayout, T t, int i, int i2) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (topBottomOffsetForScrollingSibling == i) {
            ValueAnimator valueAnimator = this.offsetAnimator;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                return;
            }
            this.offsetAnimator.cancel();
            return;
        }
        ValueAnimator valueAnimator2 = this.offsetAnimator;
        if (valueAnimator2 == null) {
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.offsetAnimator = valueAnimator3;
            valueAnimator3.setInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
            this.offsetAnimator.addUpdateListener(new AppBarLayout$BaseBehavior$a(this, coordinatorLayout, t));
        } else {
            valueAnimator2.cancel();
        }
        this.offsetAnimator.setDuration(Math.min(i2, MAX_OFFSET_ANIMATION_DURATION));
        this.offsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
        this.offsetAnimator.start();
    }

    private boolean canScrollChildren(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view) {
        return t.hasScrollableChildren() && coordinatorLayout.getHeight() - view.getHeight() <= t.getHeight();
    }

    private static boolean checkFlag(int i, int i2) {
        return (i & i2) == i2;
    }

    @Nullable
    private View findFirstScrollingChild(@NonNull CoordinatorLayout coordinatorLayout) {
        int childCount = coordinatorLayout.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = coordinatorLayout.getChildAt(i);
            if ((childAt instanceof NestedScrollingChild) || (childAt instanceof ListView) || (childAt instanceof ScrollView)) {
                return childAt;
            }
        }
        return null;
    }

    @Nullable
    private static View getAppBarChildOnOffset(@NonNull AppBarLayout appBarLayout, int i) {
        int iAbs = Math.abs(i);
        int childCount = appBarLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = appBarLayout.getChildAt(i2);
            if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private int getChildIndexOnOffset(@NonNull T t, int i) {
        int childCount = t.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = t.getChildAt(i2);
            int top = childAt.getTop();
            int bottom = childAt.getBottom();
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams) childAt.getLayoutParams();
            if (checkFlag(appBarLayout$LayoutParams.getScrollFlags(), 32)) {
                top -= ((LinearLayout$LayoutParams) appBarLayout$LayoutParams).topMargin;
                bottom += ((LinearLayout$LayoutParams) appBarLayout$LayoutParams).bottomMargin;
            }
            int i3 = -i;
            if (top <= i3 && bottom >= i3) {
                return i2;
            }
        }
        return -1;
    }

    private int interpolateOffset(@NonNull T t, int i) {
        int iAbs = Math.abs(i);
        int childCount = t.getChildCount();
        int topInset = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = t.getChildAt(i2);
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams) childAt.getLayoutParams();
            Interpolator scrollInterpolator = appBarLayout$LayoutParams.getScrollInterpolator();
            if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                if (scrollInterpolator == null) {
                    break;
                }
                int scrollFlags = appBarLayout$LayoutParams.getScrollFlags();
                if ((scrollFlags & 1) != 0) {
                    topInset = 0 + childAt.getHeight() + ((LinearLayout$LayoutParams) appBarLayout$LayoutParams).topMargin + ((LinearLayout$LayoutParams) appBarLayout$LayoutParams).bottomMargin;
                    if ((scrollFlags & 2) != 0) {
                        topInset -= ViewCompat.getMinimumHeight(childAt);
                    }
                }
                if (ViewCompat.getFitsSystemWindows(childAt)) {
                    topInset -= t.getTopInset();
                }
                if (topInset <= 0) {
                    break;
                }
                float f = topInset;
                return (childAt.getTop() + Math.round(scrollInterpolator.getInterpolation((iAbs - childAt.getTop()) / f) * f)) * Integer.signum(i);
            }
        }
        return i;
    }

    private boolean shouldJumpElevationState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
        List<View> dependents = coordinatorLayout.getDependents(t);
        int size = dependents.size();
        for (int i = 0; i < size; i++) {
            CoordinatorLayout$Behavior behavior = ((CoordinatorLayout$LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
            if (behavior instanceof AppBarLayout$ScrollingViewBehavior) {
                return ((AppBarLayout$ScrollingViewBehavior) behavior).getOverlayTop() != 0;
            }
        }
        return false;
    }

    private void snapToChildIfNeeded(CoordinatorLayout coordinatorLayout, @NonNull T t) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        int childIndexOnOffset = getChildIndexOnOffset(t, topBottomOffsetForScrollingSibling);
        if (childIndexOnOffset >= 0) {
            View childAt = t.getChildAt(childIndexOnOffset);
            AppBarLayout$LayoutParams appBarLayout$LayoutParams = (AppBarLayout$LayoutParams) childAt.getLayoutParams();
            int scrollFlags = appBarLayout$LayoutParams.getScrollFlags();
            if ((scrollFlags & 17) == 17) {
                int i = -childAt.getTop();
                int minimumHeight = -childAt.getBottom();
                if (childIndexOnOffset == t.getChildCount() - 1) {
                    minimumHeight += t.getTopInset();
                }
                if (checkFlag(scrollFlags, 2)) {
                    minimumHeight += ViewCompat.getMinimumHeight(childAt);
                } else if (checkFlag(scrollFlags, 5)) {
                    int minimumHeight2 = ViewCompat.getMinimumHeight(childAt) + minimumHeight;
                    if (topBottomOffsetForScrollingSibling < minimumHeight2) {
                        i = minimumHeight2;
                    } else {
                        minimumHeight = minimumHeight2;
                    }
                }
                if (checkFlag(scrollFlags, 32)) {
                    i += ((LinearLayout$LayoutParams) appBarLayout$LayoutParams).topMargin;
                    minimumHeight -= ((LinearLayout$LayoutParams) appBarLayout$LayoutParams).bottomMargin;
                }
                if (topBottomOffsetForScrollingSibling < (minimumHeight + i) / 2) {
                    i = minimumHeight;
                }
                animateOffsetTo(coordinatorLayout, t, MathUtils.clamp(i, -t.getTotalScrollRange(), 0), 0.0f);
            }
        }
    }

    private void updateAccessibilityActions(CoordinatorLayout coordinatorLayout, @NonNull T t) {
        ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_FORWARD.getId());
        ViewCompat.removeAccessibilityAction(coordinatorLayout, AccessibilityNodeInfoCompat$AccessibilityActionCompat.ACTION_SCROLL_BACKWARD.getId());
        View viewFindFirstScrollingChild = findFirstScrollingChild(coordinatorLayout);
        if (viewFindFirstScrollingChild == null || t.getTotalScrollRange() == 0 || !(((CoordinatorLayout$LayoutParams) viewFindFirstScrollingChild.getLayoutParams()).getBehavior() instanceof AppBarLayout$ScrollingViewBehavior)) {
            return;
        }
        addAccessibilityScrollActions(coordinatorLayout, t, viewFindFirstScrollingChild);
    }

    private void updateAppBarLayoutDrawableState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, boolean z2) {
        View appBarChildOnOffset = getAppBarChildOnOffset(t, i);
        if (appBarChildOnOffset != null) {
            int scrollFlags = ((AppBarLayout$LayoutParams) appBarChildOnOffset.getLayoutParams()).getScrollFlags();
            boolean zShouldLift = false;
            if ((scrollFlags & 1) != 0) {
                int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                if (i2 <= 0 || (scrollFlags & 12) == 0 ? !((scrollFlags & 2) == 0 || (-i) < (appBarChildOnOffset.getBottom() - minimumHeight) - t.getTopInset()) : (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - t.getTopInset()) {
                    zShouldLift = true;
                }
            }
            if (t.isLiftOnScroll()) {
                zShouldLift = t.shouldLift(findFirstScrollingChild(coordinatorLayout));
            }
            boolean liftedState = t.setLiftedState(zShouldLift);
            if (z2 || (liftedState && shouldJumpElevationState(coordinatorLayout, t))) {
                t.jumpDrawablesToCurrentState();
            }
        }
    }

    @Override // b.i.a.g.a.a
    public /* bridge */ /* synthetic */ boolean canDragView(View view) {
        return canDragView((AppBarLayout) view);
    }

    @Override // b.i.a.g.a.a
    public /* bridge */ /* synthetic */ int getMaxDragOffset(@NonNull View view) {
        return getMaxDragOffset((AppBarLayout) view);
    }

    @Override // b.i.a.g.a.a
    public /* bridge */ /* synthetic */ int getScrollRangeForDragFling(@NonNull View view) {
        return getScrollRangeForDragFling((AppBarLayout) view);
    }

    @Override // b.i.a.g.a.a
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.offsetDelta;
    }

    @VisibleForTesting
    public boolean isOffsetAnimatorRunning() {
        ValueAnimator valueAnimator = this.offsetAnimator;
        return valueAnimator != null && valueAnimator.isRunning();
    }

    @Override // b.i.a.g.a.a
    public /* bridge */ /* synthetic */ void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        onFlingFinished(coordinatorLayout, (AppBarLayout) view);
    }

    @Override // b.i.a.g.a.c, androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        return onLayoutChild(coordinatorLayout, (AppBarLayout) view, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3, int i4) {
        return onMeasureChild(coordinatorLayout, (AppBarLayout) view, i, i2, i3, i4);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i, int i2, int[] iArr, int i3) {
        onNestedPreScroll(coordinatorLayout, (AppBarLayout) view, view2, i, i2, iArr, i3);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        onNestedScroll(coordinatorLayout, (AppBarLayout) view, view2, i, i2, i3, i4, i5, iArr);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, Parcelable parcelable) {
        onRestoreInstanceState(coordinatorLayout, (AppBarLayout) view, parcelable);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view) {
        return onSaveInstanceState(coordinatorLayout, (AppBarLayout) view);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2, View view3, int i, int i2) {
        return onStartNestedScroll(coordinatorLayout, (AppBarLayout) view, view2, view3, i, i2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2, int i) {
        onStopNestedScroll(coordinatorLayout, (AppBarLayout) view, view2, i);
    }

    public void setDragCallback(@Nullable AppBarLayout$BaseBehavior$BaseDragCallback appBarLayout$BaseBehavior$BaseDragCallback) {
        this.onDragCallback = appBarLayout$BaseBehavior$BaseDragCallback;
    }

    @Override // b.i.a.g.a.a
    public /* bridge */ /* synthetic */ int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(coordinatorLayout, (AppBarLayout) view, i, i2, i3);
    }

    public boolean canDragView(T t) {
        AppBarLayout$BaseBehavior$BaseDragCallback appBarLayout$BaseBehavior$BaseDragCallback = this.onDragCallback;
        if (appBarLayout$BaseBehavior$BaseDragCallback != null) {
            return appBarLayout$BaseBehavior$BaseDragCallback.canDrag(t);
        }
        WeakReference<View> weakReference = this.lastNestedScrollingChildRef;
        if (weakReference == null) {
            return true;
        }
        View view = weakReference.get();
        return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
    }

    public int getMaxDragOffset(@NonNull T t) {
        return -t.getDownNestedScrollRange();
    }

    public int getScrollRangeForDragFling(@NonNull T t) {
        return t.getTotalScrollRange();
    }

    public void onFlingFinished(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
        snapToChildIfNeeded(coordinatorLayout, t);
        if (t.isLiftOnScroll()) {
            t.setLiftedState(t.shouldLift(findFirstScrollingChild(coordinatorLayout)));
        }
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i) {
        int iRound;
        boolean zOnLayoutChild = super.onLayoutChild(coordinatorLayout, t, i);
        int pendingAction = t.getPendingAction();
        int i2 = this.offsetToChildIndexOnLayout;
        if (i2 >= 0 && (pendingAction & 8) == 0) {
            View childAt = t.getChildAt(i2);
            int i3 = -childAt.getBottom();
            if (this.offsetToChildIndexOnLayoutIsMinHeight) {
                iRound = t.getTopInset() + ViewCompat.getMinimumHeight(childAt) + i3;
            } else {
                iRound = Math.round(childAt.getHeight() * this.offsetToChildIndexOnLayoutPerc) + i3;
            }
            setHeaderTopBottomOffset(coordinatorLayout, t, iRound);
        } else if (pendingAction != 0) {
            boolean z2 = (pendingAction & 4) != 0;
            if ((pendingAction & 2) != 0) {
                int i4 = -t.getUpNestedPreScrollRange();
                if (z2) {
                    animateOffsetTo(coordinatorLayout, t, i4, 0.0f);
                } else {
                    setHeaderTopBottomOffset(coordinatorLayout, t, i4);
                }
            } else if ((pendingAction & 1) != 0) {
                if (z2) {
                    animateOffsetTo(coordinatorLayout, t, 0, 0.0f);
                } else {
                    setHeaderTopBottomOffset(coordinatorLayout, t, 0);
                }
            }
        }
        t.resetPendingAction();
        this.offsetToChildIndexOnLayout = -1;
        setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -t.getTotalScrollRange(), 0));
        updateAppBarLayoutDrawableState(coordinatorLayout, t, getTopAndBottomOffset(), 0, true);
        t.onOffsetChanged(getTopAndBottomOffset());
        updateAccessibilityActions(coordinatorLayout, t);
        return zOnLayoutChild;
    }

    public boolean onMeasureChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, int i3, int i4) {
        if (((ViewGroup$MarginLayoutParams) ((CoordinatorLayout$LayoutParams) t.getLayoutParams())).height != -2) {
            return super.onMeasureChild(coordinatorLayout, t, i, i2, i3, i4);
        }
        coordinatorLayout.onMeasureChild(t, i, i2, View$MeasureSpec.makeMeasureSpec(0, 0), i4);
        return true;
    }

    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        int downNestedPreScrollRange;
        if (i2 != 0) {
            if (i2 < 0) {
                int i5 = -t.getTotalScrollRange();
                i4 = i5;
                downNestedPreScrollRange = t.getDownNestedPreScrollRange() + i5;
            } else {
                i4 = -t.getUpNestedPreScrollRange();
                downNestedPreScrollRange = 0;
            }
            if (i4 != downNestedPreScrollRange) {
                iArr[1] = scroll(coordinatorLayout, t, i2, i4, downNestedPreScrollRange);
            }
        }
        if (t.isLiftOnScroll()) {
            t.setLiftedState(t.shouldLift(view));
        }
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i4 < 0) {
            iArr[1] = scroll(coordinatorLayout, t, i4, -t.getDownNestedScrollRange(), 0);
        }
        if (i4 == 0) {
            updateAccessibilityActions(coordinatorLayout, t);
        }
    }

    public void onRestoreInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, Parcelable parcelable) {
        if (!(parcelable instanceof AppBarLayout$BaseBehavior$SavedState)) {
            super.onRestoreInstanceState(coordinatorLayout, t, parcelable);
            this.offsetToChildIndexOnLayout = -1;
            return;
        }
        AppBarLayout$BaseBehavior$SavedState appBarLayout$BaseBehavior$SavedState = (AppBarLayout$BaseBehavior$SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, t, appBarLayout$BaseBehavior$SavedState.getSuperState());
        this.offsetToChildIndexOnLayout = appBarLayout$BaseBehavior$SavedState.firstVisibleChildIndex;
        this.offsetToChildIndexOnLayoutPerc = appBarLayout$BaseBehavior$SavedState.firstVisibleChildPercentageShown;
        this.offsetToChildIndexOnLayoutIsMinHeight = appBarLayout$BaseBehavior$SavedState.firstVisibleChildAtMinimumHeight;
    }

    public Parcelable onSaveInstanceState(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t) {
        Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(coordinatorLayout, t);
        int topAndBottomOffset = getTopAndBottomOffset();
        int childCount = t.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = t.getChildAt(i);
            int bottom = childAt.getBottom() + topAndBottomOffset;
            if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                AppBarLayout$BaseBehavior$SavedState appBarLayout$BaseBehavior$SavedState = new AppBarLayout$BaseBehavior$SavedState(parcelableOnSaveInstanceState);
                appBarLayout$BaseBehavior$SavedState.firstVisibleChildIndex = i;
                appBarLayout$BaseBehavior$SavedState.firstVisibleChildAtMinimumHeight = bottom == t.getTopInset() + ViewCompat.getMinimumHeight(childAt);
                appBarLayout$BaseBehavior$SavedState.firstVisibleChildPercentageShown = bottom / childAt.getHeight();
                return appBarLayout$BaseBehavior$SavedState;
            }
        }
        return parcelableOnSaveInstanceState;
    }

    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, @NonNull View view, View view2, int i, int i2) {
        ValueAnimator valueAnimator;
        boolean z2 = (i & 2) != 0 && (t.isLiftOnScroll() || canScrollChildren(coordinatorLayout, t, view));
        if (z2 && (valueAnimator = this.offsetAnimator) != null) {
            valueAnimator.cancel();
        }
        this.lastNestedScrollingChildRef = null;
        this.lastStartedType = i2;
        return z2;
    }

    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, @NonNull T t, View view, int i) {
        if (this.lastStartedType == 0 || i == 1) {
            snapToChildIfNeeded(coordinatorLayout, t);
            if (t.isLiftOnScroll()) {
                t.setLiftedState(t.shouldLift(view));
            }
        }
        this.lastNestedScrollingChildRef = new WeakReference<>(view);
    }

    public int setHeaderTopBottomOffset(@NonNull CoordinatorLayout coordinatorLayout, @NonNull T t, int i, int i2, int i3) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        int i4 = 0;
        if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
            this.offsetDelta = 0;
        } else {
            int iClamp = MathUtils.clamp(i, i2, i3);
            if (topBottomOffsetForScrollingSibling != iClamp) {
                int iInterpolateOffset = t.hasChildWithInterpolator() ? interpolateOffset(t, iClamp) : iClamp;
                boolean topAndBottomOffset = setTopAndBottomOffset(iInterpolateOffset);
                i4 = topBottomOffsetForScrollingSibling - iClamp;
                this.offsetDelta = iClamp - iInterpolateOffset;
                if (!topAndBottomOffset && t.hasChildWithInterpolator()) {
                    coordinatorLayout.dispatchDependentViewsChanged(t);
                }
                t.onOffsetChanged(getTopAndBottomOffset());
                updateAppBarLayoutDrawableState(coordinatorLayout, t, iClamp, iClamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
            }
        }
        updateAccessibilityActions(coordinatorLayout, t);
        return i4;
    }

    public AppBarLayout$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.offsetToChildIndexOnLayout = -1;
    }
}
