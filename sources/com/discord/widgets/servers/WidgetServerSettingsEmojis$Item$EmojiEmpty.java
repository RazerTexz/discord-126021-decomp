package com.discord.widgets.servers;


/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Item$EmojiEmpty extends WidgetServerSettingsEmojis$Item {
    public static final WidgetServerSettingsEmojis$Item$EmojiEmpty INSTANCE = new WidgetServerSettingsEmojis$Item$EmojiEmpty();
    private static final int type = 3;
    private static final String key = "EMOJI_EMPTY";

    private WidgetServerSettingsEmojis$Item$EmojiEmpty() {
        super(null);
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
