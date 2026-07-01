package com.google.android.material.bottomsheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class BottomSheetDialog$a implements View$OnClickListener {
    public final /* synthetic */ BottomSheetDialog j;

    public BottomSheetDialog$a(BottomSheetDialog bottomSheetDialog) {
        this.j = bottomSheetDialog;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        BottomSheetDialog bottomSheetDialog = this.j;
        if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && this.j.shouldWindowCloseOnTouchOutside()) {
            this.j.cancel();
        }
    }
}
