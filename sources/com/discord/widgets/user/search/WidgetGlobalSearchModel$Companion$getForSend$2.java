package com.discord.widgets.user.search;

import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getForSend$2 extends Lambda implements Function1<WidgetGlobalSearchModel.SearchContext, Long> {
    public static final WidgetGlobalSearchModel$Companion$getForSend$2 INSTANCE = new WidgetGlobalSearchModel$Companion$getForSend$2();

    public WidgetGlobalSearchModel$Companion$getForSend$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Long invoke(WidgetGlobalSearchModel.SearchContext searchContext) {
        return Long.valueOf(invoke2(searchContext));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2(WidgetGlobalSearchModel.SearchContext searchContext) {
        Intrinsics3.checkNotNullParameter(searchContext, "it");
        return searchContext.getSelectedChannelId();
    }
}
