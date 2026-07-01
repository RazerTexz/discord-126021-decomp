package com.discord.widgets.chat.input;

import com.discord.api.guild.GuildVerificationLevel;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreChat;
import com.discord.stores.StoreGuildJoinRequest;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreLurking;
import com.discord.stores.StorePendingReplies;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreSlowMode;
import com.discord.stores.StoreSlowMode$Type$MessageSend;
import com.discord.stores.StoreThreadDraft;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserRelationships;
import com.discord.utilities.guilds.GuildVerificationLevelUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$Companion {
    private ChatInputViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$getIsOnCooldownObservable(ChatInputViewModel$Companion chatInputViewModel$Companion, long j, StoreSlowMode storeSlowMode) {
        return chatInputViewModel$Companion.getIsOnCooldownObservable(j, storeSlowMode);
    }

    public static final /* synthetic */ Observable access$getPendingReplyStateObservable(ChatInputViewModel$Companion chatInputViewModel$Companion, long j, StorePendingReplies storePendingReplies) {
        return chatInputViewModel$Companion.getPendingReplyStateObservable(j, storePendingReplies);
    }

    public static final /* synthetic */ Observable access$getVerificationLevelTriggeredObservable(ChatInputViewModel$Companion chatInputViewModel$Companion, long j, StoreGuilds storeGuilds, StoreUser storeUser) {
        return chatInputViewModel$Companion.getVerificationLevelTriggeredObservable(j, storeGuilds, storeUser);
    }

    public static final /* synthetic */ Observable access$observeStoreState(ChatInputViewModel$Companion chatInputViewModel$Companion, StoreChannelsSelected storeChannelsSelected, StoreUser storeUser, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
        return chatInputViewModel$Companion.observeStoreState(storeChannelsSelected, storeUser, storeChat, storeUserRelationships, storePermissions, storeLurking, storeSlowMode, storeGuilds, storePendingReplies, storeGuildJoinRequest, storeThreadDraft);
    }

    private final Observable<Boolean> getIsOnCooldownObservable(long channelId, StoreSlowMode storeSlowMode) {
        return storeSlowMode.observeCooldownSecs(Long.valueOf(channelId), StoreSlowMode$Type$MessageSend.INSTANCE).G(ChatInputViewModel$Companion$getIsOnCooldownObservable$1.INSTANCE).r();
    }

    private final Observable<ChatInputViewModel$StoreState$Loaded$PendingReply> getPendingReplyStateObservable(long channelId, StorePendingReplies storePendingReplies) {
        Observable<ChatInputViewModel$StoreState$Loaded$PendingReply> observableR = storePendingReplies.observePendingReply(channelId).Y(ChatInputViewModel$Companion$getPendingReplyStateObservable$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "storePendingReplies\n    …  .distinctUntilChanged()");
        return observableR;
    }

    private final Observable<GuildVerificationLevel> getVerificationLevelTriggeredObservable(long guildId, StoreGuilds storeGuilds, StoreUser storeUsers) {
        return GuildVerificationLevelUtils.observeVerificationLevelTriggered$default(GuildVerificationLevelUtils.INSTANCE, guildId, storeGuilds, storeUsers, null, 8, null);
    }

    private final Observable<ChatInputViewModel$StoreState> observeStoreState(StoreChannelsSelected storeChannelsSelected, StoreUser storeUsers, StoreChat storeChat, StoreUserRelationships storeUserRelationships, StorePermissions storePermissions, StoreLurking storeLurking, StoreSlowMode storeSlowMode, StoreGuilds storeGuilds, StorePendingReplies storePendingReplies, StoreGuildJoinRequest storeGuildJoinRequest, StoreThreadDraft storeThreadDraft) {
        Observable observableY = storeChannelsSelected.observeResolvedSelectedChannel().Y(new ChatInputViewModel$Companion$observeStoreState$1(storeUsers, storeChat, storeUserRelationships, storePermissions, storeGuilds, storeLurking, storeSlowMode, storePendingReplies, storeGuildJoinRequest, storeThreadDraft));
        m.checkNotNullExpressionValue(observableY, "storeChannelsSelected.ob…      }\n        }\n      }");
        return observableY;
    }

    public /* synthetic */ ChatInputViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
