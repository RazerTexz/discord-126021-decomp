package com.google.android.material.behavior;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments;

/* JADX INFO: loaded from: classes3.dex */
public class SwipeDismissBehavior$b implements AccessibilityViewCommand {
    public final /* synthetic */ SwipeDismissBehavior a;

    public SwipeDismissBehavior$b(SwipeDismissBehavior swipeDismissBehavior) {
        this.a = swipeDismissBehavior;
    }

    @Override // androidx.core.view.accessibility.AccessibilityViewCommand
    public boolean perform(@NonNull View view, @Nullable AccessibilityViewCommand$CommandArguments accessibilityViewCommand$CommandArguments) {
        boolean z2 = false;
        if (!this.a.canSwipeDismissView(view)) {
            return false;
        }
        boolean z3 = ViewCompat.getLayoutDirection(view) == 1;
        int i = this.a.swipeDirection;
        if ((i == 0 && z3) || (i == 1 && !z3)) {
            z2 = true;
        }
        int width = view.getWidth();
        if (z2) {
            width = -width;
        }
        ViewCompat.offsetLeftAndRight(view, width);
        view.setAlpha(0.0f);
        SwipeDismissBehavior$OnDismissListener swipeDismissBehavior$OnDismissListener = this.a.listener;
        if (swipeDismissBehavior$OnDismissListener != null) {
            swipeDismissBehavior$OnDismissListener.onDismiss(view);
        }
        return true;
    }
}
