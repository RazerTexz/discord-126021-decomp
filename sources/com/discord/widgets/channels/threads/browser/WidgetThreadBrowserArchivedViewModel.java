package com.discord.widgets.channels.threads.browser;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.channels.threads.browser.ThreadBrowserThreadView;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserAdapter;
import com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;
import rx.functions.Func4;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadBrowserArchivedViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private boolean canLoadMore;
    private final long channelId;
    private final long guildId;
    private final ArchivedThreadsStore storeArchivedThreads;
    private final StoreChannels storeChannels;
    private final StoreGuildMemberRequester storeGuildMemberRequester;
    private final StoreGuilds storeGuilds;
    private final StorePermissions storePermissions;
    private final Observable<StoreState> storeStateObservable;
    private final StoreUser storeUser;
    private final BehaviorSubject<ViewMode> viewModeSubject;

    /* JADX INFO: renamed from: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
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
            WidgetThreadBrowserArchivedViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(final ViewMode viewMode, final long guildId, long channelId, final StoreGuilds storeGuilds, StoreChannels storeChannels, final StoreUser storeUser, ArchivedThreadsStore storeArchivedThreads, final StorePermissions storePermissions) {
            Observable<StoreState> observableY = Observable.j(storeArchivedThreads.loadAndObserveThreadListing(channelId, viewMode.getThreadListingType()), storeChannels.observeChannel(channelId), new Func2<ArchivedThreadsStore.ThreadListingState, Channel, Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func2
                public final Tuples2<ArchivedThreadsStore.ThreadListingState, Channel> call(ArchivedThreadsStore.ThreadListingState threadListingState, Channel channel) {
                    return new Tuples2<>(threadListingState, channel);
                }
            }).Y(new Func1<Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel>, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(Tuples2<? extends ArchivedThreadsStore.ThreadListingState, ? extends Channel> tuples2) {
                    return call2((Tuples2<? extends ArchivedThreadsStore.ThreadListingState, Channel>) tuples2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call2(Tuples2<? extends ArchivedThreadsStore.ThreadListingState, Channel> tuples2) {
                    Observable<Map<Long, User>> scalarSynchronousObservable;
                    final ArchivedThreadsStore.ThreadListingState threadListingStateComponent1 = tuples2.component1();
                    final Channel channelComponent2 = tuples2.component2();
                    if (threadListingStateComponent1 instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
                        StoreUser storeUser2 = storeUser;
                        List<Channel> threads = ((ArchivedThreadsStore.ThreadListingState.Listing) threadListingStateComponent1).getThreads();
                        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(threads, 10));
                        Iterator<T> it = threads.iterator();
                        while (it.hasNext()) {
                            arrayList.add(Long.valueOf(((Channel) it.next()).getOwnerId()));
                        }
                        scalarSynchronousObservable = storeUser2.observeUsers(arrayList);
                    } else {
                        scalarSynchronousObservable = new ScalarSynchronousObservable(Maps6.emptyMap());
                    }
                    Observable<R> observableG = storeGuilds.observeComputed().G(new Func1<Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends GuildMember>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2.1
                        @Override // j0.k.Func1
                        public /* bridge */ /* synthetic */ Map<Long, ? extends GuildMember> call(Map<Long, ? extends Map<Long, ? extends GuildMember>> map) {
                            return call2((Map<Long, ? extends Map<Long, GuildMember>>) map);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final Map<Long, GuildMember> call2(Map<Long, ? extends Map<Long, GuildMember>> map) {
                            Map<Long, GuildMember> map2 = map.get(Long.valueOf(guildId));
                            return map2 != null ? map2 : Maps6.emptyMap();
                        }
                    });
                    Intrinsics3.checkNotNullExpressionValue(observableG, "storeGuilds\n            …[guildId] ?: emptyMap() }");
                    Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableG, 1L, TimeUnit.SECONDS).r();
                    Observable<Guild> observableObserveGuild = storeGuilds.observeGuild(guildId);
                    StorePermissions storePermissions2 = storePermissions;
                    Long lValueOf = channelComponent2 != null ? Long.valueOf(channelComponent2.getParentId()) : null;
                    Objects.requireNonNull(lValueOf, "null cannot be cast to non-null type com.discord.primitives.Snowflake /* = kotlin.Long */");
                    return Observable.h(observableR, observableObserveGuild, scalarSynchronousObservable, storePermissions2.observePermissionsForChannel(lValueOf.longValue()), new Func4<Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends User>, Long, WidgetThreadBrowserArchivedViewModel.StoreState>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$Companion$observeStoreState$2.2
                        @Override // rx.functions.Func4
                        public /* bridge */ /* synthetic */ WidgetThreadBrowserArchivedViewModel.StoreState call(Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
                            return call2((Map<Long, GuildMember>) map, guild, map2, l);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetThreadBrowserArchivedViewModel.StoreState call2(Map<Long, GuildMember> map, Guild guild, Map<Long, ? extends User> map2, Long l) {
                            boolean zCanViewAllPrivateThreads = ThreadUtils.INSTANCE.canViewAllPrivateThreads(l);
                            WidgetThreadBrowserArchivedViewModel.ViewMode viewMode2 = viewMode;
                            Intrinsics3.checkNotNullExpressionValue(map, "guildMembers");
                            Intrinsics3.checkNotNullExpressionValue(map2, "users");
                            ArchivedThreadsStore.ThreadListingState threadListingState = threadListingStateComponent1;
                            Intrinsics3.checkNotNullExpressionValue(threadListingState, "listingState");
                            return new WidgetThreadBrowserArchivedViewModel.StoreState(viewMode2, map, map2, threadListingState, zCanViewAllPrivateThreads, channelComponent2, guild, l);
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel channel;
        private final Guild guild;
        private final Map<Long, GuildMember> guildMembers;
        private final boolean isModerator;
        private final ArchivedThreadsStore.ThreadListingState listingState;
        private final Long permissions;
        private final Map<Long, User> users;
        private final ViewMode viewMode;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(ViewMode viewMode, Map<Long, GuildMember> map, Map<Long, ? extends User> map2, ArchivedThreadsStore.ThreadListingState threadListingState, boolean z2, Channel channel, Guild guild, Long l) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(map, "guildMembers");
            Intrinsics3.checkNotNullParameter(map2, "users");
            Intrinsics3.checkNotNullParameter(threadListingState, "listingState");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            this.viewMode = viewMode;
            this.guildMembers = map;
            this.users = map2;
            this.listingState = threadListingState;
            this.isModerator = z2;
            this.channel = channel;
            this.guild = guild;
            this.permissions = l;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        public final Map<Long, GuildMember> component2() {
            return this.guildMembers;
        }

        public final Map<Long, User> component3() {
            return this.users;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ArchivedThreadsStore.ThreadListingState getListingState() {
            return this.listingState;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final Guild getGuild() {
            return this.guild;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final Long getPermissions() {
            return this.permissions;
        }

        public final StoreState copy(ViewMode viewMode, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, ArchivedThreadsStore.ThreadListingState listingState, boolean isModerator, Channel channel, Guild guild, Long permissions) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(users, "users");
            Intrinsics3.checkNotNullParameter(listingState, "listingState");
            Intrinsics3.checkNotNullParameter(channel, "channel");
            return new StoreState(viewMode, guildMembers, users, listingState, isModerator, channel, guild, permissions);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.viewMode, storeState.viewMode) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.users, storeState.users) && Intrinsics3.areEqual(this.listingState, storeState.listingState) && this.isModerator == storeState.isModerator && Intrinsics3.areEqual(this.channel, storeState.channel) && Intrinsics3.areEqual(this.guild, storeState.guild) && Intrinsics3.areEqual(this.permissions, storeState.permissions);
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Guild getGuild() {
            return this.guild;
        }

        public final Map<Long, GuildMember> getGuildMembers() {
            return this.guildMembers;
        }

        public final ArchivedThreadsStore.ThreadListingState getListingState() {
            return this.listingState;
        }

        public final Long getPermissions() {
            return this.permissions;
        }

        public final Map<Long, User> getUsers() {
            return this.users;
        }

        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v10, types: [int] */
        /* JADX WARN: Type inference failed for: r2v20 */
        /* JADX WARN: Type inference failed for: r2v24 */
        public int hashCode() {
            ViewMode viewMode = this.viewMode;
            int iHashCode = (viewMode != null ? viewMode.hashCode() : 0) * 31;
            Map<Long, GuildMember> map = this.guildMembers;
            int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
            Map<Long, User> map2 = this.users;
            int iHashCode3 = (iHashCode2 + (map2 != null ? map2.hashCode() : 0)) * 31;
            ArchivedThreadsStore.ThreadListingState threadListingState = this.listingState;
            int iHashCode4 = (iHashCode3 + (threadListingState != null ? threadListingState.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode4 + r2) * 31;
            Channel channel = this.channel;
            int iHashCode5 = (i + (channel != null ? channel.hashCode() : 0)) * 31;
            Guild guild = this.guild;
            int iHashCode6 = (iHashCode5 + (guild != null ? guild.hashCode() : 0)) * 31;
            Long l = this.permissions;
            return iHashCode6 + (l != null ? l.hashCode() : 0);
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(viewMode=");
            sbU.append(this.viewMode);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", users=");
            sbU.append(this.users);
            sbU.append(", listingState=");
            sbU.append(this.listingState);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(", guild=");
            sbU.append(this.guild);
            sbU.append(", permissions=");
            return outline.G(sbU, this.permissions, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final /* data */ class ViewMode {
        private final boolean isModeratorMode;
        private final ArchivedThreadsStore.ThreadListingType threadListingType;
        private final VisibilityMode visibility;

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                VisibilityMode.values();
                int[] iArr = new int[2];
                $EnumSwitchMapping$0 = iArr;
                iArr[VisibilityMode.PublicThreads.ordinal()] = 1;
            }
        }

        public ViewMode(VisibilityMode visibilityMode, boolean z2) {
            ArchivedThreadsStore.ThreadListingType threadListingType;
            Intrinsics3.checkNotNullParameter(visibilityMode, "visibility");
            this.visibility = visibilityMode;
            this.isModeratorMode = z2;
            if (visibilityMode.ordinal() == 0) {
                threadListingType = ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS;
            } else if (!z2) {
                threadListingType = ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
            } else {
                if (!z2) {
                    throw new NoWhenBranchMatchedException();
                }
                threadListingType = ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS;
            }
            this.threadListingType = threadListingType;
        }

        public static /* synthetic */ ViewMode copy$default(ViewMode viewMode, VisibilityMode visibilityMode, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                visibilityMode = viewMode.visibility;
            }
            if ((i & 2) != 0) {
                z2 = viewMode.isModeratorMode;
            }
            return viewMode.copy(visibilityMode, z2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final VisibilityMode getVisibility() {
            return this.visibility;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsModeratorMode() {
            return this.isModeratorMode;
        }

        public final ViewMode copy(VisibilityMode visibility, boolean isModeratorMode) {
            Intrinsics3.checkNotNullParameter(visibility, "visibility");
            return new ViewMode(visibility, isModeratorMode);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewMode)) {
                return false;
            }
            ViewMode viewMode = (ViewMode) other;
            return Intrinsics3.areEqual(this.visibility, viewMode.visibility) && this.isModeratorMode == viewMode.isModeratorMode;
        }

        public final ArchivedThreadsStore.ThreadListingType getThreadListingType() {
            return this.threadListingType;
        }

        public final VisibilityMode getVisibility() {
            return this.visibility;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public int hashCode() {
            VisibilityMode visibilityMode = this.visibility;
            int iHashCode = (visibilityMode != null ? visibilityMode.hashCode() : 0) * 31;
            boolean z2 = this.isModeratorMode;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            return iHashCode + r1;
        }

        public final boolean isModeratorMode() {
            return this.isModeratorMode;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewMode(visibility=");
            sbU.append(this.visibility);
            sbU.append(", isModeratorMode=");
            return outline.O(sbU, this.isModeratorMode, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public static final /* data */ class ViewState {
        private final boolean canCreateThread;
        private final boolean isError;
        private final boolean isModerator;
        private final List<WidgetThreadBrowserAdapter.Item> listItems;
        private final ViewMode viewMode;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter.Item> list, boolean z2, boolean z3, boolean z4) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(list, "listItems");
            this.viewMode = viewMode;
            this.listItems = list;
            this.isModerator = z2;
            this.isError = z3;
            this.canCreateThread = z4;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, ViewMode viewMode, List list, boolean z2, boolean z3, boolean z4, int i, Object obj) {
            if ((i & 1) != 0) {
                viewMode = viewState.viewMode;
            }
            if ((i & 2) != 0) {
                list = viewState.listItems;
            }
            List list2 = list;
            if ((i & 4) != 0) {
                z2 = viewState.isModerator;
            }
            boolean z5 = z2;
            if ((i & 8) != 0) {
                z3 = viewState.isError;
            }
            boolean z6 = z3;
            if ((i & 16) != 0) {
                z4 = viewState.canCreateThread;
            }
            return viewState.copy(viewMode, list2, z5, z6, z4);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        public final List<WidgetThreadBrowserAdapter.Item> component2() {
            return this.listItems;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getIsModerator() {
            return this.isModerator;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsError() {
            return this.isError;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final ViewState copy(ViewMode viewMode, List<? extends WidgetThreadBrowserAdapter.Item> listItems, boolean isModerator, boolean isError, boolean canCreateThread) {
            Intrinsics3.checkNotNullParameter(viewMode, "viewMode");
            Intrinsics3.checkNotNullParameter(listItems, "listItems");
            return new ViewState(viewMode, listItems, isModerator, isError, canCreateThread);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ViewState)) {
                return false;
            }
            ViewState viewState = (ViewState) other;
            return Intrinsics3.areEqual(this.viewMode, viewState.viewMode) && Intrinsics3.areEqual(this.listItems, viewState.listItems) && this.isModerator == viewState.isModerator && this.isError == viewState.isError && this.canCreateThread == viewState.canCreateThread;
        }

        public final boolean getCanCreateThread() {
            return this.canCreateThread;
        }

        public final List<WidgetThreadBrowserAdapter.Item> getListItems() {
            return this.listItems;
        }

        public final ViewMode getViewMode() {
            return this.viewMode;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10, types: [int] */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v10 */
        /* JADX WARN: Type inference failed for: r1v11 */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v5, types: [int] */
        /* JADX WARN: Type inference failed for: r1v7 */
        /* JADX WARN: Type inference failed for: r1v8 */
        /* JADX WARN: Type inference failed for: r2v1 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r2v3 */
        public int hashCode() {
            ViewMode viewMode = this.viewMode;
            int iHashCode = (viewMode != null ? viewMode.hashCode() : 0) * 31;
            List<WidgetThreadBrowserAdapter.Item> list = this.listItems;
            int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isModerator;
            ?? r1 = z2;
            if (z2) {
                r1 = 1;
            }
            int i = (iHashCode2 + r1) * 31;
            boolean z3 = this.isError;
            ?? r2 = z3;
            if (z3) {
                r2 = 1;
            }
            int i2 = (i + r2) * 31;
            boolean z4 = this.canCreateThread;
            return i2 + (z4 ? 1 : z4);
        }

        public final boolean isError() {
            return this.isError;
        }

        public final boolean isModerator() {
            return this.isModerator;
        }

        public String toString() {
            StringBuilder sbU = outline.U("ViewState(viewMode=");
            sbU.append(this.viewMode);
            sbU.append(", listItems=");
            sbU.append(this.listItems);
            sbU.append(", isModerator=");
            sbU.append(this.isModerator);
            sbU.append(", isError=");
            sbU.append(this.isError);
            sbU.append(", canCreateThread=");
            return outline.O(sbU, this.canCreateThread, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetThreadBrowserArchivedViewModel.kt */
    public enum VisibilityMode {
        PublicThreads,
        PrivateThreads
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            VisibilityMode.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[VisibilityMode.PublicThreads.ordinal()] = 1;
            iArr[VisibilityMode.PrivateThreads.ordinal()] = 2;
            ArchivedThreadsStore.ThreadListingType.values();
            int[] iArr2 = new int[3];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS.ordinal()] = 1;
            iArr2[ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS.ordinal()] = 2;
            iArr2[ArchivedThreadsStore.ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS.ordinal()] = 3;
        }
    }

    public /* synthetic */ WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 8) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 16) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 32) != 0 ? StoreStream.INSTANCE.getArchivedThreads() : archivedThreadsStore, (i & 64) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions, (i & 128) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        int i;
        ThreadBrowserThreadView.TimestampMode timestampMode;
        ViewMode viewMode = storeState.getViewMode();
        ArrayList arrayList = new ArrayList();
        boolean zIsModerator = storeState.isModerator();
        ArchivedThreadsStore.ThreadListingState listingState = storeState.getListingState();
        String str = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        Object[] objArr4 = 0;
        Object[] objArr5 = 0;
        char c = 1;
        char c2 = 1;
        char c3 = 1;
        if (listingState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
            Channel channel = storeState.getChannel();
            if (channel != null && channel.getType() == 15) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Warning(str, c3 == true ? 1 : 0, objArr5 == true ? 1 : 0));
            }
            ArchivedThreadsStore.ThreadListingState.Listing listing = (ArchivedThreadsStore.ThreadListingState.Listing) listingState;
            if (!listing.getThreads().isEmpty()) {
                int iOrdinal = viewMode.getVisibility().ordinal();
                if (iOrdinal == 0) {
                    i = R.string.thread_browser_public_header;
                } else {
                    if (iOrdinal != 1) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i = R.string.thread_browser_private_header;
                }
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Header("header", i, listing.getThreads().size()));
                for (Channel channel2 : listing.getThreads()) {
                    User user = storeState.getUsers().get(Long.valueOf(channel2.getOwnerId()));
                    if (user == null || !storeState.getGuildMembers().containsKey(Long.valueOf(channel2.getOwnerId()))) {
                        this.storeGuildMemberRequester.queueRequest(channel2.getGuildId(), channel2.getOwnerId());
                    }
                    Map<Long, GuildMember> guildMembers = storeState.getGuildMembers();
                    boolean z2 = viewMode.getThreadListingType() == ArchivedThreadsStore.ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS;
                    if (z2) {
                        timestampMode = ThreadBrowserThreadView.TimestampMode.CreatedAt;
                    } else {
                        if (z2) {
                            throw new NoWhenBranchMatchedException();
                        }
                        timestampMode = ThreadBrowserThreadView.TimestampMode.ArchivedAt;
                    }
                    arrayList.add(new WidgetThreadBrowserAdapter.Item.Thread(new ThreadBrowserThreadView.ThreadData.ArchivedThread(channel2, guildMembers, user, timestampMode)));
                }
            }
            if (listing.isLoadingMore()) {
                arrayList.add(new WidgetThreadBrowserAdapter.Item.Loading(objArr4 == true ? 1 : 0, c2 == true ? 1 : 0, objArr3 == true ? 1 : 0));
            }
            this.canLoadMore = !listing.isLoadingMore() && listing.getHasMore();
        } else {
            if (!(listingState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized)) {
                boolean z3 = listingState instanceof ArchivedThreadsStore.ThreadListingState.Error;
                this.storeGuildMemberRequester.performQueuedRequests();
                updateViewState(new ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
            }
            arrayList.add(new WidgetThreadBrowserAdapter.Item.Loading(objArr2 == true ? 1 : 0, c == true ? 1 : 0, objArr == true ? 1 : 0));
        }
        this.storeGuildMemberRequester.performQueuedRequests();
        updateViewState(new ViewState(viewMode, arrayList, zIsModerator, z3, ThreadUtils.INSTANCE.canCreateThread(storeState.getPermissions(), storeState.getChannel(), null, storeState.getGuild())));
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
        BehaviorSubject<ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(ViewMode.copy$default(behaviorSubject.n0(), null, isModeratorMode, 1, null));
        trackTabChanged();
    }

    @MainThread
    public final void onVisibilityChanged(VisibilityMode visibility) {
        Intrinsics3.checkNotNullParameter(visibility, "visibility");
        BehaviorSubject<ViewMode> behaviorSubject = this.viewModeSubject;
        behaviorSubject.onNext(ViewMode.copy$default(behaviorSubject.n0(), visibility, false, 2, null));
        trackTabChanged();
    }

    public final void trackTabChanged() {
        String str;
        ViewMode viewModeN0 = this.viewModeSubject.n0();
        if (viewModeN0 != null) {
            int iOrdinal = viewModeN0.getThreadListingType().ordinal();
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
            StoreStream.INSTANCE.getAnalytics().trackThreadBrowserTabChanged(this.channelId, str);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetThreadBrowserArchivedViewModel(long j, long j2, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StorePermissions storePermissions, StoreGuildMemberRequester storeGuildMemberRequester) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
        Intrinsics3.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        Intrinsics3.checkNotNullParameter(storePermissions, "storePermissions");
        Intrinsics3.checkNotNullParameter(storeGuildMemberRequester, "storeGuildMemberRequester");
        this.guildId = j;
        this.channelId = j2;
        this.storeGuilds = storeGuilds;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeArchivedThreads = archivedThreadsStore;
        this.storePermissions = storePermissions;
        this.storeGuildMemberRequester = storeGuildMemberRequester;
        BehaviorSubject<ViewMode> behaviorSubjectL0 = BehaviorSubject.l0(new ViewMode(VisibilityMode.PublicThreads, false));
        Intrinsics3.checkNotNullExpressionValue(behaviorSubjectL0, "BehaviorSubject.create(\n…rMode = false\n      )\n  )");
        this.viewModeSubject = behaviorSubjectL0;
        Observable observableY = behaviorSubjectL0.Y(new Func1<ViewMode, Observable<? extends StoreState>>() { // from class: com.discord.widgets.channels.threads.browser.WidgetThreadBrowserArchivedViewModel$storeStateObservable$1
            @Override // j0.k.Func1
            public final Observable<? extends WidgetThreadBrowserArchivedViewModel.StoreState> call(WidgetThreadBrowserArchivedViewModel.ViewMode viewMode) {
                WidgetThreadBrowserArchivedViewModel.Companion companion = WidgetThreadBrowserArchivedViewModel.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(viewMode, "viewMode");
                return companion.observeStoreState(viewMode, this.this$0.guildId, this.this$0.channelId, this.this$0.storeGuilds, this.this$0.storeChannels, this.this$0.storeUser, this.this$0.storeArchivedThreads, this.this$0.storePermissions);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableY, "viewModeSubject\n        …            )\n          }");
        this.storeStateObservable = observableY;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableY, this, null, 2, null), (Class<?>) WidgetThreadBrowserArchivedViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
