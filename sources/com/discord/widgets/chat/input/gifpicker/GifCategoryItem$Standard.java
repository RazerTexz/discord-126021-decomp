package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import com.discord.models.gifpicker.domain.ModelGifCategory;
import d0.z.d.m;

/* JADX INFO: compiled from: GifCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifCategoryItem$Standard extends GifCategoryItem {
    private final ModelGifCategory gifCategory;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifCategoryItem$Standard(ModelGifCategory modelGifCategory) {
        super(null);
        m.checkNotNullParameter(modelGifCategory, "gifCategory");
        this.gifCategory = modelGifCategory;
    }

    public static /* synthetic */ GifCategoryItem$Standard copy$default(GifCategoryItem$Standard gifCategoryItem$Standard, ModelGifCategory modelGifCategory, int i, Object obj) {
        if ((i & 1) != 0) {
            modelGifCategory = gifCategoryItem$Standard.gifCategory;
        }
        return gifCategoryItem$Standard.copy(modelGifCategory);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelGifCategory getGifCategory() {
        return this.gifCategory;
    }

    public final GifCategoryItem$Standard copy(ModelGifCategory gifCategory) {
        m.checkNotNullParameter(gifCategory, "gifCategory");
        return new GifCategoryItem$Standard(gifCategory);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GifCategoryItem$Standard) && m.areEqual(this.gifCategory, ((GifCategoryItem$Standard) other).gifCategory);
        }
        return true;
    }

    public final ModelGifCategory getGifCategory() {
        return this.gifCategory;
    }

    public int hashCode() {
        ModelGifCategory modelGifCategory = this.gifCategory;
        if (modelGifCategory != null) {
            return modelGifCategory.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("Standard(gifCategory=");
        sbU.append(this.gifCategory);
        sbU.append(")");
        return sbU.toString();
    }
}
