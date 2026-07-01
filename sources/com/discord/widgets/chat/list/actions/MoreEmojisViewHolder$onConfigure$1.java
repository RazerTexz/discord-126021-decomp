package com.discord.widgets.chat.list.actions;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetChatListActionsEmojisAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MoreEmojisViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ MoreEmojisViewHolder this$0;

    public MoreEmojisViewHolder$onConfigure$1(MoreEmojisViewHolder moreEmojisViewHolder) {
        this.this$0 = moreEmojisViewHolder;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        MoreEmojisViewHolder.access$getAdapter$p(this.this$0).getOnClickMoreEmojis().invoke();
    }
}
