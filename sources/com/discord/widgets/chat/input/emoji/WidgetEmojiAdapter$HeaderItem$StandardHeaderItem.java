package com.discord.widgets.chat.input.emoji;

import b.d.b.a.a;
import com.discord.models.domain.emoji.EmojiCategory;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetEmojiAdapter$HeaderItem$StandardHeaderItem extends WidgetEmojiAdapter$HeaderItem {
    private final EmojiCategory emojiCategory;
    private final String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$HeaderItem$StandardHeaderItem(EmojiCategory emojiCategory) {
        super(null);
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        this.emojiCategory = emojiCategory;
        this.key = emojiCategory.name();
    }

    public static /* synthetic */ WidgetEmojiAdapter$HeaderItem$StandardHeaderItem copy$default(WidgetEmojiAdapter$HeaderItem$StandardHeaderItem widgetEmojiAdapter$HeaderItem$StandardHeaderItem, EmojiCategory emojiCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            emojiCategory = widgetEmojiAdapter$HeaderItem$StandardHeaderItem.emojiCategory;
        }
        return widgetEmojiAdapter$HeaderItem$StandardHeaderItem.copy(emojiCategory);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final EmojiCategory getEmojiCategory() {
        return this.emojiCategory;
    }

    public final WidgetEmojiAdapter$HeaderItem$StandardHeaderItem copy(EmojiCategory emojiCategory) {
        m.checkNotNullParameter(emojiCategory, "emojiCategory");
        return new WidgetEmojiAdapter$HeaderItem$StandardHeaderItem(emojiCategory);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetEmojiAdapter$HeaderItem$StandardHeaderItem) && m.areEqual(this.emojiCategory, ((WidgetEmojiAdapter$HeaderItem$StandardHeaderItem) other).emojiCategory);
        }
        return true;
    }

    public final EmojiCategory getEmojiCategory() {
        return this.emojiCategory;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public int hashCode() {
        EmojiCategory emojiCategory = this.emojiCategory;
        if (emojiCategory != null) {
            return emojiCategory.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("StandardHeaderItem(emojiCategory=");
        sbU.append(this.emojiCategory);
        sbU.append(")");
        return sbU.toString();
    }
}
