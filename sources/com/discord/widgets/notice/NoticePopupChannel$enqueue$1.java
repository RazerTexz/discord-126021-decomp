package com.discord.widgets.notice;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.User;
import d0.z.d.k;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.functions.Function9;

/* JADX INFO: compiled from: NoticePopupChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class NoticePopupChannel$enqueue$1 extends k implements Function9<Context, Message, Guild, Channel, Map<Long, ? extends GuildMember>, Long, User, Map<Long, ? extends String>, Map<Long, ? extends GuildRole>, NoticePopupChannel$Model> {
    public NoticePopupChannel$enqueue$1(NoticePopupChannel noticePopupChannel) {
        super(9, noticePopupChannel, NoticePopupChannel.class, "createModel", "createModel(Landroid/content/Context;Lcom/discord/models/message/Message;Lcom/discord/models/guild/Guild;Lcom/discord/api/channel/Channel;Ljava/util/Map;Ljava/lang/Long;Lcom/discord/models/user/User;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/widgets/notice/NoticePopupChannel$Model;", 0);
    }

    @Override // kotlin.jvm.functions.Function9
    public /* bridge */ /* synthetic */ NoticePopupChannel$Model invoke(Context context, Message message, Guild guild, Channel channel, Map<Long, ? extends GuildMember> map, Long l, User user, Map<Long, ? extends String> map2, Map<Long, ? extends GuildRole> map3) {
        return invoke2(context, message, guild, channel, (Map<Long, GuildMember>) map, l, user, (Map<Long, String>) map2, (Map<Long, GuildRole>) map3);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final NoticePopupChannel$Model invoke2(Context context, Message message, Guild guild, Channel channel, Map<Long, GuildMember> map, Long l, User user, Map<Long, String> map2, Map<Long, GuildRole> map3) {
        m.checkNotNullParameter(context, "p1");
        m.checkNotNullParameter(message, "p2");
        m.checkNotNullParameter(map, "p5");
        m.checkNotNullParameter(user, "p7");
        m.checkNotNullParameter(map2, "p8");
        m.checkNotNullParameter(map3, "p9");
        return NoticePopupChannel.access$createModel((NoticePopupChannel) this.receiver, context, message, guild, channel, map, l, user, map2, map3);
    }
}
