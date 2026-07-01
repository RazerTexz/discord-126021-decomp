package com.google.android.material.bottomsheet;

import android.view.View;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialogFragment$b extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ BottomSheetDialogFragment a;

    public BottomSheetDialogFragment$b(BottomSheetDialogFragment bottomSheetDialogFragment, BottomSheetDialogFragment$a bottomSheetDialogFragment$a) {
        this.a = bottomSheetDialogFragment;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(@NonNull View view, float f) {
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(@NonNull View view, int i) {
        if (i == 5) {
            BottomSheetDialogFragment.access$100(this.a);
        }
    }
}
