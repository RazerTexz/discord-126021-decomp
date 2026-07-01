package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap$Config;
import b.f.m.d;

/* JADX INFO: loaded from: classes3.dex */
@d
public class PreverificationHelper {
    @d
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Bitmap$Config bitmap$Config) {
        return bitmap$Config == Bitmap$Config.HARDWARE;
    }
}
