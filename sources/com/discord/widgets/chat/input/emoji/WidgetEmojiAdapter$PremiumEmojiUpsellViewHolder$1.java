package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEmojiAdapter $adapter;

    public WidgetEmojiAdapter$PremiumEmojiUpsellViewHolder$1(WidgetEmojiAdapter widgetEmojiAdapter) {
        this.$adapter = widgetEmojiAdapter;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEmojiAdapter.access$getOnGetPremiumCtaClicked$p(this.$adapter).invoke();
    }
}
