package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.stores.StoreMessagesLoader$ChannelLoadedState;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import d0.t.n0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$Companion$getChannel$1<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<WidgetChatListModelTop, WidgetChatListModelMessages, StoreMessagesLoader$ChannelLoadedState, Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends Integer>, WidgetChatListModel$ChatListState, WidgetChatListModel> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModel$Companion$getChannel$1(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ WidgetChatListModel call(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState, Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, Map<Long, ? extends Integer> map3, WidgetChatListModel$ChatListState widgetChatListModel$ChatListState) {
        return call2(widgetChatListModelTop, widgetChatListModelMessages, storeMessagesLoader$ChannelLoadedState, (Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, (Map<Long, Integer>) map3, widgetChatListModel$ChatListState);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel call2(WidgetChatListModelTop widgetChatListModelTop, WidgetChatListModelMessages widgetChatListModelMessages, StoreMessagesLoader$ChannelLoadedState storeMessagesLoader$ChannelLoadedState, Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, Map<Long, Integer> map3, WidgetChatListModel$ChatListState widgetChatListModel$ChatListState) {
        ChatListEntry chatListEntryAccess$getGreetMessageItem;
        List<Long> roles;
        WidgetChatListModel$Companion widgetChatListModel$Companion = WidgetChatListModel.Companion;
        m.checkNotNullExpressionValue(storeMessagesLoader$ChannelLoadedState, "loadingState");
        m.checkNotNullExpressionValue(widgetChatListModelMessages, "messages");
        Channel channel = this.$channel;
        m.checkNotNullExpressionValue(map3, "relationships");
        boolean zAccess$shouldShowStickerGreet = WidgetChatListModel$Companion.access$shouldShowStickerGreet(widgetChatListModel$Companion, storeMessagesLoader$ChannelLoadedState, widgetChatListModelMessages, channel, map3);
        int size = widgetChatListModelMessages.getItems().size() + 2;
        if (zAccess$shouldShowStickerGreet) {
            size++;
        }
        ArrayList arrayList = new ArrayList(size);
        if (widgetChatListModel$ChatListState == WidgetChatListModel$ChatListState.DETACHED) {
            arrayList.add(new LoadingEntry());
        } else {
            arrayList.add(new SpacerEntry(this.$channel.getId()));
            if (zAccess$shouldShowStickerGreet && (chatListEntryAccess$getGreetMessageItem = WidgetChatListModel$Companion.access$getGreetMessageItem(widgetChatListModel$Companion, widgetChatListModelMessages, this.$channel)) != null) {
                arrayList.add(chatListEntryAccess$getGreetMessageItem);
            }
        }
        arrayList.addAll(widgetChatListModelMessages.getItems());
        arrayList.add(widgetChatListModelTop.getItem());
        GuildMember guildMember = map2.get(l);
        Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? n0.emptySet() : new HashSet(roles);
        m.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        long id2 = this.$channel.getId();
        long guildId = this.$channel.getGuildId();
        m.checkNotNullExpressionValue(map, "channelNames");
        return new WidgetChatListModel(jLongValue, id2, guild, guildId, map, widgetChatListModelMessages.getOldestMessageId(), arrayList, setEmptySet, widgetChatListModelMessages.getNewMessagesMarkerMessageId(), widgetChatListModelMessages.getNewestKnownMessageId(), storeMessagesLoader$ChannelLoadedState.isLoadingMessages());
    }
}
