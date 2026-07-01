package com.facebook.imagepipeline.memory;

import b.f.d.d.DoNotStrip;
import b.f.d.g.MemoryTrimmableRegistry;
import b.f.j.l.BufferMemoryChunk;
import b.f.j.l.MemoryChunk;
import b.f.j.l.MemoryChunkPool;
import b.f.j.l.PoolParams;
import b.f.j.l.PoolStatsTracker;

/* JADX INFO: loaded from: classes3.dex */
@DoNotStrip
public class BufferMemoryChunkPool extends MemoryChunkPool {
    @DoNotStrip
    public BufferMemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
    }

    @Override // b.f.j.l.MemoryChunkPool, com.facebook.imagepipeline.memory.BasePool
    public MemoryChunk e(int i) {
        return new BufferMemoryChunk(i);
    }

    @Override // b.f.j.l.MemoryChunkPool
    /* JADX INFO: renamed from: s */
    public MemoryChunk e(int i) {
        return new BufferMemoryChunk(i);
    }
}
