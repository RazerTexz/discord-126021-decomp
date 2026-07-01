package com.discord.widgets.user.search;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearch.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearch$showFilterPickerDialog$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetGlobalSearch this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearch$showFilterPickerDialog$1(WidgetGlobalSearch widgetGlobalSearch) {
        super(1);
        this.this$0 = widgetGlobalSearch;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        WidgetGlobalSearch.access$setSearchPrefix(this.this$0, String.valueOf(((Character) WidgetGlobalSearch$Companion.access$getFILTER_OPTIONS_LIST$p(WidgetGlobalSearch.Companion)[i].component2()).charValue()));
    }
}
