package com.discord.widgets.chat.input.gifpicker;

import com.discord.models.gifpicker.domain.ModelGifCategory;
import com.discord.utilities.recycler.DiffKeyProvider;
import java.io.Serializable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: GifCategoryItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GifCategoryItem implements DiffKeyProvider, Serializable {
    private final String key;

    /* JADX INFO: compiled from: GifCategoryItem.kt */
    public static final /* data */ class Standard extends GifCategoryItem {
        private final ModelGifCategory gifCategory;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Standard(ModelGifCategory modelGifCategory) {
            super(null);
            C12238m.checkNotNullParameter(modelGifCategory, "gifCategory");
            this.gifCategory = modelGifCategory;
        }

        public static /* synthetic */ Standard copy$default(Standard standard, ModelGifCategory modelGifCategory, int i, Object obj) {
            if ((i & 1) != 0) {
                modelGifCategory = standard.gifCategory;
            }
            return standard.copy(modelGifCategory);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final ModelGifCategory getGifCategory() {
            return this.gifCategory;
        }

        public final Standard copy(ModelGifCategory gifCategory) {
            C12238m.checkNotNullParameter(gifCategory, "gifCategory");
            return new Standard(gifCategory);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Standard) && C12238m.areEqual(this.gifCategory, ((Standard) other).gifCategory);
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
            StringBuilder sbM833U = C1643a.m833U("Standard(gifCategory=");
            sbM833U.append(this.gifCategory);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GifCategoryItem.kt */
    public static final /* data */ class Trending extends GifCategoryItem {
        private final String gifPreviewUrl;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Trending(String str) {
            super(null);
            C12238m.checkNotNullParameter(str, "gifPreviewUrl");
            this.gifPreviewUrl = str;
        }

        public static /* synthetic */ Trending copy$default(Trending trending, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = trending.gifPreviewUrl;
            }
            return trending.copy(str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getGifPreviewUrl() {
            return this.gifPreviewUrl;
        }

        public final Trending copy(String gifPreviewUrl) {
            C12238m.checkNotNullParameter(gifPreviewUrl, "gifPreviewUrl");
            return new Trending(gifPreviewUrl);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof Trending) && C12238m.areEqual(this.gifPreviewUrl, ((Trending) other).gifPreviewUrl);
            }
            return true;
        }

        public final String getGifPreviewUrl() {
            return this.gifPreviewUrl;
        }

        public int hashCode() {
            String str = this.gifPreviewUrl;
            if (str != null) {
                return str.hashCode();
            }
            return 0;
        }

        public String toString() {
            return C1643a.m822J(C1643a.m833U("Trending(gifPreviewUrl="), this.gifPreviewUrl, ")");
        }
    }

    private GifCategoryItem() {
        this.key = String.valueOf(hashCode());
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    public /* synthetic */ GifCategoryItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
