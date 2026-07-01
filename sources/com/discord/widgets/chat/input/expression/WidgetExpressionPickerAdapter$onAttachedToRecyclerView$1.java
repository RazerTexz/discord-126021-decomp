package com.discord.widgets.chat.input.expression;

import android.view.View;
import android.view.View$OnLayoutChangeListener;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: compiled from: WidgetExpressionPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionPickerAdapter$onAttachedToRecyclerView$1 implements View$OnLayoutChangeListener {
    public final /* synthetic */ RecyclerView $recyclerView;
    public final /* synthetic */ WidgetExpressionPickerAdapter this$0;

    public WidgetExpressionPickerAdapter$onAttachedToRecyclerView$1(WidgetExpressionPickerAdapter widgetExpressionPickerAdapter, RecyclerView recyclerView) {
        this.this$0 = widgetExpressionPickerAdapter;
        this.$recyclerView = recyclerView;
    }

    @Override // android.view.View$OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        this.this$0.getStickyHeaderManager().layoutViews(this.$recyclerView);
    }
}
