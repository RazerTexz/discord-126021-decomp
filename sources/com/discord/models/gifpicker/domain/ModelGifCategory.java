package com.discord.models.gifpicker.domain;

import java.io.Serializable;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelGifCategory.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGifCategory implements Serializable {
    private final String categoryName;
    private final String gifPreviewUrl;

    public ModelGifCategory(String str, String str2) {
        C12238m.checkNotNullParameter(str, "categoryName");
        C12238m.checkNotNullParameter(str2, "gifPreviewUrl");
        this.categoryName = str;
        this.gifPreviewUrl = str2;
    }

    public static /* synthetic */ ModelGifCategory copy$default(ModelGifCategory modelGifCategory, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = modelGifCategory.categoryName;
        }
        if ((i & 2) != 0) {
            str2 = modelGifCategory.gifPreviewUrl;
        }
        return modelGifCategory.copy(str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getCategoryName() {
        return this.categoryName;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getGifPreviewUrl() {
        return this.gifPreviewUrl;
    }

    public final ModelGifCategory copy(String categoryName, String gifPreviewUrl) {
        C12238m.checkNotNullParameter(categoryName, "categoryName");
        C12238m.checkNotNullParameter(gifPreviewUrl, "gifPreviewUrl");
        return new ModelGifCategory(categoryName, gifPreviewUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGifCategory)) {
            return false;
        }
        ModelGifCategory modelGifCategory = (ModelGifCategory) other;
        return C12238m.areEqual(this.categoryName, modelGifCategory.categoryName) && C12238m.areEqual(this.gifPreviewUrl, modelGifCategory.gifPreviewUrl);
    }

    public final String getCategoryName() {
        return this.categoryName;
    }

    public final String getGifPreviewUrl() {
        return this.gifPreviewUrl;
    }

    public int hashCode() {
        String str = this.categoryName;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.gifPreviewUrl;
        return iHashCode + (str2 != null ? str2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelGifCategory(categoryName=");
        sbM833U.append(this.categoryName);
        sbM833U.append(", gifPreviewUrl=");
        return C1643a.m822J(sbM833U, this.gifPreviewUrl, ")");
    }
}
