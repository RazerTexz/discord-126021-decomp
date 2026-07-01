package com.discord.widgets.chat.input.gifpicker;

import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GifSearchViewModel$StoreState {
    private final List<String> trendingSearchTerms;

    private GifSearchViewModel$StoreState(List<String> list) {
        this.trendingSearchTerms = list;
    }

    public final List<String> getTrendingSearchTerms() {
        return this.trendingSearchTerms;
    }

    public /* synthetic */ GifSearchViewModel$StoreState(List list, DefaultConstructorMarker defaultConstructorMarker) {
        this(list);
    }
}
