package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteShare.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShare$initBottomSheetBehavior$1 extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ WidgetGuildInviteShare this$0;

    public WidgetGuildInviteShare$initBottomSheetBehavior$1(WidgetGuildInviteShare widgetGuildInviteShare) {
        this.this$0 = widgetGuildInviteShare;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(View bottomSheet, float slideOffset) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(View bottomSheet, int newState) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
        if (newState == 5) {
            WidgetGuildInviteShare.access$getViewModel$p(this.this$0).refreshUi();
            WidgetGuildInviteShare.access$getBinding$p(this.this$0).f.sendAccessibilityEvent(8);
        } else if (newState == 3) {
            WidgetGuildInviteShare.access$getBinding$p(this.this$0).k.sendAccessibilityEvent(8);
            this.this$0.getAppLogger().a(null);
        }
        ViewExtensions.fadeBy$default(WidgetGuildInviteShare.access$getBinding$p(this.this$0).f2418b, newState != 5, 0L, 2, null);
    }
}
