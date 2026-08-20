package com.discord.widgets.user.search;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel.Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter.Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2(WidgetGlobalSearchGuildsAdapter.Item item, int i, WidgetGlobalSearchGuildsModel.Item item2) {
        super(1);
        this.this$0 = item;
        this.$position = i;
        this.$data = item2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "it");
        WidgetGlobalSearchGuildsAdapter.Item.access$getAdapter$p(this.this$0).getOnLongClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
