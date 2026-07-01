package com.discord.widgets.chat.input.gifpicker;

import androidx.core.app.NotificationCompat;
import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.m;
import java.util.List;
import rx.functions.Func2;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GifSearchViewModel$Companion$observeQueryState$2$2<T1, T2, R> implements Func2<List<? extends ModelGif>, List<? extends String>, GifSearchViewModel$StoreState$SearchResults> {
    public final /* synthetic */ String $query;
    public final /* synthetic */ GifSearchViewModel$Companion$observeQueryState$2 this$0;

    public GifSearchViewModel$Companion$observeQueryState$2$2(GifSearchViewModel$Companion$observeQueryState$2 gifSearchViewModel$Companion$observeQueryState$2, String str) {
        this.this$0 = gifSearchViewModel$Companion$observeQueryState$2;
        this.$query = str;
    }

    @Override // rx.functions.Func2
    public /* bridge */ /* synthetic */ GifSearchViewModel$StoreState$SearchResults call(List<? extends ModelGif> list, List<? extends String> list2) {
        return call2((List<ModelGif>) list, (List<String>) list2);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GifSearchViewModel$StoreState$SearchResults call2(List<ModelGif> list, List<String> list2) {
        m.checkNotNullExpressionValue(list, "gifResults");
        m.checkNotNullExpressionValue(list2, "searchTerms");
        return new GifSearchViewModel$StoreState$SearchResults(list, list2, this.this$0.$trendingSearchTerms, this.$query);
    }
}
