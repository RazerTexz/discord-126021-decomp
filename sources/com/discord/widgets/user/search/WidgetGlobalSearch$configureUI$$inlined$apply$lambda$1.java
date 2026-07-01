package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$configureUI$$inlined$apply$lambda$1 extends o implements Function2<List<? extends WidgetGlobalSearchModel$ItemDataPayload>, List<? extends WidgetGlobalSearchModel$ItemDataPayload>, Unit> {
    public final /* synthetic */ WidgetGlobalSearchModel $model$inlined;
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$configureUI$$inlined$apply$lambda$1(WidgetGlobalSearch widgetGlobalSearch, WidgetGlobalSearchModel widgetGlobalSearchModel) {
        super(2);
        this.this$0 = widgetGlobalSearch;
        this.$model$inlined = widgetGlobalSearchModel;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends WidgetGlobalSearchModel$ItemDataPayload> list, List<? extends WidgetGlobalSearchModel$ItemDataPayload> list2) {
        invoke2(list, list2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends WidgetGlobalSearchModel$ItemDataPayload> list, List<? extends WidgetGlobalSearchModel$ItemDataPayload> list2) {
        m.checkNotNullParameter(list, "<anonymous parameter 0>");
        m.checkNotNullParameter(list2, "<anonymous parameter 1>");
        if (!m.areEqual(WidgetGlobalSearch.access$getFilterString$p(this.this$0), this.$model$inlined.getFilter())) {
            WidgetGlobalSearch.access$getBinding$p(this.this$0).g.scrollToPosition(0);
            WidgetGlobalSearch.access$setFilterString$p(this.this$0, this.$model$inlined.getFilter());
        }
    }
}
