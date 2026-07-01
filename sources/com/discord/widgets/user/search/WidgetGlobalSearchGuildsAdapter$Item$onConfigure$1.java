package com.discord.widgets.user.search;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1 implements View$OnClickListener {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel$Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter$Item this$0;

    public WidgetGlobalSearchGuildsAdapter$Item$onConfigure$1(WidgetGlobalSearchGuildsAdapter$Item widgetGlobalSearchGuildsAdapter$Item, int i, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        this.this$0 = widgetGlobalSearchGuildsAdapter$Item;
        this.$position = i;
        this.$data = widgetGlobalSearchGuildsModel$Item;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetGlobalSearchGuildsAdapter$Item.access$getAdapter$p(this.this$0).getOnClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
