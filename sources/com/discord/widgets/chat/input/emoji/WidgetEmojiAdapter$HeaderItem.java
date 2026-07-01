package com.discord.widgets.chat.input.emoji;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class WidgetEmojiAdapter$HeaderItem implements MGRecyclerDataPayload {
    private final int type;

    private WidgetEmojiAdapter$HeaderItem() {
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ WidgetEmojiAdapter$HeaderItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
