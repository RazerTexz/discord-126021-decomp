package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.LoadingEntry;
import com.discord.widgets.chat.list.entries.SpacerEntry;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import d0.t.n0;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModel$Companion$getThreadDraft$3<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Map<Long, ? extends String>, Long, Map<Long, ? extends GuildMember>, Guild, StoreThreadDraft$ThreadDraftState, Long, Pair<? extends Message, ? extends List<? extends ChatListEntry>>, WidgetChatListModel> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ Channel $parentChannel;
    public final /* synthetic */ Long $parentMessageId;

    public WidgetChatListModel$Companion$getThreadDraft$3(Channel channel, Long l, long j) {
        this.$parentChannel = channel;
        this.$parentMessageId = l;
        this.$guildId = j;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetChatListModel call(Map<Long, ? extends String> map, Long l, Map<Long, ? extends GuildMember> map2, Guild guild, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Long l2, Pair<? extends Message, ? extends List<? extends ChatListEntry>> pair) {
        return call2((Map<Long, String>) map, l, (Map<Long, GuildMember>) map2, guild, storeThreadDraft$ThreadDraftState, l2, (Pair<Message, ? extends List<? extends ChatListEntry>>) pair);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListModel call2(Map<Long, String> map, Long l, Map<Long, GuildMember> map2, Guild guild, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, Long l2, Pair<Message, ? extends List<? extends ChatListEntry>> pair) {
        List<Long> roles;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new SpacerEntry(this.$parentChannel.getId()));
        if (storeThreadDraft$ThreadDraftState.isSending()) {
            arrayList.add(new LoadingEntry());
        }
        arrayList.addAll(pair.getSecond());
        Channel channel = this.$parentChannel;
        Long l3 = this.$parentMessageId;
        long guildId = channel.getGuildId();
        Integer defaultAutoArchiveDuration = this.$parentChannel.getDefaultAutoArchiveDuration();
        m.checkNotNullExpressionValue(storeThreadDraft$ThreadDraftState, "threadDraft");
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        arrayList.add(new ThreadDraftFormEntry(channel, l3, guildId, guild, defaultAutoArchiveDuration, storeThreadDraft$ThreadDraftState, ThreadUtils.canCreatePrivateThread$default(threadUtils, l2, this.$parentChannel, guild, false, 8, null), threadUtils.canCreatePrivateThread(l2, this.$parentChannel, guild, false), threadUtils.canCreatePublicThread(l2, this.$parentChannel, pair.getFirst(), guild)));
        GuildMember guildMember = map2.get(l);
        Set setEmptySet = (guildMember == null || (roles = guildMember.getRoles()) == null) ? n0.emptySet() : new HashSet(roles);
        m.checkNotNullExpressionValue(l, "myId");
        long jLongValue = l.longValue();
        long j = this.$guildId;
        m.checkNotNullExpressionValue(map, "channelNames");
        return new WidgetChatListModel(jLongValue, -3L, guild, j, map, 0L, arrayList, setEmptySet, 0L, 0L, false, 800, null);
    }
}
