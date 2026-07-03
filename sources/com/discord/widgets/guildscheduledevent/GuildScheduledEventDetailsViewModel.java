package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.discord.api.channel.Channel;
import com.discord.api.guildscheduledevent.GuildScheduledEvent;
import com.discord.api.guildscheduledevent.GuildScheduledEventEntityType;
import com.discord.models.guild.Guild;
import com.discord.models.guild.UserGuildMember;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreDirectories;
import com.discord.stores.StoreGuildScheduledEvents;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserSettings;
import com.discord.stores.StoreVoiceChannelSelected;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final GuildScheduledEventDetailsArgs args;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private EventDetailsRsvpUsersFetchState rsvpUsersFetchState;
    private EventDetailsSection section;
    private int segmentControlIndex;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$1 */
    /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
    public static final /* synthetic */ class C88141 extends C12236k implements Function1<StoreState, Unit> {
        public C88141(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel) {
            super(1, guildScheduledEventDetailsViewModel, GuildScheduledEventDetailsViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "p1");
            ((GuildScheduledEventDetailsViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                GuildScheduledEventDetailsSource.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                GuildScheduledEventDetailsSource guildScheduledEventDetailsSource = GuildScheduledEventDetailsSource.Directory;
                iArr[guildScheduledEventDetailsSource.ordinal()] = 1;
                GuildScheduledEventDetailsSource guildScheduledEventDetailsSource2 = GuildScheduledEventDetailsSource.Guild;
                iArr[guildScheduledEventDetailsSource2.ordinal()] = 2;
                GuildScheduledEventDetailsSource.values();
                int[] iArr2 = new int[2];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[guildScheduledEventDetailsSource.ordinal()] = 1;
                iArr2[guildScheduledEventDetailsSource2.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        private final Observable<StoreState> observeStores(GuildScheduledEventDetailsArgs args, ObservationDeck observationDeck, StoreGuildScheduledEvents guildScheduledEventsStore, StoreGuilds guildsStore, StoreUser userStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreUserSettings userSettingsStore, StoreVoiceChannelSelected selectedVoiceChannelStore, StoreDirectories directoriesStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildScheduledEventsStore, guildsStore, userStore, channelsStore, permissionsStore, selectedVoiceChannelStore, directoriesStore}, false, null, null, new GuildScheduledEventDetailsViewModel$Companion$observeStores$1(args, directoriesStore, guildScheduledEventsStore, guildsStore, channelsStore, selectedVoiceChannelStore, permissionsStore, userSettingsStore), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean canConnect;
        private final boolean canShare;
        private final boolean canStartEvent;
        private final Channel channel;
        private final UserGuildMember creator;
        private final Guild guild;
        private final GuildScheduledEvent guildScheduledEvent;
        private final boolean isDeveloperMode;
        private final boolean isInGuild;
        private final boolean isRsvpUsersError;
        private final boolean isRsvpUsersFetching;
        private final boolean isRsvped;
        private final List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers;
        private final Long selectedVoiceChannelId;

        public StoreState() {
            this(null, null, null, null, false, false, false, false, false, null, false, null, false, false, 16383, null);
        }

        public StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List<GuildScheduledEventRsvpUserListItem.RsvpUser> list, boolean z8, boolean z9) {
            C12238m.checkNotNullParameter(list, "rsvpUsers");
            this.guildScheduledEvent = guildScheduledEvent;
            this.channel = channel;
            this.guild = guild;
            this.creator = userGuildMember;
            this.isInGuild = z2;
            this.isRsvped = z3;
            this.canShare = z4;
            this.canStartEvent = z5;
            this.isDeveloperMode = z6;
            this.selectedVoiceChannelId = l;
            this.canConnect = z7;
            this.rsvpUsers = list;
            this.isRsvpUsersFetching = z8;
            this.isRsvpUsersError = z9;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX INFO: renamed from: component11, reason: from getter */
        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> component12() {
            return this.rsvpUsers;
        }

        /* JADX INFO: renamed from: component13, reason: from getter */
        public final boolean getIsRsvpUsersFetching() {
            return this.isRsvpUsersFetching;
        }

        /* JADX INFO: renamed from: component14, reason: from getter */
        public final boolean getIsRsvpUsersError() {
            return this.isRsvpUsersError;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final UserGuildMember getCreator() {
            return this.creator;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsInGuild() {
            return this.isInGuild;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getIsRsvped() {
            return this.isRsvped;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getCanShare() {
            return this.canShare;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getIsDeveloperMode() {
            return this.isDeveloperMode;
        }

        public final StoreState copy(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember creator, boolean isInGuild, boolean isRsvped, boolean canShare, boolean canStartEvent, boolean isDeveloperMode, Long selectedVoiceChannelId, boolean canConnect, List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers, boolean isRsvpUsersFetching, boolean isRsvpUsersError) {
            C12238m.checkNotNullParameter(rsvpUsers, "rsvpUsers");
            return new StoreState(guildScheduledEvent, channel, guild, creator, isInGuild, isRsvped, canShare, canStartEvent, isDeveloperMode, selectedVoiceChannelId, canConnect, rsvpUsers, isRsvpUsersFetching, isRsvpUsersError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.guildScheduledEvent, storeState.guildScheduledEvent) && C12238m.areEqual(this.channel, storeState.channel) && C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.creator, storeState.creator) && this.isInGuild == storeState.isInGuild && this.isRsvped == storeState.isRsvped && this.canShare == storeState.canShare && this.canStartEvent == storeState.canStartEvent && this.isDeveloperMode == storeState.isDeveloperMode && C12238m.areEqual(this.selectedVoiceChannelId, storeState.selectedVoiceChannelId) && this.canConnect == storeState.canConnect && C12238m.areEqual(this.rsvpUsers, storeState.rsvpUsers) && this.isRsvpUsersFetching == storeState.isRsvpUsersFetching && this.isRsvpUsersError == storeState.isRsvpUsersError;
        }

        public final boolean getCanConnect() {
            return this.canConnect;
        }

        public final boolean getCanShare() {
            return this.canShare;
        }

        public final boolean getCanStartEvent() {
            return this.canStartEvent;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final UserGuildMember getCreator() {
            return this.creator;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final GuildScheduledEvent getGuildScheduledEvent() {
            return this.guildScheduledEvent;
        }

        public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> getRsvpUsers() {
            return this.rsvpUsers;
        }

        public final Long getSelectedVoiceChannelId() {
            return this.selectedVoiceChannelId;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v26, types: [int] */
        /* JADX WARN: Type inference failed for: r0v28, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5 */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12, types: [int] */
        /* JADX WARN: Type inference failed for: r2v14, types: [int] */
        /* JADX WARN: Type inference failed for: r2v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v18, types: [int] */
        /* JADX WARN: Type inference failed for: r2v23, types: [int] */
        /* JADX WARN: Type inference failed for: r2v25 */
        /* JADX WARN: Type inference failed for: r2v27 */
        /* JADX WARN: Type inference failed for: r2v28 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r2v30 */
        /* JADX WARN: Type inference failed for: r2v31 */
        /* JADX WARN: Type inference failed for: r2v35 */
        /* JADX WARN: Type inference failed for: r2v36 */
        /* JADX WARN: Type inference failed for: r2v37 */
        /* JADX WARN: Type inference failed for: r2v38 */
        /* JADX WARN: Type inference failed for: r2v39 */
        /* JADX WARN: Type inference failed for: r2v40 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
            int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
            Channel channel = this.channel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
            UserGuildMember userGuildMember = this.creator;
            int iHashCode4 = (iHashCode3 + (userGuildMember != null ? userGuildMember.hashCode() : 0)) * 31;
            boolean z2 = this.isInGuild;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode4 + r2) * 31;
            boolean z3 = this.isRsvped;
            ?? r3 = z3;
            if (z3) {
                r3 = 1;
            }
            int i2 = (i + r3) * 31;
            boolean z4 = this.canShare;
            ?? r4 = z4;
            if (z4) {
                r4 = 1;
            }
            int i3 = (i2 + r4) * 31;
            boolean z5 = this.canStartEvent;
            ?? r5 = z5;
            if (z5) {
                r5 = 1;
            }
            int i4 = (i3 + r5) * 31;
            boolean z6 = this.isDeveloperMode;
            ?? r6 = z6;
            if (z6) {
                r6 = 1;
            }
            int i5 = (i4 + r6) * 31;
            Long l = this.selectedVoiceChannelId;
            int iHashCode5 = (i5 + (l != null ? l.hashCode() : 0)) * 31;
            boolean z7 = this.canConnect;
            ?? r7 = z7;
            if (z7) {
                r7 = 1;
            }
            int i6 = (iHashCode5 + r7) * 31;
            List<GuildScheduledEventRsvpUserListItem.RsvpUser> list = this.rsvpUsers;
            int iHashCode6 = (i6 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z8 = this.isRsvpUsersFetching;
            ?? r1 = z8;
            if (z8) {
                r1 = 1;
            }
            int i7 = (iHashCode6 + r1) * 31;
            boolean z9 = this.isRsvpUsersError;
            return i7 + (z9 ? 1 : z9);
        }

        public final boolean isDeveloperMode() {
            return this.isDeveloperMode;
        }

        public final boolean isInGuild() {
            return this.isInGuild;
        }

        public final boolean isRsvpUsersError() {
            return this.isRsvpUsersError;
        }

        public final boolean isRsvpUsersFetching() {
            return this.isRsvpUsersFetching;
        }

        public final boolean isRsvped() {
            return this.isRsvped;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(guildScheduledEvent=");
            sbM833U.append(this.guildScheduledEvent);
            sbM833U.append(", channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", creator=");
            sbM833U.append(this.creator);
            sbM833U.append(", isInGuild=");
            sbM833U.append(this.isInGuild);
            sbM833U.append(", isRsvped=");
            sbM833U.append(this.isRsvped);
            sbM833U.append(", canShare=");
            sbM833U.append(this.canShare);
            sbM833U.append(", canStartEvent=");
            sbM833U.append(this.canStartEvent);
            sbM833U.append(", isDeveloperMode=");
            sbM833U.append(this.isDeveloperMode);
            sbM833U.append(", selectedVoiceChannelId=");
            sbM833U.append(this.selectedVoiceChannelId);
            sbM833U.append(", canConnect=");
            sbM833U.append(this.canConnect);
            sbM833U.append(", rsvpUsers=");
            sbM833U.append(this.rsvpUsers);
            sbM833U.append(", isRsvpUsersFetching=");
            sbM833U.append(this.isRsvpUsersFetching);
            sbM833U.append(", isRsvpUsersError=");
            return C1643a.m827O(sbM833U, this.isRsvpUsersError, ")");
        }

        public /* synthetic */ StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List list, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guildScheduledEvent, (i & 2) != 0 ? null : channel, (i & 4) != 0 ? null : guild, (i & 8) != 0 ? null : userGuildMember, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? false : z5, (i & 256) != 0 ? false : z6, (i & 512) == 0 ? l : null, (i & 1024) != 0 ? false : z7, (i & 2048) != 0 ? C12147n.emptyList() : list, (i & 4096) != 0 ? false : z8, (i & 8192) == 0 ? z9 : false);
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
        public static final /* data */ class Initialized extends ViewState {
            private final boolean canConnect;
            private final boolean canShare;
            private final boolean canStartEvent;
            private final Channel channel;
            private final UserGuildMember creator;
            private final Guild guild;
            private final GuildScheduledEvent guildScheduledEvent;
            private final boolean isConnected;
            private final boolean isDeveloperMode;
            private final boolean isInGuild;
            private final boolean isRsvped;
            private final GuildScheduledEventLocationInfo locationInfo;
            private final List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers;
            private final EventDetailsRsvpUsersFetchState rsvpUsersFetchState;
            private final EventDetailsSection section;
            private final int segmentedControlIndex;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List<GuildScheduledEventRsvpUserListItem.RsvpUser> list, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i, UserGuildMember userGuildMember) {
                super(null);
                C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(list, "rsvpUsers");
                C12238m.checkNotNullParameter(eventDetailsSection, "section");
                C12238m.checkNotNullParameter(eventDetailsRsvpUsersFetchState, "rsvpUsersFetchState");
                this.guildScheduledEvent = guildScheduledEvent;
                this.locationInfo = guildScheduledEventLocationInfo;
                this.guild = guild;
                this.channel = channel;
                this.isInGuild = z2;
                this.isRsvped = z3;
                this.canShare = z4;
                this.isConnected = z5;
                this.canStartEvent = z6;
                this.isDeveloperMode = z7;
                this.canConnect = z8;
                this.rsvpUsers = list;
                this.section = eventDetailsSection;
                this.rsvpUsersFetchState = eventDetailsRsvpUsersFetchState;
                this.segmentedControlIndex = i;
                this.creator = userGuildMember;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Initialized copy$default(Initialized initialized, GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List list, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i, UserGuildMember userGuildMember, int i2, Object obj) {
                return initialized.copy((i2 & 1) != 0 ? initialized.guildScheduledEvent : guildScheduledEvent, (i2 & 2) != 0 ? initialized.locationInfo : guildScheduledEventLocationInfo, (i2 & 4) != 0 ? initialized.guild : guild, (i2 & 8) != 0 ? initialized.channel : channel, (i2 & 16) != 0 ? initialized.isInGuild : z2, (i2 & 32) != 0 ? initialized.isRsvped : z3, (i2 & 64) != 0 ? initialized.canShare : z4, (i2 & 128) != 0 ? initialized.isConnected : z5, (i2 & 256) != 0 ? initialized.canStartEvent : z6, (i2 & 512) != 0 ? initialized.isDeveloperMode : z7, (i2 & 1024) != 0 ? initialized.canConnect : z8, (i2 & 2048) != 0 ? initialized.rsvpUsers : list, (i2 & 4096) != 0 ? initialized.section : eventDetailsSection, (i2 & 8192) != 0 ? initialized.rsvpUsersFetchState : eventDetailsRsvpUsersFetchState, (i2 & 16384) != 0 ? initialized.segmentedControlIndex : i, (i2 & 32768) != 0 ? initialized.creator : userGuildMember);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getIsDeveloperMode() {
                return this.isDeveloperMode;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final boolean getCanConnect() {
                return this.canConnect;
            }

            public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> component12() {
                return this.rsvpUsers;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final EventDetailsSection getSection() {
                return this.section;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final EventDetailsRsvpUsersFetchState getRsvpUsersFetchState() {
                return this.rsvpUsersFetchState;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final int getSegmentedControlIndex() {
                return this.segmentedControlIndex;
            }

            /* JADX INFO: renamed from: component16, reason: from getter */
            public final UserGuildMember getCreator() {
                return this.creator;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final GuildScheduledEventLocationInfo getLocationInfo() {
                return this.locationInfo;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIsInGuild() {
                return this.isInGuild;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsRsvped() {
                return this.isRsvped;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getCanShare() {
                return this.canShare;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsConnected() {
                return this.isConnected;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getCanStartEvent() {
                return this.canStartEvent;
            }

            public final Initialized copy(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo locationInfo, Guild guild, Channel channel, boolean isInGuild, boolean isRsvped, boolean canShare, boolean isConnected, boolean canStartEvent, boolean isDeveloperMode, boolean canConnect, List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers, EventDetailsSection section, EventDetailsRsvpUsersFetchState rsvpUsersFetchState, int segmentedControlIndex, UserGuildMember creator) {
                C12238m.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(rsvpUsers, "rsvpUsers");
                C12238m.checkNotNullParameter(section, "section");
                C12238m.checkNotNullParameter(rsvpUsersFetchState, "rsvpUsersFetchState");
                return new Initialized(guildScheduledEvent, locationInfo, guild, channel, isInGuild, isRsvped, canShare, isConnected, canStartEvent, isDeveloperMode, canConnect, rsvpUsers, section, rsvpUsersFetchState, segmentedControlIndex, creator);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Initialized)) {
                    return false;
                }
                Initialized initialized = (Initialized) other;
                return C12238m.areEqual(this.guildScheduledEvent, initialized.guildScheduledEvent) && C12238m.areEqual(this.locationInfo, initialized.locationInfo) && C12238m.areEqual(this.guild, initialized.guild) && C12238m.areEqual(this.channel, initialized.channel) && this.isInGuild == initialized.isInGuild && this.isRsvped == initialized.isRsvped && this.canShare == initialized.canShare && this.isConnected == initialized.isConnected && this.canStartEvent == initialized.canStartEvent && this.isDeveloperMode == initialized.isDeveloperMode && this.canConnect == initialized.canConnect && C12238m.areEqual(this.rsvpUsers, initialized.rsvpUsers) && C12238m.areEqual(this.section, initialized.section) && C12238m.areEqual(this.rsvpUsersFetchState, initialized.rsvpUsersFetchState) && this.segmentedControlIndex == initialized.segmentedControlIndex && C12238m.areEqual(this.creator, initialized.creator);
            }

            public final boolean getCanConnect() {
                return this.canConnect;
            }

            public final boolean getCanShare() {
                return this.canShare;
            }

            public final boolean getCanStartEvent() {
                return this.canStartEvent;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final UserGuildMember getCreator() {
                return this.creator;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final GuildScheduledEvent getGuildScheduledEvent() {
                return this.guildScheduledEvent;
            }

            public final GuildScheduledEventLocationInfo getLocationInfo() {
                return this.locationInfo;
            }

            public final List<GuildScheduledEventRsvpUserListItem.RsvpUser> getRsvpUsers() {
                return this.rsvpUsers;
            }

            public final EventDetailsRsvpUsersFetchState getRsvpUsersFetchState() {
                return this.rsvpUsersFetchState;
            }

            public final EventDetailsSection getSection() {
                return this.section;
            }

            public final int getSegmentedControlIndex() {
                return this.segmentedControlIndex;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v10, types: [int] */
            /* JADX WARN: Type inference failed for: r2v12, types: [int] */
            /* JADX WARN: Type inference failed for: r2v14, types: [int] */
            /* JADX WARN: Type inference failed for: r2v16, types: [int] */
            /* JADX WARN: Type inference failed for: r2v18, types: [int] */
            /* JADX WARN: Type inference failed for: r2v20, types: [int] */
            /* JADX WARN: Type inference failed for: r2v36 */
            /* JADX WARN: Type inference failed for: r2v37 */
            /* JADX WARN: Type inference failed for: r2v38 */
            /* JADX WARN: Type inference failed for: r2v39 */
            /* JADX WARN: Type inference failed for: r2v40 */
            /* JADX WARN: Type inference failed for: r2v41 */
            /* JADX WARN: Type inference failed for: r2v45 */
            /* JADX WARN: Type inference failed for: r2v46 */
            /* JADX WARN: Type inference failed for: r2v47 */
            /* JADX WARN: Type inference failed for: r2v48 */
            /* JADX WARN: Type inference failed for: r2v49 */
            /* JADX WARN: Type inference failed for: r2v50 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                GuildScheduledEvent guildScheduledEvent = this.guildScheduledEvent;
                int iHashCode = (guildScheduledEvent != null ? guildScheduledEvent.hashCode() : 0) * 31;
                GuildScheduledEventLocationInfo guildScheduledEventLocationInfo = this.locationInfo;
                int iHashCode2 = (iHashCode + (guildScheduledEventLocationInfo != null ? guildScheduledEventLocationInfo.hashCode() : 0)) * 31;
                Guild guild = this.guild;
                int iHashCode3 = (iHashCode2 + (guild != null ? guild.hashCode() : 0)) * 31;
                Channel channel = this.channel;
                int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
                boolean z2 = this.isInGuild;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode4 + r2) * 31;
                boolean z3 = this.isRsvped;
                ?? r3 = z3;
                if (z3) {
                    r3 = 1;
                }
                int i2 = (i + r3) * 31;
                boolean z4 = this.canShare;
                ?? r4 = z4;
                if (z4) {
                    r4 = 1;
                }
                int i3 = (i2 + r4) * 31;
                boolean z5 = this.isConnected;
                ?? r5 = z5;
                if (z5) {
                    r5 = 1;
                }
                int i4 = (i3 + r5) * 31;
                boolean z6 = this.canStartEvent;
                ?? r6 = z6;
                if (z6) {
                    r6 = 1;
                }
                int i5 = (i4 + r6) * 31;
                boolean z7 = this.isDeveloperMode;
                ?? r7 = z7;
                if (z7) {
                    r7 = 1;
                }
                int i6 = (i5 + r7) * 31;
                boolean z8 = this.canConnect;
                int i7 = (i6 + (z8 ? 1 : z8)) * 31;
                List<GuildScheduledEventRsvpUserListItem.RsvpUser> list = this.rsvpUsers;
                int iHashCode5 = (i7 + (list != null ? list.hashCode() : 0)) * 31;
                EventDetailsSection eventDetailsSection = this.section;
                int iHashCode6 = (iHashCode5 + (eventDetailsSection != null ? eventDetailsSection.hashCode() : 0)) * 31;
                EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState = this.rsvpUsersFetchState;
                int iHashCode7 = (((iHashCode6 + (eventDetailsRsvpUsersFetchState != null ? eventDetailsRsvpUsersFetchState.hashCode() : 0)) * 31) + this.segmentedControlIndex) * 31;
                UserGuildMember userGuildMember = this.creator;
                return iHashCode7 + (userGuildMember != null ? userGuildMember.hashCode() : 0);
            }

            public final boolean isConnected() {
                return this.isConnected;
            }

            public final boolean isDeveloperMode() {
                return this.isDeveloperMode;
            }

            public final boolean isInGuild() {
                return this.isInGuild;
            }

            public final boolean isRsvped() {
                return this.isRsvped;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Initialized(guildScheduledEvent=");
                sbM833U.append(this.guildScheduledEvent);
                sbM833U.append(", locationInfo=");
                sbM833U.append(this.locationInfo);
                sbM833U.append(", guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", isInGuild=");
                sbM833U.append(this.isInGuild);
                sbM833U.append(", isRsvped=");
                sbM833U.append(this.isRsvped);
                sbM833U.append(", canShare=");
                sbM833U.append(this.canShare);
                sbM833U.append(", isConnected=");
                sbM833U.append(this.isConnected);
                sbM833U.append(", canStartEvent=");
                sbM833U.append(this.canStartEvent);
                sbM833U.append(", isDeveloperMode=");
                sbM833U.append(this.isDeveloperMode);
                sbM833U.append(", canConnect=");
                sbM833U.append(this.canConnect);
                sbM833U.append(", rsvpUsers=");
                sbM833U.append(this.rsvpUsers);
                sbM833U.append(", section=");
                sbM833U.append(this.section);
                sbM833U.append(", rsvpUsersFetchState=");
                sbM833U.append(this.rsvpUsersFetchState);
                sbM833U.append(", segmentedControlIndex=");
                sbM833U.append(this.segmentedControlIndex);
                sbM833U.append(", creator=");
                sbM833U.append(this.creator);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildScheduledEventDetailsViewModel(GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable observable, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i2 & 2) != 0 ? ObservationDeckProvider.get() : observationDeck;
        StoreGuildScheduledEvents guildScheduledEvents = (i2 & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreGuilds guilds = (i2 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i2 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i2 & 32) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i2 & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUserSettings userSettings = (i2 & 128) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i2 & 256) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreDirectories directories = (i2 & 512) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        this(guildScheduledEventDetailsArgs, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories, (i2 & 1024) != 0 ? INSTANCE.observeStores(guildScheduledEventDetailsArgs, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories) : observable, (i2 & 2048) != 0 ? EventDetailsSection.EVENT_INFO : eventDetailsSection, (i2 & 4096) != 0 ? EventDetailsRsvpUsersFetchState.LOADING : eventDetailsRsvpUsersFetchState, (i2 & 8192) != 0 ? 0 : i);
    }

    private final EventDetailsRsvpUsersFetchState getRsvpUsersFetchState(StoreState storeState) {
        if (storeState.isRsvpUsersFetching() && storeState.getRsvpUsers().isEmpty()) {
            return EventDetailsRsvpUsersFetchState.LOADING;
        }
        if (storeState.isRsvpUsersError()) {
            return EventDetailsRsvpUsersFetchState.ERROR;
        }
        return storeState.getRsvpUsers().isEmpty() ? EventDetailsRsvpUsersFetchState.EMPTY : EventDetailsRsvpUsersFetchState.SUCCESS;
    }

    private final void handleStoreState(StoreState storeState) {
        ViewState initialized;
        boolean z2;
        if (storeState.getGuildScheduledEvent() == null || storeState.getGuild() == null) {
            initialized = ViewState.Invalid.INSTANCE;
        } else {
            if (getViewState() == null) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUserCounts(storeState.getGuild().getId());
            }
            GuildScheduledEventLocationInfo guildScheduledEventLocationInfoBuildLocationInfo = (this.args.getSource() == GuildScheduledEventDetailsSource.Guild || storeState.getGuildScheduledEvent().getEntityType() == GuildScheduledEventEntityType.EXTERNAL || storeState.isInGuild()) ? GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(storeState.getGuildScheduledEvent(), storeState.getChannel()) : null;
            this.rsvpUsersFetchState = getRsvpUsersFetchState(storeState);
            GuildScheduledEvent guildScheduledEvent = storeState.getGuildScheduledEvent();
            Guild guild = storeState.getGuild();
            Channel channel = storeState.getChannel();
            boolean zIsInGuild = storeState.isInGuild();
            boolean zIsRsvped = storeState.isRsvped();
            Long channelId = storeState.getGuildScheduledEvent().getChannelId();
            boolean z3 = false;
            if (channelId != null) {
                long jLongValue = channelId.longValue();
                Long selectedVoiceChannelId = storeState.getSelectedVoiceChannelId();
                if (selectedVoiceChannelId != null && jLongValue == selectedVoiceChannelId.longValue()) {
                    z3 = true;
                }
                z2 = z3;
            } else {
                z2 = false;
            }
            initialized = new ViewState.Initialized(guildScheduledEvent, guildScheduledEventLocationInfoBuildLocationInfo, guild, channel, zIsInGuild, zIsRsvped, storeState.getCanShare(), z2, storeState.getCanStartEvent(), storeState.isDeveloperMode(), storeState.getCanConnect(), storeState.getRsvpUsers(), this.section, this.rsvpUsersFetchState, this.segmentControlIndex, storeState.getCreator());
        }
        updateViewState(initialized);
    }

    public final void endEventClicked(Context context, Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.endEvent(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId()), false, 1, null), (Class<?>) GuildScheduledEventDetailsViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C8816x6abdea3c(this, context, onSuccess));
        }
    }

    public final void onDeleteButtonClicked(Context context, Function0<Unit> onSuccess) {
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(onSuccess, "onSuccess");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildScheduledEvent(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId()), false, 1, null), (Class<?>) GuildScheduledEventDetailsViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C8817x5cc2db1f(this, context, onSuccess));
        }
    }

    public final void onGuildNameClicked() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            StoreStream.INSTANCE.getGuildSelected().set(initialized.getGuild().getId());
        }
    }

    public final void onRsvpButtonClicked() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            this.guildScheduledEventsStore.toggleMeRsvpForEvent(initialized.getGuildScheduledEvent());
        }
    }

    public final void onShareButtonClicked(WeakReference<Fragment> weakFragment) {
        C12238m.checkNotNullParameter(weakFragment, "weakFragment");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            Long channelId = initialized.getGuildScheduledEvent().getChannelId();
            long guildId = initialized.getGuildScheduledEvent().getGuildId();
            long id2 = initialized.getGuildScheduledEvent().getId();
            GuildScheduledEventUtilities.Companion companion = GuildScheduledEventUtilities.INSTANCE;
            boolean zCanShareEvent = companion.canShareEvent(channelId, guildId, (60 & 4) != 0 ? StoreStream.INSTANCE.getChannels() : null, (60 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : null, (60 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : null, (60 & 32) != 0 ? StoreStream.INSTANCE.getPermissions() : null);
            Fragment fragment = weakFragment.get();
            if (fragment != null) {
                C12238m.checkNotNullExpressionValue(fragment, "weakFragment.get() ?: return");
                companion.launchInvite(zCanShareEvent, fragment, guildId, initialized.getChannel(), id2);
            }
        }
    }

    public final void setSegmentedControlIndex(int index) {
        if (this.segmentControlIndex == index) {
            return;
        }
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            this.segmentControlIndex = index;
            EventDetailsSection eventDetailsSection = index == 0 ? EventDetailsSection.EVENT_INFO : EventDetailsSection.RSVP_LIST;
            this.section = eventDetailsSection;
            if (eventDetailsSection == EventDetailsSection.RSVP_LIST) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUsers(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId());
                if (initialized.getRsvpUsers().isEmpty()) {
                    this.rsvpUsersFetchState = EventDetailsRsvpUsersFetchState.LOADING;
                }
            }
            updateViewState(ViewState.Initialized.copy$default(initialized, null, null, null, null, false, false, false, false, false, false, false, null, this.section, this.rsvpUsersFetchState, this.segmentControlIndex, null, 36863, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel(GuildScheduledEventDetailsArgs guildScheduledEventDetailsArgs, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable<StoreState> observable, EventDetailsSection eventDetailsSection, EventDetailsRsvpUsersFetchState eventDetailsRsvpUsersFetchState, int i) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(guildScheduledEventDetailsArgs, "args");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        C12238m.checkNotNullParameter(storeGuilds, "guildsStore");
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(storeChannels, "channelsStore");
        C12238m.checkNotNullParameter(storePermissions, "permissionsStore");
        C12238m.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        C12238m.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        C12238m.checkNotNullParameter(storeDirectories, "directoriesStore");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        C12238m.checkNotNullParameter(eventDetailsSection, "section");
        C12238m.checkNotNullParameter(eventDetailsRsvpUsersFetchState, "rsvpUsersFetchState");
        this.args = guildScheduledEventDetailsArgs;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.userStore = storeUser;
        this.section = eventDetailsSection;
        this.rsvpUsersFetchState = eventDetailsRsvpUsersFetchState;
        this.segmentControlIndex = i;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildScheduledEventDetailsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C88141(this));
    }
}
