package com.discord.widgets.home;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel$Channel;
import com.discord.stores.StoreUserConnections$State;
import d0.z.d.m;
import rx.functions.Func8;

/* JADX INFO: compiled from: WidgetHomeViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHomeViewModel$Companion$observeStoreState$1<T1, T2, T3, T4, T5, T6, T7, T8, R> implements Func8<PanelState, PanelState, WidgetHomeViewModel$GuildInfo, MeUser, StoreChannelsSelected$ResolvedSelectedChannel, Experiment, StoreUserConnections$State, Experiment, WidgetHomeViewModel$StoreState> {
    public static final WidgetHomeViewModel$Companion$observeStoreState$1 INSTANCE = new WidgetHomeViewModel$Companion$observeStoreState$1();

    @Override // rx.functions.Func8
    public /* bridge */ /* synthetic */ WidgetHomeViewModel$StoreState call(PanelState panelState, PanelState panelState2, WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo, MeUser meUser, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Experiment experiment, StoreUserConnections$State storeUserConnections$State, Experiment experiment2) {
        return call2(panelState, panelState2, widgetHomeViewModel$GuildInfo, meUser, storeChannelsSelected$ResolvedSelectedChannel, experiment, storeUserConnections$State, experiment2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetHomeViewModel$StoreState call2(PanelState panelState, PanelState panelState2, WidgetHomeViewModel$GuildInfo widgetHomeViewModel$GuildInfo, MeUser meUser, StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel, Experiment experiment, StoreUserConnections$State storeUserConnections$State, Experiment experiment2) {
        Channel maybeChannel = storeChannelsSelected$ResolvedSelectedChannel.getMaybeChannel();
        boolean z2 = maybeChannel != null && maybeChannel.getNsfw();
        NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
        if (!(storeChannelsSelected$ResolvedSelectedChannel instanceof StoreChannelsSelected$ResolvedSelectedChannel$Channel)) {
            storeChannelsSelected$ResolvedSelectedChannel = null;
        }
        StoreChannelsSelected$ResolvedSelectedChannel$Channel storeChannelsSelected$ResolvedSelectedChannel$Channel = (StoreChannelsSelected$ResolvedSelectedChannel$Channel) storeChannelsSelected$ResolvedSelectedChannel;
        boolean z3 = (storeChannelsSelected$ResolvedSelectedChannel$Channel != null ? storeChannelsSelected$ResolvedSelectedChannel$Channel.getPeekParent() : null) != null;
        m.checkNotNullExpressionValue(panelState, "leftPanelState");
        m.checkNotNullExpressionValue(panelState2, "rightPanelState");
        m.checkNotNullExpressionValue(widgetHomeViewModel$GuildInfo, "guildInfo");
        m.checkNotNullExpressionValue(meUser, "me");
        boolean z4 = experiment != null && experiment.getBucket() == 1;
        long guildId = widgetHomeViewModel$GuildInfo.getGuildId();
        m.checkNotNullExpressionValue(storeUserConnections$State, "connectedAccounts");
        return new WidgetHomeViewModel$StoreState(panelState, panelState2, widgetHomeViewModel$GuildInfo, meUser, z3, z4, z2, nsfwAllowance, guildId, storeUserConnections$State);
    }
}
