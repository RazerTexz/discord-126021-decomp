package com.discord.app;

import android.view.View;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import d0.z.d.m;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$d extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ AppBottomSheet a;

    public AppBottomSheet$d(AppBottomSheet appBottomSheet) {
        this.a = appBottomSheet;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(View view, float f) {
        m.checkNotNullParameter(view, "bottomSheet");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(View view, int i) {
        m.checkNotNullParameter(view, "bottomSheet");
        this.a.onStateChanged(i);
        if (i == 5) {
            this.a.dismiss();
        }
    }
}
