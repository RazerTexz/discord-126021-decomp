package com.discord.widgets.search.suggestions;

import com.discord.stores.StoreStream;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$configureUI$3 extends o implements Function1<ChannelSuggestion, Unit> {
    public final /* synthetic */ WidgetSearchSuggestions$Model $model;
    public final /* synthetic */ WidgetSearchSuggestions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestions$configureUI$3(WidgetSearchSuggestions widgetSearchSuggestions, WidgetSearchSuggestions$Model widgetSearchSuggestions$Model) {
        super(1);
        this.this$0 = widgetSearchSuggestions;
        this.$model = widgetSearchSuggestions$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ChannelSuggestion channelSuggestion) {
        invoke2(channelSuggestion);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ChannelSuggestion channelSuggestion) {
        m.checkNotNullParameter(channelSuggestion, "channelSuggestion");
        StoreStream.Companion.getSearch().getStoreSearchInput().onInChannelClicked(channelSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(this.this$0).getInFilterString(), this.$model.getQuery());
    }
}
