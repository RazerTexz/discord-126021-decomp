package com.discord.widgets.chat.list.sheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetApplicationCommandBottomSheet$configureLoaded$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetApplicationCommandBottomSheet this$0;

    public WidgetApplicationCommandBottomSheet$configureLoaded$1(WidgetApplicationCommandBottomSheet widgetApplicationCommandBottomSheet, WidgetApplicationCommandBottomSheetViewModel$ViewState$Loaded widgetApplicationCommandBottomSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetApplicationCommandBottomSheet;
        this.$viewState = widgetApplicationCommandBottomSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "requireContext()");
        b.a.d.m.c(contextRequireContext, WidgetApplicationCommandBottomSheetKt.toSlashCommandCopyString(this.$viewState.getApplicationCommandData(), this.$viewState.getCommandValues()), 0, 4);
        this.this$0.dismiss();
    }
}
