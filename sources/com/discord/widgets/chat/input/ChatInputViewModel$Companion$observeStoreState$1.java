package com.discord.widgets.chat.input;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected$ResolvedSelectedChannel;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuildJoinRequest;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.forums.ForumPostCreateManager;
import d0.z.d.m;
import j0.k.b;
import j0.l.e.k;
import rx.Observable;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$Companion$observeStoreState$1<T, R> implements b<StoreChannelsSelected$ResolvedSelectedChannel, Observable<? extends ChatInputViewModel$StoreState>> {
    public final /* synthetic */ StoreChat $storeChat;
    public final /* synthetic */ StoreGuildJoinRequest $storeGuildJoinRequest;
    public final /* synthetic */ StoreGuilds $storeGuilds;
    public final /* synthetic */ StoreLurking $storeLurking;
    public final /* synthetic */ StorePendingReplies $storePendingReplies;
    public final /* synthetic */ StorePermissions $storePermissions;
    public final /* synthetic */ StoreSlowMode $storeSlowMode;
    public final /* synthetic */ StoreThreadDraft $storeThreadDraft;
    public final /* synthetic */ StoreUserRelationships $storeUserRelationships;
    public final /* synthetic */ StoreUser $storeUsers;

    public ChatInputViewModel$Companion$observeStoreState$1(StoreUser storeUser, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreGuilds storeGuilds, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
        this.$storeUsers = storeUser;
        this.$storeChat = storeChat;
        this.$storeUserRelationships = storeUserRelationships;
        this.$storePermissions = storePermissions;
        this.$storeGuilds = storeGuilds;
        this.$storeLurking = storeLurking;
        this.$storeSlowMode = storeSlowMode;
        this.$storePendingReplies = storePendingReplies;
        this.$storeGuildJoinRequest = storeGuildJoinRequest;
        this.$storeThreadDraft = storeThreadDraft;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends ChatInputViewModel$StoreState> call(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        return call2(storeChannelsSelected$ResolvedSelectedChannel);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends ChatInputViewModel$StoreState> call2(StoreChannelsSelected$ResolvedSelectedChannel storeChannelsSelected$ResolvedSelectedChannel) {
        Channel channelOrParent = storeChannelsSelected$ResolvedSelectedChannel.getChannelOrParent();
        if (channelOrParent == null) {
            return new k(ChatInputViewModel$StoreState$Loading.INSTANCE);
        }
        Observable<MeUser> observableObserveMe = this.$storeUsers.observeMe(true);
        Observable observableComputationBuffered = ObservableExtensionsKt.computationBuffered(this.$storeChat.observeEditingMessage());
        StoreUserRelationships storeUserRelationships = this.$storeUserRelationships;
        User userA = ChannelUtils.a(channelOrParent);
        Observable<Integer> observableObserve = storeUserRelationships.observe(userA != null ? userA.getId() : 0L);
        Observable<Long> observableObservePermissionsForChannel = this.$storePermissions.observePermissionsForChannel(channelOrParent.getId());
        ChatInputViewModel$Companion chatInputViewModel$Companion = ChatInputViewModel.Companion;
        Observable observableAccess$getVerificationLevelTriggeredObservable = ChatInputViewModel$Companion.access$getVerificationLevelTriggeredObservable(chatInputViewModel$Companion, channelOrParent.getGuildId(), this.$storeGuilds, this.$storeUsers);
        Observable<Boolean> observableIsLurkingObs = this.$storeLurking.isLurkingObs(channelOrParent.getGuildId());
        Observable observableAccess$getIsOnCooldownObservable = ChatInputViewModel$Companion.access$getIsOnCooldownObservable(chatInputViewModel$Companion, channelOrParent.getId(), this.$storeSlowMode);
        m.checkNotNullExpressionValue(observableAccess$getIsOnCooldownObservable, "getIsOnCooldownObservabl…hannel.id, storeSlowMode)");
        return ObservableCombineLatestOverloadsKt.combineLatest(observableObserveMe, observableComputationBuffered, observableObserve, observableObservePermissionsForChannel, observableAccess$getVerificationLevelTriggeredObservable, observableIsLurkingObs, observableAccess$getIsOnCooldownObservable, this.$storeGuilds.observeFromChannelId(channelOrParent.getId()), ChatInputViewModel$Companion.access$getPendingReplyStateObservable(chatInputViewModel$Companion, channelOrParent.getId(), this.$storePendingReplies), this.$storeGuilds.observeComputedMember(channelOrParent.getGuildId(), this.$storeUsers.getMeSnapshot().getId()), this.$storeGuildJoinRequest.observeGuildJoinRequest(channelOrParent.getGuildId()), this.$storeThreadDraft.observeDraftState(), ForumPostCreateManager.INSTANCE.observeIsForumPostCreateInProgress(channelOrParent.getGuildId()), new ChatInputViewModel$Companion$observeStoreState$1$1(channelOrParent, storeChannelsSelected$ResolvedSelectedChannel));
    }
}
