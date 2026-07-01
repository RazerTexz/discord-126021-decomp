package com.discord.widgets.user.search;

import androidx.core.app.NotificationCompat;
import d0.z.d.m;
import rx.functions.Func2;

/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$get$searchContextObservable$1<T1, T2, R> implements Func2<String, WidgetGlobalSearchModel$SearchContext, WidgetGlobalSearchModel$SearchContext> {
    public static final WidgetGlobalSearchModel$Companion$get$searchContextObservable$1 INSTANCE = new WidgetGlobalSearchModel$Companion$get$searchContextObservable$1();

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ WidgetGlobalSearchModel$SearchContext call(String str, WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        return call2(str, widgetGlobalSearchModel$SearchContext);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetGlobalSearchModel$SearchContext call2(String str, WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        m.checkNotNullExpressionValue(str, "filterStr");
        return WidgetGlobalSearchModel$SearchContext.copy$default(widgetGlobalSearchModel$SearchContext, str, null, 0L, 0L, 0L, null, null, 126, null);
    }
}
