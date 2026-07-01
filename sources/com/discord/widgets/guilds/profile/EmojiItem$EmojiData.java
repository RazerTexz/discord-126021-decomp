package com.discord.widgets.guilds.profile;

import b.d.b.a.a;
import com.discord.models.domain.emoji.Emoji;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiItem$EmojiData extends EmojiItem {
    private final Emoji emoji;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiItem$EmojiData(Emoji emoji) {
        super(0, null);
        m.checkNotNullParameter(emoji, "emoji");
        this.emoji = emoji;
    }

    public static /* synthetic */ EmojiItem$EmojiData copy$default(EmojiItem$EmojiData emojiItem$EmojiData, Emoji emoji, int i, Object obj) {
        if ((i & 1) != 0) {
            emoji = emojiItem$EmojiData.emoji;
        }
        return emojiItem$EmojiData.copy(emoji);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Emoji getEmoji() {
        return this.emoji;
    }

    public final EmojiItem$EmojiData copy(Emoji emoji) {
        m.checkNotNullParameter(emoji, "emoji");
        return new EmojiItem$EmojiData(emoji);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmojiItem$EmojiData) && m.areEqual(this.emoji, ((EmojiItem$EmojiData) other).emoji);
        }
        return true;
    }

    public final Emoji getEmoji() {
        return this.emoji;
    }

    public int hashCode() {
        Emoji emoji = this.emoji;
        if (emoji != null) {
            return emoji.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiData(emoji=");
        sbU.append(this.emoji);
        sbU.append(")");
        return sbU.toString();
    }
}
