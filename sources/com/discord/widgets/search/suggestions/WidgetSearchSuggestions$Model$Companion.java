package com.discord.widgets.search.suggestions;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.search.strings.SearchStringProvider;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSearchSuggestions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestions$Model$Companion {
    private WidgetSearchSuggestions$Model$Companion() {
    }

    public final Observable<WidgetSearchSuggestions$Model> get(SearchStringProvider searchStringProvider) {
        m.checkNotNullParameter(searchStringProvider, "searchStringProvider");
        StoreStream$Companion storeStream$Companion = StoreStream.Companion;
        Observable observableI = Observable.i(storeStream$Companion.getSearch().getStoreSearchData().get(), storeStream$Companion.getSearch().getStoreSearchInput().getCurrentParsedInput(), storeStream$Companion.getSearch().getHistory(), new WidgetSearchSuggestions$Model$Companion$get$1(searchStringProvider));
        m.checkNotNullExpressionValue(observableI, "Observable.combineLatest…gestionEntries)\n        }");
        Observable<WidgetSearchSuggestions$Model> observableR = ObservableExtensionsKt.computationLatest(observableI).r();
        m.checkNotNullExpressionValue(observableR, "Observable.combineLatest…().distinctUntilChanged()");
        return observableR;
    }

    public /* synthetic */ WidgetSearchSuggestions$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
