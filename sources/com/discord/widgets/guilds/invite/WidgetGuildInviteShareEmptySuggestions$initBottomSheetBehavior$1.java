package com.discord.widgets.guilds.invite;

import android.view.View;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildInviteShareEmptySuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareEmptySuggestions$initBottomSheetBehavior$1 extends BottomSheetBehavior$BottomSheetCallback {
    public final /* synthetic */ WidgetGuildInviteShareEmptySuggestions this$0;

    public WidgetGuildInviteShareEmptySuggestions$initBottomSheetBehavior$1(WidgetGuildInviteShareEmptySuggestions widgetGuildInviteShareEmptySuggestions) {
        this.this$0 = widgetGuildInviteShareEmptySuggestions;
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onSlide(View bottomSheet, float slideOffset) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetBehavior$BottomSheetCallback
    public void onStateChanged(View bottomSheet, int newState) {
        m.checkNotNullParameter(bottomSheet, "bottomSheet");
        if (newState == 5) {
            WidgetGuildInviteShareEmptySuggestions.access$getViewModel$p(this.this$0).refreshUi();
        }
        ViewExtensions.fadeBy$default(WidgetGuildInviteShareEmptySuggestions.access$getBinding$p(this.this$0).f2420b, newState != 5, 0L, 2, null);
    }
}
