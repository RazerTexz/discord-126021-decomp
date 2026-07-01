package b.f.j.l;

import android.util.SparseIntArray;
import b.f.d.g.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.BasePool;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.l.s, reason: use source file name */
/* JADX INFO: compiled from: MemoryChunkPool.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class MemoryChunkPool extends BasePool<MemoryChunk> {
    public final int[] k;

    public MemoryChunkPool(MemoryTrimmableRegistry memoryTrimmableRegistry, PoolParams poolParams, PoolStatsTracker poolStatsTracker) {
        super(memoryTrimmableRegistry, poolParams, poolStatsTracker);
        SparseIntArray sparseIntArray = poolParams.c;
        Objects.requireNonNull(sparseIntArray);
        this.k = new int[sparseIntArray.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.k;
            if (i >= iArr.length) {
                m();
                return;
            } else {
                iArr[i] = sparseIntArray.keyAt(i);
                i++;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void g(MemoryChunk memoryChunk) {
        memoryChunk.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int i(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int j(MemoryChunk memoryChunk) {
        return memoryChunk.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean o(MemoryChunk memoryChunk) {
        return !memoryChunk.isClosed();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public abstract MemoryChunk e(int i);
}
