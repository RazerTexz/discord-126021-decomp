package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1<T> implements Comparator {
    public final /* synthetic */ WidgetGlobalSearchModel$SearchContext $searchContext$inlined;

    public WidgetGlobalSearchModel$Companion$create$$inlined$sortedByDescending$1(WidgetGlobalSearchModel$SearchContext widgetGlobalSearchModel$SearchContext) {
        this.$searchContext$inlined = widgetGlobalSearchModel$SearchContext;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        WidgetGlobalSearchScoreStrategy widgetGlobalSearchScoreStrategy = WidgetGlobalSearchScoreStrategy.INSTANCE;
        return a.compareValues(Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel$ItemDataPayload) t2, this.$searchContext$inlined.getSearchType(), this.$searchContext$inlined.getFrecencyChannels())), Integer.valueOf(widgetGlobalSearchScoreStrategy.score((WidgetGlobalSearchModel$ItemDataPayload) t, this.$searchContext$inlined.getSearchType(), this.$searchContext$inlined.getFrecencyChannels())));
    }
}
