package com.discord.widgets.guilds.profile;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetGuildProfileSheetEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class EmojiItem$MoreEmoji extends EmojiItem {
    private final int extraEmojiCount;

    public EmojiItem$MoreEmoji(int i) {
        super(1, null);
        this.extraEmojiCount = i;
    }

    public static /* synthetic */ EmojiItem$MoreEmoji copy$default(EmojiItem$MoreEmoji emojiItem$MoreEmoji, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = emojiItem$MoreEmoji.extraEmojiCount;
        }
        return emojiItem$MoreEmoji.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getExtraEmojiCount() {
        return this.extraEmojiCount;
    }

    public final EmojiItem$MoreEmoji copy(int extraEmojiCount) {
        return new EmojiItem$MoreEmoji(extraEmojiCount);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof EmojiItem$MoreEmoji) && this.extraEmojiCount == ((EmojiItem$MoreEmoji) other).extraEmojiCount;
        }
        return true;
    }

    public final int getExtraEmojiCount() {
        return this.extraEmojiCount;
    }

    public int hashCode() {
        return this.extraEmojiCount;
    }

    public String toString() {
        return a.B(a.U("MoreEmoji(extraEmojiCount="), this.extraEmojiCount, ")");
    }
}
