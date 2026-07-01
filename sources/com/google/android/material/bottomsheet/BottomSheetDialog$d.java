package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialog$d extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ BottomSheetDialog a;

    public BottomSheetDialog$d(BottomSheetDialog bottomSheetDialog) {
        this.a = bottomSheetDialog;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(@NonNull View view, float f) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(@NonNull View view, int i) {
        if (i == 5) {
            this.a.cancel();
        }
    }
}
