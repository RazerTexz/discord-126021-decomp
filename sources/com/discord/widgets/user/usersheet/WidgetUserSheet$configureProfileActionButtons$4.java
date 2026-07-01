package com.discord.widgets.user.usersheet;

import android.content.Context;
import android.view.View;
import android.view.View$OnClickListener;
import com.discord.app.AppActivity;
import com.discord.stores.StoreNavigation$PanelAction;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetUserSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetUserSheet$configureProfileActionButtons$4 implements View$OnClickListener {
    public final /* synthetic */ WidgetUserSheetViewModel$ViewState$Loaded $viewState;
    public final /* synthetic */ WidgetUserSheet this$0;

    public WidgetUserSheet$configureProfileActionButtons$4(WidgetUserSheet widgetUserSheet, WidgetUserSheetViewModel$ViewState$Loaded widgetUserSheetViewModel$ViewState$Loaded) {
        this.this$0 = widgetUserSheet;
        this.$viewState = widgetUserSheetViewModel$ViewState$Loaded;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        ChannelSelector channelSelector$Companion = ChannelSelector.Companion.getInstance();
        Context contextRequireContext = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext, "this@WidgetUserSheet.requireContext()");
        channelSelector$Companion.findAndSetDirectMessage(contextRequireContext, this.$viewState.getUser().getId());
        this.this$0.dismiss();
        StoreTabsNavigation.selectHomeTab$default(StoreStream.Companion.getTabsNavigation(), StoreNavigation$PanelAction.CLOSE, false, 2, null);
        AppActivity appActivityRequireAppActivity = this.this$0.requireAppActivity();
        Context contextRequireContext2 = this.this$0.requireContext();
        m.checkNotNullExpressionValue(contextRequireContext2, "requireContext()");
        appActivityRequireAppActivity.j(contextRequireContext2);
    }
}
