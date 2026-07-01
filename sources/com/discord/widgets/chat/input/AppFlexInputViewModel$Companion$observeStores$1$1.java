package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft;
import com.discord.stores.StoreNotices$Notice;
import d0.z.d.m;
import rx.functions.Func6;

/* JADX INFO: compiled from: AppFlexInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AppFlexInputViewModel$Companion$observeStores$1$1<T1, T2, T3, T4, T5, T6, R> implements Func6<PanelState, PanelState, Long, StoreNotices$Notice, Boolean, Boolean, AppFlexInputViewModel$StoreState> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ StoreChannelsSelected$ResolvedSelectedChannel $selectedChannel;

    public AppFlexInputViewModel$Companion$observeStores$1$1(Channel channel, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        this.$channel = channel;
        this.$selectedChannel = storeChannelsSelected$ResolvedSelectedChannel;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ AppFlexInputViewModel$StoreState call(PanelState panelState, PanelState panelState2, Long l, StoreNotices$Notice storeNotices$Notice, Boolean bool, Boolean bool2) {
        return call2(panelState, panelState2, l, storeNotices$Notice, bool, bool2);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0028  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final AppFlexInputViewModel$StoreState call2(PanelState panelState, PanelState panelState2, Long l, StoreNotices$Notice storeNotices$Notice, Boolean bool, Boolean bool2) {
        boolean z2;
        m.checkNotNullExpressionValue(panelState, "leftPanelState");
        m.checkNotNullExpressionValue(panelState2, "rightPanelState");
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(bool, "stickerSuggestionsEnabled");
        if (bool.booleanValue()) {
            m.checkNotNullExpressionValue(bool2, "expressionSuggestionsEnabled");
            if (bool2.booleanValue()) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        return new AppFlexInputViewModel$StoreState(panelState, panelState2, channel, l, storeNotices$Notice, z2, this.$selectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$ThreadDraft);
    }
}
