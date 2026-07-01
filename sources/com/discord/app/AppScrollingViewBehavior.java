package com.discord.app;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.display.DisplayUtils;
import com.google.android.material.appbar.AppBarLayout;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: AppScrollingViewBehavior.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {

    /* JADX INFO: renamed from: a, reason: from kotlin metadata */
    public final a onApplyWindowInsetsListener;

    /* JADX INFO: compiled from: AppScrollingViewBehavior.kt */
    public static final class a implements OnApplyWindowInsetsListener {
        public Rect a;

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            Intrinsics3.checkNotNullParameter(view, "v");
            Intrinsics3.checkNotNullParameter(windowInsetsCompat, "insets");
            if (this.a == null) {
                this.a = new Rect(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), view.getPaddingBottom());
            }
            Rect rect = this.a;
            if (rect == null) {
                rect = new Rect();
            }
            view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft() + rect.left, rect.top, windowInsetsCompat.getSystemWindowInsetRight() + rect.right, windowInsetsCompat.getSystemWindowInsetTop() + windowInsetsCompat.getSystemWindowInsetBottom() + rect.bottom);
            return windowInsetsCompat;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(attributeSet, "attrs");
        this.onApplyWindowInsetsListener = new a();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public WindowInsetsCompat onApplyWindowInsets(CoordinatorLayout coordinatorLayout, View child, WindowInsetsCompat insets) {
        Intrinsics3.checkNotNullParameter(coordinatorLayout, "coordinatorLayout");
        Intrinsics3.checkNotNullParameter(child, "child");
        Intrinsics3.checkNotNullParameter(insets, "insets");
        ViewCompat.setOnApplyWindowInsetsListener(child, DisplayUtils.getNO_OP_WINDOW_INSETS_LISTENER());
        this.onApplyWindowInsetsListener.onApplyWindowInsets(child, insets);
        return insets;
    }
}
