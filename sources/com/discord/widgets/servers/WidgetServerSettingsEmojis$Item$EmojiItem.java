package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEmojis$Item$EmojiItem extends WidgetServerSettingsEmojis$Item {
    public static final WidgetServerSettingsEmojis$Item$EmojiItem$Companion Companion = new WidgetServerSettingsEmojis$Item$EmojiItem$Companion(null);
    private final ModelEmojiGuild emoji;
    private final GuildMember guildMember;
    private final String key;
    private final int type;
    private final User user;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetServerSettingsEmojis$Item$EmojiItem(ModelEmojiGuild modelEmojiGuild, User user, GuildMember guildMember) {
        super(null);
        m.checkNotNullParameter(modelEmojiGuild, "emoji");
        m.checkNotNullParameter(user, "user");
        this.emoji = modelEmojiGuild;
        this.user = user;
        this.guildMember = guildMember;
        this.key = String.valueOf(modelEmojiGuild.getId());
    }

    public static /* synthetic */ WidgetServerSettingsEmojis$Item$EmojiItem copy$default(WidgetServerSettingsEmojis$Item$EmojiItem widgetServerSettingsEmojis$Item$EmojiItem, ModelEmojiGuild modelEmojiGuild, User user, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            modelEmojiGuild = widgetServerSettingsEmojis$Item$EmojiItem.emoji;
        }
        if ((i & 2) != 0) {
            user = widgetServerSettingsEmojis$Item$EmojiItem.user;
        }
        if ((i & 4) != 0) {
            guildMember = widgetServerSettingsEmojis$Item$EmojiItem.guildMember;
        }
        return widgetServerSettingsEmojis$Item$EmojiItem.copy(modelEmojiGuild, user, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelEmojiGuild getEmoji() {
        return this.emoji;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final WidgetServerSettingsEmojis$Item$EmojiItem copy(ModelEmojiGuild emoji, User user, GuildMember guildMember) {
        m.checkNotNullParameter(emoji, "emoji");
        m.checkNotNullParameter(user, "user");
        return new WidgetServerSettingsEmojis$Item$EmojiItem(emoji, user, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEmojis$Item$EmojiItem)) {
            return false;
        }
        WidgetServerSettingsEmojis$Item$EmojiItem widgetServerSettingsEmojis$Item$EmojiItem = (WidgetServerSettingsEmojis$Item$EmojiItem) other;
        return m.areEqual(this.emoji, widgetServerSettingsEmojis$Item$EmojiItem.emoji) && m.areEqual(this.user, widgetServerSettingsEmojis$Item$EmojiItem.user) && m.areEqual(this.guildMember, widgetServerSettingsEmojis$Item$EmojiItem.guildMember);
    }

    public final ModelEmojiGuild getEmoji() {
        return this.emoji;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        ModelEmojiGuild modelEmojiGuild = this.emoji;
        int iHashCode = (modelEmojiGuild != null ? modelEmojiGuild.hashCode() : 0) * 31;
        User user = this.user;
        int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode2 + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiItem(emoji=");
        sbU.append(this.emoji);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
