package com.facebook.cache.disk;

import android.content.Context;
import b.f.b.b.b;
import b.f.b.b.g;
import com.facebook.common.internal.Supplier;
import java.io.File;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheConfig$b {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Supplier<File> f2883b;
    public final Context e;
    public String a = "image_cache";
    public long c = 41943040;
    public g d = new b();

    public DiskCacheConfig$b(Context context, DiskCacheConfig$a diskCacheConfig$a) {
        this.e = context;
    }
}
