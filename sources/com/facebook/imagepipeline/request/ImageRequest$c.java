package com.facebook.imagepipeline.request;

/* JADX INFO: loaded from: classes3.dex */
public enum ImageRequest$c {
    FULL_FETCH(1),
    DISK_CACHE(2),
    ENCODED_MEMORY_CACHE(3),
    BITMAP_MEMORY_CACHE(4);

    private int mValue;

    ImageRequest$c(int i) {
        this.mValue = i;
    }

    public static ImageRequest$c f(ImageRequest$c imageRequest$c, ImageRequest$c imageRequest$c2) {
        return imageRequest$c.mValue > imageRequest$c2.mValue ? imageRequest$c : imageRequest$c2;
    }

    public int g() {
        return this.mValue;
    }
}
