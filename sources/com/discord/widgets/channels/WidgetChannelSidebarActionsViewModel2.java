package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import rx.Observable;
import rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel2<T, R> implements Func1<PanelState, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildNSFW;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static final class AnonymousClass1<T, R> implements Func1<Channel, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
        public final /* synthetic */ PanelState $panelState;

        public AnonymousClass1(PanelState panelState) {
            this.$panelState = panelState;
        }

        @Override // j0.k.Func1
        public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(final Channel channel) {
            Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> scalarSynchronousObservable = channel == null ? new ScalarSynchronousObservable<>(WidgetChannelSidebarActionsViewModel.StoreState.ChannelNotFound.INSTANCE) : Observable.i(WidgetChannelSidebarActionsViewModel2.this.$storeUserGuildSettings.observeGuildSettings(), StoreUser.observeMe$default(WidgetChannelSidebarActionsViewModel2.this.$storeUser, false, 1, null), WidgetChannelSidebarActionsViewModel2.this.$storeChannels.observeChannel(channel.getParentId()), new Func3<Map<Long, ? extends ModelNotificationSettings>, MeUser, Channel, WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound>() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1$storeState$1
                @Override // rx.functions.Func3
                public final WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound call(Map<Long, ? extends ModelNotificationSettings> map, MeUser meUser, Channel channel2) {
                    boolean zIsGuildNsfwGateAgreed = WidgetChannelSidebarActionsViewModel2.this.$storeGuildNSFW.isGuildNsfwGateAgreed(channel.getGuildId());
                    Channel channel3 = channel;
                    return new WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound(channel3, channel2, (ModelNotificationSettings) outline.c(channel3, map), channel.getNsfw() && (!zIsGuildNsfwGateAgreed || meUser.getNsfwAllowance() == NsfwAllowance.DISALLOWED));
                }
            });
            return Intrinsics3.areEqual(this.$panelState, PanelState.c.a) ? scalarSynchronousObservable : scalarSynchronousObservable.Z(1);
        }
    }

    public WidgetChannelSidebarActionsViewModel2(StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeUser = storeUser;
        this.$storeChannels = storeChannels;
        this.$storeGuildNSFW = storeGuildsNsfw;
    }

    @Override // j0.k.Func1
    public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(PanelState panelState) {
        return this.$storeChannelsSelected.observeSelectedChannel().Y(new AnonymousClass1(panelState));
    }
}
