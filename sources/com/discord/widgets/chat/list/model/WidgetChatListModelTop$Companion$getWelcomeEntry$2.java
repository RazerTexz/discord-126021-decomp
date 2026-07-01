package com.discord.widgets.chat.list.model;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.permission.Permission;
import com.discord.api.thread.ThreadMetadata;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.threads.ThreadUtils;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GuildWelcomeEntry;
import com.discord.widgets.chat.list.entries.StartOfChatEntry;
import com.discord.widgets.chat.list.entries.StartOfPrivateChatEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Map;
import rx.functions.Func9;

/* JADX INFO: compiled from: WidgetChatListModelTop.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListModelTop$Companion$getWelcomeEntry$2<T1, T2, T3, T4, T5, T6, T7, T8, T9, R> implements Func9<Guild, MeUser, Long, Long, GuildMember, User, Map<Long, ? extends List<? extends Guild>>, Channel, Boolean, ChatListEntry> {
    public final /* synthetic */ Channel $channel;

    public WidgetChatListModelTop$Companion$getWelcomeEntry$2(Channel channel) {
        this.$channel = channel;
    }

    @Override // rx.functions.Func9
    public /* bridge */ /* synthetic */ ChatListEntry call(Guild guild, MeUser meUser, Long l, Long l2, GuildMember guildMember, User user, Map<Long, ? extends List<? extends Guild>> map, Channel channel, Boolean bool) {
        return call2(guild, meUser, l, l2, guildMember, user, (Map<Long, ? extends List<Guild>>) map, channel, bool);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final ChatListEntry call2(Guild guild, MeUser meUser, Long l, Long l2, GuildMember guildMember, User user, Map<Long, ? extends List<Guild>> map, Channel channel, Boolean bool) {
        boolean z2 = l2 != null && this.$channel.getId() == l2.longValue();
        boolean z3 = guild != null && guild.hasIcon();
        boolean zCan = PermissionUtils.can(Permission.READ_MESSAGE_HISTORY, l);
        boolean zCan2 = PermissionUtils.can(1L, l);
        boolean zCan3 = PermissionUtils.can(16L, l);
        ThreadUtils threadUtils = ThreadUtils.INSTANCE;
        m.checkNotNullExpressionValue(meUser, "me");
        boolean zCanManageThread = threadUtils.canManageThread(meUser, this.$channel, l);
        User userA = ChannelUtils.a(this.$channel);
        List<Guild> listEmptyList = map.get(Long.valueOf(userA != null ? userA.getId() : 0L));
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        boolean zIsOwner = guild != null ? guild.isOwner(meUser.getId()) : false;
        if (ChannelUtils.v(this.$channel) && guild != null && z2 && zCan && (zCan2 || !z3)) {
            long id2 = guild.getId();
            String name = guild.getName();
            return new GuildWelcomeEntry(zIsOwner, z3, zCan2, id2, name != null ? name : "");
        }
        if (ChannelUtils.B(this.$channel)) {
            return new StartOfPrivateChatEntry(this.$channel.getId(), ChannelUtils.c(this.$channel), this.$channel.getType(), IconUtils.getForChannel$default(this.$channel, null, 2, null), ChannelUtils.E(this.$channel), listEmptyList);
        }
        long id3 = this.$channel.getId();
        String strC = ChannelUtils.c(this.$channel);
        boolean zJ = ChannelUtils.J(this.$channel);
        boolean zH = ChannelUtils.H(this.$channel);
        ThreadMetadata threadMetadata = this.$channel.getThreadMetadata();
        Integer numValueOf = threadMetadata != null ? Integer.valueOf(threadMetadata.getAutoArchiveDuration()) : null;
        String nickOrUsername = user != null ? GuildMember.Companion.getNickOrUsername(guildMember, user) : "";
        boolean z4 = channel != null && ChannelUtils.q(channel);
        m.checkNotNullExpressionValue(bool, "canAccessRedesignedForumChannels");
        return new StartOfChatEntry(id3, strC, zCan, zCan3, zCanManageThread, zH, numValueOf, guildMember, nickOrUsername, zJ, z4, bool.booleanValue(), channel != null ? channel.d() : null, this.$channel.c());
    }
}
