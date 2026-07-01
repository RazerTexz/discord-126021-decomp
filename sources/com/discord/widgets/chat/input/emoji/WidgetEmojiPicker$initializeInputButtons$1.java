package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$initializeInputButtons$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    public WidgetEmojiPicker$initializeInputButtons$1(WidgetEmojiPicker widgetEmojiPicker) {
        this.this$0 = widgetEmojiPicker;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetEmojiPicker.access$setNextCategoryScrollSmooth$p(this.this$0, false);
        WidgetEmojiPicker.access$getViewModel$p(this.this$0).onClickUnicodeEmojiCategories();
    }
}
