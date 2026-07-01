package com.discord.widgets.user.search;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel$Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter$Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2(WidgetGlobalSearchGuildsAdapter$Item widgetGlobalSearchGuildsAdapter$Item, int i, WidgetGlobalSearchGuildsModel$Item widgetGlobalSearchGuildsModel$Item) {
        super(1);
        this.this$0 = widgetGlobalSearchGuildsAdapter$Item;
        this.$position = i;
        this.$data = widgetGlobalSearchGuildsModel$Item;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetGlobalSearchGuildsAdapter$Item.access$getAdapter$p(this.this$0).getOnLongClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
