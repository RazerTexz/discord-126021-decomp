package com.discord.widgets.chat.input.emoji;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetEmojiAdapter$HeaderItem$StringHeaderItem extends WidgetEmojiAdapter$HeaderItem {
    private final String key;
    private final int stringRes;

    public WidgetEmojiAdapter$HeaderItem$StringHeaderItem(@StringRes int i) {
        super(null);
        this.stringRes = i;
        this.key = String.valueOf(i);
    }

    public static /* synthetic */ WidgetEmojiAdapter$HeaderItem$StringHeaderItem copy$default(WidgetEmojiAdapter$HeaderItem$StringHeaderItem widgetEmojiAdapter$HeaderItem$StringHeaderItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = widgetEmojiAdapter$HeaderItem$StringHeaderItem.stringRes;
        }
        return widgetEmojiAdapter$HeaderItem$StringHeaderItem.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringRes() {
        return this.stringRes;
    }

    public final WidgetEmojiAdapter$HeaderItem$StringHeaderItem copy(@StringRes int stringRes) {
        return new WidgetEmojiAdapter$HeaderItem$StringHeaderItem(stringRes);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetEmojiAdapter$HeaderItem$StringHeaderItem) && this.stringRes == ((WidgetEmojiAdapter$HeaderItem$StringHeaderItem) other).stringRes;
        }
        return true;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final int getStringRes() {
        return this.stringRes;
    }

    public int hashCode() {
        return this.stringRes;
    }

    public String toString() {
        return a.B(a.U("StringHeaderItem(stringRes="), this.stringRes, ")");
    }
}
