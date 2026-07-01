package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppToast;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.permission.Permission;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.channel.ChannelInviteLaunchUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventListItem;
import d0.t.Iterables2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventListViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Long channelId;
    private final StoreChannels channelsStore;
    private final long guildId;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private final StoreGuilds guildsStore;
    private final StorePermissions permissionsStore;
    private final StoreUser userStore;
    private final StoreVoiceChannelSelected voiceChannelSelectedStore;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventListViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildScheduledEventListViewModel guildScheduledEventListViewModel) {
            super(1, guildScheduledEventListViewModel, GuildScheduledEventListViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventListViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((GuildScheduledEventListViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long guildId, Long channelId, StoreGuildScheduledEvents guildScheduledEventsStore, StoreChannels channelStore, StorePermissions permissionsStore, StoreGuilds guildStore, StoreVoiceChannelSelected voiceChannelSelectedStore, StoreUser userStore) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildScheduledEventsStore, channelStore, permissionsStore, guildStore, voiceChannelSelectedStore, userStore}, false, null, null, new GuildScheduledEventListViewModel2(channelStore, guildId, guildScheduledEventsStore, channelId, userStore, guildStore, permissionsStore, voiceChannelSelectedStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean canCreateEvents;
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, UserGuildMember> creators;
        private final Map<Long, Channel> guildChannels;
        private final List<GuildScheduledEvent> guildScheduledEvents;
        private final Long selectedVoiceChannelId;
        private final Set<Long> userGuildScheduledEventIds;

        public StoreState(List<GuildScheduledEvent> list, Set<Long> set, Map<Long, Channel> map, Map<Long, UserGuildMember> map2, boolean z2, Long l, Map<Long, Long> map3) {
            Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
            Intrinsics3.checkNotNullParameter(set, "userGuildScheduledEventIds");
            Intrinsics3.checkNotNullParameter(map, "guildChannels");
            Intrinsics3.checkNotNullParameter(map2, "creators");
            Intrinsics3.checkNotNullParameter(map3, "channelPermissions");
            this.guildScheduledEvents = list;
            this.userGuildScheduledEventIds = set;
            this.guildChannels = map;
            this.creators = map2;
            this.canCreateEvents = z2;
            this.selectedVoiceChannelId = l;
            this.channelPermissions = map3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, List list, Set set, Map map, Map map2, boolean z2, Long l, Map map3, int i, Object obj) {
            if ((i & 1) != 0) {
                list = storeState.guildScheduledEvents;
            }
            if ((i & 2) != 0) {
                set = storeState.userGuildScheduledEventIds;
            }
            Set set2 = set;
            if ((i & 4) != 0) {
                map = storeState.guildChannels;
            }
            Map map4 = map;
            if ((i & 8) != 0) {
                map2 = storeState.creators;
            }
            Map map5 = map2;
            if ((i & 16) != 0) {
                z2 = storeState.canCreateEvents;
            }
            boolean z3 = z2;
            if ((i & 32) != 0) {
                l = storeState.selectedVoiceChannelId;
            }
            Long l2 = l;
            if ((i & 64) != 0) {
                map3 = storeState.channelPermissions;
            }
            return storeState.copy(list, set2, map4, map5, z3, l2, map3);
        }

        public final List<GuildScheduledEvent> component1() {
            return this.guildScheduledEvents;
        }

        public final Set<Long> component2() {
            return this.userGuildScheduledEventIds;
        }

        public final Map<Long, Channel> component3() {
            return this.guildChannels;
        }

        public final Map<Long, UserGuildMember> component4() {
            return this.creators;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanCreateEvents() {
            return this.canCreateEvents;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Map<Long, Long> component7() {
            return this.channelPermissions;
        }

        public final StoreState copy(List<GuildScheduledEvent> guildScheduledEvents, Set<Long> userGuildScheduledEventIds, Map<Long, Channel> guildChannels, Map<Long, UserGuildMember> creators, boolean canCreateEvents, Long selectedVoiceChannelId, Map<Long, Long> channelPermissions) {
            Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
            Intrinsics3.checkNotNullParameter(userGuildScheduledEventIds, "userGuildScheduledEventIds");
            Intrinsics3.checkNotNullParameter(guildChannels, "guildChannels");
            Intrinsics3.checkNotNullParameter(creators, "creators");
            Intrinsics3.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new StoreState(guildScheduledEvents, userGuildScheduledEventIds, guildChannels, creators, canCreateEvents, selectedVoiceChannelId, channelPermissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.guildScheduledEvents, storeState.guildScheduledEvents) && Intrinsics3.areEqual(this.userGuildScheduledEventIds, storeState.userGuildScheduledEventIds) && Intrinsics3.areEqual(this.guildChannels, storeState.guildChannels) && Intrinsics3.areEqual(this.creators, storeState.creators) && this.canCreateEvents == storeState.canCreateEvents && Intrinsics3.areEqual(this.selectedVoiceChannelId, storeState.selectedVoiceChannelId) && Intrinsics3.areEqual(this.channelPermissions, storeState.channelPermissions);
        }

        public final boolean getCanCreateEvents() {
            return this.canCreateEvents;
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, UserGuildMember> getCreators() {
            return this.creators;
        }

        public final Map<Long, Channel> getGuildChannels() {
            return this.guildChannels;
        }

        public final List<GuildScheduledEvent> getGuildScheduledEvents() {
            return this.guildScheduledEvents;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        public final Set<Long> getUserGuildScheduledEventIds() {
            return this.userGuildScheduledEventIds;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v20 */
        public int hashCode() {
            List<GuildScheduledEvent> list = this.guildScheduledEvents;
            int iHashCode = (list != null ? list.hashCode() : 0) * 31;
            Set<Long> set = this.userGuildScheduledEventIds;
            int iHashCode2 = (iHashCode + (set != null ? set.hashCode() : 0)) * 31;
            Map<Long, Channel> map = this.guildChannels;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, UserGuildMember> map2 = this.creators;
            int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
            boolean z2 = this.canCreateEvents;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode4 + r2) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode5 = (i + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Long> map3 = this.channelPermissions;
            return iHashCode5 + (map3 != null ? map3.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildScheduledEvents=");
            sbU.append(this.guildScheduledEvents);
            sbU.append(", userGuildScheduledEventIds=");
            sbU.append(this.userGuildScheduledEventIds);
            sbU.append(", guildChannels=");
            sbU.append(this.guildChannels);
            sbU.append(", creators=");
            sbU.append(this.creators);
            sbU.append(", canCreateEvents=");
            sbU.append(this.canCreateEvents);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", channelPermissions=");
            return outline.M(sbU, this.channelPermissions, ")");
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
        public static final class Initial extends ViewState {
            public static final Initial INSTANCE = new Initial();

            private Initial() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canCreateEvents;
            private final List<GuildScheduledEventListItem.Event> guildScheduledEvents;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<GuildScheduledEventListItem.Event> list, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "guildScheduledEvents");
                this.guildScheduledEvents = list;
                this.canCreateEvents = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.guildScheduledEvents;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.canCreateEvents;
                }
                return loaded.copy(list, z2);
            }

            public final List<GuildScheduledEventListItem.Event> component1() {
                return this.guildScheduledEvents;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanCreateEvents() {
                return this.canCreateEvents;
            }

            public final Loaded copy(List<GuildScheduledEventListItem.Event> guildScheduledEvents, boolean canCreateEvents) {
                Intrinsics3.checkNotNullParameter(guildScheduledEvents, "guildScheduledEvents");
                return new Loaded(guildScheduledEvents, canCreateEvents);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.guildScheduledEvents, loaded.guildScheduledEvents) && this.canCreateEvents == loaded.canCreateEvents;
            }

            public final boolean getCanCreateEvents() {
                return this.canCreateEvents;
            }

            public final List<GuildScheduledEventListItem.Event> getGuildScheduledEvents() {
                return this.guildScheduledEvents;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                List<GuildScheduledEventListItem.Event> list = this.guildScheduledEvents;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                boolean z2 = this.canCreateEvents;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(guildScheduledEvents=");
                sbU.append(this.guildScheduledEvents);
                sbU.append(", canCreateEvents=");
                return outline.O(sbU, this.canCreateEvents, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventListViewModel$onShareClicked$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildScheduledEventListViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Channel, Unit> {
        public final /* synthetic */ Channel $channel;
        public final /* synthetic */ long $guildEventId;
        public final /* synthetic */ WeakReference $weakFragment;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(WeakReference weakReference, Channel channel, long j) {
            super(1);
            this.$weakFragment = weakReference;
            this.$channel = channel;
            this.$guildEventId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
            invoke2(channel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Channel channel) {
            Fragment fragment = (Fragment) this.$weakFragment.get();
            if (fragment != null) {
                ChannelInviteLaunchUtils channelInviteLaunchUtils = ChannelInviteLaunchUtils.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(fragment, "fragment");
                Channel channel2 = this.$channel;
                channelInviteLaunchUtils.inviteToChannel(fragment, channel2 != null ? channel2 : channel, GuildScheduledEventUtilities.ANALYTICS_SOURCE, (24 & 8) != 0 ? null : Long.valueOf(this.$guildEventId), (24 & 16) != 0 ? null : null);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildScheduledEventListViewModel(long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreGuildScheduledEvents guildScheduledEvents = (i & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreChannels channels = (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreGuilds guilds = (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreVoiceChannelSelected voiceChannelSelected = (i & 64) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreUser users = (i & 128) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        this(j, l, guildScheduledEvents, channels, permissions, guilds, voiceChannelSelected, users, (i & 256) != 0 ? INSTANCE.observeStores(j, l, guildScheduledEvents, channels, permissions, guilds, voiceChannelSelected, users) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (!(getViewState() instanceof ViewState.Loaded)) {
            AnalyticsTracker.INSTANCE.openGuildScheduledEventSheet(this.guildId, storeState.getGuildScheduledEvents().size());
        }
        List<GuildScheduledEvent> guildScheduledEvents = storeState.getGuildScheduledEvents();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(guildScheduledEvents, 10));
        for (GuildScheduledEvent guildScheduledEvent : guildScheduledEvents) {
            Long channelId = guildScheduledEvent.getChannelId();
            Channel channel = channelId != null ? storeState.getGuildChannels().get(Long.valueOf(channelId.longValue())) : null;
            Long creatorId = guildScheduledEvent.getCreatorId();
            UserGuildMember userGuildMember = creatorId != null ? storeState.getCreators().get(Long.valueOf(creatorId.longValue())) : null;
            boolean zContains = storeState.getUserGuildScheduledEventIds().contains(Long.valueOf(guildScheduledEvent.getId()));
            GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
            boolean zCanStartEvent$default = GuildScheduledEventUtilities.Companion.canStartEvent$default(companion, this.guildId, channel != null ? Long.valueOf(channel.getId()) : null, null, null, 12, null);
            boolean zCanShareEvent = companion.canShareEvent(channel != null ? Long.valueOf(channel.getId()) : null, this.guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null);
            Long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
            if (selectedVoiceChannelId != null) {
                long jLongValue = selectedVoiceChannelId.longValue();
                Long channelId2 = guildScheduledEvent.getChannelId();
                z2 = channelId2 != null && jLongValue == channelId2.longValue();
            } else {
                z2 = false;
            }
            Long channelId3 = guildScheduledEvent.getChannelId();
            arrayList.add(new GuildScheduledEventListItem.Event(guildScheduledEvent, channel, userGuildMember, zContains, zCanStartEvent$default, zCanShareEvent, z2, channelId3 != null ? PermissionUtils.can(Permission.CONNECT, storeState.getChannelPermissions().get(Long.valueOf(channelId3.longValue()))) : false));
        }
        updateViewState(new ViewState.Loaded(arrayList, storeState.getCanCreateEvents()));
    }

    public final void onShareClicked(GuildScheduledEvent guildScheduledEvent, WeakReference<Context> weakContext, WeakReference<Fragment> weakFragment) {
        Channel channel;
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        Intrinsics3.checkNotNullParameter(weakContext, "weakContext");
        Intrinsics3.checkNotNullParameter(weakFragment, "weakFragment");
        long guildId = guildScheduledEvent.getGuildId();
        long id2 = guildScheduledEvent.getId();
        Long channelId = guildScheduledEvent.getChannelId();
        boolean zCanShareEvent = GuildScheduledEventUtilities.INSTANCE.canShareEvent(channelId, guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null);
        if (channelId != null) {
            channel = this.channelsStore.getChannel(channelId.longValue());
        } else {
            channel = null;
        }
        if (zCanShareEvent) {
            Observable<Channel> observableZ = StoreStream.INSTANCE.getChannels().observeDefaultChannel(guildId).z();
            Intrinsics3.checkNotNullExpressionValue(observableZ, "StoreStream.getChannels(…ildId)\n          .first()");
            ObservableExtensionsKt.appSubscribe(observableZ, (Class<?>) GuildScheduledEventListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(weakFragment, channel, id2));
        } else {
            Context context = weakContext.get();
            if (context != null) {
                CharSequence eventDetailsUrl = GuildScheduledEventUrlUtils.INSTANCE.getEventDetailsUrl(guildId, id2);
                Intrinsics3.checkNotNullExpressionValue(context, "context");
                AppToast.c(context, eventDetailsUrl, 0, 4);
            }
        }
    }

    public final void toggleRsvp(GuildScheduledEvent guildScheduledEvent) {
        Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
        this.guildScheduledEventsStore.toggleMeRsvpForEvent(guildScheduledEvent);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventListViewModel(long j, Long l, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreUser storeUser, Observable<StoreState> observable) {
        super(ViewState.Initial.INSTANCE);
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "voiceChannelSelectedStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = l;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.channelsStore = storeChannels;
        this.permissionsStore = storePermissions;
        this.guildsStore = storeGuilds;
        this.voiceChannelSelectedStore = storeVoiceChannelSelected;
        this.userStore = storeUser;
        storeGuildScheduledEvents.fetchGuildScheduledEventUserCounts(j);
        storeGuildScheduledEvents.fetchMeGuildScheduledEvents(j);
        storeGuildScheduledEvents.ackGuildEvents(j);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildScheduledEventListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
