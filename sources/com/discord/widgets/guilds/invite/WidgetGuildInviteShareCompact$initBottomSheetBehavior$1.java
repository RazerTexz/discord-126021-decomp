package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$initBottomSheetBehavior$1 extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ WidgetGuildInviteShareCompact this$0;

    public WidgetGuildInviteShareCompact$initBottomSheetBehavior$1(WidgetGuildInviteShareCompact widgetGuildInviteShareCompact) {
        this.this$0 = widgetGuildInviteShareCompact;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(View bottomSheet, float slideOffset) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(View bottomSheet, int newState) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
        if (newState == 5) {
            WidgetGuildInviteShareCompact.access$getViewModel$p(this.this$0).refreshUi();
        }
        ViewExtensions.fadeBy$default(WidgetGuildInviteShareCompact.access$getBinding$p(this.this$0).f2419b, newState != 5, 0L, 2, null);
    }
}
