package com.discord.widgets.search.suggestions;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$configureUI$6 extends o implements Function0<Unit> {
    public static final WidgetSearchSuggestions$configureUI$6 INSTANCE = new WidgetSearchSuggestions$configureUI$6();

    public WidgetSearchSuggestions$configureUI$6() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getSearch().clearHistory();
    }
}
