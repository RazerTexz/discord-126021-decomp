package com.discord.utilities.images;

import android.graphics.Bitmap;
import p007b.p109f.p161j.p180o.C1961a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RoundAsCirclePostProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundAsCirclePostprocessor extends C1961a {
    private final String imageUri;

    public RoundAsCirclePostprocessor(String str) {
        C12238m.checkNotNullParameter(str, "imageUri");
        this.imageUri = str;
    }

    @Override // p007b.p109f.p161j.p180o.C1961a, p007b.p109f.p161j.p182q.AbstractC2025a
    public void process(Bitmap bitmap) {
        int width = bitmap != null ? bitmap.getWidth() : 0;
        int height = bitmap != null ? bitmap.getHeight() : 0;
        if (width < 2 || height < 2) {
            return;
        }
        super.process(bitmap);
    }
}
