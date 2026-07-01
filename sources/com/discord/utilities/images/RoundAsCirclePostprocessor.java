package com.discord.utilities.images;

import android.graphics.Bitmap;
import b.f.j.o.a;
import d0.z.d.m;

/* JADX INFO: compiled from: RoundAsCirclePostProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundAsCirclePostprocessor extends a {
    private final String imageUri;

    public RoundAsCirclePostprocessor(String str) {
        m.checkNotNullParameter(str, "imageUri");
        this.imageUri = str;
    }

    @Override // b.f.j.o.a, b.f.j.q.a
    public void process(Bitmap bitmap) {
        int width = bitmap != null ? bitmap.getWidth() : 0;
        int height = bitmap != null ? bitmap.getHeight() : 0;
        if (width < 2 || height < 2) {
            return;
        }
        super.process(bitmap);
    }
}
