package com.discord.widgets.search.suggestions;

import com.discord.stores.StoreStream;
import com.discord.utilities.search.query.node.QueryNode;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$configureUI$5 extends o implements Function1<List<? extends QueryNode>, Unit> {
    public static final WidgetSearchSuggestions$configureUI$5 INSTANCE = new WidgetSearchSuggestions$configureUI$5();

    public WidgetSearchSuggestions$configureUI$5() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends QueryNode> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends QueryNode> list) {
        m.checkNotNullParameter(list, "queryNodes");
        StoreStream.Companion.getSearch().getStoreSearchInput().onQueryClicked(list);
    }
}
