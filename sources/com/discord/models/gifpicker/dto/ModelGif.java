package com.discord.models.gifpicker.dto;

import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: ModelGif.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ModelGif {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final String gifImageUrl;
    private final int height;
    private final String tenorGifUrl;
    private final int width;

    /* JADX INFO: compiled from: ModelGif.kt */
    public static final class Companion {
        private Companion() {
        }

        public final ModelGif createFromGifDto(GifDto gifDto) {
            C12238m.checkNotNullParameter(gifDto, "gifDto");
            return new ModelGif(gifDto.getSrc(), gifDto.getUrl(), gifDto.getWidth(), gifDto.getHeight());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public ModelGif(String str, String str2, int i, int i2) {
        C12238m.checkNotNullParameter(str, "gifImageUrl");
        C12238m.checkNotNullParameter(str2, "tenorGifUrl");
        this.gifImageUrl = str;
        this.tenorGifUrl = str2;
        this.width = i;
        this.height = i2;
    }

    public static /* synthetic */ ModelGif copy$default(ModelGif modelGif, String str, String str2, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = modelGif.gifImageUrl;
        }
        if ((i3 & 2) != 0) {
            str2 = modelGif.tenorGifUrl;
        }
        if ((i3 & 4) != 0) {
            i = modelGif.width;
        }
        if ((i3 & 8) != 0) {
            i2 = modelGif.height;
        }
        return modelGif.copy(str, str2, i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getGifImageUrl() {
        return this.gifImageUrl;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTenorGifUrl() {
        return this.tenorGifUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final int getWidth() {
        return this.width;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final int getHeight() {
        return this.height;
    }

    public final ModelGif copy(String gifImageUrl, String tenorGifUrl, int width, int height) {
        C12238m.checkNotNullParameter(gifImageUrl, "gifImageUrl");
        C12238m.checkNotNullParameter(tenorGifUrl, "tenorGifUrl");
        return new ModelGif(gifImageUrl, tenorGifUrl, width, height);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ModelGif)) {
            return false;
        }
        ModelGif modelGif = (ModelGif) other;
        return C12238m.areEqual(this.gifImageUrl, modelGif.gifImageUrl) && C12238m.areEqual(this.tenorGifUrl, modelGif.tenorGifUrl) && this.width == modelGif.width && this.height == modelGif.height;
    }

    public final String getGifImageUrl() {
        return this.gifImageUrl;
    }

    public final int getHeight() {
        return this.height;
    }

    public final String getTenorGifUrl() {
        return this.tenorGifUrl;
    }

    public final int getWidth() {
        return this.width;
    }

    public int hashCode() {
        String str = this.gifImageUrl;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.tenorGifUrl;
        return ((((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + this.width) * 31) + this.height;
    }

    public String toString() {
        StringBuilder sbM833U = C1643a.m833U("ModelGif(gifImageUrl=");
        sbM833U.append(this.gifImageUrl);
        sbM833U.append(", tenorGifUrl=");
        sbM833U.append(this.tenorGifUrl);
        sbM833U.append(", width=");
        sbM833U.append(this.width);
        sbM833U.append(", height=");
        return C1643a.m814B(sbM833U, this.height, ")");
    }
}
