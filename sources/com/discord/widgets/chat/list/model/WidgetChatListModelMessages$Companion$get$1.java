package com.discord.widgets.chat.list.model;

import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.api.user.User;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.widgets.botuikit.ComponentChatListState$ComponentStoreState;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.t.n;
import d0.t.t;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function15;

/* JADX INFO: compiled from: WidgetChatListModelMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelMessages$Companion$get$1 extends o implements Function15<WidgetChatListModelMessages$MessagesWithMetadata, Channel, Map<Long, ? extends Integer>, List<? extends Long>, Map<Long, ? extends GuildMember>, Long, Map<Long, ? extends GuildRole>, Long, Boolean, Boolean, Boolean, Long, Map<Long, ? extends ComponentChatListState$ComponentStoreState>, InviteEmbedModel, Boolean, WidgetChatListModelMessages> {
    public final /* synthetic */ Channel $channel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListModelMessages$Companion$get$1(Channel channel) {
        super(15);
        this.$channel = channel;
    }

    @Override // kotlin.jvm.functions.Function15
    public /* bridge */ /* synthetic */ WidgetChatListModelMessages invoke(WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, Channel channel, Map<Long, ? extends Integer> map, List<? extends Long> list, Map<Long, ? extends GuildMember> map2, Long l, Map<Long, ? extends GuildRole> map3, Long l2, Boolean bool, Boolean bool2, Boolean bool3, Long l3, Map<Long, ? extends ComponentChatListState$ComponentStoreState> map4, InviteEmbedModel inviteEmbedModel, Boolean bool4) {
        return invoke(widgetChatListModelMessages$MessagesWithMetadata, channel, (Map<Long, Integer>) map, (List<Long>) list, (Map<Long, GuildMember>) map2, l, (Map<Long, GuildRole>) map3, l2, bool.booleanValue(), bool2.booleanValue(), bool3.booleanValue(), l3.longValue(), (Map<Long, ComponentChatListState$ComponentStoreState>) map4, inviteEmbedModel, bool4.booleanValue());
    }

    public final WidgetChatListModelMessages invoke(WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, Channel channel, Map<Long, Integer> map, List<Long> list, Map<Long, GuildMember> map2, Long l, Map<Long, GuildRole> map3, Long l2, boolean z2, boolean z3, boolean z4, long j, Map<Long, ComponentChatListState$ComponentStoreState> map4, InviteEmbedModel inviteEmbedModel, boolean z5) {
        Object next;
        User author;
        boolean zContainsKey;
        boolean zContains;
        Message message;
        Message message2;
        WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion;
        WidgetChatListModelMessages$Items widgetChatListModelMessages$Items;
        WidgetChatListModelMessages$Items widgetChatListModelMessages$Items2;
        WidgetChatListModelMessages$Companion$get$1 widgetChatListModelMessages$Companion$get$1 = this;
        WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata2 = widgetChatListModelMessages$MessagesWithMetadata;
        Map<Long, Integer> map5 = map;
        m.checkNotNullParameter(widgetChatListModelMessages$MessagesWithMetadata2, "messagesWithMetadata");
        m.checkNotNullParameter(map5, "blockedRelationships");
        m.checkNotNullParameter(list, "blockedExpanded");
        m.checkNotNullParameter(map3, "guildRoles");
        m.checkNotNullParameter(map4, "componentStoreState");
        m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        WidgetChatListModelMessages$Items widgetChatListModelMessages$Items3 = new WidgetChatListModelMessages$Items(widgetChatListModelMessages$MessagesWithMetadata.getMessages().size());
        long j2 = 0;
        Message message3 = null;
        Message message4 = null;
        int i = 0;
        int iAccess$addBlockedMessage = 0;
        boolean z6 = false;
        boolean zAccess$tryAddNewMessagesSeparator = false;
        for (Object obj : widgetChatListModelMessages$MessagesWithMetadata.getMessages()) {
            int i2 = i + 1;
            if (i < 0) {
                n.throwIndexOverflow();
            }
            Message message5 = (Message) obj;
            WidgetChatListModelMessages$Companion widgetChatListModelMessages$Companion2 = WidgetChatListModelMessages.Companion;
            UtcDateTime timestamp = message5.getTimestamp();
            if (WidgetChatListModelMessages$Companion.access$willAddTimestamp(widgetChatListModelMessages$Companion2, timestamp != null ? timestamp.getDateTimeMillis() : 0L, j2)) {
                iAccess$addBlockedMessage = WidgetChatListModelMessages$Companion.access$addBlockedMessage(widgetChatListModelMessages$Companion2, widgetChatListModelMessages$Items3, message3, iAccess$addBlockedMessage, z6);
            }
            long id2 = message5.getId();
            UtcDateTime timestamp2 = message5.getTimestamp();
            long jAccess$tryAddTimestamp = WidgetChatListModelMessages$Companion.access$tryAddTimestamp(widgetChatListModelMessages$Companion2, widgetChatListModelMessages$Items3, id2, timestamp2 != null ? timestamp2.getDateTimeMillis() : 0L, j2);
            boolean z7 = i == widgetChatListModelMessages$MessagesWithMetadata.getMessages().size() - 1;
            Integer type = message5.getType();
            if (type != null && type.intValue() == 21) {
                User author2 = ((Message) WidgetChatListModelMessages$Companion.access$getThreadStarterMessageAndChannel(widgetChatListModelMessages$Companion2, channel, widgetChatListModelMessages$Companion$get$1.$channel, message5, widgetChatListModelMessages$MessagesWithMetadata2).getFirst()).getAuthor();
                zContainsKey = map5.containsKey(author2 != null ? Long.valueOf(author2.getId()) : null);
            } else {
                User author3 = message5.getAuthor();
                zContainsKey = map5.containsKey(author3 != null ? Long.valueOf(author3.getId()) : null);
            }
            if (zContainsKey && (iAccess$addBlockedMessage = iAccess$addBlockedMessage + 1) == 1) {
                zContains = list.contains(Long.valueOf(message5.getId()));
                message = message5;
            } else {
                zContains = z6;
                message = message3;
            }
            int iAccess$addBlockedMessage2 = (!zContainsKey || z7) ? WidgetChatListModelMessages$Companion.access$addBlockedMessage(widgetChatListModelMessages$Companion2, widgetChatListModelMessages$Items3, message, iAccess$addBlockedMessage, zContains) : iAccess$addBlockedMessage;
            boolean z8 = (zContainsKey || !zContains) ? zContains : false;
            if (!zContainsKey || z8) {
                boolean zAccess$shouldConcatMessage = WidgetChatListModelMessages$Companion.access$shouldConcatMessage(widgetChatListModelMessages$Companion2, widgetChatListModelMessages$Items3, message5, message4);
                widgetChatListModelMessages$Items3.setConcatCount(zAccess$shouldConcatMessage ? widgetChatListModelMessages$Items3.getConcatCount() + 1 : 0);
                Integer type2 = message5.getType();
                if (type2 != null && type2.intValue() == 21) {
                    Channel channel2 = widgetChatListModelMessages$Companion$get$1.$channel;
                    m.checkNotNullExpressionValue(map2, "guildMembers");
                    WidgetChatListModelMessages$Items widgetChatListModelMessages$Items4 = widgetChatListModelMessages$Items3;
                    message2 = message5;
                    widgetChatListModelMessages$Companion = widgetChatListModelMessages$Companion2;
                    widgetChatListModelMessages$Items4.addItems(widgetChatListModelMessages$Companion2.getThreadStarterMessageItems(channel, channel2, map2, map3, map, message5, widgetChatListModelMessages$MessagesWithMetadata, z2, z3, z4, j, true, map4, inviteEmbedModel));
                    widgetChatListModelMessages$Items = widgetChatListModelMessages$Items4;
                } else {
                    message2 = message5;
                    widgetChatListModelMessages$Companion = widgetChatListModelMessages$Companion2;
                    Channel channel3 = widgetChatListModelMessages$Companion$get$1.$channel;
                    m.checkNotNullExpressionValue(map2, "guildMembers");
                    widgetChatListModelMessages$Items = widgetChatListModelMessages$Items3;
                    widgetChatListModelMessages$Items.addItems(WidgetChatListModelMessages$Companion.getMessageItems$default(widgetChatListModelMessages$Companion, channel3, map2, map3, map, widgetChatListModelMessages$MessagesWithMetadata.getMessageThreads().get(Long.valueOf(message2.getId())), widgetChatListModelMessages$MessagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message2.getId())), message2, widgetChatListModelMessages$MessagesWithMetadata.getMessageState().get(Long.valueOf(message2.getId())), widgetChatListModelMessages$MessagesWithMetadata.getMessageReplyState(), z8, zAccess$shouldConcatMessage, l2, z2, z3, z4, j, true, map4, inviteEmbedModel, false, z5, 524288, null));
                }
            } else {
                widgetChatListModelMessages$Items = widgetChatListModelMessages$Items3;
                message2 = message5;
                widgetChatListModelMessages$Companion = widgetChatListModelMessages$Companion2;
            }
            if (zAccess$tryAddNewMessagesSeparator) {
                widgetChatListModelMessages$Items2 = widgetChatListModelMessages$Items;
                widgetChatListModelMessages$Companion$get$1 = this;
            } else {
                m.checkNotNullExpressionValue(l, "newMessagesMarkerMessageId");
                widgetChatListModelMessages$Items2 = widgetChatListModelMessages$Items;
                widgetChatListModelMessages$Companion$get$1 = this;
                zAccess$tryAddNewMessagesSeparator = WidgetChatListModelMessages$Companion.access$tryAddNewMessagesSeparator(widgetChatListModelMessages$Companion, widgetChatListModelMessages$Items2, l.longValue(), z7, message2.getId(), widgetChatListModelMessages$Companion$get$1.$channel);
            }
            widgetChatListModelMessages$MessagesWithMetadata2 = widgetChatListModelMessages$MessagesWithMetadata;
            map5 = map;
            widgetChatListModelMessages$Items3 = widgetChatListModelMessages$Items2;
            i = i2;
            j2 = jAccess$tryAddTimestamp;
            iAccess$addBlockedMessage = iAccess$addBlockedMessage2;
            z6 = z8;
            message3 = message;
            message4 = message2;
        }
        WidgetChatListModelMessages$Items widgetChatListModelMessages$Items5 = widgetChatListModelMessages$Items3;
        t.reverse(widgetChatListModelMessages$Items5.getItems());
        List<ChatListEntry> items = widgetChatListModelMessages$Items5.getItems();
        Message message6 = (Message) u.firstOrNull((List) widgetChatListModelMessages$MessagesWithMetadata.getMessages());
        long id3 = message6 != null ? message6.getId() : 0L;
        Message message7 = (Message) u.lastOrNull((List) widgetChatListModelMessages$MessagesWithMetadata.getMessages());
        long id4 = message7 != null ? message7.getId() : 0L;
        m.checkNotNullExpressionValue(l, "newMessagesMarkerMessageId");
        long jLongValue = l.longValue();
        Iterator<T> it = widgetChatListModelMessages$MessagesWithMetadata.getMessages().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            author = ((Message) next).getAuthor();
        } while (!(author != null && author.getId() == j));
        Message message8 = (Message) next;
        return new WidgetChatListModelMessages(items, id3, id4, map2, jLongValue, message8 != null ? Long.valueOf(message8.getId()) : null);
    }
}
