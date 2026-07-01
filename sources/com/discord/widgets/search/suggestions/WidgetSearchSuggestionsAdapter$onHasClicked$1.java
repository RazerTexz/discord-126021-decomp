package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.node.answer.HasNode2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onHasClicked$1 extends Lambda implements Function1<HasNode2, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onHasClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onHasClicked$1();

    public WidgetSearchSuggestionsAdapter$onHasClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HasNode2 hasNode2) {
        invoke2(hasNode2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HasNode2 hasNode2) {
        Intrinsics3.checkNotNullParameter(hasNode2, "it");
    }
}
