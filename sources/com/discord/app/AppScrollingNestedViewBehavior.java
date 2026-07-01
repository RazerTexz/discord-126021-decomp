package com.discord.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.display.DisplayUtils;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: AppScrollingNestedViewBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScrollingNestedViewBehavior extends AppBarLayout.ScrollingViewBehavior {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScrollingNestedViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        Intrinsics3.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics3.checkNotNullParameter(child, "child");
        Intrinsics3.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        WindowInsetsCompat windowInsetsCompatOnApplyWindowInsets = DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER().onApplyWindowInsets(child, insets);
        Intrinsics3.checkNotNullExpressionValue(windowInsetsCompatOnApplyWindowInsets, "NO_OP_WINDOW_INSETS_LIST…ndowInsets(child, insets)");
        return windowInsetsCompatOnApplyWindowInsets;
    }
}
