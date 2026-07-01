package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout$Behavior<T> {
    private static final boolean AUTO_HIDE_DEFAULT = false;
    private static final boolean AUTO_SHRINK_DEFAULT = true;
    private boolean autoHideEnabled;
    private boolean autoShrinkEnabled;

    @Nullable
    private ExtendedFloatingActionButton$OnChangedCallback internalAutoHideCallback;

    @Nullable
    private ExtendedFloatingActionButton$OnChangedCallback internalAutoShrinkCallback;
    private Rect tmpRect;

    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior() {
        this.autoHideEnabled = false;
        this.autoShrinkEnabled = true;
    }

    private static boolean isBottomSheet(@NonNull View view) {
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof CoordinatorLayout$LayoutParams) {
            return ((CoordinatorLayout$LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
        }
        return false;
    }

    private boolean shouldUpdateVisibility(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
        return (this.autoHideEnabled || this.autoShrinkEnabled) && ((CoordinatorLayout$LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
    }

    private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, @NonNull AppBarLayout appBarLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
        if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
            return false;
        }
        if (this.tmpRect == null) {
            this.tmpRect = new Rect();
        }
        Rect rect = this.tmpRect;
        DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
        if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
            shrinkOrHide(extendedFloatingActionButton);
            return true;
        }
        extendOrShow(extendedFloatingActionButton);
        return true;
    }

    private boolean updateFabVisibilityForBottomSheet(@NonNull View view, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
        if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
            return false;
        }
        if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((ViewGroup$MarginLayoutParams) ((CoordinatorLayout$LayoutParams) extendedFloatingActionButton.getLayoutParams())).topMargin) {
            shrinkOrHide(extendedFloatingActionButton);
            return true;
        }
        extendOrShow(extendedFloatingActionButton);
        return true;
    }

    public void extendOrShow(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
        boolean z2 = this.autoShrinkEnabled;
        ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, z2 ? ExtendedFloatingActionButton.access$500(extendedFloatingActionButton) : ExtendedFloatingActionButton.access$600(extendedFloatingActionButton), z2 ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull Rect rect) {
        return getInsetDodgeRect(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
    }

    public boolean isAutoHideEnabled() {
        return this.autoHideEnabled;
    }

    public boolean isAutoShrinkEnabled() {
        return this.autoShrinkEnabled;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        if (coordinatorLayout$LayoutParams.dodgeInsetEdges == 0) {
            coordinatorLayout$LayoutParams.dodgeInsetEdges = 80;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull View view, View view2) {
        return onDependentViewChanged(coordinatorLayout, (ExtendedFloatingActionButton) view, view2);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, int i) {
        return onLayoutChild(coordinatorLayout, (ExtendedFloatingActionButton) view, i);
    }

    public void setAutoHideEnabled(boolean z2) {
        this.autoHideEnabled = z2;
    }

    public void setAutoShrinkEnabled(boolean z2) {
        this.autoShrinkEnabled = z2;
    }

    @VisibleForTesting
    public void setInternalAutoHideCallback(@Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        this.internalAutoHideCallback = extendedFloatingActionButton$OnChangedCallback;
    }

    @VisibleForTesting
    public void setInternalAutoShrinkCallback(@Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        this.internalAutoShrinkCallback = extendedFloatingActionButton$OnChangedCallback;
    }

    public void shrinkOrHide(@NonNull ExtendedFloatingActionButton extendedFloatingActionButton) {
        boolean z2 = this.autoShrinkEnabled;
        ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, z2 ? ExtendedFloatingActionButton.access$200(extendedFloatingActionButton) : ExtendedFloatingActionButton.access$300(extendedFloatingActionButton), z2 ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
    }

    public boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, @NonNull Rect rect) {
        return super.getInsetDodgeRect(coordinatorLayout, extendedFloatingActionButton, rect);
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
        if (view instanceof AppBarLayout) {
            updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
            return false;
        }
        if (!isBottomSheet(view)) {
            return false;
        }
        updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
        return false;
    }

    public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
        int size = dependencies.size();
        for (int i2 = 0; i2 < size; i2++) {
            View view = dependencies.get(i2);
            if (!(view instanceof AppBarLayout)) {
                if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                    break;
                }
            } else {
                if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                    break;
                }
            }
        }
        coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
        return true;
    }

    public ExtendedFloatingActionButton$ExtendedFloatingActionButtonBehavior(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ExtendedFloatingActionButton_Behavior_Layout);
        this.autoHideEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
        this.autoShrinkEnabled = typedArrayObtainStyledAttributes.getBoolean(R$styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
        typedArrayObtainStyledAttributes.recycle();
    }
}
