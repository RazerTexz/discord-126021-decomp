package com.discord.utilities.images;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.d.Suppliers;
import b.f.d.e.FLog;
import b.f.g.a.a.Fresco;
import b.f.g.a.a.PipelineDraweeControllerBuilderSupplier;
import b.f.j.e.ImagePipeline;
import b.f.j.e.ImagePipeline2;
import b.f.j.e.ImagePipelineConfig2;
import b.f.j.e.ImagePipelineExperiments;
import b.f.j.e.ImagePipelineFactory;
import b.f.j.e.NativeCodeSetup;
import b.f.j.r.FrescoSystrace;
import b.f.m.n.NativeLoader;
import b.f.m.n.SystemDelegate;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import d0.z.d.Intrinsics3;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: MGImagesConfig.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesConfig {
    private static final String CACHE_DIR = "app_images_cache";
    private static final String CACHE_DIR_SMALL = "app_images_cache_small";
    public static final MGImagesConfig INSTANCE = new MGImagesConfig();
    private static final int MAX_BITMAP_MEM_CACHE_SIZE_RATIO = 3;
    private static final long MAX_DISK_CACHE_SIZE = 41943040;

    private MGImagesConfig() {
    }

    private final DefaultBitmapMemoryCacheParamsSupplier getAppBitmapMemoryCacheParamsSupplier(Context context) {
        Object systemService = context.getSystemService(ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.app.ActivityManager");
        final ActivityManager activityManager = (ActivityManager) systemService;
        return new DefaultBitmapMemoryCacheParamsSupplier(activityManager) { // from class: com.discord.utilities.images.MGImagesConfig.getAppBitmapMemoryCacheParamsSupplier.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier, com.facebook.common.internal.Supplier
            public MemoryCacheParams get() {
                MemoryCacheParams memoryCacheParams = super.get();
                int i = memoryCacheParams.a;
                return new MemoryCacheParams(i, memoryCacheParams.f2895b, memoryCacheParams.c, memoryCacheParams.d, i / 3, TimeUnit.MINUTES.toMillis(5L));
            }
        };
    }

    private final DiskCacheConfig newDiskCacheConfig(Context context, String str) {
        DiskCacheConfig.b bVar = new DiskCacheConfig.b(context, null);
        bVar.f2883b = new Suppliers(context.getCacheDir());
        bVar.a = str;
        bVar.c = MAX_DISK_CACHE_SIZE;
        DiskCacheConfig diskCacheConfig = new DiskCacheConfig(bVar);
        Intrinsics3.checkNotNullExpressionValue(diskCacheConfig, "DiskCacheConfig\n        …HE_SIZE)\n        .build()");
        return diskCacheConfig;
    }

    public final void init(Application context) {
        Intrinsics3.checkNotNullParameter(context, "context");
        ImagePipelineConfig2.a aVar = new ImagePipelineConfig2.a(context, null);
        aVar.c = true;
        aVar.d = newDiskCacheConfig(context, CACHE_DIR);
        aVar.e = newDiskCacheConfig(context, CACHE_DIR_SMALL);
        DefaultBitmapMemoryCacheParamsSupplier appBitmapMemoryCacheParamsSupplier = getAppBitmapMemoryCacheParamsSupplier(context);
        Objects.requireNonNull(appBitmapMemoryCacheParamsSupplier);
        aVar.a = appBitmapMemoryCacheParamsSupplier;
        ImagePipelineExperiments.b bVar = aVar.f;
        bVar.f576b = true;
        ImagePipelineConfig2.a aVar2 = bVar.a;
        Objects.requireNonNull(aVar2);
        ImagePipelineConfig2 imagePipelineConfig2 = new ImagePipelineConfig2(aVar2, null);
        FrescoSystrace.b();
        if (Fresco.f477b) {
            FLog.k(Fresco.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            Fresco.f477b = true;
        }
        NativeCodeSetup.a = true;
        if (!NativeLoader.b()) {
            FrescoSystrace.b();
            try {
                try {
                    try {
                        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, context);
                    } catch (ClassNotFoundException unused) {
                        NativeLoader.a(new SystemDelegate());
                    } catch (IllegalAccessException unused2) {
                        NativeLoader.a(new SystemDelegate());
                    }
                } catch (NoSuchMethodException unused3) {
                    NativeLoader.a(new SystemDelegate());
                } catch (InvocationTargetException unused4) {
                    NativeLoader.a(new SystemDelegate());
                }
                FrescoSystrace.b();
            } finally {
                FrescoSystrace.b();
            }
        }
        Context applicationContext = context.getApplicationContext();
        ImagePipelineFactory.j(imagePipelineConfig2);
        FrescoSystrace.b();
        PipelineDraweeControllerBuilderSupplier pipelineDraweeControllerBuilderSupplier = new PipelineDraweeControllerBuilderSupplier(applicationContext);
        Fresco.a = pipelineDraweeControllerBuilderSupplier;
        SimpleDraweeView.initialize(pipelineDraweeControllerBuilderSupplier);
        FrescoSystrace.b();
    }

    public final void onTrimMemory(int level) {
        if (level == 5 || level == 10 || level == 15 || level == 40 || level == 60 || level == 80) {
            ImagePipelineFactory imagePipelineFactory = ImagePipelineFactory.a;
            AnimatableValueParser.y(imagePipelineFactory, "ImagePipelineFactory was not initialized!");
            if (imagePipelineFactory.l == null) {
                imagePipelineFactory.l = imagePipelineFactory.a();
            }
            ImagePipeline2 imagePipeline2 = imagePipelineFactory.l;
            ImagePipeline imagePipeline = new ImagePipeline(imagePipeline2);
            imagePipeline2.e.d(imagePipeline);
            imagePipeline2.f.d(imagePipeline);
        }
    }
}
