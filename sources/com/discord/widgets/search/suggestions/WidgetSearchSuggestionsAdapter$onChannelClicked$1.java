package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onChannelClicked$1 extends AbstractC12240o implements Function1<ChannelSuggestion, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onChannelClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onChannelClicked$1();

    public WidgetSearchSuggestionsAdapter$onChannelClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
        invoke2(channelSuggestion);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelSuggestion channelSuggestion) {
        C12238m.checkNotNullParameter(channelSuggestion, "it");
    }
}
