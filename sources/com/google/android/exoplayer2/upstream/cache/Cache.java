package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.c.e3.b0.h;
import b.i.a.c.e3.b0.l;
import b.i.a.c.e3.b0.m;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
public interface Cache {
    @WorkerThread
    File a(String str, long j, long j2) throws Cache$CacheException;

    l b(String str);

    @WorkerThread
    void c(String str, m mVar) throws Cache$CacheException;

    @WorkerThread
    void d(h hVar);

    @Nullable
    @WorkerThread
    h e(String str, long j, long j2) throws Cache$CacheException;

    @WorkerThread
    h f(String str, long j, long j2) throws InterruptedException, Cache$CacheException;

    @WorkerThread
    void g(File file, long j) throws Cache$CacheException;

    long h();

    void i(h hVar);
}
