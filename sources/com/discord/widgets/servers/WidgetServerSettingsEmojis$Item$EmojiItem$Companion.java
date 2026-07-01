package com.discord.widgets.servers;

import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.CoreUser;
import d0.z.d.m;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Item$EmojiItem$Companion {
    private WidgetServerSettingsEmojis$Item$EmojiItem$Companion() {
    }

    public final WidgetServerSettingsEmojis$Item$EmojiItem from(ModelEmojiGuild emoji, Map<Long, GuildMember> guildMembers) {
        m.checkNotNullParameter(emoji, "emoji");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        CoreUser coreUser = new CoreUser(emoji.getUser());
        return new WidgetServerSettingsEmojis$Item$EmojiItem(emoji, coreUser, guildMembers.get(Long.valueOf(coreUser.getId())));
    }

    public /* synthetic */ WidgetServerSettingsEmojis$Item$EmojiItem$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
