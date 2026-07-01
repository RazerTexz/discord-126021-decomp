package com.discord.app;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.display.DisplayUtils;
import com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior;
import d0.z.d.m;

/* JADX INFO: compiled from: AppScrollingViewBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScrollingViewBehavior extends AppBarLayout$ScrollingViewBehavior {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final AppScrollingViewBehavior$a onApplyWindowInsetsListener;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(attributeSet, "attrs");
        this.onApplyWindowInsetsListener = new AppScrollingViewBehavior$a();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        m.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        m.checkNotNullParameter(child, "child");
        m.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        this.onApplyWindowInsetsListener.onApplyWindowInsets(child, insets);
        return insets;
    }
}
