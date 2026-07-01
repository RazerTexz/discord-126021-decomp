package b.f.j.c;

import com.facebook.common.memory.PooledByteBuffer;

/* JADX INFO: renamed from: b.f.j.c.p, reason: use source file name */
/* JADX INFO: compiled from: EncodedCountingMemoryCacheFactory.java */
/* JADX INFO: loaded from: classes.dex */
public final class EncodedCountingMemoryCacheFactory implements ValueDescriptor<PooledByteBuffer> {
    @Override // b.f.j.c.ValueDescriptor
    public int a(PooledByteBuffer pooledByteBuffer) {
        return pooledByteBuffer.size();
    }
}
