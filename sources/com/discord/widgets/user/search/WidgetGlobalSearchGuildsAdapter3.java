package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchGuildsModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchGuildsAdapter$Item$onConfigure$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalSearchGuildsAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsAdapter3 extends Lambda implements Function1<View, Unit> {
    public final /* synthetic */ WidgetGlobalSearchGuildsModel.Item $data;
    public final /* synthetic */ int $position;
    public final /* synthetic */ WidgetGlobalSearchGuildsAdapter.Item this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchGuildsAdapter3(WidgetGlobalSearchGuildsAdapter.Item item, int i, WidgetGlobalSearchGuildsModel.Item item2) {
        super(1);
        this.this$0 = item;
        this.$position = i;
        this.$data = item2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        Intrinsics3.checkNotNullParameter(view, "it");
        WidgetGlobalSearchGuildsAdapter.Item.access$getAdapter$p(this.this$0).getOnLongClickListener().invoke(Integer.valueOf(this.this$0.getItemViewType()), Integer.valueOf(this.$position), this.$data);
    }
}
