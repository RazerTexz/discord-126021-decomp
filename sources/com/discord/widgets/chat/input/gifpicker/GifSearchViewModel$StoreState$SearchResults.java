package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifSearchViewModel$StoreState$SearchResults extends GifSearchViewModel$StoreState {
    private final List<ModelGif> gifs;
    private final String searchQuery;
    private final List<String> suggested;
    private final List<String> trending;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifSearchViewModel$StoreState$SearchResults(List<ModelGif> list, List<String> list2, List<String> list3, String str) {
        super(list3, null);
        m.checkNotNullParameter(list, "gifs");
        m.checkNotNullParameter(list2, "suggested");
        m.checkNotNullParameter(list3, "trending");
        this.gifs = list;
        this.suggested = list2;
        this.trending = list3;
        this.searchQuery = str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifSearchViewModel$StoreState$SearchResults copy$default(GifSearchViewModel$StoreState$SearchResults gifSearchViewModel$StoreState$SearchResults, List list, List list2, List list3, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifSearchViewModel$StoreState$SearchResults.gifs;
        }
        if ((i & 2) != 0) {
            list2 = gifSearchViewModel$StoreState$SearchResults.suggested;
        }
        if ((i & 4) != 0) {
            list3 = gifSearchViewModel$StoreState$SearchResults.trending;
        }
        if ((i & 8) != 0) {
            str = gifSearchViewModel$StoreState$SearchResults.searchQuery;
        }
        return gifSearchViewModel$StoreState$SearchResults.copy(list, list2, list3, str);
    }

    public final List<ModelGif> component1() {
        return this.gifs;
    }

    public final List<String> component2() {
        return this.suggested;
    }

    public final List<String> component3() {
        return this.trending;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final GifSearchViewModel$StoreState$SearchResults copy(List<ModelGif> gifs, List<String> suggested, List<String> trending, String searchQuery) {
        m.checkNotNullParameter(gifs, "gifs");
        m.checkNotNullParameter(suggested, "suggested");
        m.checkNotNullParameter(trending, "trending");
        return new GifSearchViewModel$StoreState$SearchResults(gifs, suggested, trending, searchQuery);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifSearchViewModel$StoreState$SearchResults)) {
            return false;
        }
        GifSearchViewModel$StoreState$SearchResults gifSearchViewModel$StoreState$SearchResults = (GifSearchViewModel$StoreState$SearchResults) other;
        return m.areEqual(this.gifs, gifSearchViewModel$StoreState$SearchResults.gifs) && m.areEqual(this.suggested, gifSearchViewModel$StoreState$SearchResults.suggested) && m.areEqual(this.trending, gifSearchViewModel$StoreState$SearchResults.trending) && m.areEqual(this.searchQuery, gifSearchViewModel$StoreState$SearchResults.searchQuery);
    }

    public final List<ModelGif> getGifs() {
        return this.gifs;
    }

    public final String getSearchQuery() {
        return this.searchQuery;
    }

    public final List<String> getSuggested() {
        return this.suggested;
    }

    public final List<String> getTrending() {
        return this.trending;
    }

    public int hashCode() {
        List<ModelGif> list = this.gifs;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        List<String> list2 = this.suggested;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<String> list3 = this.trending;
        int iHashCode3 = (iHashCode2 + (list3 != null ? list3.hashCode() : 0)) * 31;
        String str = this.searchQuery;
        return iHashCode3 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SearchResults(gifs=");
        sbU.append(this.gifs);
        sbU.append(", suggested=");
        sbU.append(this.suggested);
        sbU.append(", trending=");
        sbU.append(this.trending);
        sbU.append(", searchQuery=");
        return a.J(sbU, this.searchQuery, ")");
    }
}
