package com.discord.widgets.channels.threads.browser;

import androidx.annotation.MainThread;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;

/* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final long channelId;
    private final long guildId;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel$1 */
    /* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
    public static final class C76691 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C76691() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            WidgetThreadBrowserViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long channelId, long guildId, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions) {
            Observable<StoreState> observableM11075i = Observable.m11075i(storeChannels.observeChannel(channelId), storeGuilds.observeGuild(guildId), storePermissions.observePermissionsForChannel(channelId), new Func3<Channel, Guild, Long, StoreState>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func3
                public final WidgetThreadBrowserViewModel.StoreState call(Channel channel, Guild guild, Long l) {
                    return new WidgetThreadBrowserViewModel.StoreState(channel, guild, l);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11075i, "Observable.combineLatest…issions\n        )\n      }");
            return observableM11075i;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final Long permissions;

        public StoreState(Channel channel, Guild guild, Long l) {
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, Channel channel, Guild guild, Long l, int i, Object obj) {
            if ((i & 1) != 0) {
                channel = storeState.channel;
            }
            if ((i & 2) != 0) {
                guild = storeState.guild;
            }
            if ((i & 4) != 0) {
                l = storeState.permissions;
            }
            return storeState.copy(channel, guild, l);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(Channel channel, Guild guild, Long permissions) {
            return new StoreState(channel, guild, permissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.channel, storeState.channel) && C12238m.areEqual(this.guild, storeState.guild) && C12238m.areEqual(this.permissions, storeState.permissions);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public int hashCode() {
            Channel channel = this.channel;
            int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
            Guild guild = this.guild;
            int iHashCode2 = (iHashCode + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            return iHashCode2 + (l != null ? l.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(channel=");
            sbM833U.append(this.channel);
            sbM833U.append(", guild=");
            sbM833U.append(this.guild);
            sbM833U.append(", permissions=");
            return C1643a.m819G(sbM833U, this.permissions, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
        public static final /* data */ class Browser extends ViewState {
            private final boolean canCreateThread;
            private final boolean canViewArchivedThreads;
            private final String channelName;
            private final boolean isForumChannel;

            public Browser(String str, boolean z2, boolean z3, boolean z4) {
                super(null);
                this.channelName = str;
                this.canCreateThread = z2;
                this.canViewArchivedThreads = z3;
                this.isForumChannel = z4;
            }

            public static /* synthetic */ Browser copy$default(Browser browser, String str, boolean z2, boolean z3, boolean z4, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = browser.channelName;
                }
                if ((i & 2) != 0) {
                    z2 = browser.canCreateThread;
                }
                if ((i & 4) != 0) {
                    z3 = browser.canViewArchivedThreads;
                }
                if ((i & 8) != 0) {
                    z4 = browser.isForumChannel;
                }
                return browser.copy(str, z2, z3, z4);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final String getChannelName() {
                return this.channelName;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanCreateThread() {
                return this.canCreateThread;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getCanViewArchivedThreads() {
                return this.canViewArchivedThreads;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsForumChannel() {
                return this.isForumChannel;
            }

            public final Browser copy(String channelName, boolean canCreateThread, boolean canViewArchivedThreads, boolean isForumChannel) {
                return new Browser(channelName, canCreateThread, canViewArchivedThreads, isForumChannel);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Browser)) {
                    return false;
                }
                Browser browser = (Browser) other;
                return C12238m.areEqual(this.channelName, browser.channelName) && this.canCreateThread == browser.canCreateThread && this.canViewArchivedThreads == browser.canViewArchivedThreads && this.isForumChannel == browser.isForumChannel;
            }

            public final boolean getCanCreateThread() {
                return this.canCreateThread;
            }

            public final boolean getCanViewArchivedThreads() {
                return this.canViewArchivedThreads;
            }

            public final String getChannelName() {
                return this.channelName;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5 */
            /* JADX WARN: Type inference failed for: r1v6 */
            /* JADX WARN: Type inference failed for: r1v7 */
            /* JADX WARN: Type inference failed for: r1v8 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                String str = this.channelName;
                int iHashCode = (str != null ? str.hashCode() : 0) * 31;
                boolean z2 = this.canCreateThread;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.canViewArchivedThreads;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.isForumChannel;
                return i2 + (z4 ? 1 : z4);
            }

            public final boolean isForumChannel() {
                return this.isForumChannel;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Browser(channelName=");
                sbM833U.append(this.channelName);
                sbM833U.append(", canCreateThread=");
                sbM833U.append(this.canCreateThread);
                sbM833U.append(", canViewArchivedThreads=");
                sbM833U.append(this.canViewArchivedThreads);
                sbM833U.append(", isForumChannel=");
                return C1643a.m827O(sbM833U, this.isForumChannel, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetThreadBrowserViewModel.kt */
        public static final /* data */ class GoToChannel extends ViewState {
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GoToChannel(Channel channel) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                this.channel = channel;
            }

            public static /* synthetic */ GoToChannel copy$default(GoToChannel goToChannel, Channel channel, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = goToChannel.channel;
                }
                return goToChannel.copy(channel);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final GoToChannel copy(Channel channel) {
                C12238m.checkNotNullParameter(channel, "channel");
                return new GoToChannel(channel);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof GoToChannel) && C12238m.areEqual(this.channel, ((GoToChannel) other).channel);
                }
                return true;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                if (channel != null) {
                    return channel.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("GoToChannel(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 4) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 8) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StorePermissions permissions = (i & 16) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        this(j, j2, channels, guilds, permissions, (i & 32) != 0 ? INSTANCE.observeStoreState(j2, j, channels, guilds, permissions) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        if (getViewState() instanceof ViewState.GoToChannel) {
            return;
        }
        Channel channel = storeState.getChannel();
        String strM7679c = channel != null ? ChannelUtils.m7679c(channel) : null;
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        boolean zCanCreateThread = threadUtils.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild());
        boolean zCanViewAllPublicArchivedThreads = threadUtils.canViewAllPublicArchivedThreads(storeState.getChannel(), storeState.getPermissions());
        Channel channel2 = storeState.getChannel();
        updateViewState(new ViewState.Browser(strM7679c, zCanCreateThread, zCanViewAllPublicArchivedThreads, channel2 != null && channel2.getType() == 15));
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final long getGuildId() {
        return this.guildId;
    }

    public final void openThread(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        updateViewState(new ViewState.GoToChannel(channel));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserViewModel(long j, long j2, StoreChannels storeChannels, StoreGuilds storeGuilds, StorePermissions storePermissions, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.channelId = j2;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storePermissions = storePermissions;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetThreadBrowserViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C76691());
    }
}
