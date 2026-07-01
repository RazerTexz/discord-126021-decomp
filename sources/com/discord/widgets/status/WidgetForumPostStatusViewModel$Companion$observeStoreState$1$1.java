package com.discord.widgets.status;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.message.reaction.MessageReaction;
import com.discord.models.message.Message;
import com.discord.stores.StoreThreadMessages$ThreadState;
import com.discord.stores.StoreThreadsJoined$JoinedThread;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.widgets.forums.ForumUtils;
import d0.z.d.m;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetForumPostStatusViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumPostStatusViewModel$Companion$observeStoreState$1$1<T1, T2, T3, T4, T5, R> implements Func5<Long, StoreThreadsJoined$JoinedThread, Message, StoreThreadMessages$ThreadState, Long, WidgetForumPostStatusViewModel$StoreState$Loaded> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ WidgetForumPostStatusViewModel$Companion$observeStoreState$1 this$0;

    public WidgetForumPostStatusViewModel$Companion$observeStoreState$1$1(WidgetForumPostStatusViewModel$Companion$observeStoreState$1 widgetForumPostStatusViewModel$Companion$observeStoreState$1, Channel channel) {
        this.this$0 = widgetForumPostStatusViewModel$Companion$observeStoreState$1;
        this.$channel = channel;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetForumPostStatusViewModel$StoreState$Loaded call(Long l, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, Message message, StoreThreadMessages$ThreadState storeThreadMessages$ThreadState, Long l2) {
        return call2(l, storeThreadsJoined$JoinedThread, message, storeThreadMessages$ThreadState, l2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetForumPostStatusViewModel$StoreState$Loaded call2(Long l, StoreThreadsJoined$JoinedThread storeThreadsJoined$JoinedThread, Message message, StoreThreadMessages$ThreadState storeThreadMessages$ThreadState, Long l2) {
        boolean zCan = PermissionUtils.can(64L, l2);
        ForumUtils forumUtils = ForumUtils.INSTANCE;
        MessageReaction placeholderMessageReaction = forumUtils.getPlaceholderMessageReaction(this.this$0.$storeEmoji);
        MessageReaction messageReactionMostCommonReaction = message != null ? forumUtils.mostCommonReaction(message, this.this$0.$storeEmoji) : null;
        boolean z2 = messageReactionMostCommonReaction != null && forumUtils.isDefaultPostReaction(messageReactionMostCommonReaction, this.this$0.$storeEmoji);
        m.checkNotNullExpressionValue(l, "myUserId");
        long jLongValue = l.longValue();
        long id2 = this.$channel.getId();
        long guildId = this.$channel.getGuildId();
        boolean zJ = ChannelUtils.j(this.$channel);
        boolean z3 = storeThreadsJoined$JoinedThread != null;
        Long lValueOf = message != null ? Long.valueOf(message.getId()) : null;
        if (messageReactionMostCommonReaction != null) {
            placeholderMessageReaction = messageReactionMostCommonReaction;
        }
        return new WidgetForumPostStatusViewModel$StoreState$Loaded(jLongValue, id2, guildId, lValueOf, z3, zJ, storeThreadMessages$ThreadState != null ? Integer.valueOf(storeThreadMessages$ThreadState.getCount()) : null, zCan, z2, placeholderMessageReaction);
    }
}
