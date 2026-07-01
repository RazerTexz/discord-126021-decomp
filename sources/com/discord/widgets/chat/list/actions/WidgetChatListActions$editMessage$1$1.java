package com.discord.widgets.chat.list.actions;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.emoji.EmojiSet;
import com.discord.models.guild.Guild;
import com.discord.models.user.User;
import com.discord.utilities.textprocessing.MessageUnparser;
import d0.z.d.m;
import java.util.Map;
import rx.functions.Func3;

/* JADX INFO: compiled from: WidgetChatListActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListActions$editMessage$1$1<T1, T2, T3, R> implements Func3<Map<Long, ? extends User>, Map<Long, ? extends Guild>, EmojiSet, CharSequence> {
    public final /* synthetic */ Map $channels;
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ WidgetChatListActions$editMessage$1 this$0;

    public WidgetChatListActions$editMessage$1$1(WidgetChatListActions$editMessage$1 widgetChatListActions$editMessage$1, long j, Map map) {
        this.this$0 = widgetChatListActions$editMessage$1;
        this.$guildId = j;
        this.$channels = map;
    }

    @Override // rx.functions.Func3
    public /* bridge */ /* synthetic */ CharSequence call(Map<Long, ? extends User> map, Map<Long, ? extends Guild> map2, EmojiSet emojiSet) {
        return call2(map, (Map<Long, Guild>) map2, emojiSet);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final CharSequence call2(Map<Long, ? extends User> map, Map<Long, Guild> map2, EmojiSet emojiSet) {
        String content = this.this$0.$message.getContent();
        if (content == null) {
            content = "";
        }
        Guild guild = map2.get(Long.valueOf(this.$guildId));
        Map map3 = this.$channels;
        m.checkNotNullExpressionValue(map3, "channels");
        m.checkNotNullExpressionValue(map, "users");
        m.checkNotNullExpressionValue(emojiSet, "emojiSet");
        return MessageUnparser.unparse(content, guild, map3, map, emojiSet);
    }
}
