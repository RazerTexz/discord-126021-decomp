package com.discord.app;

import android.view.View;
import android.view.View$OnLayoutChangeListener;

/* JADX INFO: compiled from: AppBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppBottomSheet$e implements View$OnLayoutChangeListener {
    public final /* synthetic */ AppBottomSheet j;

    public AppBottomSheet$e(AppBottomSheet appBottomSheet) {
        this.j = appBottomSheet;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.j.updatePeekHeightPx(i4);
    }
}
