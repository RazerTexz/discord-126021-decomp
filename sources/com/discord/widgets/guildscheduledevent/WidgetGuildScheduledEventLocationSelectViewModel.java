package com.discord.widgets.guildscheduledevent;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.GuildFeature;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityMetadata;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventTiming;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilitiesKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildScheduledEventLocationSelectViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final StoreChannels channelsStore;
    private StoreState currentStoreState;
    private final Long existingGuildScheduledEventId;
    private final Long initialChannelId;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.WidgetGuildScheduledEventLocationSelectViewModel$1 */
    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    public static final class C89051 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C89051() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetGuildScheduledEventLocationSelectViewModel widgetGuildScheduledEventLocationSelectViewModel = WidgetGuildScheduledEventLocationSelectViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "it");
            widgetGuildScheduledEventLocationSelectViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long guildId, Long existingGuildScheduledEventId, StoreGuilds guildsStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreGuildScheduledEvents guildScheduledEventsStore) {
            return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{channelsStore, permissionsStore}, false, null, null, new C8906x3a3a16f6(guildsStore, guildId, channelsStore, permissionsStore, existingGuildScheduledEventId, guildScheduledEventsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Long> channelPermissions;
        private final Map<Long, Channel> channels;
        private final GuildScheduledEvent existingGuildScheduledEvent;
        private final Guild guild;
        private final Long guildPermissions;

        public StoreState(Guild guild, Map<Long, Channel> map, Map<Long, Long> map2, Long l, GuildScheduledEvent guildScheduledEvent) {
            C12238m.checkNotNullParameter(map, "channels");
            C12238m.checkNotNullParameter(map2, "channelPermissions");
            this.guild = guild;
            this.channels = map;
            this.channelPermissions = map2;
            this.guildPermissions = l;
            this.existingGuildScheduledEvent = guildScheduledEvent;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Guild guild, Map map, Map map2, Long l, GuildScheduledEvent guildScheduledEvent, int i, Object obj) {
            if ((i & 1) != 0) {
                guild = storeState.guild;
            }
            if ((i & 2) != 0) {
                map = storeState.channels;
            }
            Map map3 = map;
            if ((i & 4) != 0) {
                map2 = storeState.channelPermissions;
            }
            Map map4 = map2;
            if ((i & 8) != 0) {
                l = storeState.guildPermissions;
            }
            Long l2 = l;
            if ((i & 16) != 0) {
                guildScheduledEvent = storeState.existingGuildScheduledEvent;
            }
            return storeState.copy(guild, map3, map4, l2, guildScheduledEvent);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, Channel> component2() {
            return this.channels;
        }

        public final Map<Long, Long> component3() {
            return this.channelPermissions;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Long getGuildPermissions() {
            return this.guildPermissions;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final GuildScheduledEvent getExistingGuildScheduledEvent() {
            return this.existingGuildScheduledEvent;
        }

        public final StoreState copy(Guild guild, Map<Long, Channel> channels, Map<Long, Long> channelPermissions, Long guildPermissions, GuildScheduledEvent existingGuildScheduledEvent) {
            C12238m.checkNotNullParameter(channels, "channels");
            C12238m.checkNotNullParameter(channelPermissions, "channelPermissions");
            return new StoreState(guild, channels, channelPermissions, guildPermissions, existingGuildScheduledEvent);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.channels, storeState.channels) && C12238m.areEqual(this.channelPermissions, storeState.channelPermissions) && C12238m.areEqual(this.guildPermissions, storeState.guildPermissions) && C12238m.areEqual(this.existingGuildScheduledEvent, storeState.existingGuildScheduledEvent);
        }

        public final Map<Long, Long> getChannelPermissions() {
            return this.channelPermissions;
        }

        public final Map<Long, Channel> getChannels() {
            return this.channels;
        }

        public final GuildScheduledEvent getExistingGuildScheduledEvent() {
            return this.existingGuildScheduledEvent;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getGuildPermissions() {
            return this.guildPermissions;
        }

        public int hashCode() {
            Guild guild = this.guild;
            int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
            Map<Long, Channel> map = this.channels;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, Long> map2 = this.channelPermissions;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            Long l = this.guildPermissions;
            int iHashCode4 = (iHashCode3 + (l != null ? l.hashCode() : 0)) * 31;
            GuildScheduledEvent guildScheduledEvent = this.existingGuildScheduledEvent;
            return iHashCode4 + (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", channels=");
            sbM833U.append(this.channels);
            sbM833U.append(", channelPermissions=");
            sbM833U.append(this.channelPermissions);
            sbM833U.append(", guildPermissions=");
            sbM833U.append(this.guildPermissions);
            sbM833U.append(", existingGuildScheduledEvent=");
            sbM833U.append(this.existingGuildScheduledEvent);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetGuildScheduledEventLocationSelectViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final Map<Long, Channel> availableChannels;
            private final Set<Long> availableStageChannelIds;
            private final Set<Long> availableVoiceChannelIds;
            private final boolean canChangeChannel;
            private final boolean canCreateExternalEvent;
            private final String externalLocation;
            private final Channel selectedChannel;
            private final GuildScheduledEventEntityType selectedLocationOption;
            private final boolean showStageOptionIfUnavailable;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(GuildScheduledEventEntityType guildScheduledEventEntityType, Channel channel, String str, Map<Long, Channel> map, Set<Long> set, Set<Long> set2, boolean z2, boolean z3, boolean z4) {
                super(null);
                C12238m.checkNotNullParameter(guildScheduledEventEntityType, "selectedLocationOption");
                C12238m.checkNotNullParameter(str, "externalLocation");
                C12238m.checkNotNullParameter(map, "availableChannels");
                C12238m.checkNotNullParameter(set, "availableVoiceChannelIds");
                C12238m.checkNotNullParameter(set2, "availableStageChannelIds");
                this.selectedLocationOption = guildScheduledEventEntityType;
                this.selectedChannel = channel;
                this.externalLocation = str;
                this.availableChannels = map;
                this.availableVoiceChannelIds = set;
                this.availableStageChannelIds = set2;
                this.canCreateExternalEvent = z2;
                this.showStageOptionIfUnavailable = z3;
                this.canChangeChannel = z4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, GuildScheduledEventEntityType guildScheduledEventEntityType, Channel channel, String str, Map map, Set set, Set set2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                return valid.copy((i & 1) != 0 ? valid.selectedLocationOption : guildScheduledEventEntityType, (i & 2) != 0 ? valid.selectedChannel : channel, (i & 4) != 0 ? valid.externalLocation : str, (i & 8) != 0 ? valid.availableChannels : map, (i & 16) != 0 ? valid.availableVoiceChannelIds : set, (i & 32) != 0 ? valid.availableStageChannelIds : set2, (i & 64) != 0 ? valid.canCreateExternalEvent : z2, (i & 128) != 0 ? valid.showStageOptionIfUnavailable : z3, (i & 256) != 0 ? valid.canChangeChannel : z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildScheduledEventEntityType getSelectedLocationOption() {
                return this.selectedLocationOption;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getExternalLocation() {
                return this.externalLocation;
            }

            public final Map<Long, Channel> component4() {
                return this.availableChannels;
            }

            public final Set<Long> component5() {
                return this.availableVoiceChannelIds;
            }

            public final Set<Long> component6() {
                return this.availableStageChannelIds;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getCanCreateExternalEvent() {
                return this.canCreateExternalEvent;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getShowStageOptionIfUnavailable() {
                return this.showStageOptionIfUnavailable;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getCanChangeChannel() {
                return this.canChangeChannel;
            }

            public final Valid copy(GuildScheduledEventEntityType selectedLocationOption, Channel selectedChannel, String externalLocation, Map<Long, Channel> availableChannels, Set<Long> availableVoiceChannelIds, Set<Long> availableStageChannelIds, boolean canCreateExternalEvent, boolean showStageOptionIfUnavailable, boolean canChangeChannel) {
                C12238m.checkNotNullParameter(selectedLocationOption, "selectedLocationOption");
                C12238m.checkNotNullParameter(externalLocation, "externalLocation");
                C12238m.checkNotNullParameter(availableChannels, "availableChannels");
                C12238m.checkNotNullParameter(availableVoiceChannelIds, "availableVoiceChannelIds");
                C12238m.checkNotNullParameter(availableStageChannelIds, "availableStageChannelIds");
                return new Valid(selectedLocationOption, selectedChannel, externalLocation, availableChannels, availableVoiceChannelIds, availableStageChannelIds, canCreateExternalEvent, showStageOptionIfUnavailable, canChangeChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.selectedLocationOption, valid.selectedLocationOption) && C12238m.areEqual(this.selectedChannel, valid.selectedChannel) && C12238m.areEqual(this.externalLocation, valid.externalLocation) && C12238m.areEqual(this.availableChannels, valid.availableChannels) && C12238m.areEqual(this.availableVoiceChannelIds, valid.availableVoiceChannelIds) && C12238m.areEqual(this.availableStageChannelIds, valid.availableStageChannelIds) && this.canCreateExternalEvent == valid.canCreateExternalEvent && this.showStageOptionIfUnavailable == valid.showStageOptionIfUnavailable && this.canChangeChannel == valid.canChangeChannel;
            }

            public final Map<Long, Channel> getAvailableChannels() {
                return this.availableChannels;
            }

            public final Set<Long> getAvailableStageChannelIds() {
                return this.availableStageChannelIds;
            }

            public final Set<Long> getAvailableVoiceChannelIds() {
                return this.availableVoiceChannelIds;
            }

            public final boolean getCanChangeChannel() {
                return this.canChangeChannel;
            }

            public final boolean getCanCreateExternalEvent() {
                return this.canCreateExternalEvent;
            }

            public final String getExternalLocation() {
                return this.externalLocation;
            }

            public final Channel getSelectedChannel() {
                return this.selectedChannel;
            }

            public final GuildScheduledEventEntityType getSelectedLocationOption() {
                return this.selectedLocationOption;
            }

            public final boolean getShowStageOptionIfUnavailable() {
                return this.showStageOptionIfUnavailable;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r0v16, types: [int] */
            /* JADX WARN: Type inference failed for: r0v18, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v15 */
            public int hashCode() {
                GuildScheduledEventEntityType guildScheduledEventEntityType = this.selectedLocationOption;
                int iHashCode = (guildScheduledEventEntityType != null ? guildScheduledEventEntityType.hashCode() : 0) * 31;
                Channel channel = this.selectedChannel;
                int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
                String str = this.externalLocation;
                int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
                Map<Long, Channel> map = this.availableChannels;
                int iHashCode4 = (iHashCode3 + (map != null ? map.hashCode() : 0)) * 31;
                Set<Long> set = this.availableVoiceChannelIds;
                int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
                Set<Long> set2 = this.availableStageChannelIds;
                int iHashCode6 = (iHashCode5 + (set2 != null ? set2.hashCode() : 0)) * 31;
                boolean z2 = this.canCreateExternalEvent;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode6 + r1) * 31;
                boolean z3 = this.showStageOptionIfUnavailable;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.canChangeChannel;
                return i2 + (z4 ? 1 : z4);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(selectedLocationOption=");
                sbM833U.append(this.selectedLocationOption);
                sbM833U.append(", selectedChannel=");
                sbM833U.append(this.selectedChannel);
                sbM833U.append(", externalLocation=");
                sbM833U.append(this.externalLocation);
                sbM833U.append(", availableChannels=");
                sbM833U.append(this.availableChannels);
                sbM833U.append(", availableVoiceChannelIds=");
                sbM833U.append(this.availableVoiceChannelIds);
                sbM833U.append(", availableStageChannelIds=");
                sbM833U.append(this.availableStageChannelIds);
                sbM833U.append(", canCreateExternalEvent=");
                sbM833U.append(this.canCreateExternalEvent);
                sbM833U.append(", showStageOptionIfUnavailable=");
                sbM833U.append(this.showStageOptionIfUnavailable);
                sbM833U.append(", canChangeChannel=");
                return C1643a.m827O(sbM833U, this.canChangeChannel, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetGuildScheduledEventLocationSelectViewModel(long j, Long l, Long l2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreGuildScheduledEvents guildScheduledEvents = (i & 64) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        this(j, l, l2, channels, guilds, permissions, guildScheduledEvents, (i & 128) != 0 ? INSTANCE.observeStores(j, l2, guilds, channels, permissions, guildScheduledEvents) : observable);
    }

    private final GuildScheduledEventEntityType getEntityTypeForChannel(Channel channel) {
        if (channel == null) {
            return GuildScheduledEventEntityType.NONE;
        }
        if (ChannelUtils.m7675J(channel)) {
            return GuildScheduledEventEntityType.VOICE;
        }
        return ChannelUtils.m7669D(channel) ? GuildScheduledEventEntityType.STAGE_INSTANCE : GuildScheduledEventEntityType.NONE;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:79:0x014f  */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        Long channelId;
        GuildScheduledEvent existingGuildScheduledEvent;
        GuildScheduledEventEntityMetadata entityMetadata;
        boolean z2;
        Set<GuildFeature> features;
        this.currentStoreState = storeState;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid)) {
            viewState = null;
        }
        ViewState.Valid valid = (ViewState.Valid) viewState;
        boolean zCanCreateExternalEvent = GuildScheduledEventUtilities.INSTANCE.canCreateExternalEvent(storeState.getGuildPermissions());
        Map<Long, Channel> channels = storeState.getChannels();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, Channel> entry : channels.entrySet()) {
            Channel value = entry.getValue();
            if (GuildScheduledEventUtilities.INSTANCE.canStartEventInChannel(value, (Long) C1643a.m845d(value, storeState.getChannelPermissions()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (Channel channel : linkedHashMap.values()) {
            if (ChannelUtils.m7675J(channel)) {
                hashSet2.add(Long.valueOf(channel.getId()));
            } else if (ChannelUtils.m7669D(channel)) {
                hashSet.add(Long.valueOf(channel.getId()));
            }
        }
        boolean z3 = this.existingGuildScheduledEventId != null;
        if (valid != null) {
            Channel selectedChannel = valid.getSelectedChannel();
            if (selectedChannel != null) {
                channelId = Long.valueOf(selectedChannel.getId());
            } else {
                channelId = null;
            }
        } else if (z3) {
            GuildScheduledEvent existingGuildScheduledEvent2 = storeState.getExistingGuildScheduledEvent();
            if (existingGuildScheduledEvent2 != null) {
                channelId = existingGuildScheduledEvent2.getChannelId();
            } else {
                channelId = null;
            }
        } else {
            channelId = this.initialChannelId;
        }
        Channel channel2 = (Channel) linkedHashMap.get(channelId);
        GuildScheduledEventEntityType selectedLocationOption = valid != null ? valid.getSelectedLocationOption() : storeState.getExistingGuildScheduledEvent() != null ? storeState.getExistingGuildScheduledEvent().getEntityType() : getEntityTypeForChannel(channel2);
        if (selectedLocationOption == GuildScheduledEventEntityType.STAGE_INSTANCE && hashSet.isEmpty()) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        } else if (selectedLocationOption == GuildScheduledEventEntityType.VOICE && hashSet2.isEmpty()) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        } else if (selectedLocationOption == GuildScheduledEventEntityType.EXTERNAL && !zCanCreateExternalEvent) {
            selectedLocationOption = GuildScheduledEventEntityType.NONE;
        }
        GuildScheduledEventEntityType guildScheduledEventEntityType = selectedLocationOption;
        Guild guild = storeState.getGuild();
        boolean zContains = (guild == null || (features = guild.getFeatures()) == null) ? false : features.contains(GuildFeature.COMMUNITY);
        String externalLocation = valid != null ? valid.getExternalLocation() : (!z3 || channelId != null || (existingGuildScheduledEvent = storeState.getExistingGuildScheduledEvent()) == null || (entityMetadata = existingGuildScheduledEvent.getEntityMetadata()) == null) ? null : entityMetadata.getLocation();
        if (z3) {
            GuildScheduledEvent existingGuildScheduledEvent3 = storeState.getExistingGuildScheduledEvent();
            if ((existingGuildScheduledEvent3 != null ? GuildScheduledEventUtilitiesKt.getEventTiming(existingGuildScheduledEvent3) : null) == GuildScheduledEventTiming.LIVE) {
                z2 = false;
            } else {
                z2 = true;
            }
        } else {
            z2 = true;
        }
        if (externalLocation == null) {
            externalLocation = "";
        }
        updateViewState(new ViewState.Valid(guildScheduledEventEntityType, channel2, externalLocation, linkedHashMap, hashSet2, hashSet, zCanCreateExternalEvent, zContains, z2));
    }

    public final StoreState getCurrentStoreState() {
        return this.currentStoreState;
    }

    public final void selectChannel(long channelId) {
        StoreState storeState;
        Map<Long, Channel> channels;
        Channel channel;
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Valid) || (storeState = this.currentStoreState) == null || (channels = storeState.getChannels()) == null || (channel = channels.get(Long.valueOf(channelId))) == null) {
            return;
        }
        updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, channel, null, null, null, null, false, false, false, 509, null));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0035  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Multi-variable type inference failed */
    public final void selectLocationOption(GuildScheduledEventEntityType locationOption) {
        Channel channel;
        Channel channel2;
        Map<Long, Channel> channels;
        C12238m.checkNotNullParameter(locationOption, "locationOption");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            ViewState.Valid valid = (ViewState.Valid) viewState;
            if (locationOption == valid.getSelectedLocationOption()) {
                return;
            }
            Long l = this.initialChannelId;
            Object obj = null;
            if (l != null) {
                l.longValue();
                StoreState storeState = this.currentStoreState;
                if (storeState == null || (channels = storeState.getChannels()) == null) {
                    channel = null;
                } else {
                    channel = channels.get(this.initialChannelId);
                }
            } else {
                channel = null;
            }
            GuildScheduledEventEntityType guildScheduledEventEntityType = GuildScheduledEventEntityType.VOICE;
            if (locationOption == guildScheduledEventEntityType && channel != null && channel.getType() == 2) {
                channel2 = channel;
            } else {
                if (locationOption == guildScheduledEventEntityType) {
                    for (Object obj2 : valid.getAvailableChannels().values()) {
                        if (((Channel) obj2).getType() == 2) {
                            obj = obj2;
                            break;
                        }
                    }
                    obj = (Channel) obj;
                } else {
                    GuildScheduledEventEntityType guildScheduledEventEntityType2 = GuildScheduledEventEntityType.STAGE_INSTANCE;
                    if (locationOption == guildScheduledEventEntityType2 && channel != null && channel.getType() == 13) {
                        channel2 = channel;
                    } else if (locationOption == guildScheduledEventEntityType2) {
                        for (Object obj3 : valid.getAvailableChannels().values()) {
                            if (((Channel) obj3).getType() == 13) {
                                obj = obj3;
                                break;
                            }
                        }
                        obj = (Channel) obj;
                    }
                }
                channel2 = obj;
            }
            updateViewState(ViewState.Valid.copy$default(valid, locationOption, channel2, "", null, null, null, false, false, false, 504, null));
        }
    }

    public final void setCurrentStoreState(StoreState storeState) {
        this.currentStoreState = storeState;
    }

    public final void setExternalLocation(String newExternalLocation) {
        C12238m.checkNotNullParameter(newExternalLocation, "newExternalLocation");
        ViewState viewState = getViewState();
        if (viewState instanceof ViewState.Valid) {
            updateViewState(ViewState.Valid.copy$default((ViewState.Valid) viewState, null, null, newExternalLocation, null, null, null, false, false, false, 507, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildScheduledEventLocationSelectViewModel(long j, Long l, Long l2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, StoreGuildScheduledEvents storeGuildScheduledEvents, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.initialChannelId = l;
        this.existingGuildScheduledEventId = l2;
        this.channelsStore = storeChannels;
        Observable<StoreState> observableM11098X = observable.m11098X(C12781a.m10873a());
        C12238m.checkNotNullExpressionValue(observableM11098X, "storeStateObservable\n   …Schedulers.computation())");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11098X, this, null, 2, null), (Class<?>) WidgetGuildScheduledEventLocationSelectViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C89051());
    }
}
