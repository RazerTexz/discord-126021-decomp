package com.discord.widgets.chat.input;

import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets$Type;
import android.view.WindowInsetsAnimation;
import android.view.WindowInsetsAnimation$Bounds;
import android.view.WindowInsetsAnimation$Callback;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: SmoothKeyboardReactionHelper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SmoothKeyboardReactionHelper$Callback extends WindowInsetsAnimation$Callback {
    private final View view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SmoothKeyboardReactionHelper$Callback(View view) {
        super(0);
        m.checkNotNullParameter(view, "view");
        this.view = view;
    }

    @Override // android.view.WindowInsetsAnimation$Callback
    public WindowInsets onProgress(WindowInsets insets, List<WindowInsetsAnimation> runningAnimations) {
        m.checkNotNullParameter(insets, "insets");
        m.checkNotNullParameter(runningAnimations, "runningAnimations");
        return insets;
    }

    @Override // android.view.WindowInsetsAnimation$Callback
    public WindowInsetsAnimation$Bounds onStart(WindowInsetsAnimation animation, WindowInsetsAnimation$Bounds bounds) {
        m.checkNotNullParameter(animation, "animation");
        m.checkNotNullParameter(bounds, "bounds");
        if (this.view.getRootWindowInsets().isVisible(WindowInsets$Type.ime())) {
            this.view.setTranslationY(bounds.getUpperBound().bottom);
        } else {
            this.view.setTranslationY(-bounds.getUpperBound().bottom);
        }
        this.view.animate().setDuration(animation.getDurationMillis()).setInterpolator(animation.getInterpolator()).translationY(0.0f);
        WindowInsetsAnimation$Bounds windowInsetsAnimation$BoundsOnStart = super.onStart(animation, bounds);
        m.checkNotNullExpressionValue(windowInsetsAnimation$BoundsOnStart, "super.onStart(animation, bounds)");
        return windowInsetsAnimation$BoundsOnStart;
    }
}
