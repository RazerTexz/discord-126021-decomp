package com.discord.widgets.servers;

import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsEmojis$Item$EmojiSection extends WidgetServerSettingsEmojis$Item {
    private final int emojiLength;
    private final int emojiMax;
    private final String key;
    private final int titleId;
    private final int type;

    public WidgetServerSettingsEmojis$Item$EmojiSection(int i, int i2, int i3) {
        super(null);
        this.emojiMax = i;
        this.emojiLength = i2;
        this.titleId = i3;
        this.type = 1;
        this.key = String.valueOf(i3);
    }

    public static /* synthetic */ WidgetServerSettingsEmojis$Item$EmojiSection copy$default(WidgetServerSettingsEmojis$Item$EmojiSection widgetServerSettingsEmojis$Item$EmojiSection, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = widgetServerSettingsEmojis$Item$EmojiSection.emojiMax;
        }
        if ((i4 & 2) != 0) {
            i2 = widgetServerSettingsEmojis$Item$EmojiSection.emojiLength;
        }
        if ((i4 & 4) != 0) {
            i3 = widgetServerSettingsEmojis$Item$EmojiSection.titleId;
        }
        return widgetServerSettingsEmojis$Item$EmojiSection.copy(i, i2, i3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getEmojiMax() {
        return this.emojiMax;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getEmojiLength() {
        return this.emojiLength;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getTitleId() {
        return this.titleId;
    }

    public final WidgetServerSettingsEmojis$Item$EmojiSection copy(int emojiMax, int emojiLength, int titleId) {
        return new WidgetServerSettingsEmojis$Item$EmojiSection(emojiMax, emojiLength, titleId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsEmojis$Item$EmojiSection)) {
            return false;
        }
        WidgetServerSettingsEmojis$Item$EmojiSection widgetServerSettingsEmojis$Item$EmojiSection = (WidgetServerSettingsEmojis$Item$EmojiSection) other;
        return this.emojiMax == widgetServerSettingsEmojis$Item$EmojiSection.emojiMax && this.emojiLength == widgetServerSettingsEmojis$Item$EmojiSection.emojiLength && this.titleId == widgetServerSettingsEmojis$Item$EmojiSection.titleId;
    }

    public final int getEmojiLength() {
        return this.emojiLength;
    }

    public final int getEmojiMax() {
        return this.emojiMax;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        return (((this.emojiMax * 31) + this.emojiLength) * 31) + this.titleId;
    }

    public String toString() {
        StringBuilder sbU = a.U("EmojiSection(emojiMax=");
        sbU.append(this.emojiMax);
        sbU.append(", emojiLength=");
        sbU.append(this.emojiLength);
        sbU.append(", titleId=");
        return a.B(sbU, this.titleId, ")");
    }
}
