package com.discord.widgets.user.usersheet;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureIncomingFriendRequest$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureIncomingFriendRequest$1(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetUserSheet;
        this.$viewState = widgetUserSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetUserSheet.access$acceptFriendRequest(this.this$0, this.$viewState.getUser().getUsername());
    }
}
