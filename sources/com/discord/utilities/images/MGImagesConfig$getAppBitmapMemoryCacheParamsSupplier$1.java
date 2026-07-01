package com.discord.utilities.images;

import android.app.ActivityManager;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MGImagesConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1 extends DefaultBitmapMemoryCacheParamsSupplier {
    public final /* synthetic */ ActivityManager $activityManager;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1(ActivityManager activityManager, ActivityManager activityManager2) {
        super(activityManager2);
        this.$activityManager = activityManager;
    }

    @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
    public /* bridge */ /* synthetic */ MemoryCacheParams get() {
        return get();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
    public MemoryCacheParams get() {
        MemoryCacheParams memoryCacheParams = super.get();
        int i = memoryCacheParams.a;
        return new MemoryCacheParams(i, memoryCacheParams.f2895b, memoryCacheParams.c, memoryCacheParams.d, i / 3, TimeUnit.MINUTES.toMillis(5L));
    }
}
