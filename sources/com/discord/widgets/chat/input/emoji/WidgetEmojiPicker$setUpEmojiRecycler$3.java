package com.discord.widgets.chat.input.emoji;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetEmojiPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiPicker$setUpEmojiRecycler$3 extends RecyclerView$OnScrollListener {
    public final /* synthetic */ WidgetEmojiPicker this$0;

    public WidgetEmojiPicker$setUpEmojiRecycler$3(WidgetEmojiPicker widgetEmojiPicker) {
        this.this$0 = widgetEmojiPicker;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        WidgetEmojiPicker.access$checkUpsellHeaderVisibility(this.this$0, recyclerView);
    }
}
