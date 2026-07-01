package com.discord.widgets.chat.input.emoji;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$UpsellItem implements MGRecyclerDataPayload {
    private static final String key;
    public static final WidgetEmojiAdapter$UpsellItem INSTANCE = new WidgetEmojiAdapter$UpsellItem();
    private static final int type = 2;

    static {
        String name = WidgetEmojiAdapter$UpsellItem.class.getName();
        m.checkNotNullExpressionValue(name, "javaClass.name");
        key = name;
    }

    private WidgetEmojiAdapter$UpsellItem() {
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return type;
    }
}
