package com.discord.widgets.servers;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEmojis$Item$EmojiHeader extends WidgetServerSettingsEmojis$Item {
    private final int emojiMax;
    private final String key;
    private final int type;

    public WidgetServerSettingsEmojis$Item$EmojiHeader(int i) {
        super(null);
        this.emojiMax = i;
        this.type = 2;
        this.key = "EMOJI_HEADER";
    }

    public static /* synthetic */ WidgetServerSettingsEmojis$Item$EmojiHeader copy$default(WidgetServerSettingsEmojis$Item$EmojiHeader widgetServerSettingsEmojis$Item$EmojiHeader, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetServerSettingsEmojis$Item$EmojiHeader.emojiMax;
        }
        return widgetServerSettingsEmojis$Item$EmojiHeader.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEmojiMax() {
        return this.emojiMax;
    }

    public final WidgetServerSettingsEmojis$Item$EmojiHeader copy(int emojiMax) {
        return new WidgetServerSettingsEmojis$Item$EmojiHeader(emojiMax);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetServerSettingsEmojis$Item$EmojiHeader) && this.emojiMax == ((WidgetServerSettingsEmojis$Item$EmojiHeader) other).emojiMax;
        }
        return true;
    }

    public final int getEmojiMax() {
        return this.emojiMax;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return this.emojiMax;
    }

    public String toString() {
        return a.B(a.U("EmojiHeader(emojiMax="), this.emojiMax, ")");
    }
}
