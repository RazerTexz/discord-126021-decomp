package com.discord.widgets.channels;

import androidx.core.app.NotificationCompat;
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
import java.util.Map;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.functions.Func3;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1 */
/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C7348x2d9fcf21<T, R> implements InterfaceC12589b<PanelState, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreChannelsSelected $storeChannelsSelected;
    public final /* synthetic */ StoreGuildsNsfw $storeGuildNSFW;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserGuildSettings $storeUserGuildSettings;

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static final class AnonymousClass1<T, R> implements InterfaceC12589b<Channel, Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState>> {
        public final /* synthetic */ PanelState $panelState;

        public AnonymousClass1(PanelState panelState) {
            this.$panelState = panelState;
        }

        @Override // p637j0.p641k.InterfaceC12589b
        public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(final Channel channel) {
            Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> c12721k = channel == null ? new C12721k<>(WidgetChannelSidebarActionsViewModel.StoreState.ChannelNotFound.INSTANCE) : Observable.m11075i(C7348x2d9fcf21.this.$storeUserGuildSettings.observeGuildSettings(), StoreUser.observeMe$default(C7348x2d9fcf21.this.$storeUser, false, 1, null), C7348x2d9fcf21.this.$storeChannels.observeChannel(channel.getParentId()), new Func3<Map<Long, ? extends ModelNotificationSettings>, MeUser, Channel, WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound>() { // from class: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$Companion$observeStoreState$1$1$storeState$1
                @Override // p658rx.functions.Func3
                public final WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound call(Map<Long, ? extends ModelNotificationSettings> map, MeUser meUser, Channel channel2) {
                    boolean zIsGuildNsfwGateAgreed = C7348x2d9fcf21.this.$storeGuildNSFW.isGuildNsfwGateAgreed(channel.getGuildId());
                    Channel channel3 = channel;
                    return new WidgetChannelSidebarActionsViewModel.StoreState.ChannelFound(channel3, channel2, (ModelNotificationSettings) C1643a.m843c(channel3, map), channel.getNsfw() && (!zIsGuildNsfwGateAgreed || meUser.getNsfwAllowance() == NsfwAllowance.DISALLOWED));
                }
            });
            return C12238m.areEqual(this.$panelState, PanelState.C5580c.f18642a) ? c12721k : c12721k.m11100Z(1);
        }
    }

    public C7348x2d9fcf21(StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreUser storeUser, StoreChannels storeChannels, StoreGuildsNsfw storeGuildsNsfw) {
        this.$storeChannelsSelected = storeChannelsSelected;
        this.$storeUserGuildSettings = storeUserGuildSettings;
        this.$storeUser = storeUser;
        this.$storeChannels = storeChannels;
        this.$storeGuildNSFW = storeGuildsNsfw;
    }

    @Override // p637j0.p641k.InterfaceC12589b
    public final Observable<? extends WidgetChannelSidebarActionsViewModel.StoreState> call(PanelState panelState) {
        return this.$storeChannelsSelected.observeSelectedChannel().m11099Y(new AnonymousClass1(panelState));
    }
}
