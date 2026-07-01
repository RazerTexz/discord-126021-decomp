package com.discord.stores;

import com.discord.models.gifpicker.dto.ModelGif;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: StoreGifPicker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGifPicker$Companion {
    private StoreGifPicker$Companion() {
    }

    public final List<ModelGif> getSearchResultsLoadingList() {
        return StoreGifPicker.access$getSearchResultsLoadingList$cp();
    }

    public final List<String> getSearchTermsLoadingList() {
        return StoreGifPicker.access$getSearchTermsLoadingList$cp();
    }

    public /* synthetic */ StoreGifPicker$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
