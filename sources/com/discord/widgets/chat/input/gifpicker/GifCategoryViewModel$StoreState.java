package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import com.discord.models.gifpicker.dto.ModelGif;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GifCategoryViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifCategoryViewModel$StoreState {
    private final List<ModelGif> gifs;

    public GifCategoryViewModel$StoreState(List<ModelGif> list) {
        m.checkNotNullParameter(list, "gifs");
        this.gifs = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifCategoryViewModel$StoreState copy$default(GifCategoryViewModel$StoreState gifCategoryViewModel$StoreState, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = gifCategoryViewModel$StoreState.gifs;
        }
        return gifCategoryViewModel$StoreState.copy(list);
    }

    public final List<ModelGif> component1() {
        return this.gifs;
    }

    public final GifCategoryViewModel$StoreState copy(List<ModelGif> gifs) {
        m.checkNotNullParameter(gifs, "gifs");
        return new GifCategoryViewModel$StoreState(gifs);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifCategoryViewModel$StoreState) && m.areEqual(this.gifs, ((GifCategoryViewModel$StoreState) other).gifs);
        }
        return true;
    }

    public final List<ModelGif> getGifs() {
        return this.gifs;
    }

    public int hashCode() {
        List<ModelGif> list = this.gifs;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("StoreState(gifs="), this.gifs, ")");
    }
}
