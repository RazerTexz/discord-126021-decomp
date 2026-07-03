package com.google.android.exoplayer2.upstream.cache;

import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.io.File;
import java.io.IOException;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2689h;
import p007b.p225i.p226a.p242c.p257e3.p258b0.C2694m;
import p007b.p225i.p226a.p242c.p257e3.p258b0.InterfaceC2693l;

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

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.cache.Cache$a */
    public interface InterfaceC10774a {
        /* JADX INFO: renamed from: b */
        void mo2818b(Cache cache, C2689h c2689h);

        /* JADX INFO: renamed from: c */
        void mo2819c(Cache cache, C2689h c2689h, C2689h c2689h2);

        /* JADX INFO: renamed from: d */
        void mo2820d(Cache cache, C2689h c2689h);
    }

    @WorkerThread
    /* JADX INFO: renamed from: a */
    File mo2826a(String str, long j, long j2) throws CacheException;

    /* JADX INFO: renamed from: b */
    InterfaceC2693l mo2827b(String str);

    @WorkerThread
    /* JADX INFO: renamed from: c */
    void mo2828c(String str, C2694m c2694m) throws CacheException;

    @WorkerThread
    /* JADX INFO: renamed from: d */
    void mo2829d(C2689h c2689h);

    @Nullable
    @WorkerThread
    /* JADX INFO: renamed from: e */
    C2689h mo2830e(String str, long j, long j2) throws CacheException;

    @WorkerThread
    /* JADX INFO: renamed from: f */
    C2689h mo2831f(String str, long j, long j2) throws InterruptedException, CacheException;

    @WorkerThread
    /* JADX INFO: renamed from: g */
    void mo2832g(File file, long j) throws CacheException;

    /* JADX INFO: renamed from: h */
    long mo2833h();

    /* JADX INFO: renamed from: i */
    void mo2834i(C2689h c2689h);
}
