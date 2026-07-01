package com.discord.widgets.chat.pins;

import com.discord.api.channel.ChannelUtils;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.widgets.chat.list.entries.DividerEntry;
import com.discord.widgets.chat.list.entries.EmptyPinsEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata;
import d0.t.n0;
import d0.t.u;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: WidgetChannelPinnedMessages.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelPinnedMessages$Model$Companion$get$1$1 extends o implements Function10<Long, WidgetChatListModelMessages$MessagesWithMetadata, Map<Long, ? extends GuildRole>, Map<Long, ? extends GuildMember>, Map<Long, ? extends String>, Boolean, Boolean, Guild, InviteEmbedModel, Boolean, WidgetChannelPinnedMessages$Model> {
    public final /* synthetic */ List $pinnedMessages;
    public final /* synthetic */ WidgetChannelPinnedMessages$Model$Companion$get$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelPinnedMessages$Model$Companion$get$1$1(WidgetChannelPinnedMessages$Model$Companion$get$1 widgetChannelPinnedMessages$Model$Companion$get$1, List list) {
        super(10);
        this.this$0 = widgetChannelPinnedMessages$Model$Companion$get$1;
        this.$pinnedMessages = list;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ WidgetChannelPinnedMessages$Model invoke(Long l, WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, Map<Long, ? extends GuildRole> map, Map<Long, ? extends GuildMember> map2, Map<Long, ? extends String> map3, Boolean bool, Boolean bool2, Guild guild, InviteEmbedModel inviteEmbedModel, Boolean bool3) {
        return invoke(l.longValue(), widgetChatListModelMessages$MessagesWithMetadata, (Map<Long, GuildRole>) map, (Map<Long, GuildMember>) map2, (Map<Long, String>) map3, bool.booleanValue(), bool2.booleanValue(), guild, inviteEmbedModel, bool3.booleanValue());
    }

    /* JADX WARN: Code duplicated, block: B:27:0x0141  */
    public final WidgetChannelPinnedMessages$Model invoke(long j, WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, Map<Long, GuildRole> map, Map<Long, GuildMember> map2, Map<Long, String> map3, boolean z2, boolean z3, Guild guild, InviteEmbedModel inviteEmbedModel, boolean z4) {
        List list;
        List listListOf;
        GuildMember guildMember;
        Set setEmptySet;
        List<Long> roles;
        m.checkNotNullParameter(widgetChatListModelMessages$MessagesWithMetadata, "messagesWithMetadata");
        m.checkNotNullParameter(map, "guildRoles");
        m.checkNotNullParameter(map2, "guildMembers");
        m.checkNotNullParameter(map3, "channelNames");
        m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        List list2 = this.$pinnedMessages;
        if (list2 != null) {
            if (list2.isEmpty()) {
                WidgetChannelPinnedMessages$Model$Companion$get$1 widgetChannelPinnedMessages$Model$Companion$get$1 = this.this$0;
                String string = widgetChannelPinnedMessages$Model$Companion$get$1.$context.getString(ChannelUtils.B(widgetChannelPinnedMessages$Model$Companion$get$1.$channel) ? 2131893273 : 2131893272);
                m.checkNotNullExpressionValue(string, "context.getString(\n     …                        )");
                listListOf = d0.t.m.listOf(new EmptyPinsEntry(string));
            } else {
                ArrayList arrayList = new ArrayList();
                int size = this.$pinnedMessages.size();
                int i = 0;
                while (i < size) {
                    Message message = (Message) this.$pinnedMessages.get(i);
                    int i2 = i;
                    int i3 = size;
                    ArrayList arrayList2 = arrayList;
                    arrayList2.addAll(WidgetChatListModelMessages$Companion.getMessageItems$default(WidgetChatListModelMessages.Companion, this.this$0.$channel, map2, map, new HashMap(), widgetChatListModelMessages$MessagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), widgetChatListModelMessages$MessagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, widgetChatListModelMessages$MessagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), new HashMap(), false, false, null, z2, z3, StoreStream.Companion.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, z4, 524288, null));
                    if (i2 < this.$pinnedMessages.size() - 1) {
                        arrayList2.add(new DividerEntry());
                    }
                    i = i2 + 1;
                    arrayList = arrayList2;
                    size = i3;
                }
                list = arrayList;
            }
            guildMember = map2.get(Long.valueOf(j));
            if (guildMember != null || (roles = guildMember.getRoles()) == null || (setEmptySet = u.toHashSet(roles)) == null) {
                setEmptySet = n0.emptySet();
            }
            return new WidgetChannelPinnedMessages$Model(this.this$0.$channel, guild, j, map3, list, setEmptySet, 0L, 0L, 0L, 0L, false, 1984, null);
        }
        listListOf = d0.t.m.listOf(new LoadingEntry());
        list = listListOf;
        guildMember = map2.get(Long.valueOf(j));
        if (guildMember != null) {
            setEmptySet = n0.emptySet();
        } else {
            setEmptySet = n0.emptySet();
        }
        return new WidgetChannelPinnedMessages$Model(this.this$0.$channel, guild, j, map3, list, setEmptySet, 0L, 0L, 0L, 0L, false, 1984, null);
    }
}
