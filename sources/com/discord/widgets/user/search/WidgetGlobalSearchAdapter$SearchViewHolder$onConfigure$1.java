package com.discord.widgets.user.search;

import android.view.View;
import android.view.View$OnClickListener;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter$SearchViewHolder this$0;

    public WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1(WidgetGlobalSearchAdapter$SearchViewHolder widgetGlobalSearchAdapter$SearchViewHolder, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        this.this$0 = widgetGlobalSearchAdapter$SearchViewHolder;
        this.$position = i;
        this.$data = widgetGlobalSearchModel$ItemDataPayload;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        Function4<View, Integer, WidgetGlobalSearchModel$ItemDataPayload, Boolean, Unit> onSelectedListener = WidgetGlobalSearchAdapter$SearchViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener();
        m.checkNotNullExpressionValue(view, "view");
        onSelectedListener.invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.FALSE);
    }
}
