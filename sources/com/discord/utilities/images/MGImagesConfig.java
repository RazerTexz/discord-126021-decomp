package com.discord.utilities.images;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import b.c.a.a0.d;
import b.f.d.d.k;
import b.f.d.e.a;
import b.f.g.a.a.e;
import b.f.j.e.g;
import b.f.j.e.h;
import b.f.j.e.j;
import b.f.j.e.j$a;
import b.f.j.e.l$b;
import b.f.j.e.n;
import b.f.j.r.b;
import b.f.m.n.c;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.cache.disk.DiskCacheConfig$b;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import d0.z.d.m;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

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
        ActivityManager activityManager = (ActivityManager) systemService;
        return new MGImagesConfig$getAppBitmapMemoryCacheParamsSupplier$1(activityManager, activityManager);
    }

    private final DiskCacheConfig newDiskCacheConfig(Context context, String str) {
        DiskCacheConfig$b diskCacheConfig$b = new DiskCacheConfig$b(context, null);
        diskCacheConfig$b.f2883b = new k(context.getCacheDir());
        diskCacheConfig$b.a = str;
        diskCacheConfig$b.c = MAX_DISK_CACHE_SIZE;
        DiskCacheConfig diskCacheConfig = new DiskCacheConfig(diskCacheConfig$b);
        m.checkNotNullExpressionValue(diskCacheConfig, "DiskCacheConfig\n        …HE_SIZE)\n        .build()");
        return diskCacheConfig;
    }

    public final void init(Application context) {
        m.checkNotNullParameter(context, "context");
        j$a j_a = new j$a(context, null);
        j_a.c = true;
        j_a.d = newDiskCacheConfig(context, CACHE_DIR);
        j_a.e = newDiskCacheConfig(context, CACHE_DIR_SMALL);
        DefaultBitmapMemoryCacheParamsSupplier appBitmapMemoryCacheParamsSupplier = getAppBitmapMemoryCacheParamsSupplier(context);
        Objects.requireNonNull(appBitmapMemoryCacheParamsSupplier);
        j_a.a = appBitmapMemoryCacheParamsSupplier;
        l$b l_b = j_a.f;
        l_b.f576b = true;
        j$a j_a2 = l_b.a;
        Objects.requireNonNull(j_a2);
        j jVar = new j(j_a2, null);
        b.b();
        if (b.f.g.a.a.b.f477b) {
            a.k(b.f.g.a.a.b.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            b.f.g.a.a.b.f477b = true;
        }
        n.a = true;
        if (!b.f.m.n.a.b()) {
            b.b();
            try {
                try {
                    try {
                        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, context);
                    } catch (ClassNotFoundException unused) {
                        b.f.m.n.a.a(new c());
                    } catch (IllegalAccessException unused2) {
                        b.f.m.n.a.a(new c());
                    }
                } catch (NoSuchMethodException unused3) {
                    b.f.m.n.a.a(new c());
                } catch (InvocationTargetException unused4) {
                    b.f.m.n.a.a(new c());
                }
                b.b();
            } finally {
                b.b();
            }
        }
        Context applicationContext = context.getApplicationContext();
        b.f.j.e.m.j(jVar);
        b.b();
        e eVar = new e(applicationContext);
        b.f.g.a.a.b.a = eVar;
        SimpleDraweeView.initialize(eVar);
        b.b();
    }

    public final void onTrimMemory(int level) {
        if (level == 5 || level == 10 || level == 15 || level == 40 || level == 60 || level == 80) {
            b.f.j.e.m mVar = b.f.j.e.m.a;
            d.y(mVar, "ImagePipelineFactory was not initialized!");
            if (mVar.l == null) {
                mVar.l = mVar.a();
            }
            h hVar = mVar.l;
            g gVar = new g(hVar);
            hVar.e.d(gVar);
            hVar.f.d(gVar);
        }
    }
}
