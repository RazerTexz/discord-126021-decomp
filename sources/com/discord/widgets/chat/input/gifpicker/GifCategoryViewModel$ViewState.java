package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import d0.g;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifCategoryViewModel$ViewState {

    /* JADX INFO: renamed from: gifCount$delegate, reason: from kotlin metadata */
    private final Lazy gifCount;
    private final List<GifAdapterItem$GifItem> gifItems;

    public GifCategoryViewModel$ViewState(List<GifAdapterItem$GifItem> list) {
        m.checkNotNullParameter(list, "gifItems");
        this.gifItems = list;
        this.gifCount = g.lazy(new GifCategoryViewModel$ViewState$gifCount$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifCategoryViewModel$ViewState copy$default(GifCategoryViewModel$ViewState gifCategoryViewModel$ViewState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifCategoryViewModel$ViewState.gifItems;
        }
        return gifCategoryViewModel$ViewState.copy(list);
    }

    public static /* synthetic */ void getGifCount$annotations() {
    }

    public final List<GifAdapterItem$GifItem> component1() {
        return this.gifItems;
    }

    public final GifCategoryViewModel$ViewState copy(List<GifAdapterItem$GifItem> gifItems) {
        m.checkNotNullParameter(gifItems, "gifItems");
        return new GifCategoryViewModel$ViewState(gifItems);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifCategoryViewModel$ViewState) && m.areEqual(this.gifItems, ((GifCategoryViewModel$ViewState) other).gifItems);
        }
        return true;
    }

    public final int getGifCount() {
        return ((Number) this.gifCount.getValue()).intValue();
    }

    public final List<GifAdapterItem$GifItem> getGifItems() {
        return this.gifItems;
    }

    public int hashCode() {
        List<GifAdapterItem$GifItem> list = this.gifItems;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("ViewState(gifItems="), this.gifItems, ")");
    }
}
