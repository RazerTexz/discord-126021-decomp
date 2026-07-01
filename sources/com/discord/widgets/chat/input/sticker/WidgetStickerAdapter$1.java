package com.discord.widgets.chat.input.sticker;

import androidx.recyclerview.widget.GridLayoutManager$SpanSizeLookup;
import com.discord.models.domain.ModelAuditLogEntry;

/* JADX INFO: compiled from: WidgetStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStickerAdapter$1 extends GridLayoutManager$SpanSizeLookup {
    public final /* synthetic */ WidgetStickerAdapter this$0;

    public WidgetStickerAdapter$1(WidgetStickerAdapter widgetStickerAdapter) {
        this.this$0 = widgetStickerAdapter;
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
