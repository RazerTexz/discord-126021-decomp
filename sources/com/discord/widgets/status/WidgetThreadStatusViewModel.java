package com.discord.widgets.status;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.restapi.RestAPIParams;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActiveJoined;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.forums.ForumUtils;
import com.discord.widgets.status.WidgetThreadStatus;
import com.discord.widgets.status.WidgetThreadStatusViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func4;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatusViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private StoreState currentStoreState;
    private final PublishSubject<WidgetThreadStatus.Event> eventSubject;
    private final Observable<StoreState> storeStateObservable;

    /* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatusViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
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
            WidgetThreadStatusViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final StoreThreadsActiveJoined storeThreadsActiveJoined, StoreChannelsSelected storeChannelsSelected, final StoreChannels storeChannels, final StorePermissions storePermissions, final StoreExperiments storeExperiments) {
            Observable<R> observableG = storeChannelsSelected.observeSelectedChannel().y(ObservableExtensionsKt.AnonymousClass1.INSTANCE).G(ObservableExtensionsKt.AnonymousClass2.INSTANCE);
            Intrinsics3.checkNotNullExpressionValue(observableG, "filter { it != null }.map { it!! }");
            Observable<StoreState> observableY = observableG.Y(new Func1<Channel, Observable<? extends StoreState>>() { // from class: com.discord.widgets.status.WidgetThreadStatusViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends WidgetThreadStatusViewModel.StoreState> call(final Channel channel) {
                    return Observable.h(storeThreadsActiveJoined.observeActiveJoinedThreadsForGuild(channel.getGuildId()), storePermissions.observePermissionsForChannel(channel.getId()), storeChannels.observeChannel(channel.getParentId()), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, channel.getGuildId(), storeExperiments, null, 4, null), new Func4<Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>>, Long, Channel, Boolean, WidgetThreadStatusViewModel.StoreState>() { // from class: com.discord.widgets.status.WidgetThreadStatusViewModel$Companion$observeStoreState$1.1
                        @Override // rx.functions.Func4
                        public /* bridge */ /* synthetic */ WidgetThreadStatusViewModel.StoreState call(Map<Long, ? extends Map<Long, ? extends StoreThreadsActiveJoined.ActiveJoinedThread>> map, Long l, Channel channel2, Boolean bool) {
                            return call2((Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>>) map, l, channel2, bool);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetThreadStatusViewModel.StoreState call2(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map, Long l, Channel channel2, Boolean bool) {
                            ThreadUtils threadUtils = ThreadUtils.INSTANCE;
                            Channel channel3 = channel;
                            Intrinsics3.checkNotNullExpressionValue(channel3, "selectedChannel");
                            boolean zCanUnarchiveThread = threadUtils.canUnarchiveThread(channel3, l);
                            boolean zIsThreadModerator = threadUtils.isThreadModerator(Long.valueOf(l != null ? l.longValue() : 0L));
                            Intrinsics3.checkNotNullExpressionValue(map, "activeJoinedThreads");
                            Channel channel4 = channel;
                            Intrinsics3.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
                            return new WidgetThreadStatusViewModel.StoreState(map, channel4, channel2, zCanUnarchiveThread, zIsThreadModerator, bool.booleanValue());
                        }
                    }).r();
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…ntilChanged()\n          }");
            return observableY;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, StoreThreadsActiveJoined storeThreadsActiveJoined, StoreChannelsSelected storeChannelsSelected, StoreChannels storeChannels, StorePermissions storePermissions, StoreExperiments storeExperiments, int i, Object obj) {
            if ((i & 1) != 0) {
                storeThreadsActiveJoined = StoreStream.INSTANCE.getThreadsActiveJoined();
            }
            if ((i & 2) != 0) {
                storeChannelsSelected = StoreStream.INSTANCE.getChannelsSelected();
            }
            StoreChannelsSelected storeChannelsSelected2 = storeChannelsSelected;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            StorePermissions storePermissions2 = storePermissions;
            if ((i & 16) != 0) {
                storeExperiments = StoreStream.INSTANCE.getExperiments();
            }
            return companion.observeStoreState(storeThreadsActiveJoined, storeChannelsSelected2, storeChannels2, storePermissions2, storeExperiments);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
    public static abstract class Status {

        /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
        public static final /* data */ class Archived extends Status {
            private final boolean canArchive;
            private final boolean isLocked;

            public Archived(boolean z2, boolean z3) {
                super(null);
                this.isLocked = z2;
                this.canArchive = z3;
            }

            public static /* synthetic */ Archived copy$default(Archived archived, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    z2 = archived.isLocked;
                }
                if ((i & 2) != 0) {
                    z3 = archived.canArchive;
                }
                return archived.copy(z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final boolean getIsLocked() {
                return this.isLocked;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanArchive() {
                return this.canArchive;
            }

            public final Archived copy(boolean isLocked, boolean canArchive) {
                return new Archived(isLocked, canArchive);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Archived)) {
                    return false;
                }
                Archived archived = (Archived) other;
                return this.isLocked == archived.isLocked && this.canArchive == archived.canArchive;
            }

            public final boolean getCanArchive() {
                return this.canArchive;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v1, types: [int] */
            /* JADX WARN: Type inference failed for: r0v3, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r1v0 */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v2 */
            public int hashCode() {
                boolean z2 = this.isLocked;
                ?? r0 = z2;
                if (z2) {
                    r0 = 1;
                }
                int i = r0 * 31;
                boolean z3 = this.canArchive;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isLocked() {
                return this.isLocked;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Archived(isLocked=");
                sbU.append(this.isLocked);
                sbU.append(", canArchive=");
                return outline.O(sbU, this.canArchive, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
        public static final class Hide extends Status {
            public static final Hide INSTANCE = new Hide();

            private Hide() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
        public static final class Unjoined extends Status {
            public static final Unjoined INSTANCE = new Unjoined();

            private Unjoined() {
                super(null);
            }
        }

        private Status() {
        }

        public /* synthetic */ Status(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
    public static final /* data */ class StoreState {
        private final Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedThreads;
        private final boolean canAccessRedesignedForumChannels;
        private final boolean canArchive;
        private final boolean isModerator;
        private final Channel parentChannel;
        private final Channel selectedChannel;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map, Channel channel, Channel channel2, boolean z2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(map, "activeJoinedThreads");
            this.activeJoinedThreads = map;
            this.selectedChannel = channel;
            this.parentChannel = channel2;
            this.canArchive = z2;
            this.isModerator = z3;
            this.canAccessRedesignedForumChannels = z4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Map map, Channel channel, Channel channel2, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                map = storeState.activeJoinedThreads;
            }
            if ((i & 2) != 0) {
                channel = storeState.selectedChannel;
            }
            Channel channel3 = channel;
            if ((i & 4) != 0) {
                channel2 = storeState.parentChannel;
            }
            Channel channel4 = channel2;
            if ((i & 8) != 0) {
                z2 = storeState.canArchive;
            }
            boolean z5 = z2;
            if ((i & 16) != 0) {
                z3 = storeState.isModerator;
            }
            boolean z6 = z3;
            if ((i & 32) != 0) {
                z4 = storeState.canAccessRedesignedForumChannels;
            }
            return storeState.copy(map, channel3, channel4, z5, z6, z4);
        }

        public final Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> component1() {
            return this.activeJoinedThreads;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getCanArchive() {
            return this.canArchive;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        public final StoreState copy(Map<Long, ? extends Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedThreads, Channel selectedChannel, Channel parentChannel, boolean canArchive, boolean isModerator, boolean canAccessRedesignedForumChannels) {
            Intrinsics3.checkNotNullParameter(activeJoinedThreads, "activeJoinedThreads");
            return new StoreState(activeJoinedThreads, selectedChannel, parentChannel, canArchive, isModerator, canAccessRedesignedForumChannels);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.activeJoinedThreads, storeState.activeJoinedThreads) && Intrinsics3.areEqual(this.selectedChannel, storeState.selectedChannel) && Intrinsics3.areEqual(this.parentChannel, storeState.parentChannel) && this.canArchive == storeState.canArchive && this.isModerator == storeState.isModerator && this.canAccessRedesignedForumChannels == storeState.canAccessRedesignedForumChannels;
        }

        public final Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> getActiveJoinedThreads() {
            return this.activeJoinedThreads;
        }

        public final boolean getCanAccessRedesignedForumChannels() {
            return this.canAccessRedesignedForumChannels;
        }

        public final boolean getCanArchive() {
            return this.canArchive;
        }

        public final Channel getParentChannel() {
            return this.parentChannel;
        }

        public final Channel getSelectedChannel() {
            return this.selectedChannel;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v12, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v4 */
        /* JADX WARN: Type inference failed for: r2v5, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        public int hashCode() {
            Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> map = this.activeJoinedThreads;
            int iHashCode = (map != null ? map.hashCode() : 0) * 31;
            Channel channel = this.selectedChannel;
            int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
            Channel channel2 = this.parentChannel;
            int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
            boolean z2 = this.canArchive;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode3 + r1) * 31;
            boolean z3 = this.isModerator;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.canAccessRedesignedForumChannels;
            return i2 + (z4 ? 1 : z4);
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(activeJoinedThreads=");
            sbU.append(this.activeJoinedThreads);
            sbU.append(", selectedChannel=");
            sbU.append(this.selectedChannel);
            sbU.append(", parentChannel=");
            sbU.append(this.parentChannel);
            sbU.append(", canArchive=");
            sbU.append(this.canArchive);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", canAccessRedesignedForumChannels=");
            return outline.O(sbU, this.canAccessRedesignedForumChannels, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadStatusViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean isLoading;
        private final Status threadStatus;

        public ViewState(Status status, boolean z2) {
            Intrinsics3.checkNotNullParameter(status, "threadStatus");
            this.threadStatus = status;
            this.isLoading = z2;
        }

        public static /* synthetic */ ViewState copy$default(ViewState viewState, Status status, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                status = viewState.threadStatus;
            }
            if ((i & 2) != 0) {
                z2 = viewState.isLoading;
            }
            return viewState.copy(status, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Status getThreadStatus() {
            return this.threadStatus;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        public final ViewState copy(Status threadStatus, boolean isLoading) {
            Intrinsics3.checkNotNullParameter(threadStatus, "threadStatus");
            return new ViewState(threadStatus, isLoading);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.threadStatus, viewState.threadStatus) && this.isLoading == viewState.isLoading;
        }

        public final Status getThreadStatus() {
            return this.threadStatus;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            Status status = this.threadStatus;
            int iHashCode = (status != null ? status.hashCode() : 0) * 31;
            boolean z2 = this.isLoading;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isLoading() {
            return this.isLoading;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(threadStatus=");
            sbU.append(this.threadStatus);
            sbU.append(", isLoading=");
            return outline.O(sbU, this.isLoading, ")");
        }

        public /* synthetic */ ViewState(Status status, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(status, (i & 2) != 0 ? false : z2);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetThreadStatusViewModel() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public /* synthetic */ WidgetThreadStatusViewModel(Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Companion.observeStoreState$default(INSTANCE, null, null, null, null, null, 31, null) : observable);
    }

    private final void emitError(int code) {
        PublishSubject<WidgetThreadStatus.Event> publishSubject = this.eventSubject;
        publishSubject.k.onNext(new WidgetThreadStatus.Event.Error(code));
    }

    private final void handleStoreState(StoreState storeState) {
        Status archived;
        this.currentStoreState = storeState;
        Channel selectedChannel = storeState.getSelectedChannel();
        Channel parentChannel = storeState.getParentChannel();
        Map<Long, Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread>> activeJoinedThreads = storeState.getActiveJoinedThreads();
        Channel selectedChannel2 = storeState.getSelectedChannel();
        StoreThreadsActiveJoined.ActiveJoinedThread activeJoinedThread = null;
        Map<Long, StoreThreadsActiveJoined.ActiveJoinedThread> map = activeJoinedThreads.get(selectedChannel2 != null ? Long.valueOf(selectedChannel2.getParentId()) : null);
        if (map != null) {
            Channel selectedChannel3 = storeState.getSelectedChannel();
            activeJoinedThread = map.get(selectedChannel3 != null ? Long.valueOf(selectedChannel3.getId()) : null);
        }
        boolean z2 = false;
        boolean z3 = activeJoinedThread != null;
        if (selectedChannel == null || !ChannelUtils.H(selectedChannel)) {
            archived = Status.Hide.INSTANCE;
        } else if (parentChannel != null && ChannelUtils.q(parentChannel) && storeState.getCanAccessRedesignedForumChannels()) {
            archived = Status.Hide.INSTANCE;
        } else {
            ThreadMetadata threadMetadata = selectedChannel.getThreadMetadata();
            if (threadMetadata == null || !threadMetadata.getArchived()) {
                archived = z3 ? Status.Hide.INSTANCE : Status.Unjoined.INSTANCE;
            } else {
                ThreadMetadata threadMetadata2 = selectedChannel.getThreadMetadata();
                if (threadMetadata2 != null && threadMetadata2.getLocked()) {
                    z2 = true;
                }
                archived = new Status.Archived(z2, storeState.getCanArchive());
            }
        }
        updateViewWithStatus(archived);
    }

    private final void updateViewLoading(boolean isLoading) {
        ViewState viewState = getViewState();
        if (viewState != null) {
            updateViewState(ViewState.copy$default(viewState, null, isLoading, 1, null));
        }
    }

    private final void updateViewWithStatus(Status status) {
        updateViewState(new ViewState(status, false, 2, null));
    }

    public final Observable<StoreState> getStoreStateObservable() {
        return this.storeStateObservable;
    }

    public final Observable<WidgetThreadStatus.Event> observeEvents() {
        PublishSubject<WidgetThreadStatus.Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onJoinTapped() {
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            if (storeState.getSelectedChannel() == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.INSTANCE.getApi().joinThread(storeState.getSelectedChannel().getId(), "Banner", new RestAPIParams.EmptyBody()), false, 1, null), this, null, 2, null), (Class<?>) WidgetThreadStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new WidgetThreadStatusViewModel3(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new WidgetThreadStatusViewModel4(this)), WidgetThreadStatusViewModel5.INSTANCE);
        }
        updateViewLoading(true);
    }

    public final void onUnarchiveTapped() {
        StoreState storeState = this.currentStoreState;
        if (storeState != null) {
            if (storeState.getSelectedChannel() == null) {
                return;
            }
            RestAPI api = RestAPI.INSTANCE.getApi();
            long id2 = storeState.getSelectedChannel().getId();
            Boolean bool = Boolean.FALSE;
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(api.editThread(id2, new RestAPIParams.ThreadSettings(bool, storeState.isModerator() ? bool : null, null, 4, null)), false, 1, null), this, null, 2, null), (Class<?>) WidgetThreadStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new WidgetThreadStatusViewModel6(this)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : new WidgetThreadStatusViewModel7(this)), WidgetThreadStatusViewModel8.INSTANCE);
        }
        updateViewLoading(true);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public WidgetThreadStatusViewModel(Observable<StoreState> observable) {
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        DefaultConstructorMarker defaultConstructorMarker = null;
        super(defaultConstructorMarker, 1, defaultConstructorMarker);
        this.storeStateObservable = observable;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetThreadStatusViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
