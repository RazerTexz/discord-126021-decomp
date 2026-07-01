package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.FilterType;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onFilterClicked$1 extends Lambda implements Function1<FilterType, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onFilterClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onFilterClicked$1();

    public WidgetSearchSuggestionsAdapter$onFilterClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FilterType filterType) {
        invoke2(filterType);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FilterType filterType) {
        Intrinsics3.checkNotNullParameter(filterType, "it");
    }
}
