package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onHasClicked$1 extends AbstractC12240o implements Function1<HasAnswerOption, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onHasClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onHasClicked$1();

    public WidgetSearchSuggestionsAdapter$onHasClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HasAnswerOption hasAnswerOption) {
        invoke2(hasAnswerOption);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HasAnswerOption hasAnswerOption) {
        C12238m.checkNotNullParameter(hasAnswerOption, "it");
    }
}
