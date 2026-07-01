package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton$BaseBehavior<T extends FloatingActionButton> extends CoordinatorLayout$Behavior<T> {
    private static final boolean AUTO_HIDE_DEFAULT = true;
    private boolean autoHideEnabled;
    private FloatingActionButton$OnVisibilityChangedListener internalAutoHideListener;
    private Rect tmpRect;

    public FloatingActionButton$BaseBehavior() {
        this.autoHideEnabled = true;
    }

    private static boolean isBottomSheet(@NonNull View view) {
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout$LayoutParams) {
            return ((CoordinatorLayout$LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
        }
        return false;
    }

    private void offsetIfNeeded(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton) {
        int i;
        Rect rect = floatingActionButton.shadowPadding;
        if (rect == null || rect.centerX() <= 0 || rect.centerY() <= 0) {
            return;
        }
        CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams) floatingActionButton.getLayoutParams();
        int i2 = 0;
        if (floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).rightMargin) {
            i = rect.right;
        } else {
            i = floatingActionButton.getLeft() <= ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).leftMargin ? -rect.left : 0;
        }
        if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).bottomMargin) {
            i2 = rect.bottom;
        } else if (floatingActionButton.getTop() <= ((ViewGroup$MarginLayoutParams) coordinatorLayout$LayoutParams).topMargin) {
            i2 = -rect.top;
        }
        if (i2 != 0) {
            ViewCompat.offsetTopAndBottom(floatingActionButton, i2);
        }
        if (i != 0) {
            ViewCompat.offsetLeftAndRight(floatingActionButton, i);
        }
    }

    private boolean shouldUpdateVisibility(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
        return this.autoHideEnabled && ((CoordinatorLayout$LayoutParams) floatingActionButton.getLayoutParams()).getAnchorId() == view.getId() && floatingActionButton.getUserSetVisibility() == 0;
    }

    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull FloatingActionButton floatingActionButton) {
        if (!shouldUpdateVisibility(appBarLayout, floatingActionButton)) {
            return false;
        }
        if (this.tmpRect == null) {
            this.tmpRect = new Rect();
        }
        Rect rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
        if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
            floatingActionButton.hide(this.internalAutoHideListener, false);
            return true;
        }
        floatingActionButton.show(this.internalAutoHideListener, false);
        return true;
    }

    private boolean updateFabVisibilityForBottomSheet(@NonNull View view, @NonNull FloatingActionButton floatingActionButton) {
        if (!shouldUpdateVisibility(view, floatingActionButton)) {
            return false;
        }
        if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup$MarginLayoutParams) ((CoordinatorLayout$LayoutParams) floatingActionButton.getLayoutParams())).topMargin) {
            floatingActionButton.hide(this.internalAutoHideListener, false);
            return true;
        }
        floatingActionButton.show(this.internalAutoHideListener, false);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
        return getInsetDodgeRect(coordinatorLayout, (FloatingActionButton) view, rect);
    }

    public boolean isAutoHideEnabled() {
        return this.autoHideEnabled;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        if (coordinatorLayout$LayoutParams.dodgeInsetEdges == 0) {
            coordinatorLayout$LayoutParams.dodgeInsetEdges = 80;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
        return onDependentViewChanged(coordinatorLayout, (FloatingActionButton) view, view2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        return onLayoutChild(coordinatorLayout, (FloatingActionButton) view, i);
    }

    public void setAutoHideEnabled(boolean z2) {
        this.autoHideEnabled = z2;
    }

    @VisibleForTesting
    public void setInternalAutoHideListener(FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        this.internalAutoHideListener = floatingActionButton$OnVisibilityChangedListener;
    }

    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
        Rect rect2 = floatingActionButton.shadowPadding;
        rect.set(floatingActionButton.getLeft() + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
        return true;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
        if (view instanceof AppBarLayout) {
            updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton);
            return false;
        }
        if (!isBottomSheet(view)) {
            return false;
        }
        updateFabVisibilityForBottomSheet(view, floatingActionButton);
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
        List<View> dependencies = coordinatorLayout.getDependencies(floatingActionButton);
        int size = dependencies.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = dependencies.get(i2);
            if (!(view instanceof AppBarLayout)) {
                if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, floatingActionButton)) {
                    break;
                }
            } else {
                if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, floatingActionButton)) {
                    break;
                }
            }
        }
        coordinatorLayout.onLayoutChild(floatingActionButton, i);
        offsetIfNeeded(coordinatorLayout, floatingActionButton);
        return true;
    }

    public FloatingActionButton$BaseBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
        this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
