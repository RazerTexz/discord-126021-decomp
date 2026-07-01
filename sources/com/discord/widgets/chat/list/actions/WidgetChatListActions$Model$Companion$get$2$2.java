package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.message.Message;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$Model$Companion$get$2$2<T1, T2, T3, T4, T5, R> implements Func5<Long, MeUser, GuildMember, Guild, EmojiSet, WidgetChatListActions$Model> {
    public final /* synthetic */ Channel $channel;
    public final /* synthetic */ Message $message;
    public final /* synthetic */ WidgetChatListActions$Model$Companion$get$2 this$0;

    public WidgetChatListActions$Model$Companion$get$2$2(WidgetChatListActions$Model$Companion$get$2 widgetChatListActions$Model$Companion$get$2, Message message, Channel channel) {
        this.this$0 = widgetChatListActions$Model$Companion$get$2;
        this.$message = message;
        this.$channel = channel;
    }

    @Override // rx.functions.Func5
    public /* bridge */ /* synthetic */ WidgetChatListActions$Model call(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
        return call2(l, meUser, guildMember, guild, emojiSet);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetChatListActions$Model call2(Long l, MeUser meUser, GuildMember guildMember, Guild guild, EmojiSet emojiSet) {
        WidgetChatListActions$Model$Companion widgetChatListActions$Model$Companion = WidgetChatListActions$Model.Companion;
        Message message = this.$message;
        m.checkNotNullExpressionValue(meUser, "meUser");
        Channel channel = this.$channel;
        WidgetChatListActions$Model$Companion$get$2 widgetChatListActions$Model$Companion$get$2 = this.this$0;
        CharSequence charSequence = widgetChatListActions$Model$Companion$get$2.$messageContent;
        int i = widgetChatListActions$Model$Companion$get$2.$type;
        m.checkNotNullExpressionValue(emojiSet, "emojis");
        return WidgetChatListActions$Model$Companion.access$create(widgetChatListActions$Model$Companion, message, guild, l, meUser, guildMember, channel, charSequence, i, emojiSet);
    }
}
