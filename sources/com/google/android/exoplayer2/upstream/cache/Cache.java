package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.c.e3.b0.CacheSpan;
import b.i.a.c.e3.b0.ContentMetadata2;
import b.i.a.c.e3.b0.ContentMetadataMutations;
import java.io.File;
import java.io.IOException;

/* JADX INFO: loaded from: classes3.dex */
public interface Cache {

    public static class CacheException extends IOException {
        public CacheException(String str) {
            super(str);
        }

        public CacheException(Throwable th) {
            super(th);
        }

        public CacheException(String str, Throwable th) {
            super(str, th);
        }
    }

    public interface a {
        void b(Cache cache, CacheSpan cacheSpan);

        void c(Cache cache, CacheSpan cacheSpan, CacheSpan cacheSpan2);

        void d(Cache cache, CacheSpan cacheSpan);
    }

    @WorkerThread
    File a(String str, long j, long j2) throws CacheException;

    ContentMetadata2 b(String str);

    @WorkerThread
    void c(String str, ContentMetadataMutations contentMetadataMutations) throws CacheException;

    @WorkerThread
    void d(CacheSpan cacheSpan);

    @Nullable
    @WorkerThread
    CacheSpan e(String str, long j, long j2) throws CacheException;

    @WorkerThread
    CacheSpan f(String str, long j, long j2) throws InterruptedException, CacheException;

    @WorkerThread
    void g(File file, long j) throws CacheException;

    long h();

    void i(CacheSpan cacheSpan);
}
