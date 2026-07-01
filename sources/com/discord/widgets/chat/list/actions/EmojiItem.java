package com.discord.widgets.chat.list.actions;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class EmojiItem implements MGRecyclerDataPayload {
    public static final EmojiItem$Companion Companion = new EmojiItem$Companion(null);
    public static final int TYPE_EMOJI = 0;
    public static final int TYPE_MORE_EMOJIS = 1;
    private final int type;

    private EmojiItem(int i) {
        this.type = i;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ EmojiItem(int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(i);
    }
}
