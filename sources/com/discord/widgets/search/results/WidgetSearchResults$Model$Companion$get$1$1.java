package com.discord.widgets.search.results;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreStream;
import com.discord.utilities.embed.InviteEmbedModel;
import com.discord.utilities.search.network.state.QueryFetchState;
import com.discord.utilities.search.network.state.SearchState;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.MessageHeaderEntry;
import com.discord.widgets.chat.list.entries.SearchEmptyEntry;
import com.discord.widgets.chat.list.entries.SearchErrorEntry;
import com.discord.widgets.chat.list.entries.SearchIndexingEntry;
import com.discord.widgets.chat.list.entries.SearchResultCountEntry;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$Companion;
import com.discord.widgets.chat.list.model.WidgetChatListModelMessages$MessagesWithMetadata;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.t.h0;
import d0.t.n;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function10;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchResults$Model$Companion$get$1$1 extends o implements Function10<WidgetChatListModelMessages$MessagesWithMetadata, Long, Map<Long, ? extends String>, Map<Long, ? extends Guild>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends Channel>, Boolean, Boolean, InviteEmbedModel, WidgetSearchResults$Model> {
    public final /* synthetic */ SearchState $searchState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchResults$Model$Companion$get$1$1(SearchState searchState) {
        super(10);
        this.$searchState = searchState;
    }

    @Override // kotlin.jvm.functions.Function10
    public /* bridge */ /* synthetic */ WidgetSearchResults$Model invoke(WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, Long l, Map<Long, ? extends String> map, Map<Long, ? extends Guild> map2, Map<Long, ? extends Map<Long, ? extends GuildMember>> map3, Map<Long, ? extends Map<Long, ? extends GuildRole>> map4, Map<Long, ? extends Channel> map5, Boolean bool, Boolean bool2, InviteEmbedModel inviteEmbedModel) {
        return invoke(widgetChatListModelMessages$MessagesWithMetadata, l.longValue(), (Map<Long, String>) map, (Map<Long, Guild>) map2, (Map<Long, ? extends Map<Long, GuildMember>>) map3, (Map<Long, ? extends Map<Long, GuildRole>>) map4, (Map<Long, Channel>) map5, bool.booleanValue(), bool2.booleanValue(), inviteEmbedModel);
    }

    public final WidgetSearchResults$Model invoke(WidgetChatListModelMessages$MessagesWithMetadata widgetChatListModelMessages$MessagesWithMetadata, long j, Map<Long, String> map, Map<Long, Guild> map2, Map<Long, ? extends Map<Long, GuildMember>> map3, Map<Long, ? extends Map<Long, GuildRole>> map4, Map<Long, Channel> map5, boolean z2, boolean z3, InviteEmbedModel inviteEmbedModel) {
        Long l;
        Map<Long, Guild> map6 = map2;
        Map<Long, ? extends Map<Long, GuildMember>> map7 = map3;
        Map<Long, ? extends Map<Long, GuildRole>> map8 = map4;
        m.checkNotNullParameter(widgetChatListModelMessages$MessagesWithMetadata, "messagesWithMetadata");
        m.checkNotNullParameter(map, "channelNames");
        m.checkNotNullParameter(map6, "guilds");
        m.checkNotNullParameter(map7, "members");
        m.checkNotNullParameter(map8, "roles");
        m.checkNotNullParameter(map5, "channels");
        m.checkNotNullParameter(inviteEmbedModel, "inviteEmbedModel");
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        Long l2 = null;
        if (this.$searchState.getQueryFetchState() == QueryFetchState.COMPLETED || this.$searchState.getQueryFetchState() == QueryFetchState.LOADING_MORE) {
            List<Message> messages = widgetChatListModelMessages$MessagesWithMetadata.getMessages();
            if (!messages.isEmpty()) {
                Long lValueOf = Long.valueOf(messages.get(messages.size() - 1).getId());
                arrayList.add(new SearchResultCountEntry(this.$searchState.getTotalResults()));
                l = lValueOf;
            } else {
                l = null;
            }
            for (Message message : messages) {
                Channel channel = map5.get(Long.valueOf(message.getChannelId()));
                if (channel != null) {
                    Map mapEmptyMap = (Map) a.c(channel, map7);
                    if (mapEmptyMap == null) {
                        mapEmptyMap = h0.emptyMap();
                    }
                    Map map9 = mapEmptyMap;
                    GuildMember guildMember = (GuildMember) map9.get(Long.valueOf(j));
                    List<Long> roles = guildMember != null ? guildMember.getRoles() : null;
                    if (roles == null) {
                        roles = n.emptyList();
                    }
                    hashSet.addAll(roles);
                    arrayList.add(new MessageHeaderEntry(message, channel, (Guild) a.c(channel, map6)));
                    Map<Long, GuildRole> mapEmptyMap2 = map8.get(Long.valueOf(channel.getGuildId()));
                    if (mapEmptyMap2 == null) {
                        mapEmptyMap2 = h0.emptyMap();
                    }
                    arrayList.addAll(WidgetChatListModelMessages$Companion.getMessageItems$default(WidgetChatListModelMessages.Companion, channel, map9, mapEmptyMap2, new HashMap(), widgetChatListModelMessages$MessagesWithMetadata.getMessageThreads().get(Long.valueOf(message.getId())), widgetChatListModelMessages$MessagesWithMetadata.getThreadCountsAndLatestMessages().get(Long.valueOf(message.getId())), message, widgetChatListModelMessages$MessagesWithMetadata.getMessageState().get(Long.valueOf(message.getId())), new HashMap(), false, false, null, z2, z3, StoreStream.Companion.getUserSettings().getIsRenderEmbedsEnabled(), j, false, new HashMap(), inviteEmbedModel, false, GuildRoleSubscriptionsFeatureFlag.Companion.getINSTANCE().canGuildSeePurchaseFeedbackLoopMessages(channel.getGuildId()), 524288, null));
                }
                map6 = map2;
                map7 = map3;
                map8 = map4;
            }
            if (this.$searchState.getQueryFetchState() == QueryFetchState.LOADING_MORE) {
                arrayList.add(new LoadingEntry());
            } else if (arrayList.isEmpty()) {
                arrayList.add(new SearchEmptyEntry());
            }
            l2 = l;
        } else if (this.$searchState.getQueryFetchState() == QueryFetchState.IN_PROGRESS) {
            arrayList.add(new LoadingEntry());
        } else if (this.$searchState.getQueryFetchState() == QueryFetchState.INDEXING) {
            arrayList.add(new SearchIndexingEntry());
        } else if (this.$searchState.getQueryFetchState() == QueryFetchState.FAILED) {
            arrayList.add(new SearchErrorEntry());
        }
        return new WidgetSearchResults$Model(arrayList, j, map, l2 != null ? l2.longValue() : 0L, hashSet);
    }
}
