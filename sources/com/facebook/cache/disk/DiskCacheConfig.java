package com.facebook.cache.disk;

import android.content.Context;
import b.f.b.a.a;
import b.f.b.a.b;
import b.f.b.a.d;
import b.f.b.a.e;
import b.f.b.b.g;
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
    public final g g;
    public final a h;
    public final b i;
    public final b.f.d.a.a j;
    public final Context k;

    public DiskCacheConfig(DiskCacheConfig$b diskCacheConfig$b) {
        d dVar;
        e eVar;
        b.f.d.a.b bVar;
        Context context = diskCacheConfig$b.e;
        this.k = context;
        b.c.a.a0.d.C((diskCacheConfig$b.f2883b == null && context == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
        if (diskCacheConfig$b.f2883b == null && context != null) {
            diskCacheConfig$b.f2883b = new DiskCacheConfig$a(this);
        }
        this.a = 1;
        String str = diskCacheConfig$b.a;
        Objects.requireNonNull(str);
        this.f2882b = str;
        Supplier<File> supplier = diskCacheConfig$b.f2883b;
        Objects.requireNonNull(supplier);
        this.c = supplier;
        this.d = diskCacheConfig$b.c;
        this.e = 10485760L;
        this.f = Permission.SPEAK;
        g gVar = diskCacheConfig$b.d;
        Objects.requireNonNull(gVar);
        this.g = gVar;
        synchronized (d.class) {
            if (d.a == null) {
                d.a = new d();
            }
            dVar = d.a;
        }
        this.h = dVar;
        synchronized (e.class) {
            if (e.a == null) {
                e.a = new e();
            }
            eVar = e.a;
        }
        this.i = eVar;
        synchronized (b.f.d.a.b.class) {
            if (b.f.d.a.b.a == null) {
                b.f.d.a.b.a = new b.f.d.a.b();
            }
            bVar = b.f.d.a.b.a;
        }
        this.j = bVar;
    }
}
