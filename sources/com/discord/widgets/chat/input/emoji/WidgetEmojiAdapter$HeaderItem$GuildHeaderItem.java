package com.discord.widgets.chat.input.emoji;

import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetEmojiAdapter$HeaderItem$GuildHeaderItem extends WidgetEmojiAdapter$HeaderItem {
    private final String key;
    private final String text;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$HeaderItem$GuildHeaderItem(String str, String str2) {
        super(null);
        m.checkNotNullParameter(str, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(str2, "key");
        this.text = str;
        this.key = str2;
    }

    public static /* synthetic */ WidgetEmojiAdapter$HeaderItem$GuildHeaderItem copy$default(WidgetEmojiAdapter$HeaderItem$GuildHeaderItem widgetEmojiAdapter$HeaderItem$GuildHeaderItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetEmojiAdapter$HeaderItem$GuildHeaderItem.text;
        }
        if ((i & 2) != 0) {
            str2 = widgetEmojiAdapter$HeaderItem$GuildHeaderItem.getKey();
        }
        return widgetEmojiAdapter$HeaderItem$GuildHeaderItem.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getText() {
        return this.text;
    }

    public final String component2() {
        return getKey();
    }

    public final WidgetEmojiAdapter$HeaderItem$GuildHeaderItem copy(String text, String key) {
        m.checkNotNullParameter(text, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        m.checkNotNullParameter(key, "key");
        return new WidgetEmojiAdapter$HeaderItem$GuildHeaderItem(text, key);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetEmojiAdapter$HeaderItem$GuildHeaderItem)) {
            return false;
        }
        WidgetEmojiAdapter$HeaderItem$GuildHeaderItem widgetEmojiAdapter$HeaderItem$GuildHeaderItem = (WidgetEmojiAdapter$HeaderItem$GuildHeaderItem) other;
        return m.areEqual(this.text, widgetEmojiAdapter$HeaderItem$GuildHeaderItem.text) && m.areEqual(getKey(), widgetEmojiAdapter$HeaderItem$GuildHeaderItem.getKey());
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        String str = this.text;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String key = getKey();
        return iHashCode + (key != null ? key.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GuildHeaderItem(text=");
        sbU.append(this.text);
        sbU.append(", key=");
        sbU.append(getKey());
        sbU.append(")");
        return sbU.toString();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$HeaderItem$GuildHeaderItem(Guild guild) {
        this(guild.getName(), String.valueOf(guild.getId()));
        m.checkNotNullParameter(guild, "guild");
    }
}
