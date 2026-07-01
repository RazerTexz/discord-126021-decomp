package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener;
import com.google.android.material.internal.ViewUtils$RelativePadding;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetBehavior$c implements ViewUtils$OnApplyWindowInsetsListener {
    public final /* synthetic */ BottomSheetBehavior a;

    public BottomSheetBehavior$c(BottomSheetBehavior bottomSheetBehavior) {
        this.a = bottomSheetBehavior;
    }

    @Override // com.google.android.material.internal.ViewUtils$OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils$RelativePadding viewUtils$RelativePadding) {
        BottomSheetBehavior.access$102(this.a, windowInsetsCompat.getMandatorySystemGestureInsets().bottom);
        BottomSheetBehavior.access$200(this.a, false);
        return windowInsetsCompat;
    }
}
