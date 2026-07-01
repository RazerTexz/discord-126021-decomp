package com.discord.widgets.search.results;

import com.discord.stores.StoreStream;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSearchResults.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchResults$Model$Companion {
    private WidgetSearchResults$Model$Companion() {
    }

    public final Observable<WidgetSearchResults$Model> get() {
        Observable observableR = StoreStream.Companion.getSearch().getStoreSearchQuery().getState().Y(WidgetSearchResults$Model$Companion$get$1.INSTANCE).r();
        m.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
        return ObservableExtensionsKt.computationLatest(observableR);
    }

    public /* synthetic */ WidgetSearchResults$Model$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
