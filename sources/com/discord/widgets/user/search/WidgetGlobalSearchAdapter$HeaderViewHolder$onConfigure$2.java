package com.discord.widgets.user.search;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel$ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter$HeaderViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$2(WidgetGlobalSearchAdapter$HeaderViewHolder widgetGlobalSearchAdapter$HeaderViewHolder, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload) {
        super(1);
        this.this$0 = widgetGlobalSearchAdapter$HeaderViewHolder;
        this.$position = i;
        this.$data = widgetGlobalSearchModel$ItemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "view");
        WidgetGlobalSearchAdapter$HeaderViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener().invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.TRUE);
    }
}
