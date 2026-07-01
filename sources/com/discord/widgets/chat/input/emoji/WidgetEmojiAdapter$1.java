package com.discord.widgets.chat.input.emoji;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$1 extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ WidgetEmojiAdapter this$0;

    public WidgetEmojiAdapter$1(WidgetEmojiAdapter widgetEmojiAdapter) {
        this.this$0 = widgetEmojiAdapter;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup
    public int getSpanSize(int position) {
        int itemViewType = this.this$0.getItemViewType(position);
        if (itemViewType == 0 || itemViewType == 2) {
            return this.this$0.getNumColumns();
        }
        return 1;
    }
}
