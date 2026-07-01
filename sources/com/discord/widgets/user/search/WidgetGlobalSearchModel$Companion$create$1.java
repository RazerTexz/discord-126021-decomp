package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$1 extends o implements Function1<WidgetGlobalSearchModel$SearchContext, Long> {
    public static final WidgetGlobalSearchModel$Companion$create$1 INSTANCE = new WidgetGlobalSearchModel$Companion$create$1();

    public WidgetGlobalSearchModel$Companion$create$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        m.checkNotNullParameter(widgetGlobalSearchModel$SearchContext, "it");
        return 0L;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        return Long.valueOf(invoke2(widgetGlobalSearchModel$SearchContext));
    }
}
