package com.discord.widgets.forums;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.ArchivedThreadsStore;
import com.discord.stores.ArchivedThreadsStore$ThreadListingState;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreForumPostMessages;
import com.discord.stores.StoreForumPostReadStates;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMessagesMostRecent;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreThreadMessages;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.stores.StoreUserTyping;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;

/* JADX INFO: compiled from: WidgetForumBrowserViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumBrowserViewModel$Companion$observeStoreState$1<T, R> implements b<WidgetForumBrowserViewModel$MinimalStoreState, Observable<? extends WidgetForumBrowserViewModel$StoreState>> {
    public final /* synthetic */ ArchivedThreadsStore $storeArchivedThreads;
    public final /* synthetic */ StoreChannels $storeChannels;
    public final /* synthetic */ StoreEmoji $storeEmoji;
    public final /* synthetic */ StoreForumPostMessages $storeForumPostMessages;
    public final /* synthetic */ StoreForumPostReadStates $storeForumPostReadStates;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreMessagesMostRecent $storeMessagesMostRecent;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreThreadsActive $storeThreadsActive;
    public final /* synthetic */ StoreThreadMessages $storeThreadsMessages;
    public final /* synthetic */ StoreUser $storeUser;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUserTyping $storeUserTyping;

    public WidgetForumBrowserViewModel$Companion$observeStoreState$1(StoreUser storeUser, ArchivedThreadsStore archivedThreadsStore, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreForumPostMessages storeForumPostMessages, StoreThreadMessages storeThreadMessages, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreMessagesMostRecent storeMessagesMostRecent, StoreEmoji storeEmoji, StoreForumPostReadStates storeForumPostReadStates, StoreThreadsActive storeThreadsActive, StoreUserTyping storeUserTyping) {
        this.$storeUser = storeUser;
        this.$storeArchivedThreads = archivedThreadsStore;
        this.$storeChannels = storeChannels;
        this.$storeGuilds = storeGuilds;
        this.$storeForumPostMessages = storeForumPostMessages;
        this.$storeThreadsMessages = storeThreadMessages;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storePermissions = storePermissions;
        this.$storeMessagesMostRecent = storeMessagesMostRecent;
        this.$storeEmoji = storeEmoji;
        this.$storeForumPostReadStates = storeForumPostReadStates;
        this.$storeThreadsActive = storeThreadsActive;
        this.$storeUserTyping = storeUserTyping;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends WidgetForumBrowserViewModel$StoreState> call(WidgetForumBrowserViewModel$MinimalStoreState widgetForumBrowserViewModel$MinimalStoreState) {
        return call2(widgetForumBrowserViewModel$MinimalStoreState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends WidgetForumBrowserViewModel$StoreState> call2(WidgetForumBrowserViewModel$MinimalStoreState widgetForumBrowserViewModel$MinimalStoreState) {
        if (!(widgetForumBrowserViewModel$MinimalStoreState instanceof WidgetForumBrowserViewModel$MinimalStoreState$Valid)) {
            return new k(WidgetForumBrowserViewModel$StoreState$Invalid.INSTANCE);
        }
        WidgetForumBrowserViewModel$MinimalStoreState$Valid widgetForumBrowserViewModel$MinimalStoreState$Valid = (WidgetForumBrowserViewModel$MinimalStoreState$Valid) widgetForumBrowserViewModel$MinimalStoreState;
        Channel channel = widgetForumBrowserViewModel$MinimalStoreState$Valid.getChannel();
        Map<Long, Channel> activeThreads = widgetForumBrowserViewModel$MinimalStoreState$Valid.getActiveThreads();
        Observable observableObserveMe$default = StoreUser.observeMe$default(this.$storeUser, false, 1, null);
        Observable<Map<Long, User>> observableObserveAllUsers = this.$storeUser.observeAllUsers();
        Observable<ArchivedThreadsStore$ThreadListingState> observableMaybeLoadAndObserveThreadListing = ForumUtils.INSTANCE.maybeLoadAndObserveThreadListing(channel.getId(), true ^ activeThreads.isEmpty(), this.$storeArchivedThreads);
        Observable<Map<Long, String>> observableObserveNames = this.$storeChannels.observeNames();
        Observable<Map<Long, GuildMember>> observableObserveGuildMembers = this.$storeGuilds.observeGuildMembers(channel.getGuildId());
        m.checkNotNullExpressionValue(observableObserveGuildMembers, "storeGuilds\n            …rs(parentChannel.guildId)");
        Observable<T> observableR = ObservableExtensionsKt.leadingEdgeThrottle(observableObserveGuildMembers, 1L, TimeUnit.SECONDS).r();
        m.checkNotNullExpressionValue(observableR, "storeGuilds\n            …  .distinctUntilChanged()");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe$default, observableObserveAllUsers, observableMaybeLoadAndObserveThreadListing, observableObserveNames, observableR, this.$storeGuilds.observeRoles(channel.getGuildId()), this.$storeForumPostMessages.observeForumPostFirstMessages(), this.$storeThreadsMessages.observeThreadCountAndLatestMessage(), this.$storeUserRelationships.observeForType(2), this.$storePermissions.observePermissionsForChannel(channel.getId()), this.$storeMessagesMostRecent.observeRecentMessageIds(), StoreEmoji.getEmojiSet$default(this.$storeEmoji, channel.getGuildId(), channel.getId(), false, false, 12, null), ForumPostReadStateManager.observeForumPostReadStates$default(ForumPostReadStateManager.INSTANCE, channel.getGuildId(), channel.getId(), null, null, null, 28, null), this.$storeForumPostReadStates.observeThreadUnreadCounts(), this.$storeForumPostReadStates.observeThreadIdsWithPersistedReadStates(), this.$storeThreadsActive.observeIsThreadSyncedGuild(channel.getGuildId()), this.$storeUserTyping.observeTypingUsersForChannels(activeThreads.keySet()), new WidgetForumBrowserViewModel$Companion$observeStoreState$1$1(activeThreads, channel));
    }
}
