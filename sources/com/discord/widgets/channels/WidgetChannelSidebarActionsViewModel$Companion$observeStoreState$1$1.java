package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.panels.PanelState$c;
import com.discord.stores.StoreUser;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1<T, R> implements b<Channel, Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState>> {
    public final /* synthetic */ PanelState $panelState;
    public final /* synthetic */ WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1 this$0;

    public WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1(WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1 widgetChannelSidebarActionsViewModel$Companion$observeStoreState$1, PanelState panelState) {
        this.this$0 = widgetChannelSidebarActionsViewModel$Companion$observeStoreState$1;
        this.$panelState = panelState;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState> call(Channel channel) {
        return call2(channel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState> call2(Channel channel) {
        Observable<? extends WidgetChannelSidebarActionsViewModel$StoreState> kVar = channel == null ? new k<>(WidgetChannelSidebarActionsViewModel$StoreState$ChannelNotFound.INSTANCE) : Observable.i(this.this$0.$storeUserGuildSettings.observeGuildSettings(), StoreUser.observeMe$default(this.this$0.$storeUser, false, 1, null), this.this$0.$storeChannels.observeChannel(channel.getParentId()), new WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1$storeState$1(this, channel));
        return m.areEqual(this.$panelState, PanelState$c.a) ? kVar : kVar.Z(1);
    }
}
