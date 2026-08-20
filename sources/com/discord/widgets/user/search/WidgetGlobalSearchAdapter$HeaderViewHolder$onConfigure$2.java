package com.discord.widgets.user.search;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2 extends AbstractC12240o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter.HeaderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2(WidgetGlobalSearchAdapter.HeaderViewHolder headerViewHolder, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        super(1);
        this.this$0 = headerViewHolder;
        this.$position = i;
        this.$data = itemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        C12238m.checkNotNullParameter(view, "view");
        WidgetGlobalSearchAdapter.HeaderViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener().invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.TRUE);
    }
}
