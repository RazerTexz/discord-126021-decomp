package com.discord.widgets.search.suggestions;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$configureUI$2 extends o implements Function1<UserSuggestion, Unit> {
    public final /* synthetic */ WidgetSearchSuggestions$Model $model;
    public final /* synthetic */ WidgetSearchSuggestions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestions$configureUI$2(WidgetSearchSuggestions widgetSearchSuggestions, WidgetSearchSuggestions$Model widgetSearchSuggestions$Model) {
        super(1);
        this.this$0 = widgetSearchSuggestions;
        this.$model = widgetSearchSuggestions$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(UserSuggestion userSuggestion) {
        invoke2(userSuggestion);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(UserSuggestion userSuggestion) {
        m.checkNotNullParameter(userSuggestion, "userSuggestion");
        int iOrdinal = userSuggestion.getTargetType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal != 1) {
                return;
            }
            StoreStream.Companion.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(this.this$0).getMentionsFilterString(), this.$model.getQuery());
        } else {
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            storeStream$Companion.getSearch().getStoreSearchInput().onFromUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(this.this$0).getFromFilterString(), this.$model.getQuery());
            storeStream$Companion.getSearch().getStoreSearchInput().onMentionsUserClicked(userSuggestion, WidgetSearchSuggestions.access$getSearchStringProvider$p(this.this$0).getMentionsFilterString(), this.$model.getQuery());
        }
    }
}
