package com.google.android.material.floatingactionbutton;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;

/* JADX INFO: loaded from: classes3.dex */
public class FloatingActionButton$Behavior extends FloatingActionButton$BaseBehavior<FloatingActionButton> {
    public FloatingActionButton$Behavior() {
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior
    public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, @NonNull Rect rect) {
        return super.getInsetDodgeRect(coordinatorLayout, floatingActionButton, rect);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior
    public /* bridge */ /* synthetic */ boolean isAutoHideEnabled() {
        return super.isAutoHideEnabled();
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public /* bridge */ /* synthetic */ void onAttachedToLayoutParams(@NonNull CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams) {
        super.onAttachedToLayoutParams(coordinatorLayout$LayoutParams);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior
    public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, View view) {
        return super.onDependentViewChanged(coordinatorLayout, floatingActionButton, view);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior
    public /* bridge */ /* synthetic */ boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull FloatingActionButton floatingActionButton, int i) {
        return super.onLayoutChild(coordinatorLayout, floatingActionButton, i);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior
    public /* bridge */ /* synthetic */ void setAutoHideEnabled(boolean z2) {
        super.setAutoHideEnabled(z2);
    }

    @Override // com.google.android.material.floatingactionbutton.FloatingActionButton$BaseBehavior
    @VisibleForTesting
    public /* bridge */ /* synthetic */ void setInternalAutoHideListener(FloatingActionButton$OnVisibilityChangedListener floatingActionButton$OnVisibilityChangedListener) {
        super.setInternalAutoHideListener(floatingActionButton$OnVisibilityChangedListener);
    }

    public FloatingActionButton$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
