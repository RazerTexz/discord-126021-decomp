package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onUserClicked$1 extends AbstractC12240o implements Function1<UserSuggestion, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onUserClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onUserClicked$1();

    public WidgetSearchSuggestionsAdapter$onUserClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
        invoke2(userSuggestion);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserSuggestion userSuggestion) {
        C12238m.checkNotNullParameter(userSuggestion, "it");
    }
}
