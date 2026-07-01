package com.discord.widgets.servers;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.models.domain.emoji.ModelEmojiGuild;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetServerSettingsEmojis.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetServerSettingsEmojis$Item $data;
    public final /* synthetic */ WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder this$0;

    public WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder$onConfigure$1(WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder widgetServerSettingsEmojis$Adapter$EmojiItemViewHolder, WidgetServerSettingsEmojis$Item widgetServerSettingsEmojis$Item) {
        this.this$0 = widgetServerSettingsEmojis$Adapter$EmojiItemViewHolder;
        this.$data = widgetServerSettingsEmojis$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function2<View, ModelEmojiGuild, Unit> onEmojiItemClicked = WidgetServerSettingsEmojis$Adapter$EmojiItemViewHolder.access$getAdapter$p(this.this$0).getOnEmojiItemClicked();
        m.checkNotNullExpressionValue(view, "it");
        onEmojiItemClicked.invoke(view, ((WidgetServerSettingsEmojis$Item$EmojiItem) this.$data).getEmoji());
    }
}
