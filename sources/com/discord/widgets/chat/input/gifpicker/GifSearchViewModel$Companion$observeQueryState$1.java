package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.stores.StoreAnalytics;
import com.discord.utilities.analytics.SearchType;
import rx.functions.Action1;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$Companion$observeQueryState$1<T> implements Action1<String> {
    public final /* synthetic */ StoreAnalytics $storeAnalytics;

    public GifSearchViewModel$Companion$observeQueryState$1(StoreAnalytics storeAnalytics) {
        this.$storeAnalytics = storeAnalytics;
    }

    @Override // rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(String str) {
        call2(str);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final void call2(String str) {
        StoreAnalytics.trackSearchStarted$default(this.$storeAnalytics, SearchType.GIF, null, false, 6, null);
    }
}
