package com.discord.widgets.channels;

import a0.a.a.b;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelNotificationSettings;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuildsNsfw;
import com.discord.stores.StoreNavigation;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Iterator;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActionsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActionsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            WidgetChannelSidebarActionsViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildNSFW, StoreUser storeUser) {
            Observable observableY = storeNavigation.observeRightPanelState().Y(new WidgetChannelSidebarActionsViewModel2(storeChannelsSelected, storeUserGuildSettings, storeUser, storeChannels, storeGuildNSFW));
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeNavigation\n        …          }\n            }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreNavigation storeNavigation, StoreChannels storeChannels, StoreChannelsSelected storeChannelsSelected, StoreUserGuildSettings storeUserGuildSettings, StoreGuildsNsfw storeGuildsNsfw, StoreUser storeUser, int i, Object obj) {
            if ((i & 1) != 0) {
                storeNavigation = StoreStream.INSTANCE.getNavigation();
            }
            if ((i & 2) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 4) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 8) != 0) {
                storeUserGuildSettings = StoreStream.INSTANCE.getUserGuildSettings();
            }
            StoreUserGuildSettings storeUserGuildSettings2 = storeUserGuildSettings;
            if ((i & 16) != 0) {
                storeGuildsNsfw = StoreStream.INSTANCE.getGuildsNsfw();
            }
            StoreGuildsNsfw storeGuildsNsfw2 = storeGuildsNsfw;
            if ((i & 32) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            return companion.observeStoreState(storeNavigation, storeChannels2, storeChannelsSelected2, storeUserGuildSettings2, storeGuildsNsfw2, storeUser);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final /* data */ class ChannelFound extends StoreState {
            private final Channel channel;
            private final boolean disablePins;
            private final ModelNotificationSettings guildNotificationSettings;
            private final Channel parentChannel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public ChannelFound(Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2) {
                super(null);
                Intrinsics3.checkNotNullParameter(channel, "channel");
                this.channel = channel;
                this.parentChannel = channel2;
                this.guildNotificationSettings = modelNotificationSettings;
                this.disablePins = z2;
            }

            public static /* synthetic */ ChannelFound copy$default(ChannelFound channelFound, Channel channel, Channel channel2, ModelNotificationSettings modelNotificationSettings, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = channelFound.channel;
                }
                if ((i & 2) != 0) {
                    channel2 = channelFound.parentChannel;
                }
                if ((i & 4) != 0) {
                    modelNotificationSettings = channelFound.guildNotificationSettings;
                }
                if ((i & 8) != 0) {
                    z2 = channelFound.disablePins;
                }
                return channelFound.copy(channel, channel2, modelNotificationSettings, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ModelNotificationSettings getGuildNotificationSettings() {
                return this.guildNotificationSettings;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final ChannelFound copy(Channel channel, Channel parentChannel, ModelNotificationSettings guildNotificationSettings, boolean disablePins) {
                Intrinsics3.checkNotNullParameter(channel, "channel");
                return new ChannelFound(channel, parentChannel, guildNotificationSettings, disablePins);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ChannelFound)) {
                    return false;
                }
                ChannelFound channelFound = (ChannelFound) other;
                return Intrinsics3.areEqual(this.channel, channelFound.channel) && Intrinsics3.areEqual(this.parentChannel, channelFound.parentChannel) && Intrinsics3.areEqual(this.guildNotificationSettings, channelFound.guildNotificationSettings) && this.disablePins == channelFound.disablePins;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final ModelNotificationSettings getGuildNotificationSettings() {
                return this.guildNotificationSettings;
            }

            public final Channel getParentChannel() {
                return this.parentChannel;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Channel channel2 = this.parentChannel;
                int iHashCode2 = (iHashCode + (channel2 != null ? channel2.hashCode() : 0)) * 31;
                ModelNotificationSettings modelNotificationSettings = this.guildNotificationSettings;
                int iHashCode3 = (iHashCode2 + (modelNotificationSettings != null ? modelNotificationSettings.hashCode() : 0)) * 31;
                boolean z2 = this.disablePins;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode3 + r1;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ChannelFound(channel=");
                sbU.append(this.channel);
                sbU.append(", parentChannel=");
                sbU.append(this.parentChannel);
                sbU.append(", guildNotificationSettings=");
                sbU.append(this.guildNotificationSettings);
                sbU.append(", disablePins=");
                return outline.O(sbU, this.disablePins, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final class ChannelNotFound extends StoreState {
            public static final ChannelNotFound INSTANCE = new ChannelNotFound();

            private ChannelNotFound() {
                super(null);
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final /* data */ class Guild extends ViewState {
            private final long channelId;
            private final boolean disablePins;
            private final long guildId;
            private final boolean hasUnreadPins;
            private final boolean isGuildForumChannel;
            private final boolean isGuildForumPost;
            private final boolean isMuted;
            private final boolean isThread;
            private final boolean shouldHideChannelSidebar;

            public Guild(long j, long j2, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8) {
                super(null);
                this.channelId = j;
                this.guildId = j2;
                this.isMuted = z2;
                this.hasUnreadPins = z3;
                this.disablePins = z4;
                this.isThread = z5;
                this.isGuildForumPost = z6;
                this.isGuildForumChannel = z7;
                this.shouldHideChannelSidebar = z8;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getHasUnreadPins() {
                return this.hasUnreadPins;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getDisablePins() {
                return this.disablePins;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsThread() {
                return this.isThread;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getIsGuildForumPost() {
                return this.isGuildForumPost;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final boolean getIsGuildForumChannel() {
                return this.isGuildForumChannel;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getShouldHideChannelSidebar() {
                return this.shouldHideChannelSidebar;
            }

            public final Guild copy(long channelId, long guildId, boolean isMuted, boolean hasUnreadPins, boolean disablePins, boolean isThread, boolean isGuildForumPost, boolean isGuildForumChannel, boolean shouldHideChannelSidebar) {
                return new Guild(channelId, guildId, isMuted, hasUnreadPins, disablePins, isThread, isGuildForumPost, isGuildForumChannel, shouldHideChannelSidebar);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Guild)) {
                    return false;
                }
                Guild guild = (Guild) other;
                return this.channelId == guild.channelId && this.guildId == guild.guildId && this.isMuted == guild.isMuted && this.hasUnreadPins == guild.hasUnreadPins && this.disablePins == guild.disablePins && this.isThread == guild.isThread && this.isGuildForumPost == guild.isGuildForumPost && this.isGuildForumChannel == guild.isGuildForumChannel && this.shouldHideChannelSidebar == guild.shouldHideChannelSidebar;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final boolean getDisablePins() {
                return this.disablePins;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final boolean getHasUnreadPins() {
                return this.hasUnreadPins;
            }

            public final boolean getShouldHideChannelSidebar() {
                return this.shouldHideChannelSidebar;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r0v16 */
            /* JADX WARN: Type inference failed for: r0v17 */
            /* JADX WARN: Type inference failed for: r0v18 */
            /* JADX WARN: Type inference failed for: r0v19 */
            /* JADX WARN: Type inference failed for: r0v20 */
            /* JADX WARN: Type inference failed for: r0v21 */
            /* JADX WARN: Type inference failed for: r0v22 */
            /* JADX WARN: Type inference failed for: r0v23 */
            /* JADX WARN: Type inference failed for: r0v24 */
            /* JADX WARN: Type inference failed for: r0v25 */
            /* JADX WARN: Type inference failed for: r0v26 */
            /* JADX WARN: Type inference failed for: r0v27 */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10, types: [int] */
            /* JADX WARN: Type inference failed for: r1v12, types: [int] */
            /* JADX WARN: Type inference failed for: r1v14, types: [int] */
            /* JADX WARN: Type inference failed for: r1v16, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4, types: [int] */
            /* JADX WARN: Type inference failed for: r1v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v8, types: [int] */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                int iA = (b.a(this.guildId) + (b.a(this.channelId) * 31)) * 31;
                boolean z2 = this.isMuted;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = (iA + r0) * 31;
                boolean z3 = this.hasUnreadPins;
                ?? r1 = z3;
                if (z3) {
                    r1 = 1;
                }
                int i2 = (i + r1) * 31;
                boolean z4 = this.disablePins;
                ?? r2 = z4;
                if (z4) {
                    r2 = 1;
                }
                int i3 = (i2 + r2) * 31;
                boolean z5 = this.isThread;
                ?? r3 = z5;
                if (z5) {
                    r3 = 1;
                }
                int i4 = (i3 + r3) * 31;
                boolean z6 = this.isGuildForumPost;
                ?? r4 = z6;
                if (z6) {
                    r4 = 1;
                }
                int i5 = (i4 + r4) * 31;
                boolean z7 = this.isGuildForumChannel;
                ?? r5 = z7;
                if (z7) {
                    r5 = 1;
                }
                int i6 = (i5 + r5) * 31;
                boolean z8 = this.shouldHideChannelSidebar;
                return i6 + (z8 ? 1 : z8);
            }

            public final boolean isGuildForumChannel() {
                return this.isGuildForumChannel;
            }

            public final boolean isGuildForumPost() {
                return this.isGuildForumPost;
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public final boolean isThread() {
                return this.isThread;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Guild(channelId=");
                sbU.append(this.channelId);
                sbU.append(", guildId=");
                sbU.append(this.guildId);
                sbU.append(", isMuted=");
                sbU.append(this.isMuted);
                sbU.append(", hasUnreadPins=");
                sbU.append(this.hasUnreadPins);
                sbU.append(", disablePins=");
                sbU.append(this.disablePins);
                sbU.append(", isThread=");
                sbU.append(this.isThread);
                sbU.append(", isGuildForumPost=");
                sbU.append(this.isGuildForumPost);
                sbU.append(", isGuildForumChannel=");
                sbU.append(this.isGuildForumChannel);
                sbU.append(", shouldHideChannelSidebar=");
                return outline.O(sbU, this.shouldHideChannelSidebar, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final /* data */ class Private extends ViewState {
            private final long channelId;
            private final boolean isMuted;

            public Private(long j, boolean z2) {
                super(null);
                this.channelId = j;
                this.isMuted = z2;
            }

            public static /* synthetic */ Private copy$default(Private r0, long j, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    j = r0.channelId;
                }
                if ((i & 2) != 0) {
                    z2 = r0.isMuted;
                }
                return r0.copy(j, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsMuted() {
                return this.isMuted;
            }

            public final Private copy(long channelId, boolean isMuted) {
                return new Private(channelId, isMuted);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Private)) {
                    return false;
                }
                Private r6 = (Private) other;
                return this.channelId == r6.channelId && this.isMuted == r6.isMuted;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            /* JADX WARN: Type inference failed for: r1v3 */
            public int hashCode() {
                int iA = b.a(this.channelId) * 31;
                boolean z2 = this.isMuted;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iA + r1;
            }

            public final boolean isMuted() {
                return this.isMuted;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Private(channelId=");
                sbU.append(this.channelId);
                sbU.append(", isMuted=");
                return outline.O(sbU, this.isMuted, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetChannelSidebarActionsViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetChannelSidebarActionsViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ WidgetChannelSidebarActionsViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, null, null, null, null, 63, null) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        ModelNotificationSettings.ChannelOverride channelOverride;
        List<ModelNotificationSettings.ChannelOverride> channelOverrides;
        Object next;
        ModelNotificationSettings.ChannelOverride channelOverride2;
        if (Intrinsics3.areEqual(storeState, StoreState.ChannelNotFound.INSTANCE)) {
            updateViewState(ViewState.Uninitialized.INSTANCE);
            return;
        }
        if (!(storeState instanceof StoreState.ChannelFound)) {
            throw new NoWhenBranchMatchedException();
        }
        StoreState.ChannelFound channelFound = (StoreState.ChannelFound) storeState;
        boolean z2 = false;
        if (!ChannelUtils.B(channelFound.getChannel())) {
            long id2 = channelFound.getChannel().getId();
            long guildId = channelFound.getChannel().getGuildId();
            ModelNotificationSettings guildNotificationSettings = channelFound.getGuildNotificationSettings();
            boolean z3 = (guildNotificationSettings == null || (channelOverride = guildNotificationSettings.getChannelOverride(id2)) == null || !channelOverride.isMuted()) ? false : true;
            boolean disablePins = channelFound.getDisablePins();
            boolean zH = ChannelUtils.H(channelFound.getChannel());
            Channel parentChannel = channelFound.getParentChannel();
            updateViewState(new ViewState.Guild(id2, guildId, z3, false, disablePins, zH, parentChannel != null && ChannelUtils.q(parentChannel), ChannelUtils.q(channelFound.getChannel()), ChannelUtils.o(channelFound.getChannel())));
            return;
        }
        ModelNotificationSettings guildNotificationSettings2 = channelFound.getGuildNotificationSettings();
        long id3 = channelFound.getChannel().getId();
        if (guildNotificationSettings2 != null && (channelOverrides = guildNotificationSettings2.getChannelOverrides()) != null) {
            Iterator<T> it = channelOverrides.iterator();
            do {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    channelOverride2 = (ModelNotificationSettings.ChannelOverride) next;
                    Intrinsics3.checkNotNullExpressionValue(channelOverride2, "channelOverride");
                }
            } while (!(channelOverride2.getChannelId() == id3));
            ModelNotificationSettings.ChannelOverride channelOverride3 = (ModelNotificationSettings.ChannelOverride) next;
            if (channelOverride3 != null && channelOverride3.isMuted()) {
                z2 = true;
            }
        }
        updateViewState(new ViewState.Private(channelFound.getChannel().getId(), z2));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSidebarActionsViewModel(Observable<StoreState> observable) {
        super(ViewState.Uninitialized.INSTANCE);
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetChannelSidebarActionsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
