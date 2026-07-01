package com.discord.app;

import android.view.View;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsCompat$Builder;
import d0.z.d.m;

/* JADX INFO: compiled from: java-style lambda group */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$a implements OnApplyWindowInsetsListener {
    public static final AppBottomSheet$a a = new AppBottomSheet$a(0);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final AppBottomSheet$a f2078b = new AppBottomSheet$a(1);
    public final /* synthetic */ int c;

    public AppBottomSheet$a(int i) {
        this.c = i;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        int i = this.c;
        if (i == 0) {
            m.checkNotNullParameter(view, "v");
            m.checkNotNullParameter(windowInsetsCompat, "insets");
            view.setPadding(view.getPaddingLeft(), windowInsetsCompat.getSystemWindowInsetTop(), view.getPaddingRight(), view.getPaddingBottom());
            return new WindowInsetsCompat$Builder(windowInsetsCompat).setSystemWindowInsets(Insets.of(windowInsetsCompat.getSystemWindowInsetLeft(), 0, windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom())).build();
        }
        if (i != 1) {
            throw null;
        }
        m.checkNotNullExpressionValue(view, "v");
        m.checkNotNullExpressionValue(windowInsetsCompat, "insets");
        view.setPadding(windowInsetsCompat.getSystemWindowInsetLeft(), windowInsetsCompat.getSystemWindowInsetTop(), windowInsetsCompat.getSystemWindowInsetRight(), windowInsetsCompat.getSystemWindowInsetBottom());
        return windowInsetsCompat.consumeSystemWindowInsets();
    }
}
