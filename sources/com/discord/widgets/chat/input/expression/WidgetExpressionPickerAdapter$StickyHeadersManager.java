package com.discord.widgets.chat.input.expression;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.views.StickyHeaderItemDecoration$LayoutManager;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionPickerAdapter$StickyHeadersManager {
    private final View currentStickyHeaderView;
    private final WidgetExpressionPickerAdapter$StickyHeaderViewHolder stickyHeaderHolder;

    public WidgetExpressionPickerAdapter$StickyHeadersManager(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter) {
        m.checkNotNullParameter(widgetExpressionPickerAdapter, "adapter");
        WidgetExpressionPickerAdapter$StickyHeaderViewHolder widgetExpressionPickerAdapter$StickyHeaderViewHolderCreateStickyHeaderViewHolder = widgetExpressionPickerAdapter.createStickyHeaderViewHolder(widgetExpressionPickerAdapter);
        this.stickyHeaderHolder = widgetExpressionPickerAdapter$StickyHeaderViewHolderCreateStickyHeaderViewHolder;
        this.currentStickyHeaderView = widgetExpressionPickerAdapter$StickyHeaderViewHolderCreateStickyHeaderViewHolder.getItemView();
    }

    public final View getCurrentStickyHeaderView() {
        return this.currentStickyHeaderView;
    }

    public final WidgetExpressionPickerAdapter$StickyHeaderViewHolder getStickyHeaderHolder() {
        return this.stickyHeaderHolder;
    }

    public final void layoutViews(RecyclerView recyclerView) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        View view = this.currentStickyHeaderView;
        if (view != null) {
            StickyHeaderItemDecoration$LayoutManager.layoutHeaderView(recyclerView, view);
        }
    }
}
