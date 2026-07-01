package com.facebook.cache.disk;

import com.facebook.common.internal.Supplier;
import java.io.File;
import java.util.Objects;

/* JADX INFO: loaded from: classes.dex */
public class DiskCacheConfig$a implements Supplier<File> {
    public final /* synthetic */ DiskCacheConfig a;

    public DiskCacheConfig$a(DiskCacheConfig diskCacheConfig) {
        this.a = diskCacheConfig;
    }

    @Override // com.facebook.common.internal.Supplier
    public File get() {
        Objects.requireNonNull(this.a.k);
        return this.a.k.getApplicationContext().getCacheDir();
    }
}
