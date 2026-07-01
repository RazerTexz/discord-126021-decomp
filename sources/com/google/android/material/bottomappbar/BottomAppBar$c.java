package com.google.android.material.bottomappbar;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;

/* JADX INFO: loaded from: classes3.dex */
public class BottomAppBar$c implements ViewUtils$OnApplyWindowInsetsListener {
    public final /* synthetic */ BottomAppBar a;

    public BottomAppBar$c(BottomAppBar bottomAppBar) {
        this.a = bottomAppBar;
    }

    @Override // com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener
    @NonNull
    public WindowInsetsCompat onApplyWindowInsets(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull ViewUtils$RelativePadding viewUtils$RelativePadding) {
        boolean z2;
        if (BottomAppBar.access$600(this.a)) {
            BottomAppBar.access$702(this.a, windowInsetsCompat.getSystemWindowInsetBottom());
        }
        boolean z3 = false;
        if (BottomAppBar.access$800(this.a)) {
            z2 = BottomAppBar.access$900(this.a) != windowInsetsCompat.getSystemWindowInsetLeft();
            BottomAppBar.access$902(this.a, windowInsetsCompat.getSystemWindowInsetLeft());
        } else {
            z2 = false;
        }
        if (BottomAppBar.access$1000(this.a)) {
            boolean z4 = BottomAppBar.access$1100(this.a) != windowInsetsCompat.getSystemWindowInsetRight();
            BottomAppBar.access$1102(this.a, windowInsetsCompat.getSystemWindowInsetRight());
            z3 = z4;
        }
        if (z2 || z3) {
            BottomAppBar.access$1200(this.a);
            BottomAppBar.access$1300(this.a);
            BottomAppBar.access$1400(this.a);
        }
        return windowInsetsCompat;
    }
}
