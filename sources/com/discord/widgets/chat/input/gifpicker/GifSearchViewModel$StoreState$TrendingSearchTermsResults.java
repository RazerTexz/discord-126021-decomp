package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifSearchViewModel$StoreState$TrendingSearchTermsResults extends GifSearchViewModel$StoreState {
    private final List<String> trending;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel$StoreState$TrendingSearchTermsResults(List<String> list) {
        super(list, null);
        m.checkNotNullParameter(list, "trending");
        this.trending = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifSearchViewModel$StoreState$TrendingSearchTermsResults copy$default(GifSearchViewModel$StoreState$TrendingSearchTermsResults gifSearchViewModel$StoreState$TrendingSearchTermsResults, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifSearchViewModel$StoreState$TrendingSearchTermsResults.trending;
        }
        return gifSearchViewModel$StoreState$TrendingSearchTermsResults.copy(list);
    }

    public final List<String> component1() {
        return this.trending;
    }

    public final GifSearchViewModel$StoreState$TrendingSearchTermsResults copy(List<String> trending) {
        m.checkNotNullParameter(trending, "trending");
        return new GifSearchViewModel$StoreState$TrendingSearchTermsResults(trending);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifSearchViewModel$StoreState$TrendingSearchTermsResults) && m.areEqual(this.trending, ((GifSearchViewModel$StoreState$TrendingSearchTermsResults) other).trending);
        }
        return true;
    }

    public final List<String> getTrending() {
        return this.trending;
    }

    public int hashCode() {
        List<String> list = this.trending;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("TrendingSearchTermsResults(trending="), this.trending, ")");
    }
}
