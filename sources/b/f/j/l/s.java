package b.f.j.l;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.BasePool$InvalidSizeException;
import java.util.Objects;

/* JADX INFO: compiled from: MemoryChunkPool.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class s extends BasePool<r> {
    public final int[] k;

    public s(b.f.d.g.c cVar, y yVar, z zVar) {
        super(cVar, yVar, zVar);
        SparseIntArray sparseIntArray = yVar.c;
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
    public /* bridge */ /* synthetic */ r e(int i) {
        return s(i);
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void g(r rVar) {
        rVar.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int i(int i) {
        if (i <= 0) {
            throw new BasePool$InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int j(r rVar) {
        return rVar.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public boolean o(r rVar) {
        return !rVar.isClosed();
    }

    public abstract r s(int i);
}
