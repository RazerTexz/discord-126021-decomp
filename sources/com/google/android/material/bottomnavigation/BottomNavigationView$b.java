package com.google.android.material.bottomnavigation;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;

/* JADX INFO: loaded from: classes3.dex */
public class BottomNavigationView$b implements ViewUtils$OnApplyWindowInsetsListener {
    public BottomNavigationView$b(BottomNavigationView bottomNavigationView) {
    }

    @Override // com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils$RelativePadding viewUtils$RelativePadding) {
        viewUtils$RelativePadding.bottom = windowInsetsCompat.getSystemWindowInsetBottom() + viewUtils$RelativePadding.bottom;
        boolean z2 = ViewCompat.getLayoutDirection(view) == 1;
        int systemWindowInsetLeft = windowInsetsCompat.getSystemWindowInsetLeft();
        int systemWindowInsetRight = windowInsetsCompat.getSystemWindowInsetRight();
        viewUtils$RelativePadding.start += z2 ? systemWindowInsetRight : systemWindowInsetLeft;
        int i = viewUtils$RelativePadding.end;
        if (!z2) {
            systemWindowInsetLeft = systemWindowInsetRight;
        }
        viewUtils$RelativePadding.end = i + systemWindowInsetLeft;
        viewUtils$RelativePadding.applyToView(view);
        return windowInsetsCompat;
    }
}
