package com.discord.widgets.chat.managereactions;

import android.view.View;
import android.view.View$OnClickListener;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ManageReactionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ ManageReactionsEmojisAdapter$ReactionEmojiItem $data;
    public final /* synthetic */ ManageReactionsEmojisAdapter$ReactionEmojiViewHolder this$0;

    public ManageReactionsEmojisAdapter$ReactionEmojiViewHolder$onConfigure$1(ManageReactionsEmojisAdapter$ReactionEmojiViewHolder manageReactionsEmojisAdapter$ReactionEmojiViewHolder, ManageReactionsEmojisAdapter$ReactionEmojiItem manageReactionsEmojisAdapter$ReactionEmojiItem) {
        this.this$0 = manageReactionsEmojisAdapter$ReactionEmojiViewHolder;
        this.$data = manageReactionsEmojisAdapter$ReactionEmojiItem;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function1<String, Unit> onEmojiSelectedListener = ManageReactionsEmojisAdapter$ReactionEmojiViewHolder.access$getAdapter$p(this.this$0).getOnEmojiSelectedListener();
        if (onEmojiSelectedListener != null) {
            onEmojiSelectedListener.invoke(this.$data.getReaction().getEmoji().c());
        }
    }
}
