package b.f.j.c;

import b.c.a.a0.AnimatableValueParser;
import b.f.a.FileBinaryResource;
import b.f.b.a.NoOpCacheEventListener;
import b.f.b.a.SimpleCacheKey;
import b.f.b.b.DiskStorageCache;
import b.f.b.b.FileCache;
import b.f.b.b.SettableCacheEvent;
import b.f.d.e.FLog;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteStreams;
import b.f.j.j.EncodedImage2;
import b.f.j.r.FrescoSystrace;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.memory.PooledByteBuffer;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import z.Task6;

/* JADX INFO: renamed from: b.f.j.c.f, reason: use source file name */
/* JADX INFO: compiled from: BufferedDiskCache.java */
/* JADX INFO: loaded from: classes.dex */
public class BufferedDiskCache2 {
    public final FileCache a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final PooledByteBufferFactory f555b;
    public final PooledByteStreams c;
    public final Executor d;
    public final Executor e;
    public final StagingArea f = new StagingArea();
    public final ImageCacheStatsTracker g;

    /* JADX INFO: renamed from: b.f.j.c.f$a */
    /* JADX INFO: compiled from: BufferedDiskCache.java */
    public class a implements Runnable {
        public final /* synthetic */ CacheKey j;
        public final /* synthetic */ EncodedImage2 k;

        public a(Object obj, CacheKey cacheKey, EncodedImage2 encodedImage2) {
            this.j = cacheKey;
            this.k = encodedImage2;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                BufferedDiskCache2.b(BufferedDiskCache2.this, this.j, this.k);
                BufferedDiskCache2.this.f.d(this.j, this.k);
                EncodedImage2 encodedImage2 = this.k;
                if (encodedImage2 != null) {
                    encodedImage2.close();
                }
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    BufferedDiskCache2.this.f.d(this.j, this.k);
                    EncodedImage2 encodedImage3 = this.k;
                    if (encodedImage3 != null) {
                        encodedImage3.close();
                    }
                    throw th2;
                }
            }
        }
    }

    public BufferedDiskCache2(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, PooledByteStreams pooledByteStreams, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.a = fileCache;
        this.f555b = pooledByteBufferFactory;
        this.c = pooledByteStreams;
        this.d = executor;
        this.e = executor2;
        this.g = imageCacheStatsTracker;
    }

    public static PooledByteBuffer a(BufferedDiskCache2 bufferedDiskCache2, CacheKey cacheKey) throws IOException {
        Objects.requireNonNull(bufferedDiskCache2);
        try {
            cacheKey.b();
            int i = FLog.a;
            FileBinaryResource fileBinaryResourceB = ((DiskStorageCache) bufferedDiskCache2.a).b(cacheKey);
            if (fileBinaryResourceB == null) {
                cacheKey.b();
                Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.g);
                return null;
            }
            cacheKey.b();
            Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.g);
            FileInputStream fileInputStream = new FileInputStream(fileBinaryResourceB.a);
            try {
                PooledByteBuffer pooledByteBufferD = bufferedDiskCache2.f555b.d(fileInputStream, (int) fileBinaryResourceB.a());
                fileInputStream.close();
                cacheKey.b();
                return pooledByteBufferD;
            } catch (Throwable th) {
                fileInputStream.close();
                throw th;
            }
        } catch (IOException e) {
            FLog.n(BufferedDiskCache2.class, e, "Exception reading from cache for %s", cacheKey.b());
            Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.g);
            throw e;
        }
    }

    public static void b(BufferedDiskCache2 bufferedDiskCache2, CacheKey cacheKey, EncodedImage2 encodedImage2) {
        Objects.requireNonNull(bufferedDiskCache2);
        cacheKey.b();
        int i = FLog.a;
        try {
            ((DiskStorageCache) bufferedDiskCache2.a).d(cacheKey, new BufferedDiskCache4(bufferedDiskCache2, encodedImage2));
            Objects.requireNonNull((NoOpImageCacheStatsTracker) bufferedDiskCache2.g);
            cacheKey.b();
        } catch (IOException e) {
            FLog.n(BufferedDiskCache2.class, e, "Failed to write to disk-cache for key %s", cacheKey.b());
        }
    }

    public void c(CacheKey cacheKey) {
        DiskStorageCache diskStorageCache = (DiskStorageCache) this.a;
        Objects.requireNonNull(diskStorageCache);
        try {
            synchronized (diskStorageCache.q) {
                List<String> listZ0 = AnimatableValueParser.z0(cacheKey);
                int i = 0;
                while (true) {
                    ArrayList arrayList = (ArrayList) listZ0;
                    if (i >= arrayList.size()) {
                        return;
                    }
                    String str = (String) arrayList.get(i);
                    if (diskStorageCache.k.c(str, cacheKey)) {
                        diskStorageCache.h.add(str);
                        return;
                    }
                    i++;
                }
            }
        } catch (IOException unused) {
            SettableCacheEvent settableCacheEventA = SettableCacheEvent.a();
            settableCacheEventA.d = cacheKey;
            Objects.requireNonNull((NoOpCacheEventListener) diskStorageCache.g);
            settableCacheEventA.b();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Task6<EncodedImage2> d(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        cacheKey.b();
        int i = FLog.a;
        Objects.requireNonNull((NoOpImageCacheStatsTracker) this.g);
        ExecutorService executorService = Task6.a;
        if (encodedImage2 instanceof Boolean) {
            return ((Boolean) encodedImage2).booleanValue() ? Task6.e : Task6.f;
        }
        Task6<EncodedImage2> task6 = new Task6<>();
        if (task6.h(encodedImage2)) {
            return task6;
        }
        throw new IllegalStateException("Cannot set the result of a completed task.");
    }

    public Task6<EncodedImage2> e(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        Task6<EncodedImage2> task6C;
        try {
            FrescoSystrace.b();
            EncodedImage2 encodedImage2A = this.f.a(cacheKey);
            if (encodedImage2A != null) {
                Task6<EncodedImage2> task6D = d(cacheKey, encodedImage2A);
                FrescoSystrace.b();
                return task6D;
            }
            try {
                task6C = Task6.a(new BufferedDiskCache(this, null, atomicBoolean, cacheKey), this.d);
            } catch (Exception e) {
                FLog.n(BufferedDiskCache2.class, e, "Failed to schedule disk-cache read for %s", ((SimpleCacheKey) cacheKey).a);
                task6C = Task6.c(e);
            }
            FrescoSystrace.b();
            return task6C;
        } catch (Throwable th) {
            FrescoSystrace.b();
            throw th;
        }
    }

    public void f(CacheKey cacheKey, EncodedImage2 encodedImage2) {
        try {
            FrescoSystrace.b();
            Objects.requireNonNull(cacheKey);
            AnimatableValueParser.i(Boolean.valueOf(EncodedImage2.u(encodedImage2)));
            this.f.b(cacheKey, encodedImage2);
            EncodedImage2 encodedImage2A = EncodedImage2.a(encodedImage2);
            try {
                this.e.execute(new a(null, cacheKey, encodedImage2A));
            } catch (Exception e) {
                FLog.n(BufferedDiskCache2.class, e, "Failed to schedule disk-cache write for %s", cacheKey.b());
                this.f.d(cacheKey, encodedImage2);
                if (encodedImage2A != null) {
                    encodedImage2A.close();
                }
            }
            FrescoSystrace.b();
        } catch (Throwable th) {
            FrescoSystrace.b();
            throw th;
        }
    }
}
