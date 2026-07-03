package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$1 extends AbstractC12240o implements Function1<WidgetGlobalSearchModel.SearchContext, Long> {
    public static final WidgetGlobalSearchModel$Companion$create$1 INSTANCE = new WidgetGlobalSearchModel$Companion$create$1();

    public WidgetGlobalSearchModel$Companion$create$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(WidgetGlobalSearchModel.SearchContext searchContext) {
        C12238m.checkNotNullParameter(searchContext, "it");
        return 0L;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(WidgetGlobalSearchModel.SearchContext searchContext) {
        return Long.valueOf(invoke2(searchContext));
    }
}
