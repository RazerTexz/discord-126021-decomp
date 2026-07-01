package com.discord.widgets.user.search;

import android.view.View;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$configureUI$$inlined$apply$lambda$2 extends o implements Function4<View, Integer, WidgetGlobalSearchModel$ItemDataPayload, Boolean, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $model$inlined;
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$configureUI$$inlined$apply$lambda$2(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(4);
        this.this$0 = widgetGlobalSearch;
        this.$model$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(View view, Integer num, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, Boolean bool) {
        invoke(view, num.intValue(), widgetGlobalSearchModel$ItemDataPayload, bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(View view, int i, WidgetGlobalSearchModel$ItemDataPayload widgetGlobalSearchModel$ItemDataPayload, boolean z2) {
        m.checkNotNullParameter(view, "view");
        m.checkNotNullParameter(widgetGlobalSearchModel$ItemDataPayload, "data");
        WidgetGlobalSearch.access$handleOnSelected(this.this$0, this.$model$inlined, view, i, widgetGlobalSearchModel$ItemDataPayload, z2);
    }
}
