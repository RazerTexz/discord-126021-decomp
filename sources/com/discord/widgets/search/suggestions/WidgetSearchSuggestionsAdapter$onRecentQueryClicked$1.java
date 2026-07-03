package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.query.node.QueryNode;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1 extends AbstractC12240o implements Function1<List<? extends QueryNode>, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1();

    public WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
        invoke2(list);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends QueryNode> list) {
        C12238m.checkNotNullParameter(list, "it");
    }
}
