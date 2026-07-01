package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.emoji.Emoji;
import com.discord.stores.StoreStream;
import d0.k;
import d0.k$a;
import d0.l;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ Emoji $emoji;
    public final /* synthetic */ WidgetEmojiAdapter$EmojiViewHolder this$0;

    public WidgetEmojiAdapter$EmojiViewHolder$onConfigure$1(WidgetEmojiAdapter$EmojiViewHolder widgetEmojiAdapter$EmojiViewHolder, Emoji emoji) {
        this.this$0 = widgetEmojiAdapter$EmojiViewHolder;
        this.$emoji = emoji;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        if (this.$emoji.isUsable() && this.$emoji.isAvailable()) {
            StoreStream.Companion.getEmojis().onEmojiUsed(this.$emoji);
        }
        WidgetEmojiAdapter.access$getOnEmojiSelectedListener$p(WidgetEmojiAdapter$EmojiViewHolder.access$getAdapter$p(this.this$0)).onEmojiSelected(this.$emoji);
        WidgetEmojiAdapter$EmojiViewHolder widgetEmojiAdapter$EmojiViewHolder = this.this$0;
        try {
            k$a k_a = k.j;
            k.m97constructorimpl(Boolean.valueOf(WidgetEmojiAdapter$EmojiViewHolder.access$getBinding$p(widgetEmojiAdapter$EmojiViewHolder).f2101b.performHapticFeedback(3)));
        } catch (Throwable th) {
            k$a k_a2 = k.j;
            k.m97constructorimpl(l.createFailure(th));
        }
    }
}
