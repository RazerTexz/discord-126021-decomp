package com.discord.widgets.forums;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.channel.ForumTag;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.api.user.User;
import com.discord.models.domain.emoji.Emoji;
import com.discord.models.domain.emoji.ModelEmojiCustom;
import com.discord.models.guild.UserGuildMember;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Error;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Listing;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState$Uninitialized;
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
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserTyping;
import com.discord.utilities.SnowflakeUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.d0.f;
import d0.f0.q;
import d0.t.g0;
import d0.t.i0;
import d0.t.n;
import d0.t.o;
import d0.t.r;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map$Entry;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.sequences.Sequence;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel extends d0<WidgetForumBrowserViewModel$ViewState> {
    public static final WidgetForumBrowserViewModel$Companion Companion = new WidgetForumBrowserViewModel$Companion(null);
    private static final int MAX_TYPING_USERS = 3;
    private boolean canFetchMoreOlderPosts;
    private final PublishSubject<WidgetForumBrowserViewModel$Event> eventSubject;
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

    public WidgetForumBrowserViewModel() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 262143, null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetForumBrowserViewModel(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, ArchivedThreadsStore archivedThreadsStore, StoreThreadsActive storeThreadsActive, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreGuildMemberRequester storeGuildMemberRequester, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreUser users = (i & 1) != 0 ? StoreStream.Companion.getUsers() : storeUser;
        StoreChannels channels = (i & 2) != 0 ? StoreStream.Companion.getChannels() : storeChannels;
        StoreGuilds guilds = (i & 4) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        ArchivedThreadsStore archivedThreads = (i & 8) != 0 ? StoreStream.Companion.getArchivedThreads() : archivedThreadsStore;
        StoreThreadsActive threadsActive = (i & 16) != 0 ? StoreStream.Companion.getThreadsActive() : storeThreadsActive;
        StoreThreadMessages threadMessages = (i & 32) != 0 ? StoreStream.Companion.getThreadMessages() : storeThreadMessages;
        StoreForumPostMessages forumPostMessages = (i & 64) != 0 ? StoreStream.Companion.getForumPostMessages() : storeForumPostMessages;
        StoreUserRelationships userRelationships = (i & 128) != 0 ? StoreStream.Companion.getUserRelationships() : storeUserRelationships;
        StoreGuildMemberRequester guildMemberRequester = (i & 256) != 0 ? StoreStream.Companion.getGuildMemberRequester() : storeGuildMemberRequester;
        StoreChannelsSelected channelsSelected = (i & 512) != 0 ? StoreStream.Companion.getChannelsSelected() : storeChannelsSelected;
        StoreTabsNavigation tabsNavigation = (i & 1024) != 0 ? StoreStream.Companion.getTabsNavigation() : storeTabsNavigation;
        StoreExperiments experiments = (i & 2048) != 0 ? StoreStream.Companion.getExperiments() : storeExperiments;
        StorePermissions permissions = (i & 4096) != 0 ? StoreStream.Companion.getPermissions() : storePermissions;
        StoreMessagesMostRecent messagesMostRecent = (i & 8192) != 0 ? StoreStream.Companion.getMessagesMostRecent() : storeMessagesMostRecent;
        StoreEmoji emojis = (i & 16384) != 0 ? StoreStream.Companion.getEmojis() : storeEmoji;
        StoreForumPostReadStates forumPostReadStates = (i & 32768) != 0 ? StoreStream.Companion.getForumPostReadStates() : storeForumPostReadStates;
        StoreUserTyping usersTyping = (i & 65536) != 0 ? StoreStream.Companion.getUsersTyping() : storeUserTyping;
        this(users, channels, guilds, archivedThreads, threadsActive, threadMessages, forumPostMessages, userRelationships, guildMemberRequester, channelsSelected, tabsNavigation, experiments, permissions, messagesMostRecent, emojis, forumPostReadStates, usersTyping, (i & 131072) != 0 ? WidgetForumBrowserViewModel$Companion.access$observeStoreState(Companion, users, channels, guilds, threadsActive, archivedThreads, threadMessages, forumPostMessages, userRelationships, channelsSelected, tabsNavigation, experiments, permissions, messagesMostRecent, emojis, forumPostReadStates, usersTyping) : observable);
    }

    public static final /* synthetic */ ForumBrowserItem$PostItem access$createPostItem(WidgetForumBrowserViewModel widgetForumBrowserViewModel, WidgetForumBrowserViewModel$StoreState$Loaded widgetForumBrowserViewModel$StoreState$Loaded, Channel channel) {
        return widgetForumBrowserViewModel.createPostItem(widgetForumBrowserViewModel$StoreState$Loaded, channel);
    }

    public static final /* synthetic */ StoreGuildMemberRequester access$getGuildMemberRequester$p(WidgetForumBrowserViewModel widgetForumBrowserViewModel) {
        return widgetForumBrowserViewModel.guildMemberRequester;
    }

    public static final /* synthetic */ void access$handleStoreState(WidgetForumBrowserViewModel widgetForumBrowserViewModel, WidgetForumBrowserViewModel$StoreState widgetForumBrowserViewModel$StoreState) {
        widgetForumBrowserViewModel.handleStoreState(widgetForumBrowserViewModel$StoreState);
    }

    public static final /* synthetic */ boolean access$isFetchingMoreOlderPosts$p(WidgetForumBrowserViewModel widgetForumBrowserViewModel) {
        return widgetForumBrowserViewModel.isFetchingMoreOlderPosts;
    }

    public static final /* synthetic */ void access$setFetchingMoreOlderPosts$p(WidgetForumBrowserViewModel widgetForumBrowserViewModel, boolean z2) {
        widgetForumBrowserViewModel.isFetchingMoreOlderPosts = z2;
    }

    /* JADX WARN: Code duplicated, block: B:49:0x0122  */
    /* JADX WARN: Code duplicated, block: B:78:0x01af  */
    private final ForumBrowserItem$PostItem createPostItem(WidgetForumBrowserViewModel$StoreState$Loaded storeState, Channel channel) {
        LinkedHashMap linkedHashMap;
        PostTagData postTagData;
        List listEmptyList;
        GuildMember guildMember;
        PostTagData postTagDataFromTag;
        ForumTag forumTag;
        boolean z2;
        User author;
        com.discord.models.user.User user = storeState.getUsers().get(Long.valueOf(channel.getOwnerId()));
        Message message = (Message) a.d(channel, storeState.getForumPostFirstMessages());
        Long lValueOf = (message == null || (author = message.getAuthor()) == null) ? null : Long.valueOf(author.getId());
        boolean z3 = lValueOf != null && storeState.getMyBlockedUserIds().contains(lValueOf);
        StoreThreadMessages$ThreadState storeThreadMessages$ThreadState = (StoreThreadMessages$ThreadState) a.d(channel, storeState.getForumPostMessageCounts());
        Integer numValueOf = storeThreadMessages$ThreadState != null ? Integer.valueOf(storeThreadMessages$ThreadState.getCount()) : null;
        Long l = (Long) a.d(channel, storeState.getMostRecentMessageIds());
        Long lValueOf2 = l != null ? Long.valueOf((l.longValue() >>> 22) + SnowflakeUtils.DISCORD_EPOCH) : null;
        ForumPostReadState forumPostReadStateCreateDefault = (ForumPostReadState) a.d(channel, storeState.getForumPostReadStates());
        if (forumPostReadStateCreateDefault == null) {
            forumPostReadStateCreateDefault = ForumPostReadState.Companion.createDefault(channel.getId());
        }
        ForumPostReadState forumPostReadState = forumPostReadStateCreateDefault;
        List<ForumTag> listD = storeState.getChannel().d();
        if (listD != null) {
            linkedHashMap = new LinkedHashMap(f.coerceAtLeast(g0.mapCapacity(o.collectionSizeOrDefault(listD, 10)), 16));
            for (Object obj : listD) {
                linkedHashMap.put(Long.valueOf(((ForumTag) obj).getId()), obj);
            }
        } else {
            linkedHashMap = null;
        }
        List<Long> listC = channel.c();
        if (listC != null) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listC.iterator();
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
                    postTagDataFromTag = PostTagData.Companion.fromTag(forumTag, z2);
                }
                if (postTagDataFromTag != null) {
                    arrayList.add(postTagDataFromTag);
                }
            }
            postTagData = (PostTagData) u.firstOrNull((List) arrayList);
        } else {
            postTagData = null;
        }
        MessageReaction messageReactionMostCommonReaction = message != null ? ForumUtils.INSTANCE.mostCommonReaction(message, this.storeEmoji) : null;
        boolean zIsDefaultPostReaction = messageReactionMostCommonReaction != null ? ForumUtils.INSTANCE.isDefaultPostReaction(messageReactionMostCommonReaction, this.storeEmoji) : false;
        Set set = (Set) a.d(channel, storeState.getTypingUsers());
        if (set != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it2 = set.iterator();
            while (it2.hasNext()) {
                long jLongValue2 = ((Number) it2.next()).longValue();
                com.discord.models.user.User user2 = storeState.getUsers().get(Long.valueOf(jLongValue2));
                UserGuildMember userGuildMember = (user2 == null || (guildMember = storeState.getGuildMembers().get(Long.valueOf(jLongValue2))) == null) ? null : new UserGuildMember(user2, guildMember);
                if (userGuildMember != null) {
                    arrayList2.add(userGuildMember);
                }
            }
            listEmptyList = u.take(arrayList2, 3);
            if (listEmptyList == null) {
                listEmptyList = n.emptyList();
            }
        } else {
            listEmptyList = n.emptyList();
        }
        return new ForumBrowserItem$PostItem(new PostData(channel, user, storeState.getMeUser().getId(), storeState.getGuildMembers(), storeState.getGuildRoles(), storeState.getChannelNames(), message, z3, lValueOf2, numValueOf, postTagData, messageReactionMostCommonReaction, zIsDefaultPostReaction, forumPostReadState, (Integer) a.d(channel, storeState.getForumPostUnreadCounts()), listEmptyList));
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0033  */
    private final void handleStoreState(WidgetForumBrowserViewModel$StoreState storeState) {
        boolean z2;
        if (storeState instanceof WidgetForumBrowserViewModel$StoreState$Loaded) {
            WidgetForumBrowserViewModel$StoreState$Loaded widgetForumBrowserViewModel$StoreState$Loaded = (WidgetForumBrowserViewModel$StoreState$Loaded) storeState;
            boolean zIsEmpty = widgetForumBrowserViewModel$StoreState$Loaded.getActiveThreads().isEmpty();
            ArchivedThreadsStore$ThreadListingState archivedThreadsState = widgetForumBrowserViewModel$StoreState$Loaded.getArchivedThreadsState();
            boolean z3 = false;
            if (archivedThreadsState instanceof ArchivedThreadsStore$ThreadListingState$Uninitialized) {
                z2 = true;
            } else {
                if (archivedThreadsState instanceof ArchivedThreadsStore$ThreadListingState$Listing) {
                    ArchivedThreadsStore$ThreadListingState$Listing archivedThreadsStore$ThreadListingState$Listing = (ArchivedThreadsStore$ThreadListingState$Listing) archivedThreadsState;
                    if (archivedThreadsStore$ThreadListingState$Listing.getThreads().isEmpty() && archivedThreadsStore$ThreadListingState$Listing.isLoadingMore()) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (archivedThreadsState instanceof ArchivedThreadsStore$ThreadListingState$Listing) {
                ArchivedThreadsStore$ThreadListingState$Listing archivedThreadsStore$ThreadListingState$Listing2 = (ArchivedThreadsStore$ThreadListingState$Listing) archivedThreadsState;
                if (archivedThreadsStore$ThreadListingState$Listing2.getThreads().isEmpty() && !archivedThreadsStore$ThreadListingState$Listing2.isLoadingMore()) {
                    z3 = true;
                }
            }
            WidgetForumBrowserViewModel$NsfwPanelState widgetForumBrowserViewModel$NsfwPanelState = new WidgetForumBrowserViewModel$NsfwPanelState(!StoreStream.Companion.getGuildsNsfw().isGuildNsfwGateAgreed(widgetForumBrowserViewModel$StoreState$Loaded.getChannel().getGuildId()), widgetForumBrowserViewModel$StoreState$Loaded.getChannel().getNsfw(), widgetForumBrowserViewModel$StoreState$Loaded.getMeUser().getNsfwAllowance(), widgetForumBrowserViewModel$StoreState$Loaded.getChannel().getGuildId());
            if (!widgetForumBrowserViewModel$StoreState$Loaded.isThreadSyncedGuild()) {
                setupLoadingViewState(widgetForumBrowserViewModel$NsfwPanelState);
                return;
            }
            if (zIsEmpty && z2) {
                setupLoadingViewState(widgetForumBrowserViewModel$NsfwPanelState);
            } else if (zIsEmpty && z3) {
                setupEmptyViewState(widgetForumBrowserViewModel$StoreState$Loaded, widgetForumBrowserViewModel$NsfwPanelState);
            } else {
                setupListViewState(widgetForumBrowserViewModel$StoreState$Loaded, widgetForumBrowserViewModel$NsfwPanelState);
            }
        }
    }

    public static /* synthetic */ void maybeFetchForumPostFirstMessages$default(WidgetForumBrowserViewModel widgetForumBrowserViewModel, long j, long j2, boolean z2, int i, Object obj) {
        widgetForumBrowserViewModel.maybeFetchForumPostFirstMessages(j, j2, (i & 4) != 0 ? false : z2);
    }

    private final void setupEmptyViewState(WidgetForumBrowserViewModel$StoreState$Loaded storeState, WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState) {
        List listEmptyList = n.emptyList();
        boolean canCreateForumChannelPosts = storeState.getCanCreateForumChannelPosts();
        String name = storeState.getChannel().getName();
        if (name == null) {
            name = "";
        }
        updateViewState(new WidgetForumBrowserViewModel$ViewState$Loaded(nsfwPanelState, listEmptyList, canCreateForumChannelPosts, name, storeState.getChannel().getTopic(), storeState.getChannel().getId(), storeState.getChannel().getGuildId()));
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0140  */
    private final void setupListViewState(WidgetForumBrowserViewModel$StoreState$Loaded storeState, WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState) {
        if (this.lastSelectedForumChannelId != storeState.getChannel().getId()) {
            this.lastSelectedForumChannelId = storeState.getChannel().getId();
            this.eventSubject.k.onNext(WidgetForumBrowserViewModel$Event$ScrollToTop.INSTANCE);
        }
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ArrayList arrayList = new ArrayList();
        WidgetForumBrowserViewModel$setupListViewState$1 widgetForumBrowserViewModel$setupListViewState$1 = new WidgetForumBrowserViewModel$setupListViewState$1(this, linkedHashSet, storeState);
        Sequence sequenceAsSequence = i0.asSequence(storeState.getActiveThreads());
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : sequenceAsSequence) {
            if (ChannelUtils.A((Channel) ((Map$Entry) obj).getValue())) {
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
            ForumBrowserItem$PostItem forumBrowserItem$PostItemInvoke2 = widgetForumBrowserViewModel$setupListViewState$1.invoke2((Channel) ((Map$Entry) it.next()).getValue());
            if (forumBrowserItem$PostItemInvoke2 != null) {
                arrayList4.add(forumBrowserItem$PostItemInvoke2);
            }
        }
        List listSortedWith = u.sortedWith(arrayList4, ForumBrowserItem.Companion.getPostItemComparatorByMostRecent());
        ArrayList arrayList5 = new ArrayList();
        Iterator it2 = list2.iterator();
        while (it2.hasNext()) {
            ForumBrowserItem$PostItem forumBrowserItem$PostItemInvoke3 = widgetForumBrowserViewModel$setupListViewState$1.invoke2((Channel) ((Map$Entry) it2.next()).getValue());
            if (forumBrowserItem$PostItemInvoke3 != null) {
                arrayList5.add(forumBrowserItem$PostItemInvoke3);
            }
        }
        ForumBrowserItem$Companion forumBrowserItem$Companion = ForumBrowserItem.Companion;
        List listSortedWith2 = u.sortedWith(arrayList5, forumBrowserItem$Companion.getPostItemComparatorByMostRecent());
        arrayList.addAll(listSortedWith);
        arrayList.addAll(listSortedWith2);
        List<Channel> threads = storeState.getArchivedThreadsState() instanceof ArchivedThreadsStore$ThreadListingState$Listing ? ((ArchivedThreadsStore$ThreadListingState$Listing) storeState.getArchivedThreadsState()).getThreads() : n.emptyList();
        boolean z2 = true;
        if (!threads.isEmpty()) {
            arrayList.add(new ForumBrowserItem$HeaderItem(2131889411));
            r.addAll(arrayList, q.sortedWith(q.mapNotNull(u.asSequence(threads), new WidgetForumBrowserViewModel$setupListViewState$archivedPostItems$1(widgetForumBrowserViewModel$setupListViewState$1)), forumBrowserItem$Companion.getPostItemComparatorByMostRecent()));
        }
        if ((storeState.getArchivedThreadsState() instanceof ArchivedThreadsStore$ThreadListingState$Listing) && ((ArchivedThreadsStore$ThreadListingState$Listing) storeState.getArchivedThreadsState()).isLoadingMore()) {
            arrayList.add(ForumBrowserItem$LoadingItem.INSTANCE);
        }
        ArchivedThreadsStore$ThreadListingState archivedThreadsState = storeState.getArchivedThreadsState();
        if (archivedThreadsState instanceof ArchivedThreadsStore$ThreadListingState$Error) {
            z2 = false;
        } else if (!(archivedThreadsState instanceof ArchivedThreadsStore$ThreadListingState$Uninitialized)) {
            if (!(archivedThreadsState instanceof ArchivedThreadsStore$ThreadListingState$Listing)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!((ArchivedThreadsStore$ThreadListingState$Listing) storeState.getArchivedThreadsState()).getHasMore() || ((ArchivedThreadsStore$ThreadListingState$Listing) storeState.getArchivedThreadsState()).isLoadingMore()) {
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
        updateViewState(new WidgetForumBrowserViewModel$ViewState$Loaded(nsfwPanelState, arrayList, canCreateForumChannelPosts, name, storeState.getChannel().getTopic(), storeState.getChannel().getId(), storeState.getChannel().getGuildId()));
    }

    private final void setupLoadingViewState(WidgetForumBrowserViewModel$NsfwPanelState nsfwPanelState) {
        updateViewState(new WidgetForumBrowserViewModel$ViewState$Loading(nsfwPanelState));
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
            ArchivedThreadsStore.fetchGuildForumThreadListing$default(this.storeArchivedThreads, channelId, false, new WidgetForumBrowserViewModel$maybeFetchOlderPosts$1(this), 2, null);
        }
    }

    public final Observable<WidgetForumBrowserViewModel$Event> observeEvents() {
        PublishSubject<WidgetForumBrowserViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    @MainThread
    public final void requestForumUnreads(long channelId, long guildId) {
        if (ForumUtils.canAccessRedesignedForumChannels$default(ForumUtils.INSTANCE, guildId, null, 2, null)) {
            this.storeForumPostReadStates.requestForumUnreads(guildId, channelId);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumBrowserViewModel(StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, ArchivedThreadsStore archivedThreadsStore, StoreThreadsActive storeThreadsActive, StoreThreadMessages storeThreadMessages, StoreForumPostMessages storeForumPostMessages, StoreUserRelationships storeUserRelationships, StoreGuildMemberRequester storeGuildMemberRequester, StoreChannelsSelected storeChannelsSelected, StoreTabsNavigation storeTabsNavigation, StoreExperiments storeExperiments, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreUserTyping storeUserTyping, Observable<WidgetForumBrowserViewModel$StoreState> observable) {
        super(null, 1, null);
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(storeChannels, "storeChannels");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(archivedThreadsStore, "storeArchivedThreads");
        m.checkNotNullParameter(storeThreadsActive, "storeThreadsActive");
        m.checkNotNullParameter(storeThreadMessages, "storeThreadsMessages");
        m.checkNotNullParameter(storeForumPostMessages, "storeForumPostMessages");
        m.checkNotNullParameter(storeUserRelationships, "storeUserRelationships");
        m.checkNotNullParameter(storeGuildMemberRequester, "guildMemberRequester");
        m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        m.checkNotNullParameter(storeTabsNavigation, "storeTabsNavigation");
        m.checkNotNullParameter(storeExperiments, "storeExperiments");
        m.checkNotNullParameter(storePermissions, "storePermissions");
        m.checkNotNullParameter(storeMessagesMostRecent, "storeMessagesMostRecent");
        m.checkNotNullParameter(storeEmoji, "storeEmoji");
        m.checkNotNullParameter(storeForumPostReadStates, "storeForumPostReadStates");
        m.checkNotNullParameter(storeUserTyping, "storeUserTyping");
        m.checkNotNullParameter(observable, "storeStateObservable");
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
        this.eventSubject = PublishSubject.k0();
        this.initialChannelActivePostFirstMessageFetches = new LinkedHashSet();
        Observable observableR = ObservableExtensionsKt.computationLatest(observable).r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetForumBrowserViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetForumBrowserViewModel$1(this), 62, (Object) null);
        ForumPostReadStateManager.initialize$default(ForumPostReadStateManager.INSTANCE, null, null, null, 7, null);
    }
}
