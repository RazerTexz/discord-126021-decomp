package com.discord.widgets.user.search;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getForSend$2 extends o implements Function1<WidgetGlobalSearchModel$SearchContext, Long> {
    public static final WidgetGlobalSearchModel$Companion$getForSend$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getForSend$2();

    public WidgetGlobalSearchModel$Companion$getForSend$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        return Long.valueOf(invoke2(widgetGlobalSearchModel$SearchContext));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        m.checkNotNullParameter(widgetGlobalSearchModel$SearchContext, "it");
        return widgetGlobalSearchModel$SearchContext.getSelectedChannelId();
    }
}
