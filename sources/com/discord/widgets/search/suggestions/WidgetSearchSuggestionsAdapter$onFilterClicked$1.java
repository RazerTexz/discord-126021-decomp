package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.FilterType;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onFilterClicked$1 extends AbstractC12240o implements Function1<FilterType, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onFilterClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onFilterClicked$1();

    public WidgetSearchSuggestionsAdapter$onFilterClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(FilterType filterType) {
        invoke2(filterType);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(FilterType filterType) {
        C12238m.checkNotNullParameter(filterType, "it");
    }
}
