package com.discord.app;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface$OnShowListener;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import d0.z.d.m;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$f implements DialogInterface$OnShowListener {
    public final /* synthetic */ Dialog a;

    public AppBottomSheet$f(Dialog dialog) {
        this.a = dialog;
    }

    @Override // android.content.DialogInterface$OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        BottomSheetBehavior bottomSheetBehaviorFrom = BottomSheetBehavior.from(this.a.findViewById(2131363003));
        m.checkNotNullExpressionValue(bottomSheetBehaviorFrom, "BottomSheetBehavior.from(bottomSheet)");
        bottomSheetBehaviorFrom.setSkipCollapsed(true);
        bottomSheetBehaviorFrom.setState(3);
    }
}
