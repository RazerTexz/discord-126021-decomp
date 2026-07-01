package com.discord.widgets.guildscheduledevent;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildscheduledevent.GuildScheduledEventUtilities;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guildscheduledevent.GuildScheduledEventRsvpUserListItem;
import d0.t.Collections2;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildScheduledEventDetailsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final WidgetGuildScheduledEventDetailsBottomSheet2 args;
    private final StoreGuildScheduledEvents guildScheduledEventsStore;
    private GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState;
    private GuildScheduledEventDetailsViewModel3 section;
    private int segmentControlIndex;
    private final StoreUser userStore;

    /* JADX INFO: renamed from: com.discord.widgets.guildscheduledevent.GuildScheduledEventDetailsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<StoreState, Unit> {
        public AnonymousClass1(GuildScheduledEventDetailsViewModel guildScheduledEventDetailsViewModel) {
            super(1, guildScheduledEventDetailsViewModel, GuildScheduledEventDetailsViewModel.class, "handleStoreState", "handleStoreState(Lcom/discord/widgets/guildscheduledevent/GuildScheduledEventDetailsViewModel$StoreState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "p1");
            ((GuildScheduledEventDetailsViewModel) this.receiver).handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildScheduledEventDetailsViewModel.kt */
    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;
            public static final /* synthetic */ int[] $EnumSwitchMapping$1;

            static {
                WidgetGuildScheduledEventDetailsBottomSheet3.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet3 = WidgetGuildScheduledEventDetailsBottomSheet3.Directory;
                iArr[widgetGuildScheduledEventDetailsBottomSheet3.ordinal()] = 1;
                WidgetGuildScheduledEventDetailsBottomSheet3 widgetGuildScheduledEventDetailsBottomSheet4 = WidgetGuildScheduledEventDetailsBottomSheet3.Guild;
                iArr[widgetGuildScheduledEventDetailsBottomSheet4.ordinal()] = 2;
                WidgetGuildScheduledEventDetailsBottomSheet3.values();
                int[] iArr2 = new int[2];
                $EnumSwitchMapping$1 = iArr2;
                iArr2[widgetGuildScheduledEventDetailsBottomSheet3.ordinal()] = 1;
                iArr2[widgetGuildScheduledEventDetailsBottomSheet4.ordinal()] = 2;
            }
        }

        private Companion() {
        }

        private final Observable<StoreState> observeStores(WidgetGuildScheduledEventDetailsBottomSheet2 args, ObservationDeck observationDeck, StoreGuildScheduledEvents guildScheduledEventsStore, StoreGuilds guildsStore, StoreUser userStore, StoreChannels channelsStore, StorePermissions permissionsStore, StoreUserSettings userSettingsStore, StoreVoiceChannelSelected selectedVoiceChannelStore, StoreDirectories directoriesStore) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{guildScheduledEventsStore, guildsStore, userStore, channelsStore, permissionsStore, selectedVoiceChannelStore, directoriesStore}, false, null, null, new GuildScheduledEventDetailsViewModel4(args, directoriesStore, guildScheduledEventsStore, guildsStore, channelsStore, selectedVoiceChannelStore, permissionsStore, userSettingsStore), 14, null);
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
            Intrinsics3.checkNotNullParameter(list, "rsvpUsers");
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
            Intrinsics3.checkNotNullParameter(rsvpUsers, "rsvpUsers");
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
            return Intrinsics3.areEqual(this.guildScheduledEvent, storeState.guildScheduledEvent) && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.creator, storeState.creator) && this.isInGuild == storeState.isInGuild && this.isRsvped == storeState.isRsvped && this.canShare == storeState.canShare && this.canStartEvent == storeState.canStartEvent && this.isDeveloperMode == storeState.isDeveloperMode && Intrinsics3.areEqual(this.selectedVoiceChannelId, storeState.selectedVoiceChannelId) && this.canConnect == storeState.canConnect && Intrinsics3.areEqual(this.rsvpUsers, storeState.rsvpUsers) && this.isRsvpUsersFetching == storeState.isRsvpUsersFetching && this.isRsvpUsersError == storeState.isRsvpUsersError;
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
            StringBuilder sbU = outline.U("StoreState(guildScheduledEvent=");
            sbU.append(this.guildScheduledEvent);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", creator=");
            sbU.append(this.creator);
            sbU.append(", isInGuild=");
            sbU.append(this.isInGuild);
            sbU.append(", isRsvped=");
            sbU.append(this.isRsvped);
            sbU.append(", canShare=");
            sbU.append(this.canShare);
            sbU.append(", canStartEvent=");
            sbU.append(this.canStartEvent);
            sbU.append(", isDeveloperMode=");
            sbU.append(this.isDeveloperMode);
            sbU.append(", selectedVoiceChannelId=");
            sbU.append(this.selectedVoiceChannelId);
            sbU.append(", canConnect=");
            sbU.append(this.canConnect);
            sbU.append(", rsvpUsers=");
            sbU.append(this.rsvpUsers);
            sbU.append(", isRsvpUsersFetching=");
            sbU.append(this.isRsvpUsersFetching);
            sbU.append(", isRsvpUsersError=");
            return outline.O(sbU, this.isRsvpUsersError, ")");
        }

        public /* synthetic */ StoreState(GuildScheduledEvent guildScheduledEvent, Channel channel, Guild guild, UserGuildMember userGuildMember, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, Long l, boolean z7, List list, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : guildScheduledEvent, (i & 2) != 0 ? null : channel, (i & 4) != 0 ? null : guild, (i & 8) != 0 ? null : userGuildMember, (i & 16) != 0 ? true : z2, (i & 32) != 0 ? false : z3, (i & 64) != 0 ? false : z4, (i & 128) != 0 ? false : z5, (i & 256) != 0 ? false : z6, (i & 512) == 0 ? l : null, (i & 1024) != 0 ? false : z7, (i & 2048) != 0 ? Collections2.emptyList() : list, (i & 4096) != 0 ? false : z8, (i & 8192) == 0 ? z9 : false);
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
            private final GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState;
            private final GuildScheduledEventDetailsViewModel3 section;
            private final int segmentedControlIndex;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Initialized(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List<GuildScheduledEventRsvpUserListItem.RsvpUser> list, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i, UserGuildMember userGuildMember) {
                super(null);
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(list, "rsvpUsers");
                Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel3, "section");
                Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel2, "rsvpUsersFetchState");
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
                this.section = guildScheduledEventDetailsViewModel3;
                this.rsvpUsersFetchState = guildScheduledEventDetailsViewModel2;
                this.segmentedControlIndex = i;
                this.creator = userGuildMember;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Initialized copy$default(Initialized initialized, GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo guildScheduledEventLocationInfo, Guild guild, Channel channel, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, List list, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i, UserGuildMember userGuildMember, int i2, Object obj) {
                return initialized.copy((i2 & 1) != 0 ? initialized.guildScheduledEvent : guildScheduledEvent, (i2 & 2) != 0 ? initialized.locationInfo : guildScheduledEventLocationInfo, (i2 & 4) != 0 ? initialized.guild : guild, (i2 & 8) != 0 ? initialized.channel : channel, (i2 & 16) != 0 ? initialized.isInGuild : z2, (i2 & 32) != 0 ? initialized.isRsvped : z3, (i2 & 64) != 0 ? initialized.canShare : z4, (i2 & 128) != 0 ? initialized.isConnected : z5, (i2 & 256) != 0 ? initialized.canStartEvent : z6, (i2 & 512) != 0 ? initialized.isDeveloperMode : z7, (i2 & 1024) != 0 ? initialized.canConnect : z8, (i2 & 2048) != 0 ? initialized.rsvpUsers : list, (i2 & 4096) != 0 ? initialized.section : guildScheduledEventDetailsViewModel3, (i2 & 8192) != 0 ? initialized.rsvpUsersFetchState : guildScheduledEventDetailsViewModel2, (i2 & 16384) != 0 ? initialized.segmentedControlIndex : i, (i2 & 32768) != 0 ? initialized.creator : userGuildMember);
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
            public final GuildScheduledEventDetailsViewModel3 getSection() {
                return this.section;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final GuildScheduledEventDetailsViewModel2 getRsvpUsersFetchState() {
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

            public final Initialized copy(GuildScheduledEvent guildScheduledEvent, GuildScheduledEventLocationInfo locationInfo, Guild guild, Channel channel, boolean isInGuild, boolean isRsvped, boolean canShare, boolean isConnected, boolean canStartEvent, boolean isDeveloperMode, boolean canConnect, List<GuildScheduledEventRsvpUserListItem.RsvpUser> rsvpUsers, GuildScheduledEventDetailsViewModel3 section, GuildScheduledEventDetailsViewModel2 rsvpUsersFetchState, int segmentedControlIndex, UserGuildMember creator) {
                Intrinsics3.checkNotNullParameter(guildScheduledEvent, "guildScheduledEvent");
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(rsvpUsers, "rsvpUsers");
                Intrinsics3.checkNotNullParameter(section, "section");
                Intrinsics3.checkNotNullParameter(rsvpUsersFetchState, "rsvpUsersFetchState");
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
                return Intrinsics3.areEqual(this.guildScheduledEvent, initialized.guildScheduledEvent) && Intrinsics3.areEqual(this.locationInfo, initialized.locationInfo) && Intrinsics3.areEqual(this.guild, initialized.guild) && Intrinsics3.areEqual(this.channel, initialized.channel) && this.isInGuild == initialized.isInGuild && this.isRsvped == initialized.isRsvped && this.canShare == initialized.canShare && this.isConnected == initialized.isConnected && this.canStartEvent == initialized.canStartEvent && this.isDeveloperMode == initialized.isDeveloperMode && this.canConnect == initialized.canConnect && Intrinsics3.areEqual(this.rsvpUsers, initialized.rsvpUsers) && Intrinsics3.areEqual(this.section, initialized.section) && Intrinsics3.areEqual(this.rsvpUsersFetchState, initialized.rsvpUsersFetchState) && this.segmentedControlIndex == initialized.segmentedControlIndex && Intrinsics3.areEqual(this.creator, initialized.creator);
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

            public final GuildScheduledEventDetailsViewModel2 getRsvpUsersFetchState() {
                return this.rsvpUsersFetchState;
            }

            public final GuildScheduledEventDetailsViewModel3 getSection() {
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
                GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = this.section;
                int iHashCode6 = (iHashCode5 + (guildScheduledEventDetailsViewModel3 != null ? guildScheduledEventDetailsViewModel3.hashCode() : 0)) * 31;
                GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2 = this.rsvpUsersFetchState;
                int iHashCode7 = (((iHashCode6 + (guildScheduledEventDetailsViewModel2 != null ? guildScheduledEventDetailsViewModel2.hashCode() : 0)) * 31) + this.segmentedControlIndex) * 31;
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
                StringBuilder sbU = outline.U("Initialized(guildScheduledEvent=");
                sbU.append(this.guildScheduledEvent);
                sbU.append(", locationInfo=");
                sbU.append(this.locationInfo);
                sbU.append(", guild=");
                sbU.append(this.guild);
                sbU.append(", channel=");
                sbU.append(this.channel);
                sbU.append(", isInGuild=");
                sbU.append(this.isInGuild);
                sbU.append(", isRsvped=");
                sbU.append(this.isRsvped);
                sbU.append(", canShare=");
                sbU.append(this.canShare);
                sbU.append(", isConnected=");
                sbU.append(this.isConnected);
                sbU.append(", canStartEvent=");
                sbU.append(this.canStartEvent);
                sbU.append(", isDeveloperMode=");
                sbU.append(this.isDeveloperMode);
                sbU.append(", canConnect=");
                sbU.append(this.canConnect);
                sbU.append(", rsvpUsers=");
                sbU.append(this.rsvpUsers);
                sbU.append(", section=");
                sbU.append(this.section);
                sbU.append(", rsvpUsersFetchState=");
                sbU.append(this.rsvpUsersFetchState);
                sbU.append(", segmentedControlIndex=");
                sbU.append(this.segmentedControlIndex);
                sbU.append(", creator=");
                sbU.append(this.creator);
                sbU.append(")");
                return sbU.toString();
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
    public /* synthetic */ GuildScheduledEventDetailsViewModel(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable observable, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        ObservationDeck observationDeck2 = (i2 & 2) != 0 ? ObservationDeck4.get() : observationDeck;
        StoreGuildScheduledEvents guildScheduledEvents = (i2 & 4) != 0 ? StoreStream.INSTANCE.getGuildScheduledEvents() : storeGuildScheduledEvents;
        StoreGuilds guilds = (i2 & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreUser users = (i2 & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i2 & 32) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StorePermissions permissions = (i2 & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreUserSettings userSettings = (i2 & 128) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings;
        StoreVoiceChannelSelected voiceChannelSelected = (i2 & 256) != 0 ? StoreStream.INSTANCE.getVoiceChannelSelected() : storeVoiceChannelSelected;
        StoreDirectories directories = (i2 & 512) != 0 ? StoreStream.INSTANCE.getDirectories() : storeDirectories;
        this(widgetGuildScheduledEventDetailsBottomSheet2, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories, (i2 & 1024) != 0 ? INSTANCE.observeStores(widgetGuildScheduledEventDetailsBottomSheet2, observationDeck2, guildScheduledEvents, guilds, users, channels, permissions, userSettings, voiceChannelSelected, directories) : observable, (i2 & 2048) != 0 ? GuildScheduledEventDetailsViewModel3.EVENT_INFO : guildScheduledEventDetailsViewModel3, (i2 & 4096) != 0 ? GuildScheduledEventDetailsViewModel2.LOADING : guildScheduledEventDetailsViewModel2, (i2 & 8192) != 0 ? 0 : i);
    }

    private final GuildScheduledEventDetailsViewModel2 getRsvpUsersFetchState(StoreState storeState) {
        if (storeState.isRsvpUsersFetching() && storeState.getRsvpUsers().isEmpty()) {
            return GuildScheduledEventDetailsViewModel2.LOADING;
        }
        if (storeState.isRsvpUsersError()) {
            return GuildScheduledEventDetailsViewModel2.ERROR;
        }
        return storeState.getRsvpUsers().isEmpty() ? GuildScheduledEventDetailsViewModel2.EMPTY : GuildScheduledEventDetailsViewModel2.SUCCESS;
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
            GuildScheduledEventLocationInfo guildScheduledEventLocationInfoBuildLocationInfo = (this.args.getSource() == WidgetGuildScheduledEventDetailsBottomSheet3.Guild || storeState.getGuildScheduledEvent().getEntityType() == GuildScheduledEventEntityType.EXTERNAL || storeState.isInGuild()) ? GuildScheduledEventLocationInfo.INSTANCE.buildLocationInfo(storeState.getGuildScheduledEvent(), storeState.getChannel()) : null;
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
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(GuildScheduledEventAPI.INSTANCE.endEvent(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId()), false, 1, null), (Class<?>) GuildScheduledEventDetailsViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new GuildScheduledEventDetailsViewModel6(this, context, onSuccess));
        }
    }

    public final void onDeleteButtonClicked(Context context, Function0<Unit> onSuccess) {
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(onSuccess, "onSuccess");
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Initialized)) {
            viewState = null;
        }
        ViewState.Initialized initialized = (ViewState.Initialized) viewState;
        if (initialized != null) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().deleteGuildScheduledEvent(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId()), false, 1, null), (Class<?>) GuildScheduledEventDetailsViewModel.class, (58 & 2) != 0 ? null : context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new GuildScheduledEventDetailsViewModel7(this, context, onSuccess));
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
        Intrinsics3.checkNotNullParameter(weakFragment, "weakFragment");
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
                Intrinsics3.checkNotNullExpressionValue(fragment, "weakFragment.get() ?: return");
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
            GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3 = index == 0 ? GuildScheduledEventDetailsViewModel3.EVENT_INFO : GuildScheduledEventDetailsViewModel3.RSVP_LIST;
            this.section = guildScheduledEventDetailsViewModel3;
            if (guildScheduledEventDetailsViewModel3 == GuildScheduledEventDetailsViewModel3.RSVP_LIST) {
                this.guildScheduledEventsStore.fetchGuildScheduledEventUsers(initialized.getGuildScheduledEvent().getGuildId(), initialized.getGuildScheduledEvent().getId());
                if (initialized.getRsvpUsers().isEmpty()) {
                    this.rsvpUsersFetchState = GuildScheduledEventDetailsViewModel2.LOADING;
                }
            }
            updateViewState(ViewState.Initialized.copy$default(initialized, null, null, null, null, false, false, false, false, false, false, false, null, this.section, this.rsvpUsersFetchState, this.segmentControlIndex, null, 36863, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildScheduledEventDetailsViewModel(WidgetGuildScheduledEventDetailsBottomSheet2 widgetGuildScheduledEventDetailsBottomSheet2, ObservationDeck observationDeck, StoreGuildScheduledEvents storeGuildScheduledEvents, StoreGuilds storeGuilds, StoreUser storeUser, StoreChannels storeChannels, StorePermissions storePermissions, StoreUserSettings storeUserSettings, StoreVoiceChannelSelected storeVoiceChannelSelected, StoreDirectories storeDirectories, Observable<StoreState> observable, GuildScheduledEventDetailsViewModel3 guildScheduledEventDetailsViewModel3, GuildScheduledEventDetailsViewModel2 guildScheduledEventDetailsViewModel2, int i) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(widgetGuildScheduledEventDetailsBottomSheet2, "args");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(storeGuildScheduledEvents, "guildScheduledEventsStore");
        Intrinsics3.checkNotNullParameter(storeGuilds, "guildsStore");
        Intrinsics3.checkNotNullParameter(storeUser, "userStore");
        Intrinsics3.checkNotNullParameter(storeChannels, "channelsStore");
        Intrinsics3.checkNotNullParameter(storePermissions, "permissionsStore");
        Intrinsics3.checkNotNullParameter(storeUserSettings, "userSettingsStore");
        Intrinsics3.checkNotNullParameter(storeVoiceChannelSelected, "selectedVoiceChannelStore");
        Intrinsics3.checkNotNullParameter(storeDirectories, "directoriesStore");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel3, "section");
        Intrinsics3.checkNotNullParameter(guildScheduledEventDetailsViewModel2, "rsvpUsersFetchState");
        this.args = widgetGuildScheduledEventDetailsBottomSheet2;
        this.guildScheduledEventsStore = storeGuildScheduledEvents;
        this.userStore = storeUser;
        this.section = guildScheduledEventDetailsViewModel3;
        this.rsvpUsersFetchState = guildScheduledEventDetailsViewModel2;
        this.segmentControlIndex = i;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildScheduledEventDetailsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
    }
}
