package com.discord.widgets.voice.fullscreen;

import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.discord.utilities.dimen.DimenUtils;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$initializeSystemUiListeners$3 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$initializeSystemUiListeners$3(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        m.checkNotNullExpressionValue(view, "view");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) layoutParams;
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
        WidgetCallFullscreen$Companion widgetCallFullscreen$Companion = WidgetCallFullscreen.Companion;
        Resources resources = this.this$0.getResources();
        m.checkNotNullExpressionValue(resources, "resources");
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).leftMargin = DimenUtils.dpToPixels(widgetCallFullscreen$Companion.getUnreadIndicatorMarginLeftDp(resources)) + systemWindowInsetLeft;
        int systemWindowInsetTop = windowInsetsCompat.getSystemWindowInsetTop();
        Resources resources2 = this.this$0.getResources();
        m.checkNotNullExpressionValue(resources2, "resources");
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).topMargin = DimenUtils.dpToPixels(widgetCallFullscreen$Companion.getUnreadIndicatorMarginDp(resources2)) + systemWindowInsetTop;
        view.setLayoutParams(constraintLayout$LayoutParams);
        return windowInsetsCompat;
    }
}
