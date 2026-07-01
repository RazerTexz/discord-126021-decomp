package com.discord.widgets.channels.threads.browser;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Error;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Listing;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Uninitialized;
import com.discord.stores.ArchivedThreadsStore$ThreadListingType;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Map;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel extends d0<WidgetThreadBrowserArchivedViewModel$ViewState> {
    public static final WidgetThreadBrowserArchivedViewModel$Companion Companion = new WidgetThreadBrowserArchivedViewModel$Companion(null);
    private boolean canLoadMore;
    private final long channelId;
    private final long guildId;
    private final ArchivedThreadsStore storeArchivedThreads;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final Observable<WidgetThreadBrowserArchivedViewModel$StoreState> storeStateObservable;
    private final StoreUser storeUser;
    private final BehaviorSubject<WidgetThreadBrowserArchivedViewModel$ViewMode> viewModeSubject;

    public /* synthetic */ WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.Companion.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.Companion.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.Companion.getArchivedThreads() : archivedThreadsStore, (i & 64) != 0 ? StoreStream.Companion.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.Companion.getGuildMemberRequester() : storeGuildMemberRequester);
    }

    public static final /* synthetic */ long access$getChannelId$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.channelId;
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.guildId;
    }

    public static final /* synthetic */ ArchivedThreadsStore access$getStoreArchivedThreads$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeArchivedThreads;
    }

    public static final /* synthetic */ StoreChannels access$getStoreChannels$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeChannels;
    }

    public static final /* synthetic */ StoreGuilds access$getStoreGuilds$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeGuilds;
    }

    public static final /* synthetic */ StorePermissions access$getStorePermissions$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storePermissions;
    }

    public static final /* synthetic */ StoreUser access$getStoreUser$p(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel) {
        return widgetThreadBrowserArchivedViewModel.storeUser;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel, WidgetThreadBrowserArchivedViewModel$StoreState widgetThreadBrowserArchivedViewModel$StoreState) {
        widgetThreadBrowserArchivedViewModel.handleStoreState(widgetThreadBrowserArchivedViewModel$StoreState);
    }

    @MainThread
    private final void handleStoreState(WidgetThreadBrowserArchivedViewModel$StoreState storeState) {
        int i;
        ThreadBrowserThreadView$TimestampMode threadBrowserThreadView$TimestampMode;
        WidgetThreadBrowserArchivedViewModel$ViewMode viewMode = storeState.getViewMode();
        ArrayList arrayList = new ArrayList();
        boolean zIsModerator = storeState.isModerator();
        ArchivedThreadsStore$ThreadListingState listingState = storeState.getListingState();
        if (listingState instanceof ArchivedThreadsStore$ThreadListingState$Listing) {
            Channel channel = storeState.getChannel();
            if (channel != null && channel.getType() == 15) {
                arrayList.add(new WidgetThreadBrowserAdapter$Item$Warning(null, 1, null));
            }
            ArchivedThreadsStore$ThreadListingState$Listing archivedThreadsStore$ThreadListingState$Listing = (ArchivedThreadsStore$ThreadListingState$Listing) listingState;
            if (!archivedThreadsStore$ThreadListingState$Listing.getThreads().isEmpty()) {
                int iOrdinal = viewMode.getVisibility().ordinal();
                if (iOrdinal == 0) {
                    i = 2131896366;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = 2131896364;
                }
                arrayList.add(new WidgetThreadBrowserAdapter$Item$Header("header", i, archivedThreadsStore$ThreadListingState$Listing.getThreads().size()));
                for (Channel channel2 : archivedThreadsStore$ThreadListingState$Listing.getThreads()) {
                    User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                    if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                        this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                    }
                    Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                    boolean z2 = viewMode.getThreadListingType() == ArchivedThreadsStore$ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
                    if (z2) {
                        threadBrowserThreadView$TimestampMode = ThreadBrowserThreadView$TimestampMode.CreatedAt;
                    } else {
                        if (z2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        threadBrowserThreadView$TimestampMode = ThreadBrowserThreadView$TimestampMode.ArchivedAt;
                    }
                    arrayList.add(new WidgetThreadBrowserAdapter$Item$Thread(new ThreadBrowserThreadView$ThreadData$ArchivedThread(channel2, guildMembers, user, threadBrowserThreadView$TimestampMode)));
                }
            }
            if (archivedThreadsStore$ThreadListingState$Listing.isLoadingMore()) {
                arrayList.add(new WidgetThreadBrowserAdapter$Item$Loading(null, 1, null));
            }
            this.canLoadMore = !archivedThreadsStore$ThreadListingState$Listing.isLoadingMore() && archivedThreadsStore$ThreadListingState$Listing.getHasMore();
        } else {
            if (!(listingState instanceof ArchivedThreadsStore$ThreadListingState$Uninitialized)) {
                boolean z3 = listingState instanceof ArchivedThreadsStore$ThreadListingState$Error;
                this.storeGuildMemberRequester.performQueuedRequests();
                updateViewState(new WidgetThreadBrowserArchivedViewModel$ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
            }
            arrayList.add(new WidgetThreadBrowserAdapter$Item$Loading(null, 1, null));
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new WidgetThreadBrowserArchivedViewModel$ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
    }

    public static /* synthetic */ void maybeLoadMore$default(WidgetThreadBrowserArchivedViewModel widgetThreadBrowserArchivedViewModel, boolean z2, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = false;
        }
        widgetThreadBrowserArchivedViewModel.maybeLoadMore(z2);
    }

    @MainThread
    public final void maybeLoadMore(boolean force) {
        if (this.canLoadMore || force) {
            ArchivedThreadsStore.fetchListing$default(this.storeArchivedThreads, this.channelId, this.viewModeSubject.n0().getThreadListingType(), false, null, 12, null);
        }
    }

    @MainThread
    public final void onModeratorModeChanged(boolean isModeratorMode) {
        BehaviorSubject<WidgetThreadBrowserArchivedViewModel$ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(WidgetThreadBrowserArchivedViewModel$ViewMode.copy$default(behaviorSubject.n0(), null, isModeratorMode, 1, null));
        trackTabChanged();
    }

    @MainThread
    public final void onVisibilityChanged(WidgetThreadBrowserArchivedViewModel$VisibilityMode visibility) {
        m.checkNotNullParameter(visibility, "visibility");
        BehaviorSubject<WidgetThreadBrowserArchivedViewModel$ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(WidgetThreadBrowserArchivedViewModel$ViewMode.copy$default(behaviorSubject.n0(), visibility, false, 2, null));
        trackTabChanged();
    }

    public final void trackTabChanged() {
        String str;
        WidgetThreadBrowserArchivedViewModel$ViewMode widgetThreadBrowserArchivedViewModel$ViewModeN0 = this.viewModeSubject.n0();
        if (widgetThreadBrowserArchivedViewModel$ViewModeN0 != null) {
            int iOrdinal = widgetThreadBrowserArchivedViewModel$ViewModeN0.getThreadListingType().ordinal();
            if (iOrdinal == 0) {
                str = "My Private Archived Threads";
            } else if (iOrdinal == 1) {
                str = "Public Archived Threads";
            } else {
                if (iOrdinal != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                str = "All Private Archived Threads";
            }
            StoreStream.Companion.getAnalytics().trackThreadBrowserTabChanged(this.channelId, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester) {
        super(null, 1, null);
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        this.guildId = j;
        this.channelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeArchivedThreads = archivedThreadsStore;
        this.storePermissions = storePermissions;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        BehaviorSubject<WidgetThreadBrowserArchivedViewModel$ViewMode> behaviorSubjectL0 = BehaviorSubject.l0(new WidgetThreadBrowserArchivedViewModel$ViewMode(WidgetThreadBrowserArchivedViewModel$VisibilityMode.PublicThreads, false));
        m.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\n…rMode = false\n      )\n  )");
        this.viewModeSubject = behaviorSubjectL0;
        Observable observableY = behaviorSubjectL0.Y(new WidgetThreadBrowserArchivedViewModel$storeStateObservable$1(this));
        m.checkNotNullExpressionValue(observableY, "viewModeSubject\n        …            )\n          }");
        this.storeStateObservable = observableY;
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), WidgetThreadBrowserArchivedViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetThreadBrowserArchivedViewModel$1(this), 62, (Object) null);
    }
}
