package com.facebook.imagepipeline.platform;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import p007b.p109f.p190m.InterfaceC2051d;

/* JADX INFO: loaded from: classes3.dex */
@InterfaceC2051d
public class PreverificationHelper {
    @InterfaceC2051d
    @TargetApi(26)
    public boolean shouldUseHardwareBitmapConfig(Bitmap.Config config) {
        return config == Bitmap.Config.HARDWARE;
    }
}
