package com.discord.widgets.chat.input.gifpicker;

import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreGifPicker;
import com.discord.utilities.rx.LeadingEdgeThrottle;
import d0.z.d.m;
import j0.l.a.r;
import j0.p.a;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$Companion {
    private GifSearchViewModel$Companion() {
    }

    public static final /* synthetic */ Observable access$observeQueryState(GifSearchViewModel$Companion gifSearchViewModel$Companion, BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker, List list) {
        return gifSearchViewModel$Companion.observeQueryState(behaviorSubject, storeAnalytics, storeGifPicker, list);
    }

    public static final /* synthetic */ Observable access$observeStoreState(GifSearchViewModel$Companion gifSearchViewModel$Companion, BehaviorSubject behaviorSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
        return gifSearchViewModel$Companion.observeStoreState(behaviorSubject, storeAnalytics, storeGifPicker);
    }

    private final Observable<GifSearchViewModel$StoreState> observeQueryState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker, List<String> trendingSearchTerms) {
        Observable<String> observableR = searchSubject.J(a.c()).r();
        Observable<GifSearchViewModel$StoreState> observableY = Observable.h0(new r(observableR.j, new LeadingEdgeThrottle(1000L, TimeUnit.MILLISECONDS, a.c()))).u(new GifSearchViewModel$Companion$observeQueryState$1(storeAnalytics)).Y(new GifSearchViewModel$Companion$observeQueryState$2(trendingSearchTerms, storeGifPicker));
        m.checkNotNullExpressionValue(observableY, "searchSubject\n          …          }\n            }");
        return observableY;
    }

    private final Observable<GifSearchViewModel$StoreState> observeStoreState(BehaviorSubject<String> searchSubject, StoreAnalytics storeAnalytics, StoreGifPicker storeGifPicker) {
        Observable observableY = storeGifPicker.observeGifTrendingSearchTerms().Y(new GifSearchViewModel$Companion$observeStoreState$1(searchSubject, storeAnalytics, storeGifPicker));
        m.checkNotNullExpressionValue(observableY, "storeGifPicker.observeGi…fPicker, terms)\n        }");
        return observableY;
    }

    public /* synthetic */ GifSearchViewModel$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
