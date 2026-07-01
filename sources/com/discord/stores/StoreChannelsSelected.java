package com.discord.stores;

import a0.a.a.b;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.error.Error;
import com.discord.utilities.frecency.FrecencyTracker;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.user.search.ChannelFrecencyTracker;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: StoreChannelsSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelsSelected extends StoreV2 {
    private static final String CACHE_KEY_SELECTED_CHANNEL_IDS = "CACHE_KEY_SELECTED_CHANNEL_IDS";
    public static final long ID_THREAD_DRAFT = -3;
    public static final long ID_UNAVAILABLE = -1;
    public static final long ID_UNINITIALIZED = -2;
    public static final long ID_UNSELECTED = 0;
    private final Dispatcher dispatcher;
    private final ChannelFrecencyTracker frecency;
    private final Persister<ChannelFrecencyTracker> frecencyCache;
    private boolean handledReadyPayload;
    private boolean initializedForAuthedUser;
    private boolean isStoreInitTimedOut;
    private final ObservationDeck observationDeck;
    private ResolvedSelectedChannel previouslySelectedChannel;
    private ResolvedSelectedChannel selectedChannel;
    private final Persister<Map<Long, Long>> selectedChannelIdsCache;
    private final StoreChannels storeChannels;
    private final StoreGuildSelected storeGuildSelected;
    private final StorePermissions storePermissions;
    private final StoreStream stream;
    private final Map<Long, UserChannelSelection> userChannelSelections;
    private Subscription validateSelectedChannelSubscription;
    private static final StoreChannelsSelected4 InitializedUpdateSource = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreChannelsSelected$Companion$InitializedUpdateSource$1
    };

    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static abstract class ResolvedSelectedChannel {

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final /* data */ class Channel extends ResolvedSelectedChannel {
            private final StoreChannelsSelected3 analyticsLocation;
            private final StoreChannelsSelected2 analyticsViewType;
            private final com.discord.api.channel.Channel channel;
            private final Long peekParent;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Channel(com.discord.api.channel.Channel channel, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.peekParent = l;
                this.analyticsLocation = storeChannelsSelected3;
                this.analyticsViewType = l != null ? StoreChannelsSelected2.PEEK_VIEW : StoreChannelsSelected2.FULL_VIEW;
            }

            public static /* synthetic */ Channel copy$default(Channel channel, com.discord.api.channel.Channel channel2, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel2 = channel.channel;
                }
                if ((i & 2) != 0) {
                    l = channel.peekParent;
                }
                if ((i & 4) != 0) {
                    storeChannelsSelected3 = channel.analyticsLocation;
                }
                return channel.copy(channel2, l, storeChannelsSelected3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final com.discord.api.channel.Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getPeekParent() {
                return this.peekParent;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final Channel copy(com.discord.api.channel.Channel channel, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new Channel(channel, peekParent, analyticsLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Channel)) {
                    return false;
                }
                Channel channel = (Channel) other;
                return Intrinsics3.areEqual(this.channel, channel.channel) && Intrinsics3.areEqual(this.peekParent, channel.peekParent) && Intrinsics3.areEqual(this.analyticsLocation, channel.analyticsLocation);
            }

            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final StoreChannelsSelected2 getAnalyticsViewType() {
                return this.analyticsViewType;
            }

            public final com.discord.api.channel.Channel getChannel() {
                return this.channel;
            }

            public final Long getPeekParent() {
                return this.peekParent;
            }

            public int hashCode() {
                com.discord.api.channel.Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Long l = this.peekParent;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                StoreChannelsSelected3 storeChannelsSelected3 = this.analyticsLocation;
                return iHashCode2 + (storeChannelsSelected3 != null ? storeChannelsSelected3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Channel(channel=");
                sbU.append(this.channel);
                sbU.append(", peekParent=");
                sbU.append(this.peekParent);
                sbU.append(", analyticsLocation=");
                sbU.append(this.analyticsLocation);
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final /* data */ class ThreadDraft extends ResolvedSelectedChannel {
            private final com.discord.api.channel.Channel parentChannel;
            private final Long starterMessageId;
            private final String threadStartLocation;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ThreadDraft(com.discord.api.channel.Channel channel, Long l, String str) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "parentChannel");
                this.parentChannel = channel;
                this.starterMessageId = l;
                this.threadStartLocation = str;
            }

            public static /* synthetic */ ThreadDraft copy$default(ThreadDraft threadDraft, com.discord.api.channel.Channel channel, Long l, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = threadDraft.parentChannel;
                }
                if ((i & 2) != 0) {
                    l = threadDraft.starterMessageId;
                }
                if ((i & 4) != 0) {
                    str = threadDraft.threadStartLocation;
                }
                return threadDraft.copy(channel, l, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final com.discord.api.channel.Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getThreadStartLocation() {
                return this.threadStartLocation;
            }

            public final ThreadDraft copy(com.discord.api.channel.Channel parentChannel, Long starterMessageId, String threadStartLocation) {
                Intrinsics3.checkNotNullParameter(parentChannel, "parentChannel");
                return new ThreadDraft(parentChannel, starterMessageId, threadStartLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ThreadDraft)) {
                    return false;
                }
                ThreadDraft threadDraft = (ThreadDraft) other;
                return Intrinsics3.areEqual(this.parentChannel, threadDraft.parentChannel) && Intrinsics3.areEqual(this.starterMessageId, threadDraft.starterMessageId) && Intrinsics3.areEqual(this.threadStartLocation, threadDraft.threadStartLocation);
            }

            public final com.discord.api.channel.Channel getParentChannel() {
                return this.parentChannel;
            }

            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            public final String getThreadStartLocation() {
                return this.threadStartLocation;
            }

            public final boolean hasStarterMessage() {
                return this.starterMessageId != null;
            }

            public int hashCode() {
                com.discord.api.channel.Channel channel = this.parentChannel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Long l = this.starterMessageId;
                int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
                String str = this.threadStartLocation;
                return iHashCode2 + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ThreadDraft(parentChannel=");
                sbU.append(this.parentChannel);
                sbU.append(", starterMessageId=");
                sbU.append(this.starterMessageId);
                sbU.append(", threadStartLocation=");
                return outline.J(sbU, this.threadStartLocation, ")");
            }
        }

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final class Unavailable extends ResolvedSelectedChannel {
            public static final Unavailable INSTANCE = new Unavailable();

            private Unavailable() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final class Uninitialized extends ResolvedSelectedChannel {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final class Unselected extends ResolvedSelectedChannel {
            public static final Unselected INSTANCE = new Unselected();

            private Unselected() {
                super(null);
            }
        }

        private ResolvedSelectedChannel() {
        }

        public final com.discord.api.channel.Channel getChannelOrParent() {
            if (this instanceof Channel) {
                return ((Channel) this).getChannel();
            }
            if (this instanceof ThreadDraft) {
                return ((ThreadDraft) this).getParentChannel();
            }
            return null;
        }

        public final long getId() {
            if (this instanceof Channel) {
                return ((Channel) this).getChannel().getId();
            }
            if (this instanceof ThreadDraft) {
                return -3L;
            }
            if (Intrinsics3.areEqual(this, Unselected.INSTANCE)) {
                return 0L;
            }
            if (Intrinsics3.areEqual(this, Unavailable.INSTANCE)) {
                return -1L;
            }
            if (Intrinsics3.areEqual(this, Uninitialized.INSTANCE)) {
                return -2L;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final com.discord.api.channel.Channel getMaybeChannel() {
            Channel channel = (Channel) (!(this instanceof Channel) ? null : this);
            if (channel != null) {
                return channel.getChannel();
            }
            return null;
        }

        public /* synthetic */ ResolvedSelectedChannel(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static abstract class UserChannelSelection {

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final /* data */ class SelectedChannel extends UserChannelSelection {
            private final StoreChannelsSelected3 analyticsLocation;
            private final long channelId;
            private final Long peekParent;

            public /* synthetic */ SelectedChannel(long j, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(j, (i & 2) != 0 ? null : l, (i & 4) != 0 ? null : storeChannelsSelected3);
            }

            public static /* synthetic */ SelectedChannel copy$default(SelectedChannel selectedChannel, long j, Long l, StoreChannelsSelected3 storeChannelsSelected3, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = selectedChannel.channelId;
                }
                if ((i & 2) != 0) {
                    l = selectedChannel.peekParent;
                }
                if ((i & 4) != 0) {
                    storeChannelsSelected3 = selectedChannel.analyticsLocation;
                }
                return selectedChannel.copy(j, l, storeChannelsSelected3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getPeekParent() {
                return this.peekParent;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final SelectedChannel copy(long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
                return new SelectedChannel(channelId, peekParent, analyticsLocation);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SelectedChannel)) {
                    return false;
                }
                SelectedChannel selectedChannel = (SelectedChannel) other;
                return this.channelId == selectedChannel.channelId && Intrinsics3.areEqual(this.peekParent, selectedChannel.peekParent) && Intrinsics3.areEqual(this.analyticsLocation, selectedChannel.analyticsLocation);
            }

            public final StoreChannelsSelected3 getAnalyticsLocation() {
                return this.analyticsLocation;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final Long getPeekParent() {
                return this.peekParent;
            }

            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                Long l = this.peekParent;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                StoreChannelsSelected3 storeChannelsSelected3 = this.analyticsLocation;
                return iHashCode + (storeChannelsSelected3 != null ? storeChannelsSelected3.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SelectedChannel(channelId=");
                sbU.append(this.channelId);
                sbU.append(", peekParent=");
                sbU.append(this.peekParent);
                sbU.append(", analyticsLocation=");
                sbU.append(this.analyticsLocation);
                sbU.append(")");
                return sbU.toString();
            }

            public SelectedChannel(long j, Long l, StoreChannelsSelected3 storeChannelsSelected3) {
                super(null);
                this.channelId = j;
                this.peekParent = l;
                this.analyticsLocation = storeChannelsSelected3;
            }
        }

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final /* data */ class ThreadDraft extends UserChannelSelection {
            private final String locationThreadStart;
            private final long parentChannelId;
            private final Long starterMessageId;

            public ThreadDraft(long j, Long l, String str) {
                super(null);
                this.parentChannelId = j;
                this.starterMessageId = l;
                this.locationThreadStart = str;
            }

            public static /* synthetic */ ThreadDraft copy$default(ThreadDraft threadDraft, long j, Long l, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = threadDraft.parentChannelId;
                }
                if ((i & 2) != 0) {
                    l = threadDraft.starterMessageId;
                }
                if ((i & 4) != 0) {
                    str = threadDraft.locationThreadStart;
                }
                return threadDraft.copy(j, l, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getParentChannelId() {
                return this.parentChannelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getLocationThreadStart() {
                return this.locationThreadStart;
            }

            public final ThreadDraft copy(long parentChannelId, Long starterMessageId, String locationThreadStart) {
                return new ThreadDraft(parentChannelId, starterMessageId, locationThreadStart);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ThreadDraft)) {
                    return false;
                }
                ThreadDraft threadDraft = (ThreadDraft) other;
                return this.parentChannelId == threadDraft.parentChannelId && Intrinsics3.areEqual(this.starterMessageId, threadDraft.starterMessageId) && Intrinsics3.areEqual(this.locationThreadStart, threadDraft.locationThreadStart);
            }

            public final String getLocationThreadStart() {
                return this.locationThreadStart;
            }

            public final long getParentChannelId() {
                return this.parentChannelId;
            }

            public final Long getStarterMessageId() {
                return this.starterMessageId;
            }

            public int hashCode() {
                int iA = b.a(this.parentChannelId) * 31;
                Long l = this.starterMessageId;
                int iHashCode = (iA + (l != null ? l.hashCode() : 0)) * 31;
                String str = this.locationThreadStart;
                return iHashCode + (str != null ? str.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("ThreadDraft(parentChannelId=");
                sbU.append(this.parentChannelId);
                sbU.append(", starterMessageId=");
                sbU.append(this.starterMessageId);
                sbU.append(", locationThreadStart=");
                return outline.J(sbU, this.locationThreadStart, ")");
            }
        }

        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final class Unselected extends UserChannelSelection {
            public static final Unselected INSTANCE = new Unselected();

            private Unselected() {
                super(null);
            }
        }

        private UserChannelSelection() {
        }

        public final long getId() {
            if (this instanceof SelectedChannel) {
                return ((SelectedChannel) this).getChannelId();
            }
            if (this instanceof ThreadDraft) {
                return ((ThreadDraft) this).getParentChannelId();
            }
            if (Intrinsics3.areEqual(this, Unselected.INSTANCE)) {
                return 0L;
            }
            throw new NoWhenBranchMatchedException();
        }

        public final ResolvedSelectedChannel resolveWithChannel(Channel channel) {
            ResolvedSelectedChannel threadDraft;
            Intrinsics3.checkNotNullParameter(channel, "channel");
            if (this instanceof Unselected) {
                return ResolvedSelectedChannel.Unselected.INSTANCE;
            }
            if (this instanceof SelectedChannel) {
                SelectedChannel selectedChannel = (SelectedChannel) this;
                threadDraft = new ResolvedSelectedChannel.Channel(channel, selectedChannel.getPeekParent(), selectedChannel.getAnalyticsLocation());
            } else {
                if (!(this instanceof ThreadDraft)) {
                    throw new NoWhenBranchMatchedException();
                }
                ThreadDraft threadDraft2 = (ThreadDraft) this;
                threadDraft = new ResolvedSelectedChannel.ThreadDraft(channel, threadDraft2.getStarterMessageId(), threadDraft2.getLocationThreadStart());
            }
            return threadDraft;
        }

        public /* synthetic */ UserChannelSelection(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$observeId$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreChannelsSelected.this.getId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$observePreviousId$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Long> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Long invoke() {
            return Long.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final long invoke2() {
            return StoreChannelsSelected.this.previouslySelectedChannel.getId();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$observeResolvedSelectedChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ResolvedSelectedChannel> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResolvedSelectedChannel invoke() {
            return StoreChannelsSelected.this.selectedChannel;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$observeSelectedChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Channel> {
        public AnonymousClass1() {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Channel invoke() {
            return StoreChannelsSelected.this.getSelectedChannel();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<ResolvedSelectedChannel> {
        public final /* synthetic */ Map $allChannels;
        public final /* synthetic */ UserChannelSelection $channelSelection;
        public final /* synthetic */ boolean $isChannelStoreInitializedForAuthedUser;
        public final /* synthetic */ Map $permissionsForChannelsInGuild;
        public final /* synthetic */ long $selectedGuildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(UserChannelSelection userChannelSelection, Map map, long j, Map map2, boolean z2) {
            super(0);
            this.$channelSelection = userChannelSelection;
            this.$allChannels = map;
            this.$selectedGuildId = j;
            this.$permissionsForChannelsInGuild = map2;
            this.$isChannelStoreInitializedForAuthedUser = z2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ResolvedSelectedChannel invoke() {
            UserChannelSelection userChannelSelection = this.$channelSelection;
            return StoreChannelsSelected.this.resolveSelectedChannel(this.$channelSelection, userChannelSelection != null ? StoreChannelsSelected.this.storeChannels.getChannel(userChannelSelection.getId()) : null, this.$allChannels, this.$selectedGuildId, this.$permissionsForChannelsInGuild, this.$isChannelStoreInitializedForAuthedUser);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Subscription, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            Intrinsics3.checkNotNullParameter(subscription, "it");
            StoreChannelsSelected.this.validateSelectedChannelSubscription = subscription;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreChannelsSelected.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<ResolvedSelectedChannel, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$validateSelectedChannel$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreChannelsSelected.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ ResolvedSelectedChannel $selected;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(ResolvedSelectedChannel resolvedSelectedChannel) {
                super(0);
                this.$selected = resolvedSelectedChannel;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChannelsSelected storeChannelsSelected = StoreChannelsSelected.this;
                ResolvedSelectedChannel resolvedSelectedChannel = this.$selected;
                Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "selected");
                storeChannelsSelected.onSelectedChannelResolved(resolvedSelectedChannel);
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ResolvedSelectedChannel resolvedSelectedChannel) {
            invoke2(resolvedSelectedChannel);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ResolvedSelectedChannel resolvedSelectedChannel) {
            StoreChannelsSelected.this.dispatcher.schedule(new AnonymousClass1(resolvedSelectedChannel));
        }
    }

    public StoreChannelsSelected(StoreStream storeStream, StoreChannels storeChannels, StorePermissions storePermissions, StoreGuildSelected storeGuildSelected, Dispatcher dispatcher, ObservationDeck observationDeck) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeGuildSelected, "storeGuildSelected");
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        this.stream = storeStream;
        this.storeChannels = storeChannels;
        this.storePermissions = storePermissions;
        this.storeGuildSelected = storeGuildSelected;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.userChannelSelections = new HashMap();
        this.selectedChannelIdsCache = new Persister<>(CACHE_KEY_SELECTED_CHANNEL_IDS, new HashMap());
        ResolvedSelectedChannel.Uninitialized uninitialized = ResolvedSelectedChannel.Uninitialized.INSTANCE;
        this.selectedChannel = uninitialized;
        this.previouslySelectedChannel = uninitialized;
        Persister<ChannelFrecencyTracker> persister = new Persister<>("CHANNEL_HISTORY_V3", new ChannelFrecencyTracker());
        this.frecencyCache = persister;
        this.frecency = persister.get();
    }

    private final Channel getFirstAvailableChannel(Map<Long, Channel> channels, long guildId, Map<Long, Long> permissions) {
        Collection<Channel> collectionValues = channels.values();
        ArrayList arrayList = new ArrayList();
        for (Object obj : collectionValues) {
            Channel channel = (Channel) obj;
            if (channel.getGuildId() == guildId && ChannelUtils.v(channel) && PermissionUtils.hasAccess(channel, permissions)) {
                arrayList.add(obj);
            }
        }
        return (Channel) _Collections.firstOrNull(_Collections.sortedWith(arrayList, ChannelUtils.h(Channel.INSTANCE)));
    }

    private final boolean isValidResolution(Channel channel, long guildId, Map<Long, Long> permissions) {
        return channel.getGuildId() == guildId && ChannelUtils.G(channel) && PermissionUtils.hasAccess(channel, permissions);
    }

    @Store3
    private final void loadFromCache() {
        Map<Long, UserChannelSelection> map = this.userChannelSelections;
        Map<Long, Long> map2 = this.selectedChannelIdsCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map2.size()));
        Iterator<T> it = map2.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), new UserChannelSelection.SelectedChannel(((Number) entry.getValue()).longValue(), null, null, 6, null));
        }
        map.putAll(linkedHashMap);
    }

    @Store3
    private final void onSelectedChannelResolved(ResolvedSelectedChannel resolvedSelectedChannel) {
        if (this.selectedChannel.getId() != resolvedSelectedChannel.getId()) {
            this.previouslySelectedChannel = this.selectedChannel;
        }
        this.selectedChannel = resolvedSelectedChannel;
        boolean z2 = resolvedSelectedChannel instanceof ResolvedSelectedChannel.Channel;
        if (z2) {
            ResolvedSelectedChannel.Channel channel = (ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
            this.userChannelSelections.put(Long.valueOf(channel.getChannel().getGuildId()), new UserChannelSelection.SelectedChannel(channel.getChannel().getId(), channel.getPeekParent(), null, 4, null));
            FrecencyTracker.track$default(this.frecency, Long.valueOf(channel.getChannel().getId()), 0L, 2, null);
        }
        if (z2) {
            ResolvedSelectedChannel.Channel channel2 = (ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
            if (ChannelUtils.J(channel2.getChannel())) {
                this.stream.getAnalytics().trackTextInVoiceOpened(resolvedSelectedChannel.getId(), channel2.getAnalyticsLocation());
            }
            this.stream.getAnalytics().trackChannelOpened(resolvedSelectedChannel.getId(), channel2.getAnalyticsViewType(), channel2.getAnalyticsLocation());
        }
        updateInitializationState();
        markChanged();
    }

    private final ResolvedSelectedChannel resolveSelectedChannel(UserChannelSelection userChannelSelection, Channel resolvedChannel, Map<Long, Channel> channels, long guildId, Map<Long, Long> permissions, boolean storeChannelsInitializedForAuthedUser) {
        ResolvedSelectedChannel resolvedSelectedChannelResolveWithChannel;
        if (!storeChannelsInitializedForAuthedUser) {
            return ResolvedSelectedChannel.Uninitialized.INSTANCE;
        }
        if (resolvedChannel != null && isValidResolution(resolvedChannel, guildId, permissions)) {
            return (userChannelSelection == null || (resolvedSelectedChannelResolveWithChannel = userChannelSelection.resolveWithChannel(resolvedChannel)) == null) ? ResolvedSelectedChannel.Unselected.INSTANCE : resolvedSelectedChannelResolveWithChannel;
        }
        if (guildId == 0) {
            return ResolvedSelectedChannel.Unselected.INSTANCE;
        }
        Channel firstAvailableChannel = getFirstAvailableChannel(channels, guildId, permissions);
        return firstAvailableChannel == null ? ResolvedSelectedChannel.Unavailable.INSTANCE : new ResolvedSelectedChannel.Channel(firstAvailableChannel, null, null);
    }

    @Store3
    private final void updateInitializationState() {
        boolean z2 = this.stream.getAuthentication().getAuthState() != null;
        boolean z3 = this.initializedForAuthedUser;
        boolean z4 = z2 && this.storeChannels.getInitializedForAuthedUser() && ((this.userChannelSelections.isEmpty() ^ true) || this.handledReadyPayload || this.isStoreInitTimedOut) && (Intrinsics3.areEqual(this.selectedChannel, ResolvedSelectedChannel.Uninitialized.INSTANCE) ^ true);
        if (z3 || !z4) {
            return;
        }
        this.initializedForAuthedUser = true;
        markChanged(InitializedUpdateSource);
    }

    @Store3
    private final void validateSelectedChannel() {
        Subscription subscription = this.validateSelectedChannelSubscription;
        if (subscription != null) {
            subscription.unsubscribe();
        }
        Map<Long, Channel> channelsByIdInternal$app_productionGoogleRelease = this.storeChannels.getChannelsByIdInternal$app_productionGoogleRelease();
        boolean initializedForAuthedUser = this.storeChannels.getInitializedForAuthedUser();
        long selectedGuildIdInternal$app_productionGoogleRelease = this.storeGuildSelected.getSelectedGuildIdInternal$app_productionGoogleRelease();
        Observable observableR = ObservableExtensionsKt.computationLatest(ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeGuildSelected, this.storeChannels, this.storePermissions}, false, null, null, new AnonymousClass1(this.userChannelSelections.get(Long.valueOf(selectedGuildIdInternal$app_productionGoogleRelease)), channelsByIdInternal$app_productionGoogleRelease, selectedGuildIdInternal$app_productionGoogleRelease, this.storePermissions.getPermissionsByChannelInternal$app_productionGoogleRelease(selectedGuildIdInternal$app_productionGoogleRelease), initializedForAuthedUser), 14, null)).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observationDeck\n        …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) StoreChannelsSelected.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new AnonymousClass2()), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }

    @Store3
    public final void dismissCreateThread() {
        ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        if (!(resolvedSelectedChannel instanceof ResolvedSelectedChannel.ThreadDraft)) {
            resolvedSelectedChannel = null;
        }
        ResolvedSelectedChannel.ThreadDraft threadDraft = (ResolvedSelectedChannel.ThreadDraft) resolvedSelectedChannel;
        if (threadDraft != null) {
            Channel parentChannel = threadDraft.getParentChannel();
            this.userChannelSelections.put(Long.valueOf(parentChannel.getGuildId()), new UserChannelSelection.SelectedChannel(parentChannel.getId(), null, null, 6, null));
            validateSelectedChannel();
        }
    }

    public final ChannelFrecencyTracker getFrecency() {
        return this.frecency;
    }

    public final long getId() {
        return this.selectedChannel.getId();
    }

    public final Channel getSelectedChannel() {
        ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        if (!(resolvedSelectedChannel instanceof ResolvedSelectedChannel.Channel)) {
            resolvedSelectedChannel = null;
        }
        ResolvedSelectedChannel.Channel channel = (ResolvedSelectedChannel.Channel) resolvedSelectedChannel;
        if (channel != null) {
            return channel.getChannel();
        }
        return null;
    }

    @Store3
    public final void handleChannelOrThreadCreateOrUpdate(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (channel.getId() == this.selectedChannel.getId()) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void handleChannelOrThreadDelete(Channel channel) {
        Intrinsics3.checkNotNullParameter(channel, "channel");
        if (channel.getId() == this.selectedChannel.getId()) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        Intrinsics3.checkNotNullExpressionValue(guilds, "payload.guilds");
        HashSet hashSetHashSetOf = Sets5.hashSetOf(0L);
        Iterator<T> it = guilds.iterator();
        while (it.hasNext()) {
            hashSetHashSetOf.add(Long.valueOf(((Guild) it.next()).getId()));
        }
        Map<Long, UserChannelSelection> map = this.userChannelSelections;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<Long, UserChannelSelection> entry : map.entrySet()) {
            if (hashSetHashSetOf.contains(Long.valueOf(entry.getKey().longValue()))) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<? extends Long, ? extends UserChannelSelection> mutableMap = Maps6.toMutableMap(linkedHashMap);
        if (!mutableMap.containsKey(0L)) {
            mutableMap.put(0L, UserChannelSelection.Unselected.INSTANCE);
        }
        this.userChannelSelections.clear();
        this.userChannelSelections.putAll(mutableMap);
        this.handledReadyPayload = true;
        validateSelectedChannel();
    }

    @Store3
    public final void handleGuildAdd(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        if (this.storeGuildSelected.getSelectedGuildIdInternal$app_productionGoogleRelease() == guild.getId()) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void handleGuildRemove(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Channel maybeChannel = this.selectedChannel.getMaybeChannel();
        if (maybeChannel == null || maybeChannel.getGuildId() != guild.getId()) {
            return;
        }
        validateSelectedChannel();
    }

    @Store3
    public final void handleGuildSelected() {
        validateSelectedChannel();
    }

    @Store3
    public final void handleStoreInitTimeout() {
        this.isStoreInitTimedOut = true;
        updateInitializationState();
        if (Intrinsics3.areEqual(this.selectedChannel, ResolvedSelectedChannel.Uninitialized.INSTANCE)) {
            validateSelectedChannel();
        }
    }

    @Store3
    public final void init() {
        loadFromCache();
        validateSelectedChannel();
    }

    public final Observable<Long> observeId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Boolean> observeInitializedForAuthedUser() {
        Observable observableY = this.storeChannels.observeInitializedForAuthedUser().Y(new Func1<Boolean, Observable<? extends Boolean>>() { // from class: com.discord.stores.StoreChannelsSelected.observeInitializedForAuthedUser.1

            /* JADX INFO: renamed from: com.discord.stores.StoreChannelsSelected$observeInitializedForAuthedUser$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: StoreChannelsSelected.kt */
            public static final class C01061 extends Lambda implements Function0<Boolean> {
                public C01061() {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Boolean invoke() {
                    return Boolean.valueOf(invoke2());
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final boolean invoke2() {
                    return StoreChannelsSelected.this.initializedForAuthedUser;
                }
            }

            @Override // j0.k.Func1
            public final Observable<? extends Boolean> call(Boolean bool) {
                Intrinsics3.checkNotNullExpressionValue(bool, "isStoreChannelsInitialized");
                return bool.booleanValue() ? ObservationDeck.connectRx$default(StoreChannelsSelected.this.observationDeck, new ObservationDeck.UpdateSource[]{StoreChannelsSelected.InitializedUpdateSource}, false, null, null, new C01061(), 14, null) : new ScalarSynchronousObservable(Boolean.FALSE);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels.observeIni…            }\n          }");
        return observableY;
    }

    public final Observable<Long> observePreviousId() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<ResolvedSelectedChannel> observeResolvedSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    public final Observable<Channel> observeSelectedChannel() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(), 14, null);
    }

    @Store3
    public final void openCreateThread(long guildId, long channelId, Long parentMessageId, String threadStartLocation) {
        this.userChannelSelections.put(Long.valueOf(guildId), new UserChannelSelection.ThreadDraft(channelId, parentMessageId, threadStartLocation));
        validateSelectedChannel();
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        Persister.set$default(this.frecencyCache, this.frecency, false, 2, null);
        Map<Long, UserChannelSelection> map = this.userChannelSelections;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsJVM.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            linkedHashMap.put(entry.getKey(), Long.valueOf(((UserChannelSelection) entry.getValue()).getId()));
        }
        this.selectedChannelIdsCache.set(linkedHashMap, true);
    }

    @Store3
    public final void trySelectChannel(long guildId, long channelId, Long peekParent, StoreChannelsSelected3 analyticsLocation) {
        UserChannelSelection userChannelSelection = this.userChannelSelections.get(Long.valueOf(guildId));
        if (!(userChannelSelection instanceof UserChannelSelection.SelectedChannel)) {
            userChannelSelection = null;
        }
        UserChannelSelection.SelectedChannel selectedChannel = (UserChannelSelection.SelectedChannel) userChannelSelection;
        if (selectedChannel == null || selectedChannel.getChannelId() != channelId) {
            this.userChannelSelections.put(Long.valueOf(guildId), new UserChannelSelection.SelectedChannel(channelId, peekParent, analyticsLocation));
            validateSelectedChannel();
        }
    }
}
