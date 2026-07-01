package com.discord.widgets.chat.input.expression;

import android.view.View;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface WidgetExpressionPickerAdapter$StickyHeaderViewHolder {
    void bind(int position, MGRecyclerDataPayload data);

    View getItemView();
}
