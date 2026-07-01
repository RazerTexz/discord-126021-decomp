package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import d0.g;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;

/* JADX INFO: compiled from: GifSearchViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifSearchViewModel$ViewState$Loaded extends GifSearchViewModel$ViewState {
    private final List<GifAdapterItem> adapterItems;

    /* JADX INFO: renamed from: gifCount$delegate, reason: from kotlin metadata */
    private final Lazy gifCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GifSearchViewModel$ViewState$Loaded(List<? extends GifAdapterItem> list) {
        super(null);
        m.checkNotNullParameter(list, "adapterItems");
        this.adapterItems = list;
        this.gifCount = g.lazy(new GifSearchViewModel$ViewState$Loaded$gifCount$2(this));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifSearchViewModel$ViewState$Loaded copy$default(GifSearchViewModel$ViewState$Loaded gifSearchViewModel$ViewState$Loaded, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifSearchViewModel$ViewState$Loaded.adapterItems;
        }
        return gifSearchViewModel$ViewState$Loaded.copy(list);
    }

    public final List<GifAdapterItem> component1() {
        return this.adapterItems;
    }

    public final GifSearchViewModel$ViewState$Loaded copy(List<? extends GifAdapterItem> adapterItems) {
        m.checkNotNullParameter(adapterItems, "adapterItems");
        return new GifSearchViewModel$ViewState$Loaded(adapterItems);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifSearchViewModel$ViewState$Loaded) && m.areEqual(this.adapterItems, ((GifSearchViewModel$ViewState$Loaded) other).adapterItems);
        }
        return true;
    }

    public final List<GifAdapterItem> getAdapterItems() {
        return this.adapterItems;
    }

    public final int getGifCount() {
        return ((Number) this.gifCount.getValue()).intValue();
    }

    public int hashCode() {
        List<GifAdapterItem> list = this.adapterItems;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("Loaded(adapterItems="), this.adapterItems, ")");
    }
}
