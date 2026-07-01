package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter5 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel.ItemDataPayload $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchAdapter.SearchViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter5(WidgetGlobalSearchAdapter.SearchViewHolder searchViewHolder, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload) {
        super(1);
        this.this$0 = searchViewHolder;
        this.$position = i;
        this.$data = itemDataPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        WidgetGlobalSearchAdapter.SearchViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener().invoke(view, Integer.valueOf(this.$position), this.$data, Boolean.TRUE);
    }
}
