package com.discord.widgets.user.search;

import android.text.Editable;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$onViewBound$1 extends o implements Function1<Editable, Unit> {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$onViewBound$1(WidgetGlobalSearch widgetGlobalSearch) {
        super(1);
        this.this$0 = widgetGlobalSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Editable editable) {
        invoke2(editable);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Editable editable) {
        m.checkNotNullParameter(editable, "editable");
        WidgetGlobalSearch.access$getFilterPublisher$p(this.this$0).onNext(editable.toString());
    }
}
