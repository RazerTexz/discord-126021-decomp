package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$initializeSystemUiListeners$1 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$initializeSystemUiListeners$1(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        WidgetCallFullscreen.access$setSystemWindowInsets$p(this.this$0, windowInsetsCompat);
        WidgetCallFullscreen.access$setVoiceControlsSheetPeekHeight(this.this$0);
        m.checkNotNullExpressionValue(view, "view");
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), this.this$0.getResources().getDimensionPixelSize(2131165802) + windowInsetsCompat.getSystemWindowInsetBottom());
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams;
        viewGroup$MarginLayoutParams.leftMargin = windowInsetsCompat.getSystemWindowInsetLeft();
        viewGroup$MarginLayoutParams.rightMargin = windowInsetsCompat.getSystemWindowInsetRight();
        view.setLayoutParams(viewGroup$MarginLayoutParams);
        return windowInsetsCompat;
    }
}
