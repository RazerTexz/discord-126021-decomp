package b.f.j.l;

import b.c.a.a0.AnimatableValueParser;
import b.f.d.e.FLog;
import b.f.d.g.ByteArrayPool;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.d.g.PooledByteBufferFactory;
import b.f.d.g.PooledByteStreams;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.l.x, reason: use source file name */
/* JADX INFO: compiled from: PoolFactory.java */
/* JADX INFO: loaded from: classes3.dex */
public class PoolFactory {
    public final PoolConfig a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MemoryChunkPool f601b;
    public BitmapPool c;
    public MemoryChunkPool d;
    public MemoryChunkPool e;
    public PooledByteBufferFactory f;
    public PooledByteStreams g;
    public ByteArrayPool h;

    public PoolFactory(PoolConfig poolConfig) {
        this.a = poolConfig;
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public BitmapPool a() {
        if (this.c == null) {
            String str = this.a.i;
            byte b2 = -1;
            switch (str.hashCode()) {
                case -1868884870:
                    if (str.equals("legacy_default_params")) {
                        b2 = 3;
                    }
                    break;
                case -1106578487:
                    if (str.equals("legacy")) {
                        b2 = 4;
                    }
                    break;
                case -404562712:
                    if (str.equals("experimental")) {
                        b2 = 2;
                    }
                    break;
                case -402149703:
                    if (str.equals("dummy_with_tracking")) {
                        b2 = 1;
                    }
                    break;
                case 95945896:
                    if (str.equals("dummy")) {
                        b2 = 0;
                    }
                    break;
            }
            if (b2 == 0) {
                this.c = new DummyBitmapPool();
            } else if (b2 == 1) {
                this.c = new DummyTrackingInUseBitmapPool();
            } else if (b2 == 2) {
                Objects.requireNonNull(this.a);
                int i = this.a.j;
                NoOpPoolStatsTracker noOpPoolStatsTrackerH = NoOpPoolStatsTracker.h();
                Objects.requireNonNull(this.a);
                this.c = new LruBitmapPool(0, i, noOpPoolStatsTrackerH, null);
            } else if (b2 != 3) {
                PoolConfig poolConfig = this.a;
                this.c = new BucketsBitmapPool(poolConfig.d, poolConfig.a, poolConfig.f600b, false);
            } else {
                this.c = new BucketsBitmapPool(this.a.d, DefaultBitmapPoolParams.a(), this.a.f600b, false);
            }
        }
        return this.c;
    }

    public int b() {
        return this.a.c.d;
    }

    public PooledByteBufferFactory c(int i) {
        MemoryChunkPool memoryChunkPool;
        if (this.f == null) {
            if (i == 0) {
                if (this.e == null) {
                    try {
                        Constructor<?> constructor = Class.forName("com.facebook.imagepipeline.memory.NativeMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class);
                        PoolConfig poolConfig = this.a;
                        this.e = (MemoryChunkPool) constructor.newInstance(poolConfig.d, poolConfig.e, poolConfig.f);
                    } catch (ClassNotFoundException e) {
                        FLog.f("PoolFactory", "", e);
                        this.e = null;
                    } catch (IllegalAccessException e2) {
                        FLog.f("PoolFactory", "", e2);
                        this.e = null;
                    } catch (InstantiationException e3) {
                        FLog.f("PoolFactory", "", e3);
                        this.e = null;
                    } catch (NoSuchMethodException e4) {
                        FLog.f("PoolFactory", "", e4);
                        this.e = null;
                    } catch (InvocationTargetException e5) {
                        FLog.f("PoolFactory", "", e5);
                        this.e = null;
                    }
                }
                memoryChunkPool = this.e;
            } else if (i == 1) {
                if (this.d == null) {
                    try {
                        Constructor<?> constructor2 = Class.forName("com.facebook.imagepipeline.memory.BufferMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class);
                        PoolConfig poolConfig2 = this.a;
                        this.d = (MemoryChunkPool) constructor2.newInstance(poolConfig2.d, poolConfig2.e, poolConfig2.f);
                    } catch (ClassNotFoundException unused) {
                        this.d = null;
                    } catch (IllegalAccessException unused2) {
                        this.d = null;
                    } catch (InstantiationException unused3) {
                        this.d = null;
                    } catch (NoSuchMethodException unused4) {
                        this.d = null;
                    } catch (InvocationTargetException unused5) {
                        this.d = null;
                    }
                }
                memoryChunkPool = this.d;
            } else {
                if (i != 2) {
                    throw new IllegalArgumentException("Invalid MemoryChunkType");
                }
                if (this.f601b == null) {
                    try {
                        Constructor<?> constructor3 = Class.forName("com.facebook.imagepipeline.memory.AshmemMemoryChunkPool").getConstructor(MemoryTrimmableRegistry.class, PoolParams.class, PoolStatsTracker.class);
                        PoolConfig poolConfig3 = this.a;
                        this.f601b = (MemoryChunkPool) constructor3.newInstance(poolConfig3.d, poolConfig3.e, poolConfig3.f);
                    } catch (ClassNotFoundException unused6) {
                        this.f601b = null;
                    } catch (IllegalAccessException unused7) {
                        this.f601b = null;
                    } catch (InstantiationException unused8) {
                        this.f601b = null;
                    } catch (NoSuchMethodException unused9) {
                        this.f601b = null;
                    } catch (InvocationTargetException unused10) {
                        this.f601b = null;
                    }
                }
                memoryChunkPool = this.f601b;
            }
            AnimatableValueParser.y(memoryChunkPool, "failed to get pool for chunk type: " + i);
            this.f = new MemoryPooledByteBufferFactory(memoryChunkPool, d());
        }
        return this.f;
    }

    public PooledByteStreams d() {
        if (this.g == null) {
            this.g = new PooledByteStreams(e());
        }
        return this.g;
    }

    public ByteArrayPool e() {
        if (this.h == null) {
            PoolConfig poolConfig = this.a;
            this.h = new GenericByteArrayPool(poolConfig.d, poolConfig.g, poolConfig.h);
        }
        return this.h;
    }
}
