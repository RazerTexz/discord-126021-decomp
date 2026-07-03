package com.discord.widgets.user.search;

import android.view.View;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$configureUI$$inlined$apply$lambda$2 extends AbstractC12240o implements Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $model$inlined;
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$configureUI$$inlined$apply$lambda$2(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(4);
        this.this$0 = widgetGlobalSearch;
        this.$model$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), itemDataPayload, bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel.ItemDataPayload itemDataPayload, boolean z2) {
        C12238m.checkNotNullParameter(view, "view");
        C12238m.checkNotNullParameter(itemDataPayload, "data");
        this.this$0.handleOnSelected(this.$model$inlined, view, i, itemDataPayload, z2);
    }
}
