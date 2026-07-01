package com.discord.widgets.search.suggestions;

import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter$onChannelClicked$1 extends Lambda implements Function1<ChannelSuggestion, Unit> {
    public static final WidgetSearchSuggestionsAdapter$onChannelClicked$1 INSTANCE = new WidgetSearchSuggestionsAdapter$onChannelClicked$1();

    public WidgetSearchSuggestionsAdapter$onChannelClicked$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
        invoke2(channelSuggestion);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelSuggestion channelSuggestion) {
        Intrinsics3.checkNotNullParameter(channelSuggestion, "it");
    }
}
