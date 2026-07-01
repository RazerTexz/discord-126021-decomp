package com.discord.widgets.voice.fullscreen;

import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Type;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$onViewBound$1 implements OnApplyWindowInsetsListener {
    public static final WidgetCallPreviewFullscreen$onViewBound$1 INSTANCE = new WidgetCallPreviewFullscreen$onViewBound$1();

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat$Type.systemBars());
        m.checkNotNullExpressionValue(insets, "windowInsets.getInsets(W…Compat.Type.systemBars())");
        m.checkNotNullExpressionValue(view, "view");
        ViewGroup$LayoutParams layoutParams = view.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        ConstraintLayout$LayoutParams constraintLayout$LayoutParams = (ConstraintLayout$LayoutParams) layoutParams;
        ((ViewGroup$MarginLayoutParams) constraintLayout$LayoutParams).bottomMargin = insets.bottom;
        constraintLayout$LayoutParams.setMarginStart(insets.left);
        constraintLayout$LayoutParams.setMarginEnd(insets.right);
        view.setLayoutParams(constraintLayout$LayoutParams);
        return windowInsetsCompat;
    }
}
