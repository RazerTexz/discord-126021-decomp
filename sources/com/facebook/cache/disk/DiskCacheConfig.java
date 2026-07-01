package com.facebook.cache.disk;

import android.content.Context;
import b.c.a.a0.AnimatableValueParser;
import b.f.b.a.CacheErrorLogger;
import b.f.b.a.CacheEventListener;
import b.f.b.a.NoOpCacheErrorLogger;
import b.f.b.a.NoOpCacheEventListener;
import b.f.b.b.DefaultEntryEvictionComparatorSupplier;
import b.f.b.b.EntryEvictionComparatorSupplier;
import b.f.d.a.DiskTrimmableRegistry;
import b.f.d.a.NoOpDiskTrimmableRegistry;
import com.discord.api.permission.Permission;
import com.facebook.common.internal.Supplier;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheConfig {
    public final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f2882b;
    public final Supplier<File> c;
    public final long d;
    public final long e;
    public final long f;
    public final EntryEvictionComparatorSupplier g;
    public final CacheErrorLogger h;
    public final CacheEventListener i;
    public final DiskTrimmableRegistry j;
    public final Context k;

    public class a implements Supplier<File> {
        public a() {
        }

        @Override // com.facebook.common.internal.Supplier
        public File get() {
            Objects.requireNonNull(DiskCacheConfig.this.k);
            return DiskCacheConfig.this.k.getApplicationContext().getCacheDir();
        }
    }

    public static class b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Supplier<File> f2883b;
        public final Context e;
        public String a = "image_cache";
        public long c = 41943040;
        public EntryEvictionComparatorSupplier d = new DefaultEntryEvictionComparatorSupplier();

        public b(Context context, a aVar) {
            this.e = context;
        }
    }

    public DiskCacheConfig(b bVar) {
        NoOpCacheErrorLogger noOpCacheErrorLogger;
        NoOpCacheEventListener noOpCacheEventListener;
        NoOpDiskTrimmableRegistry noOpDiskTrimmableRegistry;
        Context context = bVar.e;
        this.k = context;
        AnimatableValueParser.C((bVar.f2883b == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (bVar.f2883b == null && context != null) {
            bVar.f2883b = new a();
        }
        this.a = 1;
        String str = bVar.a;
        Objects.requireNonNull(str);
        this.f2882b = str;
        Supplier<File> supplier = bVar.f2883b;
        Objects.requireNonNull(supplier);
        this.c = supplier;
        this.d = bVar.c;
        this.e = 10485760L;
        this.f = Permission.SPEAK;
        EntryEvictionComparatorSupplier entryEvictionComparatorSupplier = bVar.d;
        Objects.requireNonNull(entryEvictionComparatorSupplier);
        this.g = entryEvictionComparatorSupplier;
        synchronized (NoOpCacheErrorLogger.class) {
            if (NoOpCacheErrorLogger.a == null) {
                NoOpCacheErrorLogger.a = new NoOpCacheErrorLogger();
            }
            noOpCacheErrorLogger = NoOpCacheErrorLogger.a;
        }
        this.h = noOpCacheErrorLogger;
        synchronized (NoOpCacheEventListener.class) {
            if (NoOpCacheEventListener.a == null) {
                NoOpCacheEventListener.a = new NoOpCacheEventListener();
            }
            noOpCacheEventListener = NoOpCacheEventListener.a;
        }
        this.i = noOpCacheEventListener;
        synchronized (NoOpDiskTrimmableRegistry.class) {
            if (NoOpDiskTrimmableRegistry.a == null) {
                NoOpDiskTrimmableRegistry.a = new NoOpDiskTrimmableRegistry();
            }
            noOpDiskTrimmableRegistry = NoOpDiskTrimmableRegistry.a;
        }
        this.j = noOpDiskTrimmableRegistry;
    }
}
