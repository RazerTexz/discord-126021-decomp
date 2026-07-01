package com.discord.widgets.chat.list.actions;


/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiItem$MoreEmoji extends EmojiItem {
    public static final EmojiItem$MoreEmoji INSTANCE;
    private static final String key;

    static {
        EmojiItem$MoreEmoji emojiItem$MoreEmoji = new EmojiItem$MoreEmoji();
        INSTANCE = emojiItem$MoreEmoji;
        key = String.valueOf(emojiItem$MoreEmoji.getType());
    }

    private EmojiItem$MoreEmoji() {
        super(1, null);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return key;
    }
}
