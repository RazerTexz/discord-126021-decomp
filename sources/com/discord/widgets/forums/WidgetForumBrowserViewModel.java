package com.discord.widgets.forums;

import androidx.annotation.MainThread;
import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.permission.Permission;
import com.discord.api.role.GuildRole;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreGuildMemberRequester;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreTabsNavigation;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserTyping;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.tabs.NavigationTab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import p001a0.p002a.p003a.C0002b;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12138i0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12160r;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func3;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_TYPING_USERS = 3;
    private boolean canFetchMoreOlderPosts;
    private final PublishSubject<Event> eventSubject;
    private final StoreGuildMemberRequester guildMemberRequester;
    private final Set<Long> initialChannelActivePostFirstMessageFetches;
    private boolean isFetchingMoreOlderPosts;
    private long lastSelectedForumChannelId;
    private final ArchivedThreadsStore storeArchivedThreads;
    private final StoreChannels storeChannels;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreExperiments storeExperiments;
    private final StoreForumPostMessages storeForumPostMessages;
    private final StoreForumPostReadStates storeForumPostReadStates;
    private final StoreGuilds storeGuilds;
    private final StoreMessagesMostRecent storeMessagesMostRecent;
    private final StorePermissions storePermissions;
    private final StoreTabsNavigation storeTabsNavigation;
    private final StoreThreadsActive storeThreadsActive;
    private final StoreThreadMessages storeThreadsMessages;
    private final StoreUser storeUser;
    private final StoreUserRelationships storeUserRelationships;
    private final StoreUserTyping storeUserTyping;

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$1 */
    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static final class C83471 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C83471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetForumBrowserViewModel widgetForumBrowserViewModel = WidgetForumBrowserViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetForumBrowserViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<MinimalStoreState> observeMinimalStoreState(final StoreThreadsActive storeThreadsActive, StoreChannelsSelected storeChannelsSelected, final StoreTabsNavigation storeTabsNavigation, final StoreExperiments storeExperiments) {
            Observable observableM11099Y = storeChannelsSelected.observeResolvedSelectedChannel().m11099Y(new InterfaceC12589b<StoreChannelsSelected.ResolvedSelectedChannel, Observable<? extends MinimalStoreState>>() { // from class: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetForumBrowserViewModel.MinimalStoreState> call(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    final Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
                    return maybeChannel == null ? new C12721k(WidgetForumBrowserViewModel.MinimalStoreState.Invalid.INSTANCE) : Observable.m11075i(storeTabsNavigation.observeSelectedTab(), storeThreadsActive.observeActiveThreadsForChannel(maybeChannel.getGuildId(), Long.valueOf(maybeChannel.getId())), ForumUtils.observeCanAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, maybeChannel.getGuildId(), storeExperiments, null, 4, null), new Func3<NavigationTab, Map<Long, ? extends Channel>, Boolean, WidgetForumBrowserViewModel.MinimalStoreState>() { // from class: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeMinimalStoreState$1.1
                        @Override // p658rx.functions.Func3
                        public /* bridge */ /* synthetic */ WidgetForumBrowserViewModel.MinimalStoreState call(NavigationTab navigationTab, Map<Long, ? extends Channel> map, Boolean bool) {
                            return call2(navigationTab, (Map<Long, Channel>) map, bool);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetForumBrowserViewModel.MinimalStoreState call2(NavigationTab navigationTab, Map<Long, Channel> map, Boolean bool) {
                            C12238m.checkNotNullExpressionValue(bool, "canAccess");
                            if (!bool.booleanValue() || navigationTab != NavigationTab.HOME || !ChannelUtils.m7693q(maybeChannel)) {
                                return WidgetForumBrowserViewModel.MinimalStoreState.Invalid.INSTANCE;
                            }
                            C12238m.checkNotNullExpressionValue(map, "activeThreads");
                            return new WidgetForumBrowserViewModel.MinimalStoreState.Valid(maybeChannel, map);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "storeChannelsSelected.ob…      }\n        }\n      }");
            return observableM11099Y;
        }

        private final Observable<StoreState> observeStoreState(final StoreUser storeUser, final StoreChannels storeChannels, final StoreGuilds storeGuilds, final StoreThreadsActive storeThreadsActive, final ArchivedThreadsStore storeArchivedThreads, final StoreThreadMessages storeThreadsMessages, final StoreForumPostMessages storeForumPostMessages, final StoreUserRelationships storeUserRelationships, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, final StorePermissions storePermissions, final StoreMessagesMostRecent storeMessagesMostRecent, final StoreEmoji storeEmoji, final StoreForumPostReadStates storeForumPostReadStates, final StoreUserTyping storeUserTyping) {
            Observable observableM11099Y = observeMinimalStoreState(storeThreadsActive, storeChannelsSelected, storeTabsNavigation, storeExperiments).m11099Y(new InterfaceC12589b<MinimalStoreState, Observable<? extends StoreState>>() { // from class: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeStoreState$1

                /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$Companion$observeStoreState$1$1 */
                /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
                public static final class C83491 extends AbstractC12240o implements Function17<MeUser, Map<Long, ? extends User>, ArchivedThreadsStore.ThreadListingState, Map<Long, ? extends String>, Map<Long, ? extends GuildMember>, Map<Long, ? extends GuildRole>, Map<Long, ? extends Message>, Map<Long, ? extends StoreThreadMessages.ThreadState>, Map<Long, ? extends Integer>, Long, Map<Long, ? extends Long>, EmojiSet, Map<Long, ? extends ForumPostReadState>, Map<Long, ? extends Integer>, Set<? extends Long>, Boolean, Map<Long, ? extends Set<? extends Long>>, WidgetForumBrowserViewModel.StoreState.Loaded> {
                    public final /* synthetic */ Map $activeThreads;
                    public final /* synthetic */ Channel $parentChannel;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    public C83491(Map map, Channel channel) {
                        super(17);
                        this.$activeThreads = map;
                        this.$parentChannel = channel;
                    }

                    @Override // kotlin.jvm.functions.Function17
                    public /* bridge */ /* synthetic */ WidgetForumBrowserViewModel.StoreState.Loaded invoke(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore.ThreadListingState threadListingState, Map<Long, ? extends String> map2, Map<Long, ? extends GuildMember> map3, Map<Long, ? extends GuildRole> map4, Map<Long, ? extends Message> map5, Map<Long, ? extends StoreThreadMessages.ThreadState> map6, Map<Long, ? extends Integer> map7, Long l, Map<Long, ? extends Long> map8, EmojiSet emojiSet, Map<Long, ? extends ForumPostReadState> map9, Map<Long, ? extends Integer> map10, Set<? extends Long> set, Boolean bool, Map<Long, ? extends Set<? extends Long>> map11) {
                        return invoke(meUser, map, threadListingState, (Map<Long, String>) map2, (Map<Long, GuildMember>) map3, (Map<Long, GuildRole>) map4, (Map<Long, Message>) map5, (Map<Long, StoreThreadMessages.ThreadState>) map6, (Map<Long, Integer>) map7, l, (Map<Long, Long>) map8, emojiSet, (Map<Long, ForumPostReadState>) map9, (Map<Long, Integer>) map10, (Set<Long>) set, bool.booleanValue(), (Map<Long, ? extends Set<Long>>) map11);
                    }

                    public final WidgetForumBrowserViewModel.StoreState.Loaded invoke(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore.ThreadListingState threadListingState, Map<Long, String> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, Message> map5, Map<Long, StoreThreadMessages.ThreadState> map6, Map<Long, Integer> map7, Long l, Map<Long, Long> map8, EmojiSet emojiSet, Map<Long, ForumPostReadState> map9, Map<Long, Integer> map10, Set<Long> set, boolean z2, Map<Long, ? extends Set<Long>> map11) {
                        C83491 c83491 = this;
                        C12238m.checkNotNullParameter(meUser, "meUser");
                        C12238m.checkNotNullParameter(map, "users");
                        C12238m.checkNotNullParameter(threadListingState, "archivedThreadsState");
                        C12238m.checkNotNullParameter(map2, "channelNames");
                        C12238m.checkNotNullParameter(map4, "guildRoles");
                        C12238m.checkNotNullParameter(map5, "forumPostFirstMessages");
                        C12238m.checkNotNullParameter(map6, "forumPostMessageCounts");
                        C12238m.checkNotNullParameter(map7, "myBlockedUsers");
                        C12238m.checkNotNullParameter(map8, "mostRecentMessageIds");
                        C12238m.checkNotNullParameter(emojiSet, "emojis");
                        C12238m.checkNotNullParameter(map9, "forumPostReadStates");
                        C12238m.checkNotNullParameter(map10, "forumPostUnreadCounts");
                        C12238m.checkNotNullParameter(set, "forumPostWithPersistedReadStates");
                        C12238m.checkNotNullParameter(map11, "typingUsers");
                        Map map12 = c83491.$activeThreads;
                        C12238m.checkNotNullExpressionValue(map3, "guildMembers");
                        Channel channel = c83491.$parentChannel;
                        Set<Long> setKeySet = map7.keySet();
                        boolean zCan = PermissionUtils.can(Permission.SEND_MESSAGES, l);
                        Map<String, Emoji> map13 = emojiSet.emojiIndex;
                        C12238m.checkNotNullExpressionValue(map13, "emojis.emojiIndex");
                        Map map14 = C12136h0.toMap(map13);
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        for (Map.Entry<Long, Integer> entry : map10.entrySet()) {
                            if (set.contains(Long.valueOf(entry.getKey().longValue()))) {
                                linkedHashMap.put(entry.getKey(), entry.getValue());
                            }
                        }
                        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                        for (Map.Entry<Long, ? extends Set<Long>> entry2 : map11.entrySet()) {
                            if (c83491.$activeThreads.containsKey(Long.valueOf(entry2.getKey().longValue()))) {
                                linkedHashMap2.put(entry2.getKey(), entry2.getValue());
                            }
                            c83491 = this;
                        }
                        return new WidgetForumBrowserViewModel.StoreState.Loaded(meUser, map, threadListingState, map12, map3, map4, map2, channel, map5, map6, setKeySet, zCan, map8, map14, map9, linkedHashMap, z2, linkedHashMap2);
                    }
                }

                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends WidgetForumBrowserViewModel.StoreState> call(WidgetForumBrowserViewModel.MinimalStoreState minimalStoreState) {
                    if (!(minimalStoreState instanceof WidgetForumBrowserViewModel.MinimalStoreState.Valid)) {
                        return new C12721k(WidgetForumBrowserViewModel.StoreState.Invalid.INSTANCE);
                    }
                    WidgetForumBrowserViewModel.MinimalStoreState.Valid valid = (WidgetForumBrowserViewModel.MinimalStoreState.Valid) minimalStoreState;
                    Channel channel = valid.getChannel();
                    Map<Long, Channel> activeThreads = valid.getActiveThreads();
                    Observable observableObserveMe$default = StoreUser.observeMe$default(storeUser, false, 1, null);
                    Observable<Map<Long, User>> observableObserveAllUsers = storeUser.observeAllUsers();
                    Observable<ArchivedThreadsStore.ThreadListingState> observableMaybeLoadAndObserveThreadListing = ForumUtils.INSTANCE.maybeLoadAndObserveThreadListing(channel.getId(), true ^ activeThreads.isEmpty(), storeArchivedThreads);
                    Observable<Map<Long, String>> observableObserveNames = storeChannels.observeNames();
                    Observable<Map<Long, GuildMember>> observableObserveGuildMembers = storeGuilds.observeGuildMembers(channel.getGuildId());
                    C12238m.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …rs(parentChannel.guildId)");
                    Observable<T> observableM11112r = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).m11112r();
                    C12238m.checkNotNullExpressionValue(observableM11112r, "storeGuilds\n            …  .distinctUntilChanged()");
                    return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe$default, observableObserveAllUsers, observableMaybeLoadAndObserveThreadListing, observableObserveNames, observableM11112r, storeGuilds.observeRoles(channel.getGuildId()), storeForumPostMessages.observeForumPostFirstMessages(), storeThreadsMessages.observeThreadCountAndLatestMessage(), storeUserRelationships.observeForType(2), storePermissions.observePermissionsForChannel(channel.getId()), storeMessagesMostRecent.observeRecentMessageIds(), storeEmoji.getEmojiSet(channel.getGuildId(), channel.getId(), (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? false : false), ForumPostReadStateManager.INSTANCE.observeForumPostReadStates(channel.getGuildId(), channel.getId(), (28 & 4) != 0 ? StoreStream.INSTANCE.getReadStates() : null, (28 & 8) != 0 ? StoreStream.INSTANCE.getThreadsActive() : null, (28 & 16) != 0 ? StoreStream.INSTANCE.getForumPostReadStates() : null), storeForumPostReadStates.observeThreadUnreadCounts(), storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), storeThreadsActive.observeIsThreadSyncedGuild(channel.getGuildId()), storeUserTyping.observeTypingUsersForChannels(activeThreads.keySet()), new C83491(activeThreads, channel));
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "observeMinimalStoreState…      }\n        }\n      }");
            return observableM11099Y;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final class ScrollToTop extends Event {
            public static final ScrollToTop INSTANCE = new ScrollToTop();

            private ScrollToTop() {
                super(null);
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class MinimalStoreState {

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final class Invalid extends MinimalStoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Valid extends MinimalStoreState {
            private final Map<Long, Channel> activeThreads;
            private final Channel channel;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(Channel channel, Map<Long, Channel> map) {
                super(null);
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(map, "activeThreads");
                this.channel = channel;
                this.activeThreads = map;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, Channel channel, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    channel = valid.channel;
                }
                if ((i & 2) != 0) {
                    map = valid.activeThreads;
                }
                return valid.copy(channel, map);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Channel> component2() {
                return this.activeThreads;
            }

            public final Valid copy(Channel channel, Map<Long, Channel> activeThreads) {
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(activeThreads, "activeThreads");
                return new Valid(channel, activeThreads);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.channel, valid.channel) && C12238m.areEqual(this.activeThreads, valid.activeThreads);
            }

            public final Map<Long, Channel> getActiveThreads() {
                return this.activeThreads;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public int hashCode() {
                Channel channel = this.channel;
                int iHashCode = (channel != null ? channel.hashCode() : 0) * 31;
                Map<Long, Channel> map = this.activeThreads;
                return iHashCode + (map != null ? map.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", activeThreads=");
                return C1643a.m825M(sbM833U, this.activeThreads, ")");
            }
        }

        private MinimalStoreState() {
        }

        public /* synthetic */ MinimalStoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static final /* data */ class NsfwPanelState {
        private final long guildId;
        private final boolean isChannelNsfw;
        private final boolean isNsfwUnconsented;
        private final NsfwAllowance nsfwAllowed;

        public NsfwPanelState(boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j) {
            this.isNsfwUnconsented = z2;
            this.isChannelNsfw = z3;
            this.nsfwAllowed = nsfwAllowance;
            this.guildId = j;
        }

        public static /* synthetic */ NsfwPanelState copy$default(NsfwPanelState nsfwPanelState, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                z2 = nsfwPanelState.isNsfwUnconsented;
            }
            if ((i & 2) != 0) {
                z3 = nsfwPanelState.isChannelNsfw;
            }
            boolean z4 = z3;
            if ((i & 4) != 0) {
                nsfwAllowance = nsfwPanelState.nsfwAllowed;
            }
            NsfwAllowance nsfwAllowance2 = nsfwAllowance;
            if ((i & 8) != 0) {
                j = nsfwPanelState.guildId;
            }
            return nsfwPanelState.copy(z2, z4, nsfwAllowance2, j);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final boolean getIsNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final boolean getIsChannelNsfw() {
            return this.isChannelNsfw;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final long getGuildId() {
            return this.guildId;
        }

        public final NsfwPanelState copy(boolean isNsfwUnconsented, boolean isChannelNsfw, NsfwAllowance nsfwAllowed, long guildId) {
            return new NsfwPanelState(isNsfwUnconsented, isChannelNsfw, nsfwAllowed, guildId);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof NsfwPanelState)) {
                return false;
            }
            NsfwPanelState nsfwPanelState = (NsfwPanelState) other;
            return this.isNsfwUnconsented == nsfwPanelState.isNsfwUnconsented && this.isChannelNsfw == nsfwPanelState.isChannelNsfw && C12238m.areEqual(this.nsfwAllowed, nsfwPanelState.nsfwAllowed) && this.guildId == nsfwPanelState.guildId;
        }

        public final long getGuildId() {
            return this.guildId;
        }

        public final NsfwAllowance getNsfwAllowed() {
            return this.nsfwAllowed;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v1, types: [int] */
        /* JADX WARN: Type inference failed for: r0v3, types: [int] */
        /* JADX WARN: Type inference failed for: r0v7 */
        /* JADX WARN: Type inference failed for: r0v8 */
        /* JADX WARN: Type inference failed for: r1v0 */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v9 */
        public int hashCode() {
            boolean z2 = this.isNsfwUnconsented;
            ?? r0 = z2;
            if (z2) {
                r0 = 1;
            }
            int i = r0 * 31;
            boolean z3 = this.isChannelNsfw;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            NsfwAllowance nsfwAllowance = this.nsfwAllowed;
            return C0002b.m3a(this.guildId) + ((i2 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31);
        }

        public final boolean isChannelNsfw() {
            return this.isChannelNsfw;
        }

        public final boolean isNsfwUnconsented() {
            return this.isNsfwUnconsented;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("NsfwPanelState(isNsfwUnconsented=");
            sbM833U.append(this.isNsfwUnconsented);
            sbM833U.append(", isChannelNsfw=");
            sbM833U.append(this.isChannelNsfw);
            sbM833U.append(", nsfwAllowed=");
            sbM833U.append(this.nsfwAllowed);
            sbM833U.append(", guildId=");
            return C1643a.m815C(sbM833U, this.guildId, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Loaded extends StoreState {
            private final Map<Long, Channel> activeThreads;
            private final ArchivedThreadsStore.ThreadListingState archivedThreadsState;
            private final boolean canCreateForumChannelPosts;
            private final Channel channel;
            private final Map<Long, String> channelNames;
            private final Map<Long, Message> forumPostFirstMessages;
            private final Map<Long, StoreThreadMessages.ThreadState> forumPostMessageCounts;
            private final Map<Long, ForumPostReadState> forumPostReadStates;
            private final Map<Long, Integer> forumPostUnreadCounts;
            private final Map<String, Emoji> guildEmojis;
            private final Map<Long, GuildMember> guildMembers;
            private final Map<Long, GuildRole> guildRoles;
            private final boolean isThreadSyncedGuild;
            private final MeUser meUser;
            private final Map<Long, Long> mostRecentMessageIds;
            private final Set<Long> myBlockedUserIds;
            private final Map<Long, Set<Long>> typingUsers;
            private final Map<Long, User> users;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(MeUser meUser, Map<Long, ? extends User> map, ArchivedThreadsStore.ThreadListingState threadListingState, Map<Long, Channel> map2, Map<Long, GuildMember> map3, Map<Long, GuildRole> map4, Map<Long, String> map5, Channel channel, Map<Long, Message> map6, Map<Long, StoreThreadMessages.ThreadState> map7, Set<Long> set, boolean z2, Map<Long, Long> map8, Map<String, ? extends Emoji> map9, Map<Long, ForumPostReadState> map10, Map<Long, Integer> map11, boolean z3, Map<Long, ? extends Set<Long>> map12) {
                super(null);
                C12238m.checkNotNullParameter(meUser, "meUser");
                C12238m.checkNotNullParameter(map, "users");
                C12238m.checkNotNullParameter(threadListingState, "archivedThreadsState");
                C12238m.checkNotNullParameter(map2, "activeThreads");
                C12238m.checkNotNullParameter(map3, "guildMembers");
                C12238m.checkNotNullParameter(map4, "guildRoles");
                C12238m.checkNotNullParameter(map5, "channelNames");
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(map6, "forumPostFirstMessages");
                C12238m.checkNotNullParameter(map7, "forumPostMessageCounts");
                C12238m.checkNotNullParameter(set, "myBlockedUserIds");
                C12238m.checkNotNullParameter(map8, "mostRecentMessageIds");
                C12238m.checkNotNullParameter(map9, "guildEmojis");
                C12238m.checkNotNullParameter(map10, "forumPostReadStates");
                C12238m.checkNotNullParameter(map11, "forumPostUnreadCounts");
                C12238m.checkNotNullParameter(map12, "typingUsers");
                this.meUser = meUser;
                this.users = map;
                this.archivedThreadsState = threadListingState;
                this.activeThreads = map2;
                this.guildMembers = map3;
                this.guildRoles = map4;
                this.channelNames = map5;
                this.channel = channel;
                this.forumPostFirstMessages = map6;
                this.forumPostMessageCounts = map7;
                this.myBlockedUserIds = set;
                this.canCreateForumChannelPosts = z2;
                this.mostRecentMessageIds = map8;
                this.guildEmojis = map9;
                this.forumPostReadStates = map10;
                this.forumPostUnreadCounts = map11;
                this.isThreadSyncedGuild = z3;
                this.typingUsers = map12;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Map<Long, StoreThreadMessages.ThreadState> component10() {
                return this.forumPostMessageCounts;
            }

            public final Set<Long> component11() {
                return this.myBlockedUserIds;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            public final Map<Long, Long> component13() {
                return this.mostRecentMessageIds;
            }

            public final Map<String, Emoji> component14() {
                return this.guildEmojis;
            }

            public final Map<Long, ForumPostReadState> component15() {
                return this.forumPostReadStates;
            }

            public final Map<Long, Integer> component16() {
                return this.forumPostUnreadCounts;
            }

            /* JADX INFO: renamed from: component17, reason: from getter */
            public final boolean getIsThreadSyncedGuild() {
                return this.isThreadSyncedGuild;
            }

            public final Map<Long, Set<Long>> component18() {
                return this.typingUsers;
            }

            public final Map<Long, User> component2() {
                return this.users;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final ArchivedThreadsStore.ThreadListingState getArchivedThreadsState() {
                return this.archivedThreadsState;
            }

            public final Map<Long, Channel> component4() {
                return this.activeThreads;
            }

            public final Map<Long, GuildMember> component5() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> component6() {
                return this.guildRoles;
            }

            public final Map<Long, String> component7() {
                return this.channelNames;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, Message> component9() {
                return this.forumPostFirstMessages;
            }

            public final Loaded copy(MeUser meUser, Map<Long, ? extends User> users, ArchivedThreadsStore.ThreadListingState archivedThreadsState, Map<Long, Channel> activeThreads, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, String> channelNames, Channel channel, Map<Long, Message> forumPostFirstMessages, Map<Long, StoreThreadMessages.ThreadState> forumPostMessageCounts, Set<Long> myBlockedUserIds, boolean canCreateForumChannelPosts, Map<Long, Long> mostRecentMessageIds, Map<String, ? extends Emoji> guildEmojis, Map<Long, ForumPostReadState> forumPostReadStates, Map<Long, Integer> forumPostUnreadCounts, boolean isThreadSyncedGuild, Map<Long, ? extends Set<Long>> typingUsers) {
                C12238m.checkNotNullParameter(meUser, "meUser");
                C12238m.checkNotNullParameter(users, "users");
                C12238m.checkNotNullParameter(archivedThreadsState, "archivedThreadsState");
                C12238m.checkNotNullParameter(activeThreads, "activeThreads");
                C12238m.checkNotNullParameter(guildMembers, "guildMembers");
                C12238m.checkNotNullParameter(guildRoles, "guildRoles");
                C12238m.checkNotNullParameter(channelNames, "channelNames");
                C12238m.checkNotNullParameter(channel, "channel");
                C12238m.checkNotNullParameter(forumPostFirstMessages, "forumPostFirstMessages");
                C12238m.checkNotNullParameter(forumPostMessageCounts, "forumPostMessageCounts");
                C12238m.checkNotNullParameter(myBlockedUserIds, "myBlockedUserIds");
                C12238m.checkNotNullParameter(mostRecentMessageIds, "mostRecentMessageIds");
                C12238m.checkNotNullParameter(guildEmojis, "guildEmojis");
                C12238m.checkNotNullParameter(forumPostReadStates, "forumPostReadStates");
                C12238m.checkNotNullParameter(forumPostUnreadCounts, "forumPostUnreadCounts");
                C12238m.checkNotNullParameter(typingUsers, "typingUsers");
                return new Loaded(meUser, users, archivedThreadsState, activeThreads, guildMembers, guildRoles, channelNames, channel, forumPostFirstMessages, forumPostMessageCounts, myBlockedUserIds, canCreateForumChannelPosts, mostRecentMessageIds, guildEmojis, forumPostReadStates, forumPostUnreadCounts, isThreadSyncedGuild, typingUsers);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.meUser, loaded.meUser) && C12238m.areEqual(this.users, loaded.users) && C12238m.areEqual(this.archivedThreadsState, loaded.archivedThreadsState) && C12238m.areEqual(this.activeThreads, loaded.activeThreads) && C12238m.areEqual(this.guildMembers, loaded.guildMembers) && C12238m.areEqual(this.guildRoles, loaded.guildRoles) && C12238m.areEqual(this.channelNames, loaded.channelNames) && C12238m.areEqual(this.channel, loaded.channel) && C12238m.areEqual(this.forumPostFirstMessages, loaded.forumPostFirstMessages) && C12238m.areEqual(this.forumPostMessageCounts, loaded.forumPostMessageCounts) && C12238m.areEqual(this.myBlockedUserIds, loaded.myBlockedUserIds) && this.canCreateForumChannelPosts == loaded.canCreateForumChannelPosts && C12238m.areEqual(this.mostRecentMessageIds, loaded.mostRecentMessageIds) && C12238m.areEqual(this.guildEmojis, loaded.guildEmojis) && C12238m.areEqual(this.forumPostReadStates, loaded.forumPostReadStates) && C12238m.areEqual(this.forumPostUnreadCounts, loaded.forumPostUnreadCounts) && this.isThreadSyncedGuild == loaded.isThreadSyncedGuild && C12238m.areEqual(this.typingUsers, loaded.typingUsers);
            }

            public final Map<Long, Channel> getActiveThreads() {
                return this.activeThreads;
            }

            public final ArchivedThreadsStore.ThreadListingState getArchivedThreadsState() {
                return this.archivedThreadsState;
            }

            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            public final Channel getChannel() {
                return this.channel;
            }

            public final Map<Long, String> getChannelNames() {
                return this.channelNames;
            }

            public final Map<Long, Message> getForumPostFirstMessages() {
                return this.forumPostFirstMessages;
            }

            public final Map<Long, StoreThreadMessages.ThreadState> getForumPostMessageCounts() {
                return this.forumPostMessageCounts;
            }

            public final Map<Long, ForumPostReadState> getForumPostReadStates() {
                return this.forumPostReadStates;
            }

            public final Map<Long, Integer> getForumPostUnreadCounts() {
                return this.forumPostUnreadCounts;
            }

            public final Map<String, Emoji> getGuildEmojis() {
                return this.guildEmojis;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final MeUser getMeUser() {
                return this.meUser;
            }

            public final Map<Long, Long> getMostRecentMessageIds() {
                return this.mostRecentMessageIds;
            }

            public final Set<Long> getMyBlockedUserIds() {
                return this.myBlockedUserIds;
            }

            public final Map<Long, Set<Long>> getTypingUsers() {
                return this.typingUsers;
            }

            public final Map<Long, User> getUsers() {
                return this.users;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v24, types: [int] */
            /* JADX WARN: Type inference failed for: r2v31, types: [int] */
            /* JADX WARN: Type inference failed for: r2v50 */
            /* JADX WARN: Type inference failed for: r2v61 */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                MeUser meUser = this.meUser;
                int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
                Map<Long, User> map = this.users;
                int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
                ArchivedThreadsStore.ThreadListingState threadListingState = this.archivedThreadsState;
                int iHashCode3 = (iHashCode2 + (threadListingState != null ? threadListingState.hashCode() : 0)) * 31;
                Map<Long, Channel> map2 = this.activeThreads;
                int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map3 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map4 = this.guildRoles;
                int iHashCode6 = (iHashCode5 + (map4 != null ? map4.hashCode() : 0)) * 31;
                Map<Long, String> map5 = this.channelNames;
                int iHashCode7 = (iHashCode6 + (map5 != null ? map5.hashCode() : 0)) * 31;
                Channel channel = this.channel;
                int iHashCode8 = (iHashCode7 + (channel != null ? channel.hashCode() : 0)) * 31;
                Map<Long, Message> map6 = this.forumPostFirstMessages;
                int iHashCode9 = (iHashCode8 + (map6 != null ? map6.hashCode() : 0)) * 31;
                Map<Long, StoreThreadMessages.ThreadState> map7 = this.forumPostMessageCounts;
                int iHashCode10 = (iHashCode9 + (map7 != null ? map7.hashCode() : 0)) * 31;
                Set<Long> set = this.myBlockedUserIds;
                int iHashCode11 = (iHashCode10 + (set != null ? set.hashCode() : 0)) * 31;
                boolean z2 = this.canCreateForumChannelPosts;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode11 + r2) * 31;
                Map<Long, Long> map8 = this.mostRecentMessageIds;
                int iHashCode12 = (i + (map8 != null ? map8.hashCode() : 0)) * 31;
                Map<String, Emoji> map9 = this.guildEmojis;
                int iHashCode13 = (iHashCode12 + (map9 != null ? map9.hashCode() : 0)) * 31;
                Map<Long, ForumPostReadState> map10 = this.forumPostReadStates;
                int iHashCode14 = (iHashCode13 + (map10 != null ? map10.hashCode() : 0)) * 31;
                Map<Long, Integer> map11 = this.forumPostUnreadCounts;
                int iHashCode15 = (iHashCode14 + (map11 != null ? map11.hashCode() : 0)) * 31;
                boolean z3 = this.isThreadSyncedGuild;
                int i2 = (iHashCode15 + (z3 ? 1 : z3)) * 31;
                Map<Long, Set<Long>> map12 = this.typingUsers;
                return i2 + (map12 != null ? map12.hashCode() : 0);
            }

            public final boolean isThreadSyncedGuild() {
                return this.isThreadSyncedGuild;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(meUser=");
                sbM833U.append(this.meUser);
                sbM833U.append(", users=");
                sbM833U.append(this.users);
                sbM833U.append(", archivedThreadsState=");
                sbM833U.append(this.archivedThreadsState);
                sbM833U.append(", activeThreads=");
                sbM833U.append(this.activeThreads);
                sbM833U.append(", guildMembers=");
                sbM833U.append(this.guildMembers);
                sbM833U.append(", guildRoles=");
                sbM833U.append(this.guildRoles);
                sbM833U.append(", channelNames=");
                sbM833U.append(this.channelNames);
                sbM833U.append(", channel=");
                sbM833U.append(this.channel);
                sbM833U.append(", forumPostFirstMessages=");
                sbM833U.append(this.forumPostFirstMessages);
                sbM833U.append(", forumPostMessageCounts=");
                sbM833U.append(this.forumPostMessageCounts);
                sbM833U.append(", myBlockedUserIds=");
                sbM833U.append(this.myBlockedUserIds);
                sbM833U.append(", canCreateForumChannelPosts=");
                sbM833U.append(this.canCreateForumChannelPosts);
                sbM833U.append(", mostRecentMessageIds=");
                sbM833U.append(this.mostRecentMessageIds);
                sbM833U.append(", guildEmojis=");
                sbM833U.append(this.guildEmojis);
                sbM833U.append(", forumPostReadStates=");
                sbM833U.append(this.forumPostReadStates);
                sbM833U.append(", forumPostUnreadCounts=");
                sbM833U.append(this.forumPostUnreadCounts);
                sbM833U.append(", isThreadSyncedGuild=");
                sbM833U.append(this.isThreadSyncedGuild);
                sbM833U.append(", typingUsers=");
                return C1643a.m825M(sbM833U, this.typingUsers, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static abstract class ViewState {
        private final NsfwPanelState nsfwPanelState;

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean canCreateForumChannelPosts;
            private final long channelId;
            private final String channelName;
            private final String channelTopic;
            private final long guildId;
            private final List<ForumBrowserItem> listItems;
            private final NsfwPanelState nsfwPanelState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(NsfwPanelState nsfwPanelState, List<? extends ForumBrowserItem> list, boolean z2, String str, String str2, long j, long j2) {
                super(nsfwPanelState, null);
                C12238m.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                C12238m.checkNotNullParameter(list, "listItems");
                C12238m.checkNotNullParameter(str, "channelName");
                this.nsfwPanelState = nsfwPanelState;
                this.listItems = list;
                this.canCreateForumChannelPosts = z2;
                this.channelName = str;
                this.channelTopic = str2;
                this.channelId = j;
                this.guildId = j2;
            }

            public final NsfwPanelState component1() {
                return getNsfwPanelState();
            }

            public final List<ForumBrowserItem> component2() {
                return this.listItems;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final String getChannelName() {
                return this.channelName;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final String getChannelTopic() {
                return this.channelTopic;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final long getChannelId() {
                return this.channelId;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final long getGuildId() {
                return this.guildId;
            }

            public final Loaded copy(NsfwPanelState nsfwPanelState, List<? extends ForumBrowserItem> listItems, boolean canCreateForumChannelPosts, String channelName, String channelTopic, long channelId, long guildId) {
                C12238m.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                C12238m.checkNotNullParameter(listItems, "listItems");
                C12238m.checkNotNullParameter(channelName, "channelName");
                return new Loaded(nsfwPanelState, listItems, canCreateForumChannelPosts, channelName, channelTopic, channelId, guildId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(getNsfwPanelState(), loaded.getNsfwPanelState()) && C12238m.areEqual(this.listItems, loaded.listItems) && this.canCreateForumChannelPosts == loaded.canCreateForumChannelPosts && C12238m.areEqual(this.channelName, loaded.channelName) && C12238m.areEqual(this.channelTopic, loaded.channelTopic) && this.channelId == loaded.channelId && this.guildId == loaded.guildId;
            }

            public final boolean getCanCreateForumChannelPosts() {
                return this.canCreateForumChannelPosts;
            }

            public final long getChannelId() {
                return this.channelId;
            }

            public final String getChannelName() {
                return this.channelName;
            }

            public final String getChannelTopic() {
                return this.channelTopic;
            }

            public final long getGuildId() {
                return this.guildId;
            }

            public final List<ForumBrowserItem> getListItems() {
                return this.listItems;
            }

            @Override // com.discord.widgets.forums.WidgetForumBrowserViewModel.ViewState
            public NsfwPanelState getNsfwPanelState() {
                return this.nsfwPanelState;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r2v11 */
            /* JADX WARN: Type inference failed for: r2v13 */
            /* JADX WARN: Type inference failed for: r2v4, types: [int] */
            public int hashCode() {
                NsfwPanelState nsfwPanelState = getNsfwPanelState();
                int iHashCode = (nsfwPanelState != null ? nsfwPanelState.hashCode() : 0) * 31;
                List<ForumBrowserItem> list = this.listItems;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                boolean z2 = this.canCreateForumChannelPosts;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode2 + r2) * 31;
                String str = this.channelName;
                int iHashCode3 = (i + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.channelTopic;
                return C0002b.m3a(this.guildId) + ((C0002b.m3a(this.channelId) + ((iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31)) * 31);
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(nsfwPanelState=");
                sbM833U.append(getNsfwPanelState());
                sbM833U.append(", listItems=");
                sbM833U.append(this.listItems);
                sbM833U.append(", canCreateForumChannelPosts=");
                sbM833U.append(this.canCreateForumChannelPosts);
                sbM833U.append(", channelName=");
                sbM833U.append(this.channelName);
                sbM833U.append(", channelTopic=");
                sbM833U.append(this.channelTopic);
                sbM833U.append(", channelId=");
                sbM833U.append(this.channelId);
                sbM833U.append(", guildId=");
                return C1643a.m815C(sbM833U, this.guildId, ")");
            }
        }

        /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
        public static final /* data */ class Loading extends ViewState {
            private final NsfwPanelState nsfwPanelState;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loading(NsfwPanelState nsfwPanelState) {
                super(nsfwPanelState, null);
                C12238m.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                this.nsfwPanelState = nsfwPanelState;
            }

            public static /* synthetic */ Loading copy$default(Loading loading, NsfwPanelState nsfwPanelState, int i, Object obj) {
                if ((i & 1) != 0) {
                    nsfwPanelState = loading.getNsfwPanelState();
                }
                return loading.copy(nsfwPanelState);
            }

            public final NsfwPanelState component1() {
                return getNsfwPanelState();
            }

            public final Loading copy(NsfwPanelState nsfwPanelState) {
                C12238m.checkNotNullParameter(nsfwPanelState, "nsfwPanelState");
                return new Loading(nsfwPanelState);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loading) && C12238m.areEqual(getNsfwPanelState(), ((Loading) other).getNsfwPanelState());
                }
                return true;
            }

            @Override // com.discord.widgets.forums.WidgetForumBrowserViewModel.ViewState
            public NsfwPanelState getNsfwPanelState() {
                return this.nsfwPanelState;
            }

            public int hashCode() {
                NsfwPanelState nsfwPanelState = getNsfwPanelState();
                if (nsfwPanelState != null) {
                    return nsfwPanelState.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loading(nsfwPanelState=");
                sbM833U.append(getNsfwPanelState());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        private ViewState(NsfwPanelState nsfwPanelState) {
            this.nsfwPanelState = nsfwPanelState;
        }

        public NsfwPanelState getNsfwPanelState() {
            return this.nsfwPanelState;
        }

        public /* synthetic */ ViewState(NsfwPanelState nsfwPanelState, DefaultConstructorMarker defaultConstructorMarker) {
            this(nsfwPanelState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$maybeFetchOlderPosts$1 */
    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static final class C83501 extends AbstractC12240o implements Function0<Unit> {
        public C83501() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetForumBrowserViewModel.this.isFetchingMoreOlderPosts = false;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumBrowserViewModel$setupListViewState$1 */
    /* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
    public static final class C83511 extends AbstractC12240o implements Function1<Channel, ForumBrowserItem.PostItem> {
        public final /* synthetic */ Set $seenChannelIds;
        public final /* synthetic */ StoreState.Loaded $storeState;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C83511(Set set, StoreState.Loaded loaded) {
            super(1);
            this.$seenChannelIds = set;
            this.$storeState = loaded;
        }

        @Override // kotlin.jvm.functions.Function1
        public final ForumBrowserItem.PostItem invoke(Channel channel) {
            C12238m.checkNotNullParameter(channel, "channel");
            if (this.$seenChannelIds.contains(Long.valueOf(channel.getId()))) {
                return null;
            }
            this.$seenChannelIds.add(Long.valueOf(channel.getId()));
            WidgetForumBrowserViewModel.this.guildMemberRequester.queueRequest(channel.getGuildId(), channel.getOwnerId());
            return WidgetForumBrowserViewModel.this.createPostItem(this.$storeState, channel);
        }
    }

    public WidgetForumBrowserViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetForumBrowserViewModel(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, ArchivedThreadsStore archivedThreadsStore, StoreThreadsActive storeThreadsActive, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreGuildMemberRequester storeGuildMemberRequester, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 1) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 4) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        ArchivedThreadsStore archivedThreads = (i & 8) != 0 ? StoreStream.INSTANCE.getArchivedThreads() : archivedThreadsStore;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.INSTANCE.getThreadsActive() : storeThreadsActive;
        StoreThreadMessages threadMessages = (i & 32) != 0 ? StoreStream.INSTANCE.getThreadMessages() : storeThreadMessages;
        StoreForumPostMessages forumPostMessages = (i & 64) != 0 ? StoreStream.INSTANCE.getForumPostMessages() : storeForumPostMessages;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.INSTANCE.getUserRelationships() : storeUserRelationships;
        StoreGuildMemberRequester guildMemberRequester = (i & 256) != 0 ? StoreStream.INSTANCE.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreChannelsSelected channelsSelected = (i & 512) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreTabsNavigation tabsNavigation = (i & 1024) != 0 ? StoreStream.INSTANCE.getTabsNavigation() : storeTabsNavigation;
        StoreExperiments experiments = (i & 2048) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.INSTANCE.getPermissions() : storePermissions;
        StoreMessagesMostRecent messagesMostRecent = (i & 8192) != 0 ? StoreStream.INSTANCE.getMessagesMostRecent() : storeMessagesMostRecent;
        StoreEmoji emojis = (i & 16384) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreForumPostReadStates forumPostReadStates = (i & 32768) != 0 ? StoreStream.INSTANCE.getForumPostReadStates() : storeForumPostReadStates;
        StoreUserTyping usersTyping = (i & 65536) != 0 ? StoreStream.INSTANCE.getUsersTyping() : storeUserTyping;
        this(users, channels, guilds, archivedThreads, threadsActive, threadMessages, forumPostMessages, userRelationships, guildMemberRequester, channelsSelected, tabsNavigation, experiments, permissions, messagesMostRecent, emojis, forumPostReadStates, usersTyping, (i & 131072) != 0 ? INSTANCE.observeStoreState(users, channels, guilds, threadsActive, archivedThreads, threadMessages, forumPostMessages, userRelationships, channelsSelected, tabsNavigation, experiments, permissions, messagesMostRecent, emojis, forumPostReadStates, usersTyping) : observable);
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:78:0x01af  */
    private final ForumBrowserItem.PostItem createPostItem(StoreState.Loaded storeState, Channel channel) {
        LinkedHashMap linkedHashMap;
        PostTagData postTagData;
        List listEmptyList;
        GuildMember guildMember;
        PostTagData postTagDataFromTag;
        ForumTag forumTag;
        boolean z2;
        com.discord.api.user.User author;
        User user = storeState.getUsers().get(Long.valueOf(channel.getOwnerId()));
        Message message = (Message) C1643a.m845d(channel, storeState.getForumPostFirstMessages());
        Long lValueOf = (message == null || (author = message.getAuthor()) == null) ? null : Long.valueOf(author.getId());
        boolean z3 = lValueOf != null && storeState.getMyBlockedUserIds().contains(lValueOf);
        StoreThreadMessages.ThreadState threadState = (StoreThreadMessages.ThreadState) C1643a.m845d(channel, storeState.getForumPostMessageCounts());
        Integer numValueOf = threadState != null ? Integer.valueOf(threadState.getCount()) : null;
        Long l = (Long) C1643a.m845d(channel, storeState.getMostRecentMessageIds());
        Long lValueOf2 = l != null ? Long.valueOf((l.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) : null;
        ForumPostReadState forumPostReadStateCreateDefault = (ForumPostReadState) C1643a.m845d(channel, storeState.getForumPostReadStates());
        if (forumPostReadStateCreateDefault == null) {
            forumPostReadStateCreateDefault = ForumPostReadState.INSTANCE.createDefault(channel.getId());
        }
        ForumPostReadState forumPostReadState = forumPostReadStateCreateDefault;
        List<ForumTag> listM7637d = storeState.getChannel().m7637d();
        if (listM7637d != null) {
            linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(listM7637d, 10)), 16));
            for (Object obj : listM7637d) {
                linkedHashMap.put(Long.valueOf(((ForumTag) obj).getId()), obj);
            }
        } else {
            linkedHashMap = null;
        }
        List<Long> listM7636c = channel.m7636c();
        if (listM7636c != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM7636c.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                if (linkedHashMap == null || (forumTag = (ForumTag) linkedHashMap.get(Long.valueOf(jLongValue))) == null) {
                    postTagDataFromTag = null;
                } else {
                    if (forumTag.getCustomEmojiId() == null) {
                        z2 = false;
                    } else {
                        Emoji emoji = storeState.getGuildEmojis().get(forumTag.getCustomEmojiId());
                        if ((emoji instanceof ModelEmojiCustom) && ((ModelEmojiCustom) emoji).isAnimated()) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                    }
                    postTagDataFromTag = PostTagData.INSTANCE.fromTag(forumTag, z2);
                }
                if (postTagDataFromTag != null) {
                    arrayList.add(postTagDataFromTag);
                }
            }
            postTagData = (PostTagData) C12163u.firstOrNull((List) arrayList);
        } else {
            postTagData = null;
        }
        MessageReaction messageReactionMostCommonReaction = message != null ? ForumUtils.INSTANCE.mostCommonReaction(message, this.storeEmoji) : null;
        boolean zIsDefaultPostReaction = messageReactionMostCommonReaction != null ? ForumUtils.INSTANCE.isDefaultPostReaction(messageReactionMostCommonReaction, this.storeEmoji) : false;
        Set set = (Set) C1643a.m845d(channel, storeState.getTypingUsers());
        if (set != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                long jLongValue2 = ((Number) it2.next()).longValue();
                User user2 = storeState.getUsers().get(Long.valueOf(jLongValue2));
                UserGuildMember userGuildMember = (user2 == null || (guildMember = storeState.getGuildMembers().get(Long.valueOf(jLongValue2))) == null) ? null : new UserGuildMember(user2, guildMember);
                if (userGuildMember != null) {
                    arrayList2.add(userGuildMember);
                }
            }
            listEmptyList = C12163u.take(arrayList2, 3);
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
        } else {
            listEmptyList = C12147n.emptyList();
        }
        return new ForumBrowserItem.PostItem(new PostData(channel, user, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), message, z3, lValueOf2, numValueOf, postTagData, messageReactionMostCommonReaction, zIsDefaultPostReaction, forumPostReadState, (Integer) C1643a.m845d(channel, storeState.getForumPostUnreadCounts()), listEmptyList));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    private final void handleStoreState(StoreState storeState) {
        boolean z2;
        if (storeState instanceof StoreState.Loaded) {
            StoreState.Loaded loaded = (StoreState.Loaded) storeState;
            boolean zIsEmpty = loaded.getActiveThreads().isEmpty();
            ArchivedThreadsStore.ThreadListingState archivedThreadsState = loaded.getArchivedThreadsState();
            boolean z3 = false;
            if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized) {
                z2 = true;
            } else {
                if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
                    ArchivedThreadsStore.ThreadListingState.Listing listing = (ArchivedThreadsStore.ThreadListingState.Listing) archivedThreadsState;
                    if (listing.getThreads().isEmpty() && listing.isLoadingMore()) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Listing) {
                ArchivedThreadsStore.ThreadListingState.Listing listing2 = (ArchivedThreadsStore.ThreadListingState.Listing) archivedThreadsState;
                if (listing2.getThreads().isEmpty() && !listing2.isLoadingMore()) {
                    z3 = true;
                }
            }
            NsfwPanelState nsfwPanelState = new NsfwPanelState(!StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(loaded.getChannel().getGuildId()), loaded.getChannel().getNsfw(), loaded.getMeUser().getNsfwAllowance(), loaded.getChannel().getGuildId());
            if (!loaded.isThreadSyncedGuild()) {
                setupLoadingViewState(nsfwPanelState);
                return;
            }
            if (zIsEmpty && z2) {
                setupLoadingViewState(nsfwPanelState);
            } else if (zIsEmpty && z3) {
                setupEmptyViewState(loaded, nsfwPanelState);
            } else {
                setupListViewState(loaded, nsfwPanelState);
            }
        }
    }

    private final void setupEmptyViewState(StoreState.Loaded storeState, NsfwPanelState nsfwPanelState) {
        List listEmptyList = C12147n.emptyList();
        boolean canCreateForumChannelPosts = storeState.getCanCreateForumChannelPosts();
        String name = storeState.getChannel().getName();
        if (name == null) {
            name = "";
        }
        updateViewState(new ViewState.Loaded(nsfwPanelState, listEmptyList, canCreateForumChannelPosts, name, storeState.getChannel().getTopic(), storeState.getChannel().getId(), storeState.getChannel().getGuildId()));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0140  */
    private final void setupListViewState(StoreState.Loaded storeState, NsfwPanelState nsfwPanelState) {
        if (this.lastSelectedForumChannelId != storeState.getChannel().getId()) {
            this.lastSelectedForumChannelId = storeState.getChannel().getId();
            this.eventSubject.f27650k.onNext(Event.ScrollToTop.INSTANCE);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        C83511 c83511 = new C83511(linkedHashSet, storeState);
        Sequence sequenceAsSequence = C12138i0.asSequence(storeState.getActiveThreads());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : sequenceAsSequence) {
            if (ChannelUtils.m7666A((Channel) ((Map.Entry) obj).getValue())) {
                arrayList2.add(obj);
            } else {
                arrayList3.add(obj);
            }
        }
        Pair pair = new Pair(arrayList2, arrayList3);
        List list = (List) pair.component1();
        List list2 = (List) pair.component2();
        ArrayList arrayList4 = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ForumBrowserItem.PostItem postItemInvoke = c83511.invoke((Channel) ((Map.Entry) it.next()).getValue());
            if (postItemInvoke != null) {
                arrayList4.add(postItemInvoke);
            }
        }
        List listSortedWith = C12163u.sortedWith(arrayList4, ForumBrowserItem.INSTANCE.getPostItemComparatorByMostRecent());
        ArrayList arrayList5 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            ForumBrowserItem.PostItem postItemInvoke2 = c83511.invoke((Channel) ((Map.Entry) it2.next()).getValue());
            if (postItemInvoke2 != null) {
                arrayList5.add(postItemInvoke2);
            }
        }
        ForumBrowserItem.Companion companion = ForumBrowserItem.INSTANCE;
        List listSortedWith2 = C12163u.sortedWith(arrayList5, companion.getPostItemComparatorByMostRecent());
        arrayList.addAll(listSortedWith);
        arrayList.addAll(listSortedWith2);
        List<Channel> threads = storeState.getArchivedThreadsState() instanceof ArchivedThreadsStore.ThreadListingState.Listing ? ((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).getThreads() : C12147n.emptyList();
        boolean z2 = true;
        if (!threads.isEmpty()) {
            arrayList.add(new ForumBrowserItem.HeaderItem(C5419R.string.forum_section_archived));
            C12160r.addAll(arrayList, C12078q.sortedWith(C12078q.mapNotNull(C12163u.asSequence(threads), new C8352xfe97ca23(c83511)), companion.getPostItemComparatorByMostRecent()));
        }
        if ((storeState.getArchivedThreadsState() instanceof ArchivedThreadsStore.ThreadListingState.Listing) && ((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).isLoadingMore()) {
            arrayList.add(ForumBrowserItem.LoadingItem.INSTANCE);
        }
        ArchivedThreadsStore.ThreadListingState archivedThreadsState = storeState.getArchivedThreadsState();
        if (archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Error) {
            z2 = false;
        } else if (!(archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Uninitialized)) {
            if (!(archivedThreadsState instanceof ArchivedThreadsStore.ThreadListingState.Listing)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).getHasMore() || ((ArchivedThreadsStore.ThreadListingState.Listing) storeState.getArchivedThreadsState()).isLoadingMore()) {
                z2 = false;
            }
        }
        this.canFetchMoreOlderPosts = z2;
        this.guildMemberRequester.performQueuedRequests();
        boolean canCreateForumChannelPosts = storeState.getCanCreateForumChannelPosts();
        String name = storeState.getChannel().getName();
        if (name == null) {
            name = "";
        }
        updateViewState(new ViewState.Loaded(nsfwPanelState, arrayList, canCreateForumChannelPosts, name, storeState.getChannel().getTopic(), storeState.getChannel().getId(), storeState.getChannel().getGuildId()));
    }

    private final void setupLoadingViewState(NsfwPanelState nsfwPanelState) {
        updateViewState(new ViewState.Loading(nsfwPanelState));
    }

    @MainThread
    public final void enqueueForumPostFirstMessageFetch(long channelId, long guildId, long postId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            this.storeForumPostMessages.enqueueForumPostFirstMessageFetch(channelId, postId);
        }
    }

    @MainThread
    public final void maybeFetchForumPostFirstMessages(long channelId, long guildId, boolean isInitialFetch) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            if (isInitialFetch && this.initialChannelActivePostFirstMessageFetches.contains(Long.valueOf(channelId))) {
                return;
            }
            if (isInitialFetch) {
                this.initialChannelActivePostFirstMessageFetches.add(Long.valueOf(channelId));
            }
            this.storeForumPostMessages.flushForumPostFirstMessageQueue(channelId);
        }
    }

    @MainThread
    public final void maybeFetchOlderPosts(long channelId, long guildId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null) && this.canFetchMoreOlderPosts && !this.isFetchingMoreOlderPosts) {
            this.isFetchingMoreOlderPosts = true;
            ArchivedThreadsStore.fetchGuildForumThreadListing$default(this.storeArchivedThreads, channelId, false, new C83501(), 2, null);
        }
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void requestForumUnreads(long channelId, long guildId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            this.storeForumPostReadStates.requestForumUnreads(guildId, channelId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, ArchivedThreadsStore archivedThreadsStore, StoreThreadsActive storeThreadsActive, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreGuildMemberRequester storeGuildMemberRequester, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping, Observable<StoreState> observable) {
        super(null, 1, null);
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        C12238m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        C12238m.checkNotNullParameter(storeThreadMessages, "storeThreadsMessages");
        C12238m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        C12238m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        C12238m.checkNotNullParameter(storeGuildMemberRequester, "guildMemberRequester");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeTabsNavigation, "storeTabsNavigation");
        C12238m.checkNotNullParameter(storeExperiments, "storeExperiments");
        C12238m.checkNotNullParameter(storePermissions, "storePermissions");
        C12238m.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        C12238m.checkNotNullParameter(storeEmoji, "storeEmoji");
        C12238m.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        C12238m.checkNotNullParameter(storeUserTyping, "storeUserTyping");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.storeUser = storeUser;
        this.storeChannels = storeChannels;
        this.storeGuilds = storeGuilds;
        this.storeArchivedThreads = archivedThreadsStore;
        this.storeThreadsActive = storeThreadsActive;
        this.storeThreadsMessages = storeThreadMessages;
        this.storeForumPostMessages = storeForumPostMessages;
        this.storeUserRelationships = storeUserRelationships;
        this.guildMemberRequester = storeGuildMemberRequester;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeTabsNavigation = storeTabsNavigation;
        this.storeExperiments = storeExperiments;
        this.storePermissions = storePermissions;
        this.storeMessagesMostRecent = storeMessagesMostRecent;
        this.storeEmoji = storeEmoji;
        this.storeForumPostReadStates = storeForumPostReadStates;
        this.storeUserTyping = storeUserTyping;
        this.eventSubject = PublishSubject.m11133k0();
        this.initialChannelActivePostFirstMessageFetches = new LinkedHashSet();
        Observable observableM11112r = ObservableExtensionsKt.computationLatest(observable).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetForumBrowserViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C83471());
        ForumPostReadStateManager.initialize$default(ForumPostReadStateManager.INSTANCE, null, null, null, 7, null);
    }
}
