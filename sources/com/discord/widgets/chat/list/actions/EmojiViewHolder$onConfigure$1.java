package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ EmojiItem $data;
    public final /* synthetic */ EmojiViewHolder this$0;

    public EmojiViewHolder$onConfigure$1(EmojiViewHolder emojiViewHolder, EmojiItem emojiItem) {
        this.this$0 = emojiViewHolder;
        this.$data = emojiItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        EmojiViewHolder.access$getAdapter$p(this.this$0).getOnClickEmoji().invoke(((EmojiItem$EmojiData) this.$data).getEmoji());
    }
}
