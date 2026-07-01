package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import com.discord.models.gifpicker.dto.ModelGif;
import com.discord.utilities.icon.IconUtils;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifAdapterItem$GifItem extends GifAdapterItem {
    private final ModelGif gif;
    private final String key;
    private final String query;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifAdapterItem$GifItem(ModelGif modelGif, String str) {
        super(GifAdapterItem$ViewType.VIEW_TYPE_GIF_ITEM, null);
        m.checkNotNullParameter(modelGif, IconUtils.ANIMATED_IMAGE_EXTENSION);
        this.gif = modelGif;
        this.query = str;
        this.key = String.valueOf(hashCode());
    }

    public static /* synthetic */ GifAdapterItem$GifItem copy$default(GifAdapterItem$GifItem gifAdapterItem$GifItem, ModelGif modelGif, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGif = gifAdapterItem$GifItem.gif;
        }
        if ((i & 2) != 0) {
            str = gifAdapterItem$GifItem.query;
        }
        return gifAdapterItem$GifItem.copy(modelGif, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGif getGif() {
        return this.gif;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getQuery() {
        return this.query;
    }

    public final GifAdapterItem$GifItem copy(ModelGif gif, String query) {
        m.checkNotNullParameter(gif, IconUtils.ANIMATED_IMAGE_EXTENSION);
        return new GifAdapterItem$GifItem(gif, query);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifAdapterItem$GifItem)) {
            return false;
        }
        GifAdapterItem$GifItem gifAdapterItem$GifItem = (GifAdapterItem$GifItem) other;
        return m.areEqual(this.gif, gifAdapterItem$GifItem.gif) && m.areEqual(this.query, gifAdapterItem$GifItem.query);
    }

    public final ModelGif getGif() {
        return this.gif;
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public final String getQuery() {
        return this.query;
    }

    public int hashCode() {
        ModelGif modelGif = this.gif;
        int iHashCode = (modelGif != null ? modelGif.hashCode() : 0) * 31;
        String str = this.query;
        return iHashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("GifItem(gif=");
        sbU.append(this.gif);
        sbU.append(", query=");
        return a.J(sbU, this.query, ")");
    }

    public /* synthetic */ GifAdapterItem$GifItem(ModelGif modelGif, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(modelGif, (i & 2) != 0 ? "" : str);
    }
}
