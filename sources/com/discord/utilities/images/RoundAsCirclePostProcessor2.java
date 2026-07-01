package com.discord.utilities.images;

import android.graphics.Bitmap;
import b.f.j.o.RoundAsCirclePostprocessor2;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.utilities.images.RoundAsCirclePostprocessor, reason: use source file name */
/* JADX INFO: compiled from: RoundAsCirclePostProcessor.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RoundAsCirclePostProcessor2 extends RoundAsCirclePostprocessor2 {
    private final String imageUri;

    public RoundAsCirclePostProcessor2(String str) {
        Intrinsics3.checkNotNullParameter(str, "imageUri");
        this.imageUri = str;
    }

    @Override // b.f.j.o.RoundAsCirclePostprocessor2, b.f.j.q.BasePostprocessor
    public void process(Bitmap bitmap) {
        int width = bitmap != null ? bitmap.getWidth() : 0;
        int height = bitmap != null ? bitmap.getHeight() : 0;
        if (width < 2 || height < 2) {
            return;
        }
        super.process(bitmap);
    }
}
