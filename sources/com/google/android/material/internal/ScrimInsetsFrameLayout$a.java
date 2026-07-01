package com.google.android.material.internal;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ScrimInsetsFrameLayout$a implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ScrimInsetsFrameLayout a;

    public ScrimInsetsFrameLayout$a(ScrimInsetsFrameLayout scrimInsetsFrameLayout) {
        this.a = scrimInsetsFrameLayout;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
        ScrimInsetsFrameLayout scrimInsetsFrameLayout = this.a;
        if (scrimInsetsFrameLayout.insets == null) {
            scrimInsetsFrameLayout.insets = new Rect();
        }
        this.a.insets.set(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        this.a.onInsetsChanged(windowInsetsCompat);
        this.a.setWillNotDraw(!windowInsetsCompat.hasSystemWindowInsets() || this.a.insetForeground == null);
        ViewCompat.postInvalidateOnAnimation(this.a);
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
