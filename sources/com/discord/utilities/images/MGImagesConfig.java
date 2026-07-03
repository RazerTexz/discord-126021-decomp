package com.discord.utilities.images;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import androidx.appcompat.widget.ActivityChooserModel;
import com.facebook.cache.disk.DiskCacheConfig;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.cache.DefaultBitmapMemoryCacheParamsSupplier;
import com.facebook.imagepipeline.cache.MemoryCacheParams;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p119d.C1688k;
import p007b.p109f.p115d.p120e.C1691a;
import p007b.p109f.p132g.p133a.p134a.C1731b;
import p007b.p109f.p132g.p133a.p134a.C1734e;
import p007b.p109f.p161j.p170e.C1892g;
import p007b.p109f.p161j.p170e.C1893h;
import p007b.p109f.p161j.p170e.C1895j;
import p007b.p109f.p161j.p170e.C1897l;
import p007b.p109f.p161j.p170e.C1898m;
import p007b.p109f.p161j.p170e.C1899n;
import p007b.p109f.p161j.p183r.C2030b;
import p007b.p109f.p190m.p191n.C2061a;
import p007b.p109f.p190m.p191n.C2063c;
import p507d0.p592z.p594d.C12238m;

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
                int i = memoryCacheParams.f19542a;
                return new MemoryCacheParams(i, memoryCacheParams.f19543b, memoryCacheParams.f19544c, memoryCacheParams.f19545d, i / 3, TimeUnit.MINUTES.toMillis(5L));
            }
        };
    }

    private final DiskCacheConfig newDiskCacheConfig(Context context, String str) {
        DiskCacheConfig.C10634b c10634b = new DiskCacheConfig.C10634b(context, null);
        c10634b.f19434b = new C1688k(context.getCacheDir());
        c10634b.f19433a = str;
        c10634b.f19435c = MAX_DISK_CACHE_SIZE;
        DiskCacheConfig diskCacheConfig = new DiskCacheConfig(c10634b);
        C12238m.checkNotNullExpressionValue(diskCacheConfig, "DiskCacheConfig\n        …HE_SIZE)\n        .build()");
        return diskCacheConfig;
    }

    public final void init(Application context) {
        C12238m.checkNotNullParameter(context, "context");
        C1895j.a aVar = new C1895j.a(context, null);
        aVar.f3772c = true;
        aVar.f3773d = newDiskCacheConfig(context, CACHE_DIR);
        aVar.f3774e = newDiskCacheConfig(context, CACHE_DIR_SMALL);
        DefaultBitmapMemoryCacheParamsSupplier appBitmapMemoryCacheParamsSupplier = getAppBitmapMemoryCacheParamsSupplier(context);
        Objects.requireNonNull(appBitmapMemoryCacheParamsSupplier);
        aVar.f3770a = appBitmapMemoryCacheParamsSupplier;
        C1897l.b bVar = aVar.f3775f;
        bVar.f3786b = true;
        C1895j.a aVar2 = bVar.f3785a;
        Objects.requireNonNull(aVar2);
        C1895j c1895j = new C1895j(aVar2, null);
        C2030b.m1527b();
        if (C1731b.f3169b) {
            C1691a.m983k(C1731b.class, "Fresco has already been initialized! `Fresco.initialize(...)` should only be called 1 single time to avoid memory leaks!");
        } else {
            C1731b.f3169b = true;
        }
        C1899n.f3808a = true;
        if (!C2061a.m1588b()) {
            C2030b.m1527b();
            try {
                try {
                    try {
                        Class.forName("com.facebook.imagepipeline.nativecode.NativeCodeInitializer").getMethod("init", Context.class).invoke(null, context);
                    } catch (ClassNotFoundException unused) {
                        C2061a.m1587a(new C2063c());
                    } catch (IllegalAccessException unused2) {
                        C2061a.m1587a(new C2063c());
                    }
                } catch (NoSuchMethodException unused3) {
                    C2061a.m1587a(new C2063c());
                } catch (InvocationTargetException unused4) {
                    C2061a.m1587a(new C2063c());
                }
                C2030b.m1527b();
            } finally {
                C2030b.m1527b();
            }
        }
        Context applicationContext = context.getApplicationContext();
        C1898m.m1294j(c1895j);
        C2030b.m1527b();
        C1734e c1734e = new C1734e(applicationContext);
        C1731b.f3168a = c1734e;
        SimpleDraweeView.initialize(c1734e);
        C2030b.m1527b();
    }

    public final void onTrimMemory(int level) {
        if (level == 5 || level == 10 || level == 15 || level == 40 || level == 60 || level == 80) {
            C1898m c1898m = C1898m.f3788a;
            C1460d.m591y(c1898m, "ImagePipelineFactory was not initialized!");
            if (c1898m.f3799l == null) {
                c1898m.f3799l = c1898m.m1295a();
            }
            C1893h c1893h = c1898m.f3799l;
            C1892g c1892g = new C1892g(c1893h);
            c1893h.f3737e.mo1236d(c1892g);
            c1893h.f3738f.mo1236d(c1892g);
        }
    }
}
